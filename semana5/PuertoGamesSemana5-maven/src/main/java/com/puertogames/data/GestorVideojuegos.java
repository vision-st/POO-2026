package com.puertogames.data;

import com.puertogames.model.Videojuego;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestorVideojuegos {
    private final List<Videojuego> videojuegos;

    public GestorVideojuegos() {
        this.videojuegos = new ArrayList<>();
    }

    public void cargarDesdeExcel(String resourcePath) throws IOException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new IOException("No se encontro el archivo: " + resourcePath);
            }

            try (Workbook workbook = new XSSFWorkbook(inputStream)) {
                Sheet sheet = workbook.getSheetAt(0);
                boolean firstRow = true;

                for (Row row : sheet) {
                    if (firstRow) {
                        firstRow = false;
                        continue;
                    }

                    if (isEmptyRow(row)) {
                        continue;
                    }

                    videojuegos.add(new Videojuego(
                            getStringValue(row.getCell(0)),
                            getStringValue(row.getCell(1)),
                            getStringValue(row.getCell(2)),
                            getStringValue(row.getCell(3)),
                            getNumericValue(row.getCell(4)),
                            (int) getNumericValue(row.getCell(5))
                    ));
                }
            }
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

    private boolean isEmptyRow(Row row) {
        for (int i = 0; i < 6; i++) {
            Cell cell = row.getCell(i);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    private String getStringValue(Cell cell) {
        return cell == null ? "" : cell.toString().trim();
    }

    private double getNumericValue(Cell cell) {
        if (cell == null) {
            return 0;
        }
        return cell.getCellType() == CellType.NUMERIC
                ? cell.getNumericCellValue()
                : Double.parseDouble(cell.toString().trim());
    }
}
