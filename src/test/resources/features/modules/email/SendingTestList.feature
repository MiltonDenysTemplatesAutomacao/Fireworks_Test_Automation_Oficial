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

