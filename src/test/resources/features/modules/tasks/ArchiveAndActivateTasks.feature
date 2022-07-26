#Author: Milton Silva
#Regression testcase TL-1130: Archive and Activate tasks

@ArchiveAndActivateTasks
Feature: Ability to archive and activate tasks

  @ArchiveAndActivateTasksStaff @Done @Tasks
  Scenario: Tasks - Verify a task can be archived, activate, read-only after archived, not shown in task manager after archived
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to tasks
    And I click on create task button
    When I fill task fields
      |Name                 |Type   	|
      |ArchiveActivate2230	|Management	|
    And I click on Save Changes button
    And I click on archive task button
    And I close alert if return this message "Task has been archived"
    And I validate if the task is read-only
    And I navigate to tasks
    And I search a task "Name"
    And I validate if task is archived sucessfully
    And I click on filter archived status and set "Yes"
    And I open task "Name"
    Then I click on activate task button
    And I validate if archive button is displayed and fields are not disabled
    And I navigate to tasks
    And I search a task "Name"
    Then I validate if manager table shows the task created
