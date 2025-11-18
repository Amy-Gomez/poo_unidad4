package poo;
import modelo.*;

public class PruebaAudioVisual {
	public static void main(String[] args) {
        System.out.println("Hello from Eclipse!");

        // 1. Crear instancias de las clases de relación (Actor, Temporada, Investigador)
        Actor actorPelicula = new Actor("Sam Worthington", "Jake Sully");
        Temporada temporada1 = new Temporada(1, 10);
        Temporada temporada8 = new Temporada(8, 6);
        Investigador investigadorDocumental = new Investigador("Neil deGrasse Tyson", "Astrofísica");
        
        // Actores para las nuevas clases
        Actor actorVideo = new Actor("Christopher Walken", "Bailarín");
        Actor actorAnuncio = new Actor("Ryan Reynolds", "Portavoz");


        // 2. Crear instancias de TODAS las subclases
        // Aumentamos el tamaño del array a 5
        ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[5];
        
        // Clases Originales
        contenidos[0] = new Pelicula("Avatar", 125, "Accion", "20th Century Studios", actorPelicula);
        
        SerieDeTV got = new SerieDeTV("Game of Thrones", 60, "Fantasy");
        got.agregarTemporada(temporada1);
        got.agregarTemporada(temporada8);
        contenidos[1] = got;
        
        contenidos[2] = new Documental("Cosmos", 45, "Science", "Astronomy", investigadorDocumental);
        
        // NUEVAS subclases
        contenidos[3] = new VideoMusical("Weapon of Choice", 4, "Big Beat", "Fatboy Slim", "Halfway Between the Gutter and the Stars", actorVideo);
        contenidos[4] = new AnuncioPublicitario("El Mejor Anuncio", 1, "Comedia", "Mint Mobile", "Agencia Creativa", actorAnuncio);
        

        // Mostrar los detalles de CADA contenido audiovisual
        // Gracias al polimorfismo, este bucle funciona para TODAS las clases.
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
        }
    }
}