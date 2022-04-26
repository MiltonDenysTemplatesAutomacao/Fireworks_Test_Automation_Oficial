#Author: Milton Silva
#Regression testcase TL-360: Organization Status: Composite keys

@OrganizationStatusCompositeKeys
Feature: Organization Status: Composite keys

  @OrganizationStatusCompositeKeysScenarios
  Scenario: verify Org status composite keys are respected
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name					  |Role		  |Phone		  |PhoneType  |Address1			|City	  |State	|PostalCode |Country	  |
      |Degrassi High School   |High School|1-720-839-1112 |Business   |6221 E Colfax Ave|Denver   |Colorado |80220      |United States|
    #Then I validate if "Organization has been created." message is correct
    #to update org Status
    Given I go to Home page
    And I quick search "Name"
    And I validate if "Name"summary opened properly
    When I open a record
    And I navigate to status organization
    And I update organization status group "0" person 0
    When I click on Save Changes button in organization status
