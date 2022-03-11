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

    private static String typeDropdown = "#select2-chosen-6";
    private static String typeDropdownList = "#select2-drop";
    private static String idNumberField = "#entity_external_id_0_org_id_number";
    private static String idRecordedDateField = "#entity_external_id_0_org_id_date";
    private static String whoAddedIdDropdown = "#select2-chosen-7";
    private static String whoAddedIdDropdownList = "#select2-drop";
    private static String commentsField = "#entity_external_id_0_org_id_comments";
    private static String plusButtonExternalId = "//*[@id='entity_external_id_0_add']";
    private static String saveChangesBtnOrgIdTypes = "saveChangesBtnOrgIdTypes";

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
    /*
     * to update Id Types in contact tab on records
     */
    public static void updateExternalIdTypes(String type,String idNumber,String idRecordedDate,String whoAddedId, String comments){
        BasePage.wait(2000);
        try {
            BasePage.scrollToElement(By.xpath(plusButtonExternalId));

            if (mass.get(0).get(type) != null) {
                BasePage.click(By.cssSelector(typeDropdown));
                BasePage.selectElementsList(typeDropdownList, "a");
                clickOnListOfElements(mass.get(0).get(type));
            }
            if (mass.get(0).get(idNumber) != null) {
                BasePage.write(By.cssSelector(idNumberField), mass.get(0).get(idNumber));
            }
            if (mass.get(0).get(idRecordedDate) != null) {
                BasePage.write(By.cssSelector(idRecordedDateField), mass.get(0).get(idRecordedDate));
            }
            if (mass.get(0).get(whoAddedId) != null) {
                BasePage.click(By.cssSelector(whoAddedIdDropdown));
                BasePage.selectElementsList(whoAddedIdDropdownList, "a");
                clickOnListOfElements(mass.get(0).get(whoAddedId));
            }
            if (mass.get(0).get(comments) != null) {
                BasePage.write(By.cssSelector(commentsField), mass.get(0).get(comments));
            }
            saveChangesBtnPersonIdTypes();
            ExtentReportsSetUp.testingPass(LogPage.updateExternalIdTypesPass);

        } catch (Exception e) {
            ExtentReportsSetUp.testingFail(LogPage.updateExternalIdTypesFail);
            Assert.assertFalse(true);
            System.err.println(LogPage.updateExternalIdTypesFail);
        }
    }

    /*
     * to save changes in Id Types tab on records
     */
    public static void saveChangesBtnPersonIdTypes(){
        BasePage.wait(2000);
        try {
            BasePage.scrollToElement(By.id(saveChangesBtnOrgIdTypes));
            BasePage.click(By.id(saveChangesBtnOrgIdTypes));
            ExtentReportsSetUp.testingPass(LogPage.saveChangesPass);
        } catch (Exception e) {
            Assert.assertFalse(true);
            System.err.println(LogPage.saveChangesFail);
        }
    }

}
