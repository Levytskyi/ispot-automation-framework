package pages;

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

    public void clickGeneratePassword() {
        $(Selector.PASSWORD_GENERATOR_BUTTON.getSelector()).shouldBe(clickable).click();
    }

    public void clickShowPassword() {
        $(Selector.SHOW_PASSWORD_BUTTON.getSelector()).shouldBe(clickable).click();
    }

    public String getFieldValue(Selector selector) {
        return $(selector.getSelector()).shouldNotBe(empty).getValue();
    }

    public String getFieldValue(Selector selector, String previousValue) {
        return $(selector.getSelector()).shouldNotHave(value(previousValue)).getValue();
    }

    public String getElementAttributeValue(Selector selector, String attribute) {
        return $(selector.getSelector()).shouldBe(visible).getAttribute(attribute);
    }

    public String getElementAttributeValue(Selector selector, String attribute, String expectedPart) {
        return $(selector.getSelector()).shouldHave(cssClass(expectedPart)).getAttribute(attribute);
    }

    public void sendValueInField(Selector selector, String value) {
        $(selector.getSelector()).shouldBe(visible).setValue(value);
    }

    public void sendValueInField(Selector selector, String value, String previousValue) {
        $(selector.getSelector()).shouldHave(value(previousValue)).setValue(value);
    }

    public void clickSubmit() {
        $(Selector.SUBMIT_BUTTON.getSelector()).shouldBe(clickable).click();
    }

    public boolean registerAgreementIsSelected() {
        return $(Selector.AGREEMENT_CHECKBOX.getSelector()).shouldBe(visible).isSelected();
    }

    public boolean registerAgreementIsSelected(boolean isChecked) {
        if (isChecked) {
            return $(Selector.AGREEMENT_CHECKBOX.getSelector()).shouldNotBe(checked).isSelected();
        } else {
            return $(Selector.AGREEMENT_CHECKBOX.getSelector()).shouldBe(checked).isSelected();
        }
    }

    public void clickRegisterAgreement() {
        $(Selector.AGREEMENT_CHECKBOX_BUTTON.getSelector()).shouldBe(exist).click();
    }
}
