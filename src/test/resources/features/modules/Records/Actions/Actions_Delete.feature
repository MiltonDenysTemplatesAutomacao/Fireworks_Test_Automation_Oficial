#Author: Milton Silva
#Regression testcase TL-780 (1 of 2): Actions: Delete actions
#Regression testcase TL-780 (2 of 2): Actions: Delete actions


@ActionsDelete
Feature: Actions Delete Actions

  @ActionsDelete
  Scenario: Letter - create from template - system actions
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName     |EmailAddress           |EmailType|EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|Category     |Action                         |Staff        |ActionDateTime     |ActionDateField|
      |Mischa     |Violin       |MViolin@usiccopyist.com|Personal |Inquiry          |Student|Freshman   |Accepted             |Accepted     |01/15/2016       |Fall 2017|Campus Events|Admitted Student Day: Register |Fire Starter |11/30/2017 8:00 AM |11/30/2017     |
    #And I validate if "Person has been created." message is correct
    And I validate if "Mischa"summary opened properly
    And I go to Home page
    And I quick search "FirstName"
    And I open a record
    And I navigate to Actions
    And I click on add action button
    And I update action person "0"
    Then I click on Save Changes button in Actions
    And I validate if "Action has been created." message is correct
    #to delete the action
    And I verify action Datatable values index 0



