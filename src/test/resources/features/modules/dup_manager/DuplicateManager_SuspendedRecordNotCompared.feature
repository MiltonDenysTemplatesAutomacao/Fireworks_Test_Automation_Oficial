#Author: Milton Silva
#Regression testcase TL-184: Comparison to Suspended Records

@ComparisonToSuspendedRecords
Feature: Comparison to Suspended Records

  @ComparisonToSuspendedRecordsScenario @Done @DupManager
  Scenario: Record - DupManager - verify incoming or updated records are not matched against suspended records
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to add a person record
    When I create a person
      |FirstName  |LastName |Role1    |Phone         |PhoneType|StudentType|StudentStatus    |StudentStatusCategory |StudentStatusDate|EntryTerm|
      |Yasuzo     |Masumura |Student  |(217) 593-7256|Home     |Freshman   |Active-Deposited |Deposited             |07/01/2020       |Fall 2020|
    And I validate if "Person has been created." message is correct
    #person2 to become suspended
    When I create a person
      |FirstName  |LastName |Role1    |Phone         |PhoneType|StudentType|StudentStatus    |StudentStatusCategory |StudentStatusDate|EntryTerm|EmailAddress                           |EmailType|EmailOptInMethod|
      |Yasuzo     |Masumura |Student  |(217) 593-7256|Home     |Freshman   |Active-Deposited |Deposited             |07/01/2020       |Fall 2020|YMasumura@japanesenewwavedirectors.net |Personal |Inquiry         |
    And I validate if "A potential duplicate Student record was found while creating this record; it has been placed in the Duplicate Manager for review." message is correct
    #incoming person3 to not be matched against suspended person2
    When I create a person
      |FirstName  |LastName |Role1    |StudentType|StudentStatus    |StudentStatusCategory |StudentStatusDate|EntryTerm|EmailAddress                           |EmailType|EmailOptInMethod|
      |Yasuzo     |Masumura |Student  |Freshman   |Active-Deposited |Deposited             |07/01/2020       |Fall 2020|YMasumura@japanesenewwavedirectors.net |Personal |Inquiry         |
    And I validate if "Person has been created." message is correct
    #updating person3 will not cause a potential match to suspended person2
    And I validate if "Yasuzo Masumura"summary opened properly
    And I navigate to contact
    And I update email on contact for person "", "", "", "", "", "Edit to existing record does not cause potential match to a suspended record", "", "" and group "0"
    And I click on save changes in contact for person
    And I validate if "Person has been updated." message is correct
    #making suspended person2 active and resaving the record will now cause a potential match to person3
    And I navigate to duplicates
    And I use datatable
      |FirstName  |LastName |Role1    |Phone         |PhoneType|StudentType|StudentStatus    |StudentStatusCategory |StudentStatusDate|EntryTerm|EmailAddress                           |EmailType|EmailOptInMethod|
      |Yasuzo     |Masumura |Student  |(217) 593-7256|Home     |Freshman   |Active-Deposited |Deposited             |07/01/2020       |Fall 2020|                                       |         |                |
      |Yasuzo     |Masumura |Student  |(217) 593-7256|Home     |Freshman   |Active-Deposited |Deposited             |07/01/2020       |Fall 2020|YMasumura@japanesenewwavedirectors.net |Personal |Inquiry         |
      |Yasuzo     |Masumura |Student  |              |         |Freshman   |Active-Deposited |Deposited             |07/01/2020       |Fall 2020|YMasumura@japanesenewwavedirectors.net |Personal |Inquiry         |
    And I search "LastName" on duplicate manager person 1
    And I open a duplicate
    And I verify content of the suspended record person 1
    And I verify content of the "0" possible match record person 0
    And I make suspended record active
    When I quick search "YMasumura@japanesenewwavedirectors.net" from header
    Then I validate if result for "FirstName" is correct
    Then I validate if result for "LastName" is correct
    When I open a record
    And I validate if "Yasuzo Masumura"summary opened properly
    And I navigate to contact
    And I update email on contact for person "", "", "", "", "", "Edit to record after making active", "", "" and group "0"
    And I click on save changes in contact for person
    And I validate if "A potential duplicate Student record was found while creating this record; it has been placed in the Duplicate Manager for review." message is correct
