package modelo;

// Clase para representar una Temporada dentro de una SerieDeTV
public class Temporada {
	private int numeroTemporada; // Almacenar el número de la temporada (ej: 1, 2, 3)
	private int numeroEpisodios; // Almacenar el total de episodios que contiene la temporada

	// Constructor para inicializar una nueva Temporada.
	public Temporada(int numeroTemporada, int numeroEpisodios) {
		this.numeroTemporada = numeroTemporada;
		this.numeroEpisodios = numeroEpisodios;
	}

	// Obtener el número de la temporada
	public int getNumeroTemporada() {
		return numeroTemporada;
	}

	// Asignar un nuevo número a la temporada
	public void setNumeroTemporada(int numeroTemporada) {
		this.numeroTemporada = numeroTemporada;
	}

	// Obtener el número de episodios
	public int getNumeroEpisodios() {
		return numeroEpisodios;
	}

	// Asignar un nuevo número de episodios
	public void setNumeroEpisodios(int numeroEpisodios) {
		this.numeroEpisodios = numeroEpisodios;
	}

	// Sobrescribir el método para obtener una representación legible de la Temporada.
	@Override
	public String toString() {
		return "Temporada " + numeroTemporada + "(" + numeroEpisodios + " episodios)";
	}
}