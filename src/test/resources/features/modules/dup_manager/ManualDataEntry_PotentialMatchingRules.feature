#Author: Milton Silva
#TL-169: Potential Match on rule 3: FN-LN-Email
#Regression testcase TL-169 rule 5: FN-LN-Phone
#Regression testcase TL-280: Non-Student: Resolution Rules for grouped data

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
