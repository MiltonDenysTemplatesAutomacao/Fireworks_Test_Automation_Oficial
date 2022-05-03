#Author: Milton Silva
#Regresion testcase TL-1067: ID Types can be added to Staff

@IdTypes
Feature: Staff Record: ID Types

  @IdTypesScenarios
  Scenario: verify ID types required fields are correct and can be added to staff
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a staff
      |FirstName  |LastName	  |Fullname		        |EmailAddress           |AccountStartDate |PermissionGroup |IDType      |IDNumber |WhoAddedID   |IdRecordedDate |Comments                   |Primary|
      |Mayor      |McCheese   |Mayor McCheese      	|mmccheese@mcdonalds.com|09/10/2016       |Administrator   |Common App  |1067-1100|Fire Starter |09/10/2016     |ID comment on Staff record |1      |
    And I validate if "Staff member has been created." message is correct
    And I navigate to ID Types
    And I click on ID Types SaveChanges button
    Then I validate if "The Type field is required." required message is correct
    Then I validate if "The ID Number field is required." required message is correct
    Then I validate if "The Who Added ID field is required." required message is correct
    And I click on close button on modal
    And I update Id Types group "0" person 0
    And I click on ID Types SaveChanges button
    And I validate if "Staff member has been updated." message is correct
    And I validate Id Types group "0" person 0
