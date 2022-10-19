#Author: Milton Silva
#Regression testcase TL-586 (2 of 4): Letters: Template: Create

@LettersTemplateCreate
Feature: Letters: Template: Create

  @LettersTemplateCreateScenario @Done @Letter
  Scenario: Org Letter Template - no labels
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to Letters Template Page
    And I click on create template button
    And I use datatable
  |TemplateName                 |TemplateDescription                          |RecordType   |LetterFormat               |LetterContent                                 |IncludeLetterCheckbox|
  |0760OrgTemplateWithoutLabels |Organization Letter Template without Labels  |Organization |5 x 7 postcard (landscape) |Template content 0760OrgTemplateWithoutLabels |                     |
    When I update letter template person 0
    And I update Letter Org Action "Organization", "Call Out", "", "", "Action comment 0760OrgTemplateWithoutLabels"
    And I click on save template button
    Then I close alert if return this message "Letter Template has been created."
    And I navigate to template tab
    When I open template "0760OrgTemplateWithoutLabels"
    And I verify letter template 0
    And I verify Letter Org Action "Organization", "Call Out", "", "", "Action comment 0760OrgTemplateWithoutLabels"

