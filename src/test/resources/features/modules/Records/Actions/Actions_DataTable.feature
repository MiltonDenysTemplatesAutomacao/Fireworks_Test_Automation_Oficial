#Author: Milton Silva
#Regression testcase TL-150: Create Letter from Template
#Regression testcase TL-109 (1 of 3): User-defined Letter Actions
#Regression testcase TL-805 (1 of 2): System Letter Actions
#Regression testcase TL-408 (1 of 2): Actions: Data Table

@DataTable
Feature: Actions Edit actions

  @DataTablePerson
  Scenario: Letter - create from template - system actions
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName     |Address1           |City       |State      |PostalCode|Country       |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Alfred     |Hitchcock    |10957 Bellagio Road|Los Angeles|California |90077     |United States |Student|Graduate   |Accepted             |Accepted         |01/15/2020       |Fall 2020|
    #And I validate if "Person has been created." message is correct
    #to create a letter template
    And I navigate to letters page
