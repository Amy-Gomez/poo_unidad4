package modelo;

// Clase que hereda de ContenidoAudiovisual para modelar un documental específico
public class Documental extends ContenidoAudiovisual {
	private String tema; // Declarar el tema central del documental
	private Investigador investigadorPrincipal; // Relación de Agregación: almacenar el Investigador asociado al proyecto

	// Constructor para inicializar un nuevo objeto Documental
	public Documental(String titulo, int duracionEnMinutos, String genero, String tema,
			Investigador investigadorPrincipal) {
		super(titulo, duracionEnMinutos, genero); // Llamar al constructor de la clase padre
		this.tema = tema; // Asignar el tema.
		this.investigadorPrincipal = investigadorPrincipal; // Establecer la referencia al objeto Investigador
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