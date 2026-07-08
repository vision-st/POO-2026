package com.duoc.notificaciones.implementaciones;

import com.duoc.notificaciones.contratos.Notificable;

public class SmsService implements Notificable {

    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviando SMS ::::> " + mensaje);
    }
}
