#Author: Milton Silva
#Regression testcase FW-9220: User Actions can once again be deleted by non-FER Admin users


@ActionsDeleteCanBeDeletedByNonFerAdminUsers
Feature: Actions Delete Actions

  @ActionsDeleteCanBeDeletedByNonFerAdminUsersPerson
  Scenario: Record - Actions - verify user actions can be deleted by non FER Admin users
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName     |EmailAddress           |EmailType|EmailOptInMethod |Role1 |Category     |Action                         |Staff        |ActionDateTime     |ActionDateField|
      |Peyton     |Beal         |peytonbeal@yahoo.com   |Personal |Inquiry          |Person|Campus Events|Admitted Student Day: Register |Fire Starter |11/30/2017 8:00 AM |11/30/2017     |
    #the Delete Action button is enabled on a Person record
    And I validate if "Person has been created." message is correct
    And I validate if "Peyton"summary opened properly
    And I navigate to Actions
    And I click on add action button
    And I update action person "0"
    Then I click on Save Changes button in Actions
    And I validate if "Action has been created." message is correct
    And I navigate to people on records
    And I open a people record by "Peyton"
    And I navigate to Actions
    And I open an action "Campus Events"
    And I validate if delete button in action is visible
    And I validate if disable delete button is not visible
    And I click on delete button in action
    And I validate if delete modal is visible
    And I click on cancel button on delete action modal
    And I validate if delete modal is not visible

  @ActionsDeleteCanBeDeletedByNonFerAdminUsersOrganization
  Scenario: Record - Actions - the Delete Action button is enabled on a Organization record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name					  |Role	       |Address1		         |City	        |State	      |PostalCode |Country	      |Category     |Action  |Staff         |ActionDateTime     |ActionDateField|
      |Vermont Technical      |Institution |58 Blue Spring Street N. |Land O Lakes  |Florida      |34639      |United States  |Organization |Call In |Fire Starter  |06/12/2020 10:00 PM|06/12/2020     |
    And I validate if "Organization has been created." message is correct
    And I validate if "Vermont Technical"summary opened properly
    And I navigate to Actions
    And I click on add action button
    And I update action organization 0
    Then I click on Save Changes button in Actions
    And I validate if "Action has been created." message is correct
    And I navigate to people on records
    And I open a people record by "Peyton"
    And I navigate to Actions
    And I open an action "Organization"
    And I validate if delete button in action is visible
    And I validate if disable delete button is not visible
    And I click on delete button in action
    And I validate if delete modal is visible
    And I click on cancel button on delete action modal
    And I validate if delete modal is not visible