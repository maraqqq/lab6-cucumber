Feature: Quick view product details

  Scenario: Open quick view for product 1 and verify details
    Given I open the men's page
    When I open quick view of product 1
    Then Quick view should show correct product details
