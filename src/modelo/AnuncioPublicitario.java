package modelo;

// Clase que hereda de ContenidoAudiovisual para modelar un anuncio.
public class AnuncioPublicitario extends ContenidoAudiovisual {
	private String marca; // Declarar la marca que promociona el anuncio
	private String agencia; // Declarar la agencia de publicidad que creó el anuncio.
	private Actor protagonista; // Relación de Agregación: almacenar el Actor principal del anuncio.

	// Constructor para inicializar un nuevo objeto AnuncioPublicitario.
	public AnuncioPublicitario(String titulo, int duracionEnMinutos, String genero, String marca, String agencia,
			Actor protagonista) {
		super(titulo, duracionEnMinutos, genero); // Llamar al constructor de la clase padre (ContenidoAudiovisual).
		this.marca = marca; // Asignar la marca.
		this.agencia = agencia; // Asignar la agencia
		this.protagonista = protagonista; // Establecer la referencia al objeto Actor
	}

	// Obtener la marca del anuncio
	public String getMarca() {
		return marca;
	}

	// Asignar una nueva marca al anuncio.
	public void setMarca(String marca) {
		this.marca = marca;
	}

	// Obtener el nombre de la agencia.
	public String getAgencia() {
		return agencia;
	}

	// Asignar una nueva agencia
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	// Obtener el objeto Actor que es el protagonista
	public Actor getProtagonista() {
		return protagonista;
	}

	// Asignar un nuevo Actor como protagonista
	public void setProtagonista(Actor protagonista) {
		this.protagonista = protagonista;
	}
}