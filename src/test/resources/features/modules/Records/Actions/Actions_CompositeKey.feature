#Author: Milton Silva
#Regression testcase TL-620 (1 of 2): Actions: Duplicates cannot be added
#Regression testcase TL-620 (2 of 2): Actions: Duplicates cannot be added


@ActionsDuplicatesCannotBeAdded
Feature: Actions: Duplicates cannot be added

  @ActionsDuplicatesCannotBeAddedPerson
  Scenario: Record - Actions - verify duplicate actions can not be added to a person record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName    |LastName     |EmailAddress              |EmailType|EmailOptInMethod |Role1 |Category     |Action                         |Staff        |ActionDateTime     |ActionDateField|
      |Waldemar     |Cierpinski   |waldemarcirpl@yahoo.com   |Personal |Inquiry          |Person|Campus Events|Admitted Student Day: Register |Fire Starter |11/30/2017 8:00 AM |11/30/2017     |
    And I validate if "Person has been created." message is correct
    And I validate if "Waldemar"summary opened properly
    And I navigate to Actions
    And I click on add action button
    And I update action person "0"
    Then I click on Save Changes button in Actions
    And I validate if "Action has been created." message is correct
    And I click on add action button
    And I update action person "0"
    Then I click on Save Changes button in Actions
    And I validate if "Duplicate actions with an identical time and date cannot be saved. Please try again." message is correct
    And I click on clear changes on actions for "Person"

  @ActionsDuplicatesCannotBeAddedOrganization
  Scenario: Record - Actions - verify duplicate actions can not be added to an organization record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name					                 |Role        |Address1		            |City	       |State	     |PostalCode |Country	     |Category     |Action  |Staff         |ActionDateTime     |ActionDateField|
      |HowGreenWasMyValley Data Systems      |Institution |58 Blue Spring Street N. |Land O Lakes  |Florida      |34639      |United States  |Organization |Call In |Fire Starter  |06/12/2020 10:00 PM|06/12/2020     |
    And I validate if "Organization has been created." message is correct
    And I validate if "HowGreenWasMyValley Data Systems"summary opened properly
    And I navigate to Actions
    And I click on add action button
    And I update action organization 0
    Then I click on Save Changes button in Actions
    And I validate if "Action has been created." message is correct
    And I click on add action button
    And I update action organization 0
    Then I click on Save Changes button in Actions
    And I validate if "Duplicate actions with an identical time and date cannot be saved. Please try again." message is correct
    And I click on clear changes on actions for "Organization"
