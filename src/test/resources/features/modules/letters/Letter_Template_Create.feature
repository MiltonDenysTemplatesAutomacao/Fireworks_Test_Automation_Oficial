#Author: Milton Silva
#Regression testcase TL-586 (1 of 4): Letters: Template: Create
#Regression testcase TL-586 (2 of 4): Letters: Template: Create
#Regression testcase TL-586 (3 of 4): Letters: Template: Create

@LettersTemplateCreate
Feature: Letters: Template: Create

  @LettersTemplateCreateNoLabelsScenario @Done @Letter
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

  @LettersTemplateCreateWithLabelsScenario @Done @Letter
  Scenario: Org Letter Template - with labels
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to Letters Template Page
    And I click on create template button
    And I use datatable
      |TemplateName                 |TemplateDescription                       |RecordType   |LetterFormat               |LetterContent                              |
      |0770OrgTemplateWithLabels    |Organization Letter Template with Labels  |Organization |5 x 7 postcard (landscape) |Template content 0770OrgTemplateWithLabels |
    When I update letter template person 0
    And I include label
    And I update labels "File Folder Label (5066)", "0770 Label content"
    And I update Letter Org Action "Organization", "Call Out", "", "", "Action comment 0770OrgTemplateWithLabels"
    And I click on save template button
    Then I close alert if return this message "Letter Template has been created."
    And I navigate to template tab
    When I open template "0770OrgTemplateWithLabels"
    And I verify letter template 0
    And I verify labels "File Folder Label (5066)", "0770 Label content"
    And I verify Letter Org Action "Organization", "Call Out", "", "", "Action comment 0770OrgTemplateWithLabels"

  @PersonLetterTemplateWithLabels @Done @Letter
  Scenario: Person Letter Template - with labels
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to Letters Template Page
    And I click on create template button
    And I use datatable
      |TemplateName                 |TemplateDescription                 |RecordType |LetterFormat                    |LetterContent                                  |Category      |Action                      |Comments                                   |
      |0790PersonTemplateWithLabels |Person Letter Template with Labels  |Person     |Letter (8.5 x 11 no letterhead) |Letter content 0790PersonTemplateWithLabels    |Campus Events |Admitted Student Day: Attend|Action comment 0790PersonTemplateWithLabels|
    When I update letter template person 0
    And I include label
    And I update labels "Mailing Label", "0790 Label content"
    And I update letter person action index 0
    And I click on save template button
    Then I close alert if return this message "Letter Template has been created."
    And I navigate to template tab
    When I open template "0790PersonTemplateWithLabels"
    And I verify letter template 0
    And I verify labels "Mailing Label", "0790 Label content"
    And I verify letter person action "Campus Events", "Admitted Student Day: Attend", "", "", "", "" and "Action comment 0790PersonTemplateWithLabels"
