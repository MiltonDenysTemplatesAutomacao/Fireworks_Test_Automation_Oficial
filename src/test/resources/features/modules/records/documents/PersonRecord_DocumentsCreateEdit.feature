#Author: Milton Silva
#Regression testcase TL-1149: Create a Document
#Regression testcase TL-1150: Edit a Document
#Regression testcase TL-1152: Document Manager

@CreateEditDocument
Feature: Edits to Relationships

  @CreateEditDocumentScenarios @Done @Documents
  Scenario: Record - Relationships - verify edits to relationships are reflected on both records
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName|LastName |Role1    |EmailAddress             |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Grace    |Kelly    |Student  |princessgrace@monaco.com |Personal   |Inquiry         |Graduate   |Enrolled              |Enrolled       |08/12/2019       |Fall 2019|
    And I validate if "Person has been created." message is correct
    #to create a new document
    And I navigate to people on records
    And I open a people record by "Grace"
    And I validate if "Grace"summary opened properly
    And I navigate to Documents
    And I create a document
    When I update document "Headshot", "Essay", "docDescription", "02/01/2020", "docComment", "DocTests-File1.jpg"
    And I click on "Save Changes"
    And I close alert if return this message "Document has been created."
    Then I verify document "Headshot", "Essay", "docDescription", "02/01/2020", "docComment", "DocTests-File1.jpg"
    #to reopen and verify the document
    And I navigate to Documents
    And I verify document data table values "Headshot", "Essay", "docDescription", "02/01/2020", "docComment", "DocTests-File1.jpg"
    And I open a document "Headshot"
    Then I verify document "Headshot", "Essay", "docDescription", "02/01/2020", "docComment", "DocTests-File1.jpg"
    #to edit and verify the document
    When I update document "", "", "updateDocDescription", "02/03/2020", "", "DocTests-File3.jpg"
    And I click on "Save Changes"
    And I confirm replace file
    And I close alert if return this message "Document has been updated."
    And I verify document data table values "Headshot", "Essay", "updateDocDescription", "02/03/2020", "docComment", "DocTests-File3.jpg"
    And I navigate to Documents
    And I verify document data table values "Headshot", "Essay", "updateDocDescription", "02/03/2020", "docComment", "DocTests-File3.jpg"
