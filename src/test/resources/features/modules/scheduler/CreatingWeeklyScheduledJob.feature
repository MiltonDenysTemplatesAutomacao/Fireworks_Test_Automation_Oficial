#Author: Milton Silva
#Regression testcase TL-772: Creating a weekly scheduled job
#Regression testcase TL-777: Deleting a scheduled job

@CreatingAWeeklyScheduledJob
Feature: Scheduler required fields

  @VerifyAnEmailCanBeScheduledWeekly @Done @Scheduler
  Scenario: Scheduler - verify an email can be scheduled weekly
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName |LastName |EmailAddress       |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate |EntryTerm|
      |Ann       |Savage   |ASavage@actors.com |Personal   |Inquiry          |Student|Freshman   |Accepted             |Accepted         |01/15/2016        |Fall 2017|
    #And I validate if "Person has been created." message is correct
  #to create an email
    And I navigate to email manager page
    And I click on create a new email button and select type "Marketing"
    When I update Email Start Tab "", "Scheduler Test Weekly", "", "", "ASavage@actors.com"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
