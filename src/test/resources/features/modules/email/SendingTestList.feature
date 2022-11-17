#Author: Milton Silva
#Regression testcase TL-934: Sending Test Email to Test List

@SendingTestEmailToTestList
Feature: Sending Test Email to Test List

  @SendingTestEmailToTestList1 @Done @Email
  Scenario: verify we can send a test email to a test list
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create a test list
    And I navigate to Email settings page
    And I click on Test Lists
    And I click on create test list button
    #work on this step on recipients to put more than 1 email
    When I update test list "6035TestList", "Test List for 6035", "test1-6035@ferfun.com"
    And I update recipients "test2-6035@ferfun.com", "test3-6035@ferfun.com"
    And I click on "Save Changes"
    And I close alert if return this message "Email test list has been created."
    Then I verify test list "6035TestList", "Test List for 6035", "test1-6035@ferfun.com"
    Then I verify test list "", "", "test2-6035@ferfun.com"
    Then I verify test list "", "", "test3-6035@ferfun.com"
    #to create an email
    And I navigate to email manager page
    And I click on create a new email button and select type "Direct"
    When I update Email Start Tab "", "Send to Test List 6035", "", "2016 Entry Term", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "Fire Starter", "firestarter@fire-engine-red.com", "", "Send to Test List 6035", "Preheaders 6035", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I update Email Content Tab "Email 6035 HTML body content", ""
    #it is necessary to click twice at this point
    And I click on save and continue on Marketing Email Composer
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #to send a test email to a test list
    And I send a test email "6035TestList", "", "Note to test list"
    #to check the mailbox for the first test email
    When I verify if email was sent correctly "Send to Test List 6035", "firestarter@fire-engine-red.com", "Fire Starter", "test1-6035@ferfun.com,test2-6035@ferfun.com,test3-6035@ferfun.com"
    And I verify email content on mail trap is "visible" for subject "Send to Test List 6035", "Note to test list", ""
    And I verify email content on mail trap is "visible" for subject "Send to Test List 6035", "Email 6035 HTML body content", ""
    And I verify email content on mail trap is "visible" for subject "Send to Test List 6035", "Preheaders 6035", ""
    #to delete the email from mailtrap
    And I delete email on mail trap "Send to Test List 6035"
    #to check the mailbox for the second test email
    When I verify if email was sent correctly "Send to Test List 6035", "firestarter@fire-engine-red.com", "Fire Starter", ""
    And I verify email content on mail trap is "visible" for subject "Send to Test List 6035", "Note to test list", ""
    And I verify email content on mail trap is "visible" for subject "Send to Test List 6035", "Email 6035 HTML body content", ""
    And I verify email content on mail trap is "visible" for subject "Send to Test List 6035", "Preheaders 6035", ""
    #to delete the email from mailtrap
    And I delete email on mail trap "Send to Test List 6035"
    #to check the mailbox for the third test email
    When I verify if email was sent correctly "Send to Test List 6035", "firestarter@fire-engine-red.com", "Fire Starter", ""
    And I verify email content on mail trap is "visible" for subject "Send to Test List 6035", "Note to test list", ""
    And I verify email content on mail trap is "visible" for subject "Send to Test List 6035", "Email 6035 HTML body content", ""
    And I verify email content on mail trap is "visible" for subject "Send to Test List 6035", "Preheaders 6035", ""
    #the manual test log appears
    And I verify Manual test log "test1-6035@ferfun.com"
    And I verify Manual test log "test2-6035@ferfun.com"
    And I verify Manual test log "test3-6035@ferfun.com"
    #after reloading the page, the datetime is displayed in campus timezone
    And I verify today´s date in Manual test log
    And I delete email on mail trap "Send to Test List 6035"
