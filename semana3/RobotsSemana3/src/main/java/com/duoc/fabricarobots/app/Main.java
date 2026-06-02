package com.duoc.fabricarobots.app;

import com.duoc.fabricarobots.model.armamentobelico.Armamento;
import com.duoc.fabricarobots.model.mecanismo.Motor;
import com.duoc.fabricarobots.model.robots.Robot;

public class Main {
    public static void main(String[] args) {

        System.out.println("==== ROBOTS DE COMBATE ====");
        System.out.println();

        Armamento laser = new Armamento("Laser MK-I", "Energia", 35);
        Armamento cañonPlasma = new Armamento("Plasma MK-II", "Plasma", 60);
        Armamento cañonPiedras = new Armamento("Piedras MK-III", "Piedras", 10);
        Motor motorAtlas = new Motor("Snes-001", 80, "100");
        Motor motorChinese = new Motor("Schin-001", 180, "200");

        Robot atlas = new Robot("R-100", "Atlas", 100, laser, motorAtlas);
        Robot titan = new Robot("R-200", "Titan", 100, cañonPiedras, motorChinese);

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

    }
}
