Feature: My Products Management

  Scenario Outline: Add Product to Cart
    Given James lands to home page
    When he chooses the category "<category>"
    And he adds to cart the model "<card>"
    And he accepts that the product is added
    And he chooses "<brand>" brand
    Then the product "<card>" is shown in Cart Page

    Examples:
      | category | brand | card         |
      | Laptops  | Cart  | Sony vaio i5 |
      | Laptops  | Cart  | Dell i7 8gb  |


  Scenario: Delete Product
    Given James lands to Cart page
    When he deletes the product "Dell i7 8gb"
    Then the product "Dell i7 8gb" is not shown

  Scenario: Placer order
    Given James sees the total price
    When he chooses Place order
    And fill the Place Order form
    And chooses Purchases
    Then he sees "Thank you for your purchase!" message
    And he sees the purchase id
    And he sees the purchase amount
    And the purchase amount is as expected

