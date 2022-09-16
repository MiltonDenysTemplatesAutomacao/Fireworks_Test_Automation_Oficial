#Author: Milton Silva
#Regression testcase TL-1151: Document fields validation

@DocumentFieldsValidation
Feature: Document fields validation

  @DocumentFieldsValidationScenarios @Done @Documents
  Scenario: Record - Relationships - verify required field validation on document composer
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |Role1    |EmailAddress      |EmailType  |EmailOptInMethod|
      |Rainier    |Grimaldi |Person   |prince@monaco.com |Personal   |Inquiry         |
    #And I validate if "Person has been created." message is correct
    #to save a new document with no data added
    And I navigate to people on records
    And I open a people record by "Rainier"
    And I validate if "Rainier"summary opened properly
    And I navigate to Documents
    And I create a document
    And I click on "Save Changes"
    And I verify validation message "The Name field is required."
    And I verify validation message "The Type field is required."
    And I verify validation message "The File field is required."
    And I click on close button on modal
    #to save the same document which was added to another record
    When I update document "Headshot", "Essay", "", "", "", "DocTests-File1.jpg"
    And I click on "Save Changes"
    And I close alert if return this message "Document has been created."
    #not to be able save the same document to this record again
    And I navigate to Documents
    And I create a document
    When I update document "Headshot", "Essay", "", "", "", "DocTests-File1.jpg"
    And I click on "Save Changes"
    And I close alert if return this message "The Name or File Name must be different."
    And I click on clear changes


