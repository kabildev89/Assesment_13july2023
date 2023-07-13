@EbayFeature
Feature: To automate the ebay site
  This feature is to do test Automation on ebay website

  @ebay
  Scenario Outline: Search and verify the items in ebay website
    Given User launch the ebay application
    When I search for an item "<itemname>" as a non-registered customer
    Then I get a list of matching results
    And the resulting items cards show: postage price, No of bids, price or show BuyItNow tag
    When I sort the results by Lowest Price
    Then the results are listed in the page in the ascending order
    When I sort the results by Highest Price
    Then the results are listed in the page in the descending order

    Examples: 
      | itemname |
      | speaker  |

@ebay
  Scenario Outline: : Search and navigate through results pages
    Given User launch the ebay application
    When I search for an item "<itemname>" as a non-registered customer
    Then I get a list of matching results
    And The results show more than one page
    And The user can navigate through the pages to continue looking at the items

    Examples: 
      | itemname |
      | speaker  |

  @Api
  Scenario: API Automation
    Given User validates the GET request
    Given User validates the POST request
