#Author: Milton Silva
#Regression testcase TL-229: Non-student: Resolution Rules for 1:1 Fields

@NonstudentResolutionRulesFor1a1Fields
Feature: Auto Merge: Organization: Matching Rules

  @NonstudentResolutionRulesFor1a1FieldsScenario @Done @DupManager
  Scenario: Record - DupManager - Check resolution rules for Org 1:1
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |Role1    |EmailAddress            |EmailType  |EmailOptInMethod|
      |Anthony    |Tiger     |Person   |tonythetiger@cereal.com |Personal   |Inquiry         |
    And I validate if "Person has been created." message is correct
    And I validate if "Anthony"summary opened properly
    And I navigate to basic
    And I update birth values "07/23/1956", "", "", ""
    And I update culture values "Hispanic / Latino", "Asian", "Male", "Single", "Russian", ""
    And I click on save changes on basic
    Then I close alert if return this message "Person has been updated."
    #to create the second person that will be merged
    When I create a person
      |FirstName  |LastName  |Role1    |EmailAddress            |EmailType  |EmailOptInMethod|
      |Anthony    |Tiger     |Person   |tonythetiger@cereal.com |Personal   |Inquiry         |
    And I validate if "A potential duplicate Person record was found while creating this record; it has been placed in the Duplicate Manager for review." message is correct
    #to merge the records
    And I verify content of the suspended record person 0
    And I verify content of the "0" possible match record person 0
    And I merge duplicates
    And I verify merge preview 0
    And I confirm merge and go
    #verify existing 1:1 fields were not overwritten by null values
    And I validate if "Anthony"summary opened properly
    And I navigate to basic
    And I verify birth values "07/23/1956", "", "", ""
    And I verify culture values "Hispanic / Latino", "Asian", "Male", "Single", "Russian", ""
    #to create the third person
    When I create a person
      |FirstName  |LastName  |Role1    |Phone          |PhoneType   |
      |Anthony    |Tiger     |Person   |(303) 310-6651 |Fax         |
    And I validate if "Person has been created." message is correct
    And I validate if "Anthony"summary opened properly
    And I navigate to basic
    And I update birth values "07/23/1957", "", "", ""
    And I update culture values "", "Native Hawaiian or Other Pacific Islander", "Male", "Married", "English", "Baptist"
    And I click on save changes on basic
    Then I close alert if return this message "Person has been updated."
    #to update contact data that will allow this record to merge
    And I navigate to contact
    And I update email on contact for person "tonythetiger@cereal.com", "Personal", "", "Inquiry", "", "", "", "" and group "0"
    And I click on save changes in contact for person
    And I validate if "A potential duplicate Person record was found while creating this record; it has been placed in the Duplicate Manager for review." message is correct
    And I use datatable
      |FirstName  |LastName  |Role1    |EmailAddress            |
      |Anthony    |Tiger     |Person   |tonythetiger@cereal.com |
    And I verify content of the suspended record person 0
    And I verify content of the "0" possible match record person 0
    And I merge duplicates
    And I verify merge preview 0
    And I confirm merge and go
    #verify existing 1:1 fields were updated during the merge
    And I validate if "Anthony"summary opened properly
    And I navigate to basic
    And I verify birth values "07/23/1957", "", "", ""
    And I verify culture values "Hispanic / Latino", "Native Hawaiian or Other Pacific Islander", "Male", "Married", "English", "Baptist"
    And I verify culture values "", "Asian", "", "", "", ""