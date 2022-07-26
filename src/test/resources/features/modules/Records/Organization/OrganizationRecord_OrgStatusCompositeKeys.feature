#Author: Milton Silva
#Regression testcase TL-360: Organization Status: Composite keys

@OrganizationStatusCompositeKeys
Feature: Organization Status: Composite keys

  @OrganizationStatusCompositeKeysScenarios @Done @Organization
  Scenario: Record - Organization - verify Org status composite keys are respected
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name					  |Role		  |Phone		  |PhoneType  |Address1			|City	  |State	|PostalCode |Country	  |OrgStatus|OrgStatusDate|OrgStatusComments|
      |Degrassi High School   |High School|1-720-839-1112 |Business   |6221 E Colfax Ave|Denver   |Colorado |80220      |United States|Active   |11/11/2025   |Comment 1        |
      |                       |           |               |           |                 |         |         |           |             |Active   |11/11/2025   |Comment 2        |
      |                       |           |               |           |                 |         |         |           |             |         |11/12/2025   |                 |
    Then I validate if "Organization has been created." message is correct
    #to update org Status
    Given I navigate to status organization
    And I update organization status group "0" person 0
    When I click on Save Changes button in organization status
    Then I validate if "Organization has been updated." message is correct
    #to add a second org Status
    Given I close alert if return this message "Organization has been updated."
    When I click on add organization status "0"
    And I update organization status group "1" person 1
    Then I click on Save Changes button in organization status
    #to verify composite key validation messages are returned
    Given I validate if "Status must be different" message required for organization record is correct
    And I validate if "Status Date must be different." message required for organization record is correct
    And I click on close button on modal
    And I update organization status group "1" person 2
    When I click on Save Changes button in organization status
    Then I validate if "Organization has been updated." message is correct
