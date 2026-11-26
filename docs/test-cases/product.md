# Product page test cases
___
[<<< Back to README](../../README.md)

___

## TC-PROD-001

- **Title:**  Verify that the Cart contains the selected product
- **Priority:** Critical
- **Preconditions:** The User is on the Home Page and is not logged in
- **Test Data:** Product to search: "Apple AirPods 4 with Active Noise Cancellation"

| Steps | Actions                                             | Expected result                                                                 |
|-------|-----------------------------------------------------|---------------------------------------------------------------------------------|
| 1     | Enter the Product to search into the Search field   | The Search field contains the Product to search                                 |
| 2     | Click the Search button                             | The Product search page is open with results according to the Product to search |
| 3     | Open the Product detail page for the second product | The Product detail page for the selected product is open                        |
| 4     | Click the Add to cart button                        | The Cart modal window is visible and contains the selected product              |

- **Automated:** [CartTest.java](../../src/test/java/tests/product/CartTest.java)

---

## TC-PROD-002

- **Title:**  Verify that the selected product memory option can be changed
- **Priority:** High
- **Preconditions:** The User is on the Home Page and is not logged in
- **Test Data:** Product to search: "Apple MacBook Neo 13 512Gb", Selected option: "256 Gb"

| Steps | Actions                                            | Expected result                                                                                     |
|-------|----------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| 1     | Enter the Product to search into the Search field  | The Search field contains the Product to search                                                     |
| 2     | Click the Search button                            | The Product search page is open with results according to the Product to search                     |
| 3     | Open the Product detail page for the first product | The Product detail page for the selected product is open and the title contains the memory capacity |
| 4     | Click the Selected option                          | The Product detail page is updated and the title contains the Selected option                       |

- **Automated:** [ProductOptionTest.java](../../src/test/java/tests/product/ProductOptionTest.java)

---

## TC-PROD-003

- **Title:**  Verify that the product price changes after increasing quantity
- **Priority:** High
- **Preconditions:** The User is on the Home Page and is not logged in
- **Test Data:** Product to search: "Apple MacBook Neo 13"

| Steps | Actions                                            | Expected result                                                                   |
|-------|----------------------------------------------------|-----------------------------------------------------------------------------------|
| 1     | Enter the Product to search into the Search field  | The Search field contains the Product to search                                   |
| 2     | Click the Search button                            | The Product search page is open with results according to the Product to search   |
| 3     | Open the Product detail page for the first product | The Product detail page for the selected product is open and the price is visible |
| 4     | Click the Increase quantity button                 | The product quantity is increased by 1 and the price is doubled                   |

- **Automated:** [ProductPriceTest.java](../../src/test/java/tests/product/ProductPriceTest.java)

---

## TC-PROD-004

- **Title:**  Verify that the Quantity field does not accept zero value
- **Priority:** Medium
- **Preconditions:** The User is on the Home Page and is not logged in
- **Test Data:** Product to search: "Dyson", Quantity value: "0"

| Steps | Actions                                              | Expected result                                                                            |
|-------|------------------------------------------------------|--------------------------------------------------------------------------------------------|
| 1     | Enter the Product to search into the Search field    | The Search field contains the Product to search                                            |
| 2     | Click the Search button                              | The Product search page is open with results according to the Product to search            |
| 3     | Open the Product detail page for the seventh product | The Product detail page for the selected product is open and the quantity field contains 1 |
| 4     | Enter the Quantity value into the Quantity field     | The product quantity is not changed                                                        |

- **Automated:** [QuantityFieldTest.java](../../src/test/java/tests/product/QuantityFieldTest.java)

---

## TC-PROD-005

- **Title:**  Verify that the Review name field validates input using Equivalence Partitioning
- **Priority:** Low
- **Preconditions:** The User is on the Home Page and is not logged in
- **Test Data:** Product to search: "Starlink", Short name: "Hu", Long name: "Hubert Blaine Wolfeschlegelsteinhausenbergerdorff", Valid name: "Hubert Blaine"

| Steps | Actions                                             | Expected result                                                                 |
|-------|-----------------------------------------------------|---------------------------------------------------------------------------------|
| 1     | Enter the Product to search into the Search field   | The Search field contains the Product to search                                 |
| 2     | Click the Search button                             | The Product search page is open with results according to the Product to search |
| 3     | Open the Product detail page for the second product | The Product detail page for the selected product is open                        |
| 4     | Open the Review tab                                 | The Review tab is open                                                          |
| 5     | Click the Write review button                       | The Review modal is open                                                        |
| 6     | Enter the Short name                                | The Name field contains the Short name                                          |
| 7     | Click the Submit button                             | The form is not submitted and the Name field displays an error style            |
| 8     | Enter the Long name                                 | The Name field contains the Long name                                           |
| 9     | Click the Submit button                             | The form is not submitted and the Name field displays an error style            |
| 10    | Enter the Valid name                                | The Name field contains the Valid name                                          |
| 11    | Click the Submit button                             | The form is not submitted and the Name field does not display an error style    |

- **Automated:** [ReviewTest.java](../../src/test/java/tests/product/ReviewTest.java)