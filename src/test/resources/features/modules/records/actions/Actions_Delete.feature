#Author: Milton Silva
#Regression testcase TL-780 (1 of 2): Actions: Delete actions
#Regression testcase TL-780 (2 of 2): Actions: Delete actions

@ActionsDelete
Feature: Actions Delete Actions

  @ActionsDeletePerson @Done @Actions
  Scenario: Record - Actions - verify an action can be deleted from a person record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName     |EmailAddress           |EmailType|EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|Category     |Action                         |Staff        |ActionDateTime     |ActionDateField|
      |Mischa     |Violin       |MViolin@usiccopyist.com|Personal |Inquiry          |Student|Freshman   |Accepted             |Accepted     |01/15/2016       |Fall 2017|Campus Events|Admitted Student Day: Register |Fire Starter |11/30/2017 8:00 AM |11/30/2017     |
    And I validate if "Person has been created." message is correct
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
    And I verify action Datatable values index "0", values "", "", "", "", ""
    And I open an action "Campus Events"
    And I verify action values index "0"
    And I delete action
    Then I close alert if return this message "Action has been deleted."
    And I navigate to Actions
    Then I validate if action were deleted


  @ActionsDeleteOrganization @Done @Actions
  Scenario: Record - Actions - verify an action can be deleted from an organization record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name					  |Role	       |Address1		         |City	        |State	      |PostalCode |Country	      |Category     |Action  |Staff         |ActionDateTime     |ActionDateField|
      |BlueHeat Data Systems  |Institution |58 Blue Spring Street N. |Land O Lakes  |Florida      |34639      |United States  |Organization |Call In |Fire Starter  |06/12/2020 10:00 PM|06/12/2020     |
    And I validate if "Organization has been created." message is correct
    And I validate if "BlueHeat Data Systems"summary opened properly
    And I navigate to Actions
    And I click on add action button
    And I update action organization 0
    Then I click on Save Changes button in Actions
    And I validate if "Action has been created." message is correct
    #to delete the action
    And I verify action Datatable values index "0", values "", "", "", "", ""
    And I open an action "Organization"
    And I verify action values for organization index 0
    And I delete action
    Then I close alert if return this message "Action has been deleted."
    And I navigate to Actions
    Then I validate if action were deleted






