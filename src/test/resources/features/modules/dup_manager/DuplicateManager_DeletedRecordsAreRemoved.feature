#Author: Milton Silva
#Regression testcase TL-590: Duplicate Manager: Deleted Records are Removed

@DuplicateManagerDeletedRecordsAreRemoved
Feature: Non-Student: Resolution Rules for grouped data

  @DuplicateManagerDeletedRecordsAreRemovedScenarios @Done @DupManager
  Scenario: DupManager - verify deleting a duplicate removes other record from duplicate manager
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |Role1    |EmailAddress         |EmailType  |EmailOptInMethod|StudentType|StudentStatus|StudentStatusCategory|StudentStatusDate|EntryTerm|
      |Sugar      |Bear      |Student  |sugarbear@cereal.com |Personal   |Inquiry         |Freshman   |Accepted     |Accepted             |01/15/2017       |Fall 2017|
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName  |LastName  |Role1    |StudentType|StudentStatus|StudentStatusCategory|StudentStatusDate|EntryTerm|Phone        |PhoneType  |
      |Sugar      |Bear      |Student  |Freshman   |Accepted     |Accepted             |01/15/2017       |Fall 2017|303-404-2222 |Home       |
    And I validate if "Person has been created." message is correct
  #to add an email address that will cause a potential match
    And I navigate to people on records
    And I open a people record by "Bear"
    And I navigate to contact
    And I update email on contact for person "sugarbear@cereal.com", "Personal", "", "Inquiry", "", "", "", "" and group "0"
    And I click on save changes in contact for person
    And I close alert if return this message "A potential duplicate Student record was found while creating this record; it has been placed in the Duplicate Manager for review."
    #to ensure the record shows up on the duplicate page
    And I navigate to duplicates
    And I search "FirstName" on duplicate manager person 0
    And I verify if it is able to see "Bear"
    #to navigate back to the second record and delete it
    And I navigate to people on records
    And I open a people record by "Bear"
    And I validate if "Sugar Bear"summary opened properly
    When I delete a person
    And I close alert if return this message "Person has been deleted."
    #to ensure neither record shows up on the duplicate page
    And I navigate to duplicates
    And I search "LastName" on duplicate manager person 0
    And I verify if it is not able to see "Bear"
