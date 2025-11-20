package modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorContenido {

    private List<ContenidoAudiovisual> contenidos;
    // Dependencia de la abstracción (DIP)
    private IRepositorioContenido repositorio; 

    // Constructor que recibe la dependencia del repositorio (Inyección de Dependencia)
    public GestorContenido(IRepositorioContenido repositorio) {
        this.repositorio = repositorio;
        this.contenidos = new ArrayList<>();
        
        // Intenta cargar contenidos del repositorio al iniciar
        cargarContenidosIniciales();
    }
    
    // Carga inicial: intenta usar el repositorio. Si falla o no hay datos, usa datos dummy.
    private void cargarContenidosIniciales() {
        // La implementación real del repositorio (GestorArchivoCSV) devolverá la lista leída.
        this.contenidos = repositorio.cargarContenidos();
        
        // Si no se pudo cargar nada o la lista está vacía, inicializa con datos de prueba.
        if (this.contenidos == null || this.contenidos.isEmpty()) {
            System.out.println(">> GESTOR: Repositorio vacío. Inicializando con datos de prueba.");
            inicializarDatosDummy();
        } else {
            System.out.println(">> GESTOR: " + this.contenidos.size() + " contenidos cargados del repositorio.");
        }
    }

    
    // MÉTODOS DE MANIPULACIÓN Y CONSULTA DE LA LISTA (Usados por el Controlador y Tests)

    // Retorna una lista de todos los contenidos en el catálogo.
    public List<ContenidoAudiovisual> obtenerTodosLosContenidos() {
        return contenidos;
    }

    // Retorna el ID que debe asignarse al siguiente contenido disponible.
    public int getSiguienteIdDisponible() {
        int maxId = 0;
        for (ContenidoAudiovisual c : contenidos) {
            if (c.getId() > maxId) {
                maxId = c.getId();
            }
        }
        return maxId + 1;
    }
    
    // Agrega un nuevo contenido al catálogo.
    public boolean agregarContenido(ContenidoAudiovisual contenido) {
        if (contenido != null) {
            // Asigna el ID usando el setter de ContenidoAudiovisual
            contenido.setId(getSiguienteIdDisponible()); 
            this.contenidos.add(contenido);
            return true;
        }
        return false;
    }

    // Busca un contenido por su ID.
    public ContenidoAudiovisual buscarContenidoPorId(int id) {
        for (ContenidoAudiovisual c : contenidos) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    // Busca contenidos por título (búsqueda parcial e insensible a mayúsculas).
    public List<ContenidoAudiovisual> buscarContenido(String tituloBusqueda) {
        List<ContenidoAudiovisual> resultados = new ArrayList<>();
        // Normaliza la búsqueda
        String busquedaNormalizada = tituloBusqueda.trim().toLowerCase(); 
        
        for (ContenidoAudiovisual c : this.contenidos) {
            if (c.getTitulo().toLowerCase().contains(busquedaNormalizada)) {
                resultados.add(c);
            }
        }
        return resultados;
    }

    // Elimina un contenido por su ID.
    public boolean eliminarContenido(int id) {
        ContenidoAudiovisual contenidoAEliminar = buscarContenidoPorId(id);
        
        if (contenidoAEliminar != null) {
            this.contenidos.remove(contenidoAEliminar);
            return true;
        }
        return false;
    }
    
    
    // LÓGICA DE PERSISTENCIA (DELEGACIÓN AL REPOSITORIO)
    
    // Delega la operación de guardado al repositorio inyectado.
    public boolean guardar() {
        return repositorio.guardarContenidos(this.contenidos);
    }

    // Delega la operación de carga (y actualiza la lista interna)
    public boolean cargar() {
        List<ContenidoAudiovisual> datosCargados = repositorio.cargarContenidos();
        if (datosCargados != null) {
            this.contenidos = datosCargados;
            // Aseguramos que la lista cargada no esté vacía antes de devolver true
            return !this.contenidos.isEmpty();
        }
        return false;
    }
    
    
    // DATOS DE PRUEBA
    
    private void inicializarDatosDummy() {
        // Inicializa actores, investigadores y otros
        Actor actorPrincipalPelicula = new Actor("Tom Hanks", "Protagonista");
        Actor actorPrincipalAnuncio = new Actor("Ana de Armas", "Modelo principal");
        Investigador invDoc = new Investigador("Jane Goodall", "Investigadora Primates");    
        Actor actorVideoMusical = new Actor("Dwayne Johnson", "Invitado Especial");

        // Crea y agrega contenidos. El método agregarContenido asigna el ID.
        Pelicula p1 = new Pelicula("Forrest Gump", 142, "Drama", "Paramount Pictures", actorPrincipalPelicula);
        agregarContenido(p1);

        Documental d1 = new Documental("Mundo Silvestre", 90, "Naturaleza", "Vida de Primates", invDoc);
        agregarContenido(d1);

        SerieDeTV s1 = new SerieDeTV("Breaking Bad", 50, "Crimen/Drama");
        s1.agregarTemporada(new Temporada(1, 7));
        s1.agregarTemporada(new Temporada(2, 13));
        agregarContenido(s1);
        
        AnuncioPublicitario a1 = new AnuncioPublicitario("Perfume Black", 60, "Comercial", "Luxura", "AdAgency", actorPrincipalAnuncio);
        agregarContenido(a1);
        
        VideoMusical v1 = new VideoMusical("Rock You", 240, "Pop Rock", "The Band", "Greatest Hits", actorVideoMusical);
        agregarContenido(v1);
    }
}