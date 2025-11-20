package controlador;

import modelo.GestorContenido;
import vista.VistaTerminal;

public class Controlador {

    private GestorContenido modelo;
    private VistaTerminal vista;
    private boolean ejecutando;

    public Controlador(GestorContenido modelo, VistaTerminal vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.ejecutando = true;
    }

    public void iniciar() {
        while (ejecutando) {
            int opcion = vista.mostrarMenu();
            manejarOpcion(opcion);
        }
    }

    private void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                vista.mostrarListado(modelo.obtenerTodosLosContenidos());
                break;
            case 2:
                String titulo = vista.solicitarTituloBusqueda();
                vista.mostrarListado(modelo.buscarContenido(titulo));
                break;
            case 3:
                // --- Opción DEMO / No interactiva ---
                vista.mostrarMensaje("Función de añadir contenido aún en desarrollo. ¡Usa el botón 4 para guardar!");
                break;
            case 4:
                // Guardar y Salir (Opción 4 en este menú)
                if (modelo.guardar()) {
                    vista.mostrarMensaje("Datos guardados correctamente.");
                } else {
                    vista.mostrarMensaje("Error al guardar.");
                }
                ejecutando = false;
                break;
            case 0:
                vista.mostrarMensaje("Saliendo sin guardar...");
                ejecutando = false;
                break;
            default:
                vista.mostrarMensaje("Opción no válida.");
        }
    }
}