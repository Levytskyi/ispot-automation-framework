package tests.registration;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import static pages.RegistrationPage.Selector.*;

public class NameFieldTest extends BaseTest {

    @Test
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
