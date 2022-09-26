#Author: Milton Silva
#Regression testcase TL-504: Import: Duplicate Exact Matching Rules

@DuplicateExactMatchingRules
Feature: Manual Data Entry: Person: Potential Matching Rules

  @DuplicateExactMatchingRulesScenario @Fix @DupManager
  Scenario: Record - DupManager - verify the exact match rules using import
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a staff
      |FirstName |LastName  |FullName  |EmailAddress       |EmailType|PermissionGroup |
      |Just      |Fury      |Just Fury |justfury@shield.com|Personal |Administrator   |
    And I validate if "Staff member has been created. They have been sent a welcome email with a link prompting them to login and create a password. The link in this email will expire in 12 hours." message is correct
    #to create an import package
  And I navigate to ImportsPackagesPage
    And I create a package
    And I update PackageStartTab "Import Exact Match Test 0504", "", "ExactMatchTest-Base.csv", "Student"
    And I click save and continue button "Start"
    And I map required fields "Student Type"
    And I map required fields "Student Status Category"
    And I map required fields "Student Status Field"
    And I map required fields "Entry Term"
    And I map required fields "Student Status Date"
    And I map required fields "Role"
    And I map required fields "First Name"
    And I map required fields "Last Name"
    And I map required fields "Email Address"
    And I map required fields "Email Type"
    And I map required fields "Opt In Method"
    And I map required fields "Phone Number"
    And I map required fields "Phone Type"
    And I map required fields "Street 1"
    And I map required fields "Street 2"
    And I map required fields "City"
    And I map required fields "State"
    And I map required fields "Zip"
    And I map required fields "Country"
    And I map required fields "Address Type"