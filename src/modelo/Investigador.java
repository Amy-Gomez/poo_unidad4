package modelo;

public class Investigador {
	private String nombre;
	private String areaDeEspecializacion;
	
	public Investigador (String nombre, String areaDeEspecializacion) {
		this.nombre= nombre;
		this.areaDeEspecializacion= areaDeEspecializacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre (String nombre) {
		this.nombre= nombre;
	}
	public String getAreaDeEspecializacion() {
		return areaDeEspecializacion;
	}
	public void setAreaDeEspecializacion (String areaDeEspecializacion) {
		this.areaDeEspecializacion= areaDeEspecializacion;
	}
	@Override
	public String toString() {
		return "Investigador" + nombre + "(Especialidad" + areaDeEspecializacion + ")";
	}
}
