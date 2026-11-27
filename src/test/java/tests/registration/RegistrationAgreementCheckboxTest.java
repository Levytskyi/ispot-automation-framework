package tests.registration;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class RegistrationAgreementCheckboxTest extends BaseTest {

    @Test
    @Link(name = "TC-REG-004", url = "https://github.com/Levytskyi/ispot-automation-framework/blob/main/docs/test-cases/product.md#tc-reg-004")
    @Feature("Registration Page")
    @Description("Verify that the Registration agreement checkbox can be checked")
    @Severity(SeverityLevel.NORMAL)
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
