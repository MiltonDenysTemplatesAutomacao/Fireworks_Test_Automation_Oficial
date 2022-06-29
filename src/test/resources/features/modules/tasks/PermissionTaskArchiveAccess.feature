#Author: Milton Silva
#Regression testcase TL-1131: Tasks Permissions: Archive Access

@TaskPermissionArchiveAccess
Feature: Tasks Permissions: Archive Access

  @TaskPermissionArchiveAndActivateButtons @Persistent @Fix
  Scenario: Tasks - Not to see archive or activate buttons
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to tasks
    And I click on create task button
    When I fill task fields
      |Name                     |Type	|
      |Invite to Orientation	|Call	|
    And I click on Save Changes button
    And I log out
    Given I login as "tasksNoAdminNoArchiveUsername", "tasksNoAdminNoArchivePassword", "tasksNoAdminNoArchiveFullName"
    And I navigate to tasks
    And I click on filter archived status and set "Yes"
    And I open task "Name"
    Then I validate if archive and activate buttons are not displayed

  @TaskPermissionArchiveAndActivateButtonsAfterArchive @Persistent @Fix
  Scenario: Tasks - Not to see archive or activate buttons after archive a task
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to tasks
    And I click on create task button
    When I fill task fields
      |Name                       |Type	|
      |Congratulate Honors Grads  |Call	|
    And I click on Save Changes button
    And I log out
    Given I login as "tasksNoAdminNoArchiveUsername", "tasksNoAdminNoArchivePassword", "tasksNoAdminNoArchiveFullName"
    And I navigate to tasks
    And I click on filter archived status and set "Yes"
    And I open task "Name"
    Then I validate if archive and activate buttons are not displayed
