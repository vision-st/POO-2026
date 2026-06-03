package com.duoc.fabricarobots.model.mecanismo;

/**
 * Representa el sistema de movilidad y energía de un robot de combate.
 */
public class Motor {

    private String modelo;
    private int velocidad;
    private String energia;

    public Motor(String modelo, int velocidad, String energia) {
        this.modelo = modelo;
        setVelocidad(velocidad);
        this.energia = energia;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        if (velocidad >= 0) {
            this.velocidad = velocidad;
        }
    }

    public String getEnergia() {
        return energia;
    }

    public void setEnergia(String energia) {
        this.energia = energia;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "modelo='" + modelo + '\'' +
                ", velocidad=" + velocidad +
                ", energia='" + energia + '\'' +
                '}';
    }
}
