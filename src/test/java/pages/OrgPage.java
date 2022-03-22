package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.junit.Assert;
import org.openqa.selenium.By;

public class OrgPage extends BasePage{

    private static final String emailAddressField = "#entity_email_0_org_email_address";
    private static final String emailTypeDropDown = "#s2id_entity_email_0_org_email_type";
    private static final String emailTypeDropDownList = "#select2-drop";

    private static final String emailOptDropDown = "#s2id_entity_email_0_org_opt_in_method_id";
    private static final String emailOptDropDownList = "#select2-drop";

    private static final String orgBasicSaveChangesButton = "saveChangesBtnOrgContact";
    private static final String organizationNameField = "#org_name_0_org_name_formal";

    private static final String typeDropdown = "#select2-chosen-6";
    private static final String typeDropdownList = "#select2-drop";
    private static final String idNumberField = "#entity_external_id_0_org_id_number";
    private static final String idRecordedDateField = "#entity_external_id_0_org_id_date";
    private static final String whoAddedIdDropdown = "#select2-chosen-7";
    private static final String whoAddedIdDropdownList = "#select2-drop";
    private static final String commentsField = "#entity_external_id_0_org_id_comments";
    private static final String plusButtonExternalId = "//*[@id='entity_external_id_0_add']";
    private static final String saveChangesBtnOrgIdTypes = "saveChangesBtnOrgIdTypes";

    /*
     * to update email address in Contact tab on records
     */
    public static void updateEmailAddress(String emailAddress,String emailType,String emailOpt, String optStatus, String optDate, String emailStatus, String emailContent){
        try {
            waitElementBy(By.cssSelector(emailAddressField),20);
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
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_EMAIL_ADDRESS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_EMAIL_ADDRESS_FAIL);
        }
    }


    /*
     * to save changes in Contact tab on records
     */
    public static void saveChangesBtnOrgContact(){
        try {
            waitElementBy(By.id(orgBasicSaveChangesButton),20);
            BasePage.scrollToElement(By.id(orgBasicSaveChangesButton));
            BasePage.click(By.id(orgBasicSaveChangesButton));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }
    /*
     * to update Id Types in contact tab on records
     */
    public static void updateExternalIdTypes(String type,String idNumber,String idRecordedDate,String whoAddedId, String comments){
        try {
            waitElementBy(By.xpath(plusButtonExternalId),20);
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
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_EXTERNAL_ID_TYPES_PASS);

        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_EXTERNAL_ID_TYPES_FAIL);
        }
    }

    /*
     * to save changes in Id Types tab on records
     */
    public static void saveChangesBtnPersonIdTypes(){
        try {
            waitElementBy(By.id(saveChangesBtnOrgIdTypes),20);
            BasePage.scrollToElement(By.id(saveChangesBtnOrgIdTypes));
            BasePage.click(By.id(saveChangesBtnOrgIdTypes));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }
}
