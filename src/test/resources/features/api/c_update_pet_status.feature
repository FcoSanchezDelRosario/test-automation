@RestApi
Feature: Update a Pet in the store with from data

  Scenario: Updating a pet
    When James update the pet with the following information:
      | id | name | status |
      | 4  | otto | sold   |

    Then He find by the id 4 the pet updated
    And pet updated should include the following details:
      | name | status |
      | otto | sold   |
