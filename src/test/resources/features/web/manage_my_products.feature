@WebFE
Feature: Manage my products

  Scenario Outline: Adding product desired
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


  Scenario: Deleting Product
    Given James lands to Cart page
    When he deletes the product "Dell i7 8gb"
    Then the product "Dell i7 8gb" is not shown

  Scenario: purchasing products
    Given James sees the total price
    When he chooses Place order
    And fill the Place Order form
    And chooses Purchases
    Then he sees "Thank you for your purchase!" message
    And he sees the purchase id
    And he sees the purchase amount
    And the purchase amount is as expected

  Scenario: Closing lightBox Purchase
    When James chooses to confirm the purchase
    Then the lightbox disappear

  Scenario Outline: Browsing all the categories of the web
    Given James lands to home page
    When he chooses the category "<category>"
    Then the results list is shown
    And  the following model "<model title>" is shown

    Examples:
      | category | model title       |
      | Phones   | Samsung galaxy s6 |
      | Laptops  | Sony vaio i5      |
      | Monitors | Apple monitor 24  |