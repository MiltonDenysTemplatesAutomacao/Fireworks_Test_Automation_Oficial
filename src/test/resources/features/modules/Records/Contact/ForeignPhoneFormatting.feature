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
    And I create address on contact for staff "Mal. Nikitskaya St. 10", "", "", "", "Moscow", "", "Podmoskovye", "Russian Federation", "121069", "Mailing", "", "1", "1", group "0"
    And I click on save changes in contact for staff
    And I close alert if return this message "Staff member has been updated."
    And I update phone number in contact for staff "4956905132", "Home", ""
    And I click on save changes in contact for staff
    And I close alert if return this message "Staff member has been updated."
    Then I verify phone number on contact for staff "+7 495 690-51-3", "Home", ""

  @PhoneNumberFormattingScenarioStaff2 @Done
  Scenario: Record - Staff - verify a staff phone number is formatted as expected
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a staff
      |FirstName  |LastName	|Fullname 		|EmailAddress	        |EmailType  |PermissionGroup|
      |Lev	      |Tolstoy  |Lev Tolstoy	|LTolstoy@deadsouls.com	|Personal	|Administrator	|
    Then I validate if "Staff member has been created. They have been sent a welcome email with a link prompting them to login and create a password. The link in this email will expire in 12 hours." message is correct
    And I validate if "Lev"summary opened properly
    And I navigate to contact
    And I update phone number in contact for staff "9047219-202", "Home", ""
    And I click on save changes in contact for staff
    And I validate if "Staff member has been created. They have been sent a welcome email with a link prompting them to login and create a password. The link in this email will expire in 12 hours." message is correct
    Then I verify phone number on contact for staff "(904) 721-9202", "Home", ""

