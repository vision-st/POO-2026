package com.duoc.fabricarobots.app;

import com.duoc.fabricarobots.model.armamentobelico.Armamento;
import com.duoc.fabricarobots.model.identidad.Rut;
import com.duoc.fabricarobots.model.mecanismo.Motor;
import com.duoc.fabricarobots.model.personas.Piloto;
import com.duoc.fabricarobots.model.robots.Robot;
import com.duoc.fabricarobots.model.ubicacion.Direccion;

public class Main {
    public static void main(String[] args) {

    try {
        Direccion baseAtlas = new Direccion("Av las manzanas 101", "Valpo", "VALPO");
        Direccion baseTitan = new Direccion("Av las manzanas 102", "Conchali", "Metropolitana");

        Rut rutValidoAtlas = new Rut();
        rutValidoAtlas.setNumero("12345675-K"); // aqui usamos el set con validacion
        Rut rutValidoTitan = new Rut("12345665-K");

        Piloto pilotoAtlas = new Piloto("P-01", "Camila Star", rutValidoAtlas, baseAtlas);
        Piloto pilotoTitan = new Piloto("P-01", "Camilo Star", rutValidoTitan, baseTitan);

        Armamento laser = new Armamento("Laser MK-I", "Energia", 35);
        Armamento cañonPlasma = new Armamento("Plasma MK-II", "Plasma", 60);
        Motor motorAtlas = new Motor("Snes-001", 80, "100");
        Motor motorChinese = new Motor("Schin-001", 180, "200");

        Robot atlas = new Robot("R-100", "Atlas", 100, laser, motorAtlas, pilotoAtlas);
        Robot titan = new Robot("R-200", "Titan", 100, cañonPlasma, motorChinese, pilotoTitan);

        System.out.println("=== ESTADO INICIAL ===");
        System.out.println(atlas);
        System.out.println(titan);

        System.out.println();
        System.out.println("=== COMBATE DE PRUEBA ===");
        System.out.println(atlas.atacar(titan));
        System.out.println(titan.atacar(atlas));

        System.out.println("=== VERIFICACION ===");
        System.out.println("¿Atlas esta destruido?" + atlas.estaDestruido());
        System.out.println("¿Titan esta destruido?" + titan.estaDestruido());
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    }
}