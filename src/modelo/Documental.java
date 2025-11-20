package modelo;

// Clase que hereda de ContenidoAudiovisual para modelar un documental específico
public class Documental extends ContenidoAudiovisual {
	private String tema; // Declarar el tema central del documental
	private Investigador investigadorPrincipal; // Relación de Agregación: almacenar el Investigador asociado al proyecto

	// 1. CONSTRUCTOR CON ID (Para el PARSER CSV / Carga)
	public Documental(int id, String titulo, int duracionEnMinutos, String genero, 
	                  String tema, Investigador investigadorPrincipal) {
	    
	    // Llama al constructor base sin ID
	    super(titulo, duracionEnMinutos, genero); 
	    
	    // Asigna el ID cargado del archivo
	    this.setId(id);
	    
	    // Inicializa atributos específicos
	    this.tema = tema;
	    this.investigadorPrincipal = investigadorPrincipal;
	}

	// 2. CONSTRUCTOR SIN ID (Para el CONTROLADOR / Nuevos objetos)
	public Documental(String titulo, int duracionEnMinutos, String genero, 
	                  String tema, Investigador investigadorPrincipal) {
	    
	    // Llama al constructor base sin ID
	    super(titulo, duracionEnMinutos, genero); 
	    
	    // Inicializa atributos específicos
	    this.tema = tema;
	    this.investigadorPrincipal = investigadorPrincipal;
	    // El ID será asignado por GestorContenido.agregarContenido()
	}

    // IMPLEMENTACIÓN DEL MÉTODO ABSTRACTO (Detalles para Documental)
    @Override
    public String getDetallesEspecificos() {
        String nombreInvestigador = (investigadorPrincipal != null) ? investigadorPrincipal.getNombre() : "N/A";
        return "   [DOCUMENTAL] Tema: " + this.tema + 
               "\n   Investigador: " + nombreInvestigador;
    }

	// Obtener el tema del documental.
	public String getTema() {
		return tema;
	}

	// Asignar un nuevo tema.
	public void setTema(String tema) {
		this.tema = tema;
	}

	// Obtener el objeto Investigador principal
	public Investigador getInvestigadorPrincipal() {
		return investigadorPrincipal;
	}

	// Asignar un nuevo Investigador principal
	public void setInvestigadorPrincipal(Investigador investigadorPrincipal) {
		this.investigadorPrincipal = investigadorPrincipal;
	}
}