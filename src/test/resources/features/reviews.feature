Feature: Product review functionality

  Scenario: Submit a review using data table
    Given I open the men's page
    When I open quick view of product 1
    And I submit a review with:
      | field  | review              |
      | review | Great product, 5★   |
    Then I should see the review on the product page
