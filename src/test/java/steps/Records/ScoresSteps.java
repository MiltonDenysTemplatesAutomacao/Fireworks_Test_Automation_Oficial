package steps.Records;

import bean.ScoreBean;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.Records.ScoresPage;

public class ScoresSteps {

    @When("I add score {string}")
    public static void addScore(String group) {
        ScoresPage.addScore(group);
    }
    @And("I update score on Education for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void updateScore(String scoreType, String score, String scoreDate, String source, String comments, String componentScore1, String componentScore2, String componentScore3, String componentScore4, String componentScore5, String group) {
        ScoreBean scoreBean = new ScoreBean();
        scoreBean.setScoreType(scoreType);
        scoreBean.setScore(score);
        scoreBean.setScoreDate(scoreDate);
        scoreBean.setSource(source);
        scoreBean.setComments(comments);
        scoreBean.setComponent1Score(componentScore1);
        scoreBean.setComponent2Score(componentScore2);
        scoreBean.setComponent3Score(componentScore3);
        scoreBean.setComponent4Score(componentScore4);
        scoreBean.setComponent5Score(componentScore5);
        ScoresPage.updateScore(scoreBean,group);
    }
    @And("I verify score on Education for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void verifyScore(String scoreType, String score, String scoreDate, String source, String oficial,String comments, String component1, String componentScore1, String component2, String componentScore2, String component3, String componentScore3, String component4, String componentScore4, String component5, String componentScore5, String group) {
        ScoreBean scoreBean = new ScoreBean();
        scoreBean.setScoreType(scoreType);
        scoreBean.setScore(score);
        scoreBean.setScoreDate(scoreDate);
        scoreBean.setSource(source);
        scoreBean.setOfficial(oficial);
        scoreBean.setComments(comments);
        scoreBean.setComponent1(component1);
        scoreBean.setComponent1Score(componentScore1);
        scoreBean.setComponent2(component2);
        scoreBean.setComponent2Score(componentScore2);
        scoreBean.setComponent3(component3);
        scoreBean.setComponent3Score(componentScore3);
        scoreBean.setComponent4(component4);
        scoreBean.setComponent4Score(componentScore4);
        scoreBean.setComponent5(component5);
        scoreBean.setComponent5Score(componentScore5);
        ScoresPage.verifyScore(scoreBean,group);
    }
}
