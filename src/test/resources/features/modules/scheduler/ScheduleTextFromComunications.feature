#Author: Milton Silva
#Regression testcase TL-1089: Ability to schedule text messages from Communications

@AbilityToScheduleTextMessagesFromCommunications
Feature: Ability to schedule text messages from Communications

  @AbilityToScheduleTextMessagesFromCommunicationsScenarios @Done @Scheduler
  Scenario: Scheduler - verify a draft text message can be scheduled from the finish tab
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName |LastName |Phone          |PhoneType|Role1  |
      |Professor |Zoidberg |(904) 240-55995|Mobile   |Person |
    And I validate if "Person has been created." message is correct
    #to update the phone number to active and confirmed
    And I validate if "Professor Zoidberg"summary opened properly
    And I navigate to people on records
    And I open a people record by "Professor Zoidberg"
    And I navigate to contact
    When I update phone number in contact for person "", "", "Active", "Application", "Confirmed", "", "", "" field group "0"
    And I click on save changes in contact for person
    #to create a text message
    And I navigate to text message page
    And I click on create text button
    And I update start tab "ScheduleText7064", "Text Description7064", "", "(904) 240-55995"
    And I click on "Save & Continue"
    And I update body tab "Text Message for Professor"
    And I click on "Save & Continue"
    And I close alert if return this message "Text has been updated."
    And I click on schedule button
