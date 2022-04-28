package pages.Records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class StudentStatusPage extends BasePage {

    public static final String CHECKBOX_LIST = "#select2-drop";
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
                scrollToElement(By.cssSelector(statusPlusSignElement(index)));
                waitUntilElementToBeSelected(By.cssSelector(categoryElement(index)),20);
                BasePage.click(By.cssSelector(categoryElement(index)));
                BasePage.selectElementsList(By.cssSelector(CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(person).get("StudentStatusCategory"));
            }
            if (mass.get(person).get("StudentStatus") != null) {
                scrollToElement(By.cssSelector(statusPlusSignElement(index)));
                waitUntilElementToBeSelected(By.cssSelector(statusElement(index)),20);
                BasePage.click(By.cssSelector(statusElement(index)));
                BasePage.selectElementsList(By.cssSelector(CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(person).get("StudentStatus"));
            }
            if (mass.get(person).get("StudentStatusDate") != null) {
                scrollToElement(By.cssSelector(statusElement(index)));
                waitUntilElementToBeSelected(By.cssSelector(statusDateField(index)),20);
                BasePage.click(By.cssSelector(statusDateField(index)));
                BasePage.write(By.cssSelector(statusDateField(index)),mass.get(person).get("StudentStatusDate"));
            }
            if (mass.get(person).get("EntryTerm") != null) {
                scrollToElement(By.cssSelector(statusElement(index)));
                waitUntilElementToBeSelected(By.cssSelector(entryTermElement(index)),20);
                BasePage.click(By.cssSelector(entryTermElement(index)));
                BasePage.selectElementsList(By.cssSelector(CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(person).get("EntryTerm"));
            }
            if (mass.get(person).get("Comments") != null) {
                scrollToElement(By.cssSelector(entryTermElement(index)));
                waitUntilElementToBeSelected(By.cssSelector(statusCommentsField(index)),20);
                BasePage.write(By.cssSelector(statusCommentsField(index)),mass.get(person).get("Comments"));
            }
            if (mass.get(person).get("Active") != null) {
                scrollToElement(By.cssSelector(statusPlusSignElement(index)));
                waitUntilElementPresence(By.cssSelector(statusActiveCheckbox(index)),20);
                BasePage.click(By.cssSelector(statusActiveCheckbox(index)));
            }
            if (mass.get(person).get("Primary") != null) {
                scrollToElement(By.cssSelector(statusPlusSignElement(index)));
                waitUntilElementPresence(By.cssSelector(statusPrimaryCheckbox(index)),20);
                BasePage.click(By.cssSelector(statusPrimaryCheckbox(index)));
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
        boolean studentStatusCategoryValidation = false;
        boolean studentStatusValidation = false;
        boolean studentStatusDateValidation = false;
        boolean entryTermValidation = false;
        boolean studentCommentsValidation = false;
        boolean studentActiveCheckboxLocator = false;
        boolean studentPrymaryCheckboxLocator = false;

        String errorMessage = String.format(LogPage.VERIFY_STUDENT_STATUS_FAIL, studentStatus,person);
        String passMessage = String.format(LogPage.VERIFY_STUDENT_STATUS_PASS, studentStatus,person);

        try {
            scrollToElement(By.cssSelector(statusPlusSignElement(studentStatus)));
            if (mass.get(person).get("StudentStatusCategory") != null) {
                String category = getText(By.cssSelector(categoryElement(studentStatus)));
                studentStatusCategoryValidation = category.contains(mass.get(person).get("StudentStatusCategory"));
            }else{
                studentStatusCategoryValidation = true;
    }
            if (mass.get(person).get("StudentStatus") != null) {
                String status = getText(By.cssSelector(statusElement(studentStatus)));
                studentStatusValidation = status.contains(mass.get(person).get("StudentStatus"));
            }else{
                studentStatusValidation = true;
    }
            if (mass.get(person).get("StudentStatusDate") != null) {
                String studentStatusDate = getAtribute(By.cssSelector(statusDateField(studentStatus)),"value");
                studentStatusDateValidation = studentStatusDate.contains(mass.get(person).get("StudentStatusDate"));
            }else{
                studentStatusDateValidation = true;
            }
            if (mass.get(person).get("EntryTerm") != null) {
                String entryTerm = getText(By.cssSelector(entryTermElement(studentStatus)));
                entryTermValidation = entryTerm.contains(mass.get(person).get("EntryTerm"));
            }else{
                entryTermValidation = true;
            }
            if (mass.get(person).get("StudentComments") != null) {
                String studentComments = getText(By.cssSelector(statusCommentsField(studentStatus)));
                studentCommentsValidation = studentComments.contains(mass.get(person).get("StudentComments"));
            }else{
                studentCommentsValidation = true;
            }
            switch (mass.get(person).get("Active")){
                case "1":
                    studentActiveCheckboxLocator = checkBoxIsActive(By.cssSelector(statusActiveCheckbox(studentStatus)));
                    break;
                case "0":
                    studentActiveCheckboxLocator = !checkBoxIsActive(By.cssSelector(statusActiveCheckbox(studentStatus)));
                    break;
                default: throw new IllegalArgumentException("Unhandled index. Update business logic");

            }

            switch (mass.get(person).get("Primary")){
                case "1":
                    studentPrymaryCheckboxLocator = checkBoxIsActive(By.cssSelector(statusPrimaryCheckbox(studentStatus)));
                    break;
                case "0":
                    studentPrymaryCheckboxLocator = !checkBoxIsActive(By.cssSelector(statusPrimaryCheckbox(studentStatus)));
                    break;
                default: throw new IllegalArgumentException("Unhandled index. Update business logic");

            }
            if(studentStatusCategoryValidation
                    && studentStatusValidation
                    && studentStatusDateValidation
                    && entryTermValidation
                    && studentCommentsValidation
                    && studentActiveCheckboxLocator
                    && studentPrymaryCheckboxLocator){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
}
