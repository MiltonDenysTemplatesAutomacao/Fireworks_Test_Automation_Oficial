#Author: Milton Silva
#Regression testcase TL-1130: Archive and Activate tasks

@TaskRestrictedCheckBox
Feature: Task Restricted CheckBox

  @TaskRestrictedCheckBoxScenario @Persistent
  Scenario: verify this permissions group can not access tasks
    Given I login as firestarter
    When I navigate to tools
    Then I validate if task is not displayed in tools menu
