#Author: Milton Silva
#Regression testcase TL-910: URL validation test
#This test will not run locally unless the seeded default search is present

@URLValidationTest
Feature: URL validation test

  @URLValidationTest @Fix @Email
  Scenario: verify an invalid URL will produce the correct validation message
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create an email
    And I navigate to email manager page
    And I click on create a new email button and select type "Non-Marketing"
    When I update Email Start Tab "", "URLValidationTest", "", "2016 Entry Term", ""
    And I click on save and continue on Marketing Email Composer
    And I update Email Headers Tab "", "firestarter@fire-engine-red.com", "", "Generate Plain Text Test 6310", "", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #to input one valid and one invalid URL
    And I click TinyMCESourceCode
    And I update TinyMCESourceCode "<!DOCTYPE html><html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /></head><body><p><a href='http://www.fire-engine-red.com'>goodlink</a></p><p><a href='http://www.fire-engine-green.com'>badlink</a></p></body></html>"
    When I click ok button on TinyMCESourceCode
    And I click on save and continue on Marketing Email Composer
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #URL validation to return a message that an invalid url is present
    And I click on url validation button
    #\TODO $I->waitForText('Email contains 1 invalid link.' and 'Url: http://www.fire-engine-green.com, Error: Could not resolve the hostname. This usually indicates a problem with DNS.');
