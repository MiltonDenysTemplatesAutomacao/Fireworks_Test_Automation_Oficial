#Author: Milton Silva
#Regression testcase TL-122: Education: Scores: Add Multiple
#Regression testcase TL-399: Calculated Fields: High Score
#Regression testcase TL-766: High Score Settings

@EducationScoresAddMultiple
Feature: Education Scores: Add Multiple

  @EducationScoresAddMultipleScenarios @Done @Education
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
    And I verify score on Education for person "SAT (R2016)", "1450", "12/15/2015", "Self-Reported", "No", "Second score", "Section: Reading & Writing", "800", "Section: Math", "650", "", "", "", "", "", "" group "0"
    And I verify score on Education for person "SAT (R2016)", "1290", "10/14/2014", "Score Report", "Yes", "First score", "Section: Reading & Writing", "490", "Section: Math", "800", "", "", "", "", "", "" group "1"
    #the higher score is not official so we expect High Score to be the ACT equivalent of 1290
    And I navigate to basic
    And I verify system generated values "", "27"
    #to edit score2 to be official
    And I navigate to Education
    When I update score on Education for person "", "", "", "Transcript", "", "", "", "", "", "" group "0"
    And I click on save changes in Education for person
    And I close alert if return this message "Person has been updated."
    And I verify score on Education for person "SAT (R2016)", "1450", "12/15/2015", "Transcript", "Yes", "Second score", "Section: Reading & Writing", "800", "Section: Math", "650", "", "", "", "", "", "" group "0"
    #to verify the High Score updates to the ACT equivalent of 1450
    And I navigate to basic
    And I verify system generated values "", "33"
    #to change the High Score Display to SAT R2016
    And I navigate to Admin Panel Page
    And I update required school name "Fire Engine Red"
    And I update High Score Display "SAT (R2016)"
    And I click on save changes for Admin Panel on basic tab
    #to verify the High Score updates to 1450
    And I navigate to people on records
    And I open a people record by "Michael"
    And I validate if "Michael"summary opened properly
    And I navigate to basic
    And I verify system generated values "", "1450"
    #to change the SAT R2016 High Score to Super Score
    And I navigate to Admin Panel Page
    And I update SAT R2016 High Score "Super Score"
    And I click on save changes for Admin Panel on basic tab
    #to verify the High Score updates to 1600
    And I navigate to people on records
    And I open a people record by "Michael"
    And I validate if "Michael"summary opened properly
    And I navigate to basic
    And I verify system generated values "", "1600"
    #recover values from Admin Panel page for nexts scenarios
    And I navigate to Admin Panel Page
    And I update SAT R2016 High Score "Best Sitting"
    And I update High Score Display "ACT"
    And I click on save changes for Admin Panel on basic tab
