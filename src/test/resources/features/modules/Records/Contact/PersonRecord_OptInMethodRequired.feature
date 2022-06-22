#Author: Milton Silva
#Regression testcase TL-550 (1 of 2): Email Address: Opt-In Method field

@EmailAddressOptInMethodField
Feature: verify I cannot delete unsubscribed email records

  @EmailAddressOptInMethodFieldScenarios
  Scenario: Record - Contact - verify the opt in method is required for person records
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName|LastName |Role1    |EmailAddress      |EmailType |
      |Willie   |Nelson   |Sibling  |WNelson@music.com |Personal  |
    #to try to create a record without an opt-in method
    Then I validate if "The Email Opt-In Method field is required." message alert required is correct
    #to add an opt-in method on the modal page
    And I add an opt-in method "Inquiry"
    And I clickQuickAddPersonSaveAndGo
    Then I validate if "Person has been created" message is correct
    #to verify the email includes the opt-in method
    And I go to Home page
    When I quick search "FirstName"
    And I open a record
    And I validate if "Willie"summary opened properly
    And I navigate to contact
    And I verify email address "WNelson@music.com", "Personal", "", "Inquiry", "", "", "", "1", "1" group "0"
    #to remove the opt-in method
    And I update email on contact for person "", "", "", "Inquiry", "", "", "", "" and group "0"
    And I click on save changes in contact for person
    And I verify validation message "The Email Opt-In Method field is required."
    And I click on close button on modal
    #to add opt-in method back
    And I update email on contact for person "", "", "", "Inquiry", "", "", "", "" and group "0"
    And I click on save changes in contact for person
    Then I validate if "Person has been updated." message is correct
    And I close alert if return this message "Person has been updated."
    #to add email2 without an opt-in method
    And I add a new email on contact for person group "0"
    And I update email on contact for person "WNelson2@music.com", "School", "", "", "", "", "", "" and group "1"
    And I click on save changes in contact for person
    And I verify validation message "Email Address 2: The Email Opt-In Method field is required."
    And I click on close button on modal
    #to update the opt-in method of email2 and remove the opt-in from email1
    And I update email on contact for person "", "", "", "Inquiry", "", "", "", "" and group "1"
    And I click on save changes in contact for person
    Then I validate if "Person has been updated." message is correct
    #to verify email1 and email2 contain all expected values
    And I verify email address "WNelson@music.com", "Personal", "", "Inquiry", "", "", "", "1", "1" group "0"
    And I verify email address "WNelson2@music.com", "School", "", "Inquiry", "", "", "", "0", "0" group "1"










