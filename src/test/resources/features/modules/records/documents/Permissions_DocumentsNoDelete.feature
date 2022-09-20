#Author: Milton Silva
#Regression testcase TL-1157: Documents Permissions: No Delete

@DocumentsPermissionsNoDelete
Feature: Documents Permissions: No Delete

  @DocumentsPermissionsNoDeleteScenario @Fix @Documents
  Scenario: Record - Documents - verify the delete document permission is honored
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |Role1    |EmailAddress              |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Gabriela   |Moran     |Student  |gabrielamoran@monaco.com  |Personal   |Inquiry         |Graduate   |Enrolled              |Enrolled       |08/12/2019       |Fall 2019|
    And I validate if "Person has been created." message is correct
    And I log out
    Given I login as "documentsNoDeleteUsername", "documentsNoDeletePassword", "documentsNoDeleteFullName"
    And I navigate to people on records
    And I open a people record by "Gabriela"
    And I validate if "Gabriela"summary opened properly
    And I navigate to Documents
    When I update document "FW Logo", "Essay", "docDescription", "02/01/2020", "docComment", "DocTests-File1.jpg"
    And I click on "Save Changes"
    And I close alert if return this message "Document has been created."
    And I navigate to Documents
    And I open a document "FW Logo"
    #the Delete button is not visible
    And I validate if delete button on documents is not displayed

