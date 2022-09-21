#Author: Milton Silva
#Regression testcase TL-64: Employment data is reflected in Relationship panel

@EmploymentRelationships
Feature: Employment Relationship

  @EmploymentRelationships @Done @Employment
  Scenario: Record - Employment - verify relationships created when employment is added to a student
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name				   |Role	    |Address1		 |City	  |State	 |PostalCode |Country	   |
      |Decca Data Systems  |Institution |1963 Coffee Ave |Memphis |Tennessee |38106      |United States|
    Then I validate if "Organization has been created." message is correct
    When I create a person
      |FirstName|LastName |EmailAddress      |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Dave     |Berry    |DBerry@music.com  |Personal   |Inquiry          |Student|Freshman   |Accepted             |Accepted         |06/15/2020       |Fall 2021|
    And I validate if "Person has been created." message is correct
    #to add an employment record
    And I validate if "Dave"summary opened properly
    And I navigate to Employment
    And I pick an organization Employer "Decca Data Systems" group "0"
    And I update Employment "Engineer", "11/11/2012", "11/11/2014", "", "Employment comment" group "0"
    And I click on "Save Changes"
    And I close alert if return this message "Person has been updated."
    And I verify Employment "Decca Data Systems", "Engineer", "11/11/2012", "11/11/2014", "", "Employment comment" group "0"
    #to verify the read-only relationship was automatically added
    And I navigate to Relationship
    And I open a relationship "Decca Data Systems"
    And I verify relationship values "Decca Data Systems", "Employer", "Employee", "Employment comment", ""
    And I validate relationship readonly
    #edit the Employer field group from the student record and verify the Relationship is updated
    And I navigate to Employment
    And I update Employment "", "", "", "", "Edited from employer" group "0"
    And I click on "Save Changes"
    And I close alert if return this message "Person has been updated."
    And I navigate to Relationship
    And I open a relationship "Decca Data Systems"
    And I verify relationship values "Decca Data Systems", "Employer", "Employee", "Edited from employer", ""
    #to verify the read-only relationship from the Organization record
    And I navigate to organization on Records
    And I open an organization record by "Decca Data Systems"
    And I verify the record header for organization "Decca Data Systems", "", "" and ""
    And I navigate to Relationship
    And I open an organization relationship "Dave"
    And I verify relationship values "Dave Berry", "Employee", "Employer", "Edited from employer", ""
    And I validate relationship readonly

