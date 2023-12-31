package pages.records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;
import pages.PersonPage;
public class IdTypesPage extends BasePage {

    private static final String PERSON_EXTERNAL_ID_TYPES_SAVE_CHANGES_BUTTON = "//button[contains(@id, 'saveChangesBtn')]";
    private static final String VISA_NUMBER = "person_visa_0_visa_person_external_id";
    private static final String VISA_ENTRY_TERM_DROPDOWN_LIST = "#select2-results-8";
    private static final String VISA_COUNTRY_DROPDOWN_LIST = "#select2-results-9";
    private static final String VISA_VISA_TYPE_DROPDOWN_LIST = "#select2-results-10";


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
    private static String visaEntryTermDropdown(String index){
        return String.format("#s2id_person_visa_0_visa_entry_term.select2-container.form-control.person_visa.select2.required a.select2-choice",index);
    }
    private static String visaCountryDropdown(String index){
        return String.format("#s2id_person_visa_0_visa_issue_country.select2-container.form-control.person_visa.select2 a.select2-choice",index);
    }
    private static String visaVisaTypeDropdown(String index){
        return String.format("#s2id_person_visa_0_visa_type.select2-container.form-control.person_visa.select2 a.select2-choice",index);
    }
    public static void addExternalID(String group){
        String passMessage = String.format(LogPage.ADD_EXTERNAL_ID_PASS,group);
        String failMessage = String.format(LogPage.ADD_EXTERNAL_ID_FAIL,group);
        try {
            MainPage.addDeleteWithPlusButton(By.cssSelector(externalIdPlusSignElement(group)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateVisa(String entryTerm,String country,String visaType,String group){
        String passMessage = String.format(LogPage.UPDATE_VISA_PASS,group);
        String failMessage = String.format(LogPage.UPDATE_VISA_FAIL,group);
        try {
            if(entryTerm!=""){
                MainPage.clickOptionList(By.cssSelector(visaEntryTermDropdown(group)),
                        entryTerm,
                        By.cssSelector(VISA_ENTRY_TERM_DROPDOWN_LIST));
            }
            if(country!=""){
                MainPage.clickOptionList(By.cssSelector(visaCountryDropdown(group)),
                        country,
                        By.cssSelector(VISA_COUNTRY_DROPDOWN_LIST));
            }
            if(visaType!=""){
                MainPage.clickOptionList(By.cssSelector(visaVisaTypeDropdown(group)),
                        visaType,
                        By.cssSelector(VISA_VISA_TYPE_DROPDOWN_LIST));
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
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
                MainPage.clickOptionList(By.xpath(typeDropdown(index)),
                        mass.get(person).get("IDType"),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (mass.get(person).get("IDNumber") != null) {
                MainPage.fillField(By.xpath(idNumber(index)), mass.get(person).get("IDNumber"));
            }
            if (mass.get(person).get("IdRecordedDate") != null) {
                MainPage.fillDateField(By.xpath(idRecordedDate(index)), mass.get(person).get("IdRecordedDate"));
            }
            if (mass.get(person).get("WhoAddedID") != null) {
                MainPage.clickOptionList(By.xpath(whoAddedID(index)),
                        mass.get(person).get("WhoAddedID"),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (mass.get(person).get("Comments") != null) {
                MainPage.fillField(By.xpath(comments(index)), mass.get(person).get("Comments"));
            }
            if (mass.get(person).get("Primary") != null) {
                click(By.cssSelector(idTypePrimaryCheckbox(index)));
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
}
