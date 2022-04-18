package pages.Records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class StudentStatusPage extends BasePage {


    private static final String CATEGORY_ELEMENT = "#s2id_person_student_status_%s_student_status_category";
    private static final String STATUS_PLUS_SIGN_ELEMENT = "#person_student_status_%s_add";
    private static final String STATUS_ELEMENT = "#s2id_person_student_status_%s_student_status";
    private static final String STUDENT_STATUS_DATA_FIELD_ELEMENT = "#person_student_status_%s_student_status_date";
    private static final String ENTRY_TERM_ELEMENT = "#s2id_person_student_status_%s_status_entry_term";
    private static final String STUDENT_COMMENTS_ELEMENT = "#person_student_status_%s_student_status_comments";
    private static final String STATUS_ACTIVE_CHECKBOX_ELEMENT = "#person_student_status_%s_active";
    private static final String STATUS_PRIMARY_CHECKBOX_ELEMENT = "#person_student_status_%s_primary";



    public static String statusPlusSignElement(String index){
        return String.format(STATUS_PLUS_SIGN_ELEMENT,index);
    }
    public static String categoryElement(String index){
        return String.format(CATEGORY_ELEMENT,index);
    }
    public static String statusElement(String index){
        return String.format(STATUS_ELEMENT,index);
    }
    public static String statusDateField(String index){
        return String.format(STUDENT_STATUS_DATA_FIELD_ELEMENT,index);
    }
    public static String entryTermElement(String index){
        return String.format(ENTRY_TERM_ELEMENT,index);
    }
    public static String statusCommentsField(String index){
        return String.format(STUDENT_COMMENTS_ELEMENT,index);
    }
    public static String statusActiveCheckbox(String index){
        return String.format(STATUS_ACTIVE_CHECKBOX_ELEMENT,index);
    }
    public static String statusPrimaryCheckbox(String index){
        return String.format(STATUS_PRIMARY_CHECKBOX_ELEMENT,index);
    }
    /*
     * Method to update student status
     */
    public static void updateStudentStatus(String index){
        try {
            int indexInt = Integer.parseInt(index);
            if (mass.get(indexInt).get("Category") != null) {
                BasePage.click(By.cssSelector(categoryElement(index)));
                BasePage.selectElementsList(By.cssSelector("//*[@id='select2-drop'"), "a");
                clickOnListOfElements(mass.get(indexInt).get("Category"));
            }
        } catch (Exception e) {
        }
    }

    /*
     * Method to click on student status
     */
    public static void clickOnAddStudentStatus(String index){
        try {
            waitElementBy(By.cssSelector(statusPlusSignElement(index)),20);
            BasePage.click(By.cssSelector(statusPlusSignElement(index)));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_ON_ADD_STUDENT_STATUS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_ON_ADD_STUDENT_STATUS_FAIL);
        }
    }
    /*
     * Method to check to verify student status on page records
     */
    public static void verifyStudentStatus(String index){
        boolean studentStatusCategoryValidation = false;
        boolean studentStatusValidation = false;
        boolean studentStatusDateValidation = false;
        boolean entryTermValidation = false;
        boolean studentCommentsValidation = false;
        boolean studentActiveCheckboxLocator = false;
        boolean studentPrymaryCheckboxLocator = false;

        try {
            int indexInt = Integer.parseInt(index);
            scrollToElement(By.cssSelector(categoryElement(index)));
            if (mass.get(indexInt).get("StudentStatusCategory") != null) {
                String category = getText(By.cssSelector(categoryElement(index)));
                studentStatusCategoryValidation = category.contains(mass.get(indexInt).get("StudentStatusCategory"));
            }else{
                studentStatusCategoryValidation = true;
    }
            if (mass.get(indexInt).get("StudentStatus") != null) {
                String status = getText(By.cssSelector(statusElement(index)));
                studentStatusValidation = status.contains(mass.get(indexInt).get("StudentStatus"));
            }else{
                studentStatusValidation = true;
    }
            if (mass.get(indexInt).get("StudentStatusDate") != null) {
                String studentStatusDate = getAtribute(By.cssSelector(statusDateField(index)),"value");
                studentStatusDateValidation = studentStatusDate.contains(mass.get(indexInt).get("StudentStatusDate"));
            }else{
                studentStatusDateValidation = true;
            }
            if (mass.get(indexInt).get("EntryTerm") != null) {
                String entryTerm = getText(By.cssSelector(entryTermElement(index)));
                entryTermValidation = entryTerm.contains(mass.get(indexInt).get("EntryTerm"));
            }else{
                entryTermValidation = true;
            }
            if (mass.get(indexInt).get("StudentComments") != null) {
                String studentComments = getText(By.cssSelector(statusCommentsField(index)));
                studentCommentsValidation = studentComments.contains(mass.get(indexInt).get("StudentComments"));
            }else{
                studentCommentsValidation = true;
            }
            switch (indexInt){
                case 0:
                    studentActiveCheckboxLocator = checkBoxIsActive(By.cssSelector(statusActiveCheckbox(index)));
                    break;
                case 1:
                    studentActiveCheckboxLocator = !checkBoxIsActive(By.cssSelector(statusActiveCheckbox(index)));
                    break;
            }

            switch (indexInt){
                case 0:
                    studentPrymaryCheckboxLocator = checkBoxIsActive(By.cssSelector(statusPrimaryCheckbox(index)));
                    break;
                case 1:
                    studentPrymaryCheckboxLocator = !checkBoxIsActive(By.cssSelector(statusPrimaryCheckbox(index)));
                    break;
            }
            if(studentStatusCategoryValidation
                    && studentStatusValidation
                    && studentStatusDateValidation
                    && entryTermValidation
                    && studentCommentsValidation
                    && studentActiveCheckboxLocator
                    && studentPrymaryCheckboxLocator){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_STUDENT_STATUS_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_STUDENT_STATUS_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_STUDENT_STATUS_FAIL);
        }
    }




}
