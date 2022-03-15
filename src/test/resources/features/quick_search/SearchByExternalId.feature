#Author: Milton Silva

@SearchById
Feature: Search by external Id

  @SearchPersonIdRecord
  Scenario: to Quick Search for a person External Id
    Given I login as firestarter
    And I create a person
      |Firstname	|Lastname	|Fullname	|EmailAddress	|EmailType		|EmailOptInMethod	|Role1	|Type                 |ID Number|Who Added ID   |
      |Andre 		|Lamb		|Andre Lamb |andre@lamb.com	|Personal		|Inquiry			|Person	|College Board Search |00199    |Alanis Flatley |
    And I go to Home page
    When I quick search "Firstname"
    And I open a record
    And I navigate to ID Types
    When I update "Type", "ID Number", "", "Who Added ID", and "" to update external ID Types for person
    And I go to Home page
    When I quick search "ID Number"
    Then I validate if result for "ID Number" is correct

  @SearchOrganizationIdRecord
  Scenario: to Quick Search for an organization External Id
    Given I login as firestarter
    And I create an organization
      |Name					  |Role		  |Phone		|PhoneType  |Address1			|Address2	|City	|State	|PostalCode|Country			|Type  |ID Number|Who Added ID   |
      |Abraham Drawing School |High School|888-411-1689	|Business	|210 Sixth Avenue	|33rd Floor	|Denver|Colorado|80220		|United States	|CEEB  |46858    |Alanis Flatley |
    And I go to Home page
    When I quick search "Name"
    And I open a record
    And I navigate to ID Types
    When I update "Type", "ID Number", "", "Who Added ID", and "" to update external ID Types for organization
    And I go to Home page
    When I quick search "ID Number"
    Then I validate if result for "ID Number" is correct