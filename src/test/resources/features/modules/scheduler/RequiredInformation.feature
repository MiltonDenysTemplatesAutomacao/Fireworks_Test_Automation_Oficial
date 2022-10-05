#Author: Milton Silva
#Regression testcase TL-856 (1 of 4): Scheduler required fields

@SchedulerRequiredFields
Feature: Scheduler required fields

  @ComparisonToArchivedRecordsScenarios @Done @DupManager
  Scenario: Scheduler - scheduled letter job required fields
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"