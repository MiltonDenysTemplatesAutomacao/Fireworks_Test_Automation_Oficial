#Author: Milton Silva
#Regression testcase TL-45: Activities and Interests

@ActivitiesInterests
Feature: Activities and Interests

  @ActivitiesInterestsScenarios @Done @Person
  Scenario: Record - Person - verify activities and interests can be added to a student record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName  |LastName   |EmailAddress        |EmailType  |EmailOptInMethod  |Role1          |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|InterestCategory|InterestName|InterestWhoAdded|InterestDateAdded|InterestSource|InterestComments|ActivityCategory|ActivityName|ActivityWhoAdded|ActivityDateAdded|ActivitySource|ActivityComments|ActivityParticipate|
      |Frank      |Sinatra    |FSinatra@music.com  |Personal   |Inquiry           |Student        |Freshman   |Accepted             |Accepted         |01/15/2016       |Fall 2017|Academic        |Accounting  |Fire Starter    |11/11/2012       |Application   |Interest comment|Academic        |Agriculture |Fire Starter    |11/12/2013       |Self Reported |Activity comment|Yes                |
    Then I validate if "Person has been created" message is correct
    #to add an Interest independent of Activities
    Given I go to Home page
    And I quick search "FirstName"
    And I validate if "Frank"summary opened properly
    When I open a record
    And I navigate to Interests & Activities
    And I update Interests group "0" person 0
    When I click on Save Changes button in Interests & Activities
    Then I validate if "Person has been updated." message is correct
    #to add an Activity independent of Interests'
    Given I go to Home page
    And I quick search "FirstName"
    When I open a record
    And I navigate to Interests & Activities
    And I update Activities group "0" person 0
    When I click on Save Changes button in Interests & Activities
    Then I validate if "Person has been updated." message is correct
    #to verify  Activity & Interests'
    Given I go to Home page
    And I quick search "FirstName"
    When I open a record
    And I navigate to Interests & Activities
    Then I verify Interests group "0" person 0
    And I verify Activities group "0" person 0