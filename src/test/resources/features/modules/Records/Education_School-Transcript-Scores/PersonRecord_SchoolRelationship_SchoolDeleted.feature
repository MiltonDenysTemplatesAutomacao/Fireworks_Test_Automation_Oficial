#Author: Milton Silva
#Regression testcase TL-770 (1 of 2): School Relationships
#Regression testcase TL-705: Education: School: Linked relationship

@SchoolRelationshipsLinkedRelationship
Feature: Phone Number Formatting

  @SchoolRelationshipsLinkedRelationshipScenario @Done
  Scenario: Record - Education_School-Transcript-Scores - verify behavior of linked school relationship between education and relationship panels
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
#    And I create an organization
#      |Name				      |Role		                  |Address1		          |City	  |State  |PostalCode |Country	      |IDType |IDNumber |WhoAddedID   |Comments                |
#      |Blockbuster University |Post-Secondary Institution |61763 Country Road 35  |Goshen |Indiana|46528      |United States  |CEEB   |69178    |Fire Starter |Blockbuster CEEB comment|
#    Then I validate if "Organization has been created." message is correct
#    And I verify the record header for organization "Blockbuster University", "", "" and "Organization Category: School"
#    And I navigate to ID Types
#    And I update External Id group "0" person 0
#    And I click on external ID SaveChanges button
#    And I close alert if return this message "Organization has been updated."
#    And I create an organization
#      |Name				         |Role		                 |Address1		|City	      |State  |PostalCode |Country	      |IDType |IDNumber |WhoAddedID   |Comments                   |
#      |HollywoodVideo University |Post-Secondary Institution |225 Holly St  |Marysville   |Ohio   |43040      |United States  |CEEB   |69177    |Fire Starter |HollywoodVideo CEEB comment|
#    And I close alert if return this message "Organization has been created."
#    And I verify the record header for organization "HollywoodVideo University", "", "" and "Organization Category: School"
#    And I navigate to ID Types
#    And I update External Id group "0" person 0
#    And I click on external ID SaveChanges button
#    And I close alert if return this message "Organization has been updated."
    When I create a person
      |FirstName  |LastName     |EmailAddress          |EmailType|EmailOptInMethod |Role1   |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Cleo       |Brovloskeee  |CBrovloski@music.com  |Personal |Inquiry          |Student |Freshman   |Applicant            |Waitlisted       |02/15/2020       |Fall 2021|
    #Then I validate if "Person has been created." message is correct
    #to add a school to the student
    Given I go to Home page
    And I quick search "FirstName"
    And I validate if "Cleo"summary opened properly
    And I open a record
    And I navigate to Education
    And I update school in education for person "Blockbuster University", "", "", "", "", "", "" group "0"
    And I verify school in education for person "", "", "", "", "", "", "" group "0"
    #And I click on save changes in Education for person

