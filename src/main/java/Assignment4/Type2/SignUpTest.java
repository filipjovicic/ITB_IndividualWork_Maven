package Assignment4.Type2;

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
        getSignUpPage().open();
        Assert.assertTrue(getSignUpPage().getEmailField().getAttribute("type").equals("email"));
    }

    @Test
    public void verifyTypeContainsPassword() {
        getSignUpPage().open();
        Assert.assertTrue(getSignUpPage().getPasswordField().getAttribute("type").equals("password"));
    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithInvalidEmail() {

        getSignUpPage().open()
                .enterDataToNameField("Marko")
                .enterDataToEmailField("marko.com")
                .enterDataToPasswordField("12345")
                .enterDataToConfirmPasswordField("12345");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(getSignUpPage().getInvalidEmailMessage().isDisplayed());
    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithLessThanFiveCharacters() {

        getSignUpPage().open()
                .enterDataToNameField("Marko")
                .enterDataToEmailField("marko@example.com")
                .enterDataToPasswordField("1234")
                .enterDataToConfirmPasswordField("12345");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(getSignUpPage().getLessThanFiveCharactersErrorMessage().isDisplayed());

    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithMissingInfo() {

        getSignUpPage().open()
                .enterDataToNameField("")
                .enterDataToEmailField("marko@example.com")
                .enterDataToPasswordField("12345")
                .enterDataToConfirmPasswordField("12345");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(getSignUpPage().getNameFieldRequiredErrorMessage().isDisplayed());

    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithoutMatchingPasswords() {

        getSignUpPage().open()
                .enterDataToNameField("Marko")
                .enterDataToEmailField("marko@example.com")
                .enterDataToPasswordField("678910")
                .enterDataToConfirmPasswordField("12345");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(getSignUpPage().getPasswordMustMatchErrorMessage().isDisplayed());

    }

    @Test
    public void verifyErrorMsgIsDisplayedSignUpWithBlankPassword() {


        getSignUpPage().open()
                .enterDataToNameField("Marko")
                .enterDataToEmailField("marko@example.com")
                .enterDataToPasswordField("        ")
                .enterDataToConfirmPasswordField("         ");
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(getSignUpPage().getPasswordFieldRequiredErrorMessage().isDisplayed());
    }
}
