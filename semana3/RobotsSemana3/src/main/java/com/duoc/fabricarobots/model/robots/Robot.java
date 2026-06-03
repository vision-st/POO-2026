package com.duoc.fabricarobots.model.robots;

import com.duoc.fabricarobots.model.armamentobelico.Armamento;
import com.duoc.fabricarobots.model.mecanismo.Motor;
import com.duoc.fabricarobots.model.personas.Piloto;
import com.duoc.fabricarobots.model.robots.acciones.Atacar;

/**
 * Representa un robot de combate dentro del sistema.
 *
 * En semana 3 se incorpora un piloto como nueva relación entre clases.
 */
public class Robot {

    private String id;
    private String nombre;
    private int vida;
    private Armamento armamento;
    private Motor motor;
    private Piloto piloto;
    private final Atacar accionAtacar;

    public Robot(String id, String nombre, int vida, Armamento armamento, Motor motor, Piloto piloto) {
        this.id = id;
        this.nombre = nombre;
        setVida(vida);
        this.armamento = armamento;
        this.motor = motor;
        this.piloto = piloto;
        this.accionAtacar = new Atacar();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = Math.max(vida, 0);
    }

    public Armamento getArmamento() {
        return armamento;
    }

    public void setArmamento(Armamento armamento) {
        this.armamento = armamento;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public String atacar(Robot enemigo) {
        int daño = accionAtacar.ataqueBasico(enemigo, armamento);
        return nombre + " atacó a " + enemigo.getNombre()
                + " usando " + armamento.getNombre()
                + " y causó " + daño + " puntos de daño.";
    }

    public void recibirDaño(int daño) {
        if (daño > 0) {
            vida = Math.max(vida - daño, 0);
        }
    }

    public boolean estaDestruido() {
        return vida <= 0;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", vida=" + vida +
                ", armamento=" + armamento +
                ", motor=" + motor +
                ", piloto=" + piloto +
                '}';
    }
}
