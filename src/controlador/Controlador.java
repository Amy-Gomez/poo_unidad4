package controlador;
import modelo.*;
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
                // --- Lógica para AÑADIR CONTENIDO ---
                String tipo = vista.solicitarTipoContenido();
                String t = vista.solicitarDato("el Título");
                int d = vista.solicitarEntero("la Duración en minutos");
                String g = vista.solicitarDato("el Género");
                
                if (tipo.equals("PELICULA")) {
                    // Datos específicos de Película
                    String estudio = vista.solicitarDato("el Estudio");
                    String nombreActor = vista.solicitarDato("el nombre del Actor Principal");
                    
                    // Se crean las dependencias y el objeto
                    Actor actorP = new Actor(nombreActor, "Protagonista"); 
                    Pelicula nuevaPelicula = new Pelicula(t, d, g, estudio, actorP);
                    
                    modelo.agregarContenido(nuevaPelicula);
                    vista.mostrarMensaje(" Película '" + t + "' (ID: " + nuevaPelicula.getId() + ") añadida con éxito :)");
                } else {
                    vista.mostrarMensaje("Tipo de contenido '" + tipo + "' no implementado aún. Añade la lógica aquí.");
                }
                break;
            case 4:
                // --- Lógica para ELIMINAR CONTENIDO ---
                int idAEliminar = vista.solicitarId("eliminar");
                if (modelo.eliminarContenido(idAEliminar)) {
                    vista.mostrarMensaje("Contenido con ID " + idAEliminar + " eliminado correctamente.");
                } else {
                    vista.mostrarMensaje("Error: No se encontró contenido con el ID " + idAEliminar + ".");
                }
                break;
            case 5:
                // Guardar y Salir (Opción 5 en el nuevo menú)
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