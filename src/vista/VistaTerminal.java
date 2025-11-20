package vista;

import modelo.*;
import java.util.List;
import java.util.Scanner;

public class VistaTerminal {
    private Scanner scanner = new Scanner(System.in);

    // Método para mostrar el menú y obtener la opción (todo en uno)
    public int mostrarMenu() {
        System.out.println("\n--- SISTEMA DE GESTIÓN AUDIOVISUAL ---");
        System.out.println("1. Mostrar contenidos");
        System.out.println("2. Buscar contenido por título");
        System.out.println("3. Añadir contenido (Demo)");
        System.out.println("4. Guardar y Salir");
        System.out.println("0. Salir sin guardar");
        System.out.print("Seleccione una opción: ");
        
        if (scanner.hasNextInt()) {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea sobrante
            return opcion;
        } else {
            scanner.next(); // Limpiar buffer si meten letras
            return -1;
        }
    }
    
    // Método para pedir un texto al usuario (Necesario para la búsqueda)
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
            System.out.println(c.toString()); // Muestra ID, Título, etc.
            System.out.println("Detalles: " + c.getDetallesEspecificos());
        }
        System.out.println("------------------------------------------------");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(">> " + mensaje);
    }
}