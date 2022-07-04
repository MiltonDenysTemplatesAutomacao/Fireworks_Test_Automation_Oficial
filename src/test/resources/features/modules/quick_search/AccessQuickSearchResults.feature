#Author: Milton Silva

@AccessQuickSearchResults
Feature: Search by name

  @AccessQuickSearchPersonResults @Done
  Scenario: Quick Search - access quick search results for person
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName	|LastName		|FullName				|Role1	        |Phone			|PhoneType|
      |Robert		|Brandon		|Robert Brandon	        |Person	        |(720) 839-1218	|Home	  |
    And I go to Home page
    When I quick search "Phone"
    Then I validate if result for "Phone" is correct
    And I open a record
    Then I validate if "Robert Brandon"summary opened properly

  @AccessQuickSearchOrganizationResults @Done
  Scenario: Quick Search - access quick search results for organization
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name				    |Role		|Phone			|PhoneType  |Address1			|Address2	|City   |State		|PostalCode |Country		|
      |BigMac Cooking School|High School|(720) 839-1118	|Business	|6208 E Colfax Ave	|33rd Floor	|Denver |Colorado   |80220	    |United States	|
    And I go to Home page
    When I quick search "Phone"
    Then I validate if result for "Phone" is correct
    And I open a record
    Then I validate if "BigMac Cooking School"summary opened properly

  @AccessQuickSearchStaffResults @Done
  Scenario: Quick Search - access quick search results for staff
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a staff
      |FirstName	|LastName	|FullName		|EmailAddress			|EmailType  |AccountStartDate	|AccountEndDate	|PermissionGroup|Phone          |
      |Officer		|BigMac	    |Officer BigMac	|obigmac@mcdonalds.com	|Personal	|07/10/2017			|07/10/2025		|Administrator	|(720) 839-1318 |
    And I go to Home page
    When I quick search "FullName"
    Then I validate if result for "FirstName" is correct
    And I open a record
    And I navigate to contact
    And I update phone number in contact for staff "(720) 839-1318", "Business", "Comments"
    And I click on save changes in contact for staff
    Then I validate if "Staff member has been updated" message is correct
    And I go to Home page
    When I quick search "Phone"
    Then I validate if result for "Phone" is correct
    And I open a record
    Then I validate if "Officer"summary opened properly
