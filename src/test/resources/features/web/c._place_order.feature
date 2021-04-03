@WebFE
Feature: Place Order

  @ScenarioC
  Scenario: purchasing products
    Given James sees the total price
    When he chooses Place order
    And fill the Place Order form
    And chooses Purchases
    Then he sees "Thank you for your purchase!" message
    And he sees the purchase id
    And he sees the purchase amount
    And the purchase amount is as expected