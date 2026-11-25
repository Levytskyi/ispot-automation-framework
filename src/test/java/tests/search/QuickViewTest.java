package tests.search;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductSearchPage;

public class QuickViewTest extends BaseTest {

    @Test
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
