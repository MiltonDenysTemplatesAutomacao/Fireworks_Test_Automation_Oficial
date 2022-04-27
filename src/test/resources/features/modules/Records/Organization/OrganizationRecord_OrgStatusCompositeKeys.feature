#Author: Milton Silva
#Regression testcase TL-360: Organization Status: Composite keys

@OrganizationStatusCompositeKeys
Feature: Organization Status: Composite keys

  @OrganizationStatusCompositeKeysScenarios
  Scenario: verify Org status composite keys are respected
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name					  |Role		  |Phone		  |PhoneType  |Address1			|City	  |State	|PostalCode |Country	  |OrgStatus|OrgStatusDate|OrgStatusComments|
      |Degrassi High School   |High School|1-720-839-1112 |Business   |6221 E Colfax Ave|Denver   |Colorado |80220      |United States|Active   |11/11/2025   |Comment 1        |
    Then I validate if "Organization has been created." message is correct
    #to update org Status
    And I navigate to status organization
    And I update organization status group "0" person 0
    When I click on Save Changes button in organization status
    Then I validate if "Organization has been updated." message is correct