#Author: Milton Silva
#Regression testcase TL-90 (1 of 2): Edits to Relationships
#Regression testcase TL-90 (2 of 2): Edits to Relationships

@EditsToRelationships
Feature: Edits to Relationships

  @EditsToRelationshipsScenarios @Done @Contact
  Scenario: Record - Relationships - verify edits to relationships are reflected on both records
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName|LastName   |Role1            |EmailAddress                 |EmailType  |EmailOptInMethod|
      |Homer    |Simpson    |Parent/Guardian  |JSimpson@simpsonscartoon.com |Personal   |Inquiry         |
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName|LastName   |Role1    |EmailAddress                 |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Lizza    |Simpson    |Student  |LSimpson@simpsonscartoon.com |Personal   |Inquiry         |Freshman   |Accepted              |Accepted       |01/15/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName    |LastName   |Role1    |EmailAddress                 |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Bartholomew  |Simpson    |Student  |BSimpson@simpsonscartoon.com |Personal   |Inquiry         |Freshman   |Accepted              |Accepted       |01/15/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    #to create a relationship between person3 and person1
    And I navigate to Relationship
    When I create a relationship
    And I open a record picker "Homer"
    And I update relationship "Father", "Son", ""
    And I click on save changes on Relationships
    And I close alert if return this message "Relationship has been created"
    #to update the relationship
    And I open a relationship "Homer"
    And I verify relationship values "Homer Simpson", "Father", "Son", "", ""
    And I update relationship "", "", "updated comment"
    And I click on save changes on Relationships
    And I close alert if return this message "Relationship has been updated"
    #to verify the relationship was updated on person1
    And I navigate to people on records
    And I open a people record by "Homer"
    And I validate if "Homer Simpson"summary opened properly
    And I navigate to Relationship
    And I open a relationship "Bartholomew"
    And I verify relationship values "Bartholomew Simpson", "Father", "Son", "updated comment", ""
    #to create a relationship between person1 and person2
    And I navigate to Relationship
    When I create a relationship
    And I open a record picker "Lizza"
    And I update relationship "Legal Guardian", "Daughter", ""
    And I click on save changes on Relationships
    And I close alert if return this message "Relationship has been created"
    #to update the relationship values
    And I open a relationship "Lizza"
    And I verify relationship values "Lizza Simpson", "Legal Guardian", "Daughter", "", ""
    And I update relationship "Father", "", ""
    And I click on save changes on Relationships
    And I close alert if return this message "Relationship has been updated"
    #to verify the relationship was updated on person2
    And I navigate to people on records
    And I open a people record by "Lizza"
    And I validate if "Lizza Simpson"summary opened properly
    And I navigate to Relationship
    And I open a relationship "Homer"
    And I verify relationship values "Homer Simpson", "Father", "Daughter", "", ""

  @EditsToRelationshipsScenarios1 @Done @Contact
  Scenario: Record - Relationships - verify a deleted relationship is removed from both records
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |Role1                |EmailAddress                 |EmailType  |EmailOptInMethod|Role1           |
      |Randyz     |Marsh    |RMarsh@SouthPark.com |JSimpson@simpsonscartoon.com |Personal   |Inquiry         |Parent/Guardian |
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName  |LastName |Role1                |EmailAddress                 |EmailType  |EmailOptInMethod|Role1   |StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm  |StudentType |
      |Shellyz    |Marsh    |SMarsh@SouthPark.com |JSimpson@simpsonscartoon.com |Personal   |Inquiry         |Student |Accepted             |Accepted         |01/15/2016       |Fall 2017  |Freshman    |
    And I validate if "Person has been created." message is correct
    And I navigate to people on records
    And I open a people record by "Shellyz Marsh"
    And I validate if "Shellyz Marsh"summary opened properly
    And I navigate to Relationship
    When I create a relationship
    And I open a record picker "Randyz"
    And I update relationship "Father", "Daughter", ""
    And I click on save changes on Relationships
    And I close alert if return this message "Relationship has been created"
    And I open a relationship "Shellyz"
    And I verify relationship values "Shellyz Marsh", "Father", "Daughter", "", ""
    #to verify the relationship from person1
    And I validate if "Person has been created." message is correct
    And I navigate to people on records
    And I open a people record by "Randyz Marsh"
    And I validate if "Randyz Marsh"summary opened properly
    And I navigate to Relationship
    And I open a relationship "Shellyz"
    And I verify relationship values "Shellyz Marsh", "Father", "Daughter", "", ""
    #deleting the relationship removes it from both records
    And I delete a relationship
    And I open a relationship "Marsh"
    Then I verify relationships results message is correct "No search results to display."
    And I navigate to people on records
    And I open a people record by "Shellyz"
    And I validate if "Shellyz Marsh"summary opened properly
    And I navigate to Relationship
    Then I verify relationships results message is correct "No search results to display."
