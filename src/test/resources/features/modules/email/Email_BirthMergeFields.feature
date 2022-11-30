#Author: Milton Silva
#Regression testcase TL-299: Merge Fields Replacement when No Value
#FW-7567: Number of recipients static in the Sent Email view

@MergeFieldsReplacementWhenNoValue
Feature: Merge Fields Replacement when No Value

  @MergeFieldsReplacementWhenNoValueScenarios @Done @Email
  Scenario: verify birth merge tags are replaced as expected
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |EmailAddress          |EmailType|EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|
      |Rhodes     |Priestly |rpriestly@oxygen.com  |Personal |Inquiry          |Student|Freshman   |Accepted             |Accepted     |02/23/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    And I validate if "Rhodes Priestly"summary opened properly
    And I navigate to basic
    And I update birth values "02/24/2000", "Russian Federation", "London", "Texas"
    And I click on save changes on basic
    And I close alert if return this message "Person has been updated."
    When I create a person
      |FirstName  |LastName |EmailAddress                |EmailType|EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|
      |Rhodes     |Bramah   |rbramah@hydraulicpress.com  |Personal |Inquiry          |Student|Freshman   |Accepted             |Accepted     |02/23/2017       |Fall 2017|
    And I validate if "Person has been created." message is correct
    And I validate if "Rhodes Priestly"summary opened properly
    And I navigate to basic
    And I update birth values "02/27/2000", "United States", "San Francisco", "California"
    And I click on save changes on basic
    And I close alert if return this message "Person has been updated."
    When I create a person
      |FirstName  |LastName |EmailAddress             |EmailType|EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|
      |Rhodes     |Burkhart |rburkhart@wisconsin.com  |Personal |Inquiry          |Student|Freshman   |Accepted             |Accepted     |02/23/2018       |Fall 2017|
    And I validate if "Person has been created." message is correct
    #to create a smart search
    And I navigate to smart search page
    And I click on create smart search button
    And I select "First Name" search field group "0" condition "0" in smart search composer
    And I select "equals" operator field group "0" condition "0" in smart search composer
    And I fill "Rhodes" text group "0" condition "0"
    And I fill smart search name "Birth data 6140"
    And I click on save this search button
    And I close alert if return this message "Smart Search has been created."
    #to create an email
    And I navigate to email manager page
    And I click on create a new email button and select type "Direct"
    When I update Email Start Tab "", "Birth Merge Tag test 6140", "", "Birth data 6140", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "", "firestarter@fire-engine-red.com", "", "Subject 6140 for [[NAME_FIRST]] [[NAME_LAST]]", "Preheader 6140 Birth Merge Tag test 6140", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I update Email Content Tab "Name: [[NAME_FIRST]] [[NAME_LAST]]. The persons birth date is: [[BIRTH_DATE]]. The persons birth city is: [[BIRTH_CITY]]. The persons birth state is: [[BIRTH_STATE]]. The persons birth country is: [[BIRTH_COUNTRY]]", "Name: [[NAME_FIRST]] [[NAME_LAST]]. The persons birth date is: [[BIRTH_DATE]]. The persons birth city is: [[BIRTH_CITY]]. The persons birth state is: [[BIRTH_STATE]]. The persons birth country is: [[BIRTH_COUNTRY]]"
    And I click on save and continue on Marketing Email Composer
    And I click on save and continue on Marketing Email Composer
    And I validate if "Email has been updated." message is correct
    #to send the email
    And I click on finish tab
    And I send email
    And I confirm EmailSend "Person"
    Then I validate if "Email has been queued." message is correct
    #to wait until the email is sent
    And I navigate to email manager page
    When I wait until email sent "Birth Merge Tag test 6140"
    #to verify merge tags were replaced correctly for person1
    When I verify if email was sent correctly "Subject 6140 for Rhodes Priestly", "firestarter@fire-engine-red.com", "", "Rhodes Priestly"
    And I verify email content on mail trap is "visible" for subject "Subject 6140 for Rhodes Priestly", "Name: Rhodes Priestly. The persons birth date is: February 24, 2000. The persons birth city is: London. The persons birth state is: Texas. The persons birth country is: Russian Federation", "Rhodes Priestly"
    #to verify merge tags were replaced correctly for person2
    When I verify if email was sent correctly "Subject 6140 for Rhodes Bramah", "firestarter@fire-engine-red.com", "", "Rhodes Bramah"
    And I verify email content on mail trap is "visible" for subject "Subject 6140 for Rhodes Bramah", "Name: Rhodes Bramah. The persons birth date is: February 27, 2000. The persons birth city is: San Francisco. The persons birth state is: California. The persons birth country is: United States", "Rhodes Bramah"
    #to verify merge tags were replaced correctly for person3
    When I verify if email was sent correctly "Subject 6140 for Rhodes Burkhart", "firestarter@fire-engine-red.com", "", "Rhodes Burkhart"
    And I verify email content on mail trap is "visible" for subject "Subject 6140 for Rhodes Burkhart", "Name: Rhodes Burkhart. The persons birth date is: . The persons birth city is: . The persons birth state is: . The persons birth country is:", "Rhodes Burkhart"
    #to update the name of person 3 to remove them from the smart search