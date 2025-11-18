package modelo;
//Nueva subclase que hereda de ContenidoAudiovisual
public class AnuncioPublicitario extends ContenidoAudiovisual{
	private String marca;
	private String agencia;
	private Actor protagonista; //Relación de Agregación con la clase existente Actor
	
	public AnuncioPublicitario(String titulo, int duracionEnMinutos, String genero, String marca, String agencia, Actor protagonista) {
		super (titulo, duracionEnMinutos, genero);
		this.marca= marca;
		this.agencia= agencia;
		this.protagonista= protagonista; //Se establece la relación
	}
	//Setters y getters para los nuevos atributos
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca= marca;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia= agencia;
	}
	public Actor getProtagonista() {
		return protagonista;
	}
	public void setProtagonista(Actor protagonista) {
		this.protagonista= protagonista;
	}
	@Override
	public void mostrarDetalles() {
        System.out.println("Detalles del Anuncio Publicitario:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Marca: " + this.marca);
        System.out.println("Agencia: " + this.agencia);
        //Mostar detalles del actor
        if (protagonista != null) {
        	System.out.println("Protagonista:" + protagonista.toString());
        }
        System.out.println();
    }
}
