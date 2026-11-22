package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductDetailPage {
    public enum Selector {
        TITLE_TEXT("div.rm-product-title>h1"),
        PRODUCT_OPTION("div.hcol-attribute"),
        INCREASE_QUANTITY_BUTTON("button.rm-product-quantity-btn-plus"),
        PRODUCT_PRICE("div.rm-product-center-price");

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
                .replace(" ", "")
                .replace("грн.", "");
        return Integer.parseInt(price);
    }
}
