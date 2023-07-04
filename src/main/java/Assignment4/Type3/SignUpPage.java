package Assignment4.Type3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {

    @FindBy(name = "firstname")
    WebElement firstName;

    @FindBy(id = "name")
    WebElement nameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "confirmPassword")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//div[contains(text(), 'Valid email')]")
    WebElement invalidEmailMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[3]/span/div/div/div[2]/div/div/div")
    WebElement lessThanFiveCharactersErrorMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[1]/span/div/div/div[2]/div/div/div")
    WebElement nameFieldRequiredErrorMessage;

    @FindBy(xpath = "//div[contains(text(), 'Passwords')]")
    WebElement passwordMustMatchErrorMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[3]/span/div/div/div[2]/div/div/div")
    WebElement passwordFieldRequiredErrorMessage;


    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(getDriver(), this);
    }

    public void enterDataToNameField(String text){
        nameField.sendKeys(text);
    }
    public void enterDataToEmailField(String text){
        emailField.sendKeys(text);
    }

    public void enterDataToPasswordField(String text){
        passwordField.sendKeys(text);
    }

    public void enterDataToConfirmPasswordField(String text){
        confirmPasswordField.sendKeys(text);
    }

    public void open(){
        getDriver().get("https://vue-demo.daniel-avellaneda.com/signup");

    }
}
