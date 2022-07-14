package steps.Records;

import bean.TranscriptBean;
import io.cucumber.java.en.And;
import pages.Records.TranscriptPage;

public class TranscriptSteps {

    @And("I update transcript person {string} group {string}")
    public static void updateSchool(String person,String group) {
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

}
