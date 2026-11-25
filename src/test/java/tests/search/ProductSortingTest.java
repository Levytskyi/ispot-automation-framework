package tests.search;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductSearchPage;

import java.util.List;

import static pages.ProductSearchPage.SortingOption.*;

public class ProductSortingTest extends BaseTest {

    @Test
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
