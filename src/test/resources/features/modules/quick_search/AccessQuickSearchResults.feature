#Author: Milton Silva

@AccessQuickSearchResults
Feature: Search by name

  @AccessQuickSearchPersonResults
  Scenario: access quick search results for person
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName	|LastName		|FullName				|Role1	        |Phone			|PhoneType|
      |Robert		|Brandon		|Robert Brandon	        |Person	        |(720) 839-1218	|Home	  |
    And I go to Home page
    When I quick search "Phone"
    Then I validate if result for "Phone" is correct
    And I open a record
    Then I validate if "Fullname"summary opened properly

  @AccessQuickSearchOrganizationResults
  Scenario: access quick search results for organization
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name				    |Role		|Phone			|PhoneType  |Address1			|Address2	|City   |State		|PostalCode |Country		|
      |BigMac Cooking School|High School|(720) 839-1118	|Business	|6208 E Colfax Ave	|33rd Floor	|Denver |Colorado   |80220	    |United States	|
    And I go to Home page
    When I quick search "Phone"
    Then I validate if result for "Phone" is correct
    And I open a record
    Then I validate if "Name"summary opened properly

  @AccessQuickSearchStaffResults
  Scenario: access quick search results for staff
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a staff
      |FirstName	|LastName	|FullName		|EmailAddress			|EmailType  |AccountStartDate	|AccountEndDate	|PermissionGroup|Phone			|PhoneType|Comment  |
      |Officer		|BigMac	    |Officer BigMac	|obigmac@mcdonalds.com	|Personal	|07/10/2017			|07/10/2025		|Administrator	|(720) 839-1318 |Business |Comments |
    And I go to Home page
    When I quick search "FullName"
    Then I validate if result for "Officer" is correct
    And I open a record
    And I navigate to contact
    When I update "Phone", "PhoneType" and "Comment" to update phone number
    Then I validate if "Staff member has been updated" message is correct
    And I go to Home page
    When I quick search "Phone"
    Then I validate if result for "Phone" is correct
    And I open a record
    Then I validate if "Name"summary opened properly
