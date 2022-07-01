#Author: Milton Silva
#Regression testcase TL-614: Time Zone: Updated based on Primary Address

@TimeZoneUpdatedBasedPrimaryAddress
Feature: Time Zone: Updated based on Primary Address

  @TimeZoneUpdatedBasedPrimaryAddressScenarios @Done
  Scenario: Record - Contact - Phone time zone - multiple physical addresses
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName|LastName |Role1   |Phone         |PhoneType |
      |Muddy    |Waters   |Person  |(904) 721-1894|Home      |
    And I validate if "Person has been created." message is correct
    #adding a physical address updates the phone time zone
    And I go to Home page
    When I quick search "FirstName"
    And I open a record
    And I validate if "Muddy"summary opened properly
    And I navigate to contact
    And I create address on contact for person "19 S 22nd St", "", "", "", "Philadelphia", "Pennsylvania", "", "United States", "19103", "Mailing", "", "", "1", "1", group "0"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    And I verify address on contact por person "19 S 22nd St", "", "", "", "Philadelphia", "", "Pennsylvania", "", "United States", "19103", "", "Mailing", "", "", "1", "1" group "0"
    And I verify phone number on contact for person "(904) 721-1894", "Home", "", "(GMT-04:00) Eastern Time (US & Canada)", "", "", "", "", "1", "1", group "0"
    #adding a not-primary physical address does not update the phone time zone
    And I add address "0"
    And I create address on contact for person "1007 York Street", "", "", "", "Denver", "Colorado", "", "United States", "80206", "Mailing", "", "", "1", "", group "1"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    And I verify address on contact por person "19 S 22nd St", "", "", "", "Philadelphia", "", "Pennsylvania", "", "United States", "19103", "", "Mailing", "", "", "1", "1" group "0"
    And I verify address on contact por person "1007 York Street", "", "", "", "Denver", "", "Colorado", "", "United States", "80206", "", "Mailing", "", "", "1", "0" group "1"
    #updating the second physical address to be primary updates the phone time zone
    And I create address on contact for person "", "", "", "", "", "", "", "", "", "", "", "", "", "1", group "1"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    And I verify address on contact por person "1007 York Street", "", "", "", "Denver", "", "Colorado", "", "United States", "80206", "", "Mailing", "", "", "1", "1" group "0"
    And I verify phone number on contact for person "(904) 721-1894", "Home", "", "(GMT-06:00) Mountain Time (US & Canada)", "", "", "", "", "1", "1", group "0"
    And I verify address on contact por person "19 S 22nd St", "", "", "", "Philadelphia", "", "Pennsylvania", "", "United States", "19103", "", "Mailing", "", "", "1", "0" group "1"
    #adding a third physical address as primary updates the phone time zone
    And I add address "1"
    And I create address on contact for person "886 Cannery Row", "", "", "", "Monterey", "California", "", "United States", "93940", "Mailing", "", "", "1", "1", group "2"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    And I verify phone number on contact for person "(904) 721-1894", "Home", "", "(GMT-07:00) Pacific Time (US & Canada)", "", "", "", "", "1", "1", group "0"
