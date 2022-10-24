#Author: Milton Silva
#Regression testcase TL-133: Template: Copy Template

@TemplateCopyTemplate
Feature: Template: Copy Template

  @TemplateCopyTemplateScenario @Done @Letter
  Scenario: Letter Template - copy and edit
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create a letter template
    And I navigate to Letters Template Page
    And I click on create template button
    And I use datatable
      |TemplateName                |TemplateDescription             |RecordType|LetterFormat                      |LetterContent                             |Category     |Action                          |Comments                          |
      |Copy Template test          |Description Copy Template test  |Person    |Letter (8.5 x 11 no letterhead)   |Letter content Copy Template test         |Campus Events|Admitted Student Day: Register  |Action comment Copy Template test |
      |Copy of Copy Template test  |Description Copy Template test  |Person    |Letter (8.5 x 11 no letterhead)   |Letter content Copy Template test         |Campus Events|Admitted Student Day: Register  |Action comment Copy Template test |
      |Copied Template             |Description Copy Template test  |Person    |Letter (8.5 x 11 with letterhead) |Edited Letter content Copy Template test  |             |                                |                                  |
    When I update letter template person 0
    And I update letter person action index 0
    And I click on save template button
    Then I close alert if return this message "Letter Template has been created."
    And I verify letter template 0
    And I verify letter person action "Campus Events", "Admitted Student Day: Register", "", "", "", "" and "Action comment Copy Template test"
    #to copy a letter template
    And I click on Copy Template button
    Then I close alert if return this message "Letter Template has been copied."
    And I verify letter template 1
    And I verify letter person action "Campus Events", "Admitted Student Day: Register", "", "", "", "" and "Action comment Copy Template test"
    #to edit the copied template
    When I update letter template person 2
    And I click on save template button
    Then I close alert if return this message "Letter Template has been updated."
    And I navigate to template tab
    When I open template "Copied Template"
    And I verify letter template 2
    And I verify letter person action "Campus Events", "Admitted Student Day: Register", "", "", "", "" and "Action comment Copy Template test"