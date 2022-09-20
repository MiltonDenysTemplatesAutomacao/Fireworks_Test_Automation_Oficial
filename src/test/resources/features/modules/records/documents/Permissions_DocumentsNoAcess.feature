#Author: Milton Silva
#Regression testcase TL-1148: Documents Permissions: No Access

@DocumentsPermissionsNoAccess
Feature: Edits to Relationships

  @DocumentsPermissionsNoAccess @Fix @Documents
  Scenario: Record - Documents - verify this permissions group can not access documents
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |Role1    |EmailAddress               |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Elisabeth  |McWane    |Student  |elisabethmcwane@monaco.com |Personal   |Inquiry         |Graduate   |Enrolled              |Enrolled       |08/12/2019       |Fall 2019|
    And I validate if "Person has been created." message is correct
    And I log out
    Given I login as "documentsNoAccessUsername", "documentsNoAccessPassword", "documentsNoAccessFullName"
    And I navigate to people on records
    And I open a people record by "Elisabeth"
    And I validate if "Elisabeth"summary opened properly
    And I validate if documents tab is visible