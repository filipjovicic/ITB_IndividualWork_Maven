package Assignment4.Type1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignUpTest extends BaseTest {

    @Test
    public void verifyUrlContainsSignup() {
        getSignUpPage().open();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/signup"));
    }

    @Test
    public void verifyTypeContainsEmail() {
        String email = "email";
        getSignUpPage().open();
        Assert.assertTrue(getDriver().findElement(By.id("email")).getAttribute("type").equals(email));
    }

    @Test
    public void verifyTypeContainsPassword() {
        String password = "password";
        getSignUpPage().open();
        Assert.assertTrue(getDriver().findElement(By.id("password")).getAttribute("type").equals(password));
    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithInvalidEmail() {

        getSignUpPage().open();
        getSignUpPage().enterDataToNameField("Marko");
        getSignUpPage().enterDataToEmailField("marko.com");
        getSignUpPage().enterDataToPasswordField("12345");
        getSignUpPage().enterDataToConfirmPasswordField("12345");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(getDriver().findElement(By.xpath("//div[contains(text(), 'Valid email')]")).isDisplayed());
    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithLessThanFiveCharacters() {

        getSignUpPage().open();
        getSignUpPage().enterDataToNameField("Marko");
        getSignUpPage().enterDataToEmailField("marko@example.com");
        getSignUpPage().enterDataToPasswordField("1234");
        getSignUpPage().enterDataToConfirmPasswordField("12345");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[3]/span/div/div/div[2]/div/div/div")).isDisplayed());

    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithMissingInfo() {

        getSignUpPage().open();
        getSignUpPage().enterDataToNameField("");
        getSignUpPage().enterDataToEmailField("marko@example.com");
        getSignUpPage().enterDataToPasswordField("12345");
        getSignUpPage().enterDataToConfirmPasswordField("12345");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[1]/span/div/div/div[2]/div/div/div")).isDisplayed());

    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithoutMatchingPasswords() {

        getSignUpPage().open();
        getSignUpPage().enterDataToNameField("Marko");
        getSignUpPage().enterDataToEmailField("marko@example.com");
        getSignUpPage().enterDataToPasswordField("678910");
        getSignUpPage().enterDataToConfirmPasswordField("12345");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(getDriver().findElement(By.xpath("//div[contains(text(), 'Passwords')]")).isDisplayed());

    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithBlankPassword() {


        getSignUpPage().open();
        getSignUpPage().enterDataToNameField("Marko");
        getSignUpPage().enterDataToEmailField("marko@example.com");
        getSignUpPage().enterDataToPasswordField("         ");
        getSignUpPage().enterDataToConfirmPasswordField("       ");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[3]/span/div/div/div[2]/div/div/div")).isDisplayed());
    }
}
