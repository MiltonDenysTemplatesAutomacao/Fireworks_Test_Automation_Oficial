package steps;

import io.cucumber.java.en.When;
import pages.MediaPage;

public class MediaSteps {

    @When("I create media")
    public static void createMedia() {
        MediaPage.createMedia();
    }
    @When("I search media {string}")
    public static void searchMedia(String media) {
        MediaPage.searchMedia(media);
    }
    @When("I validate if media {string} is {string}")
    public static void validateMediaIsVisibleOrNot(String media,String status) {
        MediaPage.validateMediaIsVisibleOrNot(media,status);
    }
    @When("I open media {string}")
    public static void openMedia(String media) {
        MediaPage.openMedia(media);
    }
    @When("I delete media")
    public static void deleteMedia() {
        MediaPage.deleteMedia();
    }
    @When("I storage usage 1")
    public static void storageUsage1() {
        MediaPage.storageUsage1();
    }
    @When("I storage usage 2")
    public static void storageUsage2() {
        MediaPage.storageUsage2();
    }
    @When("I validate if storage value are different from each other")
    public static void validateStorageValueDifferentFromEachOther() {
        MediaPage.validateStorageValueDifferentFromEachOther();
    }
    @When("I update media {string}, {string}, {string}")
    public static void updateMedia(String mediaName,String mediaDescription,String mediaFileSource) {
        MediaPage.updateMedia(mediaName,mediaDescription,mediaFileSource);
    }
    @When("I verify media {string}, {string}, {string}")
    public static void verifyMedia(String mediaName,String mediaDescription,String mediaFileSource) {
        MediaPage.verifyMedia(mediaName,mediaDescription,mediaFileSource);
    }

}
