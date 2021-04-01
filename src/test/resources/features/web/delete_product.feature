Feature: Delete Product

  Scenario: Deleting Product
    Given James lands to Cart page
    When he deletes the product "Dell i7 8gb"
    Then the product "Dell i7 8gb" is not shown