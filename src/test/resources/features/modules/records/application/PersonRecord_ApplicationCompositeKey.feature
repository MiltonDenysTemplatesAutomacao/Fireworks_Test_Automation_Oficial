#Author: Milton Silva
#Regression testcase TL-433: Cannot add duplicate Application records

@ApplicationCompositeKey
Feature: Application Composite Key

  @ApplicationCompositeKeyScenario @Done @Application
  Scenario: Record - Application - verify a duplicate application cannot be added to a student
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName |LastName  |EmailAddress                  |EmailType  |EmailOptInMethod |Role1   |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Reginald  |Mantle    |reginaldmantle@riverdale.edu  |Personal   |Inquiry          |Student |Freshman   |Accepted              |Accepted       |01/15/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    And I navigate to people on records
    And I open a people record by "Reginald"
    And I validate if "Reginald"summary opened properly
    And I navigate to Applications
    When I update application "Fall 2016", "Agriculture", "Completed", "Early Action", "Online", "07/19/2016", "", "", "", "", "", "", "", "" group "0"
    And I click on save changes on Application
    And I close alert if return this message "Person has been updated."
    And I add application "0"
    When I update application "Fall 2016", "Agriculture", "Completed", "Early Action", "Online", "07/19/2016", "", "", "", "", "", "", "", "" group "1"
    And I click on save changes on Application
    And I verify validation message "Application 2: Entry Term must be different."
    And I verify validation message "Application 2: Major 1 must be different."
    And I verify validation message "Application 2: Type must be different."
