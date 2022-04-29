#Author: Milton Silva
#Regression testcase TL-1041:Organization: Required fields

@OrganizationRequiredFields
Feature: Organization: Required fields

  @OrganizationRequiredFieldsAlertMessages
  Scenario: to click Save with no data entered and verify alert messages
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I navigate to QuickAddCreateOrganizationPage
    And I clickQuickAddOrganizationSaveAndGo
    Then I validate if "The Organization Name field is required." message alert for organization required is correct
    And I validate if "The Role field is required." message alert for organization required is correct
    And I validate if "The Address 1 field is required." message alert for organization required is correct
    And I validate if "The City/Town field is required." message alert for organization required is correct
    And I validate if "The Postal Code field is required." message alert for organization required is correct
    And I validate if "The Country field is required." message alert for organization required is correct


  @OrganizationRequiredFieldsScenarios
  Scenario: to create a high school without adding a phone number
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create an organization
      |Name					            |Role		  |Address1			|City	    |State	  |PostalCode |Country	    |
      |GideonOfScotlandYard High School |High School  |360 Highland Road|Brunswick  |Georgia  |31525      |United States|
    Then I validate if "Organization has been created." message is correct
