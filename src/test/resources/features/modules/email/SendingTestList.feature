#Author: Milton Silva
#Regression testcase TL-934: Sending Test Email to Test List

@SendingTestEmailToTestList
Feature: Sending Test Email to Test List

  @SendingTestEmailToTestList1 @Done @Email
  Scenario: verify we can send a test email to a test list
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create a test list
    And I navigate to Email settings page
    And I click on Test Lists
    And I click on create test list button
    When I update test list "6035TestList", "Test List for 6035", "test1-6035@ferfun.com"
    And I click on "Save Changes"
    And I close alert if return this message "Email test list has been created."
    #to send a test email to a test list

