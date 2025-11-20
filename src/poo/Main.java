package poo;

import controlador.Controlador;
import modelo.GestorContenido;
import vista.VistaTerminal;
import modelo.IRepositorioContenido;
import util.GestorArchivoCSV; // Importa la implementación concreta

public class Main {
    public static void main(String[] args) {
        // 1. Crear la implementación concreta del repositorio (GestorArchivoCSV)
        IRepositorioContenido repositorio = new GestorArchivoCSV(); 

        // 2. Crear la capa Modelo (Gestor de datos), inyectando el repositorio (DIP)
        GestorContenido modelo = new GestorContenido(repositorio);

        // 3. Crear la capa Vista (Interfaz de usuario)
        VistaTerminal vista = new VistaTerminal();

        // 4. Crear el Controlador, suministrando el Modelo y la Vista
        Controlador controlador = new Controlador(modelo, vista);

        // 5. Inicia la aplicación
        System.out.println("Sistema de Contenido Audiovisual iniciado.");
        controlador.iniciar();
    }
}