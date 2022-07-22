package pages.Records;

import bean.ScoreBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.KeyPage;
import pages.LogPage;

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
            scrollToElement(By.cssSelector(scorePlusSign(group)));
            scrollTo("-150");
            waitUntilElementToBeSelected(By.cssSelector(scorePlusSign(group)),20);
            click(By.cssSelector(scorePlusSign(group)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyScore(ScoreBean scoreBean,String group){

        String passMessage = String.format(LogPage.VERIFY_SCORE_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_SCORE_FAIL,group);
        boolean scoreTypeValidation = false;
        boolean scoreValidation = false;
        boolean scoreDateValidation = false;
        boolean sourceValidation = false;
        boolean oficialValidation = false;
        boolean commentsValidation = false;
        boolean component1Validation = false;
        boolean component2Validation = false;
        boolean component3Validation = false;
        boolean component4Validation = false;
        boolean component5Validation = false;
        boolean componentScore1Validation = false;
        boolean componentScore2Validation = false;
        boolean componentScore3Validation = false;
        boolean componentScore4Validation = false;
        boolean componentScore5Validation = false;

        try {
            if(scoreBean.getScoreType()!=""){
                scrollToElement(By.cssSelector(scorePlusSign(group)));
                String scoreTypeText = getText(By.cssSelector(scoreTypeElement(group)));
                scoreTypeValidation = scoreTypeText.contains(scoreBean.getScoreType());
            }else{
                scoreTypeValidation=true;
            }
            if(scoreBean.getScore()!=""){
                scrollToElement(By.cssSelector(scorePlusSign(group)));
                String scoreText = getAtribute(By.cssSelector(scoreField(group)),"value");
                scoreValidation = scoreText.contains(scoreBean.getScore());
            }else{
                scoreValidation=true;
            }
            if(scoreBean.getScoreDate()!=""){
                scrollToElement(By.cssSelector(scorePlusSign(group)));
                String scoreDateText = getAtribute(By.cssSelector(scoreDateField(group)),"value");
                scoreDateValidation = scoreDateText.contains(scoreBean.getScoreDate());
            }else{
                scoreDateValidation=true;
            }
            if(scoreBean.getSource()!=""){
                scrollToElement(By.cssSelector(scorePlusSign(group)));
                String sourceText = getText(By.cssSelector(sourceElement(group)));
                sourceValidation = sourceText.contains(scoreBean.getSource());
            }else{
                sourceValidation=true;
            }
            if(scoreBean.getOfficial()!=""){
                scrollToElement(By.cssSelector(scorePlusSign(group)));
                String officialText = getText(By.cssSelector(officialElement(group)));
                oficialValidation = officialText.contains(scoreBean.getOfficial());
            }else{
                oficialValidation=true;
            }
            if(scoreBean.getComments()!=""){
                scrollToElement(By.cssSelector(scorePlusSign(group)));
                String commentsText = getText(By.cssSelector(scoreCommentsField(group)));
                commentsValidation = commentsText.contains(scoreBean.getComments());
            }else{
                commentsValidation=true;
            }
            if(scoreBean.getComponent1()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"0")));
                waitElementBy(By.cssSelector(componentElement(group,"0")),20);
                String component1Text = getText(By.cssSelector(componentElement(group,"0")));
                component1Validation = component1Text.contains(scoreBean.getComponent1());
            }else{
                component1Validation=true;
            }
            if(scoreBean.getComponent1Score()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"0")));
                waitElementBy(By.cssSelector(componentElement(group,"0")),20);
                String componentScore1Text = getAtribute(By.cssSelector(componentScoreField(group,"0")),"value");
                componentScore1Validation = componentScore1Text.contains(scoreBean.getComponent1Score());
            }else{
                componentScore1Validation=true;
            }
            if(scoreBean.getComponent2()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"1")));
                waitElementBy(By.cssSelector(componentElement(group,"1")),20);
                String component2Text = getText(By.cssSelector(componentElement(group,"1")));
                component2Validation = component2Text.contains(scoreBean.getComponent2());
            }else{
                component2Validation=true;
            }
            if(scoreBean.getComponent2Score()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"1")));
                waitElementBy(By.cssSelector(componentElement(group,"1")),20);
                String componentScore2Text = getAtribute(By.cssSelector(componentScoreField(group,"1")),"value");
                componentScore2Validation = componentScore2Text.contains(scoreBean.getComponent2Score());
            }else{
                componentScore2Validation=true;
            }
            if(scoreBean.getComponent3()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"2")));
                String component3Text = getText(By.cssSelector(componentElement(group,"2")));
                component3Validation = component3Text.contains(scoreBean.getComponent3());
            }else{
                component3Validation=true;
            }
            if(scoreBean.getComponent3Score()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"2")));
                String componentScore3Text = getAtribute(By.cssSelector(componentScoreField(group,"2")),"value");
                componentScore3Validation = componentScore3Text.contains(scoreBean.getComponent3Score());
            }else{
                componentScore3Validation=true;
            }
            if(scoreBean.getComponent4()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"3")));
                String component4Text = getText(By.cssSelector(componentElement(group,"3")));
                component4Validation = component4Text.contains(scoreBean.getComponent4());
            }else{
                component4Validation=true;
            }
            if(scoreBean.getComponent4Score()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"3")));
                String componentScore4Text = getAtribute(By.cssSelector(componentScoreField(group,"3")),"value");
                componentScore4Validation = componentScore4Text.contains(scoreBean.getComponent4Score());
            }else{
                componentScore4Validation=true;
            }
            if(scoreBean.getComponent5()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"4")));
                String component5Text = getText(By.cssSelector(componentElement(group,"4")));
                component5Validation = component5Text.contains(scoreBean.getComponent5());
            }else{
                component5Validation=true;
            }
            if(scoreBean.getComponent5Score()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"4")));
                String componentScore5Text = getAtribute(By.cssSelector(componentScoreField(group,"4")),"value");
                componentScore5Validation = componentScore5Text.contains(scoreBean.getComponent5Score());
            }else{
                componentScore5Validation=true;
            }

            if(scoreTypeValidation
            && scoreDateValidation
            && sourceValidation
            && oficialValidation
            && commentsValidation
            && component1Validation
            && component2Validation
            && component3Validation
            && component4Validation
            && component5Validation
            && componentScore1Validation
            && componentScore2Validation
            && componentScore3Validation
            && componentScore4Validation
            && componentScore5Validation){
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
        boolean component1Validation = false;
        boolean component2Validation = false;
        boolean component3Validation = false;
        boolean component4Validation = false;
        boolean component5Validation = false;
        boolean component6Validation = false;
        boolean component7Validation = false;
        boolean component8Validation = false;
        boolean component9Validation = false;
        boolean component10Validation = false;
        boolean component11Validation = false;
        boolean component12Validation = false;
        boolean component13Validation = false;
        boolean component14Validation = false;

        try {
            if(scoreBean.getComponent1()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"0")));
                waitElementBy(By.cssSelector(componentElement(group,"0")),20);
                String component1Text = getText(By.cssSelector(componentElement(group,"0")));
                component1Validation = component1Text.contains(scoreBean.getComponent1());
            }else{
                component1Validation=true;
            }
            if(scoreBean.getComponent2()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"1")));
                waitElementBy(By.cssSelector(componentElement(group,"1")),20);
                String component2Text = getText(By.cssSelector(componentElement(group,"1")));
                component2Validation = component2Text.contains(scoreBean.getComponent2());
            }else{
                component2Validation=true;
            }
            if(scoreBean.getComponent3()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"2")));
                String component3Text = getText(By.cssSelector(componentElement(group,"2")));
                component3Validation = component3Text.contains(scoreBean.getComponent3());
            }else{
                component3Validation=true;
            }
            if(scoreBean.getComponent4()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"3")));
                String component4Text = getText(By.cssSelector(componentElement(group,"3")));
                component4Validation = component4Text.contains(scoreBean.getComponent4());
            }else{
                component4Validation=true;
            }
            if(scoreBean.getComponent5()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"4")));
                String component5Text = getText(By.cssSelector(componentElement(group,"4")));
                component5Validation = component5Text.contains(scoreBean.getComponent5());
            }else{
                component5Validation=true;
            }
            if(scoreBean.getComponent6()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"5")));
                String component6Text = getText(By.cssSelector(componentElement(group,"5")));
                component6Validation = component6Text.contains(scoreBean.getComponent6());
            }else{
                component6Validation=true;
            }
            if(scoreBean.getComponent7()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"6")));
                String component7Text = getText(By.cssSelector(componentElement(group,"6")));
                component7Validation = component7Text.contains(scoreBean.getComponent7());
            }else{
                component7Validation=true;
            }
            if(scoreBean.getComponent8()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"7")));
                String component8Text = getText(By.cssSelector(componentElement(group,"7")));
                component8Validation = component8Text.contains(scoreBean.getComponent8());
            }else{
                component8Validation=true;
            }
            if(scoreBean.getComponent9()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"8")));
                String component9Text = getText(By.cssSelector(componentElement(group,"8")));
                component9Validation = component9Text.contains(scoreBean.getComponent9());
            }else{
                component9Validation=true;
            }
            if(scoreBean.getComponent10()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"9")));
                String component10Text = getText(By.cssSelector(componentElement(group,"9")));
                component10Validation = component10Text.contains(scoreBean.getComponent10());
            }else{
                component10Validation=true;
            }
            if(scoreBean.getComponent11()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"10")));
                String component11Text = getText(By.cssSelector(componentElement(group,"10")));
                component11Validation = component11Text.contains(scoreBean.getComponent11());
            }else{
                component11Validation=true;
            }
            if(scoreBean.getComponent12()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"11")));
                String component12Text = getText(By.cssSelector(componentElement(group,"11")));
                component12Validation = component12Text.contains(scoreBean.getComponent12());
            }else{
                component12Validation=true;
            }
            if(scoreBean.getComponent13()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"12")));
                String component13Text = getText(By.cssSelector(componentElement(group,"12")));
                component13Validation = component13Text.contains(scoreBean.getComponent13());
            }else{
                component13Validation=true;
            }
            if(scoreBean.getComponent14()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"13")));
                String component14Text = getText(By.cssSelector(componentElement(group,"13")));
                component14Validation = component14Text.contains(scoreBean.getComponent14());
            }else{
                component14Validation=true;
            }

            if(component1Validation
                    && component2Validation
                    && component3Validation
                    && component4Validation
                    && component5Validation
                    && component6Validation
                    && component7Validation
                    && component8Validation
                    && component9Validation
                    && component10Validation
                    && component11Validation
                    && component12Validation
                    && component13Validation
                    && component14Validation){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void updateComponentScore(ScoreBean scoreBean,String group){
        int updateComponentScoreDelay=20;
        String failMessage = String.format(LogPage.UPDATE_COMPONENT_SCORE_FAIL,group);
        try {
            if(scoreBean.getComponent1Score()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(componentScoreField(group,"0")));
                scrollTo("-150");
                write(By.cssSelector(componentScoreField(group,"0")),scoreBean.getComponent1Score());
            }
            if(scoreBean.getComponent2Score()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"1")));
                waitElementBy(By.cssSelector(componentScoreField(group,"1")),updateComponentScoreDelay);
                write(By.cssSelector(componentScoreField(group,"1")),scoreBean.getComponent2Score());
            }
            if(scoreBean.getComponent3Score()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"2")));
                waitElementBy(By.cssSelector(componentScoreField(group,"2")),updateComponentScoreDelay);
                write(By.cssSelector(componentScoreField(group,"2")),scoreBean.getComponent3Score());
            }
            if(scoreBean.getComponent4Score()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"3")));
                waitElementBy(By.cssSelector(componentScoreField(group,"3")),updateComponentScoreDelay);
                write(By.cssSelector(componentScoreField(group,"3")),scoreBean.getComponent4Score());
            }
            if(scoreBean.getComponent5Score()!=""){
                wait(1000);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group,"4")));
                waitElementBy(By.cssSelector(componentScoreField(group,"4")),updateComponentScoreDelay);
                write(By.cssSelector(componentScoreField(group,"4")),scoreBean.getComponent5Score());
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateScore(ScoreBean scoreBean,String group){
        int updateScoreDelay=20;
        String passMessage = String.format(LogPage.UPDATE_SCORE_PASS,group);
        String failMessage = String.format(LogPage.UPDATE_SCORE_FAIL,group);

        try {
            scrollToElement(By.cssSelector(scorePlusSign(group)));
            if(scoreBean.getScoreType()!=""){
                waitElementBy(By.cssSelector(scoreTypeElement(group)),updateScoreDelay);
                BasePage.click(By.cssSelector(scoreTypeElement(group)));
                waitElementBy(By.xpath(SCORE_TYPE_ELEMENT_FIELD),updateScoreDelay);
                write(By.xpath(SCORE_TYPE_ELEMENT_FIELD),scoreBean.getScoreType());
                KeyPage.pressKey(By.xpath(SCORE_TYPE_ELEMENT_FIELD),"Enter");
            }
            if(scoreBean.getScore()!=""){
                waitElementBy(By.cssSelector(scoreField(group)),updateScoreDelay);
                write(By.cssSelector(scoreField(group)),scoreBean.getScore());
            }
            if(scoreBean.getScoreDate()!=""){
                waitElementBy(By.cssSelector(scoreDateField(group)),updateScoreDelay);
                KeyPage.erase(By.cssSelector(scoreDateField(group)));
                write(By.cssSelector(scoreDateField(group)),scoreBean.getScoreDate());
                KeyPage.pressKey(By.cssSelector(scoreDateField(group)),"Enter");
            }
            if(scoreBean.getSource()!=""){
                waitElementBy(By.cssSelector(sourceElement(group)),updateScoreDelay);
                BasePage.click(By.cssSelector(sourceElement(group)));
                waitElementBy(By.xpath(SCORE_TYPE_ELEMENT_FIELD),updateScoreDelay);
                write(By.xpath(SCORE_TYPE_ELEMENT_FIELD),scoreBean.getSource());
                KeyPage.pressKey(By.xpath(SCORE_TYPE_ELEMENT_FIELD),"Enter");
            }
            if(scoreBean.getComments()!=""){
                waitElementBy(By.cssSelector(scoreCommentsField(group)),updateScoreDelay);
                write(By.cssSelector(scoreCommentsField(group)),scoreBean.getComments());
            }
            updateComponentScore(scoreBean,group);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
