Feature: Search Google
  Can I search Google?

Scenario: Search for Cheese
    Given I navigate to "http://www.google.com"
    And type "Cheese" to the search field
    When I click the I'm lucky button
    Then I can see "Cheese" in the page title

Scenario: Search for Milk
    Given I navigate to "http://www.google.com"
    And type "Milk" to the search field
    When I click the I'm lucky button
    Then I can see "Milk" in the page title
