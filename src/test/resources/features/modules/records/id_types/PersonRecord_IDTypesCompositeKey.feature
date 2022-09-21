#Author: Milton Silva
#Regression testcase TL-364 (1 of 2): ID Types: Composite Key
#Regression testcase TL-364 (2 of 2): ID Types: Composite Key

@IDTypesCompositeKey
Feature: ID Types: Composite Key

  @IDTypesCompositeKeyPerson @Done @IDTypes
  Scenario: Record - ID Types - verify adding a duplicate external id returns composite key validation
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName  |LastName |EmailAddress               |EmailType  |EmailOptInMethod  |Role1   |StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm  |StudentType|IdRecordedDate|IDType        |IDNumber|WhoAddedID   |
      |Thomas     |Edison    |thomasedison@thirdrail.com|Personal   |Inquiry           |Student |Accepted             |Accepted         |09/28/2016       |Fall 2017  |Freshman   |09/27/2016    |Universal App |8675309 |Fire Starter |
    And I validate if "Person has been created" message is correct
    And I validate if "Thomas"summary opened properly
    And I navigate to ID Types
    And I update External Id group "0" person 0
    And I click on external ID SaveChanges button
    And I close alert if return this message "Person has been updated."
    When I add an External ID "0"
    And I update External Id group "1" person 0
    And I click on external ID SaveChanges button
    And I verify validation message "External ID Types 2: Type must be different."
    And I verify validation message "External ID Types 2: ID Number must be different."
    And I click on clear changes

  @IDTypesCompositeKeyOrganization @Done @IDTypes
  Scenario: Record - Employment - verify that adding a duplicate id returns an error message
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name			  |Role	       |Address1		           |City	     |State	         |PostalCode |Country	   |IDType|IDNumber|WhoAddedID  |
      |Classic Gulf   |Institution |38111 Old Statesville Road |Huntersville |North Carolina |28078      |United States|CEEB  |91193   |Fire Starter|
    Then I validate if "Organization has been created." message is correct
    And I validate if "Classic Gulf"summary opened properly
    And I navigate to ID Types
    And I update External Id group "0" person 0
    And I click on external ID SaveChanges button
    And I close alert if return this message "Organization has been updated."
    When I add an External ID "0"
    And I update External Id group "1" person 0
    And I click on external ID SaveChanges button
    And I verify validation message "External ID 2: ID Type must be different."
    And I verify validation message "External ID 2: ID Number must be different."
    And I click on clear changes


