#Author: Milton Silva
#Regression testcase TL-69: Contact Field Groups 1st record is Primary and Active
#Regression testcase TL-1077: County field auto-populated
#Regression testcase TL-1005 (1 of 2): Phone Opt-In Status is not required

@ContactPrimaryActiveFlags
Feature: Exact match auto-merge on rule 5: IDType-ID-LastName,Email recipients can be merged,Actions are not shared

  @ContactPrimaryActiveFlagsScenario
  Scenario: Record - Contact - verify that active and primary indicators are correct in Contact
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |EmailAddress      |EmailType|EmailOptInMethod |Role1   |StudentType|StudentStatus|StudentStatusCategory|StudentStatusDate|EntryTerm  |Active|Primary|
      |John       |Hooker   |JHooker@music.com |Personal |Inquiry          |Student |Freshman   |Accepted     |Accepted             |07/15/2020       |Spring 2021|1     |1      |
      |           |         |JHooker2@music.com |School   |Inquiry          |        |           |             |                     |                 |           |1     |0      |
    And I validate if "Person has been created." message is correct
    And I go to Home page
    When I quick search "FirstName"
    And I open a record
    And I validate if "John"summary opened properly
    And I navigate to contact
    And I verify email address "0" fields
    When I update phone number in contact for person "(718) 846-9156", "Home", "", "", "", "", "", "" field group "0"
    And I create address on contact for person "243 Saxton Circle", "", "", "", "Powell", "Tennessee", "", "United States", "37849", "Mailing", "", "", "", "", group "0"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    #all of the contact field groups are still marked active and primary
    And I verify phone number on contact for person "", "", "", "", "", "", "", "", "1", "1", group "0"
    And I verify email address "0" fields
    And I verify name on contact for person "John", "Hooker", "", "", "", "", "1", "1" group "0"
    And I verify email address "0" fields
    And I verify email address "0" fields
    And I verify phone number on contact for person "(718) 846-9156", "Home", "", "", "", "", "", "", "1", "1", group "0"
    #to add a 2nd email address marked active but not primary
    And I add a new email on contact for person group "0"
    And I update email on contact for person "JHooker2@music.com", "School", "", "Inquiry", "", "", "1", "" and group "1"
    And I click on save changes in contact for person
    And I validate if "Person has been updated." message is correct
    And I verify email address "0" fields
    And I verify email address "1" fields
