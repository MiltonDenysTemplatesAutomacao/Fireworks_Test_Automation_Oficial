package steps;

import io.cucumber.java.en.When;
import pages.MediaPage;

public class MediaSteps {

    @When("I create media")
    public static void createMedia() {
        MediaPage.createMedia();
    }
    @When("I open media {string}")
    public static void openMedia(String media) {
        MediaPage.openMedia(media);
    }
    @When("I storage usage 1")
    public static void storageUsage1() {
        MediaPage.storageUsage1();
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
