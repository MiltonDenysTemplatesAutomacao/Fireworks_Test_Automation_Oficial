#Author: Milton Silva
#Regression testcase TL-731: Opt-in Status restrictions
#Regression testcase TL-966: CAN-SPAM Act Warning message

@OptInStatusRestrictions
Feature: Opt-in Status restrictions

  @OptInStatusRestrictionsScenarios @Done @Email
  Scenario: verify recipients with unsubscribed email addresses are excluded only from marketing emails
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |EmailAddress           |EmailType|EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|
      |Nina       |Shipman  |ninashipman@actors.com |Personal |Inquiry          |Student|Freshman   |Accepted             |Accepted     |01/15/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    #Update the email address to unsubscribed and valid
    And I validate if "Nina Shipman"summary opened properly
    And I navigate to contact
    And I update email on contact for person "", "", "Valid", "", "Unsubscribed", "", "", "" and group "0"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    #to create a smart search
    And I navigate to smart search page
    And I click on create smart search button
    And I select "Last Name" search field group "0" condition "0" in smart search composer
    And I select "equals" operator field group "0" condition "0" in smart search composer
    And I fill "Shipman" text group "0" condition "0"
    And I fill smart search name "6280 Unsubscribed search"
    And I click on save this search button
    And I close alert if return this message "Smart Search has been created."
    #to create a marketing email that will exclude records with an unsubscribed email
    And I navigate to email manager page
    And I click on create a new email button and select type "Marketing"
    When I update Email Start Tab "", "Unsubscribed test 6280", " -Marketing", "6280 Unsubscribed search", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "", "firestarter@fire-engine-red.com", "", "Subject Unsubscribed test 6280", "", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I update Email Content Tab "Body content Unsubscribed test 6280", ""
    And I click on save and continue on Marketing Email Composer
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #to verify that preview recipients excludes based on opt-in status
    And I click on finish tab
    And I send email
    And I verify RecipientsPreview "Nina", "Shipman", "ninashipman@actors.com", "Email address is marked as 'Unsubscribed", "0"
    When I close preview recipients button
    #to create a direct email that does not exclude those with unsubscribed opt-in status
    And I navigate to email manager page
    And I click on create a new email button and select type "Direct"
    When I update Email Start Tab "", "Unsubscribed test 6280", " -Direct", "6280 Unsubscribed search", ""
    And I click on "Save Changes"
    And I close alert if return this message "Email has been created."
    #to verify preview recipients shows no recipients are excluded
    When I open preview recipients button
    And I verify RecipientsPreview "Nina", "Shipman", "ninashipman@actors.com", "", "1"
    When I close preview recipients button
    #to verify a non-marketing email does not exclude unsubscribed but does display the can spam warning
    And I navigate to email manager page
    And I click on create a new email button and select type "Non-Marketing"
    When I update Email Start Tab "", "Unsubscribed test 6280", " -NonMarketing", "6280 Unsubscribed search", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "", "firestarter@fire-engine-red.com", "", "Subject Unsubscribed test 6280", "", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I update Email Content Tab "Body content Unsubscribed test 6280", ""
    And I click on save and continue on Marketing Email Composer
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I click on finish tab
    And I send email
    And I verify RecipientsPreview "Nina", "Shipman", "ninashipman@actors.com", "", "1"
    And I confirm EmailSend "Person"
    And I confirm NoMarketingContent
    And I close alert if return this message "Email has been queued."
    And I navigate to email manager page
    When I wait until email sent "Unsubscribed test 6280"