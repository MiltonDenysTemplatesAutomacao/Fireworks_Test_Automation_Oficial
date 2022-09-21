#Author: Milton Silva
#Regression testcase TL-88 (2 of 2): Education Relationships May be Created
#Regression testcase TL-1082: Enter value into GPA field manually

@AddUniversityRelationship
Feature: Add University Relationship

  @AddUniversityRelationshipScenarios @Done @Education
  Scenario: Record - Education_School-Transcript-Scores - verify a university to student relationship can be created from education panel
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name				       |Role		               |Address1            |City	            |State   |PostalCode |Country	     |IDType |IDNumber |WhoAddedID   |
      |SevenSamurai University |Post-Secondary Institution |7000 Powers Avenue  |Jacksonville Beach |Florida |32250      |United States  |CEEB   |69199    |Fire Starter |
    Then I validate if "Organization has been created." message is correct
    #to update the external ID data
    And I verify the record header for organization "SevenSamurai University", "OK to Contact: Yes", "Record Status: Active" and "Organization Category: School"
    And I navigate to ID Types
    When I update "IDType", "IDNumber", "", "WhoAddedID", and "" to update external ID Types for organization
    And I close alert if return this message "Organization has been updated."
    And I create a person
      |FirstName  |LastName   |EmailAddress                       |EmailType  |EmailOptInMethod |Role1   |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|TranscriptType |TranscriptDate|GraduationDate|DiplomaReceived|OfficialTranscript |GPA     |GPARecalculated  |Scale|SelfReported|TranscriptComments|Major     |Degree                       |DegreeLevel  |DegreeEarned |DegreeDate|Minor       |CreditHours|
      |Hiroshi    |Teshigahara|HTeshigahara@Japanese-masters.com  |Personal   |Inquiry          |Student |Freshman   |Accepted              |Accepted       |04/05/2020       |Fall 2020|Final          |11/11/2013    |11/11/2014    |Yes            |Yes                |99.234  |1.100            |1    |No          |Transcript comment|Accounting|Associate of Applied Science |Associate    |Yes          |11/11/2015|Agriculture |10         |
    And I validate if "Person has been created." message is correct
    #to add a university and transcript to the student
    And I validate if "Hiroshi"summary opened properly
    And I navigate to Education
    And I update school in education for person "SevenSamurai University", "", "", "", "School comment visible in Relationship", "", "" group "0"
    When I update transcript person "0" group "0"
    And I verify if there is no high school fields visible group "0"
    And I click on save changes in Education for person
    And I close alert if return this message "Person has been updated."
    #to verify the school and relationship data
    And I verify school in education for person "SevenSamurai University", "69199", "Jacksonville Beach", "Florida", "School comment visible in Relationship", "", "" group "0"
    And I verify transcript person "0" group "0"
    And I navigate to Relationship
    And I open a relationship "SevenSamurai University"
    And I verify relationship values "SevenSamurai University", "College/University", "Student", "School comment visible in Relationship", ""
    And I validate relationship readonly
    And I navigate to organization on Records
    And I open an organization record by "SevenSamurai University"
    And I navigate to Relationship
    And I open an organization relationship "Teshigahara"
    And I verify relationship values "Hiroshi Teshigahara", "Student", "College/University", "School comment visible in Relationship", ""
    And I validate relationship readonly
