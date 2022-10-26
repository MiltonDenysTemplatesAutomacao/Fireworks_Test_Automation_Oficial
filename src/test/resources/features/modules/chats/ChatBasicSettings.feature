#Author: Milton Silva
#Regression testcase TL-1174: Chat Basic Settings

@ChatBasicSettings
Feature: Chat Basic Settings

  @ChatBasicSettingsScenario @Done @Chats
  Scenario: verify chat basic settings
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to chat setting page
    And I verify if chat checkbox is active or inactive "0"
    #email contact is empty and is required
    When I update email contact in setting chat page ""
    And I click on "Save Changes"
    And I verify validation message "The Email Contact field is required."
    And I click on close button on modal
    #basic settings are saved
    And I set chat checkbox as active
    When I update email contact in setting chat page "test3000@fire-engine-red.com"
    And I click on "Save Changes"
    And I close alert if return this message "Chat settings have been successfully saved!"
    And I verify if chat checkbox is active or inactive "1"
    And I navigate to chat setting page
    And I verify if chat checkbox is active or inactive "1"
    When I verify email contact in setting chat page "test3000@fire-engine-red.com"
