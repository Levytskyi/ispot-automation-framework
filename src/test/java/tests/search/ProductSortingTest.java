package tests.search;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductSearchPage;

import java.util.List;

import static pages.ProductSearchPage.SortingOption.*;

public class ProductSortingTest extends BaseTest {

    @Test
    @Link(name = "TC-SRCH-002", url = "https://github.com/Levytskyi/ispot-automation-framework/blob/main/docs/test-cases/product.md#tc-srch-002")
    @Feature("Search Page")
    @Description("Verify that products can be sorted by price in ascending order")
    @Severity(SeverityLevel.MINOR)
    public void verifyProductsCanBeSortedByPriceAscending() {
        String productToSearch = "iPhone 17 Pro";

        HomePage homePage = new HomePage();
        homePage.setSearchText(productToSearch);
        homePage.clickSearchButton();

        ProductSearchPage productSearchPage = new ProductSearchPage();
        productSearchPage.selectSortOption(CHEAPER_FIRST);

        List<Integer> productsPrices = productSearchPage.getProductsPrices();

        Assert.assertEquals(
                productsPrices,
                productsPrices
                        .stream()
                        .sorted()
                        .toList(),
                "The prices in <" + productsPrices + "> aren't sorted by cheaper first option"
        );
    }
}
