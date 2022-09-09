#Author: Milton Silva
#Regression testcase TL-205: Exact match auto-merge on rule 14: Transposed FN-Transposed LN-SSN
#Regression testcase TL-1002: Initial Source should reflect the earliest non-system Action

@InitialSourceEarliestAction
Feature: Basic: Initial Source should reflect the earliest non-system Action

  @InitialSourceEarliestActionScenario1 @Fix
  Scenario: Record - Basic - verify the initial source values display the earliest action
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |Address1     |City   |State       |PostalCode|Country      |Role1   |StudentType  |StudentStatusCategory |StudentStatus    |StudentStatusDate|EntryTerm   |Category      |Action                         |Staff        |ActionDateTime     |ActionDateField|
      |Arujo      |Daisy    |70 Water St. |Mystic |Connecticut |06388     |United States|Student |Non-degree   |Inquiry               |Inquiry-Inactive |08/21/2019       |Spring 2020 |Campus Events |Admitted Student Day: Attend   |Fire Starter |09/29/2017 2:00 PM |09/29/2017     |
      |           |         |             |       |            |          |             |        |             |                      |                 |                 |            |Campus Events |Admitted Student Day: Register |Fire Starter |09/01/2017 4:00 PM |09/01/2017     |
    And I validate if "Person has been created." message is correct
    #to add an action
    And I go to Home page
    When I quick search "FirstName"
    And I open a record
    And I validate if "Arujo"summary opened properly
    And I navigate to Actions
    And I click on add action button
    And I update action person "0"
    Then I click on Save Changes button in Actions
    And I validate if "Action has been created." message is correct
    #to verify the initial source values
    And I navigate to basic
    And I verify initial Source values "Campus Events", "Admitted Student Day: Attend"
    #to add an earlier action
    And I navigate to Actions
    And I click on add action button
    And I update action person "1"
    Then I click on Save Changes button in Actions
    And I validate if "Action has been created." message is correct
    #to verify the initial source values were updated
    And I navigate to basic
    And I verify initial Source values "Campus Events", "Admitted Student Day: Register"
    And I update "", "" and "588239874" to update citizenship
    And I click on save changes on basic
    And I validate if "Person has been updated." message is correct

  @InitialSourceEarliestActionScenario2 @Fix
  Scenario: Record - Basic - to add another record to be merged
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |Phone      |PhoneType|Role1   |StudentType  |StudentStatusCategory |StudentStatus    |StudentStatusDate|EntryTerm   |Category      |Action                         |Staff        |ActionDateTime     |ActionDateField|
      |Daisy      |Arujo    |8605363700 |Business |Student |Non-degree   |Inquiry               |Inquiry-Inactive |08/21/2019       |Spring 2020 |Campus Events |Admitted Student Day: Attend   |Fire Starter |08/01/2017 6:00 PM |08/01/2017     |
    And I validate if "Person has been created." message is correct
    #to add the earliest action
    And I go to Home page
    When I quick search "FirstName"
    And I open a record
    And I validate if "Arujo"summary opened properly
    And I navigate to Actions
    And I click on add action button
    And I update action person "0"
    Then I click on Save Changes button in Actions
    And I validate if "Action has been created." message is correct
    And I navigate to basic
    And I verify initial Source values "Campus Events", "Admitted Student Day: Attend"
    And I update "", "" and "104061988" to update citizenship
    And I click on save changes on basic
    And I validate if "A duplicate Student record was found and automatically merged with the new record." message is correct
    #to verify the initial source values on merged record are the earliest action
    And I go to Home page
    When I quick search "FirstName"
    And I open a record
    And I validate if "Arujo"summary opened properly
    And I verify initial Source values "Campus Events", "Admitted Student Day: Attend"
