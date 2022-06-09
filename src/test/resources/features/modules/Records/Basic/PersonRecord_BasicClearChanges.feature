#Author: Milton Silva
#Regression testcase TL-36: Basic: Clear Changes

@BasicClearChanges
Feature: Basic: Student data can be added

  @BasicClearChangesScenario
  Scenario: Record - Basic - verify clear changes removes unsaved data from the Basic tab
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |EmailAddress           |EmailType|EmailOptInMethod |Role1   |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm  |
      |Elvis      |Presley   |elvisPresley@music.com |Personal |Inquiry          |Student |Freshman   |Accepted             |Accepted     |01/15/2016       |Fall 2017  |
    #And I validate if "Person has been created." message is correct
    And I go to Home page
    When I quick search "FirstName"
    And I open a record
    And I navigate to basic
    And I update birth values "12/25/1926", "United States", "Marfa", "Texas"
    And I update "United States Citizen", "United States" and "588-23-9879" to update citizenship
    And I update culture values "Hispanic / Latino", "Asian", "Female", "Single", "Russian", "Pagan"
    And I update initial Source values "Campus Events", "Admitted Student Day: Attend"
    And I update context values "(GMT-06:00) Mountain Time (US & Canada)", "2016", "10"
    And I update record flags "Deceased", "Student Flag", "FirstGeneration", "InternationalStudent", "legacy", "StateResident", "Veteran"
    And I verify birth values "12/25/1926", "United States", "Marfa", "Texas"
    And I verify citizenship values "United States Citizen", "United States" and "588-23-9879"
    And I verify culture values "Hispanic / Latino", "Asian", "Female", "Single", "Russian", "Pagan"
    And I verify initial Source values "Campus Events", "Admitted Student Day: Attend"
    And I verify context values "(GMT-06:00) Mountain Time (US & Canada)", "2016", "10"
    And I verify record flags "Deceased", "Student Flag", "FirstGeneration", "InternationalStudent", "Legacy", "StateResident", "Veteran"
    And I click on clear changes on Basic
    And I verify birth values "", "Select", "", "Select"
    And I verify citizenship values "Select", "Select" and ""
    And I verify culture values "Select", "", "Select", "Select", "Select", "Select"
    And I verify initial Source values "Select", "Select"
    And I verify context values "Select Time Zone", "Select", "Select"
    And I verify record flags "", "", "", "", "", "", ""