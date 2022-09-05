package steps.records;

import io.cucumber.java.en.And;
import pages.records.TranscriptPage;

public class TranscriptSteps {

    @And("I update transcript person {string} group {string}")
    public static void createTranscript(String person,String group) {
        TranscriptPage.createTranscript(person,group);
    }
    @And("I add a transcript {string}")
    public static void addTranscript(String index) {
        TranscriptPage.addTranscript(index);
    }
    @And("I verify if there is no post secondary fields visible group {string}")
    public static void verifyNoPostSecondaryFieldsAreVisible(String group) {
        TranscriptPage.verifyNoPostSecondaryFieldsAreVisible(group);
    }
    @And("I verify transcript person {string} group {string}")
    public static void verifyTranscript(String person,String group) {
        TranscriptPage.verifyTranscript(person,group);
    }
    @And("I verify if there is no high school fields visible group {string}")
    public static void verifyNoHighSchoolFieldsAreVisible(String group) {
        TranscriptPage.verifyNoHighSchoolFieldsAreVisible(group);
    }

}
