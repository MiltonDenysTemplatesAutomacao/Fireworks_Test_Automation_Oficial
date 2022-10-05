#Author: Milton Silva
#Regression testcase TL-856 (1 of 4): Scheduler required fields
#Regression testcase TL-856 (2 of 4): Scheduler required fields
#Regression testcase TL-856 (3 of 4): Scheduler required fields
#Regression testcase TL-856 (4 of 4): Scheduler required fields

@SchedulerRequiredFields
Feature: Scheduler required fields

  @SchedulerLetterJobRequiredFields @Done @Scheduler
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

  @SchedulerEmailJobRequiredFields @Done @Scheduler
  Scenario: Scheduler - scheduled email job required fields
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to scheduler
    When I create a new schedule "Email"
    #click Save from Email Job Composer and verify validation messages are returned for the required fields
    And I click on "Save Changes"
    And I verify validation message "The Name field is required."
    And I verify validation message "The Email field is required."
    And I verify validation message "The Start Date And Time field is required."
    And I verify validation message "The Frequency field is required."

  @SchedulerImportJobRequiredFields @Done @Scheduler
  Scenario: Scheduler - scheduled import job required fields
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to scheduler
    When I create a new schedule "Import"
    #click Save from Import Job Composer and verify validation messages are returned for the required fields
    And I click on "Save Changes"
    And I verify validation message "The Name field is required."
    And I verify validation message "The Import Package field is required."
    And I verify validation message "The Start Date And Time field is required."
    And I verify validation message "The Frequency field is required."

  @SchedulerExportJobRequiredFields @Done @Scheduler
  Scenario: Scheduler - scheduled export job required fields
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to scheduler
    When I create a new schedule "Export"
    #click Save from Import Job Composer and verify validation messages are returned for the required fields
    And I click on "Save Changes"
    And I verify validation message "The Name field is required."
    And I verify validation message "The Export Package field is required."
    And I verify validation message "The Start Date And Time field is required."
    And I verify validation message "The Frequency field is required."