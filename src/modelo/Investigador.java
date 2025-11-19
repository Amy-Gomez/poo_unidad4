package modelo;

// Clase para representar a un Investigador que puede participar en Documentales.
public class Investigador {
	private String nombre; 
	private String areaDeEspecializacion; 

	// Constructor para inicializar un nuevo objeto Investigador.
	public Investigador(String nombre, String areaDeEspecializacion) {
		this.nombre = nombre;
		this.areaDeEspecializacion = areaDeEspecializacion;
	}

	// Obtener el nombre del investigador.
	public String getNombre() {
		return nombre;
	}

	// Asignar un nuevo nombre al investigador.
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Obtener el área de especialización
	public String getAreaDeEspecializacion() {
		return areaDeEspecializacion;
	}

	// Asignar una nueva área de especialización
	public void setAreaDeEspecializacion(String areaDeEspecializacion) {
		this.areaDeEspecializacion = areaDeEspecializacion;
	}

	// Sobrescribir el método para obtener una representación legible del investigador
	@Override
	public String toString() {
		// Formatear la información del investigador y su especialidad
		return "Investigador" + nombre + "(Especialidad" + areaDeEspecializacion + ")";
	}
}