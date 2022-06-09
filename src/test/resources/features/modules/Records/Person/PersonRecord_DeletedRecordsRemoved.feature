#Author: Milton Silva
#Regression testcase TL-215: Person: Deleted records are removed

@DeleteRecordsRemoved
Feature: Delete records are removed

  @CreateDeleteNewPerson
  Scenario: Record - Person - verify I can create and delete a new person, to verify record is not returned in People Manager and to verify record is not returned in Quick Search
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName|LastName|EmailAddress    |EmailType  |EmailOptInMethod  |Role1	    |
      |Daniel   |Boone   |dboone@test.com |Personal   |Inquiry           |Person    |
    Then I validate if "Person has been created" message is correct
    And I go to Home page
    And I quick search "FirstName"
    And I validate if result for "FirstName" is correct
    And I open a record
    When I delete a person
    Then I validate if "Person has been deleted." message is correct
    And I search "Boone" on people page manager
    And I validate if "No search results to display." message on datatable is displayed
    And I go to Home page
    And I quick search "LastName"
    And I validate if "No search results to display." message on quick search is displayed
