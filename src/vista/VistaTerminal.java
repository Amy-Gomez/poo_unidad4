package vista;

import modelo.*;
import java.util.List;
import java.util.Scanner;

public class VistaTerminal {
	private Scanner scanner = new Scanner(System.in);

	public int mostrarMenu() {
		// ESTADO ANTERIOR: Opciones 1, 2, 3 (Demo), 4 (Guardar), 0 (Salir)
		System.out.println("\n--- SISTEMA DE GESTIÓN AUDIOVISUAL ---");
		System.out.println("1. Mostrar todos los contenidos");
		System.out.println("2. Buscar contenido por título");
		System.out.println("3. Añadir contenido (DEMO)"); // La opción que buscabas
		System.out.println("4. Guardar y Salir");
		System.out.println("0. Salir sin guardar");
		System.out.print("Seleccione una opción: ");
		
		if (scanner.hasNextInt()) {
			int opcion = scanner.nextInt();
			scanner.nextLine();
			return opcion;
		} else {
			scanner.next(); // limpiar buffer
			return -1;
		}
	}
    
	public String solicitarTituloBusqueda() {
        System.out.print("Ingrese el título a buscar: ");
        return scanner.nextLine();
    }

	public void mostrarListado(List<ContenidoAudiovisual> contenidos) {
		System.out.println("\n--- LISTADO DE CONTENIDOS ---");
		if (contenidos == null || contenidos.isEmpty()) {
			System.out.println("No hay contenidos registrados o coincidentes.");
			return;
		}
		for (ContenidoAudiovisual c : contenidos) {
			System.out.println("------------------------------------------------");
			// Aquí iría el código de tu listado original (solo para que compile)
			System.out.println("ID: " + c.getId() + " | Título: " + c.getTitulo() + " | Género: " + c.getGenero());
		}
		System.out.println("------------------------------------------------");
	}

	public void mostrarMensaje(String mensaje) {
		System.out.println(">> " + mensaje);
	}
}