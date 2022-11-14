#Author: Milton Silva
#Regression testcase TL-707: Manual test email

@ManualTestEmail
Feature: Manual test email

  @ManualTestEmailScenario @Done @Email
  Scenario: verify we can send a manual test email
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |EmailAddress        |EmailType|EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|
      |Erik       |Bruhn    |ebruhn@ballet.com   |Personal |Inquiry          |Student|Freshman   |Accepted             |Accepted     |08/15/2019       |Fall 2019|
    And I validate if "Person has been created." message is correct
    #to create a marketing email
    And I navigate to email manager page
    And I click on create a new email button and select type "Non-Marketing"
    When I update Email Start Tab "", "Send Test Email 6030", "Email 6030 Description", "", "ebruhn@ballet.com"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "Rudolph Nureyev", "rnureyev@ballet.com", "", "Subject 6030 Test Email", "Preheaders 6030", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I update Email Content Tab "Email 6030 HTML body content", ""
    #it is necessary to click twice at this point
    And I click on save and continue on Marketing Email Composer
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #to send a test email with a note to two email addresses
    And I send a test email "6030test@ferfun.com,", "test6030@ferfun.com", "Note with test email"
    #to check the mailbox for the first test email
    When I verify if email was sent correctly "Subject 6030 Test Email", "rnureyev@ballet.com", "Rudolph Nureyev", ""
    And I verify email content on mail trap is "visible" for subject "Subject 6030 Test Email", "Note with test email", ""
    And I verify email content on mail trap is "visible" for subject "Subject 6030 Test Email", "Email 6030 HTML body content", ""
    #to delete the email from mailtrap
    And I delete email on mail trap "Subject 6030 Test Email"
    #to check the mailbox for the second test email
    When I verify if email was sent correctly "Subject 6030 Test Email", "rnureyev@ballet.com", "Rudolph Nureyev", ""
    And I verify email content on mail trap is "visible" for subject "Subject 6030 Test Email", "Note with test email", ""
    And I verify email content on mail trap is "visible" for subject "Subject 6030 Test Email", "Email 6030 HTML body content", ""
    #$testEmailRecipients = [$message1ToName, $message2ToName];
  #$I->assertContains($normalizedTestEmailAddress, $testEmailRecipients);
  #$I->assertContains($normalizedTestEmailAddress2, $testEmailRecipients);
  #the manual test log appears
    And I verify Manual test log "6030test@ferfun.com"
    And I verify Manual test log "test6030@ferfun.com"
    And I verify Manual test log "test6030@ferfun.com"
  #after reloading the page, the datetime is displayed in campus timezone
    And I verify today´s date in Manual test log
    #verify no action was added to email single recipient
    And I navigate to people on records
    And I open a people record by "Bruhn"
    And I validate if "Erik Bruhn"summary opened properly
    And I navigate to Actions
    Then I validate if action were deleted


