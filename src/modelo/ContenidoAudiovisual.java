package modelo;

// Clase abstracta base para todos los contenidos (Películas, Series, Documentales, etc.).
public abstract class ContenidoAudiovisual {
	
	// El ID no se genera aquí, lo asigna el GestorContenido (SRP).
	protected int id; 
	private String titulo; 
	private int duracionEnMinutos; 
	private String genero; 

	// Constructor para inicializar los atributos de un Contenido Audiovisual.
	public ContenidoAudiovisual(String titulo, int duracionEnMinutos, String genero) {
		// Se inicializa el ID a 0. Será asignado por GestorContenido.
		this.id = 0; 
		this.titulo = titulo;
		this.duracionEnMinutos = duracionEnMinutos;
		this.genero = genero;
	}
    
    // Método abstracto (OCP) para detalles específicos (película vs serie vs documental). 
    public abstract String getDetallesEspecificos(); 


	// Obtener el ID único del contenido
	public int getId() {
		return id;
	}

	// Establecer el ID (Usado por el GestorContenido y Persistencia).
	public void setId(int id) {
	    this.id = id;
	}
	
	// Obtener el título
	public String getTitulo() {
		return titulo;
	}

	// Asignar un nuevo título
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	// Obtener la duración en minutos
	public int getDuracionEnMinutos() {
		return duracionEnMinutos;
	}

	// Asignar una nueva duración en minutos
	public void setDuracionEnMinutos(int duracionEnMinutos) {
		this.duracionEnMinutos = duracionEnMinutos;
	}

	// Obtener el género
	public String getGenero() {
		return genero;
	}

	// Asignar un nuevo género.
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	// Sobreescritura de toString para mostrar los datos comunes.
	@Override
	public String toString() {
	    return "ID: " + id + 
	           " | Título: " + titulo + 
	           " | Duración: " + duracionEnMinutos + " min" + 
	           " | Género: " + genero;
	}
}