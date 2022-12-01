#Author: Milton Silva
#Regression testcase TL-105: Send Email: Required fields

@SendEmailRequiredFields
Feature: Merge Fields Replacement when No Value

  @SendEmailRequiredFieldsScenarios @Done @Email
  Scenario: email required fields
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |EmailAddress          |EmailType|EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|
      |Estanisloa |Figueras |efigueras@espana.com  |Personal |Inquiry          |Student|Freshman   |Accepted             |Accepted     |09/15/2017       |Fall 2017|
    And I validate if "Person has been created." message is correct
    #to create an email
    And I navigate to email manager page
    And I click on create a new email button and select type "Non-Marketing"
    #to validate required fields on the start tab
    And I click on save and continue on Marketing Email Composer
    And I verify validation message "The Name field is required."
    And I verify validation message "At least one recipient is required."
    And I click on close button on modal
    When I update Email Start Tab "", "Email Required Fields 6210", "", "", "efigueras@espana.com"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    #to validate required fields on tab 2
    And I click on save and continue on Marketing Email Composer
    And I verify validation message "The Sender Email field is required."
    And I verify validation message "The Subject field is required."
    And I click on close button on modal
    And I update Email Headers Tab "", "prey@fire-engine-red.com", "", "Email Required Fields 6210", "", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #to validate required fields on tab 3
    And I click on save and continue on Marketing Email Composer
    And I click on save and continue on Marketing Email Composer
    And I verify validation message "Content is required."
    And I click on close button on modal
    And I update Email Content Tab "This is the GTUBE, the<br>Generic<br>Test for<br>Unsolicited<br>Bulk<br>Email<br><br>If your spam filter supports it, the GTUBE provides a test by which you can verify that the filter is installed correctly and is detecting incoming spam. You can send yourself a test mail containing the following string of characters (in upper case and with no white spaces and line breaks):<br> XJS*C4JDBQADN1.NSBN3*2IDNEN*GTUBE-STANDARD-ANTI-UBE-TEST-EMAIL*C.34X", ""
    And I click on Save Changes on content tab
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #No required fields on tab 4
    #SpamAssassin score needs to be less than 65% to returned expected validation message
    And I click on save and continue on Marketing Email Composer
    #And I click on finish tab
#    And I click on save and continue on Marketing Email Composer
    And I send email
    And I confirm EmailSend "Person"
    And I close alert if return this message "Spam score must be equal or greater than 65%."
    #to edit the body content so that the email can be sent


