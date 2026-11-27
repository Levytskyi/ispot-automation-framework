package pages;

import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    public enum Selector {
        FIRSTNAME("#firstname"),
        LASTNAME("#lastname"),
        PHONE("#telephone"),
        EMAIL("#email"),
        PASSWORD("#password"),
        PASSWORD_STRENGTH_INDICATOR("#strengthIndicator"),
        SHOW_PASSWORD_BUTTON("button.button-show"),
        PASSWORD_GENERATOR_BUTTON("button.rm-btn.secondary.w-100"),
        SUBMIT_BUTTON("#button-reg"),
        AGREEMENT_CHECKBOX("#registerAgree"),
        AGREEMENT_CHECKBOX_BUTTON("form.form-horizontal span.check-box");

        private final String selector;

        Selector(String selector) {
            this.selector = selector;
        }

        public String getSelector() {
            return selector;
        }
    }

    @Step("Click the Generate password button")
    public void clickGeneratePassword() {
        $(Selector.PASSWORD_GENERATOR_BUTTON.getSelector())
                .shouldBe(clickable)
                .click();
    }

    @Step("Click the Show password button")
    public void clickShowPassword() {
        $(Selector.SHOW_PASSWORD_BUTTON.getSelector())
                .shouldBe(clickable)
                .click();
    }

    @Step("Get the {selector} field value")
    public String getFieldValue(Selector selector) {
        return $(selector.getSelector())
                .shouldNotBe(empty)
                .getValue();
    }

    @Step("Get the updated {selector} field value")
    public String getFieldValue(Selector selector, String previousValue) {
        return $(selector.getSelector())
                .shouldNotHave(value(previousValue))
                .getValue();
    }

    @Step("Enter {value} into the {selector} field")
    public void setFieldValue(Selector selector, String value) {
        $(selector.getSelector())
                .shouldBe(visible)
                .setValue(value);
    }

    @Step("Click the Submit form button")
    public void clickSubmit() {
        $(Selector.SUBMIT_BUTTON.getSelector())
                .shouldBe(clickable)
                .click();
    }

    @Step("Get the {selector} field {attribute} attribute value")
    public String getElementAttributeValue(Selector selector, String attribute) {
        return $(selector.getSelector())
                .shouldBe(visible)
                .getAttribute(attribute);
    }

    @Step("Check that the {selector} field error style is visible")
    public boolean isFieldErrorStyleDisplayed(Selector selector) {
        return $(selector.getSelector())
                .shouldBe(visible)
                .has(cssClass("error_style"), Duration.ofSeconds(4));
    }

    @Step("Check that the Registration agreement checkbox is checked")
    public boolean isRegisterAgreementSelected() {
        return $(Selector.AGREEMENT_CHECKBOX.getSelector())
                .shouldBe(visible)
                .isSelected();
    }

    @Step("Check that the updated Registration agreement checkbox is checked")
    public boolean isRegisterAgreementSelected(boolean previousState) {
        if (previousState) {
            return $(Selector.AGREEMENT_CHECKBOX.getSelector())
                    .shouldNotBe(checked)
                    .isSelected();
        } else {
            return $(Selector.AGREEMENT_CHECKBOX.getSelector())
                    .shouldBe(checked)
                    .isSelected();
        }
    }

    @Step("Select the Registration agreement checkbox")
    public void clickRegisterAgreement() {
        $(Selector.AGREEMENT_CHECKBOX_BUTTON.getSelector())
                .shouldBe(exist)
                .click();
    }
}
