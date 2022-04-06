#Author: Milton Silva
# Regression testcase TL-370 (2 of 2): Non-Student Record Merged with Existing Student Record
# Regression testcase TL-123: Multiple roles can be assigned
# Regression testcase TL-228: Multi-select fields are Combined for Merged Records

@MultipleRolesCanBeAssigned
Feature: Multiple roles can be assigned

  @MultipleRolesCanBeAssignedScenario
  Scenario: to verify merging an existing person with an incoming student
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
     |Firstname|Lastname   |Fullname      |EmailAddress		                |EmailType  |EmailOptInMethod  |Role1	|Phone         |PhoneType|Address1          |City   |State    |PostalCode|Country       |
     |Isao     |Takahata   |Isao Takahata |2iTakahata@japanesedirectors.com |Personal   |Inquiry           |Donor   |(904) 725-0002|Home     |141 Green Hill Dr |Buffalo|New York |14215     |United States |
    #And I validate if "Person has been created" message is correct
    And I create a person
      |Firstname|Lastname   |Fullname       |EmailAddress		              |EmailType  |EmailOptInMethod |Role1	  |Role2  |Phone         |PhoneType|Address1          |City   |State    |PostalCode|Country       |StudentType|StudentStatusCategory|StudentStatus  |StudentStatusDate|EntryTerm|
      |Isao     |Takahata   |Isao Takahata  |iTakahata@japanesedirectors.com  |Personal   |Inquiry          |Sibling  |Student|(904) 725-0002|Home     |141 Green Hill Dr |Buffalo|New York |14215     |United States |Freshman   |Inquiry              |Inquiry-Active |01/25/2016       |Fall 2017|
      |Isao     |Takahata   |Isao Takahata  |2iTakahata@japanesedirectors.com |Personal   |Inquiry          |Donor    |       |(904) 725-0002|Home     |141 Green Hill Dr |Buffalo|New York |14215     |United States |           |                     |               |                 |         |

      #Then I validate if "A potential duplicate Student record was found while creating this record; it has been placed in the Duplicate Manager for review." message is correct
    And I verify content of the suspended record
    And I verify content of the first possible match record
    And I merge duplicates