package pages.records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;
import pages.PersonPage;
public class StudentStatusPage extends BasePage {

    private static final String STUDENT_STATUS_SAVE_CHANGES_BUTTON = "saveChangesBtnPersonStatus";
    private static final String COUNSELOR_HISTORY_DATE_ASSIGNED_TABLE = "//*[@class='table']";

    private static String statusPlusSignElement(String index){
        return String.format("#person_student_status_%s_add",index);
    }
    private static String categoryElement(String index){
        return String.format("#s2id_person_student_status_%s_student_status_category",index);
    }
    private static String statusElement(String index){
        return String.format("#s2id_person_student_status_%s_student_status",index);
    }
    private static String statusDateField(String index){
        return String.format("#person_student_status_%s_student_status_date",index);
    }
    private static String entryTermElement(String index){
        return String.format("#s2id_person_student_status_%s_status_entry_term",index);
    }
    private static String statusCommentsField(String index){
        return String.format("#person_student_status_%s_student_status_comments",index);
    }
    private static String statusActiveCheckbox(String index){
        return String.format("#person_student_status_%s_active",index);
    }
    private static String statusPrimaryCheckbox(String index){
        return String.format("#person_student_status_%s_primary",index);
    }

    public static void clickStudentStatusPrimaryCheckbox(String index){
        String errorMessage = String.format(LogPage.CLICK_STUDENT_STATUS_PRIMARY_CHECKBOX_FAIl, index);
        String passMessage = String.format(LogPage.CLICK_STUDENT_STATUS_PRIMARY_CHECKBOX_PASS, index);
        try {
            scrollToElement(By.cssSelector(statusPlusSignElement(index)));
            waitUntilElementPresence(By.cssSelector(statusPrimaryCheckbox(index)),20);
            BasePage.click(By.cssSelector(statusPrimaryCheckbox(index)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
    /*
     * Method to click on student status active checkbox using index
     */
    public static void clickStudentStatusActiveCheckbox(String index){
        String errorMessage = String.format(LogPage.CLICK_STUDENT_STATUS_ACTIVE_CHECKBOX_FAIL, index);
        String passMessage = String.format(LogPage.CLICK_STUDENT_STATUS_ACTIVE_CHECKBOX_PASS, index);
        try {
            scrollToElement(By.cssSelector(statusPlusSignElement(index)));
            waitUntilElementPresence(By.cssSelector(statusActiveCheckbox(index)),20);
            BasePage.click(By.cssSelector(statusActiveCheckbox(index)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    public static void updateStudentStatus(String index, int person){
        String errorMessage = String.format(LogPage.UPDATE_STUDENT_STATUS_FAIL, index,person);
        String passMessage = String.format(LogPage.UPDATE_STUDENT_STATUS_PASS, index,person);

        try {
            if (mass.get(person).get("StudentStatusCategory") != null) {
                MainPage.clickOptionList(By.cssSelector(categoryElement(index)),
                                    mass.get(person).get("StudentStatusCategory"),
                                    By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (mass.get(person).get("StudentStatus") != null) {
                MainPage.clickOptionList(By.cssSelector(statusElement(index)),
                        mass.get(person).get("StudentStatus"),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (mass.get(person).get("StudentStatusDate") != null) {
                MainPage.fillDateField(By.cssSelector(statusDateField(index)),mass.get(person).get("StudentStatusDate"));
            }
            if (mass.get(person).get("EntryTerm") != null) {
                MainPage.clickOptionList(By.cssSelector(entryTermElement(index)),
                        mass.get(person).get("EntryTerm"),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (mass.get(person).get("Comments") != null) {
                MainPage.fillField(By.cssSelector(statusCommentsField(index)),mass.get(person).get("Comments"));
            }
            if (mass.get(person).get("Active") != null) {
                MainPage.clickOption(By.cssSelector(statusActiveCheckbox(index)));
            }
            if (mass.get(person).get("Primary") != null) {
                MainPage.clickOption(By.cssSelector(statusPrimaryCheckbox(index)));
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    public static void clickSaveChangesStudentStatus(){
        try {
            scrollToElement(By.xpath(COUNSELOR_HISTORY_DATE_ASSIGNED_TABLE));
            waitUntilElementToBeSelected(By.id(STUDENT_STATUS_SAVE_CHANGES_BUTTON),20);
            BasePage.click(By.id(STUDENT_STATUS_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_SAVE_CHANGES_STUDENT_STATUS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_SAVE_CHANGES_STUDENT_STATUS_FAIL);
        }
    }

    public static void clickOnAddStudentStatus(String index){
        try {
            waitElementBy(By.cssSelector(statusPlusSignElement(index)),20);
            BasePage.click(By.cssSelector(statusPlusSignElement(index)));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_ON_ADD_STUDENT_STATUS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_ON_ADD_STUDENT_STATUS_FAIL);
        }
    }

    public static void verifyStudentStatus(String studentStatus, int person){
        String errorMessage = String.format(LogPage.VERIFY_STUDENT_STATUS_FAIL, studentStatus,person);
        String passMessage = String.format(LogPage.VERIFY_STUDENT_STATUS_PASS, studentStatus,person);
        try {
            if(MainPage.verifyGetText(By.cssSelector(categoryElement(studentStatus)),mass.get(person).get("StudentStatusCategory"))
            && MainPage.verifyGetText(By.cssSelector(statusElement(studentStatus)),mass.get(person).get("StudentStatus"))
            && MainPage.verifyGetAttribute(By.cssSelector(statusDateField(studentStatus)),mass.get(person).get("StudentStatusDate"))
            && MainPage.verifyGetText(By.cssSelector(entryTermElement(studentStatus)),mass.get(person).get("EntryTerm"))
            && MainPage.verifyGetText(By.cssSelector(statusCommentsField(studentStatus)),mass.get(person).get("StudentComments"))
            && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(statusActiveCheckbox(studentStatus)),mass.get(person).get("Active"))
            && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(statusPrimaryCheckbox(studentStatus)),mass.get(person).get("Primary"))
            ){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
}
