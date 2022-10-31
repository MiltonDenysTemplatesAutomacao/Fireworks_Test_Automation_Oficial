#Author: Milton Silva
#Regression testcase TL-738: Media: Upload several files in succession

@MediaUploadSeveralFilesInSuccession
Feature: Media: Upload several files in succession

  @MediaUploadSeveralFilesInSuccession @Done @Media
  Scenario: verify a file can be uploaded edited and deleted
    Given I login as "firestarterUsername", "firestarterPassword", "firestarterFullName"
    And I navigate to media page
    And I create media
    When I update media "File1_11KBmediafile.png_", "FileDescription1", "11KBmediafile.png"
    And I click on "Save Changes"
    And I close alert if return this message "Media has been created."
    #to upload a second file
    And I navigate to media page
    And I create media
    When I update media "File1_93KBmediafile.png_", "FileDescription2", "93KBmediafile.png"
    And I click on "Save Changes"
    And I close alert if return this message "Media has been created."
    #to upload a third file
    And I navigate to media page
    And I create media
    When I update media "File1_198KBmediafile.png_", "FileDescription3", "198KBmediafile.png"
    And I click on "Save Changes"
    And I close alert if return this message "Media has been created."
    #to verify the files exist
    And I navigate to media page
    And I search media "File1_11KBmediafile.png_"
    And I validate if media "File1_11KBmediafile.png_" is "visible"
    And I search media "File1_93KBmediafile.png_"
    And I validate if media "File1_93KBmediafile.png_" is "visible"
    And I search media "File1_198KBmediafile.png_"
    And I validate if media "File1_198KBmediafile.png_" is "visible"