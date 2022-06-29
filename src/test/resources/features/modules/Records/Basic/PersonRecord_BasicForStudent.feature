#Author: Milton Silva
#Regression testcase TL-416: Basic: Student data can be added

@BasicStudentDataCanBeAdded
Feature: Basic: Student data can be added

  @BasicStudentDataCanBeAddedScenario @Done
  Scenario: Record - Basic - verify data can be added to the basic panel of a student record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |EmailAddress       |EmailType|EmailOptInMethod |Role1   |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm  |
      |Roy        |Orbison   |ROrbison@music.com |Personal |Inquiry          |Student |Freshman   |Accepted             |Accepted     |01/15/2016       |Fall 2017  |
    And I validate if "Person has been created." message is correct
    And I validate if "Roy"summary opened properly
    And I go to Home page
    When I quick search "FirstName"
    And I open a record
    And I navigate to basic
    And I update birth values "", "United States", "Vernon", "Texas"
    And I update "United States Citizen", "United States" and "588-23-9874" to update citizenship
    And I update culture values "Hispanic / Latino", "Asian", "Female", "Single", "Russian", "Pagan"
    And I update initial Source values "Campus Events", "Admitted Student Day: Attend"
    And I update context values "(GMT-08:00) Alaska", "2016", "10"
    And I update record flags "Deceased", "Student Flag", "FirstGeneration", "InternationalStudent", "legacy", "StateResident", ""
    And I click on save changes on basic
    Then I close alert if return this message "Person has been updated."
    And I verify birth values "", "United States", "Vernon", "Texas"
    And I verify citizenship values "United States Citizen", "United States" and "588-23-9874"
    And I verify culture values "Hispanic / Latino", "Asian", "Female", "Single", "Russian", "Pagan"
    And I verify initial Source values "Campus Events", "Admitted Student Day: Attend"
    And I verify context values "", "(GMT-08:00) Alaska", "2016", "10"
    And I verify record flags "Deceased", "Student Flag", "FirstGeneration", "InternationalStudent", "Legacy", "StateResident", ""

