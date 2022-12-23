#Author: Milton Silva

  #Regression testcase TL-245: Search by Preferred Name
  #Regression testcase TL-247: Search by Social Security Number

@SearchByPreferredNameAndSocialSecurityNumber
Feature: Search by Preferred Name and Social Security Number

  @SearchByPreferredNameAndSocialSecurityNumberScenario
  Scenario: verify quick search returns results for social security number and preferred name searches
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to QuickAddCreatePersonPage
    When I quick add a person
      |FirstName|LastName	|EmailAddress			  |EmailType|EmailOptInMethod |Role1	|StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|
      |Squire   |Fridell    |sfridell@mcdonalds.com   |Personal |Inquiry          |Student  |Freshman   |Accepted             |Accepted     |09/19/2016       |Fall 2017|
    And I clickQuickAddPersonSaveAndGo
    #Then I validate if "Person has been created" message is correct
    And I navigate to people on records
    And I open a people record by "Squire Fridell"
    And I validate if "Squire Fridell"summary opened properly
    And I navigate to basic option
    When I update citizenship values "", "", "583-23-9874"
    And I click on button "Save Changes"
    And I validate alert message "Person has been updated."
