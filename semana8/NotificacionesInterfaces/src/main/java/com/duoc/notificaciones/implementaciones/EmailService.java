package com.duoc.notificaciones.implementaciones;

import com.duoc.notificaciones.contratos.Notificable;

public class EmailService implements Notificable {

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviando EMAIL ::::> " + mensaje);
    }
}
