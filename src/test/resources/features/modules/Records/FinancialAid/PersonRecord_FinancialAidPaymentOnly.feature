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
    And I map required fields "STUDENT_TYPE"
    And I map required fields "STUDENT_CATEGORY"
    And I map required fields "STUDENT_STATUS"
    And I map required fields "ENTRY_TERM"
    And I map required fields "STATUS_DATE"
    And I map required fields "ROLE"
    And I map required fields "FIRST_NAME"
    And I map required fields "LAST_NAME"
    And I map required fields "EMAIL_ADDRESS"
    And I map required fields "EMAIL_TYPE"
    And I map required fields "OPTIN"
    And I click save and continue button "Required"
    And I add Optional Field Group "0" name "Application"
    And I map Application optional fields "ENTRY_TERM"
    And I map Application optional fields "APP_SOURCE"
    And I map Application optional fields "APP_TYPE"
    And I map Application optional fields "COMPLETE_DATE"
    And I map Application optional fields "HOUSING"
    And I map Application optional fields "APP_COMMENTS"
    And I map Application optional fields "MAJOR1"
    And I map Application optional fields "CONCENTRATION"
    And I map Application optional fields "COMP_STATUS"
    And I map Application optional fields "RECVD_DATE"
    And I map Application optional fields "APPLIED_GRADE"
    And I map Application optional fields "MAJOR2"
    And I map Application optional fields "MAJOR3"
    And I map Application optional fields "MINOR"
    And I map Application optional fields "DEGREE"
    And I add "Subfield Group" name "Application Review" group "0" for "Application" Field Group
    And I map Application optional fields "REVIWED_FOR"
    And I map Application optional fields "RATING"
    And I map Application optional fields "REVIEWED_BY"
    And I map Application optional fields "REVIEW_COMMENTS"
    And I map Application optional fields "REVIEW_DATE"
    And I add "Add Field Group"
    And I add Optional Field Group "1" name "Payment"
    And I map Payment optional fields "PAYT_TYPE"
    And I map Payment optional fields "PAYT_AMOUNT"
    And I map Payment optional fields "RECVD_DATE"
    And I map Payment optional fields "PAYT_WHO"
    And I map Payment optional fields "PAYT_PURPOSE"
    And I map Payment optional fields "PAYT_COMMENT"
    And I add "Add Field Group"
    And I add Optional Field Group "2" name "Counselor"
    And I map Counselor optional fields "COUNSELOR"
    And I map Counselor optional fields "Date of Import"
    And I click on "Save & Continue"
    And I update Package Actions "Campus Event", "Admitted Student Day: Attend", ""
    And I click on "Save & Continue"
    #to run the import
    And I click on "Make Ready & Run"
    And I update Run Tab Actions "", "", "Fire Starter", "", ""
    And I click on "Review Import"
    And I click on Run Import button
    Then I validate if "Completed" status is displayed for package "FinancialAidPackage"
  @FinancialAidPaymentOnlyScenario3 @Done @FinancialAid
  Scenario: Record - Financial Aid - The application components were pre-populated with expected defaults
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName   |EmailAddress                      |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Valerie    |Bertinelli |valeriebertinelli@wisconsin.com   |Personal   |Inquiry          |Student|Freshman   |Accepted             |Accepted         |06/20/2017       |Fall 2017|
    And I validate if "Person has been created." message is correct
    And I navigate to people on records
    And I open a people record by "Valerie"
    And I validate if "Amy"summary opened properly
    And I navigate to Financial Aid
    And I verify application "Fall 2020", "Accounting", "Completed", "Regular Decision", "Paper", "10/06/2020 12:00 PM", "Agriculture", "", "11", "", "Commuter", "Agriculture", "10/08/2020 9:00 AM", "application notes" group "0"
    And I verify application "Fall 2019", "Accounting", "In Progress", "Early Action", "Universal Application", "06/22/2018 7:30 PM", "", "", "", "", "", "", "", "" group "0"
    And I verify application component "Application Form", "No", "", "Yes", "", "" component "0" group "0"
    And I verify application component "Essay", "No", "", "Yes", "", "" component "1" group "0"
    And I verify application component "Personal Statement", "No", "", "Yes", "", "" component "2" group "0"
    And I verify application component "Recommendation", "No", "", "Yes", "", "" component "3" group "0"
    And I verify application component "Resume", "No", "", "Yes", "", "" component "4" group "0"
    And I verify application component "Supplemental Form", "No", "", "Yes", "", "" component "5" group "0"
    And I verify application component "Test Score", "Yes", "1", "Yes", "", "" component "6" group "0"
    And I verify application component "Transcript", "Yes", "1", "Yes", "", "" component "7" group "0"
    And I verify application review "Academic Performance", "4", "Amy Santiago", "1", "Review complete" application "0" review "0"
    And I navigate to Financial Aid
    And I verify FinancialAidPayment "10/06/2020 12:00 PM", "126.48", "Application", "Credit Card", "Amy Santiago", "Payment comment" group "0"






