@RestApi
Feature: Deletes a Pet

  Scenario: Deleting a pet

    When James deletes the pet with id "4"
    Then the pet with the id "4" should be deleted from the store