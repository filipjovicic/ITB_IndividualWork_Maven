package Assignment4.Type3;

import org.testng.annotations.Test;

import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SignUpTests extends BaseTest {

    @Test
    public void verifyUrlContainsSignup() {
        getSignUpPage().open();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/signup"));
    }

    @Test
    public void verifyTypeContainsEmail() {
        getSignUpPage().open();
        Assert.assertTrue(getSignUpPage().emailField.getAttribute("type").equals("email"));
    }

    @Test
    public void verifyTypeContainsPassword() {
        getSignUpPage().open();
        Assert.assertTrue(getSignUpPage().passwordField.getAttribute("type").equals("password"));
    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithInvalidEmail() {

        getSignUpPage().open();
        getSignUpPage().enterDataToNameField("Marko");
        getSignUpPage().enterDataToEmailField("marko.com");
        getSignUpPage().enterDataToPasswordField("12345");
        getSignUpPage().enterDataToConfirmPasswordField("12345");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(getSignUpPage().invalidEmailMessage.isDisplayed());
    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithLessThanFiveCharacters() {

        getSignUpPage().open();
        getSignUpPage().enterDataToNameField("Marko");
        getSignUpPage().enterDataToEmailField("marko@example.com");
        getSignUpPage().enterDataToPasswordField("1234");
        getSignUpPage().enterDataToConfirmPasswordField("12345");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(getSignUpPage().lessThanFiveCharactersErrorMessage.isDisplayed());

    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithMissingInfo() {

        getSignUpPage().open();
        getSignUpPage().enterDataToNameField("");
        getSignUpPage().enterDataToEmailField("marko@example.com");
        getSignUpPage().enterDataToPasswordField("12345");
        getSignUpPage().enterDataToConfirmPasswordField("12345");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(getSignUpPage().nameFieldRequiredErrorMessage.isDisplayed());

    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithoutMatchingPasswords() {

        getSignUpPage().open();
        getSignUpPage().enterDataToNameField("Marko");
        getSignUpPage().enterDataToEmailField("marko@example.com");
        getSignUpPage().enterDataToPasswordField("678910");
        getSignUpPage().enterDataToConfirmPasswordField("12345");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(getSignUpPage().passwordMustMatchErrorMessage.isDisplayed());

    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithBlankPassword() {


        getSignUpPage().open();
        getSignUpPage().enterDataToNameField("Marko");
        getSignUpPage().enterDataToEmailField("marko@example.com");
        getSignUpPage().enterDataToPasswordField("        ");
        getSignUpPage().enterDataToConfirmPasswordField("         ");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(getSignUpPage().passwordFieldRequiredErrorMessage.isDisplayed());
    }


}
