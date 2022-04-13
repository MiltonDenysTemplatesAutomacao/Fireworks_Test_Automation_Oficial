#Author: Milton Silva
# Regression testcase TL-266: Person: Required fields

@RequiredFields
Feature: Required Fields for person record

  @RequiredFieldsScenarios
  Scenario: person record required fields via composer and quick add
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
#    And I create a person
#      |Firstname|Lastname |Fullname     |EmailAddress	  |EmailType    |EmailOptInMethod  |Role1	  |StudentType |StudentStatusCategory|StudentStatus  |StudentStatusDate|EntryTerm|
#      |Peter    |Murphy   |Peter Murphy |PMurphy@music.com |Personal    |Inquiry           |Student   |Freshman    |Applicant            |Waitlisted     |03/15/2020       |Fall 2020|
    When I navigate to people on records
    And I click on create record
    And I click on save record button
    Then I validate if "The First Name field is required." message alert required is correct
    Then I validate if "The Last Name field is required." message alert required is correct
    Then I validate if "A complete Address, Email, or Phone is required to create a record." message alert required is correct
    Then I validate if "The Role field is required." message alert required is correct
    And I close alert person modal
