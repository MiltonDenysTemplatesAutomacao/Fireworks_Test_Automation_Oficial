#Author: Milton Silva
#Regression testcase TL-401: Education: Transcript: Add Multiple
#Regression testcase TL-399: Calculated Fields: High Score
#Regression testcase TL-1066: New Start and End Date Fields
#Regression testcase TL-1082: Enter value into GPA field manually

@MultiplesTranscripts
Feature: School Without Scores

  @MultiplesTranscriptsScenarios @Done
  Scenario: Record - Education_School-Transcript-Scores - verify a student record can have two transcripts for one school and a test score
    #to create a school for the transcript
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name				                |Role		 |Address1	             |City	      |State      |PostalCode |Country	      |
      |Chaminade College Preparatory    |High School |7500 Chaminade Avenue  |West Hills  |California |91304      |United States  |
    #Then I validate if "Organization has been created." message is correct
    #to create the student that can have transcripts
    When I create a person
      |FirstName  |LastName     |EmailAddress           |EmailType|EmailOptInMethod |Role1   |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Akim       |Tamiroff    |ATamiroff@actors.net    |Personal |Inquiry          |Student |Freshman   |Accepted              |Accepted       |01/15/2016       |Fall 2017|
    #Then I validate if "Person has been created." message is correct
    And I navigate to people on records
    And I open a people record by "Akim"
    And I validate if "Akim"summary opened properly
    And I navigate to Education
    #to add a high school with two transcripts
    And I update school in education for person "Chaminade College Preparatory", "", "West Hills", "California", "", "", "" group "0"

