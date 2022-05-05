#Author: Milton Silva
#Regression testcase TL-53: Summary Panel Display
#NOTE This test updates the Summary Panel for this user but cleans up at the end

@SummaryPanelDisplay
Feature: Summary Panel Display

  @SummaryPanelDisplayPerson
  Scenario: verify fields can be added to the summary panel from an organization record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName	|LastName		|EmailAddress	     |EmailType  |EmailOptInMethod  |Role1  |
      |Hank         |Williams       |HWilliams@music.com |Personal   |Inquiry           |Person |
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
    Then I verify if summary "" data is correct
