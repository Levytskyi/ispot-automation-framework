package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private enum Selector {
        AUTH_MODAL("div.top-nav-account-links-item span.d-flex"),
        AUTH_EMAIL_TAB("#email-login-tab"),
        AUTH_REGISTRATION_PAGE("a.login-popup-register"),
        SEARCH_FIELD("#input_search"),
        SEARCH_BUTTON("#rm-search-button");

        private final String selector;

        Selector(String selector) {
            this.selector = selector;
        }

        public String getSelector() {
            return selector;
        }
    }

    @Step("Click the Authorization button")
    public void clickAuthModalOpen() {
        $(Selector.AUTH_MODAL.getSelector())
                .shouldBe(clickable)
                .click();
    }

    @Step("Click the Email authorization tab")
    public void clickEmailAuth() {
        $(Selector.AUTH_EMAIL_TAB.getSelector())
                .shouldBe(clickable)
                .click();
    }

    @Step("Click the Registration page link")
    public void clickRegPage() {
        $(Selector.AUTH_REGISTRATION_PAGE.getSelector())
                .shouldBe(clickable)
                .click();
    }

    @Step("Enter {productToSearch} into the Search field")
    public void setSearchText(String productToSearch) {
        $(Selector.SEARCH_FIELD.getSelector())
                .shouldBe(visible)
                .setValue(productToSearch);
    }

    @Step("Click the Search button")
    public void clickSearchButton() {
        $(Selector.SEARCH_BUTTON.getSelector())
                .shouldBe(clickable)
                .click();
    }
}
