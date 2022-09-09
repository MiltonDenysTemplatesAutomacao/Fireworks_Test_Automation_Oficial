#Author: Milton Silva
#Regression testcase TL-930: Email Status: Update to Valid changes all matching emails

@UpdateValidChangesAllMatchingEmails
Feature: Update to Valid changes all matching emails

  @UpdateValidChangesAllMatchingEmailsScenarios @Done @Contact
  Scenario: Record Person - Contact - updating a bounced email address to valid updates matching emails
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName    |LastName   |EmailAddress         |EmailType  |EmailOptInMethod |Role1  |
      |Konstantin   |Shayne     |KShayne@actors.com   |Personal   |Inquiry          |Person |
    And I validate if "Person has been created." message is correct
    #to create record2
    And I navigate to QuickAddCreatePersonPage
    And I quick add a person
      |FirstName|LastName	|EmailAddress		   |EmailType  |EmailOptInMethod  |Role1	|
      |Margaret	|Brayton	|MegBrayton@actors.com |Personal   |Inquiry			  |Person	|
    And I clickQuickAddPersonSaveAndGo
    And I validate if "Person has been created." message is correct
    #to add a bounced email address which matches the email of record1
    And I navigate to people on records
    And I open a people record by "Margaret"
    Then I validate if "Margaret Brayton"summary opened properly
    And I navigate to contact
    And I add a new email on contact for person group "0"
    And I update email on contact for person "KShayne@actors.com", "Personal", "Bounce", "Inquiry", "", "", "1", "" and group "1"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    #the bounced email address has active and primary flags OFF
    And I verify email address "KShayne@actors.com", "Personal", "Bounce", "Inquiry", "", "", "", "0", "0" group "1"
    #record1 email address was updated to bounced with active and primary flags OFF
    And I navigate to people on records
    And I open a people record by "Shayne"
    Then I validate if "Konstantin Shayne"summary opened properly
    And I navigate to contact
    And I verify email address "KShayne@actors.com", "Personal", "Bounce", "Inquiry", "", "", "", "0", "0" group "0"
    #to update the email status to valid
    And I update email on contact for person "", "", "Valid", "", "", "", "", "" and group "0"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    #the email address displays as valid with active and primary flags ON
    And I verify email address "KShayne@actors.com", "", "Valid", "", "", "", "", "1", "1" group "0"
    #record2 matching email was also updated to valid
    And I navigate to people on records
    And I open a people record by "Margaret"
    Then I validate if "Margaret Brayton"summary opened properly
    And I navigate to contact
    And I verify email address "", "", "Valid", "", "", "", "", "1", "" group "0"
    And I verify email address "", "", "Valid", "", "", "", "", "1", "" group "1"


