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
    #Then I validate if "Organization has been created." message is correct
    When I create a person
      |FirstName|LastName |EmailAddress         |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Choker   |Campbell |BCampbell@music.com  |Personal   |Inquiry          |Student|Freshman   |Accepted             |Accepted         |03/17/2019       |Fall 2019|
    #And I validate if "Person has been created." message is correct
    #add employment comment to trigger required fields validation
    And I navigate to people on records
    And I open a people record by "Choker"
    And I validate if "Choker"summary opened properly
    And I navigate to Employment
    And I update Employment "", "", "", "", "Comment" group "0"
    And I click on "Save Changes"
