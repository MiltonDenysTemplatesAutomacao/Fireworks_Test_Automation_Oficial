#Author: Milton Silva
#Regression testcase TL-373: Education: School: No duplicate

@EducationSchoolNoDuplicate
Feature: Education: School: No duplicate

  @EducationSchoolNoDuplicate @Done @Education
  Scenario: Record - Education_School-Transcript-Scores - verify a duplicate high school can not be added to an education panel for a student
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName     |EmailAddress             |EmailType|EmailOptInMethod |Role1   |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Buster     |Douglas      |BusterDouglas@music.com  |Personal |Inquiry          |Student |Freshman   |Applicant            |Waitlisted       |02/15/2020       |Fall 2021|
    Then I validate if "Person has been created." message is correct
    Given I go to Home page
    And I quick search "FirstName"
    And I validate if "Buster"summary opened properly
    And I open a record
    And I navigate to Education
    And I add school "0"
    And I search a school picker "HeavyWeight High School" group "1"
    When I click on choose button on school picker modal
    And I click on save changes in Education for person
    And I verify validation message "School 2: The Relationship already exists."

