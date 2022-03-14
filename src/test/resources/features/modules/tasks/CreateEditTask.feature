#Author: Milton Silva

@CreateEditTask
Feature: Search by phone number

  @CreateEditTaskStaff
  Scenario: to create and edit task for staff member
    Given I login as firestarter
    And I create a staff
      |Firstname|Lastname |Fullname		|EmailAddress		|PermissionGroup |Name    |Description    |Type|SmartSearch     |AssignTo   |DueDate    |DueTime  |Priority |Status     |Comments     |
      |Hugo		|Reyes	  |Hugo Reyes	|hurley@dharma.net	|Administrator	 |Task2200|TaskDescription|Call|2016 Entry Term |Hugo Reyes |11/11/2020 |02:00 PM |Medium   |In Progress|Task Comments|
    And I go to Home page
    And I navigate to tasks
    And I click on create task button
    When I update task