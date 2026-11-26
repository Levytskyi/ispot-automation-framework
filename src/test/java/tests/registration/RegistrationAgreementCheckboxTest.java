package tests.registration;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class RegistrationAgreementCheckboxTest extends BaseTest {

    @Test
    public void verifyAgreementCanBeChecked() {
        HomePage homePage = new HomePage();
        homePage.clickAuthModalOpen();
        homePage.clickEmailAuth();
        homePage.clickRegPage();

        RegistrationPage registrationPage = new RegistrationPage();

        boolean agreementBeforeSelected = registrationPage.isRegisterAgreementSelected();

        Assert.assertFalse(
                agreementBeforeSelected,
                "The agreement checkbox is checked"
        );

        registrationPage.clickRegisterAgreement();

        boolean agreementAfterSelected = registrationPage.isRegisterAgreementSelected(agreementBeforeSelected);

        Assert.assertTrue(
                agreementAfterSelected,
                "The agreement checkbox is unchecked"
        );
    }
}
