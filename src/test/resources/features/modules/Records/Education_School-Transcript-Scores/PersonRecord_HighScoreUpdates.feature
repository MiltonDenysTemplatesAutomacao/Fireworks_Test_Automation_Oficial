#Author: Milton Silva
#Regression testcase TL-122: Education: Scores: Add Multiple
#Regression testcase TL-399: Calculated Fields: High Score
#Regression testcase TL-766: High Score Settings

@EducationScoresAddMultiple
Feature: Education Scores: Add Multiple

  @EducationScoresAddMultipleScenarios @Done
  Scenario: Record - Education Scores - verify multiple test scores and updating high score settings
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |EmailAddress           |EmailType  |EmailOptInMethod |Role1   |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Michael    |Redgrave |MRedgrave@actors.net   |Personal   |Inquiry          |Student |Freshman   |Accepted              |Accepted       |01/15/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    And I navigate to people on records
    And I open a people record by "Michael"
    And I validate if "Michael"summary opened properly
    And I navigate to Education
    When I update score on Education for person "SAT (R2016)", "1290", "10/14/2014", "Score Report", "First score", "490", "800", "", "", "" group "0"
    And I click on save changes in Education for person
    And I close alert if return this message "Person has been updated."
    And I refresh the page
    And I add score "0"
    When I update score on Education for person "SAT (R2016)", "1450", "12/15/2015", "Self-Reported", "Second score", "800", "650", "", "", "" group "1"
    And I click on save changes in Education for person
    And I close alert if return this message "Person has been updated."
    And I verify score on Education for person "SAT (R2016)", "1450", "12/15/2015", "Self-Reported", "Yes", "Second score", "Section: Reading & Writing", "800", "Section: Math", "650", "", "", "", "", "", "" group "0"
    And I verify score on Education for person "SAT (R2016)", "1290", "10/14/2014", "Score Report", "No", "First score", "Section: Reading & Writing", "490", "Section: Math", "800", "", "", "", "", "", "" group "1"

