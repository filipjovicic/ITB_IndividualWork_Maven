package Assignment1;

import com.github.javafaker.Faker;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


/*
Napraviti novi maven projekat. Dodati dependencies za apache poi i faker ,
Rucno kreirati xlsx fajl koji sadrzii 5 imena.
U ovom koraku rucno pisemo u excel ne kroz kod.
Kroz kod treba da procitamo, stavimo u niz i ispisemo tih 5 imena,
a zatim dodati jos 5 imena koristeci Faker u isti niz.
Nakon toga potrebno je sva imena iz liste upisati u novi sheet u istoj
excel tabeli.
Primer: Pocetan izgled excel sheet-a: Bilja, Milos, Marko, Ivana, Vladimir.
Izgled novog sheet-a: Bilja, Milos, Marko, Ivana, Vladimir
(vrednosti iz prvog sheet-a), Suzana, Marina, Ivan, Aleksandar, Dusan
(imena kreirana uz pomoc Faker-a).
 */
public class Task2 {
    public static void main(String[] args) {

        try {
            FileInputStream inputStream = new FileInputStream("Names.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            XSSFSheet sheet1 = workbook.createSheet("List of names");
            Faker faker = new Faker();
            ArrayList<String> names = new ArrayList<>();

            for (int j = 0; j < 5; j++) {
                XSSFRow row = sheet.getRow(j);
                XSSFCell cell = row.getCell(0);
                String name = cell.getStringCellValue();
                System.out.println(name);
                names.add(name);
            }

            for (int i = 0; i < 5; i++) {
                String fakeName = faker.name().firstName();
                names.add(fakeName);
            }

            System.out.println(names);

            for (int k = 0; k < names.size(); k++) {
                XSSFRow row1 = sheet1.createRow(k);
                XSSFCell cell1 = row1.createCell(0);
                cell1.setCellValue(names.get(k));
            }

            FileOutputStream outputStream = new FileOutputStream("Names.xlsx");
            workbook.write(outputStream);
            outputStream.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }

    }
}