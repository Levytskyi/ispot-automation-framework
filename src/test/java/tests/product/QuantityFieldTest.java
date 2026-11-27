package tests.product;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductSearchPage;

public class QuantityFieldTest extends BaseTest {

    @Test
    @Link(name = "TC-PROD-004", url = "https://github.com/Levytskyi/ispot-automation-framework/blob/main/docs/test-cases/product.md#tc-prod-004")
    @Feature("Product Page")
    @Description("Verify that the Quantity field does not accept zero value")
    @Severity(SeverityLevel.MINOR)
    public void verifyQuantityFieldWithZeroValue() {
        String productToSearch = "Dyson";
        int productIndex = 1;
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
