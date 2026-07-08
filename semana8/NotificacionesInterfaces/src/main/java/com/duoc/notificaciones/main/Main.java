package com.duoc.notificaciones.main;

import com.duoc.notificaciones.contratos.Notificable;
import com.duoc.notificaciones.implementaciones.*;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[]args){

        System.out.println("==== SISTEMA DE NOTIFICACIONES CON INTERFACES ====");
        System.out.println("");

        Notificable email = new EmailService();
        Notificable sms = new SmsService();
        Notificable whatsapp = new WhatsAppService();
        Notificable insta = new InstagramService();

        GestorNotificaciones gestor = new GestorNotificaciones(email);
        System.out.println("1. notificacion usando EmailService: ");
        gestor.notificarUsuario("Bienvenido al sistema");

        System.out.println("");

        System.out.println("2. Cambiando al servicio SMS");
        gestor.setServicio(sms);
        gestor.notificarUsuario("Tu codigo SMS es el 124323");
        System.out.println("3. Cambiando al servicio a WS");
        gestor.setServicio(whatsapp);
        gestor.notificarUsuario("Tienes un nuevo sticker");
        System.out.println("4. Cambiando al servicio a INSTA");
        gestor.setServicio(insta);
        gestor.notificarUsuario("Tienes un nuevo MENSAJE en tu foto");
        System.out.println("");
        System.out.println("==== FIN SISTEMA DE NOTIFICACIONES CON INTERFACES ====");
    }
}
