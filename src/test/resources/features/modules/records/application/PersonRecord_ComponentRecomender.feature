#Author: Milton Silva
#Regression test case TL-437: Application Components and Recommenders

@ApplicationComponentsRecommenders
Feature: Application Components and Recommenders

  @ApplicationComponentsRecommendersScenario @Done @Application
  Scenario: Record - Application - verify application components can be saved and do not receive automatic recommender values
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create a recommender
    When I create a person
      |FirstName |LastName |EmailAddress          |EmailType  |EmailOptInMethod |Role1       |
      |Midge     |Klump    |mklump@riverdale.edu  |Personal   |Inquiry          |Recommender |
    And I validate if "Person has been created." message is correct
    #to create a 2nd recommender
    When I create a person
      |FirstName |LastName |EmailAddress          |EmailType  |EmailOptInMethod |Role1       |
      |Dilton    |Doiley   |ddoiley@riverdale.com |Personal   |Inquiry          |Recommender |
    And I validate if "Person has been created." message is correct
    #to create a student record
    When I create a person
      |FirstName |LastName  |EmailAddress           |EmailType  |EmailOptInMethod |Role1   |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Chuck     |Clayton   |cclayton@riverdale.edu |Personal   |Inquiry          |Student |Freshman   |Accepted              |Accepted       |01/15/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    #to create an application
    And I validate if "Chuck Clayton"summary opened properly
    And I navigate to Applications
    When I update application "Fall 2019", "Accounting", "In Progress", "Early Action", "Online", "06/22/2018 7:30 PM", "", "", "", "", "", "", "", "" group "0"
    And I update application component "", "Yes", "1", "Yes", "Midge", "" component "0" group "0"
    And I update application component "", "Yes", "1", "Yes", "", "" component "1" group "0"
    And I update application component "", "Yes", "1", "Yes", "", "" component "2" group "0"
    And I update application component "", "Yes", "1", "Yes", "", "" component "3" group "0"
    And I update application component "", "Yes", "1", "Yes", "", "" component "4" group "0"
    And I update application component "", "Yes", "1", "Yes", "", "" component "5" group "0"
    And I update application component "", "Yes", "1", "Yes", "", "" component "6" group "0"
    And I update application component "", "Yes", "1", "Yes", "Dilton", "" component "7" group "0"
    And I click on save changes on Application
    And I close alert if return this message "Person has been updated."
    #to verify the Application and Components
    And I verify application "Fall 2019", "Accounting", "In Progress", "Early Action", "Online", "06/22/2018 7:30 PM", "", "", "", "", "", "", "", "" group "0"
    And I verify application component "Application Form", "Yes", "1", "Yes", "Midge Klump", "" component "0" group "0"
    And I verify application component "Essay", "Yes", "1", "Yes", "", "" component "1" group "0"
    And I verify application component "Personal Statement", "Yes", "1", "Yes", "", "" component "2" group "0"
    And I verify application component "Recommendation", "Yes", "1", "Yes", "", "" component "3" group "0"
    And I verify application component "Resume", "Yes", "1", "Yes", "", "" component "4" group "0"
    And I verify application component "Supplemental Form", "Yes", "1", "Yes", "", "" component "5" group "0"
    And I verify application component "Test Score", "Yes", "1", "Yes", "", "" component "6" group "0"
    And I verify application component "Transcript", "Yes", "1", "Yes", "", "" component "7" group "0"


