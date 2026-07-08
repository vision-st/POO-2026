package com.duoc.notificaciones.implementaciones;

import com.duoc.notificaciones.contratos.Notificable;

public class GestorNotificaciones {

    private Notificable servicio;

    public GestorNotificaciones(Notificable servicio) {
        this.servicio = servicio;
    }

    public void notificarUsuario(String mensaje){
        servicio.enviarNotificacion(mensaje);
    }

    public void setServicio(Notificable servicio){
        this.servicio = servicio;
    }
}
