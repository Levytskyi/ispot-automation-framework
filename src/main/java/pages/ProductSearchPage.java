package pages;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.*;

public class ProductSearchPage {
    public enum Selector {
        PRODUCT_CARD("div.product-layout"),
        PRODUCT_NAME("div.rm-module-title>a"),
        PRODUCT_PRICE("span.rm-module-price"),
        SORT("#input-sort");

        private final String selector;

        Selector(String selector) {
            this.selector = selector;
        }

        public String getSelector() {
            return selector;
        }
    }

    public List<String> getProductNamesList() {
        return $$(Selector.PRODUCT_NAME.getSelector()).
                shouldHave(sizeGreaterThan(0)).texts();
    }

    public List<Integer> getProductsPrices() {
        return $$(Selector.PRODUCT_PRICE.getSelector()).
                shouldHave(sizeGreaterThan(0)).
                texts().
                stream().
                map(e -> e.replace("грн.", "").replace(" ", "").trim()).
                map(e -> Integer.parseInt(e)).
                toList();
    }

    public void selectSortOption(String sortBy) {
        $(Selector.SORT.getSelector()).shouldBe(clickable);

        switch (sortBy) {
            case "cheaperFirst" ->
                $(Selector.SORT.getSelector()).selectOption("Бюджетні спочатку");
            case "moreExpensiveFirst" ->
                    $(Selector.SORT.getSelector()).selectOption("Дорожчі");
            case "morePopularFirst" ->
                    $(Selector.SORT.getSelector()).selectOption("Популярні");
            case "newerFirst" ->
                    $(Selector.SORT.getSelector()).selectOption("Нові");
            default -> throw new IllegalArgumentException("Unknown sorting option: " + sortBy);
        }
    }
}

