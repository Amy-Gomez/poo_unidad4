package controlador;

import modelo.GestorContenido;
import vista.VistaTerminal;
import java.util.List;
import modelo.ContenidoAudiovisual;

public class Controlador {
    
    private GestorContenido modelo;
    private VistaTerminal vista;
    private boolean ejecutando;

    public Controlador(GestorContenido modelo, VistaTerminal vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.ejecutando = true;
    }

    public void ejecutar() {
        while (ejecutando) {
            int opcion = vista.mostrarMenu();
            manejarOpcion(opcion);
        }
    }

    private void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                mostrarContenidos();
                break;
            case 2:
                guardarDatos();
                break;
            case 3:
                cargarDatos();
                break;
            case 0:
                salir();
                break;
            default:
                vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
        }
    }

    private void mostrarContenidos() {
        List<ContenidoAudiovisual> contenidos = modelo.obtenerTodosLosContenidos();
        vista.mostrarListado(contenidos);
    }

    private void guardarDatos() {
        // Llama al nuevo método "guardar" del GestorContenido
        if (modelo.guardar()) {
            vista.mostrarMensaje("Datos guardados correctamente. (REPOSITORIO CSV PENDIENTE).");
        } else {
            vista.mostrarMensaje("Error al intentar guardar los datos.");
        }
    }

    private void cargarDatos() {
        // Llama al nuevo método "cargar" del GestorContenido
        if (modelo.cargar()) {
            vista.mostrarMensaje("Datos cargados correctamente. (REPOSITORIO CSV PENDIENTE).");
        } else {
            vista.mostrarMensaje("Error al intentar cargar los datos.");
        }
    }

    private void salir() {
        ejecutando = false;
        vista.mostrarMensaje("Saliendo del sistema. ¡Hasta pronto!");
    }
}