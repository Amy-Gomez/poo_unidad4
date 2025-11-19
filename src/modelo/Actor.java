package modelo;

public class Actor {
	private String nombre; // Declarar el nombre del actor
	private String rolPrincipal; // Declarar el rol principal que interpreta

	// Constructor para inicializar un nuevo objeto Actor.
	public Actor(String nombre, String rolPrincipal) {
		this.nombre = nombre;
		this.rolPrincipal = rolPrincipal;
	}

	// Obtener el nombre del actor
	public String getNombre() {
		return nombre;
	}

	// Asignarle un nuevo nombre 
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Asignar un nuevo rol principal
	public void setRolPrincipal(String rolPrincipal) {
		this.rolPrincipal = rolPrincipal;
	}

	// Sobrescribir el método para obtener una representación legible del Actor.
	@Override
	public String toString() {
		return "Actor: " + nombre + "(Rol:" + rolPrincipal + ")"; // Formatear la información del actor y su rol
	}
}