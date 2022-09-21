#Author: Milton Silva
#Regression testcase TL-358:Education: School: Scores not required
#Regression testcase TL-1082: Enter value into GPA field manually

@SchoolRelationshipsLinkedRelationship
Feature: School Without Scores

  @SchoolWithoutScores @Done @Education
  Scenario: Record - Education_School-Transcript-Scores - verify scores are not required to add a school and transcript to a student record
    #to create a high school for the transcript
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name				      |Role		   |Address1	     |City	  |State    |PostalCode |Country	      |Phone        |PhoneType|
      |Hinkley High School    |High School |1700 W 11th Ave  |Aurora  |Colorado |80011      |United States    |303-555-1213 |Business |
    Then I validate if "Organization has been created." message is correct
    #to create the student that can have a high school without scores
    When I create a person
      |FirstName  |LastName     |EmailAddress           |EmailType|EmailOptInMethod |Role1   |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|TranscriptType |TranscriptDate|GraduationDate|DiplomaReceived|OfficialTranscript|GPA       |GPARecalculated  |Scale|TranscriptComments                         |SelfReported|ClassRank|ClassSize|GED|Weighted|Percentile|RankUnavailable|RankWeighted|
      |Gabriel    |Batistuta    |gbatistuta@futbol.net  |Personal |Inquiry          |Student |Freshman   |Accepted              |Accepted       |01/16/2016       |Fall 2017|Final          |11/11/2016    |06/01/2015    |No             |Yes               |10000.00  |4.0              |2    |This is a High School Transcript comment1  |No          |3        |750      |No |Yes     |98.97     |No             |Yes         |
      |Gabriel    |Batistuta    |gbatistuta@futbol.net  |Personal |Inquiry          |Student |Freshman   |Accepted              |Accepted       |01/16/2016       |Fall 2017|Final          |11/11/2016    |06/01/2015    |No             |Yes               |9999.999  |00               |2    |This is a High School Transcript comment1  |No          |3        |750      |No |Yes     |98.97     |No             |Yes         |
    Then I validate if "Person has been created." message is correct
    #to add a high school and transcript
    And I validate if "Gabriel"summary opened properly
    And I navigate to Education
    And I update school in education for person "Hinkley High School", "", "", "", "", "", "" group "0"
    When I update transcript person "0" group "0"
    And I click on save changes in Education for person
    And I close alert if return this message "Person has been updated."
    #to verify the high school and transcript with max GPA value
    And I verify school in education for person "Hinkley High School", "", "Aurora", "Colorado", "", "", "" group "0"
    When I verify transcript person "1" group "0"
