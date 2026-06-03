package com.duoc.fabricarobots.model.identidad;

import com.duoc.fabricarobots.exceptions.RutinvalidoException;

public class Rut {

    private String numero;

    public Rut(String numero) {
        this.numero = numero;
    }

    public String getNumero(){
        return numero;
    }

    public Rut(){}

    public void setNumero(String numero) throws RutinvalidoException {
        if(numero == null || !numero.matches("[0-9]+-[0-9kK]")){ //16452226-K
            throw new RutinvalidoException("El RUT " + numero + "no tiene un formato valido, debe seguir el patron XXXXXXXX-X");
        }
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "RUT: " + numero;
    }
}
