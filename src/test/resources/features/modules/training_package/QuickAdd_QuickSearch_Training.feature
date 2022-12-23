#Author: Milton Silva

@QuickAddTraining
Feature: QuickAddTraining

  @QuickAddTrainingScenario1
  Scenario: verify quick add and quick search for all record types
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to add a student with 2 email addresses
    And I navigate to QuickAddCreatePersonPage
    When I quick add a person
      |FirstName|LastName	|EmailAddress			  |EmailType|EmailOptInMethod |Role1	|Phone        |PhoneType|Address1        |City  |State   |Country      |PostalCode|StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|
      |George   |Voorhis    |gvoorhis@McDowells.com   |Personal |Inquiry          |Student  |888-411-7732 |Home     |210 Sixth Avenue|Denver|Colorado|United States|80220     |Freshman   |Accepted             |Accepted     |09/19/2016       |Fall 2017|
    And I clickQuickAddPersonSaveAndGo
    Then I validate if "Person has been created" message is correct
    And I validate if "George Voorhis"summary opened properly
    Then I verify Header Role "Student"
    And I verify Header Record Status "Active" for person
    And I verify Header Ok to Contact "Yes"
    And I navigate to contact
    And I add a new email on contact for person group "0"
    And I update email on contact for person "gvoorhis2@mcdowells.edu", "School", "", "College Fair", "", "", "1", "" and group "1"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."





