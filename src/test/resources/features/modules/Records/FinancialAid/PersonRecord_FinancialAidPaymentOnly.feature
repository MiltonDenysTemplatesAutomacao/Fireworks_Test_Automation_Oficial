#Author: Milton Silva
#Regression testcase TL-281: Financial Aid: Payment only

@FinancialAidPaymentOnly
Feature: Update to Valid changes Active Primary flags

  @FinancialAidPaymentOnlyScenario @Done @Contact
  Scenario: Record Person - Contact - verify a financial aid payment can be added to a student record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName|LastName |EmailAddress         |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Don      |Henley   |desperado@music.com  |Personal   |College Fair     |Student|Freshman   |Accepted             |Accepted         |02/27/2018       |Fall 2018|
    #And I validate if "Person has been created." message is correct
    And I navigate to people on records
    And I open a people record by "Don"
    And I validate if "Don"summary opened properly
    And I navigate to Financial Aid