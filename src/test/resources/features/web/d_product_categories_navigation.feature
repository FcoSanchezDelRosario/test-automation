@WebFE
Feature: Navigate through product categories

  Scenario Outline: James sees all the product categories
    Given James lands to home page
    When he chooses the category "<category>"
    Then the results list is shown
    And  the following model "<model title>" is shown

    Examples:
      | category | model title       |
      | Phones   | Samsung galaxy s6 |
      | Laptops  | Sony vaio i5      |
      | Monitors | Apple monitor 24  |