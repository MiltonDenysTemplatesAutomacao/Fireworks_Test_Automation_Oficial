#Author: Milton Silva
#TL-169: Potential Match on rule 3: FN-LN-Email
#Regression testcase TL-169 rule 5: FN-LN-Phone
#Regression testcase TL-280: Non-Student: Resolution Rules for grouped data
#Regression testcase TL-169 rule 6: FN-LN-BDate
#Regression testcase TL-608: Record Flag Values are Reflected in Merged Record
#Regression testcase TL-169: rule 7 FN-Email-PostalCode(first 5)
#Regression test for FW-10046: Bounce email address not reset to Primary after partial match merge
#Regression testcase TL-216: Comparison: Multiple Potential Matches
#Regression testcase TL-169 rule 10: FN-Zip-Phone
#Regression testcase TL-203: Grouped fields: All active groups considered
#Regression testcase TL-169 rule 16: LN-Phone-PostalCode
#Regression testcase TL-961: Merge and Go to Record

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
    And I verify content of the "0" possible match record person 1
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
    And I verify content of the "0" possible match record person 1
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
    And I verify content of the "0" possible match record person 1
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

  @PotentialMatchRules8 @Done @DupManager
  Scenario: Record - DupManager - verify that a record matches three potential matches and can be merged with all of the potential matches in duplicate manager
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create a student and person record with a partial match
    When I create a person
      |FirstName  |LastName  |FullName        |Role1    |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|Phone          |PhoneType|
      |Tetsuji    |Takechi   |Tetsuji Takechi |Student  |Freshman   |Inquiry               |Inquiry-Active |01/25/2020       |Fall 2020|(803) 724-4658 |Home     |
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName  |LastName  |FullName       |Role1    |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|EmailAddress                 |EmailType  |EmailOptInMethod |
      |Tetsuji    |Takechi   |Tetsuji Takechi|Student  |Freshman   |Inquiry               |Inquiry-Active |01/25/2020       |Fall 2020|Tetsuji@japanesedirectors.net|Personal   |Inquiry          |
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName  |LastName  |FullName         |Role1    |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|Phone          |PhoneType|EmailAddress                 |EmailType  |EmailOptInMethod |
      |Tetsuji    |Morohashi |Tetsuji Morohashi|Student  |Freshman   |Inquiry               |Inquiry-Active |01/25/2020       |Fall 2020|(803) 724-4658 |Home     |Tetsuji@japanesedirectors.net|Personal   |Inquiry          |
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName  |LastName  |FullName       |Role1    |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|Phone          |PhoneType|EmailAddress                 |EmailType  |EmailOptInMethod |
      |Tetsuji    |Takechi   |Tetsuji Takechi|Student  |Freshman   |Inquiry               |Inquiry-Active |01/25/2020       |Fall 2020|(803) 724-4658 |Home     |Tetsuji@japanesedirectors.net|Personal   |Inquiry          |
    And I close alert if return this message "A potential duplicate Student record was found while creating this record; it has been placed in the Duplicate Manager for review."
    #to merge the first pair
    And I verify content of the suspended record person 0
    And I use datatable
    |FullName         |Role1  |EmailAddress                 |Phone          |LastName|
    |Tetsuji Takechi  |Student|Tetsuji@japanesedirectors.net|               |Takechi |
    |Tetsuji Takechi  |Student|                             |(803) 724-4658 |        |
    |Tetsuji Morohashi|Student|Tetsuji@japanesedirectors.net|(803) 724-4658 |        |
    |Tetsuji Takechi|Student|Tetsuji@japanesedirectors.net|(803) 724-4658 |        |
    And I verify content of the "0" possible match record person 0
    And I verify content of the "1" possible match record person 1
    And I verify content of the "2" possible match record person 2
    And I merge duplicates
    And I verify merge preview 3
    And I confirm merge and close
    #to merge the next pair
    And I navigate to duplicates
    And I search "LastName" on duplicate manager person 0
    And I open a duplicate
    And I verify content of the suspended record person 0
    And I merge duplicates
    And I verify merge preview 3
    And I confirm merge and close
    #to merge the last pair
    And I navigate to duplicates
    And I search "LastName" on duplicate manager person 0
    And I open a duplicate
    And I verify content of the suspended record person 0
    And I merge duplicates
    And I verify merge preview 3
    And I confirm merge and close
    #to verify all records were merged
    And I validate if "Tetsuji Takechi" record lo longer exists on the duplicates page
    And I navigate to duplicates
    And I validate if "Tetsuji Takechi" record lo longer exists on the duplicates page
    And I search "LastName" on duplicate manager person 0
    And I validate if "Tetsuji Takechi" record lo longer exists on the duplicates page

  @PotentialMatchRules10 @Done @DupManager
  Scenario: Record - DupManager - existing student with non-primary field groups is matched to an incoming person
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create a student and then add non-primary name and address data
    When I create a person
      |FirstName  |LastName  |FullName       |Role1    |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|Phone          |PhoneType|Address1              |City         |State         |PostalCode|Country      |
      |Eliza      |Pinckney  |Eliza Pinckney |Student  |Freshman   |Inquiry               |Inquiry-Active |01/25/2026       |Fall 2017|(215) 925-5968 |Home     |261 Island Park Dr    |Daniel Island|South Carolina|29492     |United States|
    And I validate if "Person has been created." message is correct
    And I validate if "Eliza"summary opened properly
    And I navigate to contact
    And I add a name group "0"
    When I create a name on contact for person "Elizabeth", "Lucas", "", "", "", "", "1", "" group "1"
    And I add phone "0"
    When I update phone number in contact for person "(803) 252-1974", "Home", "", "", "", "", "1", "" field group "1"
    And I add address "0"
    And I create address on contact for person "37 Church St", "", "", "", "Charleston", "South Carolina", "", "United States", "29401", "Home", "", "", "1", "", group "1"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    #to create a donor record that matches the non-primary field groups
    When I create a person
      |FirstName  |LastName |FullName        |Role1    |Phone          |PhoneType|Address1              |City         |State         |PostalCode|Country      |StudentType|StudentStatusCategory |StudentStatus  |StudentStatusDate|EntryTerm|
      |Elizabeth  |Lucas    |Elizabeth Lucas |Donor    |(803) 252-1974 |Home     |37 Church St          |Charleston   |South Carolina|29401     |United States|           |                      |               |                 |         |
      |Eliza      |Pinckney |Eliza Pinckney  |Student  |(215) 925-5968 |Home     |261 Island Park Dr    |Daniel Island|South Carolina|29492     |United States|Freshman   |Inquiry               |Inquiry-Active |01/25/2016       |Fall 2017|
    And I close alert if return this message "A potential duplicate Person record was found while creating this record; it has been placed in the Duplicate Manager for review."
    #to verify content of suspended record and first possible match then merge the records
    And I verify content of the suspended record person 0
    And I verify content of the "0" possible match record person 1
    And I merge duplicates
    And I verify merge preview 1
    And I confirm merge and close
    #to verify the records are no longer listed on the duplicates page
    And I navigate to duplicates
    And I validate if "Eliza Pinckney" record lo longer exists on the duplicates page
    And I search "LastName" on duplicate manager person 1
    And I validate if "Eliza Pinckney" record lo longer exists on the duplicates page
    #to verify contact data
    And I navigate to people on records
    And I open a people record by "Pinckney"
    And I validate if "Pinckney"summary opened properly
    And I verify Header Role "Multiple"
    And I navigate to contact
    And I verify name on contact for person "Eliza", "Pinckney", "", "", "", "", "1", "1" group "0"
    And I verify name on contact for person "Elizabeth", "Lucas", "", "", "", "", "1", "" group "1"
    And I verify phone number on contact for person "(215) 925-5968", "Home", "", "", "", "", "", "", "1", "1", group "0"
    And I verify phone number on contact for person "(803) 252-1974", "Home", "", "", "", "", "", "", "1", "", group "1"
    And I verify address on contact por person "261 Island Park Dr", "", "", "", "Daniel Island", "", "South Carolina", "", "United States", "29492", "SC02", "Home", "", "", "1", "1" group "0"
    And I verify address on contact por person "37 Church St", "", "", "", "Charleston", "", "South Carolina", "", "United States", "29401", "SC02", "Home", "", "", "1", "" group "1"

  @PotentialMatchRules16 @Done @DupManager
  Scenario: Record - DupManager - verify duplicate manager merge modal buttons - Merge and Go & Merge and Close
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create a student and then add non-primary name and address data
    When I create a person
      |FirstName  |LastName  |FullName        |Role1    |Phone          |PhoneType|Address1             |City   |State         |PostalCode|Country      |
      |Gastan     |Strobino  |Gastan Strobino |Person   |(917) 247-8763 |Home     |197 Marconi Court    |Clifton|South Carolina|07011     |United States|
    And I validate if "Person has been created." message is correct
    #to create a duplicate person to test Merge and Go
    When I create a person
      |FirstName  |LastName  |FullName        |Role1    |Phone          |PhoneType|Address1             |City   |State         |PostalCode|Country      |
      |Gaston     |Strobino  |Gaston Strobino |Person   |(917) 247-8763 |Home     |197D Marconi Court   |Clifton|South Carolina|07011     |United States|
      |Gastan     |Strobino  |Gastan Strobino |Person   |(917) 247-8763 |Home     |197 Marconi Court    |Clifton|South Carolina|07011     |United States|
    And I close alert if return this message "A potential duplicate Person record was found while creating this record; it has been placed in the Duplicate Manager for review."
    #clicking Merge and Go will redirect to the merged record
    And I verify content of the suspended record person 0
    And I verify content of the "0" possible match record person 1
    And I merge duplicates
    And I verify merge preview 0
    And I confirm merge and go
    And I close alert if return this message "Duplicate record merged successfully."
    And I validate if "Gaston Strobino"summary opened properly
    And I verify Header Role "Person"
    And I verify Header Record Status "Active" for person
    #to create another duplicate person to test Merge and Close
    When I create a person
      |FirstName  |LastName  |FullName        |Role1    |Phone          |PhoneType|Address1              |City   |State     |PostalCode|Country      |
      |Gastan     |Strobino  |Gastan Strobino |Person   |(917) 247-8763 |Home     |197-D Marconi Court   |Clifton|New Jersey|07011     |United States|
      |Gaston     |Strobino  |Gaston Strobino |Person   |(917) 247-8763 |Home     |197D Marconi Court   |Clifton|South Carolina|07011     |United States|
    And I close alert if return this message "A potential duplicate Person record was found while creating this record; it has been placed in the Duplicate Manager for review."
    #clicking Merge and Close will redirect to duplicate manager table
    And I verify content of the suspended record person 0
    And I verify content of the "0" possible match record person 1
    And I merge duplicates
    And I verify merge preview 0
    And I confirm merge and close
    And I validate if "Strobino" record lo longer exists on the duplicates page
    And I validate if "Gaston" record lo longer exists on the duplicates page
    And I validate if "Gastan" record lo longer exists on the duplicates page
    And I navigate to duplicates
    And I validate if "Strobino" record lo longer exists on the duplicates page
    And I validate if "Gaston" record lo longer exists on the duplicates page
    And I validate if "Gastan" record lo longer exists on the duplicates page
    And I navigate to people on records
    And I search "Strobino" on people page manager
    And I validate if "Gastan" message on datatable is displayed
