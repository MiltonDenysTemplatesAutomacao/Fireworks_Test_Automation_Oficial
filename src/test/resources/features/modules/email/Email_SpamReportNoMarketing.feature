#Author: Milton Silva
#Regression testcase TL-570: Email Status - Spam Report

@EmailStatusSpamReport
Feature: Email Status - Spam Report

  @EmailStatusSpamReportScenarios @Done @Email
  Scenario: verify recipients with spam report email addresses are excluded only from marketing emails
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |EmailAddress            |EmailType|EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|
      |Roland     |Gotti    |rolandgotti@actors.com  |Personal |Student Search   |Student|Freshman   |Accepted             |Accepted     |01/15/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName  |LastName |EmailAddress            |EmailType|EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|
      |Victor     |Gotti    |victorgotti@actors.com  |Personal |Student Search   |Student|Freshman   |Accepted             |Accepted     |01/15/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    #to update the email status to Spam Report
    And I validate if "Victor Gotti"summary opened properly
    And I navigate to contact
    And I update email on contact for person "", "", "Spam Report", "", "", "", "", "" and group "0"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    #to create a smart search
    And I navigate to smart search page
    And I click on create smart search button
    And I select "Last Name" search field group "0" condition "0" in smart search composer
    And I select "equals" operator field group "0" condition "0" in smart search composer
    And I fill "Gotti" text group "0" condition "0"
    And I fill smart search name "Search for test 6260"
    And I click on save this search button
    And I close alert if return this message "Smart Search has been created."
    #to create a marketing email
    And I navigate to email manager page
    And I click on create a new email button and select type "Marketing"
    When I update Email Start Tab "", "Spam Report exclusion test 6260", " -Marketing", "Search for test 6260", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "", "firestarter@fire-engine-red.com", "", "Subject Spam Report exclusion test 6260", "", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I update Email Content Tab "This is HTML body content Spam Report exclusion test 6260", ""
    And I click on save and continue on Marketing Email Composer
    And I click on save and continue on Marketing Email Composer
    And I validate if "Email has been updated." message is correct
    And I click on save and continue on Marketing Email Composer
    #to verify preview recipients excludes those with spam report email status
    And I send email
    And I verify RecipientsPreview "Roland", "Gotti", "rolandgotti@actors.com", "", "1"
    And I verify RecipientsPreview "Victor", "Gotti", "victorgotti@actors.com", "Invalid Email address status for this Email type.", "1"
    When I close preview recipients button
    #to create a direct email that does not exclude spam report email status
    And I navigate to email manager page
    And I click on create a new email button and select type "Direct"
    When I update Email Start Tab "", "Spam Report exclusion test 6260", " -Direct", "Search for test 6260", ""
    And I click on "Save Changes"
    And I close alert if return this message "Email has been created."
    #to verify preview recipients shows no recipients are excluded
    When I open preview recipients button
    And I verify RecipientsPreview "Roland", "Gotti", "rolandgotti@actors.com", "", "2"
    And I verify RecipientsPreview "Victor", "Gotti", "victorgotti@actors.com", "", "2"
    When I close preview recipients button
    #to create a non-marketing email that does not exclude spam report email status
    And I navigate to email manager page
    And I click on create a new email button and select type "Non-Marketing"
    When I update Email Start Tab "", "Spam Report exclusion test 6260", " -NonMarketing", "Search for test 6260", ""
    And I click on "Save Changes"
    And I close alert if return this message "Email has been created."
    #to verify preview recipients shows no recipients are excluded
    When I open preview recipients button
    And I verify RecipientsPreview "Roland", "Gotti", "rolandgotti@actors.com", "", "2"
    And I verify RecipientsPreview "Victor", "Gotti", "victorgotti@actors.com", "", "2"
    When I close preview recipients button