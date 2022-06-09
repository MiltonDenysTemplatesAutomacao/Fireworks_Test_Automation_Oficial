#Author: Milton Silva
#Regression testcase TL-387: Staff Record: Delete and Re-add

@DeleteReAdd
Feature: Staff Record: Required fields

  @DeleteStaffAndValidate
  Scenario: Record - Staff - verify staff record can be deleted and re-added
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a staff
      |FirstName  |LastName	  |Fullname		    |EmailAddress	            |PermissionGroup|
      |Kenzo	  |Mizoguchi  |Kenzo Mizoguchi	|KMizoguchi@directors.net	|Administrator	|
    And I validate if "Staff member has been created." message is correct
    And I validate if "Kenzo Mizoguchi"summary opened properly
    And I delete a staff member
    Then I validate if "Staff member has been deleted." message is correct
    #the staff record is not found in the staff manager table
    When I search "LastName" on staff page manager
    Then I validate if "No search results to display." message on staff datatable is displayed
    #the staff record is not found via quick search
    And I go to Home page
    When I quick search "LastName"
    And I validate if "No search results to display." message on quick search is displayed

  @StaffRecordsCanBeAddedAgain
  Scenario: the staff record can be added again
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a staff
      |FirstName  |LastName	  |Fullname		    |EmailAddress	            |PermissionGroup|
      |Kenzo	  |Mizoguchi  |Kenzo Mizoguchi	|KMizoguchi@directors.net	|Administrator	|
    And I validate if "Staff member has been created." message is correct

  @StaffRecordsCannotBeDuplicated
  Scenario: the staff record cannot be duplicated
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a staff
      |FirstName  |LastName	  |Fullname		    |EmailAddress	            |PermissionGroup|
      |Kenzo	  |Mizoguchi  |Kenzo Mizoguchi	|KMizoguchi@directors.net	|Administrator	|
    Then I validate if "The Email Address has already been taken." message alert for staff

