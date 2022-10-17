#Author: Milton Silva
#Regression testcase TL-584: Report Composer Validation

@ReportComposerValidation
Feature: Ability to schedule text messages from Communications

  @ReportComposerValidationScenarios @Done @Report
  Scenario: Report - report required fields
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to reports page
    And I click on create report button
    When I click on run report button
    And I verify validation message "A Smart Search is required."
    And I verify validation message "A Report Template is required."
