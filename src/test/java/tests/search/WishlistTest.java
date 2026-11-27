package tests.search;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductSearchPage;

public class WishlistTest extends BaseTest {

    @Test
    @Link(name = "TC-SRCH-005", url = "https://github.com/Levytskyi/ispot-automation-framework/blob/main/docs/test-cases/product.md#tc-srch-005")
    @Feature("Search Page")
    @Description("Verify that the Wishlist counter can be increased by 1")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyWishlistCountCanIncrease() {
        String productToSearch = "Apple Watch";
        int productIndex = 3;

        HomePage homePage = new HomePage();
        homePage.setSearchText(productToSearch);
        homePage.clickSearchButton();

        ProductSearchPage productSearchPage = new ProductSearchPage();
        int counterBeforeAdding = productSearchPage.getWishlistCounterValue();

        productSearchPage.addProductToWishlist(productIndex);

        int counterAfterAdding = productSearchPage.getWishlistCounterValue(counterBeforeAdding);

        Assert.assertEquals(
                counterAfterAdding,
                counterBeforeAdding + 1,
                "The wishlist counter didn't increase by 1"
        );
    }
}
