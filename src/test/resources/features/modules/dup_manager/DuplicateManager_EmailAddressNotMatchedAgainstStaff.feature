#Author: Milton Silva
#Regression testcase TL-232: Comparison to Staff Records

@ComparisonToStaffRecords
Feature: Comparison to Staff Records

  @ComparisonToStaffRecordsScenarios @Done @DupManager
  Scenario: Record - DupManager - verify student and person email addresses are not validated as duplicates against staff
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to add a person record
    When I create a staff
      |FirstName  |LastName |EmailAddress           |EmailType|PermissionGroup|
      |Mikio      |Naruse   |MNaruse@directors.net  |Personal |Administrator  |
    And I validate if "Staff member has been created. They have been sent a welcome email with a link prompting them to login and create a password. The link in this email will expire in 12 hours." message is correct
    #to add a Student with an email that matches a staff record
    When I create a person
      |FirstName  |LastName |Role1    |StudentType|StudentStatus |StudentStatusCategory |StudentStatusDate|EntryTerm|EmailAddress          |EmailType|EmailOptInMethod|
      |Nikio      |Maruse   |Student  |Freshman   |Rejected      |Applicant             |03/31/2020       |Fall 2020|MNaruse@directors.net |Personal |Inquiry         |
    And I validate if "Person has been created." message is correct
    #to see the Student record which means we are not redirected to Duplicate Manager
    And I validate if "Nikio Maruse"summary opened properly
    Then I verify Header Role "Student"
    When I create a person
      |FirstName  |LastName |Role1   |Phone        |PhoneType |
      |Nasahiro   |Thinoda  |Person  |482-372-3592 |Fax       |
    And I validate if "Person has been created." message is correct
    #to add an email that matches a staff record
    And I validate if "Nasahiro Thinoda"summary opened properly
    And I navigate to contact
    And I update email on contact for person "MNaruse@directors.net", "Personal", "", "Student Search", "", "", "", "" and group "0"
    And I click on save changes in contact for person
    #to see Person record is updated which means we are not redirected to Duplicate Manager
    And I validate if "Person has been updated." message is correct