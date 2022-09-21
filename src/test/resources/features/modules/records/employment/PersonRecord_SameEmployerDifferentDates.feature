#Author: Milton Silva
#Regression testcase TL-331: Multiple Employment records

@MultipleEmploymentRecords
Feature: Employment Relationship

  @MultipleEmploymentRecordsScenarios @Done @Employment
  Scenario: Record - Employment - verify employment records with different start dates create only one relationship
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name				         |Role	      |Address1		              |City	        |State	        |PostalCode |Country	  |
      |TobaccoRoad Data Systems  |Institution |11201 Old Statesville Road |Huntersville |North Carolina |28078      |United States|
    Then I validate if "Organization has been created." message is correct
    When I create a person
      |FirstName   |LastName |EmailAddress        |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Barbara     |Randolph |BRandolph@music.com |Personal   |Inquiry          |Student|Freshman   |Accepted             |Accepted         |06/12/2019       |Fall 2019|
    And I validate if "Person has been created." message is correct
    #add an employment record
    And I validate if "Barbara"summary opened properly
    And I navigate to Employment
    And I pick an organization Employer "TobaccoRoad" group "0"
    And I update Employment "Designer", "11/11/2012", "", "", "" group "0"
    And I click on "Save Changes"
    And I close alert if return this message "Person has been updated."
    And I verify Employment "TobaccoRoad Data Systems", "Designer", "11/11/2012", "", "", "" group "0"
    #add another employment record for the same employer
    And I add Employment group "0"
    And I pick an organization Employer "TobaccoRoad" group "1"
    And I update Employment "Western Film Maker", "11/11/2012", "", "", "" group "1"
    And I click on "Save Changes"
    And I close alert if return this message "Person has been updated."
    And I verify Employment "TobaccoRoad Data Systems", "Western Film Maker", "11/11/2012", "", "", "" group "1"
    #the organization record only has one relationship for this person
    And I navigate to organization on Records
    And I open an organization record by "TobaccoRoad Data Systems"
    And I verify the record header for organization "TobaccoRoad Data Systems", "", "" and ""
    And I navigate to Relationship
    And I open an organization relationship "Randolph"
    And I verify relationship values "Barbara Randolph", "Employee", "Employer", "", ""

