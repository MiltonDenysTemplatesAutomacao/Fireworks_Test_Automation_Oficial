#Author: Milton Silva
#Regression testcase TL-914: Student Status field group rules

@StudentStatus
Feature: Student Status

  @StudentStatusScenarios @Done @Person
  Scenario: Record - Person - to add a primary Student Status field group for a previous Entry Term
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName  |LastName |EmailAddress      |EmailType  |EmailOptInMethod  |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm  |Active|Primary|
      |Stephen    |Foster   |JFoster@music.com |Personal   |Inquiry           |Student|Freshman   |Inquiry              |Inquiry-Active   |03/11/2017       |Spring 2018|0     |0      |
      |           |         |                  |           |                  |       |           |Accepted             |Accepted-Special |04/03/2017       |Fall 2017  |1     |1      |
    Then I validate if "Person has been created" message is correct
    Then I validate if "Stephen"summary opened properly
    And I click on student status
    And I click on add student status "0"
    And I update student status group "1" person 1
    And I click on Save Changes button in Student Status
    #scenario: a validation message is returned that the most recent Student Status should be Primary
    Then I validate if "The most recent Student Status should be marked Primary" message is correct
    #scenario: to mark original Student Status as Primary and Save
    And I close alert if return this message "The most recent Student Status should be marked Primary"
    And I click on status primary checkbox "0"
    And I click on Save Changes button in Student Status
    #scenario: to mark latest Entry Term as Inactive and older Entry Term as Primary
    And I close alert if return this message "Person has been updated."
    And I click on status primary checkbox "1"
    And I click on status active checkbox "0"
    And I click on Save Changes button in Student Status
    And I close alert if return this message "Person has been updated."
    #scenario: to verify Student Status with older Entry Term is Active and Primary
    And I verify student status group "0" person 1
    #scenario: to verify Student Status with older Entry Term is Active and Primary
    And I verify student status group "1" person 0
