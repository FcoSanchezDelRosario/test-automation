@RestApi
Feature: Add a new Pet to the Store

  Scenario: adding a new pet
    Given the following pet information:
      | id | category_id | category_name | name | status    |
      | 4  | 1           | golden        | otto | available |

    When James adds the new pet to the store
    Then He find by id the new pet added
    And the new pet added should include the following details:
      | id | category_id | category_name | name | status    |
      | 4  | 1           | golden        | otto | available |