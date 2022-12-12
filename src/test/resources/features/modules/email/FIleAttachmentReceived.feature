#Author: Milton Silva
#Regression testcase TL-1071: File Attachment received

@FileAttachmentReceived
Feature: File Attachment received

  @FileAttachmentReceivedScenarios @Fix @Email
  Scenario: verify an attachment sent with an email is received
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |EmailAddress          |EmailType|EmailOptInMethod |Role1 |
      |Tom        |Helmore  |tomhelmore@actors.com |Personal |Campus Visit     |Person|
    And I validate if "Person has been created." message is correct
    #to create an email
    And I navigate to email manager page
    And I click on create a new email button and select type "Marketing"
    When I update Email Start Tab "", "File Attachment test 6330", "", "", "tomhelmore@actors.com"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "Fire Starter", "firestarter@fire-engine-red.com", "", "Subject File Attachment test 6330", "Preheader File Attachment test 6330", "93KBmediafile.png"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #to add a second attachment
    And I click on headers Tab
    And I update Email Headers Tab "", "", "", "", "", "11KBmediafile.png"
    And I click on save and continue on Marketing Email Composer
    And I update Email Content Tab "Body content File Attachment test 6330", "Body content File Attachment test 6330"
    And I click on "Save Changes"
    #to send the email
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I click on finish tab
    And I send email
    And I confirm EmailSend "Person"
    Then I validate if "Email has been queued." message is correct
    #to wait until the email is sent
    And I navigate to email manager page
    When I wait until email sent "File Attachment test 6330"
    #to verify the sent email in mailtrap
    When I verify if email was sent correctly "Subject File Attachment test 6330", "firestarter@fire-engine-red.com", "Fire Starter", "Tom Helmore"
    And I verify email content on mail trap is "visible" for subject "File Attachment test 6330", "Preheader File Attachment test 6330", "Preheader File Attachment test 6330"
    And I verify email content on mail trap is "visible" for subject "File Attachment test 6330", "Body content File Attachment test 6330", "Body content File Attachment test 6330"
    #to verify the attachment filenames
    And I validate attachment file names subject "Subject File Attachment test 6330" filename "93KBmediafile.png"