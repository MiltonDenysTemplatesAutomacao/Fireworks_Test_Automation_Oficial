#Author: Milton Silva
#Regression testcase : Add School with Transcript and Score
#Regression testcase TL-399: Calculated Fields: High Score
#Regression testcase TL-1082: Enter value into GPA field manually

@UniversityWithACT
Feature: University with ACT

  @UniversityWithACTScenarios @Done
  Scenario: Record - Education_School-Transcript-Scores - Calculated Fields- verify a university and act score can be added to a student record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create a university
    And I create an organization
      |Name				         |Role		                 |Address1        |City	      |State     |PostalCode |Country	     |IDType |IDNumber |RecordedDate|WhoAddedID   |
      |Rosebudgardner University |Post-Secondary Institution |621 Rose Drive  |San Carlos |California|94070      |United States  |CEEB   |89199    |05/11/2020  |Fire Starter |
    Then I validate if "Organization has been created." message is correct
    And I verify the record header for organization "Rosebudgardner University", "OK to Contact: Yes", "Record Status: Active" and "Organization Category: School"
    And I navigate to ID Types
    When I update "IDType", "IDNumber", "RecordedDate", "WhoAddedID", and "" to update external ID Types for organization
    And I close alert if return this message "Organization has been updated."
    #to create the student that can have a university and ACT scores
    And I create a person
      |FirstName  |LastName |EmailAddress           |EmailType  |EmailOptInMethod |Role1   |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|TranscriptType |TranscriptDate|GraduationDate|DiplomaReceived|OfficialTranscript |GPA     |GPARecalculated  |Scale|SelfReported|TranscriptComments|Major     |Degree                       |DegreeLevel  |DegreeEarned |DegreeDate|Minor       |CreditHours|
      |Robert     |Wise     |RWise@directors.net    |Personal   |Inquiry          |Student |Freshman   |Accepted              |Accepted       |04/15/2020       |Fall 2020|Final          |11/11/2013    |11/11/2014    |Yes            |Yes                |-2.222  |2.200            |1    |No          |Transcript comment|Accounting|Associate of Applied Science |Associate    |Yes          |11/11/2015|Agriculture |10         |
    And I validate if "Person has been created." message is correct
    #to add a university with a transcript and a test score
    And I navigate to people on records
    And I open a people record by "Robert"
    And I validate if "Robert"summary opened properly
    And I navigate to Education
    And I update school in education for person "Rosebudgardner University", "", "", "", "University comment", "", "" group "0"
    When I update transcript person "0" group "0"
    And I verify if there is no high school fields visible group "0"
    When I update score on Education for person "ACT", "21", "11/11/2012", "Score Report", "Score comment", "20", "22", "19", "23", "21" group "0"
    And I click on save changes in Education for person
    And I close alert if return this message "Person has been updated."
    #to verify the education data
    And I verify school in education for person "Rosebudgardner University", "89199", "San Carlos", "California", "University comment", "", "" group "0"
    And I verify transcript person "0" group "0"
    And I verify if there is no high school fields visible group "0"
    And I verify score on Education for person "ACT", "21", "11/11/2012", "Score Report", "Yes", "Score comment", "English", "20", "Mathematics", "22", "Reading", "19", "Science", "23", "Writing", "21" group "0"
    #to go to Basic tab and verify the high score in the calculated field
    And I navigate to basic
    And I verify system generated values "", "21"
