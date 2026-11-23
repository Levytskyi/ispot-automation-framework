package tests.product;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductSearchPage;

public class CartTest extends BaseTest {

    @Test
    public void verifyCartContainsSelectedProduct() {
        String productToSearch = "Apple AirPods 4 with Active Noise Cancellation";
        int productIndex = 2;

        HomePage homePage = new HomePage();
        homePage.setSearchText(productToSearch);
        homePage.clickSearchButton();

        ProductSearchPage productSearchPage = new ProductSearchPage();
        productSearchPage.openSelectedProductDetailPage(productIndex);

        ProductDetailPage productDetailPage = new ProductDetailPage();

        String expectedName = productDetailPage.getTitleText();

        productDetailPage.addProductToCart();

        String actualName = productDetailPage.getProductNameFromCart();

        Assert.assertEquals(
                actualName,
                expectedName,
                "The cart doesn't match '" + expectedName + "'"
        );
    }
}

