package steps.records.application;

import bean.ApplicationReviewBean;
import io.cucumber.java.en.And;
import pages.records.application.ApplicationReviewsPage;

public class ApplicationReviewSteps {

    @And("I add a review {string} app {string}")
    public static void addReview(String app,String review){
        ApplicationReviewsPage.addReview(app,review);
    }
    @And("I update application review {string}, {string}, {string}, {string}, {string} application {string} review {string}")
    public static void updateApplicationReview(String reviewFactor, String rating,String reader,String reviewDate,String comments,String application,String review){
        ApplicationReviewBean applicationReviewBean = new ApplicationReviewBean();
        applicationReviewBean.setReviewFactor(reviewFactor);
        applicationReviewBean.setRating(rating);
        applicationReviewBean.setReader(reader);
        applicationReviewBean.setReviewDate(reviewDate);
        applicationReviewBean.setComments(comments);
        ApplicationReviewsPage.updateApplicationReview(applicationReviewBean,application,review);
    }
    @And("I verify application review {string}, {string}, {string}, {string}, {string} application {string} review {string}")
    public static void verifyApplicationReview(String reviewFactor, String rating,String reader,String reviewDate,String comments,String application,String review){
        ApplicationReviewBean applicationReviewBean = new ApplicationReviewBean();
        applicationReviewBean.setReviewFactor(reviewFactor);
        applicationReviewBean.setRating(rating);
        applicationReviewBean.setReader(reader);
        applicationReviewBean.setReviewDate(reviewDate);
        applicationReviewBean.setComments(comments);
        ApplicationReviewsPage.verifyApplicationReview(applicationReviewBean,application,review);
    }

}
