#Author: Milton Silva
#Regression testcase TL-883: Phone number with invalid country code will be saved as is

@InvalidAreaCodeNotFormatted
Feature: Invalid Area Code Not Formatted

  @InvalidAreaCodeNotFormatted @Done
  Scenario: Record - Contact - phone number with invalid area code is not formatted
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |Phone        |PhoneType|Address1         |City       |State  |PostalCode |Country       |Role1  |
      |JDonald    |Crisp    |(011)439-4697|Home     |242 Bedford Court|Fort Myers |Florida|33905      |United States |Person |
    And I validate if "Person has been created." message is correct
    And I go to Home page
    When I quick search "FirstName"
    And I open a record
    And I validate if "JDonald"summary opened properly
    And I navigate to contact
    And I verify phone number on contact for person "(011)439-4697", "Home", "", "", "", "", "", "", "1", "1", group "0"
    And I verify phone read only group "0"
