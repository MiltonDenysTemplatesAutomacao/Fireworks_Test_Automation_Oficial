package pages.records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.*;

public class InterestsActivitiesPage extends BasePage {

    private static final String INTERESTS_ACTIVITIES_SAVE_CHANGES_BUTTON = "saveChangesBtnPersonInterests";

    private static String interestPlusSign(String index) {
        return String.format("person_interest_%s_add", index);
    }
    private static String activitiesPlusSign(String index) {
        return String.format("person_activity_%s_add", index);
    }
    private static String interestCategory(String index) {
        return String.format("s2id_person_interest_%s_interest_category", index);
    }
    private static String interestName(String index) {
        return String.format("s2id_person_interest_%s_interest", index);
    }
    private static String interestWhoAdded(String index) {
        return String.format("s2id_person_interest_%s_interest_who", index);
    }
    private static String interestDateAdded(String index) {
        return String.format("person_interest_%s_interest_date", index);
    }
    private static String interestSource(String index) {
        return String.format("s2id_person_interest_%s_interest_source", index);
    }
    private static String interestComments(String index) {
        return String.format("person_interest_%s_interest_comment", index);
    }
    private static String activityCategory(String index) {
        return String.format("s2id_person_activity_%s_activity_type", index);
    }
    private static String activityName(String index) {
        return String.format("s2id_person_activity_%s_activity_name", index);
    }
    private static String activityWhoAdded(String index) {
        return String.format("s2id_person_activity_%s_activity_who_added", index);
    }
    private static String activityDateAdded(String index) {
        return String.format("person_activity_%s_activity_date_added", index);
    }
    private static String activitiesSource(String index) {
        return String.format("s2id_person_activity_%s_activity_source", index);
    }
    private static String activityParticipate(String index) {
        return String.format("s2id_person_activity_%s_activity_participate_college", index);
    }
    private static String activityComments(String index) {
        return String.format("person_activity_%s_activity_comments", index);
    }

    /*
     * Method to verify interests
     */
    public static void verifyInterests(String index, int person){

        String errorMessage = String.format(LogPage.VERIFY_INTERESTS_FAIL, index,person);
        String passMessage = String.format(LogPage.VERIFY_INTERESTS_PASS, index,person);

        try {
            if(MainPage.verifyGetText(By.id(interestCategory(index)),mass.get(person).get("InterestCategory"))
                && MainPage.verifyGetText(By.id(interestName(index)),mass.get(person).get("InterestName"))
                && MainPage.verifyGetText(By.id(interestWhoAdded(index)),mass.get(person).get("InterestWhoAdded"))
                && MainPage.verifyGetAttribute(By.id(interestDateAdded(index)),mass.get(person).get("InterestDateAdded"))
                && MainPage.verifyGetText(By.id(interestSource(index)),mass.get(person).get("InterestSource"))
                && MainPage.verifyGetText(By.id(interestComments(index)),mass.get(person).get("InterestComments"))){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
    /*
     * Method to verify activities
     */
    public static void verifyActivities(String index, int person){
        String errorMessage = String.format(LogPage.VERIFY_ACTIVITIES_FAIL, index,person);
        String passMessage = String.format(LogPage.VERIFY_ACTIVITIES_PASS, index,person);

        try {
            if(MainPage.verifyGetText(By.id(activityCategory(index)),mass.get(person).get("ActivityCategory"))
                    && MainPage.verifyGetText(By.id(activityName(index)),mass.get(person).get("ActivityName"))
                    && MainPage.verifyGetText(By.id(activityWhoAdded(index)),mass.get(person).get("ActivityWhoAdded"))
                    && MainPage.verifyGetAttribute(By.id(activityDateAdded(index)),mass.get(person).get("ActivityDateAdded"))
                    && MainPage.verifyGetText(By.id(activitiesSource(index)),mass.get(person).get("ActivitySource"))
                    && MainPage.verifyGetText(By.id(activityComments(index)),mass.get(person).get("ActivityComments"))
                    && MainPage.verifyGetText(By.id(activityParticipate(index)),mass.get(person).get("ActivityParticipate"))
            ){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }


    /*
     * Method to update Activities
     */
    public static void updateActivities(String index, int person) {
        String errorMessage = String.format(LogPage.UPDATE_ACTIVITIES_FAIL, index, person);
        String passMessage = String.format(LogPage.UPDATE_ACTIVITIES_PASS, index, person);

        try {
            if (mass.get(person).get("ActivityCategory") != null) {
                MainPage.clickOptionList(By.id(activityCategory(index)),
                        mass.get(person).get("ActivityCategory"),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if (mass.get(person).get("ActivityName") != null) {
                MainPage.clickOptionList(By.id(activityName(index)),
                        mass.get(person).get("ActivityName"),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if (mass.get(person).get("ActivityWhoAdded") != null) {
                MainPage.clickOptionList(By.id(activityWhoAdded(index)),
                        mass.get(person).get("ActivityWhoAdded"),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if (mass.get(person).get("ActivityDateAdded") != null) {
                MainPage.fillDateField(By.id(activityDateAdded(index)),mass.get(person).get("ActivityDateAdded"));
            }
            if (mass.get(person).get("ActivitySource") != null) {
                MainPage.clickOptionList(By.id(activitiesSource(index)),
                        mass.get(person).get("ActivitySource"),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if (mass.get(person).get("ActivityParticipate") != null) {
                MainPage.clickOptionList(By.id(activityParticipate(index)),
                        mass.get(person).get("ActivityParticipate"),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if (mass.get(person).get("ActivityComments") != null) {
                MainPage.fillField(By.id(activityComments(index)),mass.get(person).get("ActivityComments"));
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
    /*
     * Method to update Interests
     */
    public static void updateInterest(String index, int person) {
        String errorMessage = String.format(LogPage.UPDATE_INTEREST_FAIL, index, person);
        String passMessage = String.format(LogPage.UPDATE_INTEREST_PASS, index, person);
        try {
            if (mass.get(person).get("InterestCategory") != null) {
                MainPage.clickOptionList(By.id(interestCategory(index)),
                        mass.get(person).get("InterestCategory"),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if (mass.get(person).get("InterestName") != null) {
                MainPage.clickOptionList(By.id(interestName(index)),
                        mass.get(person).get("InterestName"),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if (mass.get(person).get("InterestWhoAdded") != null) {
                MainPage.clickOptionList(By.id(interestWhoAdded(index)),
                        mass.get(person).get("InterestWhoAdded"),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if (mass.get(person).get("InterestDateAdded") != null) {
                MainPage.fillField(By.id(interestDateAdded(index)), mass.get(person).get("InterestDateAdded"));
            }
            if (mass.get(person).get("InterestSource") != null) {
                MainPage.clickOptionList(By.id(interestSource(index)),
                        mass.get(person).get("InterestSource"),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if (mass.get(person).get("InterestComments") != null) {
                MainPage.fillField(By.id(interestComments(index)), mass.get(person).get("InterestComments"));
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    /*
     * Method to click on save changes for interests & activities
     */
    public static void clickSaveChangesInterestsActivities(){
        try {
            scrollToElement(By.id(INTERESTS_ACTIVITIES_SAVE_CHANGES_BUTTON));
            waitUntilElementToBeSelected(By.id(INTERESTS_ACTIVITIES_SAVE_CHANGES_BUTTON),20);
            BasePage.click(By.id(INTERESTS_ACTIVITIES_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_SAVE_CHANGES_INTERESTS_ACTIVITIES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_SAVE_CHANGES_INTERESTS_ACTIVITIES_FAIL);
        }
    }
}
