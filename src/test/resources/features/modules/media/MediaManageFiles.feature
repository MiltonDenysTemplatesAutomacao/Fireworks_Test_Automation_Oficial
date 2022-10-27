#Author: Milton Silva
#Regression testcase TL-635: Media: Manage Files

@MediaManageFiles
Feature: Media: Manage Files

  @MediaManageFilesScenarios @Done @Media
  Scenario: verify a file can be uploaded edited and deleted
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    #to upload file
    And I navigate to media page
    And I create media
    When I update media "File1_2MBmediafile.png_", "FileDescription1", "2MBmediafile.png"
    And I click on "Save Changes"
    And I close alert if return this message "Media has been created."
    #to grab the current storage value
    And I navigate to media page
    And I storage usage 1
    #to verify the media
    And I open media "File1_2MBmediafile.png_"
    When I verify media "File1_2MBmediafile.png_", "FileDescription1", ""
    #to update the file name and description
    When I update media "EditedFileName_", "EditedFileDescription", ""
    And I click on "Save Changes"
    And I close alert if return this message "Media has been updated."
    #to verify the file name and description are updated




