@WebFE
Feature: Manage my Product

  Scenario : James sees all the product categories
    Given James lands to home page
    When he chooses the category "Laptops"
    And  he add to cart the model "Sony vaio i5"
    #And  accept pop up information
    #Then the model added is shown on the product card section
