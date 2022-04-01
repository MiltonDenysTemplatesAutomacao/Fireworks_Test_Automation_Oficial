#Author: Milton Silva
#Regression testcase TL-1128: Tasks Permissions: Administrator Access

@TaskPermissionAdministratorAccess
Feature: Tasks Permissions: Administrator Access

  @TaskPermissionAdministratorAccessCreateTasksScenario @Persistent
  Scenario: Creating tasks for test
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
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

  @VerifyIfThisUserCanSeeTasksToAnyUser @Persistent
  Scenario: Verify the this user can see tasks assigned to any user
    Given I login as "tasksAdminAccessNoDeleteUsername", "tasksAdminAccessNoDeletePassword", "tasksAdminAccessNoDeleteFullName"
    And I navigate to tasks
    And I search task "Invite to Orientation"
    When I validate if task "Invite to Orientation" is displayed
    And I search task "Convert Deposited to Enrolled"
    When I validate if task "Convert Deposited to Enrolled" is displayed
    And I search task "Friday Fridge Cleanout"
    When I validate if task "Friday Fridge Cleanout" is displayed

  @VerifyIfThisUserCanSeeOnlyAssingedToThem @Persistent
  Scenario: Verify the this user can see only see tasks assigned to them
    Given I login as "tasksNoAdminNoArchiveUsername", "tasksNoAdminNoArchivePassword", "tasksNoAdminNoArchiveFullName"
    And I navigate to tasks
    And I fill search task field "Friday Fridge Cleanout"
    When I validate if task is not displayed

  @VerifyIfAssignedToColumIsHiddenForNonAdminUsers @Persistent
  Scenario: Verify the assigned to column is hidden for non-admin users'
    Given I login as "tasksNoAdminNoArchiveUsername", "tasksNoAdminNoArchivePassword", "tasksNoAdminNoArchiveFullName"
    And I navigate to tasks
    When I fill search task field "Friday Fridge Cleanout"
    Then I validate if Assigned To column is not displayed
