#Author: Milton Silva
#Regression testcase TL-531:Email Address: Opt-In Status and Date

@OptInStatusAndDate
Feature: Email Address: Opt-In Status and Date

  @OptInStatusAndDatePerson @Fix @Contact
  Scenario: Record Person - Contact - verify the email opt-in date is updated during opt-in status changes
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName|LastName   |EmailAddress                    |EmailType  |EmailOptInMethod |Role1 |
      |Scott    |Tenorman   |STenorman@fire-engine-red.com   |Personal   |Inquiry          |Person|
    And I validate if "Person has been created." message is correct
    And I go to Home page
    When I quick search "FirstName"
    And I open a record
    And I validate if "Scott"summary opened properly
    And I navigate to contact
    #to changes Opt-In Status To Either Subscribed or Unsubscribed. Opposite of Current Value.
    And I update email on contact for person "", "", "", "", "Subscribed", "", "", "" and group "0"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    And I update email on contact for person "", "", "", "", "Unsubscribed", "", "", "" and group "0"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    #to verify Todays Date in Opt-In Date
    And I verify email address "", "", "", "", "", "1", "", "", "" group "0"


