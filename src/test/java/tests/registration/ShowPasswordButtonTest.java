package tests.registration;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import static pages.RegistrationPage.Selector.PASSWORD;

public class ShowPasswordButtonTest extends BaseTest {

    @Test
    public void verifyPasswordFieldTypeChanges() {
        String attribute = "type";
        String expectedTypeBeforeClick = "password";
        String expectedTypeAfterClick = "text";

        HomePage homePage = new HomePage();
        homePage.clickAuthModalOpen();
        homePage.clickEmailAuth();
        homePage.clickRegPage();

        RegistrationPage registrationPage = new RegistrationPage();
        String actualTypeBeforeClick = registrationPage.getElementAttributeValue(PASSWORD, attribute);

        Assert.assertEquals(
                actualTypeBeforeClick,
                expectedTypeBeforeClick,
                "The actual and expected password field types don't match"
        );

        registrationPage.clickShowPassword();
        String actualTypeAfterClick = registrationPage.getElementAttributeValue(PASSWORD, attribute);

        Assert.assertEquals(
                actualTypeAfterClick,
                expectedTypeAfterClick,
                "The actual and expected password field types don't match"
        );
    }
}
