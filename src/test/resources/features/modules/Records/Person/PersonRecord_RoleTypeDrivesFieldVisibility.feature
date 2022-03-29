#Author: Milton Silva
#Regression testcase TL-35: Role Type drives panel and field visibility

@RoleTypeDrivesPanelAndFieldVisibility
Feature: Role Type drives panel and field visibility

  @RoleAssignedToRecordDeterminesWhichFieldsAreAvailables
  Scenario: to verify the Basic fields for a non-student record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |Firstname|Lastname	|EmailAddress		|EmailType		|EmailOptInMethod	|Role1	|BasicSection|
      |John		|Jacob		|jjacob@nursery.org	|Personal		|Inquiry			|Person	|Birth       |
    And I go to Home page
    When I quick search "Firstname"
    And I open a record
    And I navigate to basic
    Then I verify basic fields labels