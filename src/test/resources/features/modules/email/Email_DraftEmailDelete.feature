#Author: Milton Silva
#Regression testcase TL-317: Draft: Users can delete Drafts
#Seeded smart search is required to run this test

@UsersCanDeleteDrafts
Feature: Email Sent System Action

  @UsersCanDeleteDraftsScenario @Done @Email
  Scenario: verify users can delete draft emails
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create a draft email
    And I navigate to email manager page
    And I click on create a new email button and select type "Direct"
    When I update Email Start Tab "", "Draft Email to delete 6070", "", "2016 Entry Term", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    #to delete a draft email
    And I delete email
    And I close alert if return this message "Email has been deleted."
