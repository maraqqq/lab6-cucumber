Feature: Product search tests

  Scenario: Search existing product
    Given I open the men's page
    When I search for "shirt"
    Then I should see products related to "shirt"

  Scenario: Search empty input shows products or message
    Given I open the men's page
    When I search for ""
    Then I should see at least 1 products on the page
