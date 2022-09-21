#Author: Milton Silva

@EducationScoresRequiredFields
Feature: Education Scores Required Fields

  @EducationScoresRequiredFieldsScenario @Done @Education
  Scenario: Record - Education Scores - verify test required scores required fields
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |EmailAddress              |EmailType|EmailOptInMethod |Role1   |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Jacob      |Arnold    |jacobarnold@actors.net   |Personal  |Inquiry          |Student |Freshman   |Accepted              |Accepted       |01/15/2016       |Fall 2017|
    Then I validate if "Person has been created." message is correct
    And I validate if "Jacob"summary opened properly
    And I navigate to Education
    And I update score on Education for person "", "", "", "", "comments", "", "", "", "", "" group "0"
    And I click on save changes in Education for person
    And I verify validation message "Scores: The Score Type field is required."
    And I verify validation message "Scores: The Source field is required."
    And I verify validation message "Scores: The Score Date field is required."
    And I verify validation message "Scores: The Source field is required."