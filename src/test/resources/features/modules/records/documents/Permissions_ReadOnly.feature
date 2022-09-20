#Author: Milton Silva
#Regression testcase TL-1154: Documents Permissions: View but not Create or Edit

@DocumentsPermissionsViewButNotCreateOrEdit
Feature: Documents Permissions: View but not Create or Edit

  @DocumentsPermissionsViewButNotCreateOrEditScenario @Fix @Documents
  Scenario: Record - Documents - verify this permissions group can not access documents
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |Role1    |EmailAddress               |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Vincent    |VanGogh    |Student |vincentvangogh@monaco.com  |Personal   |Inquiry         |Graduate   |Enrolled              |Enrolled       |08/12/2019       |Fall 2019|
    And I validate if "Person has been created." message is correct
    And I log out
    Given I login as "documentsReadOnlyUsername", "documentsReadOnlyPassword", "documentsReadOnlyFullName"
    And I navigate to people on records
    And I open a people record by "Vincent"
    And I validate if "Vincent"summary opened properly
    And I navigate to Documents
    #to not see the create button
    And I validate if create button is not displayed
    #the document is read-only
    When I update document "Student Profile", "Essay", "docDescription", "02/01/2020", "docComment", "DocTests-File1.jpg"
    And I click on "Save Changes"
    And I close alert if return this message "Document has been created."
    And I navigate to Documents
    And I open a document "Student Profile"
    And I validate if clear changes button is not displayed
    And I validate if save changes button is not displayed
    And I validate if document view button is displayed
    And I validate if document download button is displayed
    #navigate to the create url returns an error
