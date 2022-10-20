#Author: Milton Silva
#Regression testcase TL-119: Template: Load Template

@TemplateLoadTemplate
Feature: Template: Load Template

  @TemplateLoadTemplateScenario @Done @Letter
  Scenario: Letter Template - create new from existing
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create a letter template
    And I navigate to Letters Template Page
    And I click on create template button
    And I use datatable
      |TemplateName       |TemplateDescription            |RecordType|LetterFormat                   |LetterContent                    |Category     |Action                        |Comments                         |
      |Base Template      |Description Base Template      |Person    |Letter (8.5 x 11 no letterhead)|Letter content Base Template     |Campus Events|Admitted Student Day: Attend  |Action comment Base Template     |
      |Overwrite Template |Description Overwrite Template |Person    |5 x 7 postcard (landscape)     |Letter content Overwrite Template|Campus Events|Admitted Student Day: Register|Action comment Overwrite Template|
    When I update letter template person 0
    And I update letter person action index 0
    And I click on save template button
    Then I close alert if return this message "Letter Template has been created."
    #to create a different letter template
    And I navigate to template tab
    And I click on create template button
    When I update letter template person 1
    And I update letter person action index 1
    And I click on save template button
    Then I close alert if return this message "Letter Template has been created."
    #to create a new template using load template
    And I navigate to template tab
    When I open template "Base Template"
    And I verify letter template 0
    And I verify letter person action "Campus Events", "Admitted Student Day: Attend", "", "", "", "" and "Action comment Base Template"
    #to load a different template and verify it overwrites the previous data
    And I navigate to template tab
    When I open template "Overwrite Template"
    And I verify letter template 1
    And I verify letter person action "Campus Events", "Admitted Student Day: Register", "", "", "", "" and "Action comment Overwrite Template"
    #to edit the new template and save


