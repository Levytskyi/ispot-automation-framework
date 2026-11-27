package tests.search;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductSearchPage;

import java.util.List;

public class SearchResultsTest extends BaseTest {

    @Test
    @Link(name = "TC-SRCH-004", url = "https://github.com/Levytskyi/ispot-automation-framework/blob/main/docs/test-cases/product.md#tc-srch-004")
    @Feature("Search Page")
    @Description("Verify that the Search results contain the Product to search in their names")
    @Severity(SeverityLevel.CRITICAL)
    public void verifySearchResultsMatchProductToSearch() {
        String productToSearch = "Apple MacBook Neo";

        HomePage homePage = new HomePage();
        homePage.setSearchText(productToSearch);
        homePage.clickSearchButton();

        ProductSearchPage productSearchPage = new ProductSearchPage();

        List<String> products = productSearchPage.getProductNamesList();

        Assert.assertTrue(
                products
                        .stream()
                        .allMatch(e -> e.toLowerCase().contains(productToSearch.toLowerCase())),
                "Products names " + products + " don't all contain <" + productToSearch + ">"
        );
    }
}
