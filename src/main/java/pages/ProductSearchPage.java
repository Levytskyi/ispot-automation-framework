package pages;

import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductSearchPage {
    private enum Selector {
        PRODUCT_CARD("div.product-layout"),
        PRODUCT_NAME("div.rm-module-title>a"),
        PRODUCT_PRICE("span.rm-module-price"),
        SORT("#input-sort"),
        ADD_TO_WISHLIST("button.wishlist"),
        WISHLIST_COUNTER("span.oct-fixed-bar-wishlist-quantity"),
        QUICK_VIEW("button.popup-view"),
        QUICK_VIEW_TITLE("#rm-quickview"),
        LOAD_MORE("button.oct-load-more-button");

        private final String selector;

        Selector(String selector) {
            this.selector = selector;
        }

        public String getSelector() {
            return selector;
        }
    }

    public enum SortingOption {
        CHEAPER_FIRST("Бюджетні спочатку"),
        EXPENSIVE_FIRST("Дорожчі"),
        POPULAR_FIRST("Популярні"),
        NEWER_FIRST("Нові");

        private final String sortingOption;

        SortingOption(String sortingOption) {
            this.sortingOption = sortingOption;
        }

        public String getSortingOption() {
            return sortingOption;
        }
    }

    @Step("Get Product names list")
    public List<String> getProductNamesList() {
        return $$(Selector.PRODUCT_NAME.getSelector())
                .shouldHave(sizeGreaterThan(0))
                .texts();
    }

    @Step("Get the name text of product {productIndex}")
    public String getProductName(int productIndex) {
        return $$(Selector.PRODUCT_NAME.getSelector())
                .shouldHave(sizeGreaterThan(productIndex - 1))
                .get(productIndex - 1)
                .getText();
    }

    @Step("Get Product prices list")
    public List<Integer> getProductsPrices() {
        return $$(Selector.PRODUCT_PRICE.getSelector())
                .shouldHave(sizeGreaterThan(0))
                .texts()
                .stream()
                .map(price -> price.replaceAll("\\D", ""))
                .map(price -> Integer.parseInt(price))
                .toList();
    }

    @Step("Select {option} sorting option")
    public void selectSortOption(SortingOption option) {
        $(Selector.SORT.getSelector())
                .shouldBe(clickable)
                .selectOption(option.getSortingOption());
    }

    @Step("Add product {productIndex} to the Wishlist")
    public void addProductToWishlist(int productIndex) {
        $$(Selector.ADD_TO_WISHLIST.getSelector())
                .shouldHave(sizeGreaterThan(productIndex - 1))
                .get(productIndex - 1)
                .hover()
                .click();
    }

    @Step("Get the Wishlist counter value")
    public int getWishlistCounterValue() {
        return $(Selector.WISHLIST_COUNTER.getSelector())
                .shouldBe(visible)
                .getText()
                .transform(e -> Integer.parseInt(e));
    }

    @Step("Get the updated Wishlist counter value")
    public int getWishlistCounterValue(int previousValue) {
        return $(Selector.WISHLIST_COUNTER.getSelector())
                .shouldNotHave(exactText(String.valueOf(previousValue)))
                .getText()
                .transform(e -> Integer.parseInt(e));
    }

    @Step("Open the Quick view pop-up for product {productIndex}")
    public void openSelectedProductQuickView(int productIndex) {
        $$(Selector.QUICK_VIEW.getSelector())
                .shouldHave(sizeGreaterThan(productIndex - 1))
                .get(productIndex - 1)
                .hover()
                .click();
    }

    @Step("Get the Quick view pop-up title text")
    public String getQuickViewTitle() {
        return $(Selector.QUICK_VIEW_TITLE.getSelector())
                .should(visible)
                .getText();
    }

    @Step("Get the Quantity of visible products")
    public int getVisibleProductQuantity() {
        return $$(Selector.PRODUCT_CARD.getSelector())
                .shouldHave(sizeGreaterThan(0))
                .size();
    }

    @Step("Get the updated Quantity of visible products")
    public int getVisibleProductQuantity(int previousQuantity) {
        return $$(Selector.PRODUCT_CARD.getSelector())
                .shouldHave(sizeGreaterThan(previousQuantity))
                .size();
    }

    @Step("Click the Load more products button")
    public void loadMoreProducts() {
        $(Selector.LOAD_MORE.getSelector())
                .shouldBe(visible)
                .scrollIntoCenter()
                .shouldBe(clickable)
                .click();
    }

    @Step("Open the Product detail page for product {productIndex}")
    public void openSelectedProductDetailPage(int productIndex) {
        $$(Selector.PRODUCT_NAME.getSelector())
                .shouldHave(sizeGreaterThan(productIndex - 1))
                .get(productIndex - 1)
                .scrollIntoCenter()
                .click();
    }
}