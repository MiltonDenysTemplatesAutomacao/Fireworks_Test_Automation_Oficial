#Author: Milton Silva
#Regression testcase TL-245: Search by Preferred Name
#Regression testcase TL-247: Search by Social Security Number

@SearchByPreferredNameAndSSN
Feature: Search by preferred

  @SearchPersonByPreferredNameAndSSN
  Scenario: Quick Search - to Quick Search a person by Preferred Name, partial, with or without dashes, spaces or parenthesis
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName|LastName	|Role1	|EmailAddress			|EmailType	|EmailOptInMethod |StudentType|StudentStatus|StudentStatusCategory|StudentStatusDate|EntryTerm|PreferredName        |SSN          |
      |Squire	|Fridell	|Student|sfridell@mcdonalds.com |Personal   |Inquiry          |Freshman   |Accepted     |Accepted             |09/19/2016       |Fall 2017|Honorable Squire Bozo|583-23-9874  |
    And I go to Home page
    When I quick search "FirstName"
    Then I validate if result for "FirstName" is correct
    And I open a record
    And I navigate to basic
    When I update "", "" and "583-23-9874" to update citizenship
    And I click on save changes on basic
    And I navigate to contact
    When I update "", "", "", "PreferredName", "" and "" to update name
    And I go to Home page
    When I quick search "SSN"
    Then I validate if result for "FirstName" is correct
    And I go to Home page
    When I quick search "PreferredName"
    Then I validate if result for "LastName" is correct



