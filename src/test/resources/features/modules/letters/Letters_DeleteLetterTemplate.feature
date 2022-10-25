#Author: Milton Silva
#Regression testcase TL-136: Letters Template: Delete

@LettersTemplateDelete
Feature: Letters Template: Delete

  @LettersTemplateDeleteScenario @Done @Letter
  Scenario: Letter Template - delete and reuse name
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
     #to create a letter template
    And I navigate to Letters Template Page
    And I click on create template button
    And I use datatable
      |TemplateName          |TemplateDescription  |RecordType|LetterFormat                      |LetterContent                         |
      |Delete Template test  |                     |Person    |Letter (8.5 x 11 no letterhead)   |Letter content Delete Template test   |
    When I update letter template person 0
    And I click on save template button
    Then I close alert if return this message "Letter Template has been created."
    #to delete the template
    And I navigate to Letters Template Page
    When I open template "Delete Template test"
    And I verify letter template 0
    And I delete letter template
    Then I close alert if return this message "Letter Template has been deleted."
    #to verify the template is not found in the manager table
    When I search template "Delete Template test"
    Then I verify if template "No search results to display." exists
    #to create a new template with the same name as the deleted template
    And I click on create template button
    When I update letter template person 0
    And I click on save template button
    Then I close alert if return this message "Letter Template has been created."