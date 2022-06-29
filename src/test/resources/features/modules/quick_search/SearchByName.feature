#Author: Milton Silva

@SearchByName
Feature: Search by name

  @SearchPersonFirstNameRecord @Done
  Scenario: Quick Search - to Quick Search for person Firstname, Lastname, First and Last name and partial name
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName	|LastName	|FullName	    |EmailAddress			|EmailType		|EmailOptInMethod	|Role1	|Phone			|PhoneType|Address1					|City		|State		|Country			|PostalCode	|
      |Voorhis		|George		|Voorhis George |vgeorges@McDowells.com	|Personal		|Inquiry			|Person	|888-411-7733	|Home	  |6207 E Colfax Ave        |Denver	    |Colorado	|United States      |80220		|
    And I go to Home page
    When I quick search "FirstName"
    Then I validate if result for "FirstName" is correct
    And I go to Home page
    When I quick search "LastName"
    Then I validate if result for "LastName" is correct
    And I go to Home page
    When I quick search "FullName"
    Then I validate if result for "FirstName" is correct
    Then I validate if result for "LastName" is correct
    And I go to Home page
    When I quick search partial "FirstName"
    Then I validate if result for "FirstName" is correct


  @SearchOrganizationNameRecord @Done
  Scenario: Quick Search - to Quick Search for Organization name and partial name
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name						|Role		|Phone			|PhoneType  |Address1				|Address2		|City	 |State		|PostalCode|Country				|
      |McDowells Culinary School|High School|888-411-7731	|Business	|210 Sixth Avenue	|33rd Floor	|Denver|Colorado|80220		 |United States	|
    And I go to Home page
    When I quick search "Name"
    Then I validate if result for "Name" is correct
    And I go to Home page
    When I quick search partial "Name"
    Then I validate if result for "Name" is correct


  @SearchStaffFirstNameRecord @Done
  Scenario: Quick Search - to Quick Search for staff Firstname, LastName, First and Last name and partial name
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a staff
      |FirstName	|LastName	|FullName			|EmailAddress				|EmailType|AccountStartDate	|AccountEndDate	|PermissionGroup|
      |Leandro		|Hamburglar	|Leandro Hamburglar	|hamburglar@McDowells.com	|Personal	|07/10/2015				|07/10/2025			|Administrator	|
    And I go to Home page
    When I quick search "FirstName"
    Then I validate if result for "FirstName" is correct
    And I go to Home page
    When I quick search "LastName"
    Then I validate if result for "LastName" is correct
    And I go to Home page
    When I quick search "FullName"
    Then I validate if result for "FirstName" is correct
    Then I validate if result for "LastName" is correct
    And I go to Home page
    When I quick search partial "FirstName"
    Then I validate if result for "FirstName" is correct

