#Author: Milton Silva
#Regression testcase TL-698: Email Address field group validation

@EmailAddressFieldGroupValidation
Feature: verify I cannot delete unsubscribed email records

  @EmailAddressFieldGroupValidationScenarios
  Scenario: Record - Contact - verify the Contact email address group is validated correctly
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName|LastName |Role1    |Phone         |PhoneType |StudentType|StudentStatus|StudentStatusCategory|StudentStatusDate|EntryTerm  |
      |David    |Hussey   |Student  |(512) 249-5214|Business  |Freshman   |Accepted     |Accepted             |09/20/2016       |Fall 2017  |
    And I validate if "Person has been created." message is correct
    #to enter only the email address
    And I go to Home page
    When I quick search "FirstName"
    And I open a record
    And I validate if "David"summary opened properly
    And I navigate to contact
    And I update email on contact for person "dhussey@mcdowells.com", "", "", "", "", "", "", "" and group "0"
    And I click on save changes in contact for person
    And I verify validation message "The Email Type field is required."
    And I verify validation message "The Email Opt-In Method field is required."
    And I click on close button on modal
    And I click on clear changes
    #to provide required data except for the email address
    And I update email on contact for person "", "School", "", "Inquiry", "", "", "", "" and group "0"
    And I click on save changes in contact for person
    And I verify validation message "The Email Address field is required"
    And I click on close button on modal
    #to provide all required data
    And I update email on contact for person "dhussey@mcdowells.com", "", "", "", "", "", "", "" and group "0"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    #to verify email address is read only and status defaults to valid
    Then I verify read only email "0"
    And I verify email address "dhussey@mcdowells.com", "", "", "", "", "", "", "", "" group "0"





