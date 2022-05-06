#Author: Milton Silva
#Regression testcase TL-53: Summary Panel Display
#NOTE This test updates the Summary Panel for this user but cleans up at the end

@SummaryPanelDisplay
Feature: Summary Panel Display

  @SummaryPanelDisplayPerson
  Scenario: verify fields can be added to the summary panel from an organization record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName	|LastName		|EmailAddress	     |EmailType  |EmailOptInMethod  |Role1   |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Hank         |Williams       |HWilliams@music.com |Personal   |Inquiry           |Student | Freshman  |Deposited            |Active-Deposited |08/18/2018       |Fall 2019|
    And I navigate to people on records
    And I open a people record by "Hank"
    And I validate if "Hank"summary opened properly
    When I add in summary field "Email Address"
    And I add in summary field "Class Of"
    And I add in summary field "High Score"
    And I add in summary field "Initial Category"
    And I add in summary field "Initial Source"
    And I add in summary field "Student Status Date"
    #to verify summary data
    Then I verify if summary field "Email Address" data is correct
    And I verify if summary field "Class Of" data is correct
    And I verify if summary field "High Score" data is correct
    And I verify if summary field "Initial Category" data is correct
    And I verify if summary field "Initial Source" data is correct
    And I verify if summary field "Student Status Date" data is correct
    #to delete summary tab fields
    Then I delete summary field "Email Address"
    And I delete summary field "Class Of"
    And I delete summary field "High Score"
    And I delete summary field "Initial Category"
    And I delete summary field "Initial Source"
    And I delete summary field "Student Status Date"

