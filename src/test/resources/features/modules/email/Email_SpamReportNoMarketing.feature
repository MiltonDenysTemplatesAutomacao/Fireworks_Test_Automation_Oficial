#Author: Milton Silva
#Regression testcase TL-570: Email Status - Spam Report

@EmailStatusSpamReport
Feature: Merge Fields Replacement when No Value

  @EmailStatusSpamReportScenarios @Done @Email
  Scenario: verify recipients with spam report email addresses are excluded only from marketing emails
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |EmailAddress            |EmailType|EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|
      |Roland     |Gotti    |rolandgotti@actors.com  |Personal |Student Search   |Student|Freshman   |Accepted             |Accepted     |01/15/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    When I create a person
      |FirstName  |LastName |EmailAddress            |EmailType|EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|
      |Victor     |Gotti    |victorgotti@actors.com  |Personal |Student Search   |Student|Freshman   |Accepted             |Accepted     |01/15/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    #to update the email status to Spam Report
    And I validate if "Victor Gotti"summary opened properly
    And I navigate to contact
    And I update email on contact for person "", "", "Spam Repor", "", "", "", "", "" and group "0"
    And I click on save changes in contact for person
    And I close alert if return this message "Person has been updated."
    #to create a smart search
    And I navigate to smart search page
    And I click on create smart search button
    And I select "Last Name" search field group "0" condition "0" in smart search composer
    And I select "equals" operator field group "0" condition "0" in smart search composer
    And I fill "Gotti" text group "0" condition "0"
    And I fill smart search name "Search for test 6260"
    And I click on save this search button
    And I close alert if return this message "Smart Search has been created."
