#Author: Milton Silva
#Regression testcase TL-38: Staff Record: Account Start Date
#Regression testcase TL-179:Staff Record: Header Displays Account Status & Permission Group

@AccountStartDate
Feature: Staff Record: Account Start Date

  @AccountStartDateScenarios @Done
  Scenario: Record - Staff - verify staff member with future start date is not active
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a staff
      |FirstName  |LastName	  |Fullname		    |EmailAddress	            |AccountStartDate	|PermissionGroup|
      |Toru		  |Takemitsu  |Toru Takemitsu	|TTakemitsu@directors.net	|07/10/2050			|Administrator	|
    And I validate if "Staff member has been created." message is correct
    And I validate if "Toru Takemitsu"summary opened properly
    Then I verify Header Record Status "Record Status: Inactive"
    Then I verify Header Permission "Permissions: Administrator"
