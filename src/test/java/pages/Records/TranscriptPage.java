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
    private static String transcriptMajorElement(String index){
        return String.format("#s2id_person_school_0_person_school_transcript_%s_transcript_major_program",index);
    }
    private static String transcriptDegreeElement(String index){
        return String.format("#s2id_person_school_0_person_school_transcript_%s_transcript_degree",index);
    }
    private static String transcriptDegreeLevelElement(String index){
        return String.format("#s2id_person_school_0_person_school_transcript_%s_transcript_degree_level",index);
    }
    private static String transcriptDegreeEarnedElement(String index){
        return String.format("#s2id_person_school_0_person_school_transcript_%s_transcript_degree_earned",index);
    }
    private static String transcriptDegreeDateField(String index){
        return String.format("#person_school_0_person_school_transcript_%s_transcript_degree_date",index);
    }
    private static String transcriptMinorElement(String index){
        return String.format("#s2id_person_school_0_person_school_transcript_%s_transcript_minor",index);
    }
    private static String transcriptConcentrationElement(String index){
        return String.format("#s2id_person_school_0_person_school_transcript_%s_transcript_concentration",index);
    }
    private static String transcriptCreditHoursField(String index){
        return String.format("#person_school_0_person_school_transcript_%s_transcript_credit_hours",index);
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

    public static void addTranscript(String index){
        String passMessage = String.format(LogPage.ADD_TRANSCRIPT_PASS,index);
        String failMessage = String.format(LogPage.ADD_TRANSCRIPT_FAIL,index);
        try {
            waitUntilElementToBeSelected(By.cssSelector(transcriptPlusSign(index)),20);
            scrollToElement(By.cssSelector(transcriptPlusSign(index)));
            scrollTo("-150");
            wait(1000);
            click(By.cssSelector(transcriptPlusSign(index)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyNoHighSchoolFieldsAreVisible(String group){
        String passMessage = String.format(LogPage.VERIFY_NO_POST_SECONDARY_FIELDS_ARE_VISIBLE_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_NO_POST_SECONDARY_FIELDS_ARE_VISIBLE_FAIL,group);

        try {
            scrollToElement(By.cssSelector(transcriptPlusSign(group)));
            boolean classRankValidation = !checkIfElementIsVisible(By.cssSelector(transcriptClassRankField(group)));
            boolean classSizeValidation = !checkIfElementIsVisible(By.cssSelector(transcriptClassSizeField(group)));
            boolean weightedValidation = !checkIfElementIsVisible(By.cssSelector(transcriptWeightedElement(group)));
            boolean percentileValidation = !checkIfElementIsVisible(By.cssSelector(transcriptPercentileField(group)));
            boolean rankUnavailableValidation = !checkIfElementIsVisible(By.cssSelector(transcriptRankUnavailableElement(group)));
            boolean rankWeightedValidation = !checkIfElementIsVisible(By.cssSelector(transcriptRankWeightedElement(group)));
            boolean gedValidation = !checkIfElementIsVisible(By.cssSelector(transcriptGEDElement(group)));

            if(classRankValidation
                    && classSizeValidation
                    && weightedValidation
                    && percentileValidation
                    && rankUnavailableValidation
                    && rankWeightedValidation
                    && gedValidation
                    ){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    /**
     * This method will verify fields unique to Colleges are not visible
     */
    public static void verifyNoPostSecondaryFieldsAreVisible(String group){
        String passMessage = String.format(LogPage.VERIFY_NO_POST_SECONDARY_FIELDS_ARE_VISIBLE_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_NO_POST_SECONDARY_FIELDS_ARE_VISIBLE_FAIL,group);

        try {
            scrollToElement(By.cssSelector(transcriptPlusSign(group)));
            boolean transcriptMajorValidation = !checkIfElementIsVisible(By.cssSelector(transcriptMajorElement(group)));
            boolean transcriptDegreeValidation = !checkIfElementIsVisible(By.cssSelector(transcriptDegreeElement(group)));
            boolean transcriptDegreeLevelValidation = !checkIfElementIsVisible(By.cssSelector(transcriptDegreeLevelElement(group)));
            boolean transcriptDegreeEarnedValidation = !checkIfElementIsVisible(By.cssSelector(transcriptDegreeEarnedElement(group)));
            boolean transcriptDegreeDateFieldValidation = !checkIfElementIsVisible(By.cssSelector(transcriptDegreeDateField(group)));
            boolean transcriptMinorValidation = !checkIfElementIsVisible(By.cssSelector(transcriptMinorElement(group)));
            boolean transcriptConcentrationValidation = !checkIfElementIsVisible(By.cssSelector(transcriptConcentrationElement(group)));
            boolean transcriptCreditHoursFieldValidation = !checkIfElementIsVisible(By.cssSelector(transcriptCreditHoursField(group)));

            if(transcriptMajorValidation
            && transcriptDegreeValidation
            && transcriptDegreeLevelValidation
            && transcriptDegreeEarnedValidation
            && transcriptDegreeDateFieldValidation
            && transcriptMinorValidation
            && transcriptConcentrationValidation
            && transcriptCreditHoursFieldValidation){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
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
        transcriptBean.setMajor(mass.get(personIndex).get("Major"));
        transcriptBean.setDegree(mass.get(personIndex).get("Degree"));
        transcriptBean.setDegreeLevel(mass.get(personIndex).get("DegreeLevel"));
        transcriptBean.setDegreeEarned(mass.get(personIndex).get("DegreeEarned"));
        transcriptBean.setDegreeDate(mass.get(personIndex).get("DegreeDate"));
        transcriptBean.setMinor(mass.get(personIndex).get("Minor"));
        transcriptBean.setCreditHours(mass.get(personIndex).get("CreditHours"));
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
            if(transcriptBean.getType()!=null){
                wait(1000);
                BasePage.click(By.cssSelector(transcriptTypeElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getType());
            }
            if(transcriptBean.getTranscriptDate()!=null){
                waitElementBy(By.cssSelector(transcriptDateField(group)),updateTranscriptDelay);
                KeyPage.erase(By.cssSelector(transcriptDateField(group)));
                BasePage.write(By.cssSelector(transcriptDateField(group)), transcriptBean.getTranscriptDate());
                KeyPage.pressKey(By.cssSelector(transcriptDateField(group)),"Enter");
            }
            if(transcriptBean.getStartDate()!=null){
                waitElementBy(By.cssSelector(transcriptStartDateField(group)),updateTranscriptDelay);
                KeyPage.erase(By.cssSelector(transcriptStartDateField(group)));
                BasePage.write(By.cssSelector(transcriptStartDateField(group)), transcriptBean.getStartDate());
                KeyPage.pressKey(By.cssSelector(transcriptStartDateField(group)),"Enter");
            }
            if(transcriptBean.getEndDate()!=null){
                waitElementBy(By.cssSelector(transcriptEndDateField(group)),updateTranscriptDelay);
                KeyPage.erase(By.cssSelector(transcriptEndDateField(group)));
                BasePage.write(By.cssSelector(transcriptEndDateField(group)), transcriptBean.getEndDate());
                KeyPage.pressKey(By.cssSelector(transcriptEndDateField(group)),"Enter");
            }
            if(transcriptBean.getGraduationDate()!=null){
                waitElementBy(By.cssSelector(transcriptGraduationDateField(group)),updateTranscriptDelay);
                KeyPage.erase(By.cssSelector(transcriptGraduationDateField(group)));
                BasePage.write(By.cssSelector(transcriptGraduationDateField(group)), transcriptBean.getGraduationDate());
                KeyPage.pressKey(By.cssSelector(transcriptGraduationDateField(group)),"Enter");
            }
            if(transcriptBean.getGed()!=null){
                waitElementBy(By.cssSelector(transcriptGEDElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptGEDElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getGed());
            }
            if(transcriptBean.getDiplomaReceived()!=null){
                waitElementBy(By.cssSelector(transcriptDiplomaReceivedElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptDiplomaReceivedElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getDiplomaReceived());
            }
            if(transcriptBean.getOfficialTranscript()!=null){
                waitElementBy(By.cssSelector(transcriptOfficialTranscriptElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptOfficialTranscriptElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getOfficialTranscript());
            }
            if(transcriptBean.getMajor()!=null){
                waitElementBy(By.cssSelector(transcriptMajorElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptMajorElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getMajor());
            }
            if(transcriptBean.getDegree()!=null){
                waitElementBy(By.cssSelector(transcriptDegreeElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptDegreeElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getDegree());
            }
            if(transcriptBean.getDegreeLevel()!=null){
                waitElementBy(By.cssSelector(transcriptDegreeLevelElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptDegreeLevelElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getDegreeLevel());
            }
            if(transcriptBean.getDegreeEarned()!=null){
                waitElementBy(By.cssSelector(transcriptDegreeEarnedElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptDegreeEarnedElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getDegreeEarned());
            }
            if(transcriptBean.getDegreeDate()!=null){
                waitElementBy(By.cssSelector(transcriptDegreeDateField(group)),updateTranscriptDelay);
                BasePage.write(By.cssSelector(transcriptDegreeDateField(group)), transcriptBean.getDegreeDate());
            }
            if(transcriptBean.getMinor()!=null){
                waitElementBy(By.cssSelector(transcriptMinorElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptMinorElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getMinor());
            }
            if(transcriptBean.getConcentration()!=null){
                waitElementBy(By.cssSelector(transcriptConcentrationElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptConcentrationElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getConcentration());
            }
            if(transcriptBean.getCreditHours()!=null){
                waitElementBy(By.cssSelector(transcriptCreditHoursField(group)),updateTranscriptDelay);
                BasePage.write(By.cssSelector(transcriptCreditHoursField(group)), transcriptBean.getCreditHours());
            }
            if(transcriptBean.getClassRank()!=null){
                waitElementBy(By.cssSelector(transcriptClassRankField(group)),updateTranscriptDelay);
                BasePage.write(By.cssSelector(transcriptClassRankField(group)), transcriptBean.getClassRank());
            }
            if(transcriptBean.getClassSize()!=null){
                waitElementBy(By.cssSelector(transcriptClassSizeField(group)),updateTranscriptDelay);
                BasePage.write(By.cssSelector(transcriptClassSizeField(group)), transcriptBean.getClassSize());
            }

            if(transcriptBean.getGpa()!=null){
                waitElementBy(By.cssSelector(transcriptGpaField(group)),updateTranscriptDelay);
                BasePage.write(By.cssSelector(transcriptGpaField(group)), transcriptBean.getGpa());
            }
            if(transcriptBean.getGpaRecalculated()!=null){
                waitElementBy(By.cssSelector(transcriptGpaRecalculatedField(group)),updateTranscriptDelay);
                BasePage.write(By.cssSelector(transcriptGpaRecalculatedField(group)), transcriptBean.getGpaRecalculated());
            }
            scrollToElement(By.cssSelector(transcriptGraduationDateField(group)));
            if(transcriptBean.getScale()!=null){
                waitElementBy(By.cssSelector(transcriptScaleField(group)),updateTranscriptDelay);
                BasePage.write(By.cssSelector(transcriptScaleField(group)), transcriptBean.getScale());
            }
            if(transcriptBean.getWeighted()!=null){
                waitElementBy(By.cssSelector(transcriptWeightedElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptWeightedElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getWeighted());
            }
            if(transcriptBean.getPercentile()!=null){
                waitElementBy(By.cssSelector(transcriptPercentileField(group)),updateTranscriptDelay);
                BasePage.write(By.cssSelector(transcriptPercentileField(group)), transcriptBean.getPercentile());
            }
            if(transcriptBean.getRankUnavailable()!=null){
                waitElementBy(By.cssSelector(transcriptRankUnavailableElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptRankUnavailableElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getRankUnavailable());
            }
            if(transcriptBean.getRankWeighted()!=null){
                waitElementBy(By.cssSelector(transcriptRankWeightedElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptRankWeightedElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getRankWeighted());
            }
            if(transcriptBean.getSelfReported()!=null){
                scrollToElement(By.cssSelector(transcriptSelfReportedElement(group)));
                scrollTo("-150");
                waitElementBy(By.cssSelector(transcriptSelfReportedElement(group)),updateTranscriptDelay);
                BasePage.click(By.cssSelector(transcriptSelfReportedElement(group)));
                waitElementBy(By.cssSelector(SELECT_DROP),updateTranscriptDelay);
                BasePage.selectElementsList(By.cssSelector(SELECT_DROP), "a");
                wait(1000);
                clickOnListOfElements(transcriptBean.getSelfReported());
            }
            if(transcriptBean.getComments()!=null){
                waitElementBy(By.cssSelector(transcriptCommentsField(group)),updateTranscriptDelay);
                BasePage.write(By.cssSelector(transcriptCommentsField(group)), transcriptBean.getComments());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
