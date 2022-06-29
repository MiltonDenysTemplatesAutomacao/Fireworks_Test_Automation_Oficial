#Author: Milton Silva
#Regression testcase TL-266: Person: Required fields

@RequiredFieldsPerson
Feature: Required Fields for person record

  @RequiredFieldsViaComposer @Done
  Scenario: Record - Person - person record required fields via composer and quick add
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I navigate to people on records
    And I click on create record
    And I click on save record button
    Then I validate if "The First Name field is required." message alert required is correct
    And I validate if "The Last Name field is required." message alert required is correct
    And I validate if "A complete Address, Email, or Phone is required to create a record." message alert required is correct
    And I validate if "The Role field is required." message alert required is correct
    And I close alert person modal
    And I update people composer
      |FirstName|LastName |EmailAddress	     |EmailType   |EmailOptInMethod  |Role1	  |StudentType |StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Peter    |Murphy   |PMurphy@music.com |Personal    |Inquiry           |Student |Freshman    |Applicant             |Waitlisted     |03/15/2020       |Fall 2020|
    And I click on save record button
    Then I validate if "Person has been created" message is correct

  @RequiredFieldsQuickAddPerson @Done
  Scenario: Record - Person - validate required fields for quick add person
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to QuickAddCreatePersonPage
    And I clickQuickAddPersonSaveAndGo
    Then I validate if "The First Name field is required." message alert required is correct
    And I validate if "The Last Name field is required." message alert required is correct
    And I validate if "A complete Address, Email, or Phone is required to create a record." message alert required is correct
    And I validate if "The Role field is required." message alert required is correct



