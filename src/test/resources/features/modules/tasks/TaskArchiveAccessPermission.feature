#Author: Milton Silva
#Regression testcase TL-1131: Tasks Permissions: Archive Access

@TaskPermissionArchiveAccess
Feature: Tasks Permissions: Archive Access

  @TaskPermissionArchiveAndActivateButtons @Persistent
  Scenario: Not to see the archive or activate buttons
    Given I login as firestarter
    And I navigate to tasks
    And I click on create task button
    When I fill task fields
      |Name                     |Type	|
      |Invite to Orientation	|Call	|
    And I click on Save Changes button
    Then I validate if archive and activate buttons are not displayed

  @TaskPermissionArchiveAndActivateButtonsAfterArchive @Persistent
  Scenario: Not to see the archive or activate buttons
    Given I login as firestarter
    And I navigate to tasks
    And I click on create task button
    When I fill task fields
      |Name                       |Type	|
      |Congratulate Honors Grads  |Call	|
    And I click on Save Changes button
    And I navigate to tasks
    And I click on filter archived status and set "Yes"
    And I open task "Name"
    Then I validate if archive and activate buttons are not displayed
