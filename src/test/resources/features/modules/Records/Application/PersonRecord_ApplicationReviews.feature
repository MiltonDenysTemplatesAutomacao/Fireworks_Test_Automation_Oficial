#Author: Milton Silva
#Regression testcase TL-142: Application Review can be Saved

@ApplicationReviews
Feature: Second Application

  @ApplicationReviewsScenario @Done @Application
  Scenario: Record - Application - verify Application Reviews can be saved
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |EmailAddress     |EmailType  |EmailOptInMethod |Role1   |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Veronica   |Lodge    |vlodge@rich.com  |Personal   |Inquiry          |Student |Freshman   |Accepted              |Accepted       |01/15/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    #to add an application
    And I navigate to people on records
    And I open a people record by "Veronica"
    And I validate if "Veronica"summary opened properly
    And I navigate to Applications
    When I update application "Summer 2018", "Accounting", "Not Started", "Early Decision", "Common Application", "10/22/2017 12:00 AM", "", "", "", "", "", "", "", "" group "0"
    And I update application review "Leadership", "3", "Fire Starter", "1", "Review1 Comment" application "0" review "0"
    And I click on save changes on Application
    And I close alert if return this message "Person has been updated."
    #to add a 2nd application review
    When I add a review "0" app "0"
    And I update application review "Academic Performance", "3", "Fire Starter", "1", "Review2 Comment" application "0" review "1"
    And I click on save changes on Application
    And I close alert if return this message "Person has been updated."
    #to verify the application and reviews