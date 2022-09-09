#Author: Milton Silva
#Regression testcase TL-205: Exact match auto-merge on rule 3: SSN-LastName

@ExactMatchAutoMergeOnrule3SSNLastName
Feature: Exact match auto-merge on rule 3: SSN-LastName

  @ExactMatchAutoMergeOnrule3SSNLastNameScenario @Done @DupManager
  Scenario: Record - DupManager - Exact match - SSN + Last Name
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName    |Role1     |EmailAddress             |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Hannes     |Kolehmainen |Student   |HKolehmainen@runners.com |Personal   |Inquiry         |Freshman   |Accepted              |Accepted       |01/25/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    And I navigate to people on records
    And I open a people record by "Hannes"
    And I validate if "Hannes"summary opened properly
    And I navigate to basic
    And I update "", "" and "583-23-9879" to update citizenship
    And I click on save changes on basic
    And I close alert if return this message "Person has been updated."
    When I create a person
      |FirstName  |LastName    |Role1     |EmailAddress             |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|Phone          |PhoneType|
      |FlyingFinn |Kolehmainen |Student   |HKolehmainen@runners.com |Personal   |Inquiry         |Freshman   |Accepted              |Accepted       |01/25/2016       |Fall 2017|(401) 619-4444 |Home     |
    And I validate if "Person has been created." message is correct
    And I navigate to people on records
    And I open a people record by "FlyingFinn"
    And I validate if "FlyingFinn"summary opened properly
    And I navigate to basic
    And I update "", "" and "583-23-9879" to update citizenship
    And I click on save changes on basic
    And I close alert if return this message "A duplicate Student record was found and automatically merged with the new record."
    And I navigate to people on records
    And I open a people record by "FlyingFinn"
    And I validate if "FlyingFinn"summary opened properly
    And I navigate to contact
    And I verify name on contact for person "FlyingFinn", "Kolehmainen", "", "", "", "", "1", "1" group "0"
    And I verify name on contact for person "Hannes", "Kolehmainen", "", "", "", "", "1", "0" group "1"
    And I verify email address "0" fields
    And I verify phone number on contact for person "(401) 619-4444", "Home", "", "", "", "", "", "", "1", "1", group "0"
