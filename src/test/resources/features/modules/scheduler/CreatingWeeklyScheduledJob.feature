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
    And I validate if "Person has been created." message is correct
  #to create an email
    And I navigate to email manager page
    And I click on create a new email button and select type "Marketing"
    When I update Email Start Tab "", "Scheduler Test Weekly", "", "", "ASavage@actors.com"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "Edgar Ulmer", "EUlmer@fire-engine-red.com", "", "Subject Scheduler Test Weekly", "", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I update Email Content Tab "HTML body content for Scheduler Test Weekly", ""
    #it is necessary to click twice at this point
    And I click on save and continue on Marketing Email Composer
    And I click on save and continue on Marketing Email Composer
    And I validate if "Email has been updated." message is correct
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #to schedule the email
    And I schedule an email
    #care about last validation here
    And I verify RecipientsPreview "Ann", "Savage", "ASavage@actors.com", "", ""
    And I confirm EmailSend
    #to enter schedule data for the email
    When I update job details "Scheduler Test Weekly Email", "", "01/20/2019 7:10 AM", "Alaska", ""
    And I update Frequency1Weekly "Every Week", "Monday", "02:30 PM", "03/29/2021 2:31 PM"
    And I update Exclude1Date "03/05/2021"
    And I update Notify Recipients "notify@fire-engine-red.com"
    #And I click on job save button
    And I close alert if return this message "Scheduled Job has been created."
    #to verify the scheduled email job
    And I navigate to scheduler
    And I open a schedule job "Scheduler Test Weekly Email"
    When I verify job details "Scheduler Test Weekly Email", "", "01/20/2019 7:10 AM", "Alaska"
    And I verify Frequency1Weekly "Every Week", "Monday", "02:30 PM", "03/29/2021 2:31 PM"
    And I verify Exclude1Date "03/05/2021"
    And I verify Checkbox Defaults
    #to verify scheduled jobs can be deleted
