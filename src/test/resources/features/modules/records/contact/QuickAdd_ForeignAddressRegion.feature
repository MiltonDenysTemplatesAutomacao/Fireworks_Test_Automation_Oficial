#Author: Milton Silva
#Regression testcase TL-368: Foreign Person Records

@ForeignPersonRecords
Feature: Invalid Area Code Not Formatted

  @ForeignPersonRecordsScenario @Done @Contact
  Scenario: Record - Contact - Foreign country and region are saved
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    When I create a person
      |FirstName    |LastName   |Address1             |City       |PostalCode   |Country            |Role1  |Region     |
      |Alexander    |Pushkin    |Mal. Nikitskaya St. 7|Moscow     |121069       |Russian Federation |Person |Podmoskovye|
    And I validate if "Person has been created." message is correct
    And I go to Home page
    When I quick search "FirstName"
    And I open a record
    And I validate if "Alexander"summary opened properly
    And I navigate to contact
    And I verify address on contact por person "Mal. Nikitskaya St. 7", "", "", "", "Moscow", "", "", "Podmoskovye", "Russian Federation", "121069", "", "", "", "", "1", "1" group "0"
