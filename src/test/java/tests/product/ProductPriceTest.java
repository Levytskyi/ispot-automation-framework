package tests.product;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductSearchPage;

public class ProductPriceTest extends BaseTest {

    @Test
    public void verifyIncreaseQuantityPriceChange() {
        String productToSearch = "Apple MacBook Neo 13";
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
