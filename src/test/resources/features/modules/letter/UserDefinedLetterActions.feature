#Author: Milton Silva
#Regression testcase TL-109 (2 of 3): User-defined Letter Actions

@UserDefinedLetterActions
Feature: User-defined Letter Actions

  @UserDefinedLetterActionsScenario @Fix @Letter
  Scenario: Person Letter - no actions
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName |LastName  |EmailAddress             |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate |EntryTerm|LetterName              |LetterFormat                   |LetterContent                        |SmartSearch            |
      |Martin    |Goldstein |mgoldstein@gangsters.com |Personal   |Student Search   |Student|Freshman   |Accepted             |Accepted         |01/15/2019        |Fall 2019|Create Person Letter1067|Letter (8.5 x 11 no letterhead)|Content for Create Person Letter1067 |CreateLetter1067 Search|
    And I validate if "Person has been created." message is correct
    And I navigate to smart search page
    And I click on create smart search button
    And I select "Last Name" search field group "0" condition "0" in smart search composer
    And I select "equals" operator field group "0" condition "0" in smart search composer
    And I fill "Goldstein" text group "0" condition "0"
    And I fill smart search name "CreateLetter1067 Search"
    And I click on save this search button
    And I close alert if return this message "Smart Search has been created."
    #to create a letter
    And I navigate to letters page
    And I click on create letter button
    And I verify Letter System Action "Letter Event" and "Letter Generated"
    And I update letter details person 0
    And I update letter content person 0
    And I update letter recipients person 0
    And I verify draft letter "Create Person Letter1067", "CreateLetter1067 Search", "Letter (8.5 x 11 no letterhead)" and "Content for Create Person Letter1067"
    And I click on create PDF
    And I verify recipients modal
    And I confirm recipients modal
    And I close alert if return this message "Letter creation queued!"
    #to open the completed letter
