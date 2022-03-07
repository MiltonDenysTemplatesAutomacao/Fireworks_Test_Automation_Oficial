package pages;

import config.extent_reports.ExtentReportsSetUp;
import io.cucumber.datatable.DataTable;
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
        try {
            BasePage.click(By.id(recordNavTabContact));
            ExtentReportsSetUp.testingPass("I navigate to contact");
        } catch (Exception e) {
            Assert.assertFalse(true);
            System.err.println("Error while navigating to contact");
            ExtentReportsSetUp.testingFail("Error while navigating to contact");
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
            }else{
                Assert.assertFalse(true);
                System.err.println("Error while updating phone number");
                ExtentReportsSetUp.testingFail("Error while updating phone number");
            }
            clickContactSaveChanges();
            ExtentReportsSetUp.testingPass("I update phone number");

        } catch (Exception e) {

        }
    }
    public static void clickContactSaveChanges(){
        BasePage.wait(2000);
        try {
            BasePage.scrollToElement(By.id(staffContactSaveChangesButton));
            BasePage.click(By.id(staffContactSaveChangesButton));
            ExtentReportsSetUp.testingPass("I click on save changes");
        } catch (Exception e) {
            Assert.assertFalse(true);
            System.err.println("Error while trying to save changes");
            ExtentReportsSetUp.testingFail("Error while trying to save changes");

        }
    }



}
