package ui;

import data.GestorBiblioteca;

public class MainGrafico {
    public static void main(String[] args) {
        GestorBiblioteca gestor = new GestorBiblioteca();
        gestor.cargarDatosDemo();
        BibliotecaFrame.abrir(gestor);
    }
}
