Feature: Search

  Scenario: Search for an existing product
    Given I am logged in with username {string} and password {string}
    When I search for "Sauce Labs Backpack"
    Then the product results should include "Sauce Labs Backpack"
