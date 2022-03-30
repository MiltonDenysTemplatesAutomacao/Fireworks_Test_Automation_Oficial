#Author: Milton Silva
#Regression testcase TL-35: Role Type drives panel and field visibility

@RoleTypeDrivesPanelAndFieldVisibility
Feature: Role Type drives panel and field visibility

  @RoleAssignedToRecordDeterminesWhichFieldsAreAvailables
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