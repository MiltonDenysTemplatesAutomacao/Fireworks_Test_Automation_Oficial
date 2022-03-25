#Author: Milton Silva
#Regression testcase TL-1128: Tasks Permissions: Administrator Access

@TaskPermissionAdministratorAccess
Feature: Tasks Permissions: Administrator Access

  @TaskPermissionAdministratorAccessCreateTasksScenario @Persistent
  Scenario: Verify the admin access permission is honored
    Given I login as firestarter
    And I navigate to tasks
    And I click on create task button
    When I fill task fields
      |Name                   |Type	        |AssignTo  |DueDate   |Status       |
      |Invite to Orientation  |Applications	|Hans Hayes|01/20/2020|In Progress  |
      And I click on Save Changes button
    Then I validate if "Task has been created" message is correct
    And I navigate to tasks
    And I click on create task button
    When I fill task fields
      |Name                           |Type	|AssignTo  |DueDate   |Status      |
      |Convert Deposited to Enrolled  |Call	|Hans Hayes|01/22/2020|Not Started |
    And I click on Save Changes button
    Then I validate if "Task has been created" message is correct
    And I navigate to tasks
    And I click on create task button
    When I fill task fields
      |Name                    |Type	    |AssignTo  |DueDate   |Status      |
      |Friday Fridge Cleanout  |Management	|          |01/10/2020|Not Started |
    And I click on Save Changes button
    Then I validate if "Task has been created" message is correct

#keep working on next scenarios to validate using others users

#
#  @TaskPermissionAdministratorAccessScenario @Persistent
#  Scenario: Verify the admin access permission is honored
#    Given I login as firestarter