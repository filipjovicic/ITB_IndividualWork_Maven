package Assignment1;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) {

        try {
            FileInputStream inputStream = new FileInputStream("Numbers.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Numbers");
            XSSFSheet sheet1 = workbook.createSheet("Average");

            for (int i = 0; i < 3; i++) {
                XSSFRow row = sheet.getRow(i);
                double suma = 0.0;

                for (int j = 0; j < 5; j++) {
                    XSSFCell cell1 = row.getCell(j);
                    int number = (int) cell1.getNumericCellValue();
                    suma += number;
                }
                XSSFRow row1 = sheet1.createRow(i);
                XSSFCell cell2 = row1.createCell(0);
                cell2.setCellValue(suma / 5);
            }

            FileOutputStream outputStream = new FileOutputStream("Numbers.xlsx");
            workbook.write(outputStream);
            outputStream.close();

        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}