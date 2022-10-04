#Author: Milton Silva
#Regression testcase TL-370 (1 of 2): Non-Student Record Merged with Existing Student Record

@NonStudentRecordMergedWithExistingStudentRecord
Feature: Non-Student Record Merged with Existing Student Record

  @NonStudentRecordMergedWithExistingStudentRecordScenario @Done @DupManager
  Scenario: Record - DupManager - that an existing student keeps their email as primary when merged with incoming non-student
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to add a person record
    When I create a person
      |FirstName  |LastName |Role1    |EmailAddress                    |EmailType  |EmailOptInMethod|Phone         |PhoneType|Address1       |City          |State         |PostalCode|Country      |StudentType|StudentStatus  |StudentStatusCategory|StudentStatusDate|EntryTerm|
      |Hayao      |Miyazaki |Student  |hMiyazaki@japanesedirectors.com |Personal   |Inquiry         |(803) 725-0001|Home     |259 Palmetto Dr|Isle of Palms |South Carolina|29451     |United States|Freshman   |Inquiry-Active |Inquiry              |01/25/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    #to add a second sibling record that matches the student record except has a different email address which starts the duplicate process
    When I create a person
      |FirstName  |LastName |Role1    |EmailAddress                     |EmailType  |EmailOptInMethod|Phone         |PhoneType|Address1       |City          |State         |PostalCode|Country      |
      |Hayao      |Miyazaki |Sibling  |2hMiyazaki@japanesedirectors.com |Personal   |Inquiry         |(803) 725-0001|Home     |259 Palmetto Dr|Isle of Palms |South Carolina|29451     |United States|
    And I validate if "A potential duplicate Person record was found while creating this record; it has been placed in the Duplicate Manager for review." message is correct
    And I use datatable
      |FirstName  |LastName |Role1    |EmailAddress                     |EmailType  |EmailOptInMethod|Phone         |PhoneType|Address1       |City          |State         |PostalCode|Country      |StudentType|StudentStatus  |StudentStatusCategory|StudentStatusDate|EntryTerm|Active|Primary|
      |Hayao      |Miyazaki |Student  |hMiyazaki@japanesedirectors.com  |Personal   |Inquiry         |(803) 725-0001|Home     |259 Palmetto Dr|Isle of Palms |South Carolina|29451     |United States|Freshman   |Inquiry-Active |Inquiry              |01/25/2016       |Fall 2017|1     |1      |
      |Hayao      |Miyazaki |Sibling  |2hMiyazaki@japanesedirectors.com |Personal   |Inquiry         |(803) 725-0001|Home     |259 Palmetto Dr|Isle of Palms |South Carolina|29451     |United States|          |               |                     |                 |         |       |       |
      |           |         |Sibling  |                                 |           |                |              |         |               |              |              |          |             |          |               |                     |                 |         |       |       |
    And I verify content of the suspended record person 1
    And I verify content of the "0" possible match record person 0
    And I merge duplicates
    And I verify merge preview 0
    And I verify merge preview 2
    And I confirm merge and close
    #to verify this record no longer exists on the duplicates page
    And I navigate to duplicates
    And I validate if "Hayao Miyazaki" record lo longer exists on the duplicates page
    And I search "LastName" on duplicate manager person 0
    And I validate if "Hayao Miyazaki" record lo longer exists on the duplicates page
    #to verify role shows as multiple
    And I navigate to people on records
    And I open a people record by "Miyazaki"
    And I validate if "Hayao Miyazaki"summary opened properly
    And I verify Header Role "Multiple"
    And I navigate to contact
    #to verify the students email address remains primary
    And I verify email address "0" fields
    And I verify email address "1" fields
    #to verify student status after the merge
    Given I click on student status
    And I verify student status group "0" person 0
