package pages.Records;

import bean.TranscriptBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.KeyPage;
import pages.LogPage;

public class TranscriptPage extends BasePage {

    private static final String SELECT_DROP = "#select2-drop";


    private static String transcriptPlusSign(String index){
        return String.format("#person_school_0_person_school_transcript_%s_add",index);
    }
    private static String transcriptTypeElement(String index){
        return String.format("#s2id_person_school_0_person_school_transcript_%s_transcript_type",index);
    }
    private static String transcriptDateField(String index){
        return String.format("#person_school_0_person_school_transcript_%s_transcript_date",index);
    }
    private static String transcriptStartDateField(String index){
        return String.format("#person_school_0_person_school_transcript_%s_transcript_start_date",index);
    }
    private static String transcriptEndDateField(String index){
        return String.format("#person_school_0_person_school_transcript_%s_transcript_end_date",index);
    }
    private static String transcriptGraduationDateField(String index){
        return String.format("#person_school_0_person_school_transcript_%s_school_graduation_date",index);
    }
    private static String transcriptDiplomaReceivedElement(String index){
        return String.format("#s2id_person_school_0_person_school_transcript_%s_school_diploma_received",index);
    }
    private static String transcriptOfficialTranscriptElement(String index){
        return String.format("#s2id_person_school_0_person_school_transcript_%s_transcript_official",index);
    }
    private static String transcriptGpaField(String index){
        return String.format("#person_school_0_person_school_transcript_%s_transcript_gpa",index);
    }
    private static String transcriptGpaRecalculatedField(String index){
        return String.format("#person_school_0_person_school_transcript_%s_transcript_gpa_recalculated",index);
    }
    private static String transcriptScaleField(String index){
        return String.format("#person_school_0_person_school_transcript_%s_transcript_gpa_scale",index);
    }
    private static String transcriptSelfReportedElement(String index){
        return String.format("#s2id_person_school_0_person_school_transcript_%s_transcript_stats_selfreported",index);
    }
    private static String transcriptCommentsField(String index){
        return String.format("#person_school_0_person_school_transcript_%s_transcript_comments",index);
    }
    private static String transcriptGEDElement(String index){
        return String.format("#s2id_person_school_0_person_school_transcript_%s_school_ged",index);
    }
    private static String transcriptWeightedElement(String index){
        return String.format("#s2id_person_school_0_person_school_transcript_%s_transcript_gpa_weighted",index);
    }
    private static String transcriptPercentileField(String index){
        return String.format("#person_school_0_person_school_transcript_%s_transcript_rank_percentile",index);
    }
    private static String transcriptRankUnavailableElement(String index){
        return String.format("#s2id_person_school_0_person_school_transcript_%s_transcript_rank_unavailable",index);
    }
    private static String transcriptRankWeightedElement(String index){
        return String.format("#s2id_person_school_0_person_school_transcript_%s_transcript_rank_weighted",index);
    }
    private static String transcriptClassSizeField(String index){
        return String.format("#person_school_0_person_school_transcript_%s_transcript_class_size",index);
    }
    private static String transcriptClassRankField(String index){
        return String.format("#person_school_0_person_school_transcript_%s_transcript_class_rank",index);
    }

