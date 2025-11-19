package controlador;

import modelo.GestorContenido;
import vista.VistaTerminal;
import java.util.List;
import modelo.ContenidoAudiovisual;

public class Controlador {

	// Referencias a las capas MVC (Modelo y Vista)
	private GestorContenido modelo;
	private VistaTerminal vista;
	private boolean ejecutando;

	// Constructor que proporciona dependencias
	public Controlador(GestorContenido modelo, VistaTerminal vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.ejecutando = true;
	}

	// Inicia el ciclo principal de la aplicación
	public void ejecutar() {
		while (ejecutando) {
			int opcion = vista.mostrarMenu(); // Recibe la opción del usuario
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

	// Pide la lista al Modelo y la envía a la Vista para imprimir
	private void mostrarContenidos() {
		List<ContenidoAudiovisual> contenidos = modelo.obtenerTodosLosContenidos();
		vista.mostrarListado(contenidos);
	}

	private void guardarDatos() {
		if (modelo.guardarAArchivo()) {
			vista.mostrarMensaje("Datos guardados correctamente (Funcionalidad CSV PENDIENTE).");
		} else {
			vista.mostrarMensaje("Error al intentar guardar los datos.");
		}
	}

	private void cargarDatos() {
		if (modelo.cargarDesdeArchivo()) {
			vista.mostrarMensaje("Datos cargados correctamente (Funcionalidad CSV PENDIENTE).");
		} else {
			vista.mostrarMensaje("Error al intentar cargar los datos.");
		}
	}

	private void salir() {
		ejecutando = false;
		vista.mostrarMensaje("Saliendo del sistema. ¡Hasta pronto!");
	}
}