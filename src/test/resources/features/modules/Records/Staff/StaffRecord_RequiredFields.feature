#Author: Milton Silva
#Regression testcase TL-83: Staff Record Required Fields
#Regression testcase TL-179:Staff Record: Header Displays Account Status & Permission Group

@RequiredFields
Feature: Staff Record: Required fields

  @ValidateRequiredFieldsReturnQuickAdd @Done
  Scenario: Record - Staff - correct validation messages to be returned from the quick add staff form
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a staff
      |FirstName  |LastName	  |Fullname		        |EmailAddress|
      |           |           |                 	|            |
    Then I validate if "The First Name field is required." message alert for staff required is correct
    And I validate if "The Last Name field is required." message alert for staff required is correct
    And I validate if "The Email Address field is required." message alert for staff required is correct

  @ValidateRequiredFieldsReturnPermissionGroupNotSet @Done
  Scenario: Record - Staff - a validation message to be returned when the permissions group is not set
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a staff
      |FirstName  |LastName	  |Fullname		        |EmailAddress                 |
      |Alexander  |Hamilton   |Alexander Hamilton	|AHamilton@foundingpeople.net |
    When I validate if "This user hasn't been assigned to a permissions group. You can still create the user, but they won't be able to access the system." message alert for staff required is correct
    And I quick add a staff
      |FirstName  |LastName	  |Fullname		        |EmailAddress                 |PermissionGroup|
      |Alexander  |Hamilton   |Alexander Hamilton	|AHamilton@foundingpeople.net |Administrator  |
    And I clickQuickAddStaffSaveAndGo
    And I validate if "Staff member has been created. They have been sent a welcome email with a link prompting them to login and create a password. The link in this email will expire in 12 hours." message is correct
    And I validate if "Alexander Hamilton"summary opened properly
    Then I verify Header Record Status "Record Status: Active"
    And I verify Header Permission "Permissions: Administrator"
    And I validate if basic panel element is visible