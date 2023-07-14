@CartFeature
Feature: To automate the ecommerce site and validate cart functionalities
  This feature is to do test automation on ecommerce application

  Background: 
    Given User launches the ecommerce application


  @cart
  Scenario: To validate the cart functionality
    Given User add "4" items to the cart
    When User views the cart
    Then User verifies "4" items listed in the cart
    When User search for lowest price item
    And User able to remove the lowest price item from the cart
    Then User verifies "3" items listed in the cart
    