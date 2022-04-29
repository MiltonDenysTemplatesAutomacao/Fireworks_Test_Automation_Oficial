#Author: Milton Silva
#Regression testcase TL-38: Staff Record: Account Start Date

@AccountStartDate
Feature: Staff Record: Account Start Date

  @AccountStartDateScenarios
  Scenario: verify staff member with future start date is not active
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a staff
      |FirstName  |LastName	  |Fullname		    |EmailAddress	            |AccountStartDate	|PermissionGroup|
      |Toru		  |Takemitsu  |Toru Takemitsu	|TTakemitsu@directors.net	|07/10/2050			|Administrator	|
    And I validate if "Staff member has been created." message is correct
    And I validate if "Fullname"summary opened properly
    Then I verify Header Record Status "Record Status: Inactive"
    Then I verify Header Permission "Permissions: Administrator"
