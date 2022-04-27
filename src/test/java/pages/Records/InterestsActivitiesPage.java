package pages.Records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

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
        boolean interestCategoryValidation = false;
        boolean interestNameValidation = false;
        boolean interestWhoAddedValidation = false;
        boolean interestDateAddedValidation = false;
        boolean interestSourceValidation = false;
        boolean interestCommentsValidation = false;

        String errorMessage = String.format(LogPage.VERIFY_INTERESTS_FAIL, index,person);
        String passMessage = String.format(LogPage.VERIFY_INTERESTS_PASS, index,person);

        try {
            if (mass.get(person).get("InterestCategory") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                String category = getText(By.id(interestCategory(index)));
                interestCategoryValidation = category.contains(mass.get(person).get("InterestCategory"));
            }else{
                interestCategoryValidation = true;
            }
            if (mass.get(person).get("InterestName") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                String interestName = getText(By.id(interestName(index)));
                interestNameValidation = interestName.contains(mass.get(person).get("InterestName"));
            }else{
                interestNameValidation = true;
            }
            if (mass.get(person).get("InterestWhoAdded") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                String interestWhoAdded = getText(By.id(interestWhoAdded(index)));
                interestWhoAddedValidation = interestWhoAdded.contains(mass.get(person).get("InterestWhoAdded"));
            }else{
                interestWhoAddedValidation = true;
            }
            if (mass.get(person).get("InterestDateAdded") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                String interestDateAdded = getAtribute(By.id(interestDateAdded(index)),"value");
                interestDateAddedValidation = interestDateAdded.contains(mass.get(person).get("InterestDateAdded"));
            }else{
                interestDateAddedValidation = true;
            }
            if (mass.get(person).get("InterestSource") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                String interestSource = getText(By.id(interestSource(index)));
                interestSourceValidation = interestSource.contains(mass.get(person).get("InterestSource"));
            }else{
                interestSourceValidation = true;
            }
            if (mass.get(person).get("InterestComments") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                String interestComments = getText(By.id(interestComments(index)));
                interestCommentsValidation = interestComments.contains(mass.get(person).get("InterestComments"));
            }else{
                interestCommentsValidation = true;
            }

            if(interestCategoryValidation
                    && interestNameValidation
                    && interestWhoAddedValidation
                    && interestDateAddedValidation
                    && interestSourceValidation
                    && interestCommentsValidation
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
     * Method to verify activities
     */
    public static void verifyActivities(String index, int person){
        boolean activityCategoryValidation = false;
        boolean activityNameValidation = false;
        boolean activityWhoAddedValidation = false;
        boolean activityDateAddedValidation = false;
        boolean activitySourceValidation = false;
        boolean activityParticipateValidation = false;
        boolean activityCommentsValidation = false;

        String errorMessage = String.format(LogPage.VERIFY_ACTIVITIES_FAIL, index,person);
        String passMessage = String.format(LogPage.VERIFY_ACTIVITIES_PASS, index,person);

        try {
            if (mass.get(person).get("ActivityCategory") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                String category = getText(By.id(interestCategory(index)));
                activityCategoryValidation = category.contains(mass.get(person).get("ActivityCategory"));
            }else{
                activityCategoryValidation = true;
            }
            if (mass.get(person).get("ActivityName") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                String activityName = getText(By.id(activityName(index)));
                activityNameValidation = activityName.contains(mass.get(person).get("ActivityName"));
            }else{
                activityNameValidation = true;
            }
            if (mass.get(person).get("ActivityWhoAdded") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                String activityWhoAdded = getText(By.id(activityWhoAdded(index)));
                activityWhoAddedValidation = activityWhoAdded.contains(mass.get(person).get("ActivityWhoAdded"));
            }else{
                activityWhoAddedValidation = true;
            }
            if (mass.get(person).get("ActivityDateAdded") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                String activityDateAdded = getAtribute(By.id(activityDateAdded(index)),"value");
                activityDateAddedValidation = activityDateAdded.contains(mass.get(person).get("ActivityDateAdded"));
            }else{
                activityDateAddedValidation = true;
            }
            if (mass.get(person).get("ActivitySource") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                String activitySource = getText(By.id(activitiesSource(index)));
                activitySourceValidation = activitySource.contains(mass.get(person).get("ActivitySource"));
            }else{
                activitySourceValidation = true;
            }
            if (mass.get(person).get("ActivityComments") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                String activityComments = getText(By.id(activityComments(index)));
                activityCommentsValidation = activityComments.contains(mass.get(person).get("ActivityComments"));
            }else{
                activityCommentsValidation = true;
            }
            if (mass.get(person).get("ActivityParticipate") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                String activityParticipate = getText(By.id(activityParticipate(index)));
                activityParticipateValidation = activityParticipate.contains(mass.get(person).get("ActivityParticipate"));
            }else{
                activityParticipateValidation = true;
            }

            if(activityCategoryValidation
                    && activityNameValidation
                    && activityWhoAddedValidation
                    && activityDateAddedValidation
                    && activitySourceValidation
                    && activityCommentsValidation
                    && activityParticipateValidation
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
                scrollToElement(By.id(activitiesPlusSign(index)));
                waitUntilElementToBeSelected(By.id(activityCategory(index)), 20);
                BasePage.click(By.id(activityCategory(index)));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(person).get("ActivityCategory"));
            }
            if (mass.get(person).get("ActivityName") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                waitUntilElementToBeSelected(By.id(activityName(index)), 20);
                BasePage.click(By.id(activityName(index)));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(person).get("ActivityName"));
            }
            if (mass.get(person).get("ActivityWhoAdded") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                waitUntilElementToBeSelected(By.id(activityWhoAdded(index)), 20);
                BasePage.click(By.id(activityWhoAdded(index)));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(person).get("ActivityWhoAdded"));
            }
            if (mass.get(person).get("ActivityDateAdded") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                waitUntilElementToBeSelected(By.id(activityDateAdded(index)), 20);
                BasePage.click(By.id(activityDateAdded(index)));
                BasePage.write(By.id(activityDateAdded(index)),mass.get(person).get("ActivityDateAdded"));
            }
            if (mass.get(person).get("ActivitySource") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                waitUntilElementToBeSelected(By.id(activitiesSource(index)), 20);
                BasePage.click(By.id(activitiesSource(index)));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(person).get("ActivitySource"));
            }
            if (mass.get(person).get("ActivityParticipate") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                waitUntilElementToBeSelected(By.id(activityParticipate(index)), 20);
                BasePage.click(By.id(activityParticipate(index)));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(person).get("ActivityParticipate"));
            }
            if (mass.get(person).get("ActivityComments") != null) {
                scrollToElement(By.id(activitiesPlusSign(index)));
                waitUntilElementToBeSelected(By.id(activityComments(index)), 20);
                BasePage.click(By.id(activityComments(index)));
                BasePage.write(By.id(activityComments(index)),mass.get(person).get("ActivityComments"));
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
                scrollToElement(By.id(interestPlusSign(index)));
                waitUntilElementToBeSelected(By.id(interestCategory(index)), 20);
                BasePage.click(By.id(interestCategory(index)));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(person).get("InterestCategory"));
            }
            if (mass.get(person).get("InterestName") != null) {
                scrollToElement(By.id(interestPlusSign(index)));
                waitUntilElementToBeSelected(By.id(interestName(index)), 20);
                BasePage.click(By.id(interestName(index)));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(person).get("InterestName"));
            }
            if (mass.get(person).get("InterestWhoAdded") != null) {
                scrollToElement(By.id(interestPlusSign(index)));
                waitUntilElementToBeSelected(By.id(interestWhoAdded(index)), 20);
                BasePage.click(By.id(interestWhoAdded(index)));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(person).get("InterestWhoAdded"));
            }
            if (mass.get(person).get("InterestDateAdded") != null) {
                scrollToElement(By.id(interestPlusSign(index)));
                waitUntilElementToBeSelected(By.id(interestDateAdded(index)), 20);
                BasePage.click(By.id(interestDateAdded(index)));
                BasePage.write(By.id(interestDateAdded(index)),mass.get(person).get("InterestDateAdded"));
            }
            if (mass.get(person).get("InterestSource") != null) {
                scrollToElement(By.id(interestPlusSign(index)));
                waitUntilElementToBeSelected(By.id(interestSource(index)), 20);
                BasePage.click(By.id(interestSource(index)));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(person).get("InterestSource"));
            }
            if (mass.get(person).get("InterestComments") != null) {
                scrollToElement(By.id(interestPlusSign(index)));
                waitUntilElementToBeSelected(By.id(interestComments(index)), 20);
                BasePage.click(By.id(interestComments(index)));
                BasePage.write(By.id(interestComments(index)),mass.get(person).get("InterestComments"));
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
