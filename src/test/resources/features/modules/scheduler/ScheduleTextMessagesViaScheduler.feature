#Author: Milton Silva
#Regression Test Case TL-1086: Verify that users can schedule text messages via scheduler

@VerifyThatUsersCanScheduleTextMessagesViaScheduler
Feature: Verify that users can schedule text messages via scheduler

  @VerifyThatUsersCanScheduleTextMessagesViaSchedulerScenario @Done @Scheduler
  Scenario: Scheduler - verify a scheduled text message job can be created from Scheduler
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName |LastName |Phone         |PhoneType|Role1  |
      |Penelope  |Cruz     |(904) 766-7665|Mobile   |Person |
    And I validate if "Person has been created." message is correct
    #to update the phone number to active and confirmed
    And I validate if "Penelope Cruz"summary opened properly
    And I navigate to people on records
    And I open a people record by "Penelope Cruz"
    And I navigate to contact
    When I update phone number in contact for person "", "", "Active", "Application", "Confirmed", "", "", "" field group "0"
    And I click on save changes in contact for person
    #to create a text message
    And I navigate to text message page
    And I click on create text button
    And I update start tab "TextMessage7052", "", "", "Penelope"
    And I click on "Save & Continue"
    And I update body tab "Text Message for Penelope"
    And I click on "Save & Continue"
    #to verify the text message can be selected in Scheduler
    And I navigate to scheduler
    When I create a new schedule "Text"
    When I update job details "Scheduled Text7052", "TextMessage7052", "01/20/2020 7:10 AM", "Alaska", ""
    And I update Frequency1Weekly "Every Week", "Friday", "02:30 PM", "03/29/2021 2:31 PM"
    And I click on "Save Changes"
    And I close alert if return this message "Scheduled Job has been created."
