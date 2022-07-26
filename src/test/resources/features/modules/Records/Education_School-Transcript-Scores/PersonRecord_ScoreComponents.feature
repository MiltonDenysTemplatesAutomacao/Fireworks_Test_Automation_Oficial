#Author: Milton Silva
#Regression testcase TL-249: Education: Score Components

@EducationScoreComponents
Feature: Education Scores: Add Multiple

  @EducationScoreComponentsScenario @Done @Education
  Scenario: Record - Education Scores - verify multiple test scores and updating high score settings
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |EmailAddress           |EmailType  |EmailOptInMethod |Role1   |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Willard    |Scott    |wscott@mcdonalds.com   |Personal   |Inquiry          |Student |Freshman   |Accepted              |Accepted       |09/19/2016       |Fall 2017|
    #And I validate if "Person has been created." message is correct
    And I navigate to people on records
    And I open a people record by "Willard"
    And I validate if "Willard"summary opened properly
    And I navigate to Education
    #to pick SAT R2016 score type and verify components
    When I update score on Education for person "SAT (R2016)", "", "", "", "", "", "", "", "", "" group "0"
    And I verify components on Education for person "Section: Reading & Writing", "Section: Math", "Cross-Test: Analysis in Science", "Cross-Test: Analysis in Hist/SS", "Test: Reading", "Test: Writing & Language", "Test: Math", "Subscore: Words in Context", "Subscore: Heart of Algebra", "Subscore: Command of Evidence", "Subscore: Passport to Adv Math", "Subscore: Expression of Ideas", "Subscore: Prob Solv & Data Analysis", "Subscore: Standard Eng Conventions", group "0"
    #to change the score type to ACT and verify components
    When I update score on Education for person "ACT", "", "", "", "", "", "", "", "", "" group "0"
    And I verify components on Education for person "English", "Mathematics", "Reading", "Science", "Writing", "", "", "", "", "", "", "", "", "", group "0"
