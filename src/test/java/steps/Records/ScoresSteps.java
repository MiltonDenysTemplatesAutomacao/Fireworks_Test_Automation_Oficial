package steps.Records;

import bean.ScoreBean;
import io.cucumber.java.en.And;
import pages.Records.ScoresPage;

public class ScoresSteps {


    @And("I update score on Education for person {string}, {string}, {string}, {string}, {string} group {string}")
    public static void updateScore(String scoreType, String score, String scoreDate, String source, String comments, String group) {
        ScoreBean scoreBean = new ScoreBean();
        scoreBean.setScoreType(scoreType);
        scoreBean.setScore(score);
        scoreBean.setScoreDate(scoreDate);
        scoreBean.setSource(source);
        scoreBean.setComments(comments);
        ScoresPage.updateScore(scoreBean,group);
    }
}
