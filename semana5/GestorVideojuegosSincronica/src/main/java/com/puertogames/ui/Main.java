package com.puertogames.ui;

import com.puertogames.data.GestorVideoJuegos;
import com.puertogames.model.VideoJuego;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[]args){

        GestorVideoJuegos gestor = new GestorVideoJuegos();

        try{
            gestor.cargarDesdeExcel("productos.xlsx");

            System.out.println(gestor.totalRegistros());

            List<VideoJuego> lista = new ArrayList<>();
            lista = gestor.listarTodos();

            for (VideoJuego juego: lista){
                System.out.println(juego);
            }

            gestor.buscarPorCodigo("VG003");

        }catch(Exception e){
            System.err.println("Error al cargar excel");
        }

    }

}
