package modelo;

//Nueva subclase que hereda de ContenidoAudiovisual
public class VideoMusical extends ContenidoAudiovisual {
	private String artista;
	private String album;

	// Relación de Agregación con la clase existente Actor
	private Actor actorInvitado;

	public VideoMusical(int id, String titulo, int duracionEnMinutos, String genero, 
            String artista, String album, Actor actorInvitado) {

		// Llama al constructor base sin ID
		super(titulo, duracionEnMinutos, genero);

		// Asigna el ID cargado del archivo
		this.setId(id);

		// Inicializa atributos específicos
		this.artista = artista;
		this.album = album;
		this.actorInvitado = actorInvitado; 
}

	//2. CONSTRUCTOR SIN ID (Para el CONTROLADOR / Nuevos objetos) - (EL QUE NECESITAMOS AÑADIR)
	public VideoMusical(String titulo, int duracionEnMinutos, String genero, 
            String artista, String album, Actor actorInvitado) {

		// Llama al constructor base sin ID
		super(titulo, duracionEnMinutos, genero);

		// Inicializa atributos específicos
		this.artista = artista;
		this.album = album;
		this.actorInvitado = actorInvitado;

// El ID se queda en 0 y será asignado por GestorContenido.agregarContenido()
}

    // implementacion del metodo abstracto (Detalles para Video Musical)
    @Override
    public String getDetallesEspecificos() {
        String actor = (actorInvitado != null) ? actorInvitado.getNombre() : "N/A";
        return "   [VIDEO MUSICAL] Artista: " + this.artista + 
               "\n   Álbum: " + this.album + 
               "\n   Actor Invitado: " + actor;
    }

	// Getters y setters para los nuevos atributos
	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Actor getActorInvitado() {
		return actorInvitado;
	}

	public void setActorInvitado(Actor actorInvitado) {
		this.actorInvitado = actorInvitado;
	}
}