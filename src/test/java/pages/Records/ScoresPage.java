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
    private static String scoreComponentPlusSign(String index){
        return String.format("#person_score_0_person_score_component_%s_add",index);
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
    private static String componentElement(String index){
        return String.format("#s2id_person_score_0_person_score_component_%s_score_component",index);
    }
    private static String componentScoreField(String index){
        return String.format("#person_score_0_person_score_component_%s_score_component_score",index);
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
        int groupPlusOne;
        String groupSum;
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
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group)));
                String component1Text = getText(By.cssSelector(componentElement(group)));
                component1Validation = component1Text.contains(scoreBean.getComponent1());
            }else{
                component1Validation=true;
            }
            if(scoreBean.getComponent1Score()!=""){
                scrollToElement(By.cssSelector(scoreComponentPlusSign(group)));
                String componentScore1Text = getAtribute(By.cssSelector(componentScoreField(group)),"value");
                componentScore1Validation = componentScore1Text.contains(scoreBean.getComponent1Score());
            }else{
                componentScore1Validation=true;
            }
            if(scoreBean.getComponent2()!=""){
                groupPlusOne = Integer.parseInt(group) + Integer.parseInt("1");
                groupSum = String.valueOf(groupPlusOne);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(groupSum)));
                String component2Text = getText(By.cssSelector(componentElement(groupSum)));
                component2Validation = component2Text.contains(scoreBean.getComponent2());
            }else{
                component2Validation=true;
            }
            if(scoreBean.getComponent2Score()!=""){
                groupPlusOne = Integer.parseInt(group) + Integer.parseInt("1");
                groupSum = String.valueOf(groupPlusOne);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(groupSum)));
                String componentScore2Text = getAtribute(By.cssSelector(componentScoreField(groupSum)),"value");
                componentScore2Validation = componentScore2Text.contains(scoreBean.getComponent2Score());
            }else{
                componentScore2Validation=true;
            }
            if(scoreBean.getComponent3()!=""){
                groupPlusOne = Integer.parseInt(group) + Integer.parseInt("2");
                groupSum = String.valueOf(groupPlusOne);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(groupSum)));
                String component3Text = getText(By.cssSelector(componentElement(groupSum)));
                component3Validation = component3Text.contains(scoreBean.getComponent3());
            }else{
                component3Validation=true;
            }
            if(scoreBean.getComponent3Score()!=""){
                groupPlusOne = Integer.parseInt(group) + Integer.parseInt("2");
                groupSum = String.valueOf(groupPlusOne);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(groupSum)));
                String componentScore3Text = getAtribute(By.cssSelector(componentScoreField(groupSum)),"value");
                componentScore3Validation = componentScore3Text.contains(scoreBean.getComponent3Score());
            }else{
                componentScore3Validation=true;
            }
            if(scoreBean.getComponent4()!=""){
                groupPlusOne = Integer.parseInt(group) + Integer.parseInt("3");
                groupSum = String.valueOf(groupPlusOne);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(groupSum)));
                String component4Text = getText(By.cssSelector(componentElement(groupSum)));
                component4Validation = component4Text.contains(scoreBean.getComponent4());
            }else{
                component4Validation=true;
            }
            if(scoreBean.getComponent4Score()!=""){
                groupPlusOne = Integer.parseInt(group) + Integer.parseInt("3");
                groupSum = String.valueOf(groupPlusOne);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(groupSum)));
                String componentScore4Text = getAtribute(By.cssSelector(componentScoreField(groupSum)),"value");
                componentScore4Validation = componentScore4Text.contains(scoreBean.getComponent4Score());
            }else{
                componentScore4Validation=true;
            }
            if(scoreBean.getComponent5()!=""){
                groupPlusOne = Integer.parseInt(group) + Integer.parseInt("4");
                groupSum = String.valueOf(groupPlusOne);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(groupSum)));
                String component5Text = getText(By.cssSelector(componentElement(groupSum)));
                component5Validation = component5Text.contains(scoreBean.getComponent5());
            }else{
                component5Validation=true;
            }
            if(scoreBean.getComponent5Score()!=""){
                groupPlusOne = Integer.parseInt(group) + Integer.parseInt("4");
                groupSum = String.valueOf(groupPlusOne);
                scrollToElement(By.cssSelector(scoreComponentPlusSign(groupSum)));
                String componentScore5Text = getAtribute(By.cssSelector(componentScoreField(groupSum)),"value");
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

    public static void updateComponentScore(ScoreBean scoreBean,String group){
        int updateComponentScoreDelay=20;
        String failMessage = String.format(LogPage.UPDATE_COMPONENT_SCORE_FAIL,group);
        int groupPlusOne;
        String groupSum;

        try {
            if(scoreBean.getComponent1Score()!=""){
                waitElementBy(By.cssSelector(componentScoreField(group)),updateComponentScoreDelay);
                scrollToElement(By.cssSelector(componentScoreField(group)));
                scrollTo("-150");
                write(By.cssSelector(componentScoreField(group)),scoreBean.getComponent1Score());
            }
            if(scoreBean.getComponent2Score()!=""){
                groupPlusOne =  Integer.parseInt(group) + Integer.parseInt("1");
                groupSum = String.valueOf(groupPlusOne);
                scrollToElement(By.cssSelector(componentScoreField(groupSum)));
                scrollTo("-150");
                waitElementBy(By.cssSelector(componentScoreField(groupSum)),updateComponentScoreDelay);
                write(By.cssSelector(componentScoreField(groupSum)),scoreBean.getComponent2Score());
            }
            if(scoreBean.getComponent3Score()!=""){
                groupPlusOne =  Integer.parseInt(group) + Integer.parseInt("2");
                groupSum = String.valueOf(groupPlusOne);
                scrollToElement(By.cssSelector(componentScoreField(groupSum)));
                scrollTo("-150");
                waitElementBy(By.cssSelector(componentScoreField(groupSum)),updateComponentScoreDelay);
                write(By.cssSelector(componentScoreField(groupSum)),scoreBean.getComponent3Score());
            }
            if(scoreBean.getComponent4Score()!=""){
                groupPlusOne =  Integer.parseInt(group) + Integer.parseInt("3");
                groupSum = String.valueOf(groupPlusOne);
                scrollToElement(By.cssSelector(componentScoreField(groupSum)));
                scrollTo("-150");
                waitElementBy(By.cssSelector(componentScoreField(groupSum)),updateComponentScoreDelay);
                write(By.cssSelector(componentScoreField(groupSum)),scoreBean.getComponent4Score());
            }
            if(scoreBean.getComponent5Score()!=""){
                groupPlusOne =  Integer.parseInt(group) + Integer.parseInt("4");
                groupSum = String.valueOf(groupPlusOne);
                scrollToElement(By.cssSelector(componentScoreField(groupSum)));
                scrollTo("-150");
                waitElementBy(By.cssSelector(componentScoreField(groupSum)),updateComponentScoreDelay);
                write(By.cssSelector(componentScoreField(groupSum)),scoreBean.getComponent4Score());
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
