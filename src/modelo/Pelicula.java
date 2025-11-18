/**
 * Class Pelicula
 */
package modelo;

// Subclase Pelicula que extiende de ContenidoAudiovisual
public class Pelicula extends ContenidoAudiovisual {
    private String estudio;
    private Actor actorPrincipal; 

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio, Actor actorPrincipal) {
        super(titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
        this.actorPrincipal= actorPrincipal; //Asignar el objeto Actor
    }
    //Gtters y Setters originales
    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }
    
    //Nuevos getters y setters para el Actor 
    public Actor getActorPrincipal () {
    	return actorPrincipal;
    }
    public void setActorPrincipal (Actor actorPrincipal) {
    	this.actorPrincipal= actorPrincipal;
    }
    //Metodo modificado (para que ahora tb muestre los detalles del actor)
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la película:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Estudio: " + estudio);
        //Mostrar detalles del auor 
        if (actorPrincipal !=null) {
        	System.out.println(actorPrincipal.toString());	
        }
        System.out.println();
    }
}