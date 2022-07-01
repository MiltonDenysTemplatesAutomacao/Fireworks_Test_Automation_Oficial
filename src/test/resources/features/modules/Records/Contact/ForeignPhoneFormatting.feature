#Author: Milton Silva
#Regression testcase TL-168 (2 of 3): Phone Number Formatting

@PhoneNumberFormatting
Feature: Phone Number Formatting

@PhoneNumberFormattingScenarioOrganization @Done
Scenario: Record - Organization - Setting secondary email address status to valid makes email active
Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
And I create an organization
|Name				     |Role		 |Address1		       |City	|PostalCode |Country	         |Phone      |PhoneType|
|DeadSouls High School   |High School|Mal. Nikitskaya St. 9|Moscow  |44125      |Russian Federation  |4956905131 |Business |
Then I validate if "Organization has been created." message is correct
And I validate if "DeadSouls High School"summary opened properly
And I navigate to contact
And I verify phone number on contact for organization "+7 495 690-51-31", "Business", "", "", "", "1", "1", group "0"

  @PhoneNumberFormattingScenarioStaff @Done
  Scenario: Record - Staff - verify a foreign country phone number displays properly in Staff Contact
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a staff
      |FirstName  |LastName	  |Fullname 		|EmailAddress	            |EmailType  |PermissionGroup|
      |Pavel	  |Chichikov  |Pavel Chichikov	|PChichikov@deadsouls.com	|Personal	|Administrator	|
    Then I validate if "Staff member has been created. They have been sent a welcome email with a link prompting them to login and create a password. The link in this email will expire in 12 hours." message is correct
    And I validate if "Pavel"summary opened properly
    And I navigate to contact
    And I create address on contact for staff "", "", "", "", "", "", "", "", "", "", "", "1", "1", group "0"
