package tests.product;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductSearchPage;

public class QuantityFieldTest extends BaseTest {

    @Test
    public void verifyQuantityFieldWithAlphabeticValue() {
        String productToSearch = "Dyson";
        int productIndex = 7;
        String productQuantity = "Two";
        int expectedPrice = 0;

        HomePage homePage = new HomePage();
        homePage.setSearchText(productToSearch);
        homePage.clickSearchButton();

        ProductSearchPage productSearchPage = new ProductSearchPage();
        productSearchPage.openSelectedProductDetailPage(productIndex);

        ProductDetailPage productDetailPage = new ProductDetailPage();

        productDetailPage.setProductQuantity(productQuantity);

        int actualPrice = productDetailPage.getProductPrice();
        String actualProductQuantity = productDetailPage.getQuantityFieldValue();

        Assert.assertEquals(
                actualProductQuantity,
                productQuantity,
                "The actual product quantity doesn't match '" + productQuantity + "'"
        );
        Assert.assertEquals(
                actualPrice,
                expectedPrice,
                "The actual price doesn't match '" + expectedPrice + "'"
        );
    }
}
