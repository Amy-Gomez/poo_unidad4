package modelo;

import java.util.ArrayList;
import java.util.List;

// Clase que hereda de ContenidoAudiovisual para modelar una Serie de Televisión
public class SerieDeTV extends ContenidoAudiovisual {
	private List<Temporada> temporadas; // Declarar una lista para almacenar objetos Temporada

	// 1. CONSTRUCTOR CON ID (Para el PARSER CSV / Carga)
	public SerieDeTV(int id, String titulo, int duracionEnMinutos, String genero) {
	    
	    // Llama al constructor base sin ID
	    super(titulo, duracionEnMinutos, genero); 
	    
	    // Asigna el ID cargado del archivo
	    this.setId(id);
	    
	    // Inicializa la lista de temporadas (vacía o con datos cargados si se los pasa)
	    this.temporadas = new ArrayList<>(); 
	}

	// 2. CONSTRUCTOR SIN ID (Para el CONTROLADOR / Nuevos objetos)
	public SerieDeTV(String titulo, int duracionEnMinutos, String genero) {
	    
	    // Llama al constructor base sin ID
	    super(titulo, duracionEnMinutos, genero); 
	    
	    // Inicializa la lista de temporadas
	    this.temporadas = new ArrayList<>(); 
	    
	    // El ID será asignado por GestorContenido.agregarContenido()
	}
	
	// implementacion del metodo abstracto
	@Override
	public String getDetallesEspecificos() {
		StringBuilder sb = new StringBuilder();
		sb.append("   [SERIE] Temporadas: ").append(this.temporadas.size());

		for (Temporada t : this.temporadas) {
			// Usa el toString() de Temporada (que ya es legible)
			sb.append("\n     - ").append(t.toString());
		}
		return sb.toString();
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