#Author: Milton Silva

@QuickAdd
Feature: QuickAdd

  @0210QuickAdd_CreatePersonOnlyEmailAddressCept
  Scenario: Verify a person record can be created via quick add with only email address
    Given I login as firestarter
    And I navigate to QuickAddCreatePersonPage
    When I quick add a person
      |Firstname|Lastname	|EmailAddress				  |EmailType|EmailOptInMethod	|Role1	|
      |Camilla	|Rhodes		|CRhodes@Mulholland-Drive.com |Personal	|Inquiry			|Person	|
    And I clickQuickAddPersonSaveAndGo
    Then I recieve an alert message

  @0220QuickAdd_CreatePersonOnlyPhoneNumberCept
  Scenario: Verify a person record can be created via quick add with only phone number
    Given I login as firestarter
    And I navigate to QuickAddCreatePersonPage
    When I quick add a person
      |Firstname|Lastname	|Phone		|PhoneType|Role1	|
      |Diane	|Selwyn		|555-555-555|Home	  |Person	|
    And I clickQuickAddPersonSaveAndGo
    Then I recieve an alert message