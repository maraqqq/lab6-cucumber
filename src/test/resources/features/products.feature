Feature: Display of products on Men's page

  Scenario: Verify product listing displays at least 6 products
    Given I open the men's page
    Then I should see at least 6 products on the page
