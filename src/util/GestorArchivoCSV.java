package util;

import modelo.*;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class GestorArchivoCSV implements IRepositorioContenido {

    private static final String NOMBRE_ARCHIVO = "contenidos.csv";
    private static final String SEPARADOR = "|"; 

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
            System.err.println(">> REPOSITORIO CSV ERROR: Archivo no encontrado o error de lectura. Inicializará con datos dummy.");
            return new ArrayList<>(); 
        } catch (Exception e) {
             System.err.println(">> REPOSITORIO CSV ERROR: Error al parsear una línea: " + e.getMessage());
             return new ArrayList<>();
        }
    }
    
    private ContenidoAudiovisual parsearLinea(String linea) {
        String[] partes = linea.split("\\" + SEPARADOR);
        
        // El CSV tiene: TIPO|ID|TITULO|DURACION|GENERO|DETALLES... 
        if (partes.length < 5) return null; 

        String tipo = partes[0];
        String titulo = partes[2];
        int duracion = Integer.parseInt(partes[3].trim());
        String genero = partes[4];

        try {
            switch (tipo) {
                case "PELICULA":
                    String estudioP = partes[5];
                    Actor actorP = new Actor(partes[6], "Protagonista"); 
                    return new Pelicula(titulo, duracion, genero, estudioP, actorP);

                case "SERIE":
                    SerieDeTV serie = new SerieDeTV(titulo, duracion, genero);
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
                    return new Documental(titulo, duracion, genero, temaD, invD);
                    
                case "VIDEO":
                    String artistaV = partes[5];
                    String albumV = partes[6];
                    Actor actorV = new Actor(partes[7], "Invitado"); 
                    return new VideoMusical(titulo, duracion, genero, artistaV, albumV, actorV);
                    
                case "ANUNCIO":
                    String marcaA = partes[5];
                    String agenciaA = partes[6];
                    Actor actorA = new Actor(partes[7], "Protagonista"); 
                    return new AnuncioPublicitario(titulo, duracion, genero, marcaA, agenciaA, actorA);

                default:
                    System.err.println("Tipo de contenido desconocido: " + tipo);
                    return null;
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Error de formato o campos incompletos en la línea: " + linea);
            return null;
        }
    }
    
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
    
    private String formatearACSV(ContenidoAudiovisual c) {
        // En la escritura, el ID sí es necesario para mantener la consistencia en el archivo.
        String base = c.getId() + SEPARADOR + c.getTitulo() + SEPARADOR + c.getDuracionEnMinutos() + SEPARADOR + c.getGenero();
        
        if (c instanceof Pelicula) {
            Pelicula p = (Pelicula) c;
            return "PELICULA" + SEPARADOR + base + SEPARADOR + p.getEstudio() + SEPARADOR + p.getActorPrincipal().getNombre();
            
        } else if (c instanceof SerieDeTV) {
            SerieDeTV s = (SerieDeTV) c;
            StringBuilder temporadasCSV = new StringBuilder();
            for (Temporada t : s.getTemporadas()) {
                temporadasCSV.append("T").append(t.getNumeroTemporada()).append(":E").append(t.getNumeroEpisodios()).append(";");
            }
            String tempString = temporadasCSV.length() > 0 ? temporadasCSV.substring(0, temporadasCSV.length() - 1) : "";
            return "SERIE" + SEPARADOR + base + SEPARADOR + tempString;

        } else if (c instanceof Documental) {
            Documental d = (Documental) c;
            String nombreInvestigador = (d.getInvestigadorPrincipal() != null) ? d.getInvestigadorPrincipal().getNombre() : "N/A";
            return "DOCUMENTAL" + SEPARADOR + base + SEPARADOR + d.getTema() + SEPARADOR + nombreInvestigador;
            
        } else if (c instanceof VideoMusical) {
            VideoMusical v = (VideoMusical) c;
            String nombreActor = (v.getActorInvitado() != null) ? v.getActorInvitado().getNombre() : "N/A";
            return "VIDEO" + SEPARADOR + base + SEPARADOR + v.getArtista() + SEPARADOR + v.getAlbum() + SEPARADOR + nombreActor;
            
        } else if (c instanceof AnuncioPublicitario) {
            AnuncioPublicitario a = (AnuncioPublicitario) c;
            String nombreProtagonista = (a.getProtagonista() != null) ? a.getProtagonista().getNombre() : "N/A";
            return "ANUNCIO" + SEPARADOR + base + SEPARADOR + a.getMarca() + SEPARADOR + a.getAgencia() + SEPARADOR + nombreProtagonista;
        }
        
        return "DESCONOCIDO" + SEPARADOR + base;
    }
}