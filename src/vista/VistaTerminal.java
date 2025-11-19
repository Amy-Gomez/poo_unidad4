package vista;

import modelo.*;
import java.util.List;
import java.util.Scanner;

public class VistaTerminal {
	private Scanner scanner = new Scanner(System.in);

	public int mostrarMenu() {
		System.out.println("\n--- SISTEMA DE GESTIÓN AUDIOVISUAL ---");
		System.out.println("1. Mostrar contenidos");
		System.out.println("2. Guardar a archivo CSV");
		System.out.println("3. Cargar desde archivo CSV");
		System.out.println("0. Salir");
		System.out.print("Seleccione una opción: ");
		// Esta parte es para validación simple (para evitar errores si meten letras)
		if (scanner.hasNextInt()) {
			return scanner.nextInt();
		} else {
			scanner.next(); // limpiar buffer
			return -1;
		}
	}

	public void mostrarListado(List<ContenidoAudiovisual> contenidos) {
		System.out.println("\n--- LISTADO DE CONTENIDOS ---");
		if (contenidos.isEmpty()) {
			System.out.println("No hay contenidos registrados.");
			return;
		}
		for (ContenidoAudiovisual c : contenidos) {
			System.out.println("ID: " + c.getId() + " | Título: " + c.getTitulo() + " | Género: " + c.getGenero());

			// Aquí se determina que tipo es para imprimir sus detalles específicos
			if (c instanceof Pelicula) {
				Pelicula p = (Pelicula) c;
				System.out.println("   [PELÍCULA] Estudio: " + p.getEstudio());
				System.out.println("   Actor Principal: " + p.getActorPrincipal().getNombre());
			} else if (c instanceof SerieDeTV) {
				SerieDeTV s = (SerieDeTV) c;
				System.out.println("   [SERIE] Temporadas: " + s.getTemporadas().size());
				for (Temporada t : s.getTemporadas()) {
					System.out.println("     - " + t.toString());
				}
			} else if (c instanceof Documental) {
				Documental d = (Documental) c;
				System.out.println("   [DOCUMENTAL] Tema: " + d.getTema());
				System.out.println("   Investigador: " + d.getInvestigadorPrincipal().getNombre());
			}
			System.out.println("------------------------------------------------");
		}
	}

	public void mostrarMensaje(String mensaje) {
		System.out.println(">> " + mensaje);
	}
}
