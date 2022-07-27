#Author: Milton Silva
#Regression test case TL-68: Second Application can be added
#Regression test case TL-706: Application Components are not required

@SecondApplication
Feature: Second Application

  @SecondApplicationScenario @Done @Application
  Scenario: Record - Application - verify that two applications can be added to a record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |EmailAddress          |EmailType  |EmailOptInMethod |Role1   |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Alfred     |Capone    |aCapone@missing.comt  |Personal   |Inquiry          |Student |Freshman   |Accepted              |Accepted       |01/15/2016       |Fall 2017|
    #And I validate if "Person has been created." message is correct
    #to add two applications
    And I navigate to people on records
    And I open a people record by "Alfred"
    And I validate if "Alfred"summary opened properly
    And I navigate to Applications
    When I update application "Spring 2017", "Accounting", "In Progress", "Regular Decision", "Common Application", "01/20/2017 12:00 AM", "", "", "", "", "", "", "", "" group "0"
#    And I add application "0"
#    When I update application "Fall 2017", "Agriculture", "Not Started", "Regular Decision", "Universal Application", "07/20/2017 12:00 AM", "", "", "", "", "", "", "", "" group "1"
#    And I click on save changes on Application
#    And I close alert if return this message "Person has been updated."
#    #to verify both applications and all components
#    And I verify application "Spring 2017", "Accounting", "In Progress", "Regular Decision", "Common Application", "", "", "", "", "", "", "", "", "" group "0"
#
