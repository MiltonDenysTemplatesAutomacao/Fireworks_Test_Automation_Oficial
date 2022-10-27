#Author: Milton Silva
#Regression testcase TL-1183: Chats Permissions: Delete

@ChatsPermissionsDelete
Feature: Chats Permissions: Delete

  @ChatsPermissionsDelete @Fix @Chats
  Scenario: verify this permissions group only has read only access to chats and settings
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #the Delete button is not visible
    And I navigate to chats page
    And I open chat "Test3175"
    And I validate if element on chat page "deleteChatButton" is "not visible"
