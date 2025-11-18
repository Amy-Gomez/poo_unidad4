/**
 * Class Documental
 */
package modelo;

// Subclase Documental que extiende de ContenidoAudiovisual
public class Documental extends ContenidoAudiovisual {
    private String tema;
    private Investigador investigadorPrincipal; //Agregación: Un Documental tiene un Investigador principal
    
    public Documental(String titulo, int duracionEnMinutos, String genero, String tema, Investigador investigadorPrincipal) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigadorPrincipal= investigadorPrincipal; //Asignar el objeto Investigador 
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    public Investigador getInvestigadorPrincipal() { //Nuevo get
    	return investigadorPrincipal;
    }
    public void setInvestigadorPrincipal (Investigador investigadorPrincipal) {
    	this.investigadorPrincipal= investigadorPrincipal;
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del documental:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + this.tema);
        //Mostar detalles del investigador
        if (investigadorPrincipal != null) {
        	System.out.println(investigadorPrincipal.toString());
        }
        System.out.println();
    }
}