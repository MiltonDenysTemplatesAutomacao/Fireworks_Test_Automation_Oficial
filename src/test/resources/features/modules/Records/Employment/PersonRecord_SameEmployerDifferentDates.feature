#Author: Milton Silva
#Regression testcase TL-331: Multiple Employment records

@MultipleEmploymentRecords
Feature: Employment Relationship

  @MultipleEmploymentRecordsScenarios @Done @Employment
  Scenario: Record - Employment - verify employment records with different start dates create only one relationship
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name				   |Role	    |Address1		 |City	  |State	 |PostalCode |Country	   |
      |Decca Data Systems  |Institution |1963 Coffee Ave |Memphis |Tennessee |38106      |United States|
    Then I validate if "Organization has been created." message is correct
    When I create a person
      |FirstName|LastName |EmailAddress      |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Dave     |Berry    |DBerry@music.com  |Personal   |Inquiry          |Student|Freshman   |Accepted             |Accepted         |06/15/2020       |Fall 2021|
    And I validate if "Person has been created." message is correct