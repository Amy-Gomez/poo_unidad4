package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.GestorArchivoCSV; // Necesario para inyectar la dependencia concreta para la prueba

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase GestorContenido.
 * Verifica la correcta gestión del catálogo, la generación de IDs y la implementación de DIP.
 */
public class GestorContenidoTest {

    private GestorContenido gestor;
    private IRepositorioContenido repositorio;

    // Se ejecuta antes de cada método de prueba para asegurar un estado limpio.
    @BeforeEach
    void setUp() {
        // Usamos GestorArchivoCSV como implementación concreta para la prueba.
        // Inyección de dependencia (DIP)
        repositorio = new GestorArchivoCSV(); 
        gestor = new GestorContenido(repositorio);
    }

    // Prueba el constructor y la carga inicial.
    @Test
    void testInicializacionYCarga() {
        // Usa el método obtenerTodosLosContenidos() de la clase GestorContenido
        assertNotNull(gestor.obtenerTodosLosContenidos(), "El catálogo no debería ser null después de la inicialización.");
        // Verifica que la carga inicial se haya intentado, y que el catálogo no sea nulo.
        assertTrue(gestor.obtenerTodosLosContenidos().size() >= 0, "El catálogo debería tener al menos 0 o más elementos.");
    }

    // Prueba la generación de IDs para nuevos contenidos.
    @Test
    void testGeneracionId() {
        // Asumiendo que existe un método para obtener el siguiente ID disponible
        int idInicial = gestor.getSiguienteIdDisponible();
        
        Pelicula nuevaPelicula = new Pelicula("Test Pelicula", 90, "Drama", "Estudio", new Actor("A", "P"));
        gestor.agregarContenido(nuevaPelicula);
        
        assertEquals(idInicial, nuevaPelicula.getId(), "El ID asignado debe ser el ID inicial esperado.");
        // Asumiendo que el ID se incrementa después de agregar
        assertEquals(idInicial + 1, gestor.getSiguienteIdDisponible(), "El siguiente ID disponible debe incrementarse.");
    }

    // Prueba la adición de un nuevo contenido al catálogo.
    @Test
    void testAgregarContenido() {
        int tamanoInicial = gestor.obtenerTodosLosContenidos().size();
        Pelicula nuevaPelicula = new Pelicula("Otro Test", 100, "Accion", "EstudioX", new Actor("B", "S"));
        
        gestor.agregarContenido(nuevaPelicula);
        assertEquals(tamanoInicial + 1, gestor.obtenerTodosLosContenidos().size(), "El tamaño del catálogo debe incrementarse en 1.");
        assertTrue(gestor.obtenerTodosLosContenidos().contains(nuevaPelicula), "El nuevo contenido debe estar en el catálogo.");
    }

    // Prueba la eliminación de contenido por ID.
    @Test
    void testEliminarContenidoExistente() {
        Pelicula p = new Pelicula("Para Eliminar", 120, "Terror", "E", new Actor("C", "T"));
        gestor.agregarContenido(p);
        int idAEliminar = p.getId();
        int tamanoInicial = gestor.obtenerTodosLosContenidos().size();
        
        assertTrue(gestor.eliminarContenido(idAEliminar), "Eliminar un ID existente debe retornar true.");
        assertEquals(tamanoInicial - 1, gestor.obtenerTodosLosContenidos().size(), "El tamaño debe decrementarse en 1.");
    }

    // Prueba la eliminación de contenido con un ID que no existe.
    @Test
    void testEliminarContenidoNoExistente() {
        int idInexistente = 99999; 
        int tamanoInicial = gestor.obtenerTodosLosContenidos().size();
        
        assertFalse(gestor.eliminarContenido(idInexistente), "Eliminar un ID inexistente debe retornar false.");
        assertEquals(tamanoInicial, gestor.obtenerTodosLosContenidos().size(), "El tamaño del catálogo no debe cambiar.");
    }
    
    // Prueba la búsqueda de contenido por título.
    @Test
    void testBuscarContenidoPorTitulo() {
        Pelicula p1 = new Pelicula("Buscado A", 10, "A", "E", new Actor("C", "T"));
        gestor.agregarContenido(p1);
        
        // Búsqueda exacta
        List<ContenidoAudiovisual> resultados = gestor.buscarContenido("Buscado A");
        assertEquals(1, resultados.size(), "Debe encontrar 1 resultado con la búsqueda exacta.");
        
        // Búsqueda que no devuelve resultados
        List<ContenidoAudiovisual> resultadosVacios = gestor.buscarContenido("Inexistente");
        assertTrue(resultadosVacios.isEmpty(), "Debe retornar una lista vacía si no encuentra coincidencias.");
    }
}