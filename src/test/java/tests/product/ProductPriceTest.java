package tests.product;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductSearchPage;

public class ProductPriceTest extends BaseTest {

    @Test
    @Link(name = "TC-PROD-003", url = "https://github.com/Levytskyi/ispot-automation-framework/blob/main/docs/test-cases/product.md#tc-prod-003")
    @Feature("Product Page")
    @Description("Verify that the product price changes after increasing quantity")
    @Severity(SeverityLevel.NORMAL)
    public void verifyIncreaseQuantityPriceChange() {
        String productToSearch = "Apple iPhone 18 Pro";
        int productIndex = 1;

        HomePage homePage = new HomePage();
        homePage.setSearchText(productToSearch);
        homePage.clickSearchButton();

        ProductSearchPage productSearchPage = new ProductSearchPage();
        productSearchPage.openSelectedProductDetailPage(productIndex);

        ProductDetailPage productDetailPage = new ProductDetailPage();

        int priceBefore = productDetailPage.getProductPrice();

        productDetailPage.increaseProductQuantity();

        int priceAfter = productDetailPage.getProductPrice();

        Assert.assertEquals(
                priceAfter,
                priceBefore * 2,
                "Incorrect product price after increasing product quantity by 1"
        );
    }
}
