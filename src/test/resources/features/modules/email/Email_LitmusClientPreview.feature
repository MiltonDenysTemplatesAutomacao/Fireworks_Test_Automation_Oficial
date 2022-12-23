#Author: Milton Silva
#Regression testcase TL-688: Litmus Testing

@LitmusTesting
Feature: Litmus Testing

  @LitmusTestingScenarios @Done @Email
  Scenario: verify the litmus testing behavior in email
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |EmailAddress       |EmailType|EmailOptInMethod |Role1 |StudentType|StudentStatusCategory|StudentStatus   |StudentStatusDate|EntryTerm|
      |Tracy      |Morgan   |tmorgan@comedy.com |Personal |Campus Visit     |Student|Freshman  |Accepted             |Accepted        |01/15/2017       |Fall 2017|
    And I validate if "Person has been created." message is correct
    #to create an email
    And I navigate to email manager page
    And I click on create a new email button and select type "Non-Marketing"
    When I update Email Start Tab "", "Non Marketing Litmus Email 6360", "", "", "tmorgan@comedy.com"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "", "JamesBrown@fire-engine-red.com", "", "Come join us in the fall", "", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I update Email Content Tab "Litmus testing", ""
    And I click on save and continue on Marketing Email Composer
    And I click on save and continue on Marketing Email Composer
    And I validate if "Email has been updated." message is correct
    #to run the Litmus test
    And I click on email client preview button
    #the Litmus window heading contains date test was run
    #TODO-