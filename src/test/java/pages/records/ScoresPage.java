package pages.records;

import bean.ScoreBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;

public class ScoresPage extends BasePage {
    private static final String SCORE_TYPE_ELEMENT_FIELD = "//input[starts-with(@aria-activedescendant, 'select2-result-label-')]";

    private static String scorePlusSign(String index){
        return String.format("#person_score_%s_add",index);
    }
    private static String scoreComponentPlusSign(String group,String index){
        return String.format("#person_score_%s_person_score_component_%s_add",group,index);
    }
    private static String scoreTypeElement(String index){
        return String.format("#s2id_person_score_%s_score_type",index);
    }
    private static String scoreField(String index){
        return String.format("#person_score_%s_score",index);
    }
    private static String scoreDateField(String index){
        return String.format("#person_score_%s_score_date",index);
    }
    private static String sourceElement(String index){
        return String.format("#s2id_person_score_%s_score_source",index);
    }
    private static String officialElement(String index){
        return String.format("#s2id_person_score_%s_score_official",index);
    }
    private static String scoreCommentsField(String index){
        return String.format("#person_score_%s_score_comments",index);
    }
    private static String componentElement(String group,String index){
        return String.format("#s2id_person_score_%s_person_score_component_%s_score_component",group,index);
    }
    private static String componentScoreField(String group,String index){
        return String.format("#person_score_%s_person_score_component_%s_score_component_score",group,index);
    }

    public static void addScore(String group){
        String passMessage = String.format(LogPage.ADD_SCORE_PASS,group);
        String failMessage = String.format(LogPage.ADD_SCORE_FAIL,group);
        try {
            MainPage.addDeleteWithPlusButton(By.cssSelector(scorePlusSign(group)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyScore(ScoreBean scoreBean,String group){

        String passMessage = String.format(LogPage.VERIFY_SCORE_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_SCORE_FAIL,group);
        try {
            if(MainPage.verifyGetText(By.cssSelector(scoreTypeElement(group)),scoreBean.getScoreType())
                    && MainPage.verifyGetAttribute(By.cssSelector(scoreField(group)),scoreBean.getScore())
                    && MainPage.verifyGetAttribute(By.cssSelector(scoreDateField(group)),scoreBean.getScoreDate())
                    && MainPage.verifyGetText(By.cssSelector(sourceElement(group)),scoreBean.getSource())
                    && MainPage.verifyGetText(By.cssSelector(officialElement(group)),scoreBean.getOfficial())
                    && MainPage.verifyGetText(By.cssSelector(scoreCommentsField(group)),scoreBean.getComments())
                    && MainPage.verifyGetText(By.cssSelector(scoreCommentsField(group)),scoreBean.getComments())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"0")),scoreBean.getComponent1())
                    && MainPage.verifyGetAttribute(By.cssSelector(componentScoreField(group,"0")),scoreBean.getComponent1Score())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"1")),scoreBean.getComponent2())
                    && MainPage.verifyGetAttribute(By.cssSelector(componentScoreField(group,"1")),scoreBean.getComponent2Score())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"2")),scoreBean.getComponent3())
                    && MainPage.verifyGetAttribute(By.cssSelector(componentScoreField(group,"2")),scoreBean.getComponent3Score())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"3")),scoreBean.getComponent4())
                    && MainPage.verifyGetAttribute(By.cssSelector(componentScoreField(group,"3")),scoreBean.getComponent4Score())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"4")),scoreBean.getComponent5())
                    && MainPage.verifyGetAttribute(By.cssSelector(componentScoreField(group,"4")),scoreBean.getComponent5Score())){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyComponents(ScoreBean scoreBean,String group){

        String passMessage = String.format(LogPage.VERIFY_COMPONENTS_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_COMPONENTS_FAIL,group);
        try {
            if(MainPage.verifyGetText(By.cssSelector(componentElement(group,"0")),scoreBean.getComponent1())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"1")),scoreBean.getComponent2Score())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"2")),scoreBean.getComponent3Score())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"3")),scoreBean.getComponent4Score())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"4")),scoreBean.getComponent5Score())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"5")),scoreBean.getComponent6Score())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"6")),scoreBean.getComponent7Score())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"7")),scoreBean.getComponent8Score())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"8")),scoreBean.getComponent9Score())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"9")),scoreBean.getComponent10Score())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"10")),scoreBean.getComponent11Score())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"11")),scoreBean.getComponent12Score())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"12")),scoreBean.getComponent13Score())
                    && MainPage.verifyGetText(By.cssSelector(componentElement(group,"13")),scoreBean.getComponent14Score())){
                    ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void updateComponentScore(ScoreBean scoreBean,String group){
        String failMessage = String.format(LogPage.UPDATE_COMPONENT_SCORE_FAIL,group);
        try {
            if(scoreBean.getComponent1Score()!=""){
                MainPage.fillField(By.cssSelector(componentScoreField(group,"0")), scoreBean.getComponent1Score());
            }
            if(scoreBean.getComponent2Score()!=""){
                MainPage.fillField(By.cssSelector(componentScoreField(group,"1")), scoreBean.getComponent2Score());
            }
            if(scoreBean.getComponent3Score()!=""){
                MainPage.fillField(By.cssSelector(componentScoreField(group,"2")), scoreBean.getComponent3Score());
            }
            if(scoreBean.getComponent4Score()!=""){
                MainPage.fillField(By.cssSelector(componentScoreField(group,"3")), scoreBean.getComponent4Score());
            }
            if(scoreBean.getComponent5Score()!=""){
                MainPage.fillField(By.cssSelector(componentScoreField(group,"4")), scoreBean.getComponent5Score());
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateScore(ScoreBean scoreBean,String group){
        String passMessage = String.format(LogPage.UPDATE_SCORE_PASS,group);
        String failMessage = String.format(LogPage.UPDATE_SCORE_FAIL,group);

        try {
            if(scoreBean.getScoreType()!=""){
                MainPage.inputOptionField(By.cssSelector(scoreTypeElement(group)),
                        scoreBean.getScoreType(),
                        By.xpath(SCORE_TYPE_ELEMENT_FIELD));
            }
            if(scoreBean.getScore()!=""){
                MainPage.fillField(By.cssSelector(scoreField(group)), scoreBean.getScore());
            }
            if(scoreBean.getScoreDate()!=""){
                MainPage.fillDateField(By.cssSelector(scoreDateField(group)), scoreBean.getScoreDate());
            }
            if(scoreBean.getSource()!=""){
                MainPage.inputOptionField(By.cssSelector(sourceElement(group)),scoreBean.getSource(),By.xpath(SCORE_TYPE_ELEMENT_FIELD));
            }
            if(scoreBean.getComments()!=""){
                MainPage.fillField(By.cssSelector(scoreCommentsField(group)), scoreBean.getComments());
            }
            updateComponentScore(scoreBean,group);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
