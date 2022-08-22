#Author: Milton Silva
#Regression testcase TL-1144: Employment: Required fields

@EmploymentRequiredFields
Feature: Employment Required Field

  @EmploymentRequiredFieldsScenario @Done @Employment
  Scenario: Record - Employment - employment required fields
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name					    |Role		|Address1		  |City	               |State	   |PostalCode |Country	     |
      |Stagecoach Data Systems  |Institution|53 Wild Horse St |Egg Harbor Township |New Jersey |08234      |United States|
    Then I validate if "Organization has been created." message is correct
    When I create a person
      |FirstName|LastName |EmailAddress         |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Choker   |Campbell |BCampbell@music.com  |Personal   |Inquiry          |Student|Freshman   |Accepted             |Accepted         |03/17/2019       |Fall 2019|
    And I validate if "Person has been created." message is correct
    #add employment comment to trigger required fields validation
    And I navigate to people on records
    And I open a people record by "Choker"
    And I validate if "Choker"summary opened properly
    And I navigate to Employment
    And I update Employment "", "", "", "", "Comment" group "0"
    And I click on "Save Changes"
    #correct validation messages are returned
    And I verify validation message "The Employer field is required."
    And I verify validation message "The Position field is required."
    And I verify validation message "The Start Date field is required."
    And I click on close button on modal
    #employment record can be added
    And I pick an organization Employer "Stagecoach Data Systems" group "0"
    And I update Employment "Position", "11/11/2012", "", "", "" group "0"
    And I click on "Save Changes"
    And I close alert if return this message "Person has been updated."
    And I verify Employment "Stagecoach Data Systems", "Position", "11/11/2012", "", "", "Comment" group "0"


