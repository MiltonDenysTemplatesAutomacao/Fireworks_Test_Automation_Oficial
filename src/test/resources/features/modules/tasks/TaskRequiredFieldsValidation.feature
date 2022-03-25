#Author: Milton Silva
#Regression testcase TL-1121: Tasks Composer: Validation

  @TaskRequiredFieldsValidation
  Feature: Task Required Fields Validation

  @TaskRequiredFieldsValidationScenario @Persistent
  Scenario: Verify required field validation on task composer
    Given I login as firestarter
    And I navigate to tasks
    And I click on create task button
    When I click on Save Changes button
    Then I validate if "The Name field is required" validation alert message is correct
    And I validate if "The Type field is required" validation alert message is correct
    And I validate if duo time is disabled

  @StaffDuoTimeDisabled
  Scenario: Verify if due time is disabled when due date is not provided
    Given I login as firestarter
    And I navigate to tasks
    And I click on create task button
    When I fill task fields
      |Name     |Type	        |DueDate    |DueTime  |
      |Task2210	|Applications	|11/12/2020 |02:00 PM |
    And I erase Due Date field
    And I validate if duo time is disabled
