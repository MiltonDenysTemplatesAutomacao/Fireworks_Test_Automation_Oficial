#Author: Milton Silva
#Regression testcase TL-314 (1 of 2): Display fields can be set and updated

@DisplayFields
Feature: Display Fields

  @DisplayFields
  Scenario: verify display only fields for a student can be set and updated
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName  |LastName   |EmailAddress           |EmailType  |EmailOptInMethod  |Role1   |StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm  |Active|Primary |IDType |IDNumber |WhoAddedID   |
      |Thomas     |Mifflin    |TMifflin@presidents.com|Personal   |Inquiry           |Person  |                     |                 |                 |           |      |        |Visa   |78752    |Fire Starter |
      |           |           |                       |           |                  |        |Accepted             |Accepted-Special |04/03/2017       |Fall 2017  |1     |1       |       |         |             |
      |           |           |                       |           |                  |        |Applicant            |Denied           |04/03/2018       |Fall 2018  |1     |1       |       |         |             |
    Then I validate if "Person has been created" message is correct
    #to add the Student Role so that the Student fields are available
    And I go to Home page
    When I quick search "FirstName"
    Then I validate if result for "FirstName" is correct
    And I open a record
    Then I verify Header Role "Person"
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
    And I click on student status
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



