package pages;

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

    public enum SortingOption{
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
                .map(price -> price.replaceAll("\\D", ""))
                .map(price -> Integer.parseInt(price))
                .toList();
    }
    public void selectSortOption(SortingOption option) {
        $(Selector.SORT.getSelector())
                .shouldBe(clickable)
                .selectOption(option.getSortingOption());
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
                .shouldBe(visible)
                .scrollIntoCenter()
                .shouldBe(clickable)
                .click();
    }

    public void openSelectedProductDetailPage(int productIndex) {
        $$(Selector.PRODUCT_NAME.getSelector())
                .shouldHave(sizeGreaterThan(productIndex - 1))
                .get(productIndex - 1)
                .scrollIntoCenter()
                .click();
    }
}