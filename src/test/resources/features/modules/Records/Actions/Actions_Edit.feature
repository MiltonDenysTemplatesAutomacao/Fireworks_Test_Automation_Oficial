#Author: Milton Silva
#Regression testcase TL-256: Actions: Edit actions

@ActionsEdit
Feature: Actions Edit actions

  @ActionsEditPerson
  Scenario: verify that editing an action shows the proper values in the edit modal window
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a staff
      |FirstName  |LastName	  |Fullname		    |EmailAddress	            |EmailType	|PermissionGroup|
      |Alan		  |Rickman    |Alan Rickman 	|ARickman@actors.net    	|Personal	|Administrator	|
    And I validate if "Staff member has been created." message is correct
    And I create a person
      |FirstName  |LastName     |EmailAddress	        |EmailType  |EmailOptInMethod  |Role1   |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate |EntryTerm|Category     |Action                         |Staff        |ActionDateField    |ActionDate|Comments              |ActionType |ActionVisibility |
      |Roger      |Bannister    |RBannister@runners.com |Personal   |Inquiry           |Student | Freshman  |Accepted              |Accepted       |01/15/2016        |Fall 2017|Campus Events|Admitted Student Day: Attend   |Alan Rickman |01/05/2015 4:00 PM |01/05/2015|Original Comment      |Staff      |Primary          |
      |           |             |                       |           |                  |        |           |                      |               |                  |         |Campus Events|Admitted Student Day: Register |Fire Starter |01/05/2015 4:00 PM |01/05/2015|Edited Action Comment |           |                 |
    And I validate if "Person has been created." message is correct
    Given I go to Home page
    And I quick search "FirstName"
    #to add an action
    And I validate if "Roger"summary opened properly
    When I open a record
    And I navigate to Actions
    And I click on add action button
    And I update action person "0"
    Then I click on Save Changes button in Actions
    Then I validate if "Action has been created." message is correct
    #to edit the action
    And I verify action Datatable values "Category", "Action", "Staff", "ActionDate" and "Comments" index "0"
    And I navigate to Actions
    And I open an action "Campus Events"
    And I verify action values index "0"
    And I update action person "1"
    Then I click on Save Changes button in Actions
    And I close alert if return this message "Action has been updated."
    #to reopen the action to verify
    And I navigate to Actions
    And I open an action "Admitted Student Day: Register"
    And I verify action values index "1"
    #to verify default values of a new Action after editing an action
