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
      |FirstName  |LastName |EmailAddress      |EmailType|EmailOptInMethod |Role1   |StudentType|StudentStatus|StudentStatusCategory|StudentStatusDate|EntryTerm  |
      |John       |Hooker   |JHooker@music.com |Personal |Inquiry          |Student |Freshman   |Accepted     |Accepted             |07/15/2020       |Spring 2021|
    #And I validate if "Person has been created." message is correct
    And I go to Home page
    When I quick search "FirstName"
    And I open a record
    And I validate if "John"summary opened properly
    And I navigate to contact