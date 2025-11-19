package modelo;

// Clase que hereda de ContenidoAudiovisual para modelar una película.
public class Pelicula extends ContenidoAudiovisual {
	private String estudio; // Declarar el nombre del estudio de producción.
	private Actor actorPrincipal; // Relación de Agregación: almacenar el Actor protagonista de la película

	// Constructor para inicializar un nuevo objeto Pelicula.
	public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio, Actor actorPrincipal) {
		super(titulo, duracionEnMinutos, genero); // Llamar al constructor de la clase padre
		this.estudio = estudio; // Asignar el estudio.
		this.actorPrincipal = actorPrincipal; // Establecer la referencia al objeto Actor
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