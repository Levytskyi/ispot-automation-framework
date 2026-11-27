package tests.registration;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import static pages.RegistrationPage.Selector.PASSWORD;

public class PasswordGeneratorTest extends BaseTest {

    @Test
    @Link(name = "TC-REG-002", url = "https://github.com/Levytskyi/ispot-automation-framework/blob/main/docs/test-cases/product.md#tc-reg-002")
    @Feature("Registration Page")
    @Description("Verify that the Password generator changes the password on each click")
    @Severity(SeverityLevel.MINOR)
    public void verifyPasswordGeneratorWorksCorrectly() {

        HomePage homePage = new HomePage();
        homePage.clickAuthModalOpen();
        homePage.clickEmailAuth();
        homePage.clickRegPage();

        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickGeneratePassword();
        registrationPage.clickShowPassword();
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
