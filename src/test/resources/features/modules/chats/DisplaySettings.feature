#Author: Milton Silva
#Regression testcase TL-1169: Chat Display Settings

@ChatDisplaySettings
Feature: Chat Display Settings

  @ChatDisplaySettingsScenario @Done @Chats
  Scenario: verify chat display settings
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to chat setting page
    When I update email contact in setting chat page "ChatTest@fire-engine-red.com"
    #verify default images exist
    And I verify image thumbnail "active" and filename "chat_active_image"
    And I verify image thumbnail "inactive" and filename "chat_inactive_image"
    #verify file type and size restrictions
    When I upload a file on chat settings page "11KBmediafile.tif" on "active" thumbnail
    Then I validate if "active" error message on chat settings page is correct "Error: You can't upload files of this type."
    And I click on "Save Changes"
    And I close alert if return this message "Chat settings have been successfully saved!"
    And I verify image thumbnail "active" and filename "chat_active_image"
    When I upload a file on chat settings page "6MBmediafile.png" on "inactive" thumbnail
    Then I validate if "inactive" error message on chat settings page is correct "Error: File size of 5.9 MB exceeds maximum filesize of 1 MB."
    And I click on "Save Changes"
    And I close alert if return this message "Chat settings have been successfully saved!"
    And I verify image thumbnail "inactive" and filename "chat_inactive_image"
    #upload custom images
    When I upload a file on chat settings page "Online Icon.png" on "active" thumbnail
    And I click on "Save Changes"
    And I close alert if return this message "Chat settings have been successfully saved!"
    And I verify image thumbnail "active" and filename "Online Icon.png"
    When I upload a file on chat settings page "Offline Icon.jpg" on "inactive" thumbnail
    And I click on "Save Changes"
    And I close alert if return this message "Chat settings have been successfully saved!"
    And I verify image thumbnail "inactive" and filename "Offline Icon.jpg"
    When I upload a file on chat settings page "FER_logo.gif" on "header" thumbnail
    And I click on "Save Changes"
    And I close alert if return this message "Chat settings have been successfully saved!"
    And I verify image thumbnail "header" and filename "FER_logo.gif"
