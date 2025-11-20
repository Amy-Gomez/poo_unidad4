package modelo;

// Clase que hereda de ContenidoAudiovisual para modelar un anuncio.
public class AnuncioPublicitario extends ContenidoAudiovisual {
	private String marca; // Declarar la marca que promociona el anuncio
	private String agencia; // Declarar la agencia de publicidad que creó el anuncio.
	private Actor protagonista; // Relación de Agregación: almacenar el Actor principal del anuncio.

	// 1. CONSTRUCTOR CON ID (Para el PARSER CSV / Carga) - (EL QUE YA TENÍAS)
	public AnuncioPublicitario(int id, String titulo, int duracionEnMinutos, String genero, 
	                           String marca, String agencia, Actor protagonista) {
	    
	    // Llama al constructor base sin ID
	    super(titulo, duracionEnMinutos, genero); 
	    
	    // Asigna el ID cargado del archivo
	    this.setId(id);
	    
	    // Inicializa atributos específicos
	    this.marca = marca;
	    this.agencia = agencia;
	    this.protagonista = protagonista;
	}

	// 2. CONSTRUCTOR SIN ID (Para el CONTROLADOR / Nuevos objetos) - (EL QUE NECESITAMOS AÑADIR)
	public AnuncioPublicitario(String titulo, int duracionEnMinutos, String genero, 
	                           String marca, String agencia, Actor protagonista) {
	    
	    // Llama al constructor base sin ID
	    super(titulo, duracionEnMinutos, genero); 
	    
	    // Inicializa atributos específicos
	    this.marca = marca;
	    this.agencia = agencia;
	    this.protagonista = protagonista;
	    
	    // El ID se quedará en 0 y será asignado por GestorContenido.agregarContenido()
	}
	

    // implementacion del metodo abstracto (Detalles para Anuncio Publicitario)
    @Override
    public String getDetallesEspecificos() {
        String nombreProtagonista = (protagonista != null) ? protagonista.getNombre() : "N/A";
        return "   [ANUNCIO] Marca: " + this.marca + 
               "\n   Agencia: " + this.agencia +
               "\n   Protagonista: " + nombreProtagonista;
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