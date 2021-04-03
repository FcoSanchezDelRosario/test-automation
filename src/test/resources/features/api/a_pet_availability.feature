@RestApi
Feature: Pet Inventories

  Scenario: getting Pet Availability
    When James asks for the available pets
    Then he has the inventory of pets available
