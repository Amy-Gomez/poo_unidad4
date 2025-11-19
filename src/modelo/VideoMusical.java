package modelo;

//Nueva subclase que hereda de ContenidoAudiovisual
public class VideoMusical extends ContenidoAudiovisual {
	private String artista;
	private String album;

	// Relación de Agregación con la clase existente Actor
	private Actor actorInvitado;

	public VideoMusical(String titulo, int duracionEnMinutos, String genero, String artista, String album,
			Actor actorInvitado) {
		super(titulo, duracionEnMinutos, genero);
		this.artista = artista;
		this.album = album;
		this.actorInvitado = actorInvitado; // Se establece la relación
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