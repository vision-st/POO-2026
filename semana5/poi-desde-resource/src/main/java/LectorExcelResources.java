import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;

public class LectorExcelResources {

    public static void main(String[]args){
        String archivo = "productos.xlsx";

        try(InputStream inputStream =  LectorExcelResources.class.getClassLoader().getResourceAsStream(archivo)){

            if(inputStream == null){
                System.out.println("No se encontro el archivo en resources: " + archivo);
            }

            try(Workbook workbook = new XSSFWorkbook(inputStream)){
                Sheet hoja = workbook.getSheetAt(0);
                System.out.println("===Lectura desde resources===");

                for(Row row: hoja){
                    StringBuilder linea = new StringBuilder();
                    for(Cell cell: row){
                        linea.append(cell.toString()).append(" | ");
                    }
                    System.out.println(linea);
                }
            }
        }catch (IOException ex){
            System.out.println("Error al leer excel: " + ex.getMessage());
        }
    }
}
