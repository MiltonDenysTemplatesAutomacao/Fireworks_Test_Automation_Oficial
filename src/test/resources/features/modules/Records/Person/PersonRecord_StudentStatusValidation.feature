#Author: Milton Silva
#Regression testcase TL-1056: Student Status: Required Fields

@StudentStatusRequiredFields
Feature: Student Status: Required Fields

  @StudentStatusFieldRequiredValidations @Done
  Scenario: Record - Person - student status required fields
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create a person record so that Student Status will be empty
    And I create a person
      |FirstName  |LastName   |EmailAddress                      |EmailType  |EmailOptInMethod  |Role1          |StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|Active|Primary|
      |David      |Tennant    |PresidentOfTheEarth@doctorwho.net |Business   |Inquiry           |Trustee/Regent |                     |                 |                 |         |      |       |
      |           |           |                                  |           |                  |               |Deposited            |                 |                 |         |      |       |
      |           |           |                                  |           |                  |               |                     |Active-Deposited |                 |         |      |       |
      |           |           |                                  |           |                  |               |                     |                 |08/18/2018       |         |      |       |
      |           |           |                                  |           |                  |               |                     |                 |                 |Fall 2019|      |       |
      |           |           |                                  |           |                  |               |Deposited            |Active-Deposited |08/18/2018       |Fall 2019|1     |1      |
    Then I validate if "Person has been created" message is correct
    #to add the Student Role so that the Student fields are available
    Given I go to Home page
    And I quick search "FirstName"
    And I validate if "David"summary opened properly
    When I open a record
    And I verify Header Role "Trustee/Regent"
    And I update Header Role "Student"
    Then I close alert if return this message "Person has been updated."
    #clicking Save on the empty Student Status tab will return expected required field validation
    Given I click on student status
    When I click on Save Changes button in Student Status
    Then I validate if "The Student Status Category field is required." message required for person record is correct
    And I validate if "The Student Status field is required." message required for person record is correct
    And I validate if "The Student Status Date field is required." message required for person record is correct
    And I validate if "The Entry Term field is required." message required for person record is correct
    And I click on close button on modal
    #if I enter data for one field the remaining empty fields are validated
    And I update student status group "0" person 1
    When I click on Save Changes button in Student Status
    And I validate if "The Student Status field is required." message required for person record is correct
    And I validate if "The Student Status Date field is required." message required for person record is correct
    And I validate if "The Entry Term field is required." message required for person record is correct
    And I click on close button on modal
    And I update student status group "0" person 2
    When I click on Save Changes button in Student Status
    And I validate if "The Student Status Date field is required." message required for person record is correct
    And I validate if "The Entry Term field is required." message required for person record is correct
    And I click on close button on modal
    And I update student status group "0" person 3
    When I click on Save Changes button in Student Status
    And I validate if "The Entry Term field is required." message required for person record is correct
    And I click on close button on modal
    And I update student status group "0" person 4
    When I click on Save Changes button in Student Status
    And I close alert if return this message "Person has been updated."
    #to verify the student status data
    Then I verify student status group "0" person 5
