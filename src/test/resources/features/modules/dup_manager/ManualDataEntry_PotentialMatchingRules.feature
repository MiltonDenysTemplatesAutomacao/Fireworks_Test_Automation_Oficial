#Author: Milton Silva
#TL-169: Potential Match on rule 3: FN-LN-Email
#Regression testcase TL-169 rule 5: FN-LN-Phone
#Regression testcase TL-280: Non-Student: Resolution Rules for grouped data
#Regression testcase TL-169 rule 6: FN-LN-BDate
#Regression testcase TL-608: Record Flag Values are Reflected in Merged Record
#Regression testcase TL-169: rule 7 FN-Email-PostalCode(first 5)
#Regression test for FW-10046: Bounce email address not reset to Primary after partial match merge

@PotentialMatchRules
Feature: Manual Data Entry: Person: Potential Matching Rules

  @PotentialMatchRules3 @Done @DupManager
  Scenario: Record - DupManager - verify a potential match on first last and email address is detected
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |Role1     |EmailAddress       |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Usain      |Bolt      |Student   |UBolt@sprinter.com |Personal   |Inquiry         |Freshman   |Accepted              |Accepted       |01/15/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName  |LastName  |Role1     |EmailAddress       |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Usain      |Bolt      |Student   |UBolt@sprinter.com |Personal   |Inquiry         |Freshman   |Accepted              |Accepted       |01/15/2016       |Fall 2017|
    And I validate if "A potential duplicate Student record was found while creating this record; it has been placed in the Duplicate Manager for review." message is correct

  @PotentialMatchRules5 @Done @DupManager
  Scenario: Record - DupManager - non-matching address field groups are correct after potential match merge
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |Role1   |Phone          |PhoneType|Address1             |City        |State     |PostalCode|Country       |
      |Timothy    |Cook      |Person  |(916) 691-5757 |Home     |9520 Emerald Park Dr |Elk Grove   |California|95758     |United States |
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName  |LastName  |Role1   |Phone          |PhoneType|Address1              |City      |State      |PostalCode|Country       |
      |Timothy    |Cook      |Donor   |(916) 691-5757 |Home     |10124 Emerald Park Dr |Houston   |Texas      |77070     |United States |
      |Timothy    |Cook      |Person  |(916) 691-5757 |Home     |9520 Emerald Park Dr  |Elk Grove |California |95758     |United States |
    And I close alert if return this message "A potential duplicate Person record was found while creating this record; it has been placed in the Duplicate Manager for review."
    #to verify the suspended and possible match records then merge those records
    And I verify content of the suspended record person 0
    And I verify content of the first possible match record person 1
    And I merge duplicates
    And I verify merge preview 0
    And I confirm merge and close
    #to verify the address fields, primary flags, and role are correct
    And I navigate to people on records
    And I open a people record by "Timothy"
    And I validate if "Timothy"summary opened properly
    And I verify Header Role "Multiple"
    And I navigate to contact
    And I verify address on contact por person "10124 Emerald Park Dr", "", "", "", "Houston", "", "Texas", "", "United States", "77070", "TX15", "Home", "", "", "1", "1" group "0"
    And I verify address on contact por person "9520 Emerald Park Dr", "", "", "", "Elk Grove", "", "California", "", "United States", "95758", "CA03", "Home", "", "", "1", "0" group "1"

  @PotentialMatchRules6 @Done @DupManager
  Scenario: Record - DupManager - verify record flag values are reflected in merged record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName   |Role1   |EmailAddress          |EmailType|EmailOptInMethod|
      |Alisa      |Freyndlikh |Person  |AFreyndlikh@actors.com|Personal |Inquiry         |
    And I validate if "Person has been created." message is correct
    And I validate if "Alisa"summary opened properly
    And I navigate to basic
    And I update birth values "12/08/1934", "", "", ""
    And I click on save changes on basic
    And I close alert if return this message "Person has been updated."
    #to add another person record
    When I create a person
      |FirstName  |LastName   |Role1   |Phone          |PhoneType|EmailAddress          |EmailType|EmailOptInMethod|
      |Alisa      |Freyndlikh |Person  |(703) 777-6650 |Fax      |                      |         |                |
      |Alisa      |Freyndlikh |Person  |               |         |AFreyndlikh@actors.com|Personal |Inquiry         |
    And I validate if "Person has been created." message is correct
    #to set record flags and add the same birth date to trigger a potential match
    And I validate if "Alisa"summary opened properly
    And I navigate to basic
    And I update record flag values "Deceased", "Veteran"
    And I update birth values "12/08/1934", "", "", ""
    And I click on save changes on basic
    And I close alert if return this message "A potential duplicate Person record was found while creating this record; it has been placed in the Duplicate Manager for review."
    And I verify content of the suspended record person 0
    And I verify content of the first possible match record person 1
    And I merge duplicates
    And I verify merge preview 0
    And I confirm merge and close
    #to verify the merged record
    And I navigate to people on records
    And I open a people record by "Alisa"
    And I validate if "Alisa"summary opened properly
    And I navigate to basic
    And I verify birth values "12/08/1934", "", "", ""
    And I verify record flags "Deceased", "", "", "", "", "", "Veteran"

  @PotentialMatchRules7 @Done @DupManager
  Scenario: Record - DupManager - Potential match - FN-Email-PostalCode
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create a student and person record with a partial match
    When I create a person
      |FirstName  |LastName  |Role1    |EmailAddress        |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|Address1              |City      |State      |PostalCode|Country       |
      |Tyson      |Apostol   |Student  |tyson@realfamous.net|Personal   |Inquiry         |Freshman   |Accepted              |Accepted       |01/25/2016       |Fall 2017|395 N. State St.      |Lindon    |Utah       |84042     |United States |
    And I validate if "Person has been created." message is correct
    #to update the email status to Bounce
    And I validate if "Tyson"summary opened properly
    And I navigate to contact
    And I update email on contact for person "", "", "Bounce", "", "", "", "", "" and group "0"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    And I verify email address "", "", "Bounce", "", "", "", "", "0", "0" group "0"
    When I create a person
      |FirstName  |LastName |Role1     |Address1              |City      |State      |PostalCode|Country       |EmailAddress        |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Tyson      |Fury     |Person    |584 W. Gillman Lane   |Lindon    |Utah       |84042     |United States |tyson@realfamous.net|Personal   |Application     |           |                      |               |                 |         |
      |Tyson      |Apostol  |Student   |395 N. State St.      |Lindon    |Utah       |84042     |United States |tyson@realfamous.net|Personal   |Inquiry         |Freshman   |Accepted              |Accepted       |01/25/2016       |Fall 2017|
    And I close alert if return this message "A potential duplicate Person record was found while creating this record; it has been placed in the Duplicate Manager for review."
    #to verify the suspended and possible match records then merge those records
    And I verify content of the suspended record person 0
    And I verify content of the first possible match record person 1
    And I merge duplicates
    And I verify merge preview 1
    And I confirm merge and go
    #to verify the address fields, primary flags, and role are correct
    And I validate if "Tyson Apostol"summary opened properly
    And I navigate to contact
    And I verify name on contact for person "Tyson", "Apostol", "", "", "", "", "1", "1" group "0"
    And I verify name on contact for person "Tyson", "Fury", "", "", "", "", "1", "0" group "1"
    And I verify address on contact por person "395 N. State St.", "", "", "", "Lindon", "", "Utah", "", "United States", "84042", "UT01", "Home", "", "", "1", "1" group "0"
    And I verify address on contact por person "584 W. Gillman Lane", "", "", "", "Lindon", "", "Utah", "", "United States", "84042", "UT01", "Home", "", "", "1", "0" group "1"
    And I verify email address "", "", "Bounce", "", "", "", "", "", "" group "0"
