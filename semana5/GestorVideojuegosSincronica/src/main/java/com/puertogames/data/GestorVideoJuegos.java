package com.puertogames.data;

import com.puertogames.model.VideoJuego;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class GestorVideoJuegos {

    private final List<VideoJuego> videoJuegos;

    public GestorVideoJuegos() {
        this.videoJuegos = new ArrayList<>();
    }

    public void cargarDesdeExcel(String resourcePath) throws IOException {
        try(InputStream inputStream =  GestorVideoJuegos.class.getClassLoader().getResourceAsStream(resourcePath)){
            if(inputStream == null){
                System.out.println("No se encontro el archivo en resources: " + resourcePath);
            }
            try(Workbook workbook = new XSSFWorkbook(inputStream)){
                Sheet hoja = workbook.getSheetAt(0);
                System.out.println("===Lectura desde resources===");
                boolean primeraFila = true;
                for(Row row: hoja){
                    if(primeraFila){
                        primeraFila = false;
                        continue;
                    }
                    if(isEmptyRow(row)){
                        continue;
                    }
                    videoJuegos.add(new VideoJuego(
                            getStringValue(row.getCell(0)),
                            getStringValue(row.getCell(1)),
                            getStringValue(row.getCell(2)),
                            getStringValue(row.getCell(3)),
                            getNumericValue(row.getCell(4)),
                            (int) getNumericValue(row.getCell(5))
                    ));
                }
            }
        }catch (IOException ex){
            System.out.println("Error al leer excel: " + ex.getMessage());
        }
    }

    public List<VideoJuego> listarTodos(){
        return new ArrayList<>(videoJuegos);
    }

    public Optional<VideoJuego> buscarPorCodigo(String codigo){
        return videoJuegos.stream()
                .filter(videoJuego -> videoJuego.getCodigo().equalsIgnoreCase(codigo))
                .findFirst();
    }

    public List<VideoJuego> filtrarPorGenero(String genero){
        return videoJuegos.stream().filter(videoJuego -> videoJuego.getGenero().equalsIgnoreCase(genero))
                .toList();
    }



    public int totalRegistros(){
        return videoJuegos.size();
    }

    private boolean isEmptyRow(Row row){
        for(int i = 0; i < 6; i++){
            Cell cell = row.getCell(i);
                if(cell != null && cell.getCellType() != CellType.BLANK){
                    return false;
                }
            }
        return true;
    }


    private String getStringValue(Cell cell){
        return cell == null ? "" : cell.toString().trim();
    }

    private double getNumericValue(Cell cell){
        if(cell == null){
            return 0;
        }

        return cell.getCellType() == CellType.NUMERIC ? cell.getNumericCellValue() : Double.parseDouble(cell.toString().trim());
    }



}
