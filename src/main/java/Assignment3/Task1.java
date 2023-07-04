package Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Task1 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://Users//jovic//Documents//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @BeforeMethod
    public void beforeEachTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/signup");
        driver.manage().window().maximize();
    }


    @Test
    public void verifyUrlContainsSignUp() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void verifyTypeContainsEmail() {
        WebElement emailField = driver.findElement(By.id("email"));
        String email = "email";
        Assert.assertTrue(emailField.getAttribute("type").equals(email));
    }

    @Test
    public void verifyTypeContainsPassword() {
        WebElement passwordField = driver.findElement(By.id("password"));
        String password = "password";
        Assert.assertTrue(passwordField.getAttribute("type").equals(password));
    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithInvalidEmail() {

        WebElement nameField = driver.findElement(By.id("name"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));

        nameField.sendKeys("Marko");
        emailField.sendKeys("marko.com");
        passwordField.sendKeys("12345");
        confirmPasswordField.sendKeys("12345");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement invalidEmailMessage = driver.findElement(By.xpath("//div[contains(text(), 'Valid email')]"));
        Assert.assertTrue(invalidEmailMessage.isDisplayed());
    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithLessThanFiveCharacters() {

        WebElement nameField = driver.findElement(By.id("name"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));

        nameField.sendKeys("Marko");
        emailField.sendKeys("marko@example.com");
        passwordField.sendKeys("1234");
        confirmPasswordField.sendKeys("12345");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement invalidNoCharMessage = driver.findElement(By.xpath
                ("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[3]/span/div/div/div[2]/div/div/div"));
        Assert.assertTrue(invalidNoCharMessage.isDisplayed());
    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithMissingInfo() {

        WebElement nameField = driver.findElement(By.id("name"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));

        nameField.sendKeys("");
        emailField.sendKeys("marko@example.com");
        passwordField.sendKeys("12345");
        confirmPasswordField.sendKeys("12345");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement fieldRequiredMessage = driver.findElement(By.xpath
                ("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[1]/span/div/div/div[2]/div/div/div"));
        Assert.assertTrue(fieldRequiredMessage.isDisplayed());
    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithoutMatchingPasswords() {

        WebElement nameField = driver.findElement(By.id("name"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));

        nameField.sendKeys("Marko");
        emailField.sendKeys("marko@example.com");
        passwordField.sendKeys("678910");
        confirmPasswordField.sendKeys("12345");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement passwordMatchMessage = driver.findElement(By.xpath("//div[contains(text(), 'Passwords')]"));
        Assert.assertTrue(passwordMatchMessage.isDisplayed());
    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithBlankPassword() {

        WebElement nameField = driver.findElement(By.id("name"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));

        nameField.sendKeys("Marko");
        emailField.sendKeys("marko@example.com");
        passwordField.sendKeys("     ");
        confirmPasswordField.sendKeys("     ");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement fieldRequiredMessage = driver.findElement(By.xpath
                ("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[3]/span/div/div/div[2]/div/div/div"));
        Assert.assertTrue(fieldRequiredMessage.isDisplayed());
    }

    @AfterClass
    public void cleanUp() {
        driver.close();
    }

}
