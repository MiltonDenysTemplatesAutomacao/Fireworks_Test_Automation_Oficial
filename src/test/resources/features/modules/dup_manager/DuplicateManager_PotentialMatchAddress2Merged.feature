#Author: Milton Silva
#Regression testcase TL-169 rule 13: LN-Email-PostalCode
#Regression testcase TL-485: Winning Incoming Address 2 Value Not Dropped

@PotentialMatchAddress2Merged
Feature: Comparison to Staff Records

  @PotentialMatchAddress2MergedScenario @Done @DupManager
  Scenario: DupManager - Address2 is included in merged addresses
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to add a person record
    When I create a person
      |FirstName  |LastName   |Role1    |StudentType|StudentStatus |StudentStatusCategory |StudentStatusDate|EntryTerm|EmailAddress                |EmailType|EmailOptInMethod|Address1          |City   |State   |PostalCode|Country      |
      |Hoagy      |Carmichael |Student  |Freshman   |Inquiry-Active|Inquiry               |01/25/2020       |Fall 2020|h.carmichael@composers.com  |Personal |Inquiry         |562 Pleasant Dr W.|Chicago|Illinois|60621     |United States|
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName  |LastName   |Role1    |StudentType|StudentStatus |StudentStatusCategory |StudentStatusDate|EntryTerm|EmailAddress                |EmailType|EmailOptInMethod|Address1          |Address2|City   |State   |PostalCode|Country      |
      |Hoagland   |Carmichael |Student  |Freshman   |Complete      |Applicant             |01/25/2020       |Fall 2020|h.carmichael@composers.com  |Other    |Campus Visit    |562 Pleasant Dr W.|Unit 6  |Chicago|Illinois|60621     |United States|
    And I validate if "A potential duplicate Student record was found while creating this record; it has been placed in the Duplicate Manager for review." message is correct
    #to verify the suspended and possible match records then merge those records
    And I use datatable
      |FirstName  |LastName   |Role1    |EmailAddress                |Address1          |Address2|City   |State   |PostalCode|Country      |
      |Hoagy      |Carmichael |Student  |h.carmichael@composers.com  |562 Pleasant Dr W.|        |Chicago|Illinois|60621     |United States|
      |Hoagland   |Carmichael |Student  |h.carmichael@composers.com  |562 Pleasant Dr W.|Unit 6  |Chicago|Illinois|60621     |United States|
    And I verify content of the suspended record person 1
    And I verify content of the "0" possible match record person 0
    And I merge duplicates
    And I verify merge preview 1
    And I confirm merge and go
    #to verify the address 1 is correct and address 2 does not exist
    And I validate if "Hoagland Carmichael"summary opened properly
    And I navigate to contact
    And I verify address on contact por person "562 Pleasant Dr W", "Unit 6", "", "", "Chicago", "", "Illinois", "", "United States", "60621", "IL11", "Home", "", "", "1", "1" group "0"
    And I verify if there is no Address group "1"