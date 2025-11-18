package modelo;

public class Actor {
	private String nombre;
	private String rolPrincipal;
	public Actor(String nombre, String rolPrincipal) {
		this.nombre = nombre;
		this.rolPrincipal = rolPrincipal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre (String nombre) {
		this.nombre = nombre; 
	}
	public void setRolPrincipal(String rolPrincipal) {
		this.rolPrincipal = rolPrincipal;
	}
	@Override
	public String toString() {
		return "Actor: "+ nombre + "(Rol:" + rolPrincipal + ")";
	}
}
