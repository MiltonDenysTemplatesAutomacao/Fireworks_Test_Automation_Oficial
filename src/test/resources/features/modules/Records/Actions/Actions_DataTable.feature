#Author: Milton Silva
#Regression testcase TL-150: Create Letter from Template
#Regression testcase TL-109 (1 of 3): User-defined Letter Actions
#Regression testcase TL-805 (1 of 2): System Letter Actions
#Regression testcase TL-408 (1 of 2): Actions: Data Table

@DataTable
Feature: Actions Edit actions

  @DataTablePerson
  Scenario: Letter - create from template - system actions
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName     |Address1           |City       |State      |PostalCode|Country       |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|TemplateName             |TemplateDescription                  |RecordType|LetterName              |LetterFormat                   |LetterContent                        |Category       |Action                       |Comments                                 |SmartSearch|SingleRecipient  |Staff        |ActionDateTime|
      |Alfred     |Hitchcock    |10957 Bellagio Road|Los Angeles|California |90077     |United States |Student|Graduate   |Accepted             |Accepted         |01/15/2020       |Fall 2020|Template Actions Test1065|Letter Template description test 1065|Person    |Letter from Template1065|Letter (8.5 x 11 no letterhead)|Content for Letter from Template1065 |Campus Events  |Admitted Student Day: Attend |Template comment Letter from Template1065|           |Alfred Hitchcock |             |              |
      |           |             |                   |           |           |          |              |       |           |                     |                 |                 |         |                         |                                     |          |                        |                               |                                     |               |                             |                                         |           |                 |Fire Starter |07/20/2018    |
    And I validate if "Person has been created." message is correct
    #to create a letter template
    And I navigate to letters page
    And I navigate to template tab
    And I click on create template button
    When I update letter template person 0
    And I update letter person action index 0
    And I click on save template button
    Then I close alert if return this message "Letter Template has been created."
    #to create a letter using the template
    And I navigate to letters page
    And I click on create letter button
    And I load Template "Template Actions Test1065"
    And I verify draft letter "", "Select Smart Search", "Letter (8.5 x 11 no letterhead)" and "Content for Letter from Template1065"
    And I verify letter person action "Campus Events", "Admitted Student Day: Attend", "", "", "Select", "" and "Template comment Letter from Template1065"
    And I update letter details person 0
    And I update letter recipients person 0
    And I update letter person action index 1
    And I verify Letter System Action "Letter Event" and "Letter Generated"
    And I click on create PDF
    And I verify recipients modal
    And I confirm recipients modal
    And I validate if "Letter creation queued!" message is correct
    #to verify the letter was created



