#Author: Milton Silva
#Regression testcase TL-924 (1 of 4): Email Status: Update to Valid changes Active Primary flags
#Regression testcase TL-924 (2 of 4): Email Status: Update to Valid changes Active Primary flags
#Regression testcase TL-924 (3 of 4): Email Status: Update to Valid changes Active Primary flags
#Regression testcase TL-924 (4 of 4): Email Status: Update to Valid changes Active Primary flags


@UpdateValidChangesActivePrimaryFlags
Feature: Update to Valid changes Active Primary flags

  @UpdateValidChangesActivePrimaryFlagsScenario1 @Done @Contact
  Scenario: Record Person - Contact - verify that setting the only email address status as valid makes email active and primary
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName|LastName   |EmailAddress         |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Herbie    |Nichols   |HNichols@music.com   |Personal   |Inquiry          |Student|Freshman   |Accepted             |Accepted         |01/15/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    #to update email to a status of Bounce and see active and primary checkboxs reflect the update
    And I validate if "Herbie"summary opened properly
    And I navigate to contact
    And I update email on contact for person "", "", "Bounce", "", "", "", "", "" and group "0"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    And I verify email address "", "", "Bounce", "", "", "", "", "0", "0" group "0"
    #to update email to a status of Valid and see active and primary checkboxs reflect the update
    And I update email on contact for person "", "", "Valid", "", "", "", "", "" and group "0"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    And I update email on contact for person "", "", "Valid", "", "", "", "1", "1" and group "0"

  @UpdateValidChangesActivePrimaryFlagsScenario2 @Done @Contact
  Scenario: Record Person - Contact - Setting secondary email address status to valid makes email active
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName|LastName     |EmailAddress           |EmailType  |EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus    |StudentStatusDate|EntryTerm|
      |Angelo   |Badalamenti  |ABadalamenti@music.com |Personal   |Inquiry          |Student|Freshman   |Accepted             |Accepted         |01/15/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    #to create a new active email
    And I validate if "Angelo"summary opened properly
    And I navigate to contact
    And I add a new email on contact for person group "0"
    And I update email on contact for person "ABadalamenti2@music.com", "School", "", "Inquiry", "", "", "1", "" and group "1"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    #to update status to bounce and verify primary and active are no longer selected
    And I update email on contact for person "", "", "Bounce", "", "", "", "", "" and group "1"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    And I verify email address "ABadalamenti2@music.com", "School", "Bounce", "Inquiry", "", "", "", "", "0" group "1"
    #to update email2 to a status of Valid and see active and primary checkboxs reflect the update
    And I update email on contact for person "", "", "Valid", "", "", "", "", "" and group "1"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    And I verify email address "ABadalamenti@music.com", "Personal", "", "Inquiry", "", "", "", "1", "1" group "0"
    And I verify email address "ABadalamenti2@music.com", "School", "", "Inquiry", "", "", "", "1", "" group "1"


  @UpdateValidChangesActivePrimaryFlagsScenario3 @Done @Contact
  Scenario: Record Organization Contact - Setting only email address status to valid makes email active and primary
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name					          |Role		  |Address1		      |City	    |State	    |PostalCode |Country	  |
      |Roosevelt Junior High School   |High School|1330 College Avenue|Modesto  |California |95350      |United States|
    Then I validate if "Organization has been created." message is correct
    #to add an email address
    And I validate if "Roosevelt Junior High School"summary opened properly
    And I navigate to contact
    And I click on create a new email on contact for organization "RooseveltJr@school.net", "School", "", "Inquiry", "", "", "1", "1" group "0"
    And I click on save changes in contact for organization
    And I close alert if return this message "Organization has been updated."
    And I verify email address for organization "RooseveltJr@school.net", "School", "", "Inquiry", "", "", "", "1", "1" group "0"
    #to update status to bounce and verify primary and active are no longer selected
    And I click on create a new email on contact for organization "", "", "Bounce", "", "", "", "", "" group "0"
    And I click on save changes in contact for organization
    And I close alert if return this message "Organization has been updated."
    And I verify email address for organization "RooseveltJr@school.net", "School", "", "Inquiry", "", "", "", "0", "0" group "0"
    #to update status to valid and verify primary and active are now checked
    And I click on create a new email on contact for organization "", "", "Valid", "", "", "", "", "" group "0"
    And I click on save changes in contact for organization
    And I close alert if return this message "Organization has been updated."
    And I verify email address for organization "RooseveltJr@school.net", "School", "", "Inquiry", "", "", "", "1", "1" group "0"

  @UpdateValidChangesActivePrimaryFlagsScenario4 @Done @Contact
  Scenario: Record Organization - Contact - Setting secondary email address status to valid makes email active
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name				     |Role		 |Address1		    |City	           |State |PostalCode |Country	    |
      |Trinity High School   |High School|12425 Granger Road|Garfield Heights  |Ohio  |44125      |United States|
    Then I validate if "Organization has been created." message is correct
    #to add two email addresses and mark the second one active
    And I validate if "Trinity High School"summary opened properly
    And I navigate to contact
    And I click on create a new email on contact for organization "Trinity@school.net", "School", "", "Inquiry", "", "Email1", "1", "1" group "0"
    And I add a new email on contact for organization group "0"
    And I click on create a new email on contact for organization "Trinity2@school.net", "Business", "", "Inquiry", "", "Email2", "1", "" group "1"
    And I click on save changes in contact for organization
    And I close alert if return this message "Organization has been updated."
    #to verify email addresses then update the second email address to bounced
    And I verify email address for organization "Trinity@school.net", "School", "", "Inquiry", "", "", "Email1", "1", "1" group "0"
    And I verify email address for organization "Trinity2@school.net", "Business", "", "Inquiry", "", "", "Email2", "1", "0" group "1"
    And I click on create a new email on contact for organization "", "", "Bounce", "", "", "", "", "" group "1"
    And I click on save changes in contact for organization
    And I close alert if return this message "Organization has been updated."
    #to verify the second email address is not active then update the second email address to valid
    And I verify email address for organization "Trinity@school.net", "School", "", "Inquiry", "", "", "Email1", "1", "1" group "0"
    And I verify email address for organization "Trinity2@school.net", "Business", "", "Inquiry", "", "", "Email2", "0", "" group "1"
    And I click on create a new email on contact for organization "", "", "Valid", "", "", "", "", "" group "1"
    And I click on save changes in contact for organization
    And I close alert if return this message "Organization has been updated."
    #to verify the second email address is now active
    And I verify email address for organization "Trinity@school.net", "School", "", "Inquiry", "", "", "Email1", "1", "1" group "0"
    And I verify email address for organization "Trinity2@school.net", "Business", "", "Inquiry", "", "", "Email2", "1", "" group "1"