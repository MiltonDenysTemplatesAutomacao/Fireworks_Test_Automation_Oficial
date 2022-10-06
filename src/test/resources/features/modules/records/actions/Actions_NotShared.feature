#Author: Milton Silva
#Regression testcase TL-205: Exact match auto-merge on rule 5: IDType-ID-LastName
#Regression testcase TL-1062: Email recipients can be merged
#Regression testcase TL-1124: Actions are not shared

@ActionsAreNotShared
Feature: Exact match auto-merge on rule 5: IDType-ID-LastName,Email recipients can be merged,Actions are not shared

  @ActionsAreNotSharedPerson @Done @Actions
  Scenario: Record - Actions - actions are not shared between records therefore email recipients can be merged
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName     |EmailAddress             |EmailType|EmailOptInMethod |Role1 |Category     |Action                         |Staff        |ActionDateTime     |ActionDateField|
      |Maggie     |Rutherford   |MagRutherford@actors.net |Personal |Inquiry          |Person|Campus Events|Admitted Student Day: Register |Fire Starter |11/30/2017 8:00 AM |11/30/2017     |
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName  |LastName     |EmailAddress             |EmailType|EmailOptInMethod |Role1 |Category     |Action                         |Staff        |ActionDateTime     |ActionDateField|Type                 |ID Number|Who Added ID   |
      |Margaret   |Rutherford   |MRutherford@actors.net   |Personal |Inquiry          |Person|Campus Events|Admitted Student Day: Register |Fire Starter |11/30/2017 8:00 AM |11/30/2017     |College Board Search |6100     |Fire Starter   |
    And I close alert if return this message "Person has been created."
    And I validate if "Margaret"summary opened properly
    And I navigate to ID Types
    When I update "Type", "ID Number", "", "Who Added ID", and "" to update external ID Types for person
    And I close alert if return this message "Person has been updated."
    When I create a person
      |FirstName  |LastName     |EmailAddress             |EmailType|EmailOptInMethod |Role1 |
      |Martha     |Rutherford   |MRRutherford@actors.net  |Personal |Inquiry          |Person|
    And I validate if "Person has been created." message is correct
    And I navigate to smart search page
    And I click on create smart search button
    And I select "Last Name" search field group "0" in smart search composer
    And I select "equals" operator field group "0" in smart search composer
    And I fill "Rutherford" text condition value group "0"
    And I fill smart search name "Search for Test6100"
    And I click on save this search button
    And I close alert if return this message "Smart Search has been created."

  @SentEmailAction @Done @Actions
  Scenario: Record - Actions - to send an email with a user action
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to email manager page
    And I click on create a new email button and select type "Marketing"
    When I update Email Start Tab "", "Actions NotShared 6100", "", "Search for Test6100", ""
    And I click on save and continue on Marketing Email Composer
    And I update Email Headers Tab "", "firestarter@fire-engine-red.com", "", "Subject Actions NotShared 6100", "", ""
    And I click on save and continue on Marketing Email Composer
    And I update Email Content Tab "Body content Actions NotShared 6100", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I click on finish tab
    And I update Email Finish Tab "Campus Events", "Admitted Student Day: Register", "Fire Starter", "01/20/2020", "OriginalComments"
    And I send email
    And I confirm EmailSend
    Then I validate if "Email has been queued." message is correct
    #to wait until the email is sent
    And I wait until email sent "Actions NotShared 6100"

  @VerifyEditUserEmailPerson2 @Fix @Actions
  Scenario: Record - Actions - to verify then edit the user email action for person2
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I navigate to people on records
    And I open a people record by "MRutherford@actors.net"
    And I validate if "Margaret"summary opened properly
    And I navigate to Actions
    And I verify action Datatable values index "", values "Email Event", "Email Sent", "Fire Starter", "", ""
