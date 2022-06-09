#Author: Milton Silva
#Regression testcase TL-115: Basic: Time Zone

@BasicTimeZone
Feature: Basic: Time Zone

  @BasicTimeZoneScenario
  Scenario: Record - Basic - verify the setting and updating of a student record time zone
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |EmailAddress        |EmailType|EmailOptInMethod |Role1   |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm  |PhoneType|Phone        |
      |Elvis      |Costello  |ECostello@music.com |Personal |Inquiry          |Student |Freshman   |Accepted             |Accepted     |01/15/2016       |Fall 2017  |Fax      |904-555-5561 |
    #And I validate if "Person has been created." message is correct
    #to update context values in basic page
    And I go to Home page
    When I quick search "FirstName"
    And I open a record
    And I validate if "Elvis"summary opened properly
    And I navigate to basic
    And I update context values "(GMT-08:00) Alaska", "", ""
    And I click on save changes on basic
    #And I validate if "Person has been updated." message is correct
    And I verify context values "(GMT-08:00) Alaska", "", ""
    #to add a 2nd phone
    And I navigate to contact
    And I add phone "0"
    When I update phone number in contact for person "(904) 555-5562", "Business", "", "", "", "", "", "" field group "1"
