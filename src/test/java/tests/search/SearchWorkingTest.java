package tests.search;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductSearchPage;

import java.util.List;

public class SearchWorkingTest extends BaseTest {

    @Test
    public void verifySearchResultsMatchProductToSearch() {
        String productToSearch = "Apple MacBook Neo";

        HomePage homePage = new HomePage();
        homePage.setValueInSearchField(productToSearch);
        homePage.clickSearchButton();

        ProductSearchPage productSearchPage = new ProductSearchPage();

        List<String> products = productSearchPage.getProductNamesList();

        Assert.assertTrue(
                products.
                        stream().
                        allMatch(e -> e.toLowerCase().contains(productToSearch.toLowerCase())),
                "Products names " + products + " don't all contain <" + productToSearch + ">"
        );
    }
}
