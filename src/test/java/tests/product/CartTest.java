package tests.product;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductSearchPage;

public class CartTest extends BaseTest {

    @Test
    @Link(name = "TC-PROD-001", url = "https://github.com/Levytskyi/ispot-automation-framework/blob/main/docs/test-cases/product.md#tc-prod-001")
    @Feature("Product Page")
    @Description("Verify that the Cart contains the selected product")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyCartContainsSelectedProduct() {
        String productToSearch = "Apple iPhone 16 Pro Max";
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

