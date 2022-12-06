#Author: Milton Silva
#Regression testcase TL-932: Sending Emails to Relationships

@SendingEmailsToRelationships
Feature: Sending Emails to Relationships

  @SendingEmailsToRelationshipsScenarios @Done @Email
  Scenario: verify emails sent to relationships contain merge data from the related record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to Email settings page
    And I use datatable
      |OrganizationName|OrganizationEmail                |ReplyToEmail                      |PhoneNumberEmail|Address1Email  |City   |State/Province|PostalCode|
      |Fire Engine Red |sender.email@fire-engine-red.com |replyto.email@fire-engine-red.com |1-800-555-1212  |1100 E 6th Ave |Aurora |Colorado      |80010     |
    And I update CAM-SPAM index 0
    And I click on "Save Profile"
    #create the student record
    When I create a person
      |FirstName  |LastName |EmailAddress               |EmailType|EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|
      |Julian     |Petruzzi |JulianPetruzzi@actors.com  |Personal |Student Search   |Student|Freshman   |Accepted             |Accepted     |08/15/2018       |Fall 2019|
    And I validate if "Person has been created." message is correct
    And I validate if "Julian Petruzzi"summary opened properly
    And I navigate to basic
    And I update birth values "07/27/2001", "", "", ""
    And I click on save changes on basic
    And I close alert if return this message "Person has been updated."
    #create the parent record
    When I create a person
      |FirstName  |LastName |EmailAddress              |EmailType|EmailOptInMethod |Role1          |
      |William    |Remick   |WilliamRemick@actors.com  |Personal |Application      |Parent/Guardian|
    And I validate if "Person has been created." message is correct
    And I validate if "William Remick"summary opened properly
    And I navigate to basic
    And I update birth values "06/24/1977", "", "", ""
    And I click on save changes on basic
    And I close alert if return this message "Person has been updated."
    #create the parent relationship to the student record
    And I navigate to Relationship
    When I create a relationship
    And I open a record picker "Julian"
    And I update relationship "Daughter", "", ""
    And I click on save changes on Relationships
    And I close alert if return this message "Relationship has been created"
    #to create a smart search for the student
    And I navigate to smart search page
    And I click on create smart search button
    And I select "Last Name" search field group "0" condition "0" in smart search composer
    And I select "equals" operator field group "0" condition "0" in smart search composer
    And I fill "Petruzzi" text group "0" condition "0"
    And I fill smart search name "Search 6270 Student record"
    And I click on save this search button
    And I close alert if return this message "Smart Search has been created."
    #to create an email that will be sent to the father
    And I navigate to email manager page
    And I click on create a new email button and select type "Marketing"
    When I update Email Start Tab "", "Email to Relationships 6270", "Description Email to Relationships 6270", "Search 6270 Student record", ""
    And I send to relationship "Father"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "Fire Starter", "firestarter@fire-engine-red.com", "", "Subject Line for [[NAME_FIRST]] [[NAME_LAST]]", "Preheader 6140 Birth Merge Tag test 6140", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I update Email Content Tab "Parent data: [[NAME_FIRST]] [[NAME_LAST]]  Role: [[PERSON_ROLE]]  Email: [[EMAIL_ADDRESS]]  Birth date: [[BIRTH_DATE]].", "Parent data: [[NAME_FIRST]] [[NAME_LAST]]  Role: [[PERSON_ROLE]]  Email: [[EMAIL_ADDRESS]]  Birth date: [[BIRTH_DATE]]."
    And I click on save and continue on Marketing Email Composer
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #to send the email
    And I click on finish tab
    #\\\TODO\\\ fix action date time to get actual time
    And I update Email Finish Tab "Campus Events", "Admitted Student Day: Register", "Fire Starter", "12/06/2022", "Test 6270 action comment"
    And I send email
    And I verify RecipientsPreview "William", "Remick", "WilliamRemick@actors.com", "", "1"
    And I confirm EmailSend "Person"
    Then I validate if "Email has been queued." message is correct
    #to wait until the email is sent
    And I navigate to email manager page
    When I wait until email sent "Email to Relationships 6270"
    #verify email is received with the expected relationship data
    When I verify if email was sent correctly "Subject Line for William Remick", "firestarter@fire-engine-red.com", "Fire Starter", "William Remick"
    And I verify email content on mail trap is "visible" for subject "Subject Line for William Remick", "William Remick", ""
    And I verify email content on mail trap is "visible" for subject "Subject Line for William Remick", "WilliamRemick@actors.com", ""
    And I verify email content on mail trap is "visible" for subject "Subject Line for William Remick", "Parent/Guardian", ""
    And I verify email content on mail trap is "visible" for subject "Subject Line for William Remick", "June 24, 1977", ""
    And I verify email content on mail trap is "visible" for subject "Subject Line for William Remick", "Application", ""
    #the email action to be posted to the student
    And I navigate to people on records
    And I open a people record by "Petruzzi"
    And I validate if "Julian Petruzzi"summary opened properly
    And I navigate to Actions
    And I use datatable
      |Category     |Action     |Staff        |Comments                 |
      |Email Event  |Email Sent |Fire Starter |Test 6270 action comment |
    And I verify action Datatable values index "0", values "", "", "", "", ""
    And I verify current action date time on datatable
    #the email actions NOT to be posted to the father


