#Author: Milton Silva
#Regression testcase TL-668 (1 of 2): Email Footer

@EmailFooter
Feature: Email Footer

  @EmailFooterScenario @Done @Email
  Scenario: email actions are recorded for persons
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to Email settings page
    And I use datatable
      |OrganizationName|OrganizationEmail                |ReplyToEmail                      |PhoneNumberEmail|Address1Email  |City   |State/Province|PostalCode|
      |Fire Engine Red |sender.email@fire-engine-red.com |replyto.email@fire-engine-red.com |1-800-555-1212  |1100 E 6th Ave |Aurora |Colorado      |80010     |
    And I update CAM-SPAM index 0