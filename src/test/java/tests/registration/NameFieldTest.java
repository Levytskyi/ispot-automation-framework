package tests.registration;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import static pages.RegistrationPage.Selector.*;

public class NameFieldTest extends BaseTest {

    @Test
    @Link(name = "TC-REG-001", url = "https://github.com/Levytskyi/ispot-automation-framework/blob/main/docs/test-cases/product.md#tc-reg-001")
    @Feature("Registration Page")
    @Description("Verify that the Name field displays an error style when submitted empty")
    @Severity(SeverityLevel.NORMAL)
    public void verifyEmptyFieldStyleChanges() {
        String lastName = "Tester";
        String email = "example@test.com";
        String phoneNumber = "0661111111";

        HomePage homePage = new HomePage();
        homePage.clickAuthModalOpen();
        homePage.clickEmailAuth();
        homePage.clickRegPage();

        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.setFieldValue(LASTNAME, lastName);
        registrationPage.setFieldValue(EMAIL, email);
        registrationPage.setFieldValue(PHONE, phoneNumber);
        registrationPage.clickGeneratePassword();

        Assert.assertFalse(
                registrationPage.isFieldErrorStyleDisplayed(FIRSTNAME),
                "The name field class attribute contains an error part"
        );

        registrationPage.clickSubmit();

        Assert.assertTrue(
                registrationPage.isFieldErrorStyleDisplayed(FIRSTNAME),
                "The name field class attribute doesn't contain an error part"
        );
    }
}
