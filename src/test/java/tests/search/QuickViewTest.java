package tests.search;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductSearchPage;

public class QuickViewTest extends BaseTest {

    @Test
    @Link(name = "TC-SRCH-003", url = "https://github.com/Levytskyi/ispot-automation-framework/blob/main/docs/test-cases/product.md#tc-srch-003")
    @Feature("Search Page")
    @Description("Verify that the Quick view modal opens for the selected product")
    @Severity(SeverityLevel.MINOR)
    public void verifyQuickViewOpenedForCorrectProduct() {
        String productToSearch = "EcoFlow";
        int productIndex = 2;

        HomePage homePage = new HomePage();
        homePage.setSearchText(productToSearch);
        homePage.clickSearchButton();

        ProductSearchPage productSearchPage = new ProductSearchPage();
        String productName = productSearchPage.getProductName(productIndex).toLowerCase();
        productSearchPage.openSelectedProductQuickView(productIndex);
        String quickViewProductName = productSearchPage.getQuickViewTitle().toLowerCase();

        Assert.assertEquals(
                quickViewProductName,
                productName,
                "The title on the quick view doesn't match the product name"
        );
    }
}
