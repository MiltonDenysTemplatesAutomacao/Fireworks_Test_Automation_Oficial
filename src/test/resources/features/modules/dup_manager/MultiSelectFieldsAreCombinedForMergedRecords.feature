#Author: Milton Silva
#Regression testcase TL-228: Multi-select fields are Combined for Merged Records

@MultiSelectFieldsAreCombinedForMergedRecords
Feature: Multi-select fields are Combined for Merged Records

  @PotentialMatchRacesRolesMerged @Done @DupManager
  Scenario: DupManager - verify multi-select fields are combined for merged records
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to add a person record
    When I create a person
      |FirstName  |LastName     |Role1   |EmailAddress             |EmailType  |EmailOptInMethod|
      |Aleksandr  |Kaydanovskiy |Person  |AKaydanovskiy@actors.com |Personal   |Inquiry         |
    And I validate if "Person has been created." message is correct
    #to add data to basic tab
    And I navigate to people on records
    And I open a people record by "Aleksandr Kaydanovskiy"
    And I validate if "Aleksandr Kaydanovskiy"summary opened properly
    And I verify Header Role "Person"
    And I navigate to basic
    And I update birth values "07/23/1946", "", "", ""
    And I update culture values "", "Asian", "", "", "", ""
    And I click on save changes on basic
    Then I close alert if return this message "Person has been updated."
    #to add another person record
    When I create a person
      |FirstName  |LastName     |Role1       |Phone          |PhoneType|
      |Aleksandr  |Kaydanovskiy |Volunteer   |(574) 526-5841 |Fax      |
    And I validate if "Person has been created." message is correct
    #to add data to basic tab
    And I navigate to people on records
    And I open a people record by "Aleksandr Kaydanovskiy"
    And I validate if "Aleksandr Kaydanovskiy"summary opened properly
    And I verify Header Role "Person"
    And I navigate to basic
    And I update culture values "", "Native Hawaiian or Other Pacific Islander", "", "", "", ""
    And I update culture values "", "White", "", "", "", ""
    And I click on save changes on basic
    Then I close alert if return this message "Person has been updated."
    #to add the same birth date to trigger a potential match
    And I navigate to basic
    And I update birth values "07/23/1946", "", "", ""
    And I click on save changes on basic
    Then I close alert if return this message "A potential duplicate Person record was found while creating this record; it has been placed in the Duplicate Manager for review."
    #to merge the records
    And I use datatable
      |FirstName  |LastName     |Role1      |Phone          |PhoneType|EmailAddress             |EmailType  |EmailOptInMethod|
      |Aleksandr  |Kaydanovskiy |Person     |               |         |AKaydanovskiy@actors.com |Personal   |Inquiry         |
      |Aleksandr  |Kaydanovskiy |Volunteer  |(574) 526-5841 |Fax      |                         |           |                |
    And I verify content of the suspended record person 1
    And I verify content of the "0" possible match record person 0
    And I merge duplicates
    And I verify merge preview 1
    And I confirm merge and go
    #to verify the merged record
    And I validate if "Aleksandr Kaydanovskiy"summary opened properly
    And I verify Header Role "Multiple"
    And verify if "Person" role are selected
    And verify if "Volunteer" role are selected
    And I navigate to basic
    And I verify birth values "07/23/1946", "", "", ""
    And I verify culture values "", "Asian", "", "", "", ""
    And I verify culture values "", "White", "", "", "", ""
    And I verify culture values "", "Native Hawaiian or Other Pacific Islander", "", "", "", ""
