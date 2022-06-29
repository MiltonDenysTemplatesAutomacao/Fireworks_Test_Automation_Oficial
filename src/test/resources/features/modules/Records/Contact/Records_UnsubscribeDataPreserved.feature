#Author: Milton Silva
#Regression testcase TL-985: Unsubscribed Data is preserved

@UnsubscribedDataIsPreserved
Feature: Unsubscribed Data is preserved

  @UnsubscribedDataIsPreservedPerson @Done
  Scenario: Record - Contact - verify that active and primary indicators are correct in Contact
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |EmailAddress          |EmailType|EmailOptInMethod |Role1   |StudentType|StudentStatus|StudentStatusCategory|StudentStatusDate|EntryTerm  |
      |Sarah      |Goode    |sgoode@cabinetbed.com |Personal |Inquiry          |Student |Freshman   |Accepted     |Accepted             |10/24/2016       |Fall 2017  |
    And I validate if "Person has been created." message is correct
    And I go to Home page
    And I go to Home page
    When I quick search "FirstName"
    And I open a record
    And I validate if "Sarah"summary opened properly
    And I navigate to contact
    #to set the person email opt-in status to Unsubscribe and verify hover over messages would indicate it can not be deleted
    And I update email on contact for person "", "", "", "", "Unsubscribed", "", "", "" and group "0"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    Then I validate in source message "This Person record must be kept to preserve unsubscribed data."
    Then I validate in source message "This email address must be kept to preserve unsubscribe data"


  @UnsubscribedDataIsPreservedOrganization @Done
  Scenario: Record - Basic - verify data can be added to the basic panel of a student record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name					   |Role       |Address1		  |City  |State     |PostalCode |Country      |Phone          |PhoneType|Address2 |Address3 |Address4 |
      |Cabinet Maker Academy   |High School|6305 E Colfax Ave |Denver|Colorado  |80220      |United States|1-720-839-6304 |Business |Address 2|Address 3|Address 4|
    And I validate if "Organization has been created." message is correct
    And I validate if "Cabinet Maker Academy"summary opened properly
    And I navigate to contact
    And I click on create a new email on contact for organization "mycab@cabinets.com", "Business", "", "Application", "", "", "", "" group "0"
    And I click on save changes in contact for organization
    And I close alert if return this message "Organization has been updated."
    #to set the org email opt-in status to Unsubscribe and verify hover over messages would indicate it can not be deleted
    And I click on create a new email on contact for organization "", "", "", "", "Unsubscribed", "", "", "" group "0"
    And I click on save changes in contact for organization
    And I close alert if return this message "Organization has been updated."
    And I navigate to contact
    Then I validate in source message "This Organization record must be kept to preserve unsubscribed data."
    Then I validate in source message "This email address must be kept to preserve unsubscribe data"

