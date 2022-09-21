#Author: Milton Silva
#Regression testcase TL-314 (1 of 2): Display fields can be set and updated

@DisplayFields
Feature: Display Fields

  @DisplayFieldsPerson @Done @SummaryHeader
  Scenario: Record - SummaryHeader - verify display only fields for a student can be set and updated
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName  |LastName   |EmailAddress           |EmailType  |EmailOptInMethod  |Role1   |StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm  |Active|Primary |IDType |IDNumber |WhoAddedID   |
      |Thomas     |Mifflin    |TMifflin@presidents.com|Personal   |Inquiry           |Person  |                     |                 |                 |           |      |        |Visa   |78752    |Fire Starter |
      |           |           |                       |           |                  |        |Accepted             |Accepted-Special |04/03/2017       |Fall 2017  |1     |1       |       |         |             |
      |           |           |                       |           |                  |        |Applicant            |Denied           |04/03/2018       |Fall 2018  |1     |1       |       |         |             |
    And I validate if "Person has been created" message is correct
    #to add the Student Role so that the Student fields are available
    And I verify Header Role "Person"
    And I update Header Role "Student"
    And I close alert if return this message "Person has been updated."
    And I go to Home page
    When I quick search "FirstName"
    And I open a record
    Then I verify Header Role "Multiple"
    And I verify Student Type "Student Type:"
    And I verify Header Assign Staff "None"
    And I validate Student Status label "Student Status: None"
    And I validate Entry Term label "Entry Term: None"
    #to add another Student Status
    When I click on student status
    And I update student status group "0" person 1
    And I click on Save Changes button in Student Status
    And I close alert if return this message "Person has been updated."
    And I validate Student Status label "Student Status: Accepted"
    And I validate Entry Term label "Entry Term: Fall 2017"
    And I click on add student status "0"
    And I update student status group "1" person 2
    And I click on Save Changes button in Student Status
    And I close alert if return this message "Person has been updated."
    And I validate Student Status label "Student Status: Denied"
    And I validate Entry Term label "Entry Term: Fall 2018"
    #to add a VISA ID and verify the VISA display field
    And I navigate to ID Types
    And I update External Id group "0" person 0
    And I click on external ID SaveChanges button
    And I close alert if return this message "Person has been updated."
    Then I validate if Visa number is correct

  @DisplayFieldsOrganization @Done @SummaryHeader
  Scenario: Record - SummaryHeader - verify display fields for an organization can be set and updated
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a staff
      |FirstName  |LastName	  |Fullname		|EmailAddress       |PermissionGroup|
      |Joan	      |Baez       |Joan Baez	|MBaez@music.net	|Administrator	|
    And I validate if "Staff member has been created. They have been sent a welcome email with a link prompting them to login and create a password. The link in this email will expire in 12 hours." message is correct
    And I close alert if return this message "Staff member has been created. They have been sent a welcome email with a link prompting them to login and create a password. The link in this email will expire in 12 hours."
    And I go to Home page
    When I create an organization
      |Name					   |Role	    |Address1		    |City	    |State	     |PostalCode |Country	    |IDType |IDNumber |WhoAddedID   |
      |Catchfire High School   |High School |144 Campfire Drive |Coachella  |California  |92236      |United States |CEEB   |91195    |Joan Baez    |
    And I validate if "Organization has been created." message is correct
    And I close alert if return this message "Organization has been created."
    And I verify the record header for organization "Catchfire High School", "OK to Contact: Yes", "Record Status: Active" and "Organization Category: School"
    #that no ID is set yet
    And I validate Org Id label "None"
    #to add an ID and see if display in the header
    And I navigate to ID Types
    And I update External Id group "0" person 0
    And I click on external ID SaveChanges button
    Then I validate if "Organization has been updated." message is correct
    And I close alert if return this message "Organization has been updated."
    And I verify the record header for organization "Catchfire High School", "OK to Contact: Yes", "Record Status: Active" and "Organization Category: School"
    And I validate Org Id label "91195"

