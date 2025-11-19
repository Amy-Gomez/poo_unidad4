package modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorContenido {

	// Lista principal que almacena todos los contenidos
	private List<ContenidoAudiovisual> contenidos;

	public GestorContenido() {
		this.contenidos = new ArrayList<>();
		// Inicializa con datos de prueba para comenzar a trabajar
		inicializarDatosDummy();
	}

	// METODOS DE MANIPULACIÓN DE LA LISTA
	public List<ContenidoAudiovisual> obtenerTodosLosContenidos() {
		return contenidos;
	}

	public void agregarContenido(ContenidoAudiovisual contenido) {
		if (contenido != null) {
			this.contenidos.add(contenido);
		}
	}

	// Busca un contenido por su ID, devolviendo el objeto si se encuentra o null.
	public ContenidoAudiovisual buscarContenidoPorId(int id) {
		for (ContenidoAudiovisual c : contenidos) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	// LÓGICA DE MANEJO DE ARCHIVOS (pendiente de implementsr!)

	// Método para cargar datos desde un archivo CSV.
	public boolean cargarDesdeArchivo() {
		// Tarea: Implementar la lectura de CSV aquí.
		System.out.println("Lógica de carga de archivo CSV ejecutada. (PENDIENTE)");
		return true;
	}

	// Método para guardar el estado actual del sistema a un archivo CSV.
	public boolean guardarAArchivo() {
		// Tarea: Implementar la escritura a CSV aquí.
		System.out.println("Lógica de guardado a archivo CSV ejecutada. (PENDIENTE)");
		return true;
	}

	// DATOS DE PRUEBA:

	private void inicializarDatosDummy() {
		Actor actorPrincipalPelicula = new Actor("Tom Hanks", "Protagonista");
		Actor actorPrincipalAnuncio = new Actor("Ana de Armas", "Modelo principal");
		Investigador invDoc = new Investigador("Jane Goodall", "Investigadora Primates");
		Actor actorVideoMusical = new Actor("Dwayne Johnson", "Invitado Especial");

		// Crear Película
		Pelicula p1 = new Pelicula("Forrest Gump", 142, "Drama", "Paramount Pictures", actorPrincipalPelicula);
		agregarContenido(p1);

		// Crear Documental
		Documental d1 = new Documental("Mundo Silvestre", 90, "Naturaleza", "Vida de Primates", invDoc);
		agregarContenido(d1);

		// Crear Serie de TV
		SerieDeTV s1 = new SerieDeTV("Breaking Bad", 50, "Crimen/Drama");
		s1.agregarTemporada(new Temporada(1, 7));
		s1.agregarTemporada(new Temporada(2, 13));
		agregarContenido(s1);

		// Crear Anuncio
		AnuncioPublicitario a1 = new AnuncioPublicitario("Perfume Black", 60, "Comercial", "Luxura", "AdAgency",
				actorPrincipalAnuncio);
		agregarContenido(a1);

		// Crear Video Musical
		VideoMusical v1 = new VideoMusical("Rock You", 240, "Pop Rock", "The Band", "Greatest Hits", actorVideoMusical);
		agregarContenido(v1);
	}
}