#Author: Milton Silva
#Regression testcase TL-387: Staff Record: Delete and Re-add

@DeleteReAdd
Feature: Staff Record: Required fields

  @DeleteReAddScenarios
  Scenario: verify staff record can be deleted and re-added
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a staff
      |FirstName  |LastName	  |Fullname		    |EmailAddress	            |PermissionGroup|
      |Kenzo	  |Mizoguchi  |Kenzo Mizoguchi	|KMizoguchi@directors.net	|Administrator	|
    And I validate if "Staff member has been created." message is correct
    And I validate if "Fullname"summary opened properly
