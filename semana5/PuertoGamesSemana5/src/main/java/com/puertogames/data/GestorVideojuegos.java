package com.puertogames.data;

import com.puertogames.model.Videojuego;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestorVideojuegos {
    private static final int COLUMNAS_ESPERADAS = 6;

    private final List<Videojuego> videojuegos;
    private final LectorXlsxSimple lectorXlsxSimple;

    public GestorVideojuegos() {
        this.videojuegos = new ArrayList<>();
        this.lectorXlsxSimple = new LectorXlsxSimple();
    }

    public void cargarDesdeExcel(String resourcePath) throws IOException {
        videojuegos.clear();
        List<List<String>> filas = lectorXlsxSimple.leerFilas(resourcePath);
        boolean firstRow = true;

        for (List<String> fila : filas) {
            if (firstRow) {
                firstRow = false;
                continue;
            }
            if (fila.isEmpty() || fila.stream().allMatch(String::isBlank)) {
                continue;
            }

            videojuegos.add(new Videojuego(
                    getValue(fila, 0),
                    getValue(fila, 1),
                    getValue(fila, 2),
                    getValue(fila, 3),
                    parseDouble(getValue(fila, 4)),
                    parseInt(getValue(fila, 5))
            ));
        }
    }

    public List<Videojuego> listarTodos() {
        return new ArrayList<>(videojuegos);
    }

    public Optional<Videojuego> buscarPorCodigo(String codigo) {
        return videojuegos.stream()
                .filter(videojuego -> videojuego.getCodigo().equalsIgnoreCase(codigo))
                .findFirst();
    }

    public List<Videojuego> filtrarPorGenero(String genero) {
        return videojuegos.stream()
                .filter(videojuego -> videojuego.getGenero().equalsIgnoreCase(genero))
                .toList();
    }

    public int totalRegistros() {
        return videojuegos.size();
    }

    private String getValue(List<String> fila, int index) {
        if (index < 0 || index >= COLUMNAS_ESPERADAS || index >= fila.size()) {
            return "";
        }
        return fila.get(index).trim();
    }

    private double parseDouble(String value) {
        return value.isBlank() ? 0.0 : Double.parseDouble(value);
    }

    private int parseInt(String value) {
        return value.isBlank() ? 0 : (int) Double.parseDouble(value);
    }
}
