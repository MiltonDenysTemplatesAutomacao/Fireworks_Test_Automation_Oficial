#Author: Milton Silva
#Regression testcase TL-279: Contact field groups: Composite Keys

@VerifyCompositeKeysAreHonoredInContactGroup
Feature: Contact field groups: Composite Keys

  @VerifyCompositeKeysAreHonoredInContactGroupScenarios @Done @Contact
  Scenario: Record - Contact - verify Composite Keys are honored in Contact group
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName|LastName |EmailAddress        |EmailType|EmailOptInMethod |Role1    |Phone         |PhoneType|Address1     |City      |State   |PostalCode|Country       |
      |Ray      |Kroc     |rkroc@mcdonalds.com |Personal |Inquiry          |Person   |(478) 623-1285|Mobile   |335 Dover Ct |Broomfield|Colorado|80020     |United States |
    And I validate if "Person has been created." message is correct
    And I navigate to people on records
    And I open a people record by "Ray"
    Then I validate if "Ray Kroc"summary opened properly
    And I navigate to contact
    And I add a name group "0"
    When I create a name on contact for person "Ray", "Kroc", "", "", "", "", "1", "" group "1"
    And I add a new email on contact for person group "0"
    And I update email on contact for person "rkroc@mcdonalds.com", "Personal", "", "Inquiry", "", "", "1", "" and group "1"
    And I add phone "0"
    When I update phone number in contact for person "(478) 623-1285", "Mobile", "", "", "", "", "1", "1" field group "1"
    And I add address "0"
    And I create address on contact for person "335 Dover Ct", "", "", "", "Broomfield", "Colorado", "", "United States", "80020", "Home", "", "", "1", "", group "1"
    And I click on save changes in contact for person
    And I verify validation message "Name 1: Must be unique."
    And I verify validation message "Name 2: Must be unique."
    And I verify validation message "Email Address 1: Must be unique."
    And I verify validation message "Email Address 2: Must be unique."
    And I verify validation message "Phone Number 1: Must be unique."
    And I verify validation message "Phone Number 2: Must be unique."
    And I verify validation message "Physical Address 1: Must be unique."
    And I verify validation message "Physical Address 2: Must be unique."