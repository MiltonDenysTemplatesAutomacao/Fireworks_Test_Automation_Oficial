package pages.records.application;

import bean.ApplicationReviewBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;
import pages.PersonPage;
public class ApplicationReviewsPage extends BasePage {

    private static String reviewAddButton(String app,String review){
        return String.format("#person_application_%s_person_application_review_%s_add",app,review);
    }
    private static String reviewFactorElement(String app,String review){
        return String.format("#s2id_person_application_%s_person_application_review_%s_application_review_factor",app,review);
    }
    private static String reviewRatingElement(String app,String review){
        return String.format("#s2id_person_application_%s_person_application_review_%s_application_review_rating",app,review);
    }
    private static String reviewReaderElement(String app,String review){
        return String.format("#s2id_person_application_%s_person_application_review_%s_application_review_reader",app,review);
    }
    private static String reviewDateField(String app,String review){
        return String.format("#person_application_%s_person_application_review_%s_application_review_date",app,review);
    }
    private static String reviewCommentsField(String app,String review){
        return String.format("#person_application_%s_person_application_review_%s_application_review_comments",app,review);
    }
    /*
     * to update Review Date it is necessary to put any string on Review Date field on step, I selected "1" as a pattern
     */
    public static void verifyApplicationReview(ApplicationReviewBean applicationReviewBean, String application, String review){

        String passMessage = String.format(LogPage.VERIFY_APPLICATION_REVIEW_PASS,application,review);
        String failMessage = String.format(LogPage.VERIFY_APPLICATION_REVIEW_FAIL,application,review);
        String campusTimeZoneDate = currentDateTimeWithoutHour();
        try {
            if(MainPage.verifyGetText(By.cssSelector(reviewFactorElement(application,review)),applicationReviewBean.getReviewFactor())
                && MainPage.verifyGetText(By.cssSelector(reviewRatingElement(application,review)),applicationReviewBean.getRating())
                && MainPage.verifyGetText(By.cssSelector(reviewReaderElement(application,review)),applicationReviewBean.getReader())
                && MainPage.verifyGetAttribute(By.cssSelector(reviewDateField(application,review)),campusTimeZoneDate)
                && MainPage.verifyGetText(By.cssSelector(reviewCommentsField(application,review)),applicationReviewBean.getComments())){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    /*
     * to update Review Date it is necessary to put any string on Review Date field on step, I selected "1" as a pattern
     */
    public static void updateApplicationReview(ApplicationReviewBean applicationReviewBean, String application, String review){
        String passMessage = String.format(LogPage.UPDATE_APPLICATION_REVIEW_PASS,application,review);
        String failMessage = String.format(LogPage.UPDATE_APPLICATION_REVIEW_FAIL,application,review);
        try {
            if(applicationReviewBean.getReviewFactor()!=""){
                MainPage.clickOptionList(By.cssSelector(reviewFactorElement(application,review)),
                        applicationReviewBean.getReviewFactor(),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(applicationReviewBean.getRating()!=""){
                MainPage.clickOptionList(By.cssSelector(reviewRatingElement(application,review)),
                        applicationReviewBean.getRating(),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(applicationReviewBean.getReader()!=""){
                MainPage.clickOptionList(By.cssSelector(reviewReaderElement(application,review)),
                        applicationReviewBean.getReader(),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(applicationReviewBean.getReviewDate()!=""){
                String campusTimeZoneDate = currentDateTimeWithoutHour();
                MainPage.fillDateField(By.cssSelector(reviewDateField(application,review)), campusTimeZoneDate);
            }
            if(applicationReviewBean.getComments()!=""){
                MainPage.fillField(By.cssSelector(reviewCommentsField(application,review)), applicationReviewBean.getComments());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void addReview(String app,String review){
        String passMessage = String.format(LogPage.ADD_REVIEW_PASS,app,review);
        String failMessage = String.format(LogPage.ADD_REVIEW_FAIL,app,review);
        try {
            MainPage.addDeleteWithPlusButton(By.cssSelector(reviewAddButton(app,review)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
