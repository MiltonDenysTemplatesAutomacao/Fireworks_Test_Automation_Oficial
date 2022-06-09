#Author: Milton Silva
#Regression testcase TL-402: Actions: Required Fields

@ActionsRequiredFields
Feature: Actions Required Fields

  @ActionsRequiredFieldsPerson
  Scenario: Record - Actions - verify fields can be added to the summary panel from an organization record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName	|LastName |EmailAddress	      |EmailType  |EmailOptInMethod  |Role1   |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|ActionDateField |Staff        |Category      |Action                      |
      |Ellison      |Brown    |GBrown@runners.com |Personal   |Inquiry           |Student | Freshman  |Accepted              |Accepted       |4/25/2018        |Fall 2017|''              |             |              |                            |
      |             |         |                   |           |                  |        |           |                      |               |                 |         |12/12/2012      |             |              |                            |
      |             |         |                   |           |                  |        |           |                      |               |                 |         |                |Fire Starter |              |                            |
      |             |         |                   |           |                  |        |           |                      |               |                 |         |                |             |Campus Events |                            |
      |             |         |                   |           |                  |        |           |                      |               |                 |         |                |             |              |Admitted Student Day: Attend|
    Then I validate if "Person has been created" message is correct
    Given I go to Home page
    And I quick search "FirstName"
    And I validate if "Ellison"summary opened properly
    When I open a record
    And I navigate to Actions
    And I click on add action button
    And I update action person "0"
    Then I click on Save Changes button in Actions
    #validation messages are returned for all required fields
    Then I validate if "The Category field is required." message required for person record is correct
    And I validate if "The Action field is required." message required for person record is correct
    And I validate if "The Staff field is required." message required for person record is correct
    And I validate if "The Date field is required." message required for person record is correct
    And I update action person "1"
    And I click on Save Changes button in Actions
    #the remaining required fields are validated'
    Then I validate if "The Category field is required." message required for person record is correct
    And I validate if "The Action field is required." message required for person record is correct
    And I validate if "The Staff field is required." message required for person record is correct
    And I click on close button on modal
    And I update action person "2"
    And I click on Save Changes button in Actions
    #the remaining required fields are validated
    Then I validate if "The Category field is required." message required for person record is correct
    And I validate if "The Action field is required." message required for person record is correct
    And I click on close button on modal
    And I update action person "3"
    And I click on Save Changes button in Actions
    #the remaining required fields are validated
    And I validate if "The Action field is required." message required for person record is correct
    And I click on close button on modal
    And I update action person "4"
    And I click on Save Changes button in Actions
    Then I validate if "Action has been created." message is correct
