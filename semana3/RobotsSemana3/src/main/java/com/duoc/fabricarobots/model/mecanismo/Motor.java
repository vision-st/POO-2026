package com.duoc.fabricarobots.model.mecanismo;

/**
 * Representa el sistema de movilidad y energia de un robot de combate
 *
 * El motor define el modelo, la velocidad y la energia disponible para
 * el funcionamiento
 */
public class Motor {

    private String modelo;
    private int velocidad;
    private String energia;


    /**
     * Constructor de la clase Motor
     * @param modelo modelo o nombre tecnico del motor
     * @param velocidad velocidad maxima del motor
     * @param energia energia disponible del motor
     */
    public Motor(String modelo, int velocidad, String energia) {
        this.modelo = modelo;
        this.velocidad = velocidad;
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
        if(velocidad >= 0){
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
