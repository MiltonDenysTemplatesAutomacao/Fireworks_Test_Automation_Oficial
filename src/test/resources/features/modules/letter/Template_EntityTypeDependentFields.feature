#Author: Milton Silva
#Regression testcase TL-67: Contains Any Of with multiple value selections, multiple conditions, and Match Any

@EntityTypeDependentFields
Feature: User-defined Letter Actions

  @EntityTypeDependentFieldsScenarios @Done @Letter
  Scenario: verify contains any of operator with multiple condition values
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
#    When I create a person
#      |FirstName |LastName  |EmailAddress               |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate |EntryTerm|LetterName                      |LetterFormat                   |LetterContent                                             |SmartSearch                    |
#      |Peter     |Griffin   |petergriffin@gangsters.com |Personal   |Student Search   |Student|Freshman   |Accepted             |Accepted         |01/15/2019        |Fall 2019|Create Person MultipleValues1210|Letter (8.5 x 11 no letterhead)|Content for Create Person ContainsAnyOfMultipleValues1210 |ContainsAnyOfMultipleValues1210|
#    And I validate if "Person has been created." message is correct
    #multiple values selected in a single condition will return anyone with either value
    And I navigate to smart search page
    And I click on create smart search button
    And I select "Last Name" search field group "0" condition "0" in smart search composer
    And I select "equals" operator field group "0" in smart search composer
    And I fill "Wintheiser" text condition value group "0"
    When I add a new group on smart search composer "0"
    And I select "Last Name" search field group "1" condition "0" in smart search composer
    And I select "equals" operator field group "1" in smart search composer
    And I fill "Kohler " text condition value group "1"
    And I fill smart search name "ContainsAnyOfMultipleValues1210"
    And I click on save this search button
    And I close alert if return this message "Smart Search has been created."
    And I navigate to smart search page
    And I open smart search "ContainsAnyOfMultipleValues1210"
    When I click on run search button
    And I verify smart search results "Grimaldi, Caroline"

    And I verify results on smart search table "ContainsAnyOfMultipleValues1210"
