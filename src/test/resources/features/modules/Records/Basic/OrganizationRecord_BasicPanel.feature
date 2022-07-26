#Author: Milton Silva
#Regression testcase TL-261: Basic: Organization data can be added

@BasicOrganizationDataCanBeAdded
Feature: Basic: Organization data can be added

  @BasicOrganizationDataCanBeAddedScenario @Done
  Scenario: Record - Basic - verify data can be added to the basic panel of a organization record
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I create an organization
      |Name					      |Role		  |Address1			|City        |State     |PostalCode |Country      |Phone        |PhoneType|
      |Ballston Spa High School   |High School|220 Ballston Ave.|Ballston Spa|New York  |12020      |United States|518-885-4209 |Business |
    When I validate if "Organization has been created." message is correct
    #to update ID and Context values
    And I validate if "Ballston Spa High School"summary opened properly
    And I navigate to basic
    When I update basic identification values "", "Domestic", "www.bscsd.org/high.cfm", ""
    And I update basic context values "(GMT-05:00) Central Time (US & Canada)", "Fire Starter"
    Then I click on Save Changes in Basic for organization
    Then I validate if "Organization has been updated." message is correct
    #to verify the data was saved as expected
    And I verify basic identification values "", "Domestic", "www.bscsd.org/high.cfm", ""
    And I verify basic context values "(GMT-05:00) Central Time (US & Canada)", "Fire Starter"