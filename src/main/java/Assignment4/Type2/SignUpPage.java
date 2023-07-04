package Assignment4.Type2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {

    private WebElement nameField;
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement confirmPasswordField;
    private WebElement invalidEmailMessage;
    private WebElement lessThanFiveCharactersErrorMessage;
    private WebElement nameFieldRequiredErrorMessage;
    private WebElement passwordMustMatchErrorMessage;
    private WebElement passwordFieldRequiredErrorMessage;


    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNameField(){
        nameField = getDriver().findElement(By.id("name"));
        return nameField;
    }

    public WebElement getEmailField(){
        emailField = getDriver().findElement(By.id("email"));
        return emailField;
    }

    public WebElement getPasswordField(){
        passwordField = getDriver().findElement(By.id("password"));
        return passwordField;
    }

    public WebElement getConfirmPasswordField(){
        confirmPasswordField = getDriver().findElement(By.id("confirmPassword"));
        return confirmPasswordField;
    }

    public WebElement getInvalidEmailMessage(){
        invalidEmailMessage = getDriver().findElement(By.xpath("//div[contains(text(), 'Valid email')]"));
        return invalidEmailMessage;
    }

    public WebElement getLessThanFiveCharactersErrorMessage(){
        lessThanFiveCharactersErrorMessage =  getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[3]/span/div/div/div[2]/div/div/div"));
        return lessThanFiveCharactersErrorMessage;
    }

    public WebElement getNameFieldRequiredErrorMessage(){
        nameFieldRequiredErrorMessage =  getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[1]/span/div/div/div[2]/div/div/div"));
        return nameFieldRequiredErrorMessage;
    }



    public WebElement getPasswordMustMatchErrorMessage(){
        passwordMustMatchErrorMessage =  getDriver().findElement(By.xpath("//div[contains(text(), 'Passwords')]"));
        return passwordMustMatchErrorMessage;
    }


    public WebElement getPasswordFieldRequiredErrorMessage(){
        passwordFieldRequiredErrorMessage = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[3]/span/div/div/div[2]/div/div/div"));
        return passwordFieldRequiredErrorMessage;
    }


    public SignUpPage enterDataToNameField(String text){
        getNameField().sendKeys(text);
        return this;
    }
    public SignUpPage enterDataToEmailField(String text){
        getEmailField().sendKeys(text);
        return this;
    }

    public SignUpPage enterDataToPasswordField(String text){
        getPasswordField().sendKeys(text);
        return this;
    }

    public SignUpPage enterDataToConfirmPasswordField(String text){
        getConfirmPasswordField().sendKeys(text);
        return this;
    }

    public SignUpPage open(){
        getDriver().get("https://vue-demo.daniel-avellaneda.com/signup");
        return this;
    }
}
