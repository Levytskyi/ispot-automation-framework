package tests.search;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductSearchPage;

public class WishlistTest extends BaseTest {

    @Test
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
                "The wishlist counter didn't increase"
        );
    }
}