    public static void verifyTranscript(String person,String group){
        int personIndex = Integer.parseInt(person);
        TranscriptBean transcriptBean = new TranscriptBean();
        transcriptBean.setType(mass.get(personIndex).get("TranscriptType"));
        transcriptBean.setType(mass.get(personIndex).get("TranscriptType"));
        transcriptBean.setTranscriptDate(mass.get(personIndex).get("TranscriptDate"));
        transcriptBean.setGraduationDate(mass.get(personIndex).get("GraduationDate"));
        transcriptBean.setDiplomaReceived(mass.get(personIndex).get("DiplomaReceived"));
        transcriptBean.setOfficialTranscript(mass.get(personIndex).get("OfficialTranscript"));
        transcriptBean.setGpa(mass.get(personIndex).get("GPA"));
        transcriptBean.setGed(mass.get(personIndex).get("GED"));
        transcriptBean.setGpaRecalculated(mass.get(personIndex).get("GPARecalculated"));
        transcriptBean.setScale(mass.get(personIndex).get("Scale"));
        transcriptBean.setSelfReported(mass.get(personIndex).get("SelfReported"));
        transcriptBean.setComments(mass.get(personIndex).get("TranscriptComments"));
        transcriptBean.setClassRank(mass.get(personIndex).get("ClassRank"));
        transcriptBean.setClassSize(mass.get(personIndex).get("ClassSize"));
        transcriptBean.setWeighted(mass.get(personIndex).get("Weighted"));
        transcriptBean.setPercentile(mass.get(personIndex).get("Percentile"));
        transcriptBean.setRankUnavailable(mass.get(personIndex).get("RankUnavailable"));
        transcriptBean.setRankWeighted(mass.get(personIndex).get("RankWeighted"));

        boolean typeValidation = false;
        boolean transcriptDateValidation = false;
        boolean graduationDateValidation = false;
        boolean gedValidation = false;
        boolean diplomaReceivedValidation = false;
        boolean officialTranscriptValidation = false;
        boolean classRankValidation = false;
        boolean classSizeValidation = false;
        boolean gpaValidation = false;
        boolean gpaRecalculatedValidation = false;
        boolean scaleValidation = false;
        boolean weightedValidation = false;
        boolean percentileValidation = false;
        boolean rankUnavailableValidation = false;
        boolean rankWeightedValidation = false;
        boolean selfReportedValidation = false;
        boolean commentsValidation = false;

        String passMessage = String.format(LogPage.VERIFY_TRANSCRIPT_PASS,person,group);
        String failMessage = String.format(LogPage.VERIFY_TRANSCRIPT_FAIL,person,group);

        try {
            scrollToElement(By.cssSelector(transcriptPlusSign(group)));

            if (transcriptBean.getType() != "") {
                String typeText = getText(By.cssSelector(transcriptTypeElement(group)));
                typeValidation = typeText.contains(transcriptBean.getType());
            } else {
                typeValidation = true;
            }
            if (transcriptBean.getTranscriptDate() != "") {
                String transcriptDateDateText = getAtribute(By.cssSelector(transcriptDateField(group)),"value");
                transcriptDateValidation = transcriptDateDateText.contains(transcriptBean.getTranscriptDate());
            } else {
                transcriptDateValidation = true;
            }
            if (transcriptBean.getGraduationDate() != "") {
                String graduationDateText = getAtribute(By.cssSelector(transcriptGraduationDateField(group)),"value");
                graduationDateValidation = graduationDateText.contains(transcriptBean.getGraduationDate());
            } else {
                graduationDateValidation = true;
            }
            if (transcriptBean.getGed() != "") {
                String gedText = getText(By.cssSelector(transcriptGEDElement(group)));
                gedValidation = gedText.contains(transcriptBean.getGed());
            } else {
                gedValidation = true;
            }
            if (transcriptBean.getOfficialTranscript() != "") {
                String officialTranscriptText = getText(By.cssSelector(transcriptOfficialTranscriptElement(group)));
                diplomaReceivedValidation = officialTranscriptText.contains(transcriptBean.getOfficialTranscript());
            } else {
                diplomaReceivedValidation = true;
            }
            if (transcriptBean.getDiplomaReceived() != "") {
                String diplomaReceivedText = getText(By.cssSelector(transcriptDiplomaReceivedElement(group)));
                officialTranscriptValidation = diplomaReceivedText.contains(transcriptBean.getDiplomaReceived());
            } else {
                officialTranscriptValidation = true;
            }
            if (transcriptBean.getClassRank() != "") {
                String classRankText = getAtribute(By.cssSelector(transcriptClassRankField(group)),"value");
                classRankValidation = classRankText.contains(transcriptBean.getClassRank());
            } else {
                classRankValidation = true;
            }
            if (transcriptBean.getClassSize() != "") {
                String classSizeText = getAtribute(By.cssSelector(transcriptClassSizeField(group)),"value");
                classSizeValidation = classSizeText.contains(transcriptBean.getClassSize());
            } else {
                classSizeValidation = true;
            }
            if (transcriptBean.getGpa() != "") {
                String gpaText = getAtribute(By.cssSelector(transcriptGpaField(group)),"value");
                gpaValidation = gpaText.contains(transcriptBean.getGpa());
            } else {
                gpaValidation = true;
            }
            if (transcriptBean.getGpaRecalculated() != "") {
                String gpaRecalculatedText = getAtribute(By.cssSelector(transcriptGpaRecalculatedField(group)),"value");
                gpaRecalculatedValidation = gpaRecalculatedText.contains(transcriptBean.getGpaRecalculated());
            } else {
                gpaRecalculatedValidation = true;
            }
            scrollToElement(By.cssSelector(transcriptGraduationDateField(group)));
            if (transcriptBean.getScale() != "") {
                String scaleText = getAtribute(By.cssSelector(transcriptScaleField(group)),"value");
                scaleValidation = scaleText.contains(transcriptBean.getScale());
            } else {
                scaleValidation = true;
            }
            if (transcriptBean.getWeighted() != "") {
                String weightedText = getText(By.cssSelector(transcriptWeightedElement(group)));
                weightedValidation = weightedText.contains(transcriptBean.getWeighted());
            } else {
                weightedValidation = true;
            }
            if (transcriptBean.getPercentile() != "") {
                String percentileText = getAtribute(By.cssSelector(transcriptPercentileField(group)),"value");
                percentileValidation = percentileText.contains(transcriptBean.getPercentile());
            } else {
                percentileValidation = true;
            }
            if (transcriptBean.getRankUnavailable() != "") {
                String rankUnavailableText = getText(By.cssSelector(transcriptRankUnavailableElement(group)));
                rankUnavailableValidation = rankUnavailableText.contains(transcriptBean.getRankUnavailable());
            } else {
                rankUnavailableValidation = true;
            }
            if (transcriptBean.getRankWeighted() != "") {
                String rankWeightedText = getText(By.cssSelector(transcriptRankWeightedElement(group)));
                rankWeightedValidation = rankWeightedText.contains(transcriptBean.getRankWeighted());
            } else {
                rankWeightedValidation = true;
            }
            if (transcriptBean.getSelfReported() != "") {
                String selfReportedText = getText(By.cssSelector(transcriptSelfReportedElement(group)));
                selfReportedValidation = selfReportedText.contains(transcriptBean.getSelfReported());
            } else {
                selfReportedValidation = true;
            }
            if (transcriptBean.getComments() != "") {
                String commentsText = getAtribute(By.cssSelector(transcriptCommentsField(group)),"value");
                commentsValidation = commentsText.contains(transcriptBean.getComments());
            } else {
                commentsValidation = true;
            }

            if(typeValidation
                    && graduationDateValidation
                    && transcriptDateValidation
                    && gedValidation
                    && diplomaReceivedValidation
                    && officialTranscriptValidation
                    && classRankValidation
                    && classSizeValidation
                    && gpaValidation
                    && gpaRecalculatedValidation
                    && scaleValidation
                    && weightedValidation
                    && percentileValidation
                    && rankUnavailableValidation
                    && rankWeightedValidation
                    && selfReportedValidation
                    && commentsValidation
               ){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void createTranscript(String person,String group){
        int personIndex = Integer.parseInt(person);
        int updateTranscriptDelay = 20;
        TranscriptBean transcriptBean = new TranscriptBean();
        transcriptBean.setType(mass.get(personIndex).get("TranscriptType"));
        transcriptBean.setTranscriptDate(mass.get(personIndex).get("TranscriptDate"));
        transcriptBean.setGraduationDate(mass.get(personIndex).get("GraduationDate"));
        transcriptBean.setDiplomaReceived(mass.get(personIndex).get("DiplomaReceived"));
        transcriptBean.setOfficialTranscript(mass.get(personIndex).get("OfficialTranscript"));
        transcriptBean.setGpa(mass.get(personIndex).get("GPA"));
        transcriptBean.setGed(mass.get(personIndex).get("GED"));
        transcriptBean.setGpaRecalculated(mass.get(personIndex).get("GPARecalculated"));
        transcriptBean.setScale(mass.get(personIndex).get("Scale"));
        transcriptBean.setSelfReported(mass.get(personIndex).get("SelfReported"));
        transcriptBean.setComments(mass.get(personIndex).get("TranscriptComments"));
        transcriptBean.setClassRank(mass.get(personIndex).get("ClassRank"));
        transcriptBean.setClassSize(mass.get(personIndex).get("ClassSize"));
        transcriptBean.setWeighted(mass.get(personIndex).get("Weighted"));
        transcriptBean.setPercentile(mass.get(personIndex).get("Percentile"));
        transcriptBean.setRankUnavailable(mass.get(personIndex).get("RankUnavailable"));
        transcriptBean.setRankWeighted(mass.get(personIndex).get("RankWeighted"));

        String passMessage = String.format(LogPage.CREATE_TRANSCRIPT_PASS,person,group);
        String failMessage = String.format(LogPage.CREATE_TRANSCRIPT_FAIL,person,group);

        try {
            scrollToElement(By.cssSelector(transcriptPlusSign(group)));
            if(transcriptBean.getType()!=""){
                wait(1000);
                BasePage.click(By.cssSelector(transcriptTypeElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getType());
            }
            if(transcriptBean.getTranscriptDate()!=""){
                waitElementBy(By.cssSelector(transcriptDateField(group)),updateTranscriptDelay);
                KeyPage.erase(By.cssSelector(transcriptDateField(group)));
                BasePage.write(By.cssSelector(transcriptDateField(group)), transcriptBean.getTranscriptDate());
                KeyPage.pressKey(By.cssSelector(transcriptDateField(group)),"Enter");
            }
            if(transcriptBean.getGraduationDate()!=""){
                waitElementBy(By.cssSelector(transcriptGraduationDateField(group)),updateTranscriptDelay);
                KeyPage.erase(By.cssSelector(transcriptGraduationDateField(group)));
                BasePage.write(By.cssSelector(transcriptGraduationDateField(group)), transcriptBean.getGraduationDate());
                KeyPage.pressKey(By.cssSelector(transcriptGraduationDateField(group)),"Enter");
            }
            if(transcriptBean.getGed()!=""){
                waitElementBy(By.cssSelector(transcriptGEDElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptGEDElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getGed());
            }
            if(transcriptBean.getDiplomaReceived()!=""){
                waitElementBy(By.cssSelector(transcriptDiplomaReceivedElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptDiplomaReceivedElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getDiplomaReceived());
            }
            if(transcriptBean.getOfficialTranscript()!=""){
                waitElementBy(By.cssSelector(transcriptOfficialTranscriptElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptOfficialTranscriptElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getOfficialTranscript());
            }
            if(transcriptBean.getClassRank()!=""){
                waitElementBy(By.cssSelector(transcriptClassRankField(group)),updateTranscriptDelay);
                BasePage.write(By.cssSelector(transcriptClassRankField(group)), transcriptBean.getClassRank());
            }
            if(transcriptBean.getClassSize()!=""){
                waitElementBy(By.cssSelector(transcriptClassSizeField(group)),updateTranscriptDelay);
                BasePage.write(By.cssSelector(transcriptClassSizeField(group)), transcriptBean.getClassSize());
            }

            if(transcriptBean.getGpa()!=""){
                waitElementBy(By.cssSelector(transcriptGpaField(group)),updateTranscriptDelay);
                BasePage.write(By.cssSelector(transcriptGpaField(group)), transcriptBean.getGpa());
            }
            if(transcriptBean.getGpaRecalculated()!=""){
                waitElementBy(By.cssSelector(transcriptGpaRecalculatedField(group)),updateTranscriptDelay);
                BasePage.write(By.cssSelector(transcriptGpaRecalculatedField(group)), transcriptBean.getGpaRecalculated());
            }
            scrollToElement(By.cssSelector(transcriptGraduationDateField(group)));
            if(transcriptBean.getScale()!=""){
                waitElementBy(By.cssSelector(transcriptScaleField(group)),updateTranscriptDelay);
                BasePage.write(By.cssSelector(transcriptScaleField(group)), transcriptBean.getScale());
            }
            if(transcriptBean.getWeighted()!=""){
                waitElementBy(By.cssSelector(transcriptWeightedElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptWeightedElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getWeighted());
            }
            if(transcriptBean.getPercentile()!=""){
                waitElementBy(By.cssSelector(transcriptPercentileField(group)),updateTranscriptDelay);
                BasePage.write(By.cssSelector(transcriptPercentileField(group)), transcriptBean.getPercentile());
            }
            if(transcriptBean.getRankUnavailable()!=""){
                waitElementBy(By.cssSelector(transcriptRankUnavailableElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptRankUnavailableElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getRankUnavailable());
            }
            if(transcriptBean.getRankWeighted()!=""){
                waitElementBy(By.cssSelector(transcriptRankWeightedElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptRankWeightedElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getRankWeighted());
            }
            if(transcriptBean.getSelfReported()!=""){
                waitElementBy(By.cssSelector(transcriptSelfReportedElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptSelfReportedElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getSelfReported());
            }
            if(transcriptBean.getComments()!=""){
                waitElementBy(By.cssSelector(transcriptCommentsField(group)),updateTranscriptDelay);
                BasePage.write(By.cssSelector(transcriptCommentsField(group)), transcriptBean.getComments());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
