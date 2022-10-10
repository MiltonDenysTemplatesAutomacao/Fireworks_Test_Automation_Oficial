#Author: Milton Silva
#Regression testcase TL-773: Creating a monthly scheduled job

@CreatingAMonthlyScheduledJob
Feature: Creating a monthly scheduled job

  @CreatingAMonthlyScheduledJobScenario @Done @Scheduler
  Scenario: Scheduler - Letter - scheduled monthly
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName |LastName |EmailAddress        |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate |EntryTerm|LetterName                    |SmartSearch                  |LetterFormat                   |LetterContent                            |Category     |Action                       |Staff       |ActionDateTime    |
      |Bernard   |Girard   |BGirard@actors.comm |Personal   |Student Search   |Student|Freshman   |Accepted             |Accepted         |01/15/2016        |Fall 2017|Monthly Scheduled Letter 7056 |SearchForScheduledLetter7056 |Letter (8.5 x 11 no letterhead)|Content for Monthly Scheduled Letter 7056|Campus Events|Admitted Student Day: Attend |Fire Starter|04/01/2016 5:21 PM|
    And I validate if "Person has been created." message is correct
    And I navigate to smart search page
    And I click on create smart search button
    And I select "Last Name" search field group "0" in smart search composer
    And I select "equals" operator field group "0" in smart search composer
    And I fill "Girard" text condition value group "0"
    And I fill smart search name "SearchForScheduledLetter7056"
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
    #to update the job details
    When I update job details "Scheduled Monthly Letter 7056", "", "01/20/2019 7:10 AM", "Alaska", ""
    And I update Frequency1Monthly "Every Month", "Day 3", "02:30 PM", "03/29/2021 2:31 PM"
    And I update Exclude1Date "04/10/2020"
    And I update Notify Recipients "notify@fire-engine-red.com"
    And I close alert if return this message "Scheduled Job has been created."
    #to verify the scheduled letter
    And I navigate to scheduler
    And I open a schedule job "Scheduled Monthly Letter 7056"
    When I verify job details "Scheduled Monthly Letter 7056", "", "01/20/2019 7:10 AM", "Alaska"
    And I verify Frequency1Monthly "Every Month", "Day 3", "02:30 PM", "03/29/2021 2:31 PM"
    And I verify Exclude1Date "04/10/2020"
    And I verify Checkbox Defaults

