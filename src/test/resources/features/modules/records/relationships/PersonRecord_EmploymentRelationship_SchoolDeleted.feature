#Author: Milton Silva
#Regression testcase TL-770 (2 of 2): Employment Relationships

@EmploymentRelationships
Feature: Employment Relationships

  @EmploymentRelationshipsScenario @Done @Relationships
  Scenario: Record - Relationships - verify relationship to the employer is deleted when employer is deleted
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name			                  |Role	       |Address1		      |City    |State    |PostalCode |Country	   |
      |Loudoun County Public Schools  |Institution |21000 Education Court |Ashburn |Virginia |20148      |United States|
    Then I validate if "Organization has been created." message is correct
    And I create an organization
      |Name		|Role	     |Address1		       |City    |State    |PostalCode |Country	    |
      |Wegmans  |Institution |45131 Columbia Place |Dulles  |Virginia |20166      |United States|
    Then I validate if "Organization has been created." message is correct
    And I create a person
      |FirstName  |LastName   |EmailAddress           |EmailType  |EmailOptInMethod |Role1     |
      |Chelsea    |Prescott   |cprescott@verizon.net  |Personal   |Inquiry          |Volunteer |
    And I validate if "Person has been created." message is correct
    #to add an employment record
    And I validate if "Chelsea"summary opened properly
    And I navigate to Employment
    And I pick an organization Employer "Loudoun County" group "0"
    And I update Employment "Cook", "08/11/2012", "05/31/2014", "", "Employer1" group "0"
    And I click on "Save Changes"
    And I close alert if return this message "Person has been updated."
    #to add a 2nd employment record
    And I add Employment group "0"
    And I pick an organization Employer "Wegmans" group "1"
    And I update Employment "Cook", "08/11/2012", "", "", "" group "1"
    And I click on "Save Changes"
    And I close alert if return this message "Person has been updated."
    #to verify relationship records
    And I navigate to Relationship
    And I open a relationship "Loudoun County"
    And I verify relationship values "Loudoun County Public Schools", "Employer", "Employee", "", ""
    And I validate relationship readonly
    #to delete the 2nd employment record
    And I navigate to Employment
    When I delete an employment "1"
    And I click on "Save Changes"
    And I validate if "Person has been updated." message is correct
    #the relationship was also deleted
    And I navigate to Relationship
    And I open a relationship "Wegmans"
    Then I verify relationships results message is correct "No search results to display."
