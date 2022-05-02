#Author: Milton Silva
#Regression testcase TL-244: Search by Phone
#Regression testcase TL-56: Access Quick Search Results

@SearchByPhoneNumber
Feature: Search by phone number

  @SearchPersonPhoneNumber
  Scenario: to Quick Search a person by Phone Number, partial, with or without dashes, spaces or parenthesis
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |Firstname|Lastname	|Phone		 |PhoneType |Role1	|PhoneFormatted|
      |Stacy	|Rose		|720-839-1384|Home	    |Person	|(720) 839-1384|
    And I go to Home page
    When I quick search "Phone"
    Then I validate if result for "PhoneFormatted" is correct
    And I go to Home page
    When I quick search partial "Phone"
    Then I validate if result for "PhoneFormatted" is correct
    And I go to Home page
    When I quick search "PhoneFormatted"
    Then I validate if result for "PhoneFormatted" is correct

  @SearchOrganizationPhoneNumber
  Scenario: to Quick Search an organization by Phone Number, partial, with or without dashes, spaces or parenthesis
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name					  |Role		  |Phone		|Role1	|PhoneFormatted|PhoneType   |Address1			|Address2	|City   |State		|PostalCode |Country		|
      |Carmel Personal School |High School|720-839-4781	|Person	|(720) 839-4781|Business	|6208 E Colfax Ave	|33rd Floor	|Denver |Colorado   |80220	    |United States	|
    And I go to Home page
    When I quick search "Phone"
    Then I validate if result for "PhoneFormatted" is correct
    And I go to Home page
    When I quick search partial "Phone"
    Then I validate if result for "PhoneFormatted" is correct
    And I go to Home page
    When I quick search "PhoneFormatted"
    Then I validate if result for "PhoneFormatted" is correct

  @SearchStaffPhoneNumber
  Scenario: to Quick Search a staff by Phone Number, partial, with or without dashes, spaces or parenthesis
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a staff
      |FirstName	|LastName	|FullName		|EmailAddress		|EmailType  |AccountStartDate	|AccountEndDate	|PermissionGroup|PhoneFormatted	|Phone        |PhoneType|Comment  |
      |Roddy		|Lucky	    |Roddy Lucky	|Lucky@Roddy.com	|Personal	|07/10/2017			|07/10/2025		|Administrator	|(720) 839-4163 |720-839-4163 |Business |Comments |
    And I go to Home page
    When I quick search "FirstName"
    Then I validate if result for "FirstName" is correct
    And I open a record
    And I navigate to contact
    When I update "Phone", "PhoneType" and "Comment" to update phone number
    Then I validate if "Staff member has been updated" message is correct
    And I go to Home page
    When I quick search partial "Phone"
    Then I validate if result for "PhoneFormatted" is correct
    And I go to Home page
    When I quick search "PhoneFormatted"
    Then I validate if result for "PhoneFormatted" is correct
