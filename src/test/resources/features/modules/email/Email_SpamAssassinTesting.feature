#Author: Milton Silva
#Regression testcase TL-651: SpamAssassin testing
#FW-7402: Disable CAN SPAM Footer option not visible in NonMarketing emails

@SpamAssassinTesting
Feature: File Attachment received

  @SpamAssassinTestingScenario @Done @Email
  Scenario: verify an attachment sent with an email is received
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName  |LastName |EmailAddress           |EmailType|EmailOptInMethod |Role1 |
      |Amparo     |Figueras |ampfigueras@espana.com |Personal |Campus Visit     |Person|
    And I validate if "Person has been created." message is correct
    #to create an email
    And I navigate to email manager page
    And I click on create a new email button and select type "Non-Marketing"
    When I update Email Start Tab "", "SpamAssassin Test 6340", "", "", "ampfigueras@espana.com"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been created."
    And I validate if I do not see disable footer checkbox
    And I update Email Headers Tab "", "redondos@fire-engine-red.com", "", "SpamAssassin Test 6340", "", ""
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #to check the default spam score
    And I verify spam score "100%"
    #to enter ham content and verify the spam score updates
    And I update Email Content Tab "Somewhere over the rainbow, blue birds fly", ""
    #TODO - waitUntilSpamScoreUpdates
    And I verify spam score "93%"
    And I click on spam Assassin Score
    And I validate HTML Message SpamAssassin Details "Errors found: ", "Last Run: "
    And I click on spam Assassin modal ok button
    #to enter spam content and wait up to 30 seconds to verify the spam score updates on its own
    And I update Email Content Tab "XJS*C4JDBQADN1.NSBN3*2IDNEN*GTUBE-STANDARD-ANTI-UBE-TEST-EMAIL*C.34X", ""
    #TODO - waitUntilSpamScoreUpdates
    And I click on "Save Changes"
    And I verify spam score "93%"
    #sending the email will return validation that the spam score is less than 65%
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    And I click on finish tab
    And I send email
    And I confirm EmailSend "Person"
    #\TODO - do not receive message
    #And I close alert if return this message "Spam score must be equal or greater than 65%."
    #to update the body content so the spam score will allow the email to be sent
    And I click on content tab
    And I update Email Content Tab "Somewhere over the rainbow, blue birds fly", ""
    And I click on "Save Changes"
    And I click on save and continue on Marketing Email Composer
    And I close alert if return this message "Email has been updated."
    #to send the email
    And I click on finish tab
    And I send email
    And I confirm EmailSend "Person"
    Then I validate if "Email has been queued." message is correct
    #after the email is sent the spam score displays in the sent email
    And I navigate to email manager page
    When I wait until email sent "SpamAssassin Test 6340"