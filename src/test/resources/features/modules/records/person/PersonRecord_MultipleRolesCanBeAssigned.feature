#Author: Milton Silva
# Regression testcase TL-370 (2 of 2): Non-Student Record Merged with Existing Student Record
# Regression testcase TL-123: Multiple roles can be assigned
# Regression testcase TL-228: Multi-select fields are Combined for Merged Records

@MultipleRolesCanBeAssigned
Feature: Multiple roles can be assigned

  @MultipleRolesCanBeAssignedScenario @Fix
  Scenario: Record - Person - to verify different merge scenarios
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
     |FirstName|LastName   |FullName      |EmailAddress		                |EmailType  |EmailOptInMethod  |Role1	|Phone         |PhoneType|Address1          |City   |State    |PostalCode|Country       |
     |Isao     |Takahata   |Isao Takahata |2iTakahata@japanesedirectors.com |Personal   |Inquiry           |Donor   |(904) 725-0002|Home     |141 Green Hill Dr |Buffalo|New York |14215     |United States |
    And I validate if "Person has been created" message is correct
    And I create a person
      |FirstName|LastName   |FullName       |EmailAddress		              |EmailType  |EmailOptInMethod |Role1	  |Role2  |Phone         |PhoneType|Address1          |City   |State    |PostalCode|Country       |StudentType|StudentStatusCategory|StudentStatus  |StudentStatusDate|EntryTerm|
      |Isao     |Takahata   |Isao Takahata  |iTakahata@japanesedirectors.com  |Personal   |Inquiry          |Sibling  |Student|(904) 725-0002|Home     |141 Green Hill Dr |Buffalo|New York |14215     |United States |Freshman   |Inquiry              |Inquiry-Active |01/25/2016       |Fall 2017|
      |Isao     |Takahata   |Isao Takahata  |2iTakahata@japanesedirectors.com |Personal   |Inquiry          |Donor    |       |(904) 725-0002|Home     |141 Green Hill Dr |Buffalo|New York |14215     |United States |           |                     |               |                 |         |
    Then I validate if "A potential duplicate Student record was found while creating this record; it has been placed in the Duplicate Manager for review." message is correct
    And I verify content of the suspended record person 0
    And I verify content of the "0" possible match record person 1
    And I merge duplicates
    And I verify merge preview 0
    And I confirm merge and close
    And I navigate to duplicates
    And I validate if "Isao Takahata" record lo longer exists on the duplicates page
    And I search "LastName" on duplicate manager person 0
    And I validate if "Isao Takahata" record lo longer exists on the duplicates page
    When I navigate to people on records
    And I open a people record by "Takahata"
    Then I validate if "Isao Takahata"summary opened properly
    And I verify Header Role "Multiple"
    And verify if "Donor" role are selected
    And verify if "Sibling" role are selected
    And verify if "Student" role are selected
    And I navigate to contact
    And I verify email address "0" fields
    And I verify email address "1" fields
    And I click on student status
    And I verify student status group "0" person 0



