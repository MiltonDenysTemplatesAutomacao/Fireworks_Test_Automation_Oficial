#Author: Milton Silva
#Regression testcase TL-445:Financial Aid: Composite keys

@FinancialAidCompositeKeys
Feature: Financial Aid Payment Only

  @FinancialAidCompositeKeysScenario @Done @FinancialAid
  Scenario: Record - Financial Aid - verify duplicate financial aid records cannot be added to a student record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName |LastName |EmailAddress             |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate |EntryTerm|
      |Vincent   |VanGogh  |vincentvanGogh@music.com |Personal   |Inquiry          |Student|Freshman   |Accepted             |Accepted         |07/08/2017        |Fall 2019|
    #And I validate if "Person has been created." message is correct
    And I navigate to people on records
    And I open a people record by "Vincent"
    And I validate if "Vincent"summary opened properly
    And I navigate to Financial Aid
    And I update Financial Aid "Scholarship", "Awarded", "Fall 2019", "07/08/2017", "", "" group "0"
    And I click save changes on financial aid
    And I close alert if return this message "Person has been updated"
    And I add Financial Aid "0"
    And I update Financial Aid "Scholarship", "Awarded", "Fall 2019", "07/08/2017", "", "" group "1"
    And I click save changes on financial aid
    And I verify validation message "Date Received must be different."
    And I verify validation message "Aid Term must be different."
    And I verify validation message "Aid Application Type must be different."
    And I click on close button on modal
    And I click on clear changes


