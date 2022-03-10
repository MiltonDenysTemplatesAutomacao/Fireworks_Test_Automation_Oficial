package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.junit.Assert;
import org.openqa.selenium.By;

public class OrgPage extends BasePage{

    private static String emailAddressField = "#entity_email_0_org_email_address";
    private static String emailTypeDropDown = "#s2id_entity_email_0_org_email_type";
    private static String emailTypeDropDownList = "#select2-drop";

    private static String emailOptDropDown = "#s2id_entity_email_0_org_opt_in_method_id";
    private static String emailOptDropDownList = "#select2-drop";




    private static String orgBasicSaveChangesButton = "saveChangesBtnOrgContact";
    private static String organizationNameField = "#org_name_0_org_name_formal";



    /*
     * to update email address in Contact tab on records
     */
    public static void updateEmailAddress(String emailAddress,String emailType,String emailOpt, String optStatus, String optDate, String emailStatus, String emailContent){
        BasePage.wait(2000);
        try {
            BasePage.scrollToElement(By.cssSelector(organizationNameField));
            if (mass.get(0).get(emailAddress) != null) {
                BasePage.write(By.cssSelector(emailAddressField), mass.get(0).get(emailAddress));
            }
            if (mass.get(0).get(emailType) != null) {
                BasePage.click(By.cssSelector(emailTypeDropDown));
                BasePage.selectElementsList(emailTypeDropDownList, "a");
                clickOnListOfElements(mass.get(0).get(emailType));
            }
            if (mass.get(0).get(emailOpt) != null) {
                BasePage.click(By.cssSelector(emailOptDropDown));
                BasePage.selectElementsList(emailOptDropDownList, "a");
                clickOnListOfElements(mass.get(0).get(emailOpt));
            }
            saveChangesBtnOrgContact();
            ExtentReportsSetUp.testingPass(LogPage.updateEmailAddressPass);
        } catch (Exception e) {
            ExtentReportsSetUp.testingFail(LogPage.updateEmailAddressFail);
            Assert.assertFalse(true);
            System.err.println(LogPage.updateEmailAddressFail);
        }
    }


    /*
     * to save changes in Contact tab on records
     */
    public static void saveChangesBtnOrgContact(){
        BasePage.wait(2000);
        try {
            BasePage.scrollToElement(By.id(orgBasicSaveChangesButton));
            BasePage.click(By.id(orgBasicSaveChangesButton));
            ExtentReportsSetUp.testingPass(LogPage.saveChangesPass);
        } catch (Exception e) {
            Assert.assertFalse(true);
            System.err.println(LogPage.saveChangesFail);
        }
    }


}
