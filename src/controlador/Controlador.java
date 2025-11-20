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
            // Usamos el método que SÍ existe en VistaTerminal
            int opcion = vista.mostrarMenu();
            manejarOpcion(opcion);
        }
    }

    private void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                // Mostrar catálogo completo
                vista.mostrarListado(modelo.obtenerTodosLosContenidos());
                break;
            case 2:
                // Buscar contenido
                String titulo = vista.solicitarTituloBusqueda();
                vista.mostrarListado(modelo.buscarContenido(titulo));
                break;
            case 3:
                vista.mostrarMensaje("Función de añadir no implementada en esta demo.");
                break;
            case 4:
                // Guardar y Salir
                if (modelo.guardar()) {
                    vista.mostrarMensaje("Datos guardados correctamente.");
                } else {
                    vista.mostrarMensaje("Error al guardar.");
                }
                ejecutando = false;
                break;
            case 0:
                vista.mostrarMensaje("Saliendo...");
                ejecutando = false;
                break;
            default:
                vista.mostrarMensaje("Opción no válida.");
        }
    }
}