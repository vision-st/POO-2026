package com.duoc.fabricarobots.model.robots;


import com.duoc.fabricarobots.model.acciones.MecanismoAtaque;
import com.duoc.fabricarobots.model.armamentobelico.Armamento;
import com.duoc.fabricarobots.model.mecanismo.Motor;
import com.duoc.fabricarobots.model.personas.Piloto;


/**
 * Representa un robot de combate dentro del sistema
 *
 * ... coloquen una descripción impresionante.
 */
public class Robot {

    //caracteristicas de la clase
    private String id;
    private String nombre;
    private int vida;
    private Armamento armamento;
    private Motor motor;
    private Piloto piloto;
    private final MecanismoAtaque atacar;

    public Robot(String id, String nombre, int vida, Armamento armamento, Motor motor, Piloto piloto) {
        this.id = id;
        this.nombre = nombre;
        this.vida = vida;
        this.armamento = armamento;
        this.motor = motor;
        this.piloto = piloto;
        this.atacar = new MecanismoAtaque(); //---> RELACION DE COMPOSICIÓN FUERTE
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
        this.vida = vida;
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
        int daño = atacar.ataqueBasico(enemigo, armamento);
        return nombre + " ataco a " + enemigo.getNombre() + " usando " + armamento.getNombre() + " y causo " + daño + " puntos de daño";
    }

    public void recibirDaño(int daño) {
        if(daño >0){
            this.vida = vida - daño;
        }

        if(daño < 0){
            this.vida = 0;
        }
    }

    public boolean estaDestruido(){
        return this.vida == 0;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", vida=" + vida +
                ", armamento=" + armamento +
                ", motor=" + motor +
                '}';
    }
}