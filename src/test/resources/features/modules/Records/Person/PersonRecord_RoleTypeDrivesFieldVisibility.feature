#Author: Milton Silva
#Regression testcase TL-35: Role Type drives panel and field visibility

@RoleTypeDrivesPanelAndFieldVisibility
Feature: Role Type drives panel and field visibility

  @VerifyBasicFieldsNonStudentRecord
  Scenario: to verify the Basic fields for a non-student record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |Firstname|Lastname	|EmailAddress		|EmailType		|EmailOptInMethod	|Role1	|BasicSection|BasicFieldLabel       |CheckboxLabel |
      |John		|Jacob		|jjacob@nursery.org	|Personal		|Inquiry			|Person	|Birth       |Birth Date            |Deceased      |
      |         |           |                   |               |                   |       |Culture     |Citizenship Type      |Veteran       |
      |         |           |                   |               |                   |       |Context     |Country of Citizenship|              |
      |         |           |                   |               |                   |       |            |Ethnicity             |              |
      |         |           |                   |               |                   |       |            |Race                  |              |
      |         |           |                   |               |                   |       |            |Gender                |              |
      |         |           |                   |               |                   |       |            |Marital Status        |              |
      |         |           |                   |               |                   |       |            |Primary Language      |              |
      |         |           |                   |               |                   |       |            |Religion              |              |
      |         |           |                   |               |                   |       |            |Time Zone             |              |
      |         |           |                   |               |                   |       |            |Class Of              |              |
      |         |           |                   |               |                   |       |            |Birth Country         |              |
      |         |           |                   |               |                   |       |            |Birth City            |              |
      |         |           |                   |               |                   |       |            |Birth State           |              |
      |         |           |                   |               |                   |       |            |Social Security Number|              |
      |         |           |                   |               |                   |       |            |High Score            |              |
      |         |           |                   |               |                   |       |            |Original Geomarket    |              |
      |         |           |                   |               |                   |       |            |Student Flag          |              |
      |         |           |                   |               |                   |       |            |International         |              |
      |         |           |                   |               |                   |       |            |Legacy                |              |
      |         |           |                   |               |                   |       |            |State Resident        |              |
    And I go to Home page
    When I quick search "Firstname"
    And I open a record
    And I navigate to basic
    Then I verify basic fields labels
    And I validate not displayed fields are correct

  @VerifyRecordPanelsNonStudentRecord
  Scenario: To verify the record panels for a non student record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |Firstname        |Lastname	|EmailAddress		|EmailType		|EmailOptInMethod	|Role1	|StudentType|StudentStatusCategory |StudentStatus |StudentStatusDate |EntryTerm|BasicSection|BasicFieldLabel       |CheckboxLabel |
      |Jingleheimer		|Smith		|jsmithn@rhyme.org	|Personal		|Inquiry			|Student|Freshman   |Accepted              |Accepted      |08/15/2016        |Fall 2017|Birth       |Birth Date            |Deceased      |
    And I go to Home page
    When I quick search "Firstname"
    Then I validate if result for "Firstname" is correct
    And I open a record
    When I verify Header Role
