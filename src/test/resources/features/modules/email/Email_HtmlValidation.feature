#Author: Milton Silva
#Regression testcase TL-911: HTML test validation

@HTMLTestValidation
Feature: Merge Fields Replacement when No Value

  @HTMLTestValidationScenarios @Done @Email
  Scenario: verify we can preview email content with merge tags
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create an email
    And I navigate to email manager page
    And I click on create a new email button and select type "Marketing"
    When I update Email Start Tab "", "HTMLBodyValidationTest", "", "2016 Entry Term", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "", "firestarter@fire-engine-red.com", "", "HTML Validation Test 6300", "", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
  #to input invalid HTML into the View Source Code modal window
    And I click TinyMCESourceCode
    And I update TinyMCESourceCode "<!DOCTYPE html><html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /></head><body><p>Invalid HTML test</p></body>"
    When I click ok button on TinyMCESourceCode
    And I click on save and continue on Marketing Email Composer
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
  #HTML validation to return a message that an invalid HTML is present
  And I click on Submit for Html Validation button
#\TODO\waitForText 'Email contains 1 invalid html tag.' and TagNotClosed: End tag </html> was not found