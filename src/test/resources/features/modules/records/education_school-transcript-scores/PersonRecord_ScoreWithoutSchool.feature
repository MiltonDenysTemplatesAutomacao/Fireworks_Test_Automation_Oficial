#Author: Milton Silva
#Regression testcase TL-78: Education: Scores: School not required
#Regression testcase TL-399: Calculated Fields: High Score

@EducationScoresSchoolNotRequired
Feature: Education Scores: School not required

  @EducationScoresSchoolNotRequiredScenario @Done @Education
  Scenario: Record - Education Scores - verify test scores can be added to a student record without a school
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |EmailAddress            |EmailType  |EmailOptInMethod |Role1   |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Dorothy    |Comingore |DComingore@actors.net   |Personal   |Inquiry          |Student |Freshman   |Accepted              |Accepted       |01/15/2016       |Fall 2017|
    Then I validate if "Person has been created." message is correct
    And I navigate to people on records
    And I open a people record by "Dorothy"
    And I validate if "Dorothy"summary opened properly
    And I navigate to Education
    And I update score on Education for person "SAT (R2016)", "1500", "12/15/2018", "Score Report", "Score comment", "700", "800", "", "", "" group "0"
    And I click on save changes in Education for person
    And I close alert if return this message "Person has been updated."
    And I verify score on Education for person "SAT (R2016)", "1500", "12/15/2018", "Score Report", "Yes", "Score comment", "Section: Reading & Writing", "700", "Section: Math", "800", "", "", "", "", "", "" group "0"
    And I navigate to basic
    And I verify system generated values "", "34"