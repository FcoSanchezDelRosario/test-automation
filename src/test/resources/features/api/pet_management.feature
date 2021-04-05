@RestApi
Feature: Pet Management

  Scenario: getting Pet Availability
    When James asks for the available pets
    Then he has the inventory of pets available

  Scenario: adding a new pet
    Given the following pet information:
      | id | category_id | category_name | name | status    |
      | 4  | 1           | golden        | otto | available |

    When James adds the new pet to the store
    Then He find by id the new pet added
    And the new pet added should include the following details:
      | id | category_id | category_name | name | status    |
      | 4  | 1           | golden        | otto | available |

  Scenario: Updating a pet
    When James update the pet with the following information:
      | id | name | status |
      | 4  | otto | sold   |

    Then He find by the id 4 the pet updated
    And pet updated should include the following details:
      | name | status |
      | otto | sold   |

  Scenario: Deleting a pet

    When James deletes the pet with id "4"
    Then the pet with the id "4" should be deleted from the store