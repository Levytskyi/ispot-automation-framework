package tests.product;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductSearchPage;

public class ProductOptionTest extends BaseTest {

    @Test
    @Link(name = "TC-PROD-002", url = "https://github.com/Levytskyi/ispot-automation-framework/blob/main/docs/test-cases/product.md#tc-prod-002")
    @Feature("Product Page")
    @Description("Verify that the selected product memory option can be changed")
    @Severity(SeverityLevel.NORMAL)
    public void verifyMemoryOptionChange() {
        String productToSearch = "Apple iPhone 16 Pro Max 512Gb";
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
