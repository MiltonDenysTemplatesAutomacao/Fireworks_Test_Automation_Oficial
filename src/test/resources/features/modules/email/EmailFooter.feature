#Author: Milton Silva
#Regression testcase TL-668 (1 of 2): Email Footer

@EmailFooter
Feature: Email Footer

  @EmailFooterScenario1 @Done @Email
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
    When I verify if email was sent correctly "Subject Marketing Footer test 6010", "firestarter@fire-engine-red.com", "Fire Starter", "Roberto Bolle"
    And I verify email content on mail trap is "visible" for subject "Subject Marketing Footer test 6010", "HTML body content for Marketing Footer test 6010", "TEXT body content for Marketing Footer test 6010"
    #to check the contents of the can-spam footer
    And I verify email content on mail trap is "visible" for subject "Subject Marketing Footer test 6010", "Inquiry", ""
    And I verify email content on mail trap is "visible" for subject "Subject Marketing Footer test 6010", "Unsubscribe", ""
    And I verify email content on mail trap is "visible" for subject "Subject Marketing Footer test 6010", "", "Fire Engine Red"
    And I verify email content on mail trap is "visible" for subject "Subject Marketing Footer test 6010", "", "1100 E 6th Ave"
    And I verify email content on mail trap is "visible" for subject "Subject Marketing Footer test 6010", "", "Aurora, Colorado 80010"
    And I verify email content on mail trap is "not visible" for subject "Subject Marketing Footer test 6010", "not validation necessary", "Aurora, Colorado 80010 0"
    And I verify email content on mail trap is "not visible" for subject "Subject Marketing Footer test 6010", "not validation necessary", "United States"
    And I verify email content on mail trap is "visible" for subject "Subject Marketing Footer test 6010", "", "We collected your email address from your "
    And I verify email content on mail trap is "visible" for subject "Subject Marketing Footer test 6010", "", "Inquiry"
    #verify this step parameter later
    #And I verify email content on mail trap is "visible" for subject "Subject Marketing Footer test 6010", "", "testing.site.education/email/unsubscribe/"

  @EmailFooterScenario2 @Done @Email
  Scenario: verify FER Admin can disable the can-spam footer in marketing emails
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to Email settings page
    And I use datatable
      |OrganizationName|OrganizationEmail                |ReplyToEmail                      |PhoneNumberEmail|Address1Email  |City   |State/Province|PostalCode|
      |Fire Engine Red |sender.email@fire-engine-red.com |replyto.email@fire-engine-red.com |1-800-555-1212  |1100 E 6th Ave |Aurora |Colorado      |80010     |
    And I update CAM-SPAM index 0
    And I click on "Save Profile"
    When I create a person
      |FirstName    |LastName     |EmailAddress              |EmailType|EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|
      |Nikolayevich |Baryshnikov  |nBaryshnikov@ballet.com   |Personal |Inquiry          |Student|Freshman   |Accepted             |Accepted     |01/15/2019       |Fall 2017|
    And I validate if "Person has been created." message is correct
    #to create a marketing email and disable the footer
    And I navigate to email manager page
    And I click on create a new email button and select type "Marketing"
    When I update Email Start Tab "", "No Footer test 6020", "", "", "nBaryshnikov@ballet.com"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "Fire Starter", "firestarter@fire-engine-red.com", "", "Subject No Footer test 6020", "", ""
    And I click on disable message footer checkbox
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I update Email Content Tab "HTML body content for No Footer test 6020", "TEXT body content for No Footer test 6020"
    #it is necessary to click twice at this point
    And I click on save and continue on Marketing Email Composer
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #to send the email
    And I send email
    #fix last parameter here
    And I verify RecipientsPreview "Nikolayevich", "Baryshnikov", "nBaryshnikov@ballet.com", "", ""
    And I confirm EmailSend "Person"
    Then I validate if "Email has been queued." message is correct
      #to wait until the email is sent
    And I navigate to email manager page
    When I wait until email sent "No Footer test 6020"
    #to verify the sent email in mailtrap
    When I verify if email was sent correctly "Subject No Footer test 6020", "firestarter@fire-engine-red.com", "Fire Starter", "Nikolayevich Baryshnikov"
    And I verify email content on mail trap is "visible" for subject "Subject No Footer test 6020", "HTML body content for No Footer test 6020", "TEXT body content for No Footer test 6020"
    #the can-spam footer is not displayed
    And I verify email content on mail trap is "not visible" for subject "Subject No Footer test 6020", "Inquiry", "not validation necessary"
    And I verify email content on mail trap is "not visible" for subject "Subject No Footer test 6020", "Unsubscribe", "not validation necessary"
    And I verify email content on mail trap is "not visible" for subject "Subject No Footer test 6020", "not validation necessary", "Fire Engine Red"
    And I verify email content on mail trap is "not visible" for subject "Subject No Footer test 6020", "not validation necessary", "1100 E 6th Ave"
    And I verify email content on mail trap is "not visible" for subject "Subject No Footer test 6020", "not validation necessary", "Aurora, Colorado 80010"
    And I verify email content on mail trap is "not visible" for subject "Subject No Footer test 6020", "not validation necessary", "Aurora, Colorado 80010 0"
    And I verify email content on mail trap is "not visible" for subject "Subject No Footer test 6020", "not validation necessary", "United States"
    And I verify email content on mail trap is "not visible" for subject "Subject No Footer test 6020", "not validation necessary", "We collected your email address from your "
    And I verify email content on mail trap is "not visible" for subject "Subject No Footer test 6020", "not validation necessary", "testing.site.education/email/unsubscribe/"

