#Author: Milton Silva
#Regression testcase TL-280: Non-Student: Resolution Rules for grouped data

@NonstudentResolutionRulesForGroupData
Feature: Non-Student: Resolution Rules for grouped data

  @PotencialMatchDuplicateActionsMerged @Done @DupManager
  Scenario: Record - DupManager - verify duplicate actions are merged during potential match merge
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |Role1    |EmailAddress        |EmailType  |EmailOptInMethod|Phone     |PhoneType|Category     |Action                       |Staff       |ActionDateTime    |ActionDateField|Comments            |
      |Shivaughn  |McKenna   |Person   |SMcKenna@actors.com |Personal   |Inquiry         |8722959142|Mobile   |Campus Events|Admitted Student Day: Attend |Fire Starter|01/01/2016 2:00 PM|01/01/2016     |person1ActionComment|
    And I validate if "Person has been created." message is correct
    #to add an action to this person record
    And I validate if "Shivaughn"summary opened properly
    And I navigate to Actions
    And I click on add action button
    And I update action person "0"
    Then I click on Save Changes button in Actions
    And I validate if "Action has been created." message is correct
    When I create a person
      |FirstName  |LastName  |Role1   |Phone     |PhoneType|Category     |Action                       |Staff       |ActionDateTime    |ActionDateField|Comments            |
      |Siobhan    |McKenna   |Person  |8722959142|Mobile   |Campus Events|Admitted Student Day: Attend |Fire Starter|01/01/2016 2:00 PM|01/01/2016     |person2ActionComment|
    And I validate if "Person has been created." message is correct
    #to add an identical action to this person record
    And I validate if "Siobhan McKenna"summary opened properly
    And I navigate to Actions
    And I click on add action button
    And I update action person "0"
    Then I click on Save Changes button in Actions
    And I validate if "Action has been created." message is correct
    #to add an email address that matches the first record and triggers a potential match
    And I navigate to contact
    And I update email on contact for person "SMcKenna@actors.com", "Personal", "", "Inquiry", "", "", "1", "" and group "0"
    And I click on save changes in contact for person
    And I validate if "A potential duplicate Person record was found while creating this record; it has been placed in the Duplicate Manager for review." message is correct
    #to merge the records and verify one action is present but both comments are listed
    And I use datatable
      |FirstName  |LastName  |Role1    |EmailAddress        |EmailType  |EmailOptInMethod|Phone         |PhoneType|Comments             |
      |Shivaughn  |McKenna   |Person   |SMcKenna@actors.com |Personal   |Inquiry         |(872) 295-9142|Mobile   |person1ActionComment |
      |Siobhan    |McKenna   |Person   |                    |           |                |(872) 295-9142|Mobile   |person2ActionComment |
    And I verify content of the suspended record person 1
    And I verify content of the "0" possible match record person 0
    And I merge duplicates
    And I verify merge preview 1
    And I confirm merge and go
    And I validate if "Siobhan McKenna"summary opened properly
    And I navigate to Actions
    And I verify if action manager table on actions row 1 is displayed
    And I verify if action manager table on actions row 2 is not displayed
    And I verify action Datatable values index "0", values "Campus Events", "Admitted Student Day: Attend", "Fire Starter", "01/01/2016", ""
    And I open an action "Campus Events"
    And I use datatable
    |Comments              |
    |person1ActionComment  |

    And I verify default action values index "0"
#    And I verify default action values index "1"

  @PotencialMatchEmailAddressesMerged @Done @DupManager
  Scenario: Record - DupManager - verify duplicate actions are merged during potential match merge
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName      |Role1    |EmailAddress            |EmailType  |EmailOptInMethod|Address1   |City  |PostalCode|State   |Country      |
      |Baron      |VonRedBerry   |Person   |BVonRedBerry@cereal.com |Personal   |Inquiry         |113 Main St|Denver|80222     |Colorado|United States|
    And I validate if "Person has been created." message is correct
    #to add a second email addresses for matching
    And I validate if "Baron VonRedBerry"summary opened properly
    And I navigate to contact
    And I add a new email on contact for person group "0"
    And I update email on contact for person "VonRedBerry@cereal.com", "Personal", "", "Campus Visit", "Subscribed", "", "", "" and group "1"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    When I create a person
      |FirstName  |LastName      |Role1    |EmailAddress            |EmailType|EmailOptInMethod|Phone         |PhoneType|
      |Baron      |VonRedBerry   |Person   |VonRedBerry@cereal.com  |School   |Campus Visit    |(720) 266-6651|Fax      |
      |Baron      |VonRedBerry   |Person   |BVonRedBerry@cereal.com |Personal |Inquiry         |              |         |
    And I validate if "A potential duplicate Person record was found while creating this record; it has been placed in the Duplicate Manager for review." message is correct
    #to manually merge the two records
    And I verify content of the suspended record person 0
    And I verify content of the "0" possible match record person 1
    And I merge duplicates
    And I verify merge preview 0
    And I confirm merge and close
    #the email address of the winning record is primary
    And I navigate to people on records
    And I open a people record by "VonRedBerry"
    And I validate if "Baron VonRedBerry"summary opened properly
    And I navigate to contact
    And I verify email address "VonRedBerry@cereal.com", "School", "Valid", "Campus Visit", "Subscribed", "", "", "1", "1" group "0"
#    #to make the 2nd email address of the merged record inactive
    And I update email on contact for person "", "", "", "", "", "", "1", "" and group "1"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    And I verify email address "BVonRedBerry@cereal.com", "Personal", "Valid", "Inquiry", "", "", "", "0", "0" group "1"
#    #to add a third person with a phone that matches the merged record to initiate the potential duplicate process
    When I create a person
      |FirstName  |LastName      |Role1    |EmailAddress                |EmailType  |EmailOptInMethod|Phone           |PhoneType|
      |Baron      |VonRedBerry   |Person   |BaronVonRedBerry@cereal.com |Business   |Student Search  |(720) 266-6651  |Business |
      |Baron      |VonRedBerry   |Person   |VonRedBerry@cereal.com      |           |                |(720) 266-6651  |         |
    And I validate if "A potential duplicate Person record was found while creating this record; it has been placed in the Duplicate Manager for review." message is correct
    #to merge the new record with the previously merged records
    And I verify content of the suspended record person 0
    And I verify content of the "0" possible match record person 1
    And I merge duplicates
    And I verify merge preview 0
    And I confirm merge and close
    #the email from the incoming third record should now be primary
    And I navigate to people on records
    And I open a people record by "VonRedBerry"
    And I validate if "Baron VonRedBerry"summary opened properly
    And I navigate to contact
    And I verify email address "BaronVonRedBerry@cereal.com", "Business", "", "Student Search", "", "", "", "1", "1" group "0"
    And I verify email address "VonRedBerry@cereal.com", "School", "Valid", "Campus Visit", "Subscribed", "", "", "1", "0" group "1"
    And I verify email address "BVonRedBerry@cereal.com", "Personal", "Valid", "Inquiry", "", "", "", "0", "0" group "2"
