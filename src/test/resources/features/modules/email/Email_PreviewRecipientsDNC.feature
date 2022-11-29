#Author: Milton Silva
#Regression testcase TL-568: Emails cannot be sent to Do Not Contact records
#Regression testcase TL-702: Preview Recipients

@EmailsCannotBeSentToDoNotContactRecords
Feature: Sending Test Email to Test List

  @EmailsCannotBeSentToDoNotContactRecordsScenario @Done @Email
  Scenario: verify we can preview email recipients
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName |LastName  |Role1    |EmailAddress     |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory|StudentStatus   |StudentStatusDate|EntryTerm|
      |Julio     |Boca      |Student  |jboca@ballet.com |Personal   |Inquiry         |Freshman   |Accepted             |Accepted        |15/08/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName |LastName  |Role1    |EmailAddress     |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory|StudentStatus   |StudentStatusDate|EntryTerm|
      |Abril     |Boca      |Student  |aboca@ballet.com |Personal   |Inquiry         |Freshman   |Accepted             |Accepted        |15/08/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    #to change this person to OK to Contact = No
    And I validate if "Abril Boca"summary opened properly
    And I update Header Ok to Contact "No"
    And I verify Header Ok to Contact "No"
    #to create a smart search for those person records
    And I navigate to smart search page
    And I click on create smart search button
    And I select "Last Name" search field group "0" condition "0" in smart search composer
    And I select "equals" operator field group "0" condition "0" in smart search composer
    And I fill "Boca" text group "0" condition "0"
    And I fill smart search name "Search for Email Test 6050"
    And I click on save this search button
    And I close alert if return this message "Smart Search has been created."
    #to create an email
    And I navigate to email manager page
    And I click on create a new email button and select type "Marketing"
    When I update Email Start Tab "", "Preview Recipients Test 6050", "Email 6050 Description", "Search for Email Test 6050", ""
    #to verify the preview recipients window
    When I open preview recipients button
    And I verify RecipientsPreview "Julio", "Boca", "jboca@ballet.com", "", "1"
    And I verify RecipientsPreview "Abril", "Boca", "aboca@ballet.com", "Record marked as 'Do Not Contact'.", "1"
    When I close preview recipients button
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    #to reopen the email to check again
    And I navigate to email manager page
    And I open email "Preview Recipients Test 6050"
    When I open preview recipients button
    And I verify RecipientsPreview "Julio", "Boca", "jboca@ballet.com", "", "1"
    And I verify RecipientsPreview "Abril", "Boca", "aboca@ballet.com", "Record marked as 'Do Not Contact'.", "1"
    When I close preview recipients button