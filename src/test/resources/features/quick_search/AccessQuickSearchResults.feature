#Author: Milton Silva

@AccessQuickSearchResults
Feature: Search by name

  @AccessQuickSearchPersonResults
  Scenario: to verify quick search returns results for person phone number searches
    Given I login as firestarter
    And I create a person
      |Firstname	|Lastname		|Fullname				|Role1	        |Phone					|PhoneType|
      |Robert		|Brandon		|Robert Brandon	|Person	|1-720-839-1218	|Home			|
    And I go to Home page
    When I quick search "Phone"
    Then I validate if result for "Phone" is correct
    And I open a record
    Then I validate if "Fullname"summary opened properly

