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
    And I validate if "Person has been created." message is correct
    #to add the 1st Financial Aid record with two Aid components
    And I navigate to people on records
    And I open a people record by "Vincent"
    And I validate if "Vincent"summary opened properly
    And I navigate to Financial Aid
    And I update Financial Aid "Scholarship", "Awarded", "Fall 2018", "07/07/2017", "9", "85" group "0"
    And I update Financial Aid Component "", "Yes", "08/01/2017", "Yes", "Aid Application1 Component1 comment" Financial "0" Aid "0"
    And I update Financial Aid Component "", "Yes", "08/02/2017", "Yes", "Aid Application1 Component2 comment" Financial "0" Aid "1"
    And I update Award Component "100", "Government Grant", "Pell Grant", "Aid Award Component1 comment" Financial "0" Award Component "0"
    And I click save changes on financial aid
    And I close alert if return this message "Person has been updated."
    #to add a second award component to financial aid 1
    And I add Award Component Financial "0" Award Component "0"
    And I update Award Component "246766.00", "Institutional", "Grant", "Aid Award Component2 comment" Financial "0" Award Component "1"
    And I click save changes on financial aid
    And I close alert if return this message "Person has been updated."
    #to add a 2nd Financial Aid record
    And I add Financial Aid "0"
    And I update Financial Aid "Need-Based", "Awarded", "Fall 2018", "08/07/2017", "9", "85" group "1"
    And I update Financial Aid Active "1"
    And I update Financial Aid Component "", "Yes", "08/07/2017", "Yes", "Aid Application2 Component1 comment" Financial "1" Aid "0"
    And I update Financial Aid Component "", "Yes", "08/08/2017", "Yes", "Aid Application2 Component2 comment" Financial "1" Aid "1"
    And I update Financial Aid Component "", "Yes", "08/09/2017", "Yes", "Aid Application2 Component3 comment" Financial "1" Aid "2"
    And I update Financial Aid Component "", "Yes", "08/10/2017", "Yes", "Aid Application2 Component4 comment" Financial "1" Aid "3"
    And I update Financial Aid Component "", "Yes", "08/11/2017", "Yes", "Aid Application2 Component5 comment" Financial "1" Aid "4"
    And I update Financial Aid Component "", "Yes", "08/12/2017", "Yes", "Aid Application2 Component6 comment" Financial "1" Aid "5"
    And I update Award Component "250", "Loans", "Perkins", "Aid Award Component comment" Financial "1" Award Component "0"
    And I update Financial Aid Interest "Athletic", "Soccer", "Yes", "07/01/2017" group "0"
    And I update FinancialAidPayment "08/10/2017 12:00 AM", "999.99", "Application", "Credit Card", "Fire Starter", "Aid Payment comment" group "0"
    And I click save changes on financial aid
    And I close alert if return this message "Person has been updated."
    #to verify the financial aid records were saved correctly
    And I verify financial Aid "Active" group "0" checkbox "1"
    And I verify financial Aid "Primary" group "0" checkbox "1"
    And I verify financial Aid "Active" group "1" checkbox "1"
    And I verify financial Aid "Primary" group "1" checkbox "0"
