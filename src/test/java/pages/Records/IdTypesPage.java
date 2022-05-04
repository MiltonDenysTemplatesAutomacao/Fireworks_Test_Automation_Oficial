package pages.Records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.OrgPage;

public class IdTypesPage extends BasePage {

    private static final String PERSON_EXTERNAL_ID_TYPES_SAVE_CHANGES_BUTTON = "saveChangesBtnPersonIdTypes";
    private static final String VISA_NUMBER = "person_visa_0_visa_person_external_id";


    private static String externalIdPlusSignElement(String index){
        return String.format("#entity_external_id_%s_add",index);
    }
    private static String idTypePrimaryCheckbox(String index){
        return String.format("#entity_external_id_%s_primary",index);
    }
    private static String typeDropdown(String index){
        return String.format("#s2id_entity_external_id_%s_id_type",index);
    }
    private static String idNumber(String index){
        return String.format("#entity_external_id_%s_id_number",index);
    }
    private static String idRecordedDate(String index){
        return String.format("#entity_external_id_%s_id_date",index);
    }
    private static String whoAddedID(String index){
        return String.format("#s2id_entity_external_id_%s_id_user",index);
    }
    private static String comments(String index){
        return String.format("#entity_external_id_%s_id_comments",index);
    }
    private static String visaVisaNumber(String index){
        return String.format("person_visa_0_visa_person_external_id",index);
    }

    public static void validateVisaNumber(){

        try {
            scrollToElement(By.cssSelector(externalIdPlusSignElement("0")));
            if (mass.get(0).get("IDNumber").contains(getText(By.id(VISA_NUMBER)))) {
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_VISA_NUMBER_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_VISA_NUMBER_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_VISA_NUMBER_FAIL);
        }
    }

    public static void saveChangesBtnStaffIdTypes(){
        try {
            waitElementBy(By.id(PERSON_EXTERNAL_ID_TYPES_SAVE_CHANGES_BUTTON),20);
            BasePage.scrollToElement(By.id(PERSON_EXTERNAL_ID_TYPES_SAVE_CHANGES_BUTTON));
            BasePage.click(By.id(PERSON_EXTERNAL_ID_TYPES_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }

    public static void updateExternalId(String index, int person){
        String errorMessage = String.format(LogPage.UPDATE_EXTERNAL_ID_FAIL, index,person);
        String passMessage = String.format(LogPage.UPDATE_EXTERNAL_ID_PASS, index,person);
        try {
            if (mass.get(person).get("IDType") != null) {
                scrollToElement(By.cssSelector(externalIdPlusSignElement(index)));
                waitUntilElementToBeSelected(By.cssSelector(typeDropdown(index)),20);
                BasePage.click(By.cssSelector(typeDropdown(index)));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                clickOnListOfElements(mass.get(person).get("IDType"));
            }
            if (mass.get(person).get("IDNumber") != null) {
                scrollToElement(By.cssSelector(externalIdPlusSignElement(index)));
                waitElementBy(By.cssSelector(idNumber(index)),20);
                BasePage.write(By.cssSelector(idNumber(index)),mass.get(person).get("IDNumber"));
            }
            if (mass.get(person).get("IdRecordedDate") != null) {
                scrollToElement(By.cssSelector(externalIdPlusSignElement(index)));
                waitElementBy(By.cssSelector(idRecordedDate(index)),20);
                BasePage.write(By.cssSelector(idRecordedDate(index)),mass.get(person).get("IdRecordedDate"));
            }
            if (mass.get(person).get("WhoAddedID") != null) {
                scrollToElement(By.cssSelector(externalIdPlusSignElement(index)));
                BasePage.click(By.cssSelector(whoAddedID(index)));
                BasePage.selectElementsList(By.cssSelector(OrgPage.WHO_ADDED_ID_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get("WhoAddedID"));
            }
            if (mass.get(person).get("Comments") != null) {
                scrollToElement(By.cssSelector(externalIdPlusSignElement(index)));
                waitElementBy(By.cssSelector(comments(index)),20);
                BasePage.write(By.cssSelector(comments(index)),mass.get(person).get("Comments"));
            }
            if (mass.get(person).get("Primary") != null) {
                scrollToElement(By.cssSelector(externalIdPlusSignElement(index)));
                waitUntilElementPresence(By.cssSelector(idTypePrimaryCheckbox(index)),20);
                BasePage.click(By.cssSelector(idTypePrimaryCheckbox(index)));
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

}
