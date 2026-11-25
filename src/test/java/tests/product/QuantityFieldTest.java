package tests.product;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductSearchPage;

public class QuantityFieldTest extends BaseTest {

    @Test
    public void verifyQuantityFieldWithZeroValue() {
        String productToSearch = "Dyson";
        int productIndex = 7;
        String productQuantity = "0";

        HomePage homePage = new HomePage();
        homePage.setSearchText(productToSearch);
        homePage.clickSearchButton();

        ProductSearchPage productSearchPage = new ProductSearchPage();
        productSearchPage.openSelectedProductDetailPage(productIndex);

        ProductDetailPage productDetailPage = new ProductDetailPage();

        productDetailPage.setProductQuantity(productQuantity);

        String actualProductQuantity = productDetailPage.getQuantityFieldValue();

        Assert.assertNotEquals(
                actualProductQuantity,
                productQuantity,
                "Quantity field should not accept '" + productQuantity + "' value"
        );
    }
}
