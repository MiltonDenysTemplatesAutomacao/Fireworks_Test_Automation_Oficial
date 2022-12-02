#Author: Milton Silva
#Regression testcase TL-425: Email content preview

@EmailContentPreview
Feature: Merge Fields Replacement when No Value

  @EmailContentPreview @Done @Email
  Scenario: verify we can preview email content with merge tags
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |EmailAddress            |EmailType|EmailOptInMethod |Role1  |StudentType|StudentStatusCategory|StudentStatus|StudentStatusDate|EntryTerm|
      |Catherine  |Aragon   |caragon@reyesespana.com |Personal |Inquiry          |Student|Freshman   |Accepted             |Accepted     |09/15/2016       |Fall 2017|
    And I validate if "Person has been created." message is correct
    #to create an email
    And I navigate to email manager page
    And I click on create a new email button and select type "Non-Marketing"
    When I update Email Start Tab "", "Content Preview Test 6250", "", "", "caragon@reyesespana.com"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    #to verify preview of body content having no merge tags
    And I click on content tab
    And I update Email Content Tab "Preview without merge tags", ""
    # work on this
#  ->openContentPreviewModal();
#  $I->see($emailBodyContentNoMergeTags);
#  $email->closeContentPreviewModal();
  #to verify preview body content using merge tags
    And I click on content tab
    And I update Email Content Tab "Preview without merge tags", ""
#  ->openContentPreviewModal();
#  $I->see($person1->firstName);
#  $I->see($person1->lastName);
#  $I->dontSee('[[ADDRESS_1]]');
#  $I->see($emailBodyContentText);
#  $email->closeContentPreviewModal();