package poo;

import controlador.Controlador;
import modelo.GestorContenido;
import util.GestorArchivoCSV;
import vista.VistaTerminal;

public class PruebaAudioVisual {

    public static void main(String[] args) {
        System.out.println("--- INICIANDO SISTEMA (MVC) ---");
        
        // 1. Repositorio
        GestorArchivoCSV repositorio = new GestorArchivoCSV();
        
        // 2. Modelo
        GestorContenido modelo = new GestorContenido(repositorio);
        
        // 3. Vista
        VistaTerminal vista = new VistaTerminal();
        
        // 4. Controlador
        Controlador controlador = new Controlador(modelo, vista);
        
        // 5. Ejecutar
        controlador.iniciar(); 
    }
}