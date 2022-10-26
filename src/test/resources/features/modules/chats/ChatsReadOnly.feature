#Author: Milton Silva
#Regression testcase TL-1182: Chats Permissions: View but not Create
#Regression testcase TL-1184: Chats Permissions: Settings - View but not Create

@ChatSettingsViewButNotCreate
Feature: Chat Settings - View but not Create

  @ChatSettingsViewButNotCreateScenario @Done @Chats
  Scenario: verify this permissions group only has read only access to chats and settings
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I open chat ""