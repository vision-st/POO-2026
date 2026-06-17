package cl.duoc.poi.ruta;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class LectorExcelRuta {
    public static void main(String[] args) {
        Path ruta = args.length > 0
                ? Path.of(args[0])
                : Path.of("datos/productos.xlsx");

        System.out.println("Intentando leer: " + ruta.toAbsolutePath());

        if (!Files.exists(ruta)) {
            System.out.println("No existe el archivo en la ruta indicada.");
            return;
        }

        try (InputStream inputStream = Files.newInputStream(ruta);
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0);
            System.out.println("=== Lectura desde ruta externa ===");
            for (Row row : sheet) {
                StringBuilder linea = new StringBuilder();
                for (Cell cell : row) {
                    linea.append(cell.toString()).append(" | ");
                }
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el Excel: " + e.getMessage());
        }
    }
}
