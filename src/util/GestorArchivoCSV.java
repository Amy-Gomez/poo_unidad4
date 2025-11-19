package util;

import modelo.ContenidoAudiovisual;
import modelo.IRepositorioContenido;
import java.util.List;
import java.util.ArrayList;

// Implementación concreta del repositorio usando archivos CSV.
public class GestorArchivoCSV implements IRepositorioContenido {

    private static final String NOMBRE_ARCHIVO = "contenidos.csv";

    @Override
    public List<ContenidoAudiovisual> cargarContenidos() {
        System.out.println(">> REPOSITORIO CSV: Iniciando carga desde " + NOMBRE_ARCHIVO + "...");
        
        // Tarea: Implementar la lógica de lectura y parseo del archivo CSV aquí.
        // Por ahora, devuelve una lista vacía para que GestorContenido inicialice datos dummy.
        
        System.out.println(">> REPOSITORIO CSV: Lectura finalizada. (PENDIENTE)");
        return new ArrayList<>(); 
    }

    @Override
    public boolean guardarContenidos(List<ContenidoAudiovisual> contenidos) {
        System.out.println(">> REPOSITORIO CSV: Guardando " + contenidos.size() + " contenidos a " + NOMBRE_ARCHIVO + "...");
        
        // Tarea: Implementar la lógica de escritura y formateo al archivo CSV aquí.
        
        System.out.println(">> REPOSITORIO CSV: Guardado finalizado. (PENDIENTE)");
        return true; 
    }
}