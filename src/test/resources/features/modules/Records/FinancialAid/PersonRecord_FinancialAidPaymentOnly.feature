#Author: Milton Silva
#Regression testcase TL-281: Financial Aid: Payment only
#TL-725: Import Application without components
#TL-281: Financial Aid: Payment only
#FW-9392: Import Assigned Counselor

@FinancialAidPaymentOnly
Feature: Financial Aid Payment Only

  @FinancialAidPaymentOnlyScenario @Done @FinancialAid
  Scenario: Record - Financial Aid - verify a financial aid payment can be added to a student record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName|LastName |EmailAddress         |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Don      |Henley   |desperado@music.com  |Personal   |College Fair     |Student|Freshman   |Accepted             |Accepted         |02/27/2018       |Fall 2018|
    And I validate if "Person has been created." message is correct
    And I navigate to people on records
    And I open a people record by "Don"
    And I validate if "Don"summary opened properly
    And I navigate to Financial Aid
    And I update FinancialAidPayment "08/10/2017 12:00 AM", "1000.00", "Application", "Credit Card", "Fire Starter", "Payment comment" group "0"
    And I click save changes on financial aid
    And I close alert if return this message "Person has been updated."
    And I verify FinancialAidPayment "08/10/2017 12:00 AM", "1000.00", "Application", "Credit Card", "Fire Starter", "Payment comment" group "0"

  @FinancialAidPaymentOnlyScenario2 @Done @FinancialAid
  Scenario: Record - Financial Aid - to add a staff to use as the counselor
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a staff
      |FirstName|LastName |FullName     |EmailAddress           |EmailType  |PermissionGroup |
      |Amy      |Santiago |Amy Santiago |santiago@nine-nine.net |Personal   |Administrator   |
    And I validate if "Staff member has been created. They have been sent a welcome email with a link prompting them to login and create a password. The link in this email will expire in 12 hours." message is correct
    #to create a Student package with a counselor and an application
    When I navigate to ImportsPackagesPage
    And I create a package
    And I update PackageStartTab "ApplicationPaymentCounselor", "", "ApplicationPaytCounselor0940.csv", "Student"
    And I click save and continue button "Start"
    #And I map required fields