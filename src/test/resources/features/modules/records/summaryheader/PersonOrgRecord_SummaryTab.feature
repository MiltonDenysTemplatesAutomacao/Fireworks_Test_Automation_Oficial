#Author: Milton Silva
#Regression testcase TL-53: Summary Panel Display
#NOTE This test updates the Summary Panel for this user but cleans up at the end

@SummaryPanelDisplay
Feature: Summary Panel Display

  @SummaryPanelDisplayPerson @Done @SummaryHeader
  Scenario: Record - SummaryHeader - verify fields can be added to the summary panel from an organization record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName	|LastName		|EmailAddress	     |EmailType  |EmailOptInMethod  |Role1   |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Hank         |Williams       |HWilliams@music.com |Personal   |Inquiry           |Student | Freshman  |Deposited            |Active-Deposited |08/18/2018       |Fall 2019|
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

  @SummaryPanelDisplayOrganization @Done @SummaryHeader
  Scenario: Record - SummaryHeader - verify fields can be added to the summary panel from an organization record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name					               |Role	    |Address1		    |City	    |State	      |PostalCode |Country	      |
      |TheTestamentOfDrMabuse High School  |High School |543 Campfire Drive |Phoenix    |Arizona      |85001      |United States  |
    And I validate if "TheTestamentOfDrMabuse High School"summary opened properly
    When I add in summary organization field "Org Informal Name"
    When I add in summary organization field "Phone Number"
    When I add in summary organization field "Time Zone"
    When I add in summary organization field "Organization Fireworks ID"
    #to verify summary data
    Then I verify if summary organization field "Org Informal Name" data is correct
    Then I verify if summary organization field "Phone Number" data is correct
    Then I verify if summary organization field "Organization Fireworks ID" data is correct
    Then I verify if summary organization field "Time Zone" data is correct
    #to delete summary tab fields
    Then I delete summary organization field "Org Informal Name"
    Then I delete summary organization field "Phone Number"
    Then I delete summary organization field "Organization Fireworks ID"
    Then I delete summary organization field "Time Zone"


