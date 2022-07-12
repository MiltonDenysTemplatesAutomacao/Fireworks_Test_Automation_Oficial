package steps.Records;

import bean.TranscriptBean;
import io.cucumber.java.en.And;
import pages.Records.TranscriptPage;

public class TranscriptSteps {

    @And("I update transcript person {string} group {string}")
    public static void updateSchool(String person,String group) {
        TranscriptPage.createTranscript(person,group);
    }

}
