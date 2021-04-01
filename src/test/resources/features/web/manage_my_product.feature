Feature: Manage my Product

  Scenario: Add Product to Cart
    Given James lands to home page
    When he chooses the category "Laptops"
    And he adds to cart the model "Sony vaio i5"
    And he accepts that the product is added
    Then the product "Sony vaio i5" is shown in Cart Page

