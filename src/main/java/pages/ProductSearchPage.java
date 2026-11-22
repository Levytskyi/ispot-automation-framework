package pages;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductSearchPage {
    public enum Selector {
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

    public List<String> getProductNamesList() {
        return $$(Selector.PRODUCT_NAME.getSelector())
                .shouldHave(sizeGreaterThan(0))
                .texts();
    }

    public String getProductName(int productIndex) {
        return $$(Selector.PRODUCT_NAME.getSelector())
                .shouldHave(sizeGreaterThan(productIndex - 1))
                .get(productIndex - 1)
                .getText();
    }

    public List<Integer> getProductsPrices() {
        return $$(Selector.PRODUCT_PRICE.getSelector())
                .shouldHave(sizeGreaterThan(0))
                .texts()
                .stream()
                .map(e -> e.replace("грн.", "").replace(" ", "").trim())
                .map(e -> Integer.parseInt(e))
                .toList();
    }

    public void selectSortOption(String sortBy) {
        $(Selector.SORT.getSelector()).shouldBe(clickable);

        switch (sortBy) {
            case "cheaperFirst" -> $(Selector.SORT.getSelector()).selectOption("Бюджетні спочатку");
            case "moreExpensiveFirst" -> $(Selector.SORT.getSelector()).selectOption("Дорожчі");
            case "morePopularFirst" -> $(Selector.SORT.getSelector()).selectOption("Популярні");
            case "newerFirst" -> $(Selector.SORT.getSelector()).selectOption("Нові");
            default -> throw new IllegalArgumentException("Unknown sorting option: " + sortBy);
        }
    }

    public void addProductToWishlist(int productIndex) {
        $$(Selector.ADD_TO_WISHLIST.getSelector())
                .shouldHave(sizeGreaterThan(productIndex - 1))
                .get(productIndex - 1)
                .hover()
                .click();
    }

    public int getWishlistCounterValue() {
        return $(Selector.WISHLIST_COUNTER.getSelector())
                .shouldBe(visible)
                .getText()
                .transform(e -> Integer.parseInt(e));
    }

    public int getWishlistCounterValue(int previousValue) {
        return $(Selector.WISHLIST_COUNTER.getSelector())
                .shouldNotHave(exactText(String.valueOf(previousValue)))
                .getText()
                .transform(e -> Integer.parseInt(e));
    }

    public void openSelectedProductQuickView(int productIndex) {
        $$(Selector.QUICK_VIEW.getSelector())
                .shouldHave(sizeGreaterThan(productIndex - 1))
                .get(productIndex - 1)
                .hover()
                .click();
    }

    public String getQuickViewTitle() {
        return $(Selector.QUICK_VIEW_TITLE.getSelector())
                .should(visible)
                .getText();
    }

    public int getVisibleProductQuantity() {
        return $$(Selector.PRODUCT_CARD.getSelector())
                .shouldHave(sizeGreaterThan(0))
                .size();
    }
    public int getVisibleProductQuantity(int previousQuantity) {
        return $$(Selector.PRODUCT_CARD.getSelector())
                .shouldHave(sizeGreaterThan(previousQuantity))
                .size();
    }

    public void loadMoreProducts() {
        $(Selector.LOAD_MORE.getSelector())
                .should(visible)
                .scrollIntoCenter()
                .shouldBe(clickable)
                .click();
    }

    public void openSelectedProductDetailPage(int productIndex) {
        $$(Selector.PRODUCT_NAME.getSelector())
                .shouldHave(sizeGreaterThanOrEqual(productIndex - 1))
                .get(productIndex)
                .click();
    }
}