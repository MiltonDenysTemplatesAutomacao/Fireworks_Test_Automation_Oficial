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
    When I verify media "File1_2MBmediafile.png_", "FileDescription1", "2MBmediafile.png"
    #to update the file name and description
    When I update media "EditedFileName_", "EditedFileDescription", ""
    And I click on "Save Changes"
    And I close alert if return this message "Media has been updated."
    #to verify the file name and description are updated
    When I verify media "EditedFileName_", "EditedFileDescription", "2MBmediafile.png"
    And I navigate to media page
    And I open media "EditedFileName_"
    When I verify media "EditedFileName_", "EditedFileDescription", "2MBmediafile.png"
    #to delete the file previously uploaded
    And I delete media
    And I close alert if return this message "Media has been deleted."
    And I navigate to media page
    And I search media "EditedFileName_"
    And I validate if media "EditedFileName_" is "not visible"
    #to verify the new storage value is different than before
    And I storage usage 2
    Then I validate if storage value are different from each other




