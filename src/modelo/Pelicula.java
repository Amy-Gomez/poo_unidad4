package modelo;

// Clase que hereda de ContenidoAudiovisual para modelar una película.
public class Pelicula extends ContenidoAudiovisual {
	private String estudio; // Declarar el nombre del estudio de producción.
	private Actor actorPrincipal; // Relación de Agregación: almacenar el Actor protagonista de la película

	// Constructor para inicializar un nuevo objeto Pelicula.
	public Pelicula(int id, String titulo, int duracionEnMinutos, String genero, String estudio, Actor actorPrincipal) {
	    // 1. Llama al constructor de la clase base (ContenidoAudiovisual) con los parámetros
	    super(titulo, duracionEnMinutos, genero); 
	    // 2. Asigna el ID usando el método que heredó
	    this.setId(id); // O llama a super.setId(id);
	    
	    // 3. Inicializa los atributos específicos de Pelicula
	    this.estudio = estudio;
	    this.actorPrincipal = actorPrincipal;
	}
	public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio, Actor actorPrincipal) {
	    super(titulo, duracionEnMinutos, genero); 
	    // El ID se queda en 0 y lo asignará GestorContenido.agregarContenido()
	    this.estudio = estudio;
	    this.actorPrincipal = actorPrincipal;
	}
    
    // implementacion de el método abstracto (Polimorfismo para detalles específicos)
    @Override
    public String getDetallesEspecificos() {
        // Usa el carácter de sangría que estabas usando:    
        return "   [PELÍCULA] Estudio: " + this.estudio + 
               "\n   Actor Principal: " + this.actorPrincipal.getNombre();
    }

	// Obtener el nombre del estudio
	public String getEstudio() {
		return estudio;
	}

	// Asignar un nuevo estudio
	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}

	// Obtener el objeto Actor principal
	public Actor getActorPrincipal() {
		return actorPrincipal;
	}

	// Asignar un nuevo Actor principal
	public void setActorPrincipal(Actor actorPrincipal) {
		this.actorPrincipal = actorPrincipal;
	}
}