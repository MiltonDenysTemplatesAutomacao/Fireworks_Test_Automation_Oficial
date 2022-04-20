#Author: Milton Silva
#Regression testcase TL-1056: Student Status: Required Fields

@StudentStatusRequiredFields
Feature: Student Status: Required Fields

  @AddPrimaryStudentStatusField
  Scenario: student status required fields
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create a person record so that Student Status will be empty
    And I create a person
      |Firstname  |Lastname   |EmailAddress                      |EmailType  |EmailOptInMethod  |Role1          |
      |David      |Tennant    |PresidentOfTheEarth@doctorwho.net |Business   |Inquiry           |Trustee/Regent |
    #Then I validate if "Person has been created" message is correct
    #to add the Student Role so that the Student fields are available
    And I go to Home page
    And I quick search "Firstname"
    And I validate if "Firstname"summary opened properly
    And I open a record
    And I verify Header Role "Trustee/Regent"
    And I update Header Role "Student"
    Then I validate if "Person has been updated." message is correct