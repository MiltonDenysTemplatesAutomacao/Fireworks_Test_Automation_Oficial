#Author: Milton Silva
# Regression testcase TL-370 (2 of 2): Non-Student Record Merged with Existing Student Record
# Regression testcase TL-123: Multiple roles can be assigned
# Regression testcase TL-228: Multi-select fields are Combined for Merged Records

@MultipleRolesCanBeAssigned
Feature: Multiple roles can be assigned

  @MultipleRolesCanBeAssignedScenario
  Scenario: to verify different scenarios in merge
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
     |Firstname|Lastname   |Fullname      |EmailAddress		                |EmailType  |EmailOptInMethod  |Role1	|Phone         |PhoneType|Address1          |City   |State    |PostalCode|Country       |
     |Isao     |Takahata   |Isao Takahata |2iTakahata@japanesedirectors.com |Personal   |Inquiry           |Donor   |(904) 725-0002|Home     |141 Green Hill Dr |Buffalo|New York |14215     |United States |
    And I validate if "Person has been created" message is correct
    And I create a person
      |Firstname|Lastname   |Fullname       |EmailAddress		              |EmailType  |EmailOptInMethod |Role1	  |Role2  |Phone         |PhoneType|Address1          |City   |State    |PostalCode|Country       |StudentType|StudentStatusCategory|StudentStatus  |StudentStatusDate|EntryTerm|
      |Isao     |Takahata   |Isao Takahata  |iTakahata@japanesedirectors.com  |Personal   |Inquiry          |Sibling  |Student|(904) 725-0002|Home     |141 Green Hill Dr |Buffalo|New York |14215     |United States |Freshman   |Inquiry              |Inquiry-Active |01/25/2016       |Fall 2017|
      |Isao     |Takahata   |Isao Takahata  |2iTakahata@japanesedirectors.com |Personal   |Inquiry          |Donor    |       |(904) 725-0002|Home     |141 Green Hill Dr |Buffalo|New York |14215     |United States |           |                     |               |                 |         |

    Then I validate if "A potential duplicate Student record was found while creating this record; it has been placed in the Duplicate Manager for review." message is correct
    And I verify content of the suspended record
    And I verify content of the first possible match record
    And I merge duplicates
    And I verify merge preview
    And I confirm merge and close
    And I navigate to duplicates
    And I validate if the record lo longer exists on the duplicates page
    And I search "Lastname" on duplicate manager
    And I validate if the record lo longer exists on the duplicates page
    When I navigate to people on records
    And I open a people record by "Lastname"
    Then I validate if "Fullname"summary opened properly
    And I verify Header Role "Multiple"
    And I verify all three roles are selected in the role dropdown
    And I navigate to contact
    And I verify email address "0" fields
    And I verify email address "1" fields

