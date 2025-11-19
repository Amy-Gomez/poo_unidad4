package modelo;

import java.util.List;

// Interfaz que define el contrato de persistencia para ContenidoAudiovisual.
public interface IRepositorioContenido {
    
    // Carga todos los contenidos desde la fuente de datos.
    List<ContenidoAudiovisual> cargarContenidos();

    // Guarda la lista completa de contenidos en la fuente de datos.
    boolean guardarContenidos(List<ContenidoAudiovisual> contenidos);
}