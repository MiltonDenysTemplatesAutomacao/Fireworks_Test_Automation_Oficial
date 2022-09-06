#Author: Milton Silva
#Regression testcase TL-931: Org: Primary Contact Relationship

@OrgPrimaryContactRelationship
Feature: Employment Relationships

  @OrgPrimaryContactRelationshipScenarios @Done @Relationships
  Scenario: Record - Relationships - verify relationship created from an organizations primary contact
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |EmailAddress           |EmailType|EmailOptInMethod |Role1    |
      |Bugsy      |Siegel   |BSiegel@gangsters.net  |Personal |Inquiry          |Employee |
    Then I validate if "Person has been created." message is correct
    And I create an organization
      |Name		   |Role	              |Address1		    |City     |State    |PostalCode |Country	  |Phone          |PhoneType|
      |Murder Inc  |Religious Institution |772 Saratoga Ave |Brooklyn |New York |11212      |United States|(718) 385-1257 |Business |
    Then I validate if "Organization has been created." message is correct
  #to add the person as the primary contact for the org
    And I validate if "Murder Inc"summary opened properly
    And I navigate to basic
    When I update basic identification values "", "", "", "Siegel"
    And I click on "Save Changes"
    Then I validate if "Organization has been updated." message is correct
    #to verify the primary contact was added
    And I verify basic identification values "", "", "", "Bugsy Siegel"
    #to verify a relationship was created for the org
    And I navigate to Relationship
    And I open an organization relationship "Siegel"
    And I verify relationship values "Bugsy Siegel", "Employer", "Employee", "", ""
    #to verify disabled fields
    And I validate relationship readonly field "Relationship Target"
    And I validate relationship readonly field "Role"
    And I validate relationship readonly field "Role in Relationship"
    #to update the relationship comment
    And I update relationship "", "", "Headquarters of famous crime syndicate"
    And I click on "Save Changes"
    Then I validate if "Relationship has been updated." message is correct
    #to verify fields are still disabled
    And I validate relationship readonly field "Relationship Target"
    And I validate relationship readonly field "Role"
    And I validate relationship readonly field "Role in Relationship"
   #to verify the comments field has been updated
    And I verify relationship values "", "", "", "Headquarters of famous crime syndicate", ""
    #to go to the primary contact and verify they have the relationship with the org
    And I go to Home page
    When I quick search by "BSiegel@gangsters.net"
    Then I validate if result for "FirstName" is correct
    And I open a record
    And I validate if "Bugsy Siegel"summary opened properly
    And I navigate to Relationship
    And I open a relationship "Murder Inc"
    And I verify relationship values "Murder Inc", "Employer", "Employee", "Headquarters of famous crime syndicate", ""
    #to verify disabled fields
    And I validate relationship readonly field "Relationship Target"
    And I validate relationship readonly field "Role"
    And I validate relationship readonly field "Role in Relationship"