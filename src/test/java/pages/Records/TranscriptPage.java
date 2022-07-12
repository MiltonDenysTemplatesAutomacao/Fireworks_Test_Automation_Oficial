package pages.Records;

import bean.TranscriptBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class TranscriptPage extends BasePage {

    private static final String SELECT_DROP = "#select2-drop";


    private static String transcriptPlusSign(String index){
        return String.format("#person_school_0_person_school_transcript_%s_add",index);
    }
    private static String transcriptTypeElement(String index){
        return String.format("#s2id_person_school_0_person_school_transcript_%s_transcript_type",index);
    }


    public static void createTranscript(String person,String group){
        int personIndex = Integer.parseInt(person);
        int updateTranscriptDelay = 20;
        TranscriptBean transcriptBean = new TranscriptBean();
        transcriptBean.setType(mass.get(personIndex).get("TranscriptType"));

        String passMessage = String.format(LogPage.CREATE_TRANSCRIPT_PASS,group);
        String failMessage = String.format(LogPage.CREATE_TRANSCRIPT_FAIL,group);

        try {
            if(transcriptBean.getType()!=""){
                scrollToElement(By.cssSelector(transcriptPlusSign(group)));
                waitElementBy(By.cssSelector(transcriptTypeElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptTypeElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(500);
                clickOnListOfElements(transcriptBean.getType());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
