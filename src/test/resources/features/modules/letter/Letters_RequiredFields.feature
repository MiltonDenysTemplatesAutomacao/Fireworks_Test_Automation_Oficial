#Author: Milton Silva
#Regression testcase TL-159: Create PDF: Required Fields

@CreatePDFRequiredFields
Feature: Letter - required fields

  @CreatePDFRequiredFieldsScenario @Done @Letter
  Scenario: Report - report required fields
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to letters page
    And I click on create letter button
    And I click on create PDF
    #to verify the validation messages returned
    And I verify validation message "The Name field is required."
    And I verify validation message "At least one recipient is required."
    And I verify validation message "The Format field is required."
    And I verify validation message "The Body field is required."
    And I click on close button on modal
    #to try to create the pdf with only name and format
    And I use datatable
    |LetterName           |LetterFormat                   |
    |Letter Name Required |Letter (8.5 x 11 no letterhead)|
    And I update letter details person 0
    And I update letter content person 0
    And I click on create PDF
    And I verify validation message "At least one recipient is required."
    And I verify validation message "The Body field is required."
    And I click on close button on modal
