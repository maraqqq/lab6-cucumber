Feature: Contact section tests

  Scenario: Contact link redirects to contact page or shows contact content
    Given I open the men's page
    When I click Contact link
    Then I should be on contact page or see contact related content
