#Author: Milton Silva
#Regression testcase TL-446: Education: Scores: Composite keys


@EducationScoresCompositeKeys
Feature: School Without Scores

  @EducationScoresCompositeKeysScenarios @Done
  Scenario: Record - Education_School-Transcript-Scores - verify test scores composite keys
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |EmailAddress          |EmailType|EmailOptInMethod |Role1   |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|TranscriptType |TranscriptDate|StartDate  |EndDate    |GraduationDate|GED|DiplomaReceived|OfficialTranscript |ClassRank|ClassSize|GPA     |GPARecalculated  |Scale|Weighted|Percentile|RankUnavailable|RankWeighted|SelfReported|TranscriptComments|
      |King       |Moody     |kingmoody@actors.net  |Personal |Inquiry          |Student |Freshman   |Accepted              |Accepted       |01/15/2016       |Fall 2017|7th Semester   |11/11/2016    |           |           |06/01/2015    |No |No             |Yes                |3        |750      |3.33    |3.300            |2    |Yes     |98.97     |No             |Yes         |No          |Transcript1       |
    Then I validate if "Person has been created." message is correct
    And I navigate to people on records
    And I open a people record by "King"
    And I validate if "King"summary opened properly
    And I navigate to Education
    And I add score "0"
    And I update score on Education for person "SAT (R2016)", "1220", "11/11/2012", "Self-Reported", "", "620", "600", "", "", "" group "1"
    And I click on save changes in Education for person
    And I verify validation message "Score Type must be different."

