package tests.registration;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class RegisterAgreementCheckboxTest extends BaseTest {

    @Test
    public void verifyAgreementCanBeChecked() {
        boolean expectedAgreementBeforeSelected = false;
        boolean expectedAgreementAfterSelected = true;

        HomePage homePage = new HomePage();
        homePage.clickAuthModalOpen();
        homePage.clickEmailAuth();
        homePage.clickRegPage();

        RegistrationPage registrationPage = new RegistrationPage();
        boolean agreementBeforeSelected = registrationPage.registerAgreementIsSelected();
        Assert.assertEquals(agreementBeforeSelected, expectedAgreementBeforeSelected, "The agreement checkbox is checked");

        registrationPage.clickRegisterAgreement();

        boolean agreementAfterSelected = registrationPage.registerAgreementIsSelected(agreementBeforeSelected);
        Assert.assertEquals(agreementAfterSelected, expectedAgreementAfterSelected, "The agreement checkbox is unchecked");
    }
}
