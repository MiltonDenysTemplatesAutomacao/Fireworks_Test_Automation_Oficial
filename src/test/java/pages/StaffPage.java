package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.junit.Assert;
import org.openqa.selenium.By;

public class StaffPage extends BasePage{
    public static String recordNavTabContact = "recordNavTab_contact";
    private static String contactPhoneNumberField = "entity_phone_0_phone_number";
    private static String contactPhoneTypeDropdown = "s2id_entity_phone_0_phone_type";
    private static String contactPhoneTypeDropdownList = "#select2-drop";
    private static String contactPhoneCommentsField = "entity_phone_0_phone_comments";
    private static String staffContactSaveChangesButton = "saveChangesBtnStaffContact";

    public static void navigateToContact(){
        String errorMessage = "Error while navigating to contact";
        String passMessage ="I navigate to contact";
        try {
            BasePage.click(By.id(recordNavTabContact));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail(errorMessage);
            Assert.assertFalse(true);
            System.err.println(errorMessage);
        }
    }
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
            ExtentReportsSetUp.testingPass("I update phone number");
        } catch (Exception e) {
            System.err.println("Fail on updatePhoneNumber");
        }
    }
    public static void saveChangesBtnStaffContact(){
        BasePage.wait(2000);
        String errorMessage = "Error while trying to save changes";
        String passMessage ="I click on save changes";
        try {
            BasePage.scrollToElement(By.id(staffContactSaveChangesButton));
            BasePage.click(By.id(staffContactSaveChangesButton));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            Assert.assertFalse(true);
            System.err.println(errorMessage);
            ExtentReportsSetUp.testingFail(errorMessage);
        }
    }



}
