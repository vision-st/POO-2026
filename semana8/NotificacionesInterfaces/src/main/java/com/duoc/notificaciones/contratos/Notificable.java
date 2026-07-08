package com.duoc.notificaciones.contratos;

/**
 * Interface que define el contrato para cualquier servicio
 * que sea capaz de enviar una notificacion.
 */
public interface Notificable {

    /**
     * Metodo que deben implementar todas las clases notificadoras.
     * @param mensaje
     */
    void enviarNotificacion(String mensaje);
}
