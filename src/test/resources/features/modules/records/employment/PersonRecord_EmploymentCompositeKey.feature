#Author: Milton Silva
#Regression testcase TL-1143: Employment Composite key

@EmploymentCompositeKey
Feature: EmploymentCompositeKey

  @EmploymentCompositeKey @Done @Employment
  Scenario: Record - Employment - verify employment field group composite key
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name				                 |Role	      |Address1		   |City    |State	   |PostalCode |Country	      |
      |DrumsAlongTheMohawk Data Systems  |Institution |1287 Coffee Ave |Memphis |Tennessee |38106      |United States |
    Then I validate if "Organization has been created." message is correct
    When I create a person
      |FirstName |LastName |EmailAddress            |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Billy     |Eckstine |billyeckstine@music.com |Personal   |Inquiry          |Student|Freshman   |Accepted             |Accepted         |06/15/2020       |Fall 2021|
    And I validate if "Person has been created." message is correct
    And I navigate to people on records
    And I open a people record by "Billy"
    And I validate if "Billy"summary opened properly
    And I navigate to Employment
    And I pick an organization Employer "DrumsAlongTheMohawk" group "0"
    And I update Employment "Designer", "11/11/2012", "", "", "" group "0"
    And I click on "Save Changes"
    And I close alert if return this message "Person has been updated."
    And I add Employment group "0"
    And I pick an organization Employer "DrumsAlongTheMohawk" group "1"
    And I update Employment "Designer", "11/11/2012", "", "", "" group "1"
    And I click on "Save Changes"
    And I verify validation message "Employment 2: Employer must be different."
    And I verify validation message "Employment 2: Position must be different."
    And I verify validation message "Employment 2: Start Date must be different."
