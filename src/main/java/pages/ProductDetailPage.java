package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductDetailPage {
    private enum Selector {
        TITLE_TEXT("div.rm-product-title>h1"),
        PRODUCT_OPTION("div.hcol-attribute"),
        INCREASE_QUANTITY_BUTTON("button.rm-product-quantity-btn-plus"),
        PRODUCT_PRICE("div.rm-product-center-price"),
        CART_PRODUCT_NAME("div.rm-cart-products-item-info-title>a"),
        ADD_TO_CART_BUTTON("#button-cart"),
        QUANTITY_FIELD("#input-quantity");

        private final String selector;

        Selector(String selector) {
            this.selector = selector;
        }

        public String getSelector() {
            return selector;
        }
    }

    public String getTitleText() {
        return $(Selector.TITLE_TEXT.getSelector())
                .shouldBe(visible)
                .getText();
    }

    public String getTitleText(String previousValue) {
        return $(Selector.TITLE_TEXT.getSelector())
                .shouldNotHave(exactText(previousValue))
                .getText();
    }

    public void selectProductOption(String option) {
        $$(Selector.PRODUCT_OPTION.getSelector())
                .findBy(exactText(option))
                .shouldBe(clickable)
                .click();
    }

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

    public int getProductPrice() {
        String price = $(Selector.PRODUCT_PRICE.getSelector())
                .shouldBe(visible)
                .getText()
                .replaceAll("\\D", "");
        return Integer.parseInt(price);
    }

    public String getProductNameFromCart() {
        return $(Selector.CART_PRODUCT_NAME.getSelector())
                .shouldBe(visible)
                .getText();
    }

    public void addProductToCart() {
        $(Selector.ADD_TO_CART_BUTTON.getSelector())
                .shouldBe(clickable)
                .click();
    }

    public void setProductQuantity(String productQuantity) {
        String price = $(Selector.PRODUCT_PRICE.getSelector())
                .shouldBe(visible)
                .getText();

        $(Selector.QUANTITY_FIELD.getSelector())
                .shouldBe(visible)
                .setValue(productQuantity)
                .pressEnter();

        $(Selector.PRODUCT_PRICE.getSelector())
                .shouldNotHave(exactText(price));
    }

    public String getQuantityFieldValue() {
        return $(Selector.QUANTITY_FIELD.getSelector())
                .shouldBe(visible)
                .getValue();
    }
}
