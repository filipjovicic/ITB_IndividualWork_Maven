package Assignment4.Type1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {

    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("confirmPassword");
    private By invalidEmailMessage = By.xpath("//div[contains(text(), 'Valid email')]");


    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void enterDataToNameField(String text){
        getDriver().findElement(nameField).sendKeys(text);
    }
    public void enterDataToEmailField(String text){
        getDriver().findElement(emailField).sendKeys(text);
    }

    public void enterDataToPasswordField(String text){
        getDriver().findElement(passwordField).sendKeys(text);
    }

    public void enterDataToConfirmPasswordField(String text){
        getDriver().findElement(confirmPasswordField).sendKeys(text);
    }

    public void open(){
        getDriver().get("https://vue-demo.daniel-avellaneda.com/signup");
    }
}
