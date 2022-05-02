package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class StaffPage extends BasePage{
    private static final String CONTACT_PHONE_NUMBER_FIELD = "entity_phone_0_phone_number";
    private static final String CONTACT_PHONE_TYPE_DROPDOWN = "s2id_entity_phone_0_phone_type";
    private static final String CONTACT_PHONE_TYPE_DROPDOWN_LIST = "#select2-drop";
    private static final String CONTACT_PHONE_COMMENTS_FIELD = "entity_phone_0_phone_comments";
    private static final String STAFF_CONTACT_SAVE_CHANGES_BUTTON = "saveChangesBtnStaffContact";
    public static final String STAFF_STATUS_RECORD = "staffHeaderRecordStatusButton";

    public static final String BASIC_PANEL_HEADING_ELEMENT = "#basic span";

    public static void validateBasicElementIsVisible(){
        try {
            String basicReturn = getText(By.cssSelector(BASIC_PANEL_HEADING_ELEMENT));
            if(basicReturn.equals("Basic")){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_BASIC_ELEMENT_IS_VISIBLE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_BASIC_ELEMENT_IS_VISIBLE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_BASIC_ELEMENT_IS_VISIBLE_FAIL);

        }
    }

    public static void verifyHeaderRecordStatus(String status){
        String passMessage = String.format(LogPage.VERIFY_HEADER_RECORD_STATUS_PASS, status);
        String failMessage = String.format(LogPage.VERIFY_HEADER_RECORD_STATUS_FAIL, status);
        try {
            waitUntilElementPresence(By.id(STAFF_STATUS_RECORD),20);
            String studentTypeText = getText(By.id(STAFF_STATUS_RECORD));
            if(studentTypeText.contains(status)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyHeaderPermissions(String permission){
        String passMessage = String.format(LogPage.VERIFY_HEADER_PERMISSIONS_PASS, permission);
        String failMessage = String.format(LogPage.VERIFY_HEADER_PERMISSIONS_FAIL, permission);
        try {
            waitUntilElementPresence(By.cssSelector(STAFF_STATUS_RECORD),20);
            String studentTypeText = getText(By.cssSelector(STAFF_STATUS_RECORD));
            if(studentTypeText.contains(permission)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updatePhoneNumber(String phone,String phoneType,String comment){
        try {
            waitElementBy(By.id(CONTACT_PHONE_NUMBER_FIELD),20);
            if (mass.get(0).get(phone) != null) {
                BasePage.write(By.id(CONTACT_PHONE_NUMBER_FIELD), mass.get(0).get(phone));
            }
            if (mass.get(0).get(phoneType) != null) {
                BasePage.click(By.id(CONTACT_PHONE_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(CONTACT_PHONE_TYPE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get(phoneType));
            }
            if (mass.get(0).get(comment) != null) {
                BasePage.write(By.id(CONTACT_PHONE_COMMENTS_FIELD), mass.get(0).get(comment));
            }
            saveChangesBtnStaffContact();
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_PHONE_NUMBER_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_PHONE_NUMBER_FAIL);
        }
    }
    /*
     * to save changes in contact tab on records
     */
    public static void saveChangesBtnStaffContact(){
        try {
            waitElementBy(By.id(STAFF_CONTACT_SAVE_CHANGES_BUTTON),20);
            BasePage.scrollToElement(By.id(STAFF_CONTACT_SAVE_CHANGES_BUTTON));
            BasePage.click(By.id(STAFF_CONTACT_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }
}
