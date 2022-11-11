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

#    And I click on save and continue on Marketing Email Composer
#    And I close alert if return this message "Email has been updated."
#
