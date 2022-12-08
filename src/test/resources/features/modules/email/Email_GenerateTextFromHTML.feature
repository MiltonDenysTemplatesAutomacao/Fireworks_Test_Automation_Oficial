#Author: Milton Silva
#Regression testcase TL-899: Text from HTML
#This test will not run locally unless the seeded default search is present

@TextFromHTML
Feature: Merge Fields Replacement when No Value

  @TextFromHTMLScenarios @Done @Email
  Scenario: verify text generated from html is correct
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to create an email
    And I navigate to email manager page
    And I click on create a new email button and select type "Marketing"
    When I update Email Start Tab "", "HTMLToTextGenerationTest", "", "2016 Entry Term", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I update Email Headers Tab "", "firestarter@fire-engine-red.com", "", "Generate Plain Text Test 6310", "", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I update Email Content Tab "<u>This</u> is the <b>body</b> of an <i>email</i>", ""
    And I click on "Save Changes"
    #to generate the plain text version
    And I click on generate Plain Text Button
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #to update the plain text content
    And I click on content tab
    And I verify body text Email Content Tab "This"
    And I verify body text Email Content Tab " is the "
    And I verify body text Email Content Tab "body"
    And I verify body text Email Content Tab " of an "
    And I verify body text Email Content Tab "email"
    And I update Email Content Tab "", "Updated Plain Text Body Content"
    And I click on "Save Changes"
    And I close alert if return this message "Email has been updated."
    #to verify the plain text was updated and the html content is unchanged
    And I verify body html Email Content Tab "This is the body of an email"
    And I verify body text Email Content Tab "Updated Plain Text Body Content"
    #to update the html content
    And I update Email Content Tab "This is <b>the</b> <u>updated</u> <i>HTML</i> body of an email", ""
    And I click on "Save Changes"
    #to verify generating the plain text version again will overwrite the existing text
    And I click on generate Plain Text Button
    And I click on generate Plain Text overwrite Button
    And I click on "Save Changes"
    And I close alert if return this message "Email has been updated."
    And I verify body html Email Content Tab "This is the updated HTML body of an email"



