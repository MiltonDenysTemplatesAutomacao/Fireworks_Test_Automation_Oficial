package pages.records;

import bean.TranscriptBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.*;

public class TranscriptPage extends BasePage {

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
            MainPage.addDeleteWithPlusButton(By.cssSelector(transcriptPlusSign(index)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyNoHighSchoolFieldsAreVisible(String group){
        String passMessage = String.format(LogPage.VERIFY_NO_POST_SECONDARY_FIELDS_ARE_VISIBLE_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_NO_POST_SECONDARY_FIELDS_ARE_VISIBLE_FAIL,group);

        try {
            if(!MainPage.verifyIfElementIsVisible(By.cssSelector(transcriptClassRankField(group)))
                    && !MainPage.verifyIfElementIsVisible(By.cssSelector(transcriptClassSizeField(group)))
                    && !MainPage.verifyIfElementIsVisible(By.cssSelector(transcriptWeightedElement(group)))
                    && !MainPage.verifyIfElementIsVisible(By.cssSelector(transcriptPercentileField(group)))
                    && !MainPage.verifyIfElementIsVisible(By.cssSelector(transcriptRankUnavailableElement(group)))
                    && !MainPage.verifyIfElementIsVisible(By.cssSelector(transcriptRankWeightedElement(group)))
                    && !MainPage.verifyIfElementIsVisible(By.cssSelector(transcriptGEDElement(group)))
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
            if(!MainPage.verifyIfElementIsVisible(By.cssSelector(transcriptMajorElement(group)))
                    && !MainPage.verifyIfElementIsVisible(By.cssSelector(transcriptDegreeElement(group)))
                    && !MainPage.verifyIfElementIsVisible(By.cssSelector(transcriptDegreeLevelElement(group)))
                    && !MainPage.verifyIfElementIsVisible(By.cssSelector(transcriptDegreeEarnedElement(group)))
                    && !MainPage.verifyIfElementIsVisible(By.cssSelector(transcriptDegreeDateField(group)))
                    && !MainPage.verifyIfElementIsVisible(By.cssSelector(transcriptMinorElement(group)))
                    && !MainPage.verifyIfElementIsVisible(By.cssSelector(transcriptConcentrationElement(group)))
                    && !MainPage.verifyIfElementIsVisible(By.cssSelector(transcriptCreditHoursField(group)))){
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
        transcriptBean.setTranscriptDate(mass.get(personIndex).get("TranscriptDate"));
        transcriptBean.setStartDate(mass.get(personIndex).get("StarDate"));
        transcriptBean.setEndDate(mass.get(personIndex).get("EndDate"));
        transcriptBean.setGraduationDate(mass.get(personIndex).get("GraduationDate"));
        transcriptBean.setGed(mass.get(personIndex).get("GED"));
        transcriptBean.setDiplomaReceived(mass.get(personIndex).get("DiplomaReceived"));
        transcriptBean.setOfficialTranscript(mass.get(personIndex).get("OfficialTranscript"));
        transcriptBean.setMajor(mass.get(personIndex).get("Major"));
        transcriptBean.setDegree(mass.get(personIndex).get("Degree"));
        transcriptBean.setDegreeLevel(mass.get(personIndex).get("DegreeLevel"));
        transcriptBean.setDegreeEarned(mass.get(personIndex).get("DegreeLevelEarned"));
        transcriptBean.setDegreeDate(mass.get(personIndex).get("DegreeDate"));
        transcriptBean.setMinor(mass.get(personIndex).get("Minor"));
        transcriptBean.setConcentration(mass.get(personIndex).get("Concentration"));
        transcriptBean.setCreditHours(mass.get(personIndex).get("CreditHours"));
        transcriptBean.setGpa(mass.get(personIndex).get("GPA"));
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

        String passMessage = String.format(LogPage.VERIFY_TRANSCRIPT_PASS,person,group);
        String failMessage = String.format(LogPage.VERIFY_TRANSCRIPT_FAIL,person,group);

        try {
            if(MainPage.verifyGetText(By.cssSelector(transcriptTypeElement(group)),transcriptBean.getType())
                    && MainPage.verifyGetAttribute(By.cssSelector(transcriptDateField(group)),transcriptBean.getTranscriptDate())
                    && MainPage.verifyGetAttribute(By.cssSelector(transcriptGraduationDateField(group)),transcriptBean.getGraduationDate())
                    && MainPage.verifyGetText(By.cssSelector(transcriptGEDElement(group)),transcriptBean.getGed())
                    && MainPage.verifyGetText(By.cssSelector(transcriptDiplomaReceivedElement(group)),transcriptBean.getDiplomaReceived())
                    && MainPage.verifyGetText(By.cssSelector(transcriptOfficialTranscriptElement(group)),transcriptBean.getOfficialTranscript())
                    && MainPage.verifyGetText(By.cssSelector(transcriptMajorElement(group)),transcriptBean.getMajor())
                    && MainPage.verifyGetText(By.cssSelector(transcriptDegreeElement(group)),transcriptBean.getDegree())
                    && MainPage.verifyGetText(By.cssSelector(transcriptDegreeLevelElement(group)),transcriptBean.getDegreeLevel())
                    && MainPage.verifyGetText(By.cssSelector(transcriptDegreeEarnedElement(group)),transcriptBean.getDegreeEarned())
                    && MainPage.verifyGetAttribute(By.cssSelector(transcriptDegreeDateField(group)),transcriptBean.getDegreeDate())
                    && MainPage.verifyGetText(By.cssSelector(transcriptMinorElement(group)),transcriptBean.getMinor())
                    && MainPage.verifyGetText(By.cssSelector(transcriptConcentrationElement(group)),transcriptBean.getConcentration())
                    && MainPage.verifyGetAttribute(By.cssSelector(transcriptCreditHoursField(group)),transcriptBean.getCreditHours())
                    && MainPage.verifyGetAttribute(By.cssSelector(transcriptClassRankField(group)),transcriptBean.getClassRank())
                    && MainPage.verifyGetAttribute(By.cssSelector(transcriptClassSizeField(group)),transcriptBean.getClassSize())
                    && MainPage.verifyGetAttribute(By.cssSelector(transcriptGpaField(group)),transcriptBean.getGpa())
                    && MainPage.verifyGetAttribute(By.cssSelector(transcriptGpaRecalculatedField(group)),transcriptBean.getGpaRecalculated())
                    && MainPage.verifyGetAttribute(By.cssSelector(transcriptScaleField(group)),transcriptBean.getScale())
                    && MainPage.verifyGetText(By.cssSelector(transcriptWeightedElement(group)),transcriptBean.getWeighted())
                    && MainPage.verifyGetAttribute(By.cssSelector(transcriptPercentileField(group)),transcriptBean.getPercentile())
                    && MainPage.verifyGetText(By.cssSelector(transcriptRankUnavailableElement(group)),transcriptBean.getRankUnavailable())
                    && MainPage.verifyGetText(By.cssSelector(transcriptRankWeightedElement(group)),transcriptBean.getRankWeighted())
                    && MainPage.verifyGetText(By.cssSelector(transcriptSelfReportedElement(group)),transcriptBean.getSelfReported())
                    && MainPage.verifyGetAttribute(By.cssSelector(transcriptCommentsField(group)),transcriptBean.getComments())){
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
                MainPage.clickOptionList(By.cssSelector(transcriptTypeElement(group)),
                        transcriptBean.getType(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(transcriptBean.getTranscriptDate()!=null){
                MainPage.fillDateField(By.cssSelector(transcriptDateField(group)), transcriptBean.getTranscriptDate());
            }
            if(transcriptBean.getStartDate()!=null){
                MainPage.fillDateField(By.cssSelector(transcriptDateField(group)), transcriptBean.getStartDate());
            }
            if(transcriptBean.getEndDate()!=null){
                MainPage.fillDateField(By.cssSelector(transcriptDateField(group)), transcriptBean.getEndDate());
            }
            if(transcriptBean.getGraduationDate()!=null){
                MainPage.fillDateField(By.cssSelector(transcriptDateField(group)), transcriptBean.getGraduationDate());
            }
            if(transcriptBean.getGed()!=null){
                MainPage.clickOptionList(By.cssSelector(transcriptGEDElement(group)),
                        transcriptBean.getGed(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(transcriptBean.getDiplomaReceived()!=null){
                MainPage.clickOptionList(By.cssSelector(transcriptDiplomaReceivedElement(group)),
                        transcriptBean.getDiplomaReceived(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(transcriptBean.getOfficialTranscript()!=null){
                MainPage.clickOptionList(By.cssSelector(transcriptOfficialTranscriptElement(group)),
                        transcriptBean.getOfficialTranscript(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(transcriptBean.getMajor()!=null){
                MainPage.clickOptionList(By.cssSelector(transcriptMajorElement(group)),
                        transcriptBean.getMajor(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(transcriptBean.getDegree()!=null){
                MainPage.clickOptionList(By.cssSelector(transcriptDegreeElement(group)),
                        transcriptBean.getDegree(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(transcriptBean.getDegreeLevel()!=null){
                MainPage.clickOptionList(By.cssSelector(transcriptDegreeLevelElement(group)),
                        transcriptBean.getDegreeLevel(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(transcriptBean.getDegreeEarned()!=null){
                MainPage.clickOptionList(By.cssSelector(transcriptDegreeEarnedElement(group)),
                        transcriptBean.getDegreeEarned(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(transcriptBean.getDegreeDate()!=null){
                MainPage.fillField(By.cssSelector(transcriptDegreeDateField(group)), transcriptBean.getDegreeDate());
            }
            if(transcriptBean.getMinor()!=null){
                MainPage.clickOptionList(By.cssSelector(transcriptMinorElement(group)),
                        transcriptBean.getMinor(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(transcriptBean.getConcentration()!=null){
                MainPage.clickOptionList(By.cssSelector(transcriptConcentrationElement(group)),
                        transcriptBean.getConcentration(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(transcriptBean.getCreditHours()!=null){
                MainPage.fillField(By.cssSelector(transcriptCreditHoursField(group)), transcriptBean.getCreditHours());
            }
            if(transcriptBean.getClassRank()!=null){
                MainPage.fillField(By.cssSelector(transcriptClassRankField(group)), transcriptBean.getClassRank());
            }
            if(transcriptBean.getClassSize()!=null){
                MainPage.fillField(By.cssSelector(transcriptClassSizeField(group)), transcriptBean.getClassSize());
            }
            if(transcriptBean.getGpa()!=null){
                MainPage.fillField(By.cssSelector(transcriptGpaField(group)), transcriptBean.getGpa());
            }
            if(transcriptBean.getGpaRecalculated()!=null){
                MainPage.fillField(By.cssSelector(transcriptGpaRecalculatedField(group)), transcriptBean.getGpaRecalculated());
            }
            scrollToElement(By.cssSelector(transcriptGraduationDateField(group)));
            if(transcriptBean.getScale()!=null){
                MainPage.fillField(By.cssSelector(transcriptScaleField(group)), transcriptBean.getScale());
            }
            if(transcriptBean.getWeighted()!=null){
                MainPage.clickOptionList(By.cssSelector(transcriptWeightedElement(group)),
                        transcriptBean.getWeighted(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(transcriptBean.getPercentile()!=null){
                MainPage.fillField(By.cssSelector(transcriptPercentileField(group)), transcriptBean.getPercentile());
            }
            if(transcriptBean.getRankUnavailable()!=null){
                MainPage.clickOptionList(By.cssSelector(transcriptRankUnavailableElement(group)),
                        transcriptBean.getRankUnavailable(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(transcriptBean.getRankWeighted()!=null){
                MainPage.clickOptionList(By.cssSelector(transcriptRankWeightedElement(group)),
                        transcriptBean.getRankWeighted(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(transcriptBean.getSelfReported()!=null){
                MainPage.clickOptionList(By.cssSelector(transcriptSelfReportedElement(group)),
                        transcriptBean.getSelfReported(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(transcriptBean.getComments()!=null){
                MainPage.fillField(By.cssSelector(transcriptCommentsField(group)), transcriptBean.getComments());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
