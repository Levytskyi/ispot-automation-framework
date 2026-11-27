package tests.registration;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import static pages.RegistrationPage.Selector.*;

public class PasswordStrengthIndicatorTest extends BaseTest {

    @Test
    @Link(name = "TC-REG-003", url = "https://github.com/Levytskyi/ispot-automation-framework/blob/main/docs/test-cases/product.md#tc-reg-003")
    @Feature("Registration Page")
    @Description("Verify that the password strength indicator changes according to the password complexity")
    @Severity(SeverityLevel.MINOR)
    public void verifyStrengthIndicatorChanges() {
        String attributeToFind = "style";

        String weakPassword = "<91";
        String mediumPassword = "<91S/jQ";
        String strongPassword = "<91S/jQ4$acG";

        String weakPasswordColor = "red";
        String mediumPasswordColor = "orange";
        String strongPasswordColor = "green";

        HomePage homePage = new HomePage();
        homePage.clickAuthModalOpen();
        homePage.clickEmailAuth();
        homePage.clickRegPage();

        RegistrationPage registrationPage = new RegistrationPage();

        registrationPage.setFieldValue(PASSWORD, weakPassword);

        Assert.assertTrue(registrationPage.getElementAttributeValue(
                                PASSWORD_STRENGTH_INDICATOR, attributeToFind)
                        .contains(weakPasswordColor),
                "The password indicator didn't turn red");

        registrationPage.setFieldValue(PASSWORD, mediumPassword);

        Assert.assertTrue(
                registrationPage
                        .getElementAttributeValue(PASSWORD_STRENGTH_INDICATOR, attributeToFind)
                        .contains(mediumPasswordColor),
                "The password indicator didn't turn orange");

        registrationPage.setFieldValue(PASSWORD, strongPassword);

        Assert.assertTrue(
                registrationPage
                        .getElementAttributeValue(PASSWORD_STRENGTH_INDICATOR, attributeToFind)
                        .contains(strongPasswordColor),
                "The password indicator didn't turn green");
    }
}
