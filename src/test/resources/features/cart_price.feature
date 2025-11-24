Feature: Cart price verification after add to cart

  Scenario: Add product to cart and verify price updates
    Given I open the men's page
    When I open quick view of product 1
    And I add product to cart
    Then The cart price should reflect the product price
