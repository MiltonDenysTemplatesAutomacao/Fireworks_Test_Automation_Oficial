#Author: Milton Silva
#Regression testcase TL-177 (2 of 2): File Attachments - Limits test

@FileAttachmentsLimitsTest
Feature: File Attachments - Limits test

  @FileAttachmentsLimitsTestScenarios @Done @Email
  Scenario: verify attachments limits are in place
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to see an error returned if invalid file type is uploaded
   #to create an email
    And I navigate to email manager page
    And I click on create a new email button and select type "Marketing"
    When I update Email Start Tab "", "Email Attachment Limits", "Description Email Attachment Limits", "2016 Entry Term", ""
    And I click on save and continue on Marketing Email Composer
    And I update Email Headers Tab "Fire Starter", "firestarter@fire-engine-red.com", "", "Subject Line Email Attachment Limits", "", "11KBmediafile.tif"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #to see an error returned if the file size exceeds the limit
    And I click on headers Tab
    And I update Email Headers Tab "", "", "", "", "", "6MBmediafile.png"
    And I validate email attachment file message "exceeds maximum filesize of 5 MB."
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #to see an error returned when two files exceed the limit
    And I click on headers Tab
    And I update Email Headers Tab "", "", "", "", "", "2MBmediafile.png"
    And I click on "Save Changes"
    And I close alert if return this message "Email has been updated."
    And I update Email Headers Tab "", "", "", "", "", "4MBmediafile.png"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
