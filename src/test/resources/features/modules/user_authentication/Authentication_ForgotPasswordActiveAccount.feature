#Author: Milton Silva
#Regression testcase TL-6: Forgot Password active account

@ForgotPasswordActiveAccount
Feature: Ability to schedule text messages from Communications

  @ForgotPasswordActiveAccountScenario @Done @UserAuthentication
  Scenario: Report - report required fields
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a staff
      |FirstName  |LastName	|Fullname		|EmailAddress	        |EmailType  |AccountStartDate	|AccountEndDate	|PermissionGroup|
      |Red		  | Forman	|Red  Forman	|rforman@wisconsin.com	|Personal	|06/02/2015			|08/20/2030		|Administrator	|
    And I validate if "Staff member has been created. They have been sent a welcome email with a link prompting them to login and create a password. The link in this email will expire in 12 hours." message is correct
    And I validate if "Red  Forman"summary opened properly
    Then I verify Header Record Status "Record Status: Active"
    And I log out
    #get activation email from mailtrap and then delete it

