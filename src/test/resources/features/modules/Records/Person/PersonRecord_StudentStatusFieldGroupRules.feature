#Author: Milton Silva
#Regression testcase TL-914: Student Status field group rules

@StudentStatus
Feature: Student Status

  @AddPrimaryStudentStatusField
  Scenario: to add a primary Student Status field group for a previous Entry Term
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |Firstname  |Lastname |EmailAddress      |EmailType  |EmailOptInMethod  |Role1  |StudentType|StudentStatusCategory|StudentStatus  |StudentStatusDate|EntryTerm  |Category|Status          |StatusDate|Active|Primary|
      |Stephen    |Foster   |JFoster@music.com |Personal   |Inquiry           |Student|Freshman   |Inquiry              |Inquiry-Active |03/11/2017       |Spring 2018|        |                |          |      |       |
      |           |         |                  |           |                  |       |           |                     |               |                 |Fall 2017  |Accepted|Accepted-Special|04/03/2017|1     |1      |
      #Then I validate if "Person has been created" message is correct
    And I go to Home page
    When I quick search "Firstname"
    Then I validate if "Firstname"summary opened properly
    And I open a record
    And I click on student status
    And I click on add student status "0"
    And I update student status "1"
