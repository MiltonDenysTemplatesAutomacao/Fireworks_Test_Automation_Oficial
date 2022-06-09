#Author: Milton Silva
#Regression testcase TL-1142: Tasks Permissions: Restricted checkbox

@TaskRestrictedCheckBox
Feature: Task Restricted CheckBox

  @TaskRestrictedCheckBoxScenario @Persistent
  Scenario: Tasks - verify this permissions group can not access tasks
    Given I login as "tasksNoAccessUsername", "tasksNoAccessPassword", "tasksNoAccessFullName"
    When I navigate to tools
    Then I validate if task is not displayed in tools menu
