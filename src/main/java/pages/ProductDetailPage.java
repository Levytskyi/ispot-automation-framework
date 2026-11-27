package pages;

import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductDetailPage {
    private enum Selector {
        TITLE_TEXT("div.rm-product-title>h1"),
        PRODUCT_OPTION("div.hcol-attribute"),
        INCREASE_QUANTITY_BUTTON("button.rm-product-quantity-btn-plus"),
        PRODUCT_PRICE("div.rm-product-center-price"),
        CART_PRODUCT_NAME("div.rm-cart-products-item-info-title>a"),
        ADD_TO_CART_BUTTON("#button-cart"),
        QUANTITY_FIELD("#input-quantity"),
        REVIEW_TAB("[href='#product_reviews']"),
        WRITE_REVIEW_BUTTON("[data-target='#rm-popup-review']"),
        SUBMIT_REVIEW_BUTTON("#button-review"),
        REVIEW_NAME_FIELD("#InputName");

        private final String selector;

        Selector(String selector) {
            this.selector = selector;
        }

        public String getSelector() {
            return selector;
        }
    }

    @Step("Get the Title text on the Product detail page")
    public String getTitleText() {
        return $(Selector.TITLE_TEXT.getSelector())
                .shouldBe(visible)
                .getText();
    }

    @Step("Get the updated Title text on the Product detail page")
    public String getTitleText(String previousValue) {
        return $(Selector.TITLE_TEXT.getSelector())
                .shouldNotHave(exactText(previousValue))
                .getText();
    }

    @Step("Select {option} product option")
    public void selectProductOption(String option) {
        $$(Selector.PRODUCT_OPTION.getSelector())
                .findBy(exactText(option))
                .shouldBe(clickable)
                .click();
    }

    @Step("Increase the product quantity by 1")
    public void increaseProductQuantity() {
        String previousPrice = $(Selector.PRODUCT_PRICE.getSelector())
                .shouldBe(visible)
                .getText();

        $(Selector.INCREASE_QUANTITY_BUTTON.getSelector())
                .shouldBe(clickable)
                .click();

        $(Selector.PRODUCT_PRICE.getSelector())
                .shouldNotHave(exactText(previousPrice));
    }

    @Step("Get the Product price")
    public int getProductPrice() {
        String price = $(Selector.PRODUCT_PRICE.getSelector())
                .shouldBe(visible)
                .getText()
                .replaceAll("\\D", "");
        return Integer.parseInt(price);
    }

    @Step("Get the Product name from the Cart")
    public String getProductNameFromCart() {
        return $(Selector.CART_PRODUCT_NAME.getSelector())
                .shouldBe(visible)
                .getText();
    }

    @Step("Add the Product to the Cart")
    public void addProductToCart() {
        $(Selector.ADD_TO_CART_BUTTON.getSelector())
                .shouldBe(clickable)
                .click();
    }

    @Step("Enter {productQuantity} into the Quantity field")
    public void setProductQuantity(String productQuantity) {
        $(Selector.QUANTITY_FIELD.getSelector())
                .shouldBe(visible)
                .setValue(productQuantity)
                .pressEnter();
    }

    @Step("Get the Quantity field value")
    public String getQuantityFieldValue() {
        return $(Selector.QUANTITY_FIELD.getSelector())
                .shouldBe(visible)
                .getValue();
    }

    @Step("Click the Review tab")
    public void openReviewTab() {
        $(Selector.REVIEW_TAB.getSelector())
                .shouldBe(visible)
                .scrollIntoCenter()
                .click();
    }

    @Step("Click the Write review button")
    public void openReviewModal() {
        $(Selector.WRITE_REVIEW_BUTTON.getSelector())
                .shouldBe(clickable)
                .click();
    }

    @Step("Click the Submit review button")
    public void clickSubmitReview() {
        $(Selector.SUBMIT_REVIEW_BUTTON.getSelector())
                .shouldBe(clickable)
                .click();
    }

    @Step("Enter {value} into the Review name field")
    public void setValueReviewNameField(String value) {
        $(Selector.REVIEW_NAME_FIELD.getSelector())
                .shouldBe(visible)
                .setValue(value);
    }

    @Step("Check that the Review name field error style is visible")
    public boolean isReviewNameFieldErrorStyleDisplayed() {
        return $(Selector.REVIEW_NAME_FIELD.getSelector())
                .shouldBe(visible)
                .has(cssClass("error_style"), Duration.ofSeconds(4));
    }
}
