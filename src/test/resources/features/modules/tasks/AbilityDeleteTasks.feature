#Author: Milton Silva
#Regression testcase TL-1127: Delete a task

@AbilityDeleteTasks
Feature: Ability to delete tasks

  @AbilityDeleteTasksStaff
  Scenario: Verify if it possible to delete a task, cancel on delete task modal and check if the task was deleted
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to tasks
    And I click on create task button
    When I fill task fields
      |Name                     |Type	|
      |Task to be Deleted 2220	|Call	|
    And I click on Save Changes button
    Then I click on delete task button
    And I click on cancel button on delete task modal
    Then I click on delete task button
    And I click on yes button on delete task modal
    And I validate if "Task has been deleted" message is correct
    And I validate if task was deleted correctly
