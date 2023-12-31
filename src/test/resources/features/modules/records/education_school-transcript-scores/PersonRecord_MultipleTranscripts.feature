#Author: Milton Silva
#Regression testcase TL-401: Education: Transcript: Add Multiple
#Regression testcase TL-399: Calculated Fields: High Score
#Regression testcase TL-1066: New Start and End Date Fields
#Regression testcase TL-1082: Enter value into GPA field manually

@MultiplesTranscripts
Feature: Multiples Transcripts

  @MultiplesTranscriptsScenarios @Done @Education
  Scenario: Record - Education_School-Transcript-Scores - verify a student record can have two transcripts for one school and a test score
    #to create a school for the transcript
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name				                |Role		 |Address1	             |City	      |State      |PostalCode |Country	      |
      |Chaminade College Preparatory    |High School |7500 Chaminade Avenue  |West Hills  |California |91304      |United States  |
    Then I validate if "Organization has been created." message is correct
    #to create the student that can have transcripts
    When I create a person
      |FirstName  |LastName     |EmailAddress          |EmailType|EmailOptInMethod |Role1   |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|TranscriptType |TranscriptDate|StartDate  |EndDate    |GraduationDate|GED|DiplomaReceived|OfficialTranscript |ClassRank|ClassSize|GPA     |GPARecalculated  |Scale|Weighted|Percentile|RankUnavailable|RankWeighted|SelfReported|TranscriptComments|
      |Akim       |Tamiroff     |ATamiroff@actors.net  |Personal |Inquiry          |Student |Freshman   |Accepted              |Accepted       |01/15/2016       |Fall 2017|7th Semester   |11/11/2016    |           |           |06/01/2015    |No |No             |Yes                |3        |750      |3.33    |3.300            |2    |Yes     |98.97     |No             |Yes         |No          |Transcript1       |
      |Akim       |Tamiroff     |ATamiroff@actors.net  |Personal |Inquiry          |Student |Freshman   |Accepted              |Accepted       |01/15/2016       |Fall 2017|Student Life   |11/12/2016    |10/10/2002 |10/10/2028 |06/01/2015    |No |No             |Yes                |3        |750      |100.000 |3.300            |2    |Yes     |98.97     |No             |Yes         |No          |Transcript2       |
    Then I validate if "Person has been created." message is correct
    And I validate if "Akim"summary opened properly
    And I navigate to Education
    #to add a high school with two transcripts
    And I update school in education for person "Chaminade", "", "", "", "", "", "" group "0"
    When I update transcript person "0" group "0"
    And I verify if there is no post secondary fields visible group "0"
    And I add a transcript "0"
    When I update transcript person "1" group "1"
    And I verify if there is no post secondary fields visible group "1"
    And I update score on Education for person "SAT (R2016)", "900", "11/11/2012", "Score Report", "Score comment", "400", "500", "", "", "" group "0"
    And I click on save changes in Education for person
    And I close alert if return this message "Person has been updated."
    #verify all of the school, score, and transcript data with 3 decimal GPA value
    And I verify school in education for person "Chaminade College Preparatory", "", "West Hills", "California", "", "", "" group "0"
    And I verify transcript person "0" group "0"
    And I verify if there is no post secondary fields visible group "0"
    And I verify transcript person "1" group "1"
    And I verify if there is no post secondary fields visible group "1"
    And I verify score on Education for person "SAT (R2016)", "900", "11/11/2012", "Score Report", "", "Score comment", "Section: Reading & Writing", "400", "Section: Math", "500", "", "", "", "", "", "" group "0"
    #to go to Basic tab and verify the high score in the calculated field
    And I navigate to basic
    And I verify system generated values "", "16"

  @MultiplesTranscriptsScenarios1 @Done
  Scenario: Record - Education_School-Transcript-Scores - verify the high school transcript composite key
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName   |LastName   |EmailAddress            |EmailType|EmailOptInMethod |Role1   |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|TranscriptType |TranscriptDate|OfficialTranscript |
      |Danny       |Devito     |dannydevito@actors.net  |Personal |Inquiry          |Student |Freshman   |Accepted              |Accepted       |01/15/2016       |Fall 2017|7th Semester   |11/11/2016    |Yes                |
      |Danny       |Devito     |dannydevito@actors.net  |Personal |Inquiry          |Student |Freshman   |Accepted              |Accepted       |01/15/2016       |Fall 2017|7th Semester   |11/11/2016    |Yes                |
    Then I validate if "Person has been created." message is correct
    And I validate if "Danny"summary opened properly
    And I navigate to Education
    And I update school in education for person "Chaminade", "", "", "", "", "", "" group "0"
    When I update transcript person "0" group "0"
    And I add a transcript "0"
    When I update transcript person "0" group "1"
    And I click on save changes in Education for person
    And I verify validation message "School: Transcript 2: Transcript Type must be different."
    And I verify validation message "School: Transcript 2: Date must be different."
    And I verify validation message "School: Transcript 2: Official Transcript must be different."
    And I verify if I do not see validation message "School: Transcript 2: Major or Program of Study must be different."
    And I verify if I do not see validation message "School: Transcript 2: Degree must be different."
    And I click on clear changes
