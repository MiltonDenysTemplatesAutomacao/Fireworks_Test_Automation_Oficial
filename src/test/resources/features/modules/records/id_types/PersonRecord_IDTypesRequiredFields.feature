#Author: Milton Silva
#Regression testcase TL-336: ID Types: Required Fields

@IDTypesRequiredFields
Feature: ID Types: Visa Number

  @IDTypesRequiredFieldsScenarios @Done @IDTypes
  Scenario: Record - ID Types - ID types required fields
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName  |LastName |EmailAddress        |EmailType  |EmailOptInMethod  |Role1   |StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm  |StudentType|IdRecordedDate|Comments              |IDType    |IDNumber|WhoAddedID   |
      |Granville  |Woods    |gwoods@thirdrail.com|Personal   |Inquiry           |Student |Accepted             |Accepted         |09/28/2016       |Fall 2017  |Freshman   |09/27/2016    |Got your number Jenny |          |        |             |
      |           |         |                    |           |                  |        |                     |                 |                 |           |           |09/27/2016    |Got your number Jenny |Common App|8675309 |Fire Starter |
    And I validate if "Person has been created" message is correct
    #to enter Date and Comments to trigger validation
    And I validate if "Granville"summary opened properly
    And I navigate to ID Types
    And I update External Id group "0" person 0
    And I click on external ID SaveChanges button
    And I verify validation message "The Type field is required."
    And I verify validation message "The ID Number field is required."
    And I verify validation message "The Who Added ID field is required."
    And I click on close button on modal
    And I update External Id group "0" person 1
    And I click on external ID SaveChanges button
    And I close alert if return this message "Person has been updated."


