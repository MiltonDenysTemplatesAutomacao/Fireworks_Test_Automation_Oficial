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
    And I validate if "Person has been created." message is correct
    #to update context values in basic page
    And I go to Home page
    When I quick search "FirstName"
    And I open a record
    And I validate if "Elvis"summary opened properly
    And I navigate to basic
    And I update context values "(GMT-08:00) Alaska", "", ""
    And I click on save changes on basic
    And I validate if "Person has been updated." message is correct
    And I verify context values "", "(GMT-08:00) Alaska", "", ""
    #to add a 2nd phone
    And I navigate to contact
    And I add phone "0"
    When I update phone number in contact for person "(904) 555-5562", "Business", "", "", "", "", "", "" field group "1"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    And I verify phone number on contact for person "(904) 555-5561", "Fax", "", "(GMT-08:00) Alaska", "", "", "", "", "1", "1", group "0"
    And I verify phone number on contact for person "(904) 555-5562", "Business", "", "", "", "", "", "", "", "", group "1"
    #to edit the Basic Time Zone
    And I navigate to basic
    And I update context values "(GMT-07:00) Pacific Time (US & Canada)", "", ""
    And I click on save changes on basic
    And I close alert if return this message "Person has been updated."
    And I verify context values "", "(GMT-07:00) Pacific Time (US & Canada)", "", ""
    #to click Save from the Contact tab and verify the phone time zones were updated
    And I navigate to contact
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    And I verify phone number on contact for person "", "", "", "(GMT-07:00) Pacific Time (US & Canada)", "", "", "", "", "", "", group "0"
    And I verify phone number on contact for person "", "", "", "(GMT-07:00) Pacific Time (US & Canada)", "", "", "", "", "", "", group "1"
    #to add a physical address with a different time zone
    And I create address on contact for person "6421 E 36th St N", "", "", "", "Tulsa", "Oklahoma", "", "United States", "74115", "Mailing", "", "", "", "", group "0"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    #to verify the phone time zones were updated and the basic time zone was updated
    And I verify phone number on contact for person "", "", "", "(GMT-05:00) Central Time (US & Canada)", "", "", "", "", "", "", group "0"
    And I verify phone number on contact for person "", "", "", "(GMT-05:00) Central Time (US & Canada)", "", "", "", "", "", "", group "1"
    And I navigate to basic
    And I verify context values "OK02", "(GMT-05:00) Central Time (US & Canada)", "", ""

