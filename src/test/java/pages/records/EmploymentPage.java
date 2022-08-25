package pages.records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;

public class EmploymentPage extends BasePage {

    public static final String ORG_PICKER_MODAL_SEARCH_FIELD = "#orgPickerModalTableControlsTableSearch";
    public static final String ORG_PICKER_MODAL_TABLE_ROW1 = "#orgPickerModalTable_row_0";
    public static final String ORG_PICKER_MODAL_CHOOSE_BUTTON = "#modalSubmitButtonorgPicker";
    public static final String ORG_PICKER_MODAL_TABLE_ROW1_CHECKBOX = "//table[@id='orgPickerModalTable']/tbody/tr/th/div/input";

    private static String paymentTypeDropdown(String index){
        return String.format("#person_employment_%s_employment_position",index);
    }
    private static String employmentStartDate(String index){
        return String.format("#person_employment_%s_employment_start_date",index);
    }
    private static String employmentEndDate(String index){
        return String.format("#person_employment_%s_employment_end_date",index);
    }
    private static String employmentDuties(String index){
        return String.format("#person_employment_%s_employment_duties",index);
    }
    private static String employmentComments(String index){
        return String.format("#person_employment_%s_employment_comments",index);
    }
    private static String employmentPickButton(String index){
        return String.format("#person_employment_%s_recordPickerTrigger",index);
    }
    private static String employmentEmployerName(String index){
        return String.format("#person_employment_%s_employer_reltn_id",index);
    }
    private static String employmentPosition(String index){
        return String.format("#person_employment_%s_employment_position",index);
    }
    private static String employmentPlusSignButton(String index){
        return String.format("#person_employment_%s_add",index);
    }

    public static void addEmployment(String group){
        String passMessage = String.format(LogPage.ADD_EMPLOYMENT_PASS,group);
        String failMessage = String.format(LogPage.ADD_EMPLOYMENT_FAIL,group);
        try {
            MainPage.addDeleteWithPlusButton(By.cssSelector(employmentPlusSignButton(group)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyEmployment(String employerName, String position,String startDate,String endDate,String duties,String comments,String group){
        String passMessage = String.format(LogPage.VERIFY_EMPLOYMENT_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_EMPLOYMENT_FAIL,group);
        try {
            if(MainPage.verifyGetAttribute(By.cssSelector(employmentEmployerName(group)),employerName)
            && MainPage.verifyGetAttribute(By.cssSelector(employmentPosition(group)),position)
            && MainPage.verifyGetAttribute(By.cssSelector(employmentStartDate(group)),startDate)
            && MainPage.verifyGetAttribute(By.cssSelector(employmentEndDate(group)),endDate)
            && MainPage.verifyGetAttribute(By.cssSelector(employmentDuties(group)),duties)
            && MainPage.verifyGetAttribute(By.cssSelector(employmentComments(group)),comments)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void pickEmployer(String employerName,String group){
        String passMessage = String.format(LogPage.PICK_EMPLOYER_PASS,employerName,group);
        String failMessage = String.format(LogPage.PICK_EMPLOYER_FAIL,employerName,group);
        try {
            MainPage.picker(By.cssSelector(employmentPickButton(group)),
                    By.cssSelector(ORG_PICKER_MODAL_SEARCH_FIELD),
                    By.cssSelector(ORG_PICKER_MODAL_TABLE_ROW1),
                    By.xpath(ORG_PICKER_MODAL_TABLE_ROW1_CHECKBOX),
                    By.cssSelector(ORG_PICKER_MODAL_CHOOSE_BUTTON),
                    employerName);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateEmployment(String position,String startDate,String endDate,String duties,String comments,String group){
        String passMessage = String.format(LogPage.UPDATE_EMPLOYMENT_PASS,group);
        String failMessage = String.format(LogPage.UPDATE_EMPLOYMENT_FAIL,group);
        try {
            if(position!=""){
                MainPage.fillField(By.cssSelector(paymentTypeDropdown(group)),position);
            }
            if(startDate!=""){
                MainPage.fillDateField(By.cssSelector(employmentStartDate(group)),startDate);
            }
            if(endDate!=""){
                MainPage.fillDateField(By.cssSelector(employmentEndDate(group)),endDate);
            }
            if(duties!=""){
                MainPage.fillField(By.cssSelector(employmentDuties(group)),duties);
            }
            if(comments!=""){
                MainPage.fillField(By.cssSelector(employmentComments(group)),comments);
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
