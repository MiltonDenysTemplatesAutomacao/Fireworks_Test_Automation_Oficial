#Author: Milton Silva
#Regression testcase TL-1182: Chats Permissions: View but not Create
#Regression testcase TL-1184: Chats Permissions: Settings - View but not Create

@ChatSettingsViewButNotCreate
Feature: Chat Settings - View but not Create

  @ChatSettingsViewButNotCreateScenario @Done @Chats
  Scenario: verify this permissions group only has read only access to chats and settings
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I open chat "Test3175"
    #the chat is read-only
    And I validate if element on chat page "printChatButton" is "visible"
    And I validate if element on chat page "markChatUnreadButton" is "visible"
    And I validate if element on chat page "deleteChatButton" is "not visible"
    #the chat settings are read-only
    And I navigate to chat setting page
    And I validate if element on chat page "activeImageDropzone" is "not visible"
    And I validate if element on chat page "inactiveImageDropzone" is "not visible"
    And I validate if element on chat page "headerImageDropzone" is "not visible"

