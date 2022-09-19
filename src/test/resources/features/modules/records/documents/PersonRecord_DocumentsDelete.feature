#Author: Milton Silva
#Regression testcase TL-1158: Delete a Document
#Regression testcase TL-1162: Search for documents

@DeleteDocument
Feature: Edits to Relationships

  @DeleteDocumentScenario @Done @Documents
  Scenario: Record - Documents - verify a document can be searched and deleted
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName|LastName |Role1    |EmailAddress                 |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Caroline |Grimaldi |Student  |PrincessCaroline@hanover.com |Personal   |Inquiry         |Transfer   |Enrolled              |Enrolled       |02/12/2020       |Fall 2019|
    And I validate if "Person has been created." message is correct
    And I navigate to people on records
    And I open a people record by "Caroline"
    And I validate if "Caroline"summary opened properly
    And I navigate to Documents
    And I create a document
    When I update document "Doc4220 to be Deleted", "College Transcript", "", "", "", "DocTests-File2.pdf"
    And I click on "Save Changes"
    And I close alert if return this message "Document has been created."
    #to search based on document fields
    And I navigate to smart search page
    And I click on create smart search button
    And I select "File" search field group "0" in smart search composer
    And I select "equals" operator field group "0" in smart search composer
    And I fill "DocTests-File2.pdf" text condition value group "0"
    And I fill smart search name "DocumentSearch4220"
    And I click on save this search button
    And I verify smart search results "Grimaldi, Caroline"
    #to delete the document
    And I navigate to people on records
    And I open a people record by "Caroline"
    And I validate if "Caroline"summary opened properly
    And I navigate to Documents
    And I open a document "Doc4220 to be Deleted"
    And I delete a document
    And I close alert if return this message "Document has been deleted."
    #to verify the document does not exist
    And I open a document "Doc4220 to be Deleted"
    And I verify document data table values "No table data available.", "", "", "", "", ""
    #rerunning the document search returns no results
    And I navigate to smart search page
    And I open smart search "DocumentSearch4220"
    When I click on run search button
    And I verify results on smart search table "No search results to display."
    And I verify result count on smart search table "This Smart Search returned 0 results"


