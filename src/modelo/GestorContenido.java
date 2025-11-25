package modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorContenido {

    private List<ContenidoAudiovisual> contenidos;
    private IRepositorioContenido repositorio; 

    public GestorContenido(IRepositorioContenido repositorio) {
        this.repositorio = repositorio;
        this.contenidos = new ArrayList<>();
        
        // Intenta cargar contenidos del repositorio al iniciar
        cargarContenidosIniciales();
    }
    
    // Carga inicial: intenta usar el repositorio. Si falla o no hay datos, usa datos predeterminados.
    private void cargarContenidosIniciales() {
        // La implementación real del repositorio devolverá la lista leída.
        this.contenidos = repositorio.cargarContenidos();
        
        // Si no se pudo cargar nada o la lista está vacía, inicializa con datos de prueba.
        if (this.contenidos == null || this.contenidos.isEmpty()) {
            System.out.println(">> GESTOR: Repositorio vacío. Inicializando con datos de prueba.");
            // Llama al método que añade los datos de prueba
            inicializarDatosDummy(); 
        } else {
            System.out.println(">> GESTOR: " + this.contenidos.size() + " contenidos cargados del repositorio.");
        }
        
        // Se actualiza el contador estático después de cargar los datos (o los dummy).
        actualizarContadorID();
    }

    /**
     * Busca el ID más alto en la lista de contenidos cargados 
     * y actualiza el contador estático global en ContenidoAudiovisual.
     */
    private void actualizarContadorID() {
        int maxId = 0;
        for (ContenidoAudiovisual c : this.contenidos) {
            if (c.getId() > maxId) {
                maxId = c.getId();
            }
        }
        
        // Usa el método estático que agregamos a ContenidoAudiovisual para fijar el nuevo punto de inicio.
        ContenidoAudiovisual.setSiguienteID(maxId + 1); 
        System.out.println("Gestión interna: Contador de IDs actualizado a " + (maxId + 1) + ".");
    }
    
    // --- MÉTODOS DE MANIPULACIÓN Y CONSULTA ---

    // Retorna una lista de todos los contenidos en el catálogo.
    public List<ContenidoAudiovisual> obtenerTodosLosContenidos() {
        return contenidos;
    }
    
    // Retorna el ID que debe asignarse al siguiente contenido disponible. (Ahora usa el estático)
    public int getSiguienteIdDisponible() {
        return ContenidoAudiovisual.getSiguienteID();
    }
    
    /**
     * Agrega un nuevo contenido al catálogo. 
     * Asigna el siguiente ID disponible y lo incrementa.
     */
    public boolean agregarContenido(ContenidoAudiovisual contenido) {
        if (contenido != null) {
            // 1. Asigna el ID usando el contador estático.
            contenido.setId(ContenidoAudiovisual.getSiguienteID()); 
            // 2. Incrementa el contador para el siguiente objeto.
            ContenidoAudiovisual.setSiguienteID(ContenidoAudiovisual.getSiguienteID() + 1);
            
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
    
    
    // --- LÓGICA DE PERSISTENCIA ---
    
    // Delega la operación de guardado al repositorio insertado.
    public boolean guardar() {
        return repositorio.guardarContenidos(this.contenidos);
    }

    // Delega la operación de carga (y actualiza la lista interna)
    public boolean cargar() {
        List<ContenidoAudiovisual> datosCargados = repositorio.cargarContenidos();
        if (datosCargados != null) {
            this.contenidos = datosCargados;
            actualizarContadorID(); // Actualiza el contador después de cargar
            return !this.contenidos.isEmpty();
        }
        return false;
    }
    
    
    // --- DATOS DE PRUEBA (dummy) ---
    
    private void inicializarDatosDummy() {
        // Inicializa actores, investigadores y otros
        Actor actorPrincipalPelicula = new Actor("Tom Hanks", "Protagonista");
        Actor actorPrincipalAnuncio = new Actor("Ana de Armas", "Modelo principal");
        Investigador invDoc = new Investigador("Jane Goodall", "Investigadora Primates");    
        Actor actorVideoMusical = new Actor("Dwayne Johnson", "Invitado Especial");

        // Crea y agrega contenidos. El método agregarContenido asigna el ID.
     // Película ID 1
        Pelicula p1 = new Pelicula(1, "Forrest Gump", 142, "Drama", "Paramount Pictures", actorPrincipalPelicula);
        this.contenidos.add(p1);

        // Documental ID 2
        Documental d1 = new Documental(2, "Mundo Silvestre", 90, "Naturaleza", "Vida de Primates", invDoc);
        this.contenidos.add(d1);

        // Serie ID 3
        SerieDeTV s1 = new SerieDeTV(3, "Breaking Bad", 50, "Crimen/Drama");
        s1.agregarTemporada(new Temporada(1, 7));
        s1.agregarTemporada(new Temporada(2, 13));
        this.contenidos.add(s1);
        
        // Anuncio ID 4
        AnuncioPublicitario a1 = new AnuncioPublicitario(4, "Perfume Black", 60, "Comercial", "Luxura", "AdAgency", actorPrincipalAnuncio);
        this.contenidos.add(a1);
        
        // VideoMusical ID 5
        VideoMusical v1 = new VideoMusical(5, "Rock You", 240, "Pop Rock", "The Band", "Greatest Hits", actorVideoMusical);
        this.contenidos.add(v1);
        ContenidoAudiovisual.setSiguienteID(6);
    }
}