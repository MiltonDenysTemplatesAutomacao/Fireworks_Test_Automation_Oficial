#Author: Milton Silva
#Regression testcase TL-246 (2 of 2): Search by Email

@SearchByEmail
Feature: Search by Email
  @SearchPersonByEmail
  Scenario: Quick Search - to Quick Search a person by Email, full or partial
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName|LastName	|EmailAddress	      |EmailType|EmailOptInMethod |Role1	|
      |John 	|Carter		|johncarter@yahoo.com |Personal	|Inquiry		  |Person	|
    And I go to Home page
    When I quick search "EmailAddress"
    Then I validate if result for "EmailAddress" is correct
    When I quick search partial "EmailAddress"
    Then I validate if result for "EmailAddress" is correct

  @SearchOrganizationByEmail
  Scenario: Quick Search - to Quick Search an organization by Email, full or partial
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name					  |Role		  |Phone		|PhoneType  |Address1			|Address2	|City  |State	|PostalCode|Country			|EmailAddress	         |EmailType   |EmailOptInMethod |OptInStatus|
      |Selwyn Culinary School |High School|888-411-4682	|Business	|210 Sixth Avenue	|33rd Floor	|Denver|Colorado|80220	   |United States	|SelwynCulinary@yahoo.com|School      |College Fair     |Subscribed |
    And I go to Home page
    When I quick search "Name"
    And I open a record
    And I navigate to contact
    When I update "EmailAddress", "EmailType", "EmailOptInMethod", "", "", "" and "" to update email address
    And I go to Home page
    When I quick search "EmailAddress"
    Then I validate if result for "Name" is correct
    When I quick search partial "EmailAddress"
    Then I validate if result for "EmailAddress" is correct

  @SearchStaffByEmail
  Scenario: Quick Search - to Quick Search a staff member by Email, full or partial
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a staff
      |FirstName  |LastName	|Fullname		|EmailAddress	|EmailType  |AccountStartDate	|AccountEndDate	|PermissionGroup|
      |Levi		  | Ralph	|Levi  Ralph	|levi@ralph.com	|Personal	|07/10/2017			|07/10/2025		|Administrator	|
    And I go to Home page
    When I quick search "EmailAddress"
    Then I validate if result for "EmailAddress" is correct
    When I quick search partial "EmailAddress"
    Then I validate if result for "EmailAddress" is correct