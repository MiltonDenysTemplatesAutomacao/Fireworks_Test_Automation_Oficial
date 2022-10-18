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
    And I select "equals" operator field group "0" condition "0" in smart search composer
    And I fill "Kiana" text group "0" condition "0"
    When I add a new group on smart search composer "0"
    And I select "First Name" search field group "1" condition "0" in smart search composer
    And I select "equals" operator field group "1" condition "0" in smart search composer
    And I fill "Cade" text group "1" condition "0"
    And I select match "Match Any"
    And I click on save this search button
#    And I navigate to smart search page
#    And I open smart search "ContainsAnyOfMultipleValues1210"
#    When I click on run search button
    And I verify smart search results "Wintheiser"
#    And I verify results on smart search table "ContainsAnyOfMultipleValues1210"
  #multiple values in separate conditions using match all will return records with both values
#    And I navigate to smart search page
#    And I open smart search "ContainsAnyOfMultipleValues1210"

