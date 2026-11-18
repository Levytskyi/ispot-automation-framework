package tests.search;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductSearchPage;

import java.util.List;

public class ProductSortingTest extends BaseTest {

    @Test
    public void verifyProductsCanBeSortedByPriceAscending() {
        String productToSearch = "Apple MacBook Neo";
        String sortBy = "cheaperFirst";

        HomePage homePage = new HomePage();
        homePage.setSearchText(productToSearch);
        homePage.clickSearchButton();

        ProductSearchPage productSearchPage = new ProductSearchPage();
        productSearchPage.selectSortOption(sortBy);
        List<Integer> productsPrices = productSearchPage.getProductsPrices();

        Assert.assertEquals(
                productsPrices,
                productsPrices
                        .stream()
                        .sorted()
                        .toList(),
                "The prices in <" + productsPrices + "> aren't sorted by" + sortBy
        );
    }
}
