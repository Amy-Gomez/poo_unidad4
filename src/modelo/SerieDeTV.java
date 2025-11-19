package modelo;

import java.util.ArrayList;
import java.util.List;

// Clase que hereda de ContenidoAudiovisual para modelar una Serie de Televisión
public class SerieDeTV extends ContenidoAudiovisual {
	private List<Temporada> temporadas; // Declarar una lista para almacenar objetos Temporada

	// Constructor para inicializar una nueva Serie de TV
	public SerieDeTV(String titulo, int duracionEnMinutos, String genero) {
		super(titulo, duracionEnMinutos, genero); // Llamar al constructor de la clase padre.
		this.temporadas = new ArrayList<>(); // Inicializar la lista de temporadas al crear la serie
	}

	// Método para añadir un nuevo objeto Temporada a la lista de la serie
	public void agregarTemporada(Temporada temporada) {
		this.temporadas.add(temporada);
	}

	// Obtener la lista completa de objetos Temporada asociados a esta serie
	public List<Temporada> getTemporadas() {
		return temporadas;
	}
}