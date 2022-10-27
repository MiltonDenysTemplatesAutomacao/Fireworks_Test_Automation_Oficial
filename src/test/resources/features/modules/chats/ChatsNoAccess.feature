#Author: Milton Silva
#Regression testcase TL-1180: Chats Permissions: Restricted checkbox

@ChatsPermissionsRestrictedCheckbox
Feature: Chats Permissions: Restricted checkbox

  @ChatsPermissionsRestrictedCheckboxScenario @Fix @Chats
  Scenario: verify this permissions group can not access chats
    Given I login as "chatsNoAccessUsername", "chatsNoAccessPassword", "chatsNoAccessFullName"
    And I validate if element "footerToolsMenu" is "visible"
    And I validate if element "footerRecordsMenu" is "visible"
    And I validate if element "footerQuickAddMenu" is "visible"
    And I validate if element "footerSettingsMenu" is "visible"
    And I validate if element "footerCommunicationsMenu" is "visible"
    And I navigate to footer communications menu
    And I validate if element "footerCommunicationsChatsMenuItem" is "not visible"
