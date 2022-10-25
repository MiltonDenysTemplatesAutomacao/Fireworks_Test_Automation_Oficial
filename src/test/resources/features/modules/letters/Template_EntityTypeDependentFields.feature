#Author: Milton Silva
#Regression testcase TL-67: Contains Any Of with multiple value selections, multiple conditions, and Match Any

@EntityTypeDependentFields
Feature: User-defined Letter Actions

  @EntityTypeDependentFieldsScenarios @Done @Letter
  Scenario: verify contains any of operator with multiple condition values
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #multiple values selected in a single condition will return anyone with either value
    And I navigate to smart search page
    And I click on create smart search button
    And I fill smart search name "ContainsAnyOfMultipleValues1210"
    And I select "does not equal" operator field group "0" condition "0" in smart search composer
    When I click on run search button
    Then I validate number of records "1–10 of 11"
    And I verify smart search results "Cade"
    And I verify smart search results "Douglas"
    And I verify smart search results "Jenkins"
    And I verify smart search results "Koss"
    And I verify smart search results "Olson"
#multiple values in separate conditions using match all will return records with both values
    And I navigate to smart search page
    And I click on create smart search button
    And I fill smart search name "ContainsAnyOfMultipleConditionsMatchAll1210"
    And I fill " " text group "0" condition "0"
    When I click on run search button
    And I verify smart search results "No search results to display."
  #multiple values in separate conditions using match any will return the same set as first search
    And I navigate to smart search page
    And I click on create smart search button
    And I fill smart search name "ContainsAnyOfMultipleConditionsMatchAny1210"
    And I select "equals" operator field group "0" condition "0" in smart search composer
    And I fill "Cade" text group "0" condition "0"
    And I select match "Match Any"
    When I click on run search button
    Then I validate number of records "1–1 of 1"
    And I verify smart search results "Cade"
