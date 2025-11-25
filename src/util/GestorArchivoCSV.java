package util;

import modelo.*;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

// Implementación concreta de la interfaz IRepositorioContenido.
// Gestiona la persistencia de los objetos ContenidoAudiovisual en un archivo CSV.
public class GestorArchivoCSV implements IRepositorioContenido {

    private static final String NOMBRE_ARCHIVO = "contenidos.csv";
    private static final String SEPARADOR = "|"; 

    // --- CARGA DE CONTENIDOS ---

    @Override
    public List<ContenidoAudiovisual> cargarContenidos() {
        List<ContenidoAudiovisual> contenidosCargados = new ArrayList<>();
        System.out.println(">> REPOSITORIO CSV: Iniciando carga desde " + NOMBRE_ARCHIVO + "...");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            
            String linea;
            reader.readLine(); // Saltar el encabezado
            
            while ((linea = reader.readLine()) != null) {
                ContenidoAudiovisual contenido = parsearLinea(linea);
                if (contenido != null) {
                    contenidosCargados.add(contenido);
                }
            }
            
            System.out.println(">> REPOSITORIO CSV: " + contenidosCargados.size() + " contenidos leídos exitosamente.");
            return contenidosCargados;
            
        } catch (IOException e) {
            System.err.println(">> REPOSITORIO CSV ERROR: Archivo no encontrado o error de lectura. Inicializará con datos de prueba.");
            return new ArrayList<>(); 
        } catch (Exception e) {
             System.err.println(">> REPOSITORIO CSV ERROR: Error al parsear una línea: " + e.getMessage());
             return new ArrayList<>();
        }
    }
    
    // Procesa una línea del CSV y crea el objeto ContenidoAudiovisual correspondiente.
    private ContenidoAudiovisual parsearLinea(String linea) {
        String[] partes = linea.split("\\" + SEPARADOR);
        
        // Estructura esperada: TIPO|ID|TITULO|DURACION|GENERO|DETALLES... 
        if (partes.length < 5) return null; 
        
        String tipo = partes[0];
        int id = 0;
        try {
            // CRÍTICO: Leer el ID de la segunda columna (índice 1).
            id = Integer.parseInt(partes[1].trim()); 
        } catch (NumberFormatException e) {
            System.err.println("Error al parsear ID: " + partes[1] + ". Usando ID 0.");
            return null;
        }
        
        // El resto de campos se leen a partir del índice 2.
        String titulo = partes[2];
        int duracion = Integer.parseInt(partes[3].trim());
        String genero = partes[4];
        
        try {
            switch (tipo) {
                case "PELICULA":
                    String estudioP = partes[5];
                    Actor actorP = new Actor(partes[6], "Protagonista"); 
                    // Usar constructor CON ID
                    return new Pelicula(id, titulo, duracion, genero, estudioP, actorP);

                case "SERIE":
                    // Usar constructor CON ID
                    SerieDeTV serie = new SerieDeTV(id, titulo, duracion, genero);
                    String[] temporadasData = partes[5].split(";");
                    for (String tData : temporadasData) {
                        if (!tData.isEmpty()) {
                            int num = Integer.parseInt(tData.substring(1, tData.indexOf(":E")));
                            int eps = Integer.parseInt(tData.substring(tData.indexOf(":E") + 2));
                            serie.agregarTemporada(new Temporada(num, eps)); 
                        }
                    }
                    return serie;

                case "DOCUMENTAL":
                    String temaD = partes[5];
                    Investigador invD = new Investigador(partes[6], "Especialista"); 
                    // Usar constructor CON ID
                    return new Documental(id, titulo, duracion, genero, temaD, invD);
                    
                case "VIDEO":
                    String artistaV = partes[5];
                    String albumV = partes[6];
                    Actor actorV = new Actor(partes[7], "Invitado"); 
                    // Usar constructor CON ID
                    return new VideoMusical(id, titulo, duracion, genero, artistaV, albumV, actorV);
                    
                case "ANUNCIO":
                    String marcaA = partes[5];
                    String agenciaA = partes[6];
                    Actor actorA = new Actor(partes[7], "Protagonista"); 
                    // Usar constructor CON ID
                    return new AnuncioPublicitario(id, titulo, duracion, genero, marcaA, agenciaA, actorA);

                default:
                    System.err.println("Tipo de contenido desconocido: " + tipo);
                    return null;
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Error de formato o campos incompletos en la línea: " + linea);
            return null;
        }
    }
    
    // --- GUARDADO DE CONTENIDOS ---

    @Override
    public boolean guardarContenidos(List<ContenidoAudiovisual> contenidos) {
        System.out.println(">> REPOSITORIO CSV: Guardando " + contenidos.size() + " contenidos a " + NOMBRE_ARCHIVO + "...");
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(NOMBRE_ARCHIVO))) {
            
            writer.println("TIPO|ID|TITULO|DURACION|GENERO|DETALLES_ESPECIFICOS...");

            for (ContenidoAudiovisual contenido : contenidos) {
                String lineaCSV = formatearACSV(contenido);
                writer.println(lineaCSV);
            }

            System.out.println(">> REPOSITORIO CSV: Guardado exitoso.");
            return true;
        } catch (IOException e) {
            System.err.println(">> REPOSITORIO CSV ERROR: No se pudo escribir al archivo: " + e.getMessage());
            return false;
        }
    }
    
    // Convierte un objeto ContenidoAudiovisual a una línea de texto CSV.
    private String formatearACSV(ContenidoAudiovisual c) {
        // Campos comunes después del ID: TITULO | DURACION | GENERO
        String camposComunes = c.getTitulo() + SEPARADOR + c.getDuracionEnMinutos() + SEPARADOR + c.getGenero();
        
        // PREFIJO: TIPO | ID | TITULO | DURACION | GENERO
        // El ID debe ir primero, seguido de los campos comunes.
        String prefijo = c.getId() + SEPARADOR + camposComunes;
        
        if (c instanceof Pelicula) {
            Pelicula p = (Pelicula) c;
            return "PELICULA" + SEPARADOR + prefijo + SEPARADOR + p.getEstudio() + SEPARADOR + p.getActorPrincipal().getNombre();
            
        } else if (c instanceof SerieDeTV) {
            SerieDeTV s = (SerieDeTV) c;
            StringBuilder temporadasCSV = new StringBuilder();
            for (Temporada t : s.getTemporadas()) {
                temporadasCSV.append("T").append(t.getNumeroTemporada()).append(":E").append(t.getNumeroEpisodios()).append(";");
            }
            String tempString = temporadasCSV.length() > 0 ? temporadasCSV.substring(0, temporadasCSV.length() - 1) : "";
            return "SERIE" + SEPARADOR + prefijo + SEPARADOR + tempString;

        } else if (c instanceof Documental) {
            Documental d = (Documental) c;
            String nombreInvestigador = (d.getInvestigadorPrincipal() != null) ? d.getInvestigadorPrincipal().getNombre() : "N/A";
            return "DOCUMENTAL" + SEPARADOR + prefijo + SEPARADOR + d.getTema() + SEPARADOR + nombreInvestigador;
            
        } else if (c instanceof VideoMusical) {
            VideoMusical v = (VideoMusical) c;
            String nombreActor = (v.getActorInvitado() != null) ? v.getActorInvitado().getNombre() : "N/A";
            return "VIDEO" + SEPARADOR + prefijo + SEPARADOR + v.getArtista() + SEPARADOR + v.getAlbum() + SEPARADOR + nombreActor;
            
        } else if (c instanceof AnuncioPublicitario) {
            AnuncioPublicitario a = (AnuncioPublicitario) c;
            String nombreProtagonista = (a.getProtagonista() != null) ? a.getProtagonista().getNombre() : "N/A";
            return "ANUNCIO" + SEPARADOR + prefijo + SEPARADOR + a.getMarca() + SEPARADOR + a.getAgencia() + SEPARADOR + nombreProtagonista;
        }
        
        return "DESCONOCIDO" + SEPARADOR + prefijo;
    }
}