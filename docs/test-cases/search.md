# Search page test cases
___
[<<< Back to README](../../README.md)

___

## TC-SRCH-001

- **Title:**  Verify that the Load more products button loads additional products
- **Priority:** Low
- **Preconditions:** The User is on the Home Page and is not logged in
- **Test Data:** Product to search: "iPhone"

| Steps | Actions                                           | Expected result                                                                 |
|-------|---------------------------------------------------|---------------------------------------------------------------------------------|
| 1     | Enter the Product to search into the Search field | The Search field contains the Product to search                                 |
| 2     | Click the Search button                           | The Product search page is open with results according to the Product to search |
| 3     | Click the Load more products button               | The quantity of visible products on the Product search page is increased        |

- **Automated:** [LoadMoreProductsTest.java](../../src/test/java/tests/search/LoadMoreProductsTest.java)

---

## TC-SRCH-002

- **Title:**  Verify that products can be sorted by price in ascending order
- **Priority:** Low
- **Preconditions:** The User is on the Home Page and is not logged in
- **Test Data:** Product to search: "iPhone 17 Pro"

| Steps | Actions                                           | Expected result                                                                 |
|-------|---------------------------------------------------|---------------------------------------------------------------------------------|
| 1     | Enter the Product to search into the Search field | The Search field contains the Product to search                                 |
| 2     | Click the Search button                           | The Product search page is open with results according to the Product to search |
| 3     | Select the Cheaper first sorting option           | The products are sorted by price in ascending order                             |

- **Automated:** [ProductSortingTest.java](../../src/test/java/tests/search/ProductSortingTest.java)

---  

## TC-SRCH-003

- **Title:**  Verify that the Quick view modal opens for the selected product
- **Priority:** Low
- **Preconditions:** The User is on the Home Page and is not logged in
- **Test Data:** Product to search: "EcoFlow"

| Steps | Actions                                               | Expected result                                                                 |
|-------|-------------------------------------------------------|---------------------------------------------------------------------------------|
| 1     | Enter the Product to search into the Search field     | The Search field contains the Product to search                                 |
| 2     | Click the Search button                               | The Product search page is open with results according to the Product to search |
| 3     | Click the Quck view button on the second product card | The Quick view modal is open and the title contains the selected product name   |

- **Automated:** [QuickViewTest.java](../../src/test/java/tests/search/QuickViewTest.java)

---

## TC-SRCH-004

- **Title:**  Verify that the Search results contain the Product to search in their names
- **Priority:** High
- **Preconditions:** The User is on the Home Page and is not logged in
- **Test Data:** Product to search: "Apple MacBook Neo"

| Steps | Actions                                           | Expected result                                                                                     |
|-------|---------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| 1     | Enter the Product to search into the Search field | The Search field contains the Product to search                                                     |
| 2     | Click the Search button                           | The Product search page is open and the search results contain the Product to search in their names |

- **Automated:** [SearchResultsTest.java](../../src/test/java/tests/search/SearchResultsTest.java)

---  

## TC-SRCH-005

- **Title:**  Verify that the Wishlist counter can be increased by 1
- **Priority:** Low
- **Preconditions:** The User is on the Home Page and is not logged in
- **Test Data:** Product to search: "Apple Watch"

| Steps | Actions                                                    | Expected result                                                                                                     |
|-------|------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|
| 1     | Enter the Product to search into the Search field          | The Search field contains the Product to search                                                                     |
| 2     | Click the Search button                                    | The Product search page is open with results according to the Product to search and the Wishlist counter displays 0 |
| 3     | Click the Add to Wishlist button on the third product card | The Wishlist counter is increased by 1                                                                              |

- **Automated:** [WishlistTest.java](../../src/test/java/tests/search/WishlistTest.java)