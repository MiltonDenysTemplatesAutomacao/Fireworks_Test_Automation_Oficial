#Author: Milton Silva
#Regression testcase TL-255:Financial Aid: Interests only


@FinancialAidInterestsOnly
Feature: Financial Aid Payment Only

  @FinancialAidInterestsOnlyScenario @Done @FinancialAid
  Scenario: Record - Financial Aid - verify financial aid interests can be added to a student record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName|LastName |EmailAddress         |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Irving   |Berlin   |IBerlin@music.com    |Personal   |Inquiry          |Student|Freshman   |Accepted             |Accepted         |08/25/201        |Fall 2017|
    And I validate if "Person has been created." message is correct
    #add Financial Aid Interests only
    And I navigate to people on records
    And I open a people record by "Irving"
    And I validate if "Irving"summary opened properly
    And I navigate to Financial Aid
    And I update Financial Aid Interest "Music", "Piano", "Yes", "09/26/2017" group "0"
    And I click save changes on financial aid
    And I close alert if return this message "Person has been updated."
    And I verify Financial Aid Interest "Music", "Piano", "Yes", "09/26/2017" group "0"
