#Author: Milton Silva
#Regression testcase TL-712: Message Header data is delivered in email

@EmailMessageHeader
Feature: Sending Test Email to Test List

  @EmailMessageHeaderScenario @Done @Email
  Scenario: verify the message header in sent emails
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create a staff record to be the counselor
    When I create a staff
      |FirstName |LastName  |FullName       |EmailAddress       |EmailType|PermissionGroup |
      |Audrey    |Hepburn   |Audrey Hepburn |AHepburn@actors.net|Personal |Administrator   |
    And I validate if "Staff member has been created. They have been sent a welcome email with a link prompting them to login and create a password. The link in this email will expire in 12 hours." message is correct
    #to create a student record with an assigned counselor
    When I create a person
      |FirstName  |LastName  |Role1    |EmailAddress                  |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory|StudentStatus   |StudentStatusDate|EntryTerm|
      |Hubert     |Givenchy  |Student  |housedeGivenchy@designers.com |Personal   |Inquiry         |Non-degree |Deposited            |Active-Deposited|03/10/2018       |Fall 2018|
    And I validate if "Person has been created." message is correct
    And I update Header Assigned Staff "Audrey Hepburn"
    And I verify Header Assign Staff "Audrey Hepburn"
    #to create an email
    And I navigate to email manager page
    And I click on create a new email button and select type "Non-Marketing"
    When I update Email Start Tab "", "Message Header Test 6040", "", "", "housedeGivenchy@designers.com"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "Fire Starter", "firestarter@fire-engine-red.com", "firestarter@fire-engine-red.com", "6040 Message Header Test", "Preheaders 6040", ""
    #to choose use assigned counselor for the sender name
    And I click checkbox Use assigned counselor when available
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I update Email Content Tab "Email 6040 body content", ""
    #it is necessary to click twice at this point
    And I click on save and continue on Marketing Email Composer
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #to send the email
    And I send email
    And I confirm EmailSend "Person"
    Then I validate if "Email has been queued." message is correct
    #to wait until the email is sent
    And I navigate to email manager page
    When I wait until email sent "Message Header Test 6040"
    And I open email "Message Header Test 6040"
    #to verify the message data
    When I verify if email was sent correctly "6040 Message Header Test", "firestarter@fire-engine-red.com", "Audrey Hepburn", "Hubert Givenchy"
    And I verify email content on mail trap is "visible" for subject "6040 Message Header Test", "Email 6040 body content", ""
    And I verify email content on mail trap is "visible" for subject "6040 Message Header Test", "Preheaders 6040", ""