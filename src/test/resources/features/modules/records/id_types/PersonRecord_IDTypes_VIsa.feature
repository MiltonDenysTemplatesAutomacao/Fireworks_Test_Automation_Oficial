#Author: Milton Silva
#Regression testcase TL-312: ID Types: Visa Number

@IDTypesVisaNumber
Feature: ID Types: Visa Number

  @IDTypesVisaNumberScenarios @Done @IDTypes
  Scenario: Record - ID Types - visa ID required fields
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName  |LastName   |EmailAddress    |EmailType  |EmailOptInMethod  |Role1   |StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm  |StudentType|IDType|IDNumber|IdRecordedDate|WhoAddedID   |Comments     |
      |Rosetta    |Tharpe    |RTharpe@music.com|Personal   |Inquiry           |Student |Accepted             |Accepted         |01/15/2016       |Fall 2017  |Freshman   |Visa  |78751   |01/27/2016    |Fire Starter |Visa Comment |
    And I validate if "Person has been created" message is correct
    And I navigate to people on records
    And I open a people record by "Rosetta"
    And I validate if "Rosetta"summary opened properly
    And I navigate to ID Types
    And I update External Id group "0" person 0
    And I click on external ID SaveChanges button
    And I close alert if return this message "Person has been updated."
    #to verify the Visa number field was autopopulated
    Then I validate if Visa number is correct
    #to verify the Visa validation messages
    And I click on external ID SaveChanges button
    And I verify validation message "The Visa Entry Term field is required."
    And I verify validation message "The Visa Type field is required."
    And I click on close button on modal
    And I update visa "Fall 2018", "", "F-1 Student" group "0"
    And I click on external ID SaveChanges button
    And I close alert if return this message "Person has been updated."





