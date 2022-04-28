#Author: Milton Silva
#Regression testcase TL-1041:Organization: Required fields

@OrganizationRequiredFields
Feature: Organization: Required fields

  @OrganizationRequiredFieldsScenarios
  Scenario: organization record required fields
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name					  |Role		  |Phone		  |PhoneType  |Address1			|City	  |State	|PostalCode |Country	  |OrgStatus|OrgStatusDate|OrgStatusComments|
      |Degrassi High School   |High School|1-720-839-1112 |Business   |6221 E Colfax Ave|Denver   |Colorado |80220      |United States|Active   |11/11/2025   |Comment 1        |
