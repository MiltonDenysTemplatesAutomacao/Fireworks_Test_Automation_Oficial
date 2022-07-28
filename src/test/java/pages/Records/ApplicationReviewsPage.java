package pages.Records;

import bean.ApplicationReviewBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.*;

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
    public static void updateApplicationReview(ApplicationReviewBean applicationReviewBean, String application, String review){
        String passMessage = String.format(LogPage.UPDATE_APPLICATION_REVIEW_PASS,application,review);
        String failMessage = String.format(LogPage.UPDATE_APPLICATION_REVIEW_FAIL,application,review);
        int updateApplicationReviewDelay=10;
        try {
            if(applicationReviewBean.getReviewFactor()!=""){
                scrollToElement(By.cssSelector(reviewAddButton(application,review)));
                waitElementBy(By.cssSelector(reviewFactorElement(application,review)),updateApplicationReviewDelay);
                BasePage.click(By.cssSelector(reviewFactorElement(application,review)));
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(applicationReviewBean.getReviewFactor());
            }
            if(applicationReviewBean.getRating()!=""){
                scrollToElement(By.cssSelector(reviewAddButton(application,review)));
                waitElementBy(By.cssSelector(reviewRatingElement(application,review)),updateApplicationReviewDelay);
                BasePage.click(By.cssSelector(reviewRatingElement(application,review)));
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(applicationReviewBean.getRating());
            }
            if(applicationReviewBean.getReader()!=""){
                scrollToElement(By.cssSelector(reviewAddButton(application,review)));
                waitElementBy(By.cssSelector(reviewReaderElement(application,review)),updateApplicationReviewDelay);
                BasePage.click(By.cssSelector(reviewReaderElement(application,review)));
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(applicationReviewBean.getReader());
            }
            if(applicationReviewBean.getReviewDate()!=""){
                String campusTimeZoneDate = currentDateTimeWithoutHour();
                waitElementBy(By.cssSelector(reviewAddButton(application,review)),updateApplicationReviewDelay);
                scrollToElement(By.cssSelector(reviewAddButton(application,review)));
                waitElementBy(By.cssSelector(reviewDateField(application,review)),updateApplicationReviewDelay);
                KeyPage.erase(By.cssSelector(reviewDateField(application,review)));
                wait(1000);
                BasePage.write(By.cssSelector(reviewDateField(application,review)),campusTimeZoneDate);
                wait(1000);
                KeyPage.pressKey(By.cssSelector(reviewDateField(application,review)), "Enter");
            }
            if(applicationReviewBean.getComments()!=""){
                scrollToElement(By.cssSelector(reviewAddButton(application,review)));
                waitElementBy(By.cssSelector(reviewCommentsField(application,review)),updateApplicationReviewDelay);
                BasePage.write(By.cssSelector(reviewCommentsField(application,review)),applicationReviewBean.getComments());
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
            scrollToElement(By.cssSelector(reviewAddButton(app,review)));
            scrollTo("-150");
            waitUntilElementToBeSelected(By.cssSelector(reviewAddButton(app,review)),10);
            click(By.cssSelector(reviewAddButton(app,review)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
