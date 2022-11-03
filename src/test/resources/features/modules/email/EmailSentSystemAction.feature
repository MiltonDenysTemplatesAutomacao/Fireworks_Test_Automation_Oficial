#Author: Milton Silva
#Regression testcase TL-174 (1 of 2): User-defined Email Actions
#Regression testcase TL-933 (1 of 2): Email Sent System action

@EmailSentSystemAction
Feature: Email Sent System Action

  @EmailSentSystemActionPersonScenarios @Done @Email
  Scenario: email actions are recorded for persons
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |EmailAddress              |EmailType|EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|Staff |Category|Action|ActionType|ActionVisibility|
      |Trevor     |Baylis   |tbaylis@windupradio.com   |Personal |Inquiry          |Student|Freshman   |Accepted             |Accepted     |12/15/2017       |Fall 2017|Select|Select  |Select|Select    |Select          |
      |           |         |                          |         |                 |       |           |                     |             |                 |         |Staff |        |      |          |Primary         |
    And I validate if "Person has been created." message is correct
    #to create an email
    And I navigate to email manager page
    And I click on create a new email button and select type "Marketing"
    When I update Email Start Tab "", "Email Actions test 6090", "", "", "tbaylis@windupradio.com"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "Fire Starter", "firestarter@fire-engine-red.com", "", "Subject Email Actions test 6090", "", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I update Email Content Tab "HTML body content Email Actions test 6090", ""
    And I click on save and continue on Marketing Email Composer
    And I click on save and continue on Marketing Email Composer
    And I validate if "Email has been updated." message is correct
    #to make sure action fields are empty first
    And I click on save and continue on Marketing Email Composer
    And I verify default action values index "0"
    #to add action category and action to see defaults in other fields
    And I update Email Finish Tab "Campus Events", "Admitted Student Day: Attend", "Fire Starter", "01/01/2016", ""
    And I verify default action values index "1"
    #to send the email
    And I send email
    And I confirm EmailSend
    Then I validate if "Email has been queued." message is correct
    #to wait until the email is sent
    And I navigate to email manager page
    When I wait until email sent "Email Actions test 6090"
    And I open email "Email Actions test 6090"
    #to verify email actions were recorded to the recipient records
    And I navigate to people on records
    And I open a people record by "Baylis"
    And I navigate to Actions
    And I search an action "Email Event"
    And I use datatable
      |Category     |Action     |Staff        |
      |Email Event  |Email Sent |Fire Starter |
    And I verify action Datatable values index "0", values "", "", "", "", ""
    And I open an action "Email Event"
    And I verify default action values index "0"
    And I verify current action date time
    Then I validate if element "clearChangesDisabledButton" is "visible" for email
    Then I validate if element "deleteActionDisabledButton" is "visible" for email
    Then I validate if element "saveChangesDisabledButton" is "visible" for email
    Then I validate if link text is correct "Campus Events: Admitted Student Day: Attend on 01/01/2016 by Fire Starter"

  @EmailSentSystemActionOrganizationScenarios @Done @Email
  Scenario: email actions are recorded for organizatons
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create an organization
      |Name	         |Role		             |Phone		     |PhoneType  |Address1	 |City	  |State   |PostalCode |Country		  |Staff |Category|Action|ActionType|ActionVisibility|
      |Illuminati HQ |Religious Institution  |201-793-5175   |Business   |205 West St|New York|New York|10282      |United States |Select|Select  |Select|Select    |Select          |
    And I validate if "Organization has been created." message is correct
    And I validate if "Illuminati HQ"summary opened properly
    And I navigate to contact
    And I click on create a new email on contact for organization "justyourimagination@orisit.com", "School", "", "Inquiry", "Subscribed", "", "", "" group "0"
    And I click on save changes in contact for organization
    And I close alert if return this message "Organization has been updated."
    #to create an email
    And I navigate to email manager page
    And I click on create a new email button and select type "Marketing"
    When I update Email Start Tab "", "User Email Actions Org test 6095", "", "", "justyourimagination@orisit.com"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "", "sender.email@fire-engine-red.com", "", "Subject Line test 6095", "", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I update Email Content Tab "Body Content test 6095. Testing that user email actions are recorded to organization records when the email is sent", ""
    And I click on save and continue on Marketing Email Composer
    And I click on save and continue on Marketing Email Composer
    And I validate if "Email has been updated." message is correct
    And I click on finish tab
    #verify the action fields are empty by default
    And I verify default action values index "0"
