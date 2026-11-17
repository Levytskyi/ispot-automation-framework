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
        String attributeToInspect = "class";
        String fieldErrorStyle = "error_style";

        HomePage homePage = new HomePage();
        homePage.clickAuthModalOpen();
        homePage.clickEmailAuth();
        homePage.clickRegPage();

        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.sendValueInField(LASTNAME, lastName);
        registrationPage.sendValueInField(EMAIL, email);
        registrationPage.sendValueInField(PHONE, phoneNumber);
        registrationPage.clickGeneratePassword();

        String attributeValueBeforeSubmit = registrationPage.getElementAttributeValue(FIRSTNAME, attributeToInspect);

        Assert.assertFalse(
                attributeValueBeforeSubmit.
                        contains(fieldErrorStyle),
                "The name field class attribute contains an error part"
        );

        registrationPage.clickSubmit();

        Assert.assertTrue(
                registrationPage.
                        getElementAttributeValue(
                                FIRSTNAME,
                                attributeToInspect,
                                fieldErrorStyle).
                        contains(fieldErrorStyle),
                "The name field class attribute doesn't contain an error part"
        );
    }
}
