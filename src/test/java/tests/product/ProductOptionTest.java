package tests.product;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductSearchPage;

public class ProductOptionTest extends BaseTest {

    @Test
    public void verifyMemoryOptionChange() {
        String productToSearch = "Apple MacBook Neo 13 512Gb";
        int productIndex = 1;
        String selectedOption = "256 Gb";

        HomePage homePage = new HomePage();
        homePage.setSearchText(productToSearch);
        homePage.clickSearchButton();

        ProductSearchPage productSearchPage = new ProductSearchPage();
        productSearchPage.openSelectedProductDetailPage(productIndex);

        ProductDetailPage productDetailPage = new ProductDetailPage();

        String titleBeforeChanging = productDetailPage.getTitleText();

        productDetailPage.selectProductOption(selectedOption);

        String titleAfterChanging = productDetailPage.getTitleText(titleBeforeChanging);

        Assert.assertTrue(
                titleAfterChanging.contains(selectedOption.replace(" ", "")),
                "The selected option didn't change"
        );
    }
}
