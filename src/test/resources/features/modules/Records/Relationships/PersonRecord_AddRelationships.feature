#Author: Milton Silva
#Regression testcase - Person Relationship can be created
#Regression testcase TL-88 (1 of 2): School Relationships May be Created
#Regression testcase TL-88 (2 of 2): Education Relationships May be Created
#Regression testcase TL-1082: Enter value into GPA field manually

@AddRelationships
Feature: Add Relationships

  @PersonRelationshipCanBeCreated @Done @Relationships
  Scenario: Record - Relationships - verify relationships can be created
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create a person
      |FirstName |LastName |EmailAddress               |EmailType  |EmailOptInMethod  |Role1           |
      |Wally     |Brown    |WBrown@Mulholland-Drive.com|Personal   |Inquiry           |Parent/Guardian |
    And I validate if "Person has been created" message is correct
    And I create an organization
      |Name			         |Role	      |Address1		      |City	       |State	   |PostalCode |Country	     |
      |Silencio High School  |High School |8591 Mulholland Dr |Los Angeles |California |90046      |United States|
    Then I validate if "Organization has been created." message is correct
    And I create a person
      |FirstName |LastName  |EmailAddress              |EmailType  |EmailOptInMethod  |Role1   |StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm  |StudentType |
      |Jimmy     |Katz      |JKatz@Mulholland-Drive.com|Personal   |Inquiry           |Student |Accepted             |Accepted         |03/15/2019       |Fall 2019  |Freshman    |
    And I validate if "Person has been created" message is correct
  #to create a person relationship from the student record
    And I navigate to people on records
    And I open a people record by "Jimmy"
    And I validate if "Jimmy Katz"summary opened properly
    Then I verify Header Role "Student"
    And I navigate to Relationship
    When I create a relationship
    And I open a record picker "Wally"
    And I update relationship "Father", "Son", ""
    And I click on save changes on Relationships
    And I close alert if return this message "Relationship has been created"
    #to add a school relationship without adding data to the School field group
    When I create a relationship
    And I open an organization record picker "Silencio"
    And I update relationship "High School", "Student", ""
    And I click on save changes on Relationships
    And I close alert if return this message "Relationship has been created"
    And I open a relationship "Wally Brown"
    And I verify relationship values "Wally Brown", "Father", "Son", "", ""
    And I navigate to Relationship
    And I open a relationship "Silencio"
    And I verify relationship values "Silencio High School", "High School", "Son", "Student", ""
    #to verify the relationship from the parent record
    And I navigate to people on records
    And I open a people record by "Wally"
    And I validate if "Wally Brown"summary opened properly
    And I navigate to Relationship
    And I open a relationship "Jimmy Katz"
    And I verify relationship values "Jimmy Jimmy", "High School", "Son", "Father", ""
    #to verify the relationship from the Organization record
    And I navigate to organization on Records
    And I open an organization record by "Silencio High School"
    And I verify the record header for organization "Silencio High School", "OK to Contact: Yes", "Record Status: Active" and "Organization Category: School"
