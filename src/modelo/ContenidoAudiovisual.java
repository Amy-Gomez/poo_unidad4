package modelo;

// Clase abstracta base para todos los contenidos.
public abstract class ContenidoAudiovisual {
	
	// Contador estático para IDs (gestionado por GestorContenido).
	private static int siguienteID = 1;

	protected int id; 
	private String titulo; 
	private int duracionEnMinutos; 
	private String genero; 

	/**
     * Constructor principal: Usado por las clases hijas (subclases) al ser creadas.
     * El ID se inicializa a 0 y es asignado posteriormente.
     */
	public ContenidoAudiovisual(String titulo, int duracionEnMinutos, String genero) {
		this.id = 0; 
		this.titulo = titulo;
		this.duracionEnMinutos = duracionEnMinutos;
		this.genero = genero;
	}
    
    // Método abstracto (OCP) para detalles específicos (polimorfismo). 
    public abstract String getDetallesEspecificos(); 


	// --- GESTIÓN DE ID ---

	public int getId() {
		return id;
	}

	// Establecer el ID (Usado por GestorContenido y Persistencia).
	public void setId(int id) {
	    this.id = id;
	}

    /**
     * Establece el valor del próximo ID que se debe asignar.
     * Usado por GestorContenido al cargar datos (o dummy) para evitar reiniciar la secuencia.
     */
    public static void setSiguienteID(int nuevoID) {
        siguienteID = nuevoID;
    }
    
    // Retorna el próximo ID disponible.
    public static int getSiguienteID() {
        return siguienteID;
    }

	
	// --- GETTERS & SETTERS ---

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracionEnMinutos() {
		return duracionEnMinutos;
	}

	public void setDuracionEnMinutos(int duracionEnMinutos) {
		this.duracionEnMinutos = duracionEnMinutos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
	    return "ID: " + id + 
	           " | Título: " + titulo + 
	           " | Duración: " + duracionEnMinutos + " min" + 
	           " | Género: " + genero;
	}
}