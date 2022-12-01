#Author: Milton Silva
#Regression testcase TL-107: Verify Sender Email format is validated

@VerifySenderEmailFormatIsValidated
Feature: Merge Fields Replacement when No Value

  @VerifySenderEmailFormatIsValidatedScenarios @Done @Email
  Scenario: verify the sender email address format is validated
    #to enter a sender email with no @
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to email manager page
    And I click on create a new email button and select type "Non-Marketing"
    When I update Email Start Tab "", "Sender Email Validation test 6240", "", "2016 Entry Term", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "", "nafigueras.espana.com", "", "Testing sender email", "Testing sender email", ""
    And I click on save and continue on Marketing Email Composer
    And I verify validation message "The Sender Email field is required."
    #to enter a sender email with an extra @
    And I update Email Headers Tab "", "nafigueras@@espana.com", "", "", "", ""
    And I click on save and continue on Marketing Email Composer
    And I verify validation message "The Sender Email field is required."
    #to enter a sender email with an extra @
    And I update Email Headers Tab "", "na figueras@espana.com", "", "", "", ""
    And I click on save and continue on Marketing Email Composer
    And I verify validation message "The Sender Email field is required."
    And I click on "Clear Changes"
