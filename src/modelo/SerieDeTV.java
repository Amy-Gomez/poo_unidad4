/**
 * Class SerieDeTV
 */
package modelo;
import java.util.List;
import java.util.ArrayList;
// Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
    private List <Temporada> temporadas; // La lista de temporadas ahora modela la relación

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = new ArrayList<>(); //Crea un arreglo que contenga una lista
    }

    public void agregarTemporada(Temporada temporada) {
        this.temporadas.add(temporada);
    }

    public List <Temporada>getTemporadas() {
        return temporadas;
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la serie de TV:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Temporadas: " + this.temporadas.size());
        
        for (Temporada t: temporadas) {
        	System.out.println("-" + t.toString());
        } 
        System.out.println();
    }
}