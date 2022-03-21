#Author: Milton Silva
#Regression testcase TL-245: Search by Preferred Name
#Regression testcase TL-247: Search by Social Security Number

@SearchByPreferredNameAndSSN
Feature: Search by phone number

  @SearchPersonByPreferredNameAndSSN
  Scenario: to Quick Search a person by Preferred Name, partial, with or without dashes, spaces or parenthesis
    Given I login as firestarter
    And I create a person
      |Firstname|Lastname	|Role1	|EmailAddress			|EmailType	|EmailOptInMethod |StudentType|StudentStatus|StudentStatusCategory|StudentStatusDate|EntryTerm|PreferredName        |SSN          |
      |Squire	|Fridell	|Student|sfridell@mcdonalds.com |Personal   |Inquiry          |Freshman   |Accepted     |Accepted             |09/19/2016       |Fall 2017|Honorable Squire Bozo|583-23-9874  |
    And I go to Home page
    When I quick search "Firstname"
    Then I validate if result for "Firstname" is correct
    And I open a record
    And I navigate to basic
    When I update "", "" and "SSN" to update citizenship
    And I navigate to contact
    When I update "", "", "", "PreferredName", "" and "" to update name
    And I go to Home page
    When I quick search "SSN"
    Then I validate if result for "Firstname" is correct
    And I go to Home page
    When I quick search "PreferredName"
    Then I validate if result for "Lastname" is correct



