package tests.search;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductSearchPage;

public class LoadMoreProductsTest extends BaseTest {

    @Test
    @Link(name = "TC-SRCH-001", url = "https://github.com/Levytskyi/ispot-automation-framework/blob/main/docs/test-cases/product.md#tc-srch-001")
    @Feature("Search Page")
    @Description("Verify that the Load more products button loads additional products")
    @Severity(SeverityLevel.MINOR)
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
                "The quantity doesn't change"
        );
    }
}
