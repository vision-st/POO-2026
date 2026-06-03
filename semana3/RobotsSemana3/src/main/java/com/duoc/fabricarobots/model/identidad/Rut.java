package com.duoc.fabricarobots.model.identidad;

import com.duoc.fabricarobots.util.RutInvalidoException;

/**
 * Representa el RUT de un piloto.
 *
 * La clase encapsula la lógica de validación para reutilizarla en distintas
 * entidades sin duplicar código.
 */
public class Rut {

    private String numero;

    public Rut(String numero) throws RutInvalidoException {
        setNumero(numero);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws RutInvalidoException {
        if (numero == null || !numero.matches("[0-9]+-[0-9kK]")) {
            throw new RutInvalidoException(
                    "El RUT '" + numero + "' no tiene un formato válido. Debe seguir el patrón XXXXXXXX-Y."
            );
        }
        this.numero = numero.toUpperCase();
    }

    @Override
    public String toString() {
        return "RUT: " + numero;
    }
}
