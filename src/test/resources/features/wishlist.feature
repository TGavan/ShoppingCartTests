Feature: The objective of this feature is to test that item can be added to wishlist of shopping cart

  Scenario: Verifying that searched item can be added to the wish list successfully
    Given The User navigates to the home page of the shopping portal
    And The User clicks on the first image of the product displayed on the home page
    Then The product details page is displayed
    And User clicks on the Wish List link of the product
    And The User is navigated to the login page where he enters valid credentials
    Then The user is landed to the WishList Page
    And User can see the counter available for the items in this page


