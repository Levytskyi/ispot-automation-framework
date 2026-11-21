package tests.search;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductSearchPage;

public class LoadMoreProductsTest extends BaseTest {

    @Test
    public void verifyLoadMoreButtonWorks() {
        String productToSearch = "iPhone";

        HomePage homePage = new HomePage();
        homePage.setSearchText(productToSearch);
        homePage.clickSearchButton();

        ProductSearchPage productSearchPage = new ProductSearchPage();
        int quantityBeforeLoading = productSearchPage.getVisibleProductQuantity();
        productSearchPage.loadMoreProducts();

        int quantityAfterLoading = productSearchPage.getVisibleProductQuantity(quantityBeforeLoading);

        Assert.assertTrue(
                quantityAfterLoading > quantityBeforeLoading,
                "The quantity doesn't change");
    }
}
