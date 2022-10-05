#Author: Milton Silva
#Regression testcase TL-856 (1 of 4): Scheduler required fields

@SchedulerRequiredFields
Feature: Scheduler required fields

  @SchedulerRequiredFields @Done @Scheduler
  Scenario: Scheduler - scheduled letter job required fields
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to scheduler
    When I create a new schedule "Letter"
    #click Save from Letter Job Composer and verify validation messages are returned for the required fields
    And I click on "Save Changes"
    And I verify validation message "The Name field is required."
    And I verify validation message "The Letter field is required."
    And I verify validation message "The Start Date And Time field is required."
    And I verify validation message "The Frequency field is required."
