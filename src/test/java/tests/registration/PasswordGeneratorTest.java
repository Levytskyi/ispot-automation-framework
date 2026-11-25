package tests.registration;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import static pages.RegistrationPage.Selector.PASSWORD;

public class PasswordGeneratorTest extends BaseTest {

    @Test
    public void verifyPasswordGeneratorWorksCorrectly() {

        HomePage homePage = new HomePage();
        homePage.clickAuthModalOpen();
        homePage.clickEmailAuth();
        homePage.clickRegPage();

        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickShowPassword();
        registrationPage.clickGeneratePassword();
        String generatedPassword = registrationPage.getFieldValue(PASSWORD);

        registrationPage.clickGeneratePassword();
        String newGeneratedPassword = registrationPage.getFieldValue(PASSWORD, generatedPassword);

        Assert.assertNotEquals(
                newGeneratedPassword,
                generatedPassword,
                "Password hasn't changed"
        );
    }
}
