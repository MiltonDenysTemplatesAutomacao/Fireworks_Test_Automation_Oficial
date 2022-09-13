#Author: Milton Silva
#Regression testcase TL-205: Exact match auto-merge on rule 3: SSN-LastName
#Regression testcase TL-205: Exact match auto-merge on rule 6: IDType-ID-FN(first3)
#Regression testcase TL-806: Relationships are not lost in record merges
#Regression testcase TL-205: Exact match auto-merge on rule 10: FN-LN-Phone-Email-Role
#Regression testcase TL-371: Resolution Rules for Student data

@ExactMatchAutoMergeOnrule
Feature: Auto-Merge: Person: Standard Matching Rules

  @ExactMatchAutoMergeOnrule3 @Done @DupManager
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

  @ExactMatchAutoMergeOnrule6 @Done @DupManager
  Scenario: Record - DupManager - verify that relationships are maintained after a merge on person records
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |Role1     |EmailAddress                 |EmailType  |EmailOptInMethod|
      |Yoshifumi  |Kondo    |Person    |yKondo@japanesedirectors.com |Personal   |Inquiry         |
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName |LastName |Role1     |EmailAddress                  |EmailType  |EmailOptInMethod|
      |Hiroyuki  |Morita   |Person    |hMorita@japanesedirectors.com |Personal   |Inquiry         |
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName |LastName    |Role1     |EmailAddress                       |EmailType  |EmailOptInMethod|
      |Hiromasa  |Yonebayashi |Person    |hYonebayashi@japanesedirectors.com |Personal   |Inquiry         |
    And I validate if "Person has been created." message is correct
    #to create a relationship between person1 and person2
    And I navigate to people on records
    And I open a people record by "Yoshifumi"
    And I validate if "Yoshifumi"summary opened properly
    And I navigate to Relationship
    When I create a relationship
    And I open a record picker "Hiroyuki"
    And I update relationship "Son", "Father", ""
    And I click on save changes on Relationships
    And I close alert if return this message "Relationship has been created"
    #to add the same external id to person2 and person3 to auto-merge the records
    And I navigate to people on records
    And I open a people record by "Hiroyuki"
    And I validate if "Hiroyuki"summary opened properly
    And I navigate to ID Types
    And I use datatable
    |IDType|IDNumber|RecordedDate|WhoAddedID    |Comments   |
    |TOEFL |72918   |01/15/2016  |Fire Starter  |ID Comment |
    When I update "IDType", "IDNumber", "RecordedDate", "WhoAddedID", and "Comments" to update external ID Types for person
    And I close alert if return this message "Person has been updated."
    And I navigate to people on records
    And I open a people record by "Hiromasa"
    And I validate if "Hiromasa"summary opened properly
    And I navigate to ID Types
    When I update "IDType", "IDNumber", "RecordedDate", "WhoAddedID", and "Comments" to update external ID Types for person
    And I close alert if return this message "A duplicate Person record was found and automatically merged with the new record."
    #person3 now shows a relationship to person1
    And I navigate to Relationship
    And I open a relationship "Yoshifumi"
    And I verify relationship values "Yoshifumi Kondo", "Father", "Son", "", ""

  @ExactMatchAutoMergeExactMatchPersonRule10 @Done @DupManager
  Scenario: Record - DupManager - verify an exact match occurs based on first last phone email and role
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |Role1 |EmailAddress               |EmailType  |EmailOptInMethod|Phone        |PhoneType|
      |Rudolf     |Agricola |Donor |RAgricola@germanauthors.com|Personal   |Inquiry         |555-555-5559 |Home     |
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName  |LastName |Role1 |EmailAddress               |EmailType  |EmailOptInMethod|Phone        |PhoneType|
      |Rudolf     |Agricola |Donor |RAgricola@germanauthors.com|Personal   |Inquiry         |555-555-5559 |Home     |
    And I close alert if return this message "A duplicate Person record was found and automatically merged with the new record."

  @ExactMatchAutoMergeExclusionsCanExactMatchRule10 @Done @DupManager
  Scenario: Record - DupManager - verify suspended records which are made active can be exact match merged
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName  |Role1   |EmailAddress                           |EmailType  |EmailOptInMethod|Phone         |PhoneType|StudentType|StudentStatus  |StudentStatusCategory|StudentStatusDate|EntryTerm|
      |Koji       |Wakamatsu |Student |KWakamatsu@japanesenewwavedirectors.net|Personal   |Inquiry         |(516) 453-3612|Home     |Freshman   |Inquiry-Active |Inquiry              |01/25/2020       |Fall 2021|
    And I validate if "Person has been created." message is correct
    #to add a second record that potentially matches based on name and phone number
    When I create a person
      |FirstName  |LastName  |FullName        |Role1   |EmailAddress                             |EmailType  |EmailOptInMethod|Phone         |PhoneType|StudentType|StudentStatus  |StudentStatusCategory|StudentStatusDate|EntryTerm|
      |Koji       |Wakamatsu |Koji Wakamatsu  |Student |KWakamatsu2@japanesenewwavedirectors.net |Personal   |Inquiry         |(516) 453-3612|Home     |Freshman   |Inquiry-Active |Inquiry              |01/25/2020       |Fall 2021|
      |           |Wakamatsu |Koji Wakamatsu  |Student |KWakamatsu@japanesenewwavedirectors.net  |           |                |(516) 453-3612|         |           |               |                     |                 |         |
    And I validate if "A potential duplicate Student record was found while creating this record; it has been placed in the Duplicate Manager for review." message is correct
    #to verify content of Suspended Record and the First Match then make the record Active
    And I verify content of the suspended record person 0
    And I verify content of the first possible match record person 1
    And I make suspended record active
    And I close alert if return this message "Incoming record successfully activated."
    #to verify the record was removed from the Duplicates Page
    And I navigate to duplicates
    And I validate if "Koji Wakamatsu" record lo longer exists on the duplicates page
    And I search "LastName" on duplicate manager person 1
    And I validate if "Koji Wakamatsu" record lo longer exists on the duplicates page
    And I navigate to people on records
    And I open a people record by "Wakamatsu"
    And I validate if "Wakamatsu"summary opened properly
    And I navigate to contact
    And I add a new email on contact for person group "0"
    And I update email on contact for person "KWakamatsu@japanesenewwavedirectors.net", "School", "", "Inquiry", "", "", "1", "" and group "1"
    And I click on save changes in contact for person
    And I close alert if return this message "A duplicate Student record was found and automatically merged with the new record."
    #an new incoming record can be matched to the previously suspended record
    When I create a person
      |FirstName  |LastName  |Role1   |EmailAddress                            |EmailType  |EmailOptInMethod|StudentType|StudentStatus  |StudentStatusCategory|StudentStatusDate|EntryTerm|
      |Koji       |Wakamatsu |Student |KWakamatsu2@japanesenewwavedirectors.net|Personal   |Inquiry         |Freshman   |Inquiry-Active |Inquiry              |01/25/2020       |Fall 2021|
      |Koji       |Wakamatsu |Student |KWakamatsu2@japanesenewwavedirectors.net|Personal   |Inquiry         |Freshman   |Inquiry-Active |Inquiry              |01/25/2020       |Fall 2021|
    And I close alert if return this message "A potential duplicate Student record was found while creating this record; it has been placed in the Duplicate Manager for review."
    And I verify content of the suspended record person 0
    And I verify content of the first possible match record person 1

  @ResolutionRulesForStudentDataRule10 @Done @DupManager
  Scenario: Record - DupManager - verify resolution rules for student data
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create an import package
    When I navigate to ImportsPackagesPage
    And I create a package
    And I update PackageStartTab "StudentStatus Update Test", "", "ImportStudentStatusTest01Enrolled.zip", "Student"
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
    And I click save and continue button "Required"
    And I click on "Save & Continue"
    And I update Package Actions "Campus Event", "Admitted Student Day: Attend", ""
    And I click on "Save & Continue"
    #to run the import
    And I click on "Make Ready & Run"
    And I verify if package settings were loaded "StudentStatus Update Test", "ImportStudentStatusTest01Enrolled.zip"
    And I click on review import button
    And I click on Run Import button
    Then I validate if "Completed" status is displayed for package "StudentStatus Update Test"
    #step above failing, need this step to go ahead

