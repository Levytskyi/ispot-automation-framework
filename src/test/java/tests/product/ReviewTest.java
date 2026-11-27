package tests.product;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductSearchPage;

public class ReviewTest extends BaseTest {

    @Test
    @Link(name = "TC-PROD-005", url = "https://github.com/Levytskyi/ispot-automation-framework/blob/main/docs/test-cases/product.md#tc-prod-005")
    @Feature("Product Page")
    @Description("Verify that the Review name field validates input using Equivalence Partitioning")
    @Severity(SeverityLevel.TRIVIAL)
    public void verifyNameFieldEquivalencePartitioning() {
        String productToSearch = "Starlink";
        int productIndex = 2;
        String shortName = "Hu";
        String longName = "Hubert Blaine Wolfeschlegelsteinhausenbergerdorff";
        String validName = "Hubert Blaine";

        HomePage homePage = new HomePage();
        homePage.setSearchText(productToSearch);
        homePage.clickSearchButton();

        ProductSearchPage productSearchPage = new ProductSearchPage();
        productSearchPage.openSelectedProductDetailPage(productIndex);

        ProductDetailPage productDetailPage = new ProductDetailPage();
        productDetailPage.openReviewTab();
        productDetailPage.openReviewModal();

        productDetailPage.setValueReviewNameField(shortName);
        productDetailPage.clickSubmitReview();

        Assert.assertTrue(
                productDetailPage.isReviewNameFieldErrorStyleDisplayed(),
                "Error style should be displayed for name shorten than 3 characters"
        );

        productDetailPage.setValueReviewNameField(longName);
        productDetailPage.clickSubmitReview();

        Assert.assertTrue(
                productDetailPage.isReviewNameFieldErrorStyleDisplayed(),
                "Error style should be displayed for name longer than 25 characters"
        );

        productDetailPage.setValueReviewNameField(validName);
        productDetailPage.clickSubmitReview();

        Assert.assertFalse(
                productDetailPage.isReviewNameFieldErrorStyleDisplayed(),
                "Error style should not be displayed for name between 3 and 25 characters"
        );
    }
}
