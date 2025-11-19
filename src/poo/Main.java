package poo;

import controlador.Controlador;
import modelo.GestorContenido;
import vista.VistaTerminal;

public class Main {
    public static void main(String[] args) {
        // 1. Inicializa las capas del Modelo y la Vista
        GestorContenido modelo = new GestorContenido();
        VistaTerminal vista = new VistaTerminal();

        // 2. Crea el Controlador, pasando las dependencias (DIP)
        Controlador controlador = new Controlador(modelo, vista);

        // 3. Inicia la aplicación
        System.out.println("Sistema de Contenido Audiovisual iniciado.");
        controlador.ejecutar();
    }
}