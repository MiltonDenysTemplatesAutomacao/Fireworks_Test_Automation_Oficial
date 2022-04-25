#Author: Milton Silva
#Regression testcase TL-45: Activities and Interests

@ActivitiesInterests
Feature: Activities and Interests

  @ActivitiesInterestsScenarios
  Scenario: verify activities and interests can be added to a student record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |Firstname  |Lastname   |EmailAddress        |EmailType  |EmailOptInMethod  |Role1          |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Frank      |Sinatra    |FSinatra@music.com  |Personal   |Inquiry           |Student        |Freshman   |Accepted             |Accepted         |01/15/2016       |Fall 2017|
    #Then I validate if "Person has been created" message is correct
    #to add an Interest independent of Activities
    Given I go to Home page
    And I quick search "Firstname"
    And I validate if "Firstname"summary opened properly
    When I open a record
    And I navigate to Interests & Activities
    And I update Interests & Activities group "0" person 0
