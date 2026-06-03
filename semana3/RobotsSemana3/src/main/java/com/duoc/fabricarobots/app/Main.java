package com.duoc.fabricarobots.app;

import com.duoc.fabricarobots.model.armamentobelico.Armamento;
import com.duoc.fabricarobots.model.identidad.Rut;
import com.duoc.fabricarobots.model.mecanismo.Motor;
import com.duoc.fabricarobots.model.personas.Piloto;
import com.duoc.fabricarobots.model.robots.Robot;
import com.duoc.fabricarobots.model.ubicacion.Direccion;
import com.duoc.fabricarobots.util.RutInvalidoException;

public class Main {

    public static void main(String[] args) {
        System.out.println("==== ROBOTS DE COMBATE - SEMANA 3 ====");
        System.out.println();

        try {
            Direccion baseAtlas = new Direccion("Av. Las Industrias 101", "Valparaiso", "Region de Valparaiso");
            Direccion baseTitan = new Direccion("Calle del Acero 202", "Santiago", "Region Metropolitana");

            Rut rutValidoAtlas = new Rut("12345678-K");
            Rut rutValidoTitan = new Rut("87654321-9");

            Piloto pilotoAtlas = new Piloto("P-01", "Camila Vega", rutValidoAtlas, baseAtlas);
            Piloto pilotoTitan = new Piloto("P-02", "Diego Rojas", rutValidoTitan, baseTitan);

            Armamento laser = new Armamento("Laser MK-I", "Energia", 35);
            Armamento plasma = new Armamento("Plasma MK-II", "Plasma", 60);
            Motor motorAtlas = new Motor("SNES-001", 80, "100 unidades");
            Motor motorTitan = new Motor("SCHIN-001", 180, "200 unidades");

            Robot atlas = new Robot("R-100", "Atlas", 100, laser, motorAtlas, pilotoAtlas);
            Robot titan = new Robot("R-200", "Titan", 100, plasma, motorTitan, pilotoTitan);

            System.out.println("=== ESTADO INICIAL ===");
            System.out.println(atlas);
            System.out.println(titan);

            System.out.println();
            System.out.println("=== COMBATE DE PRUEBA ===");
            System.out.println(atlas.atacar(titan));
            System.out.println(titan.atacar(atlas));

            System.out.println();
            System.out.println("=== VERIFICACION ===");
            System.out.println("¿Atlas esta destruido? " + atlas.estaDestruido());
            System.out.println("¿Titan esta destruido? " + titan.estaDestruido());

            System.out.println();
            System.out.println("=== PRUEBA DE VALIDACION ===");
            Rut rutInvalido = new Rut("12.345.678-K");
            System.out.println(rutInvalido);
        } catch (RutInvalidoException e) {
            System.out.println("Se detecto un error de validacion: " + e.getMessage());
        }
    }
}
