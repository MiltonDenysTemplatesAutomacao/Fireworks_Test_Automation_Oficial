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
                write(By.cssSelector(scoreCommentsField(group)),scoreBean.getScoreDate());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
