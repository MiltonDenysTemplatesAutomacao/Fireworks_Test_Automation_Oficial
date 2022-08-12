#Author: Milton Silva
#Regression testcase TL-717:Financial Aid: Components not required
#TL-717: Financial Aid: Components not required
#FW-9803: Financial Aid Awards
#Regression testcase: Importing all fields for FinAid and FinAidInterest field groups

@FinancialAidComponentsNotRequired
Feature: Financial Aid: Components not required

  @FinancialAidComponentsNotRequiredScenario @Done @FinancialAid
  Scenario: Record - Financial Aid - verify financial aid components are not required
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName|LastName |EmailAddress          |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Michael  |Kelso    |mkelso@wisconsin.com  |Personal   |Inquiry          |Student|Freshman   |Accepted             |Accepted         |06/20/2017       |Fall 2017|
    And I validate if "Person has been created." message is correct
  #to add a financial aid record without entering component data
    And I navigate to people on records
    And I open a people record by "Michael"
    And I validate if "Michael"summary opened properly
    And I navigate to Financial Aid
    And I update Financial Aid "Scholarship", "Awarded", "Fall 2019", "10/31/2017", "7", "80" group "0"
    And I verify Financial Aid Component "Application", "No", "", "Yes", "" Financial "0" Aid "0"
    And I verify Financial Aid Component "Audition Tape", "No", "", "Yes", "" Financial "0" Aid "1"
    #change the Aid App Type to verify the components are updated accordingly
    And I update Financial Aid "Need-Based", "", "", "", "", "" group "0"
    And I verify Financial Aid Component "FAFSA", "No", "", "Yes", "" Financial "0" Aid "0"
    And I verify Financial Aid Component "CSS/PROFILE", "No", "", "Yes", "" Financial "0" Aid "1"
    And I verify Financial Aid Component "Parental Tax Forms", "No", "", "Yes", "" Financial "0" Aid "2"
    And I verify Financial Aid Component "Student Tax Forms", "No", "", "Yes", "" Financial "0" Aid "3"
    And I verify Financial Aid Component "Institutional Aid Form", "No", "", "Yes", "" Financial "0" Aid "4"
    And I verify Financial Aid Component "Financial Aid Transcript", "No", "", "Yes", "" Financial "0" Aid "5"
    And I click save changes on financial aid
    And I close alert if return this message "Person has been updated."
    And I verify financial Aid "Need-Based", "Awarded", "Fall 2019", "", "", "10/31/2017", "7", "80" group "0"
    And I verify Financial Aid Component "FAFSA", "No", "", "Yes", "" Financial "0" Aid "0"
    And I verify Financial Aid Component "CSS/PROFILE", "No", "", "Yes", "" Financial "0" Aid "1"
    And I verify Financial Aid Component "Parental Tax Forms", "No", "", "Yes", "" Financial "0" Aid "2"
    And I verify Financial Aid Component "Student Tax Forms", "No", "", "Yes", "" Financial "0" Aid "3"
    And I verify Financial Aid Component "Institutional Aid Form", "No", "", "Yes", "" Financial "0" Aid "4"
    And I verify Financial Aid Component "Financial Aid Transcript", "No", "", "Yes", "" Financial "0" Aid "5"

  @FinancialAidComponentsNotRequiredScenario2 @Done @FinancialAid
  Scenario: Record - Import - Financial Aid without components
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I navigate to ImportsPackagesPage
    And I create a package
    And I update PackageStartTab "FinancialAidPackage4", "", "FinancialAid0950.csv", "Student"
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
    And I add Optional Field Group "0" name "Financial Aid"
    And I map Financial Aid optional fields "ENTRY_TERM"
    And I map Financial Aid optional fields "APP_STATUS"
    And I map Financial Aid optional fields "APP_TYPE"
    And I map Financial Aid optional fields "RECVD_DATE"
    And I map Financial Aid optional fields "DESIRABILITY"
    And I map Financial Aid optional fields "NEED_SCORE"
    And I "Subfield Group" name "Financial Aid Award Components" group "0"
    And I map Financial Aid optional fields "AWARD_CAT"
    And I map Financial Aid optional fields "AWARD_TYPE"
    And I map Financial Aid optional fields "AWARD_AMT"
    And I map Financial Aid optional fields "AWARD_COMMENTS"
    And I "Field Group" name "Financial Aid Interests" group "0"
    And I map Financial Aid optional fields "INTEREST_CATEGORY"
    And I map Financial Aid optional fields "INTEREST_TYPE"
    And I map Financial Aid optional fields "Static Value"
    And I add conversion field "Static Value" value "Yes" group "0"
    And I map Financial Aid Interests optional fields "RECVD_DATE"
    And I click on "Save & Continue"
    And I update Package Actions "Campus Event", "Admitted Student Day: Attend", ""
    And I click on "Save & Continue"
    #to run the import
    And I click on "Make Ready & Run"
    And I update Run Tab Actions "", "", "", "", ""

