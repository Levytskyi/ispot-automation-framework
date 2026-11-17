package tests.registration;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import static pages.RegistrationPage.Selector.*;

public class PasswordStrengthIndicatorTest extends BaseTest {

    @Test
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

        registrationPage.sendValueInField(PASSWORD, weakPassword);

        Assert.assertTrue(registrationPage.getElementAttributeValue(
                                PASSWORD_STRENGTH_INDICATOR, attributeToFind).
                        contains(weakPasswordColor),
                "The password indicator didn't turn red");

        registrationPage.sendValueInField(PASSWORD, mediumPassword, weakPassword);

        Assert.assertTrue(registrationPage.getElementAttributeValue(
                                PASSWORD_STRENGTH_INDICATOR, attributeToFind).
                        contains(mediumPasswordColor),
                "The password indicator didn't turn orange");

        registrationPage.sendValueInField(PASSWORD, strongPassword, mediumPassword);

        Assert.assertTrue(registrationPage.getElementAttributeValue(
                                PASSWORD_STRENGTH_INDICATOR, attributeToFind).
                        contains(strongPasswordColor),
                "The password indicator didn't turn green");
    }
}
