#Author: Milton Silva
#Regression testcase TL-361:Financial Aid: Multiple records can be added


@FinancialAidMultipleRecordsCanBeAdded
Feature: Financial Aid Multiple records can be added

  @FinancialAidMultipleRecordsCanBeAddedScenario @Done @FinancialAid
  Scenario: Record - Financial Aid - verify two financial aid records can be added to a student record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName|LastName |EmailAddress        |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Vincent  |Youmans  |VYoumans@music.com  |Personal   |College Fair     |Student|Freshman   |Accepted             |Accepted         |01/25/2016       |Fall 2017|
    #And I validate if "Person has been created." message is correct
    #to add the 1st Financial Aid record with two Aid components
    And I navigate to people on records
    And I open a people record by "Vincent"
    And I validate if "Vincent"summary opened properly
    And I navigate to Financial Aid
    And I update Financial Aid "Scholarship", "Awarded", "Fall 2018", "07/07/2017", "9", "85" group "0"
    And I update Financial Aid Component "", "Yes", "08/01/2017", "Yes", "Aid Application1 Component1 comment" Financial "0" Aid "0"
    And I update Financial Aid Component "", "Yes", "08/02/2017", "Yes", "Aid Application1 Component2 comment" Financial "0" Aid "1"

    #And I click save changes on financial aid