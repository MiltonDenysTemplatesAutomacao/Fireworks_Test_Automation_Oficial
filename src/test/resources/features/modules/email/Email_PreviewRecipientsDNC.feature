#Author: Milton Silva
#Regression testcase TL-568: Emails cannot be sent to Do Not Contact records
#Regression testcase TL-702: Preview Recipients

@EmailsCannotBeSentToDoNotContactRecords
Feature: Sending Test Email to Test List

  @EmailsCannotBeSentToDoNotContactRecordsScenario @Done @Email
  Scenario: verify we can preview email recipients
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName |LastName  |Role1    |EmailAddress     |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory|StudentStatus   |StudentStatusDate|EntryTerm|
      |Julio     |Boca      |Student  |jboca@ballet.com |Personal   |Inquiry         |Freshman   |Accepted             |Accepted        |15/08/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName |LastName  |Role1    |EmailAddress     |EmailType  |EmailOptInMethod|StudentType|StudentStatusCategory|StudentStatus   |StudentStatusDate|EntryTerm|
      |Abril     |Boca      |Student  |aboca@ballet.com |Personal   |Inquiry         |Freshman   |Accepted             |Accepted        |15/08/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    #to change this person to OK to Contact = No
    And I validate if "Abril Boca"summary opened properly
