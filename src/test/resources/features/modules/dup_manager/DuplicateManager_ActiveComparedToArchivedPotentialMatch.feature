#Author: Milton Silva
#Regression testcase TL-186 (3 of 3): Comparison to Archived Records

@ComparisonToArchivedRecords
Feature: Comparison to Archived Records

  @ComparisonToArchivedRecordsScenarios @Done @DupManager
  Scenario: DupManager - Exact match - SSN + Last Name
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |Role1     |StudentType|StudentStatusCategory |StudentStatus   |StudentStatusDate|EntryTerm|Phone        |PhoneType|Address1                 |City         |State  |PostalCode|Country       |
      |France     |Loesser   |Student   |Freshman   |Inquiry               |Inquiry-Active  |09/01/2019       |Fall 2020|904-724-3399 |Home     |6215 South Franklin Road |Indianapolis |Indiana|46259     |United States |
    And I validate if "Person has been created." message is correct
    And I validate if "France Loesser"summary opened properly
    And I verify Header Record Status "Active" for person
    And I update Header Record Status "Archived" for person
    And I close alert if return this message "Person has been updated."
    And I verify Header Record Status "Archived" for person
    #to create a second non-matching higher value student record then update address and phone to create a potential match
    When I create a person
      |FirstName  |LastName  |Role1     |StudentType|StudentStatusCategory   |StudentStatus   |StudentStatusDate|EntryTerm|EmailAddress             |EmailType|EmailOptInMethod|
      |Frank      |Loesser   |Student   |Freshman   |Applicant               |Complete        |11/01/2019       |Fall 2020|FLoesser@tinpanalley.com |Personal |Inquiry         |
    And I validate if "Person has been created." message is correct
    And I validate if "Frank Loesser"summary opened properly
    And I verify Header Record Status "Active" for person
    And I navigate to contact
    And I create address on contact for person "6215 South Franklin Road", "", "", "", "Indianapolis", "Indiana", "", "United States", "46259", "Mailing", "", "", "", "", group "0"
    When I update phone number in contact for person "(904) 724-3399", "Home", "", "", "", "", "", "" field group "0"
    And I click on save changes in contact for person
    And I close alert if return this message "A potential duplicate Student record was found while creating this record; it has been placed in the Duplicate Manager for review."
    #to verify the suspended and possible match records then merge those records
    And I use datatable
      |FirstName  |LastName  |Role1     |Phone          |Address1                 |City         |State  |PostalCode|Country       |EmailAddress             |
      |France     |Loesser   |Student   |(904) 724-3399 |6215 South Franklin Road |Indianapolis |Indiana|46259     |United States |                         |
      |Frank      |Loesser   |Student   |               |                         |             |       |          |              |FLoesser@tinpanalley.com |
    And I verify content of the suspended record person 1
    And I verify content of the "0" possible match record person 0
    And I merge duplicates
    And I verify merge preview 1
    And I confirm merge and close
    #to verify the merged records no longer show on the duplicates page
    And I validate if "Loesser" record lo longer exists on the duplicates page
    And I validate if "France" record lo longer exists on the duplicates page
    And I validate if "Frank" record lo longer exists on the duplicates page
    #navigate back to duplicate page and verify that the merged records no longer show even after a search
    And I navigate to duplicates
    And I validate if "Loesser" record lo longer exists on the duplicates page
    And I validate if "France" record lo longer exists on the duplicates page
    And I validate if "Frank" record lo longer exists on the duplicates page
    And I search "LastName" on duplicate manager person 1
    And I validate if "Loesser" record lo longer exists on the duplicates page
    And I validate if "France" record lo longer exists on the duplicates page
    And I validate if "Frank" record lo longer exists on the duplicates page
    #verify the older record no longer exists on the Person Page
    And I navigate to people on records
    And I search "Boone" on people page manager
    And I validate if "No search results to display." message on datatable is displayed
    #verify proper merge values and active status for merged record
    And I open a people record by "Loesser"
    And I validate if "Frank Loesser"summary opened properly
    And I verify Header Record Status "Active" for person


