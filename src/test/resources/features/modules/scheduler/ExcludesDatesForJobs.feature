#Author: Milton Silva
#Regression testcase TL-789: Exclude dates for jobs

@ExcludeDatesForJobs
Feature: Exclude dates for jobs

  @ExcludeDatesForJobsScenario @Done @Scheduler
  Scenario: Scheduler - Letter - scheduled daily with exclusions
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName |LastName |EmailAddress               |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate |EntryTerm|LetterName                       |SmartSearch                  |LetterFormat                   |LetterContent                                             |
      |Wheaton   |Chambers |WheatonChambers@actors.com |Personal   |Student Search   |Student|Freshman   |Accepted             |Accepted         |01/15/2016        |Fall 2017|LetterScheduledWithExclusions7070|SearchForScheduledLetter7070 |Letter (8.5 x 11 no letterhead)|Letter body content for LetterScheduledWithExclusions7070 |
    And I validate if "Person has been created." message is correct
    And I navigate to smart search page
    And I click on create smart search button
    And I select "Last Name" search field group "0" in smart search composer
    And I select "equals" operator field group "0" in smart search composer
    And I fill "Wheaton" text condition value group "0"
    And I fill smart search name "SearchForScheduledLetter7070"
    And I click on save this search button
    And I close alert if return this message "Smart Search has been created."
    #to create a scheduled letter
    And I navigate to letters page
    And I click on create letter button
    And I update letter details person 0
    And I update letter recipients person 0
    And I update letter content person 0
    And I update letter person action index 0
    When I click on schedule letter button
    When I update job details "Scheduled Exclude Dates 7070", "", "10/11/22 12:01 AM", "Alaska", ""
    And I update Frequency1Daily "Every Day", "12:02 AM", "10/11/22 11:59 PM AM"
    And I click on job save button
    And I close alert if return this message "Scheduled Job has been created."
    #to verify the number of scheduled jobs in the calendar before exclusions are added
    #working on validate calendar method
    #When I validate if numbers of elements "1" on
    #to update the job to add an excluded date
    #And I update Exclude1Date "10/07/2022"

