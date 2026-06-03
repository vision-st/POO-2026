package com.duoc.fabricarobots.model.acciones;

import com.duoc.fabricarobots.model.armamentobelico.Armamento;
import com.duoc.fabricarobots.model.robots.Robot;

public class MecanismoAtaque {

    public int ataqueBasico(Robot enemigo, Armamento armamento){
        int daño = armamento.getDaño();
        enemigo.recibirDaño(daño);
        return daño;
    }

}
