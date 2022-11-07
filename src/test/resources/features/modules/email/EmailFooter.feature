#Author: Milton Silva
#Regression testcase TL-668 (1 of 2): Email Footer

@EmailFooter
Feature: Email Footer

  @EmailFooterScenario @Done @Email
  Scenario: email actions are recorded for persons
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to Email settings page
    And I use datatable
      |OrganizationName|OrganizationEmail                |ReplyToEmail                      |PhoneNumberEmail|Address1Email  |City   |State/Province|PostalCode|
      |Fire Engine Red |sender.email@fire-engine-red.com |replyto.email@fire-engine-red.com |1-800-555-1212  |1100 E 6th Ave |Aurora |Colorado      |80010     |
    And I update CAM-SPAM index 0
    And I click on "Save Profile"
    When I create a person
      |FirstName  |LastName |EmailAddress        |EmailType|EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|
      |Roberto    |Bolle    |rbolle@ballet.com   |Personal |Inquiry          |Student|Freshman   |Accepted             |Accepted     |01/15/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    #to create a marketing email
    And I navigate to email manager page
    And I click on create a new email button and select type "Marketing"
    When I update Email Start Tab "", "Marketing Footer test 6010", "", "", "rbolle@ballet.com"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "Fire Starter", "firestarter@fire-engine-red.com", "", "Subject Marketing Footer test 6010", "", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I update Email Content Tab "HTML body content for Marketing Footer test 6010", "TEXT body content for Marketing Footer test 6010"
    #it is necessary to click twice at this point
    And I click on save and continue on Marketing Email Composer
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #to send the email
    And I send email
    And I verify RecipientsPreview "Roberto", "Bolle", "rbolle@ballet.com", "", ""
    And I confirm EmailSend "Person"
    Then I validate if "Email has been queued." message is correct
    #to wait until the email is sent
    And I navigate to email manager page
    When I wait until email sent "Marketing Footer test 6010"
    #to verify the sent email in mailtrap
    And I open email "Marketing Footer test 6010"
    And I validate message header "Fire Starter", "firestarter@fire-engine-red.com", "", "Subject Marketing Footer test 6010", "", "HTML body content for Marketing Footer test 6010", "HTML body content for Marketing Footer test 6010"
    #to check the contents of the can-spam footer

