package pages.records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.*;

public class IdTypesPage extends BasePage {

    private static final String PERSON_EXTERNAL_ID_TYPES_SAVE_CHANGES_BUTTON = "//button[contains(@id, 'saveChangesBtn')]";
    private static final String VISA_NUMBER = "person_visa_0_visa_person_external_id";


    private static String externalIdPlusSignElement(String index){
        return String.format("#entity_external_id_%s_add",index);
    }
    private static String idTypePrimaryCheckbox(String index){
        return String.format("#entity_external_id_%s_primary",index);
    }
    private static String typeDropdown(String index){
        return String.format("//div[contains(@id, 'entity_external_id_%s_') and contains(@id, '_id_type')]",index);
    }
    private static String idNumber(String index){
        return String.format("//*[starts-with(@id, 'entity_external_id_%s_') and contains(@id, '_id_number')]",index);
    }
    private static String idRecordedDate(String index){
        return String.format("//*[contains(@id, 'entity_external_id_%s_') and contains(@id, '_id_date')]",index);
    }
    private static String whoAddedID(String index){
        return String.format("//div[contains(@id, 'entity_external_id_%s_') and contains(@id, '_id_user')]",index);
    }
    private static String comments(String index){
        return String.format("//*[contains(@id, 'entity_external_id_%s_') and contains(@id, '_id_comments')]",index);
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

    public static void saveChangesBtnIdTypes(){
        try {
            waitElementBy(By.xpath(PERSON_EXTERNAL_ID_TYPES_SAVE_CHANGES_BUTTON),20);
            BasePage.scrollToElement(By.xpath(PERSON_EXTERNAL_ID_TYPES_SAVE_CHANGES_BUTTON));
            BasePage.click(By.xpath(PERSON_EXTERNAL_ID_TYPES_SAVE_CHANGES_BUTTON));
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
                waitUntilElementToBeSelected(By.xpath(typeDropdown(index)),20);
                BasePage.click(By.xpath(typeDropdown(index)));
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(mass.get(person).get("IDType"));
            }
            if (mass.get(person).get("IDNumber") != null) {
                scrollToElement(By.cssSelector(externalIdPlusSignElement(index)));
                waitElementBy(By.xpath(idNumber(index)),20);
                BasePage.write(By.xpath(idNumber(index)),mass.get(person).get("IDNumber"));
            }
            if (mass.get(person).get("IdRecordedDate") != null) {
                scrollToElement(By.cssSelector(externalIdPlusSignElement(index)));
                waitElementBy(By.xpath(idRecordedDate(index)),20);
                BasePage.write(By.xpath(idRecordedDate(index)),mass.get(person).get("IdRecordedDate"));
            }
            if (mass.get(person).get("WhoAddedID") != null) {
                scrollToElement(By.cssSelector(externalIdPlusSignElement(index)));
                BasePage.click(By.xpath(whoAddedID(index)));
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(mass.get(0).get("WhoAddedID"));
            }
            if (mass.get(person).get("Comments") != null) {
                scrollToElement(By.cssSelector(externalIdPlusSignElement(index)));
                waitElementBy(By.xpath(comments(index)),20);
                BasePage.write(By.xpath(comments(index)),mass.get(person).get("Comments"));
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
