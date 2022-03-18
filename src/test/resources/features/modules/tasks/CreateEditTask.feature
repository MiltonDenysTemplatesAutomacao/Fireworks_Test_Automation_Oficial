#Author: Milton Silva

@CreateEditTask
Feature: Search by phone number

  @CreateTaskStaff
  Scenario: to create a task for staff member
    Given I login as firestarter
    And I create a staff
      |Firstname|Lastname |Fullname		|EmailAddress		|PermissionGroup |Name    |Description    |Type|SmartSearch     |AssignTo   |DueDate    |DueTime  |Priority |Status     |Comments     |
      |Hugo		|Reyes	  |Hugo Reyes	|hurley@dharma.net	|Administrator	 |Task2200|TaskDescription|Call|2016 Entry Term |Hugo Reyes |11/11/2020 |02:00 PM |Medium   |In Progress|Task Comments|
    And I go to Home page
    And I navigate to tasks
    And I click on create task button
    When I create a task
    Then I validate if "Task has been created" message is correct
    When I verify if task was created correctly
    And I go to Home page
    And I navigate to tasks
    And I search a task "Name"
    Then I validate if manager table shows the task created

  @UpdateTaskStaff
  Scenario: to clear changes and update a task for staff member
    Given I login as firestarter
    And I create a staff
      |Firstname|Lastname |Fullname		|EmailAddress		|PermissionGroup  |PreviousName |Name           |Description      |Type      |AssignTo     |DueDate    |DueTime  |Priority |Status      |Comments     |
      |Igor		|Schanez  |Igor Schanez	|Igor@Schanez.net	|Administrator	  |Task2200     |RenamedTask2200|EditedDescription|Management|Fire Starter |12/11/2019 |04:00 PM |High     |Complete    |Task edited  |
      |Hugo		|Reyes	  |Hugo Reyes	|hurley@dharma.net	|Administrator	  |Task2200     |Task2200       |TaskDescription  |Call      |Hugo Reyes   |11/11/2020 |02:00 PM |Medium   |In Progress |Task Comments|
    And I go to Home page
    And I navigate to tasks
    And I open task "PreviousName"
    When I update task fields
    And I clear changes
    And I validate if clear changes worked
    And I create a task
    Then I validate if "Task has been updated" message is correct



