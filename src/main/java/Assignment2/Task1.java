package Assignment2;


/*
Napraviti maven projekat i dodati selenium dependency i dependency za Faker.
U Mainu preko selenijuma otici na https://demoqa.com/text-box.
Zadatak je da popunite sva polja (Full Name, email, Current Address, Permanent Address) i da kliknete submit koristeci Faker.
Uporediti da li u rezultatu (ispod submit), full name i email su isti kao uneseni pre submita, da nije doslo do izmene.
 Upisati odgovarajucu poruku ako su isti ili ako se razlikuju podaci.
 */

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C://Users//jovic//Documents//chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        Faker faker = new Faker();

        String fullName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String currentAddress = faker.address().fullAddress();
        String permanentAddress = faker.address().fullAddress();

        driver.get("https://demoqa.com/text-box");

        driver.manage().window().maximize();

        WebElement fullNameField = driver.findElement(By.id("userName"));
        fullNameField.sendKeys(fullName);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        emailField.sendKeys(email);

        WebElement currentAddressField = driver.findElement(By.id("currentAddress"));
        currentAddressField.sendKeys(currentAddress);

        WebElement permanentAddressField = driver.findElement(By.id("permanentAddress"));
        permanentAddressField.sendKeys(permanentAddress);

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement submitField = driver.findElement(By.id("output"));

        if (submitField.getText().contains(fullName) && submitField.getText().contains(email)
                && submitField.getText().contains(currentAddress) && submitField.getText().contains(permanentAddress)){
            System.out.println("Test passed. User information submitted successfully");
        } else {
            System.out.println("Test failed! Information missing!");
        }

        driver.close();




    }
}
