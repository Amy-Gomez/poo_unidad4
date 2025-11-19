package modelo;

// Clase abstracta base para todos los contenidos (Películas, Series, Documentales, etc.).
public abstract class ContenidoAudiovisual {
	private static int contar = 0; // Contador estático para generar IDs unicos
	protected int id; // Identificador único del contenido. Usé 'protected' para acceso en subclases
	private String titulo; // Título del contenido.
	private int duracionEnMinutos; // Duración del contenido
	private String genero; // Género cinematográfico del contenido

	// Constructor para inicializar los atributos de un Contenido Audiovisual.
	public ContenidoAudiovisual(String titulo, int duracionEnMinutos, String genero) {
		this.id = ++contar; // Incrementar el contador estático y asignar el nuevo valor como id
		this.titulo = titulo;
		this.duracionEnMinutos = duracionEnMinutos;
		this.genero = genero;
	}

	// Obtener el ID único del contenido
	public int getId() {
		return id;
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
}