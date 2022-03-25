#Author: Milton Silva
#Regression testcase TL-1129: Tasks Permissions: Composer Delete

@TaskPermissionDeleteButtonAccess
Feature: Tasks Permissions: Composer Delete

  @TaskPermissionDeleteButtonAccessScenario @Persistent
  Scenario: Not to see delete button
    Given I login as firestarter
    And I navigate to tasks
    And I click on create task button
    When I fill task fields
      |Name                           |Type	|
      |Convert Deposited to Enrolled  |Call	|
    And I click on Save Changes button
    And I log out
    And I login as firestarter
    And I navigate to tasks
    And I open task "Name"
    Then I validate if delete button is not displayed