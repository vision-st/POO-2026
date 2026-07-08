package ui;

import data.GestorBiblioteca;
import util.Separador;

public class Main {
    public static void main(String[] args) {
        GestorBiblioteca gestor = new GestorBiblioteca();
        gestor.cargarDatosDemo();

        Separador.titulo("CATALOGO GENERAL");
        gestor.mostrarCatalogo();

        Separador.titulo("POLIMORFISMO CON INTERFACES");
        gestor.procesarPrestamos();
        gestor.procesarDescargas();
        gestor.reproducirMuestras();

        Separador.titulo("VALIDACION DE TIPOS CON INSTANCEOF");
        gestor.mostrarTiposReales();

        Separador.titulo("CIERRE");
        System.out.println("Este proyecto integra herencia, polimorfismo, interfaces, colecciones genericas e instanceof.");
        System.out.println("O sea, justamente lo que pedia semana 8, pero con un negocio distinto y sin copiar PuertoGames con otro peinado.");
    }
}
