package com.duoc.notificaciones.implementaciones;

import com.duoc.notificaciones.contratos.Notificable;

public class InstagramService implements Notificable {
    /**
     * Metodo que deben implementar todas las clases notificadoras.
     *
     * @param mensaje
     */
    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviando MENSAJE INSTA ::::> " + mensaje);
    }
}
