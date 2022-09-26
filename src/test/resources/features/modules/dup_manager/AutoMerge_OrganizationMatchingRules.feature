#Author: Milton Silva
#Regression testcase TL-374: Organization: Resolution Rules for 1:1 Fields
#Regression testcase TL-610 rule 4: auto-merge org on email address


@AutoMergeOrganizationMatchingRules
Feature: Auto Merge: Organization: Matching Rules

  @AutoMergeOrganizationMatchingRulesScenarios @Done @DupManager
  Scenario: Record - DupManager - Check resolution rules for Org 1:1
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |Role1    |EmailAddress       |EmailType  |EmailOptInMethod|
      |Cameron    |Frye      |Person   |camfrye@dayoff.com |Personal   |Inquiry         |
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName  |LastName  |Role1    |EmailAddress                  |EmailType  |EmailOptInMethod|
      |Garth      |Bolbeck   |Person   |gbolbeck@TommysSurfSchool.com |Personal   |Inquiry         |
    And I validate if "Person has been created." message is correct
    When I create a staff
      |FirstName |LastName  |FullName       |EmailAddress       |EmailType|PermissionGroup |
      |Ferris    |Bueller   |Ferris Bueller |justfury@shield.com|Personal |Administrator   |
    And I validate if "Staff member has been created. They have been sent a welcome email with a link prompting them to login and create a password. The link in this email will expire in 12 hours." message is correct
    When I create a staff
      |FirstName |LastName |FullName      |EmailAddress                 |EmailType|PermissionGroup |
      |Edward    |Rooney   |Edward Rooney |edrooney@TommysSurfSchool.edu|Personal |Administrator   |
    And I validate if "Staff member has been created. They have been sent a welcome email with a link prompting them to login and create a password. The link in this email will expire in 12 hours." message is correct
    #to create the first organization record
    When I create an organization
      |Name					    |Role		             |Phone		     |PhoneType  |Address1			            |City	  |State   |PostalCode |Country		  |
      |Tommy Bahama Surf School |Religious Institution   |203-855-2857   |Business   |11853 Ferris Bueller Boulevard|Rochester|New York|82463      |United States |
    And I validate if "Organization has been created." message is correct
    And I verify the record header for organization "Tommy Bahama Surf School", "OK to Contact: Yes", "Record Status: Active" and ""
    And I navigate to contact
    And I click on create a new email on contact for organization "admin@TommysSurfSchool.edu", "School", "", "College Fair", "", "Do not share the address with outsiders.", "", "" group "0"
    And I click on save changes in contact for organization
    And I close alert if return this message "Organization has been updated."
    And I navigate to basic
    When I update basic identification values "", "", "TommysSurfSchool.edu", "Frye"
    And I update basic context values "(GMT-04:00) Eastern Time (US & Canada)", "Ferris Bueller"
    Then I click on Save Changes in Basic for organization
    And I close alert if return this message "Organization has been updated."
    #to create another org that we will update so it auto merges
    When I create an organization
      |Name					     |Role		             |Phone		     |PhoneType  |Address1			            |City	  |State   |PostalCode |Country		  |
      |Tommy Bahama Surf School1 |Religious Institution   |203-855-2857   |Business   |11853 Ferris Bueller Boulevard|Rochester|New York|82463      |United States |
    And I validate if "Organization has been created." message is correct
    And I verify the record header for organization "Tommy Bahama Surf School1", "OK to Contact: Yes", "Record Status: Active" and ""
    And I navigate to basic
    When I update basic identification values "", "", "http://www.TommysSurfSchool.edu", "Bolbeck"
    And I update basic context values "(GMT-06:00) Mountain Time (US & Canada)", "Edward Rooney"
    Then I click on Save Changes in Basic for organization
    And I close alert if return this message "Organization has been updated."
    #add a matching Email Address to Org2 to cause auto-merge on rule 4
    And I navigate to contact
    And I click on create a new email on contact for organization "admin@TommysSurfSchool.edu", "School", "", "College Fair", "", "Do not share the address with outsiders.", "", "" group "0"
    And I click on save changes in contact for organization
    And I close alert if return this message "A duplicate Organization record was found and automatically merged with the new record."
    And I verify the record header for organization "Tommy Bahama Surf School1", "OK to Contact: Yes", "Record Status: Active" and ""
    #verify merged data
    And I navigate to contact
    And I verify organization name "Tommy Bahama Surf School1" on contact
    And I verify organization name is 1 to 1
    And I verify phone number on contact for organization "", "", "", "(GMT-06:00) Mountain Time (US & Canada)", "", "", "", group "0"
    And I navigate to basic
    And I verify basic identification values "", "", "http://www.TommysSurfSchool.edu", "Garth Bolbeck"
    And I verify basic context values "(GMT-06:00) Mountain Time (US & Canada)", "Edward Rooney"
    #to create a 3rd organization to merge to verify null values do not overwrite existing values
    When I create an organization
      |Name					     |Role		             |Phone		     |PhoneType  |Address1			            |City	  |State   |PostalCode |Country		  |
      |Tommy Bahama Surf School1 |Religious Institution   |203-855-2857   |Business   |11853 Ferris Bueller Boulevard|Rochester|New York|82463      |United States |
    And I validate if "A duplicate Organization record was found and automatically merged with the new record." message is correct
    And I verify the record header for organization "Tommy Bahama Surf School1", "OK to Contact: Yes", "Record Status: Active" and ""
    And I navigate to contact
    And I verify organization name "Tommy Bahama Surf School1" on contact
    And I verify phone number on contact for organization "", "", "", "(GMT-06:00) Mountain Time (US & Canada)", "", "", "", group "0"
    And I navigate to basic
    And I verify basic identification values "", "", "http://www.TommysSurfSchool.edu", "Garth Bolbeck"
    And I verify basic context values "(GMT-06:00) Mountain Time (US & Canada)", "Edward Rooney"