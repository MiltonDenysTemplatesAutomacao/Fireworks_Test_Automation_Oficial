#Author: Milton Silva
#Regression testcase TL-717:Financial Aid: Components not required

@FinancialAidComponentsNotRequired
Feature: Financial Aid: Components not required

  @FinancialAidComponentsNotRequiredScenario @Done @FinancialAid
  Scenario: Record - Financial Aid - verify financial aid components are not required
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName|LastName |EmailAddress          |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Michael  |Kelso    |mkelso@wisconsin.com  |Personal   |Inquiry          |Student|Freshman   |Accepted             |Accepted         |06/20/2017       |Fall 2017|
    And I validate if "Person has been created." message is correct