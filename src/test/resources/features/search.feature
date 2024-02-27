Feature: The objective of this feature is to test the search feature of the shopping portal

  Scenario Outline: Verifying Search Functionality on the Shopping Portal
    Given The User navigates to the home page of the shopping portal
    And The User inputs a valid "<Valid SKU>" into the search bar
    And The User clicks on the search icon
    Then The User should observe the amount of the articles is displayed as search results
    Examples:
      | Valid SKU |
      | WS12      |