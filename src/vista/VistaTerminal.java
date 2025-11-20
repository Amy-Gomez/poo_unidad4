package vista;

import modelo.*;
import java.util.List;
import java.util.Scanner;

public class VistaTerminal {
	private Scanner scanner = new Scanner(System.in);

	public int mostrarMenu() {
        System.out.println("\n--- SISTEMA DE GESTIÓN AUDIOVISUAL ---");
        System.out.println("1. Mostrar todos los contenidos");
        System.out.println("2. Buscar contenido por título");
        System.out.println("3. Añadir nuevo contenido"); // Ahora interactivo
        System.out.println("4. Eliminar contenido por ID"); // Nueva opción
        System.out.println("5. Guardar y Salir");
        System.out.println("0. Salir sin guardar");
        System.out.print("Seleccione una opción: ");
        
        if (scanner.hasNextInt()) {
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            return opcion;
        } else {
            scanner.next(); 
            return -1;
        }
    }
    
	public String solicitarTituloBusqueda() {
        System.out.print("Ingrese el título a buscar: ");
        return scanner.nextLine();
    }
	
	// --- Métodos de Entrada de Datos ---
    public String solicitarTipoContenido() {
        System.out.println("\n--- AÑADIR NUEVO CONTENIDO ---");
        System.out.println("Seleccione tipo: (1) PELICULA, (2) SERIE, (3) DOCUMENTAL");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1: return "PELICULA";
            case 2: return "SERIE";
            case 3: return "DOCUMENTAL";
            default: return "PELICULA"; // Valor por defecto
        }
    }
    
    public String solicitarDato(String mensaje) {
        System.out.print("Ingrese " + mensaje + ": ");
        return scanner.nextLine();
    }
    
    public int solicitarEntero(String mensaje) {
        System.out.print("Ingrese " + mensaje + ": ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Debe ser un número.");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    public int solicitarId(String accion) {
        return solicitarEntero("ID del contenido a " + accion);
    }
    public void mostrarListado(List<ContenidoAudiovisual> contenidos) {
		System.out.println("\n--- LISTADO DE CONTENIDOS ---");
		if (contenidos == null || contenidos.isEmpty()) {
			System.out.println("No hay contenidos registrados o coincidentes.");
			return;
		}
		
		// Impresión detallada
		for (ContenidoAudiovisual c : contenidos) {
			System.out.println("------------------------------------------------");
			// Muestra ID, Título, Duración, etc. (Usando toString())
			System.out.println(c.toString()); 
			
			// Usa el método polimórfico para obtener los detalles específicos (Actor, Temporadas)
			System.out.println("Detalles Específicos: " + c.getDetallesEspecificos());
		}
		System.out.println("------------------------------------------------");
	}

	public void mostrarMensaje(String mensaje) {
		System.out.println(">> " + mensaje);
	}
}