package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.junit.Assert;
import org.openqa.selenium.By;

public class StaffPage extends BasePage{
    private static String recordNavTabContact = "recordNavTab_contact";
    private static String contactPhoneNumberField = "entity_phone_0_phone_number";
    private static String contactPhoneTypeDropdown = "s2id_entity_phone_0_phone_type";
    private static String contactPhoneTypeDropdownList = "#select2-drop";
    private static String contactPhoneCommentsField = "entity_phone_0_phone_comments";
    private static String staffContactSaveChangesButton = "saveChangesBtnStaffContact";

    /*
     * to go to Contact tab on records
     */
    public static void navigateToContact(){
        try {
            BasePage.click(By.id(recordNavTabContact));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_CONTACT_PASS);
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail(LogPage.NAVIGATE_TO_CONTACT_FAIL);
            Assert.assertFalse(true);
            System.err.println(LogPage.NAVIGATE_TO_CONTACT_FAIL);
        }
    }
    /*
     * to update Phone Number in contact tab on records
     */
    public static void updatePhoneNumber(String phone,String phoneType,String comment){
        BasePage.wait(3000);
        try {
            if (mass.get(0).get(phone) != null) {
                BasePage.write(By.id(contactPhoneNumberField), mass.get(0).get(phone));
            }
            if (mass.get(0).get(phoneType) != null) {
                BasePage.click(By.id(contactPhoneTypeDropdown));
                BasePage.selectElementsList(contactPhoneTypeDropdownList, "a");
                clickOnListOfElements(mass.get(0).get(phoneType));
            }
            if (mass.get(0).get(comment) != null) {
                BasePage.write(By.id(contactPhoneCommentsField), mass.get(0).get(comment));
            }
            saveChangesBtnStaffContact();
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_PHONE_NUMBER_PASS);
        } catch (Exception e) {
            System.err.println(LogPage.UPDATE_PHONE_NUMBER_FAIL);
        }
    }
    /*
     * to save changes in contact tab on records
     */
    public static void saveChangesBtnStaffContact(){
        BasePage.wait(2000);
        try {
            BasePage.scrollToElement(By.id(staffContactSaveChangesButton));
            BasePage.click(By.id(staffContactSaveChangesButton));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail(LogPage.SAVE_CHANGES_FAIL);
            Assert.assertFalse(true);
            System.err.println(LogPage.SAVE_CHANGES_FAIL);
        }
    }
}
