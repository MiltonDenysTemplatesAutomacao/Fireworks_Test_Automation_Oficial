package pages.Records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class PersonContactPage extends BasePage {

    private static final String EMAIL_ADDRESS_FIELD = "#entity_email_%s_email_address";
    private static final String EMAIL_TYPE_ELEMENT = "#entity_email_%s_email_type_component";
    private static final String EMAIL_OPT_IN_METHOD_ELEMENT = "#entity_email_%s_opt_in_method_id_component";
    private static final String EMAIL_OPT_IN_STATUS_ELEMENT = "#entity_email_%s_opt_in_status_component";
    private static final String EMAIL_OPT_IN_DATE_FIELD = "#entity_email_%s_opt_in_date";
    private static final String EMAIL_STATUS_ELEMENT = "#entity_email_%s_email_status_component";
    private static final String EMAIL_ACTIVE_CHECKBOX = "#entity_email_%s_active";
    private static final String EMAIL_PRIMARY_CHECKBOX = "#entity_email_%s_primary";
    private static final String EMAIL_COMMENTS_FIELD = "#entity_email_%s_email_comments";
    private static final String EMAIL_PLUS_SIGN_ELEMENT = "#entity_email_%s_add";
    private static final String EMAIL_DROP_DOWN = "//ul[starts-with(@id, 'entity_email_%s_')]//a[contains(text(),'%s')]";
    private static final String EMAIL_ADDRESS_FIELD_READ_ONLY = "//input[@id='entity_email_%s_email_address'][@readonly='readonly']";

    public static String emailAddressField(String index){
        return String.format(EMAIL_ADDRESS_FIELD,index);
    }
    public static String emailTypeElement(String index){
        return String.format(EMAIL_TYPE_ELEMENT,index);
    }
    public static String emailOptInMethodElement(String index){
        return String.format(EMAIL_OPT_IN_METHOD_ELEMENT,index);
    }
    public static String emailOptInStatusElement(String index){
        return String.format(EMAIL_OPT_IN_STATUS_ELEMENT,index);
    }
    public static String emailOptInDateField(String index){
        return String.format(EMAIL_OPT_IN_DATE_FIELD,index);
    }
    public static String emailStatusElement(String index){
        return String.format(EMAIL_STATUS_ELEMENT,index);
    }
    public static String emailCommentsField(String index){
        return String.format(EMAIL_COMMENTS_FIELD,index);
    }
    public static String emailActiveCheckbox(String index){
        return String.format(EMAIL_ACTIVE_CHECKBOX,index);
    }
    public static String emailPrimaryCheckbox(String index){
        return String.format(EMAIL_PRIMARY_CHECKBOX,index);
    }
    public static String emailPlusSignElement(String index){
        return String.format(EMAIL_PLUS_SIGN_ELEMENT,index);
    }
    public static String emailDropDown(String index){
        return String.format(EMAIL_DROP_DOWN,index);
    }
    public static String emailAddressFieldReadOnly(String index){
        return String.format(EMAIL_ADDRESS_FIELD_READ_ONLY,index);
    }
    private static String phoneNumberField(String index){
        return String.format("#entity_phone_%s_phone_number",index);
    }
    private static String phoneTypeElement(String index){
        return String.format("#entity_phone_%s_phone_type_component",index);
    }
    private static String phoneTypeElementList(String index){
        return String.format("#entity_phone_%s_phone_type_dropdown_menu",index);
    }
    private static String phoneStatusElement(String index){
        return String.format("#entity_phone_%s_phone_status_component",index);
    }
    private static String phoneStatusElementList(String index){
        return String.format("#entity_phone_%s_phone_status_dropdown_menu",index);
    }
    private static String phoneTimeZoneElement(String index){
        return String.format("#entity_phone_%s_phone_time_zone_component",index);
    }
    private static String phoneOptInMethodElement(String index){
        return String.format("#entity_phone_%s_phone_number",index);
    }
    private static String phoneOptInMethodElementList(String index){
        return String.format("#entity_phone_%s_text_messaging_opt_in_method_dropdown_menu",index);
    }
    private static String phoneOptInStatusElement(String index){
        return String.format("#entity_phone_%s_text_messaging_opt_in_status_component",index);
    }
    private static String phoneOptInStatusElementList(String index){
        return String.format("#entity_phone_%s_text_messaging_opt_in_status_dropdown_menu",index);
    }
    private static String phoneCommentsField(String index){
        return String.format("#entity_phone_%s_phone_comments",index);
    }
    private static String phoneActiveCheckbox(String index){
        return String.format("#entity_phone_%s_active",index);
    }
    private static String phonePrimaryCheckbox(String index){
        return String.format("#entity_phone_%s_primary",index);
    }
    private static String emailAddressAddButton(String index){
        return String.format("#entity_address_%s_add",index);
    }
    private static String address1Field(String index){
        return String.format("#entity_address_%s_address_1",index);
    }
    private static String address2Field(String index){
        return String.format("#entity_address_%s_address_2",index);
    }
    private static String address3Field(String index){
        return String.format("#entity_address_%s_address_3",index);
    }
    private static String address4Field(String index){
        return String.format("#entity_address_%s_address_4",index);
    }
    private static String addressCityField(String index){
        return String.format("#entity_address_%s_address_city",index);
    }
    private static String addressStateElement(String index){
        return String.format("#entity_address_%s_address_state_component",index);
    }
    private static String addressStateElementList(String index){
        return String.format("#entity_address_%s_address_state_dropdown_menu",index);
    }
    private static String addressStateSearch(String index){
        return String.format("#entity_address_%s_address_state_search",index);
    }

    private static String addressRegionField(String index){
        return String.format("#entity_address_%s_address_region",index);
    }
    private static String addressCountryElement(String index){
        return String.format("#entity_address_%s_address_country_component",index);
    }
    private static String addressCountryElementList(String index){
        return String.format("#entity_address_%s_address_country_dropdown_menu",index);
    }
    private static String addressPostalCodeField(String index){
        return String.format("#entity_address_%s_address_postal_code",index);
    }
    private static String addressTypeElement(String index){
        return String.format("#entity_address_%s_address_type_component",index);
    }
    private static String addressTypeElementList(String index){
        return String.format("#entity_address_%s_address_type_dropdown_menu",index);
    }
    private static String addressNeighborhoodElement(String index){
        return String.format("#entity_address_%s_address_neighborhood_component",index);
    }
    private static String addressNeighborhoodElementList(String index){
        return String.format("#entity_address_%s_address_neighborhood_dropdown_menu",index);
    }
    private static String addressCommentsField(String index){
        return String.format("#entity_address_%s_address_comments",index);
    }
    private static String addressActiveCheckbox(String index){
        return String.format("#entity_address_%s_active",index);
    }
    private static String addressPrimaryCheckbox(String index){
        return String.format("#entity_address_%s_primary",index);
    }

    public static void createAddress(String address1,String address2,String address3,String address4,String city,String state,String region,String country,String postalCode,String addressType,String educationNeighborhood,String addressComments,String active,String primary, String group){
        int createAddressDelay = 20;
        try {
            if(address1!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(address1Field(group)),createAddressDelay);
                write(By.cssSelector(address1Field(group)),address1);

            }
            if(address2!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(address2Field(group)),createAddressDelay);
                write(By.cssSelector(address1Field(group)),address2);
            }
            if(address3!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(address1Field(group)),createAddressDelay);
                write(By.cssSelector(address3Field(group)),address3);
            }
            if(address4!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(address4Field(group)),createAddressDelay);
                write(By.cssSelector(address1Field(group)),address4);
            }
            if(city!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(addressCityField(group)),createAddressDelay);
                write(By.cssSelector(addressCityField(group)),city);
            }
            if(state!=""){
                scrollToElement(By.cssSelector(addressCityField(group)));
                waitElementBy(By.cssSelector(addressStateElement(group)),createAddressDelay);
                BasePage.click(By.cssSelector(addressStateElement(group)));
                waitElementBy(By.cssSelector(addressStateElementList(group)),createAddressDelay);
                write(By.cssSelector(addressStateSearch(group)),state);
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(addressStateElementList(group)), "a");
                clickOnListOfElements(state);
                wait(1000);
            }
            if(region!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(addressRegionField(group)),createAddressDelay);
                write(By.cssSelector(addressRegionField(group)),region);
            }
            if(country!=""){
                scrollToElement(By.cssSelector(addressCityField(group)));
                waitElementBy(By.cssSelector(addressCountryElement(group)),createAddressDelay);
                BasePage.click(By.cssSelector(addressCountryElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(addressCountryElementList(group)), "a");
                clickOnListOfElements(country);
                wait(1000);
            }
            if(postalCode!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(addressPostalCodeField(group)),createAddressDelay);
                write(By.cssSelector(addressPostalCodeField(group)),postalCode);
            }
            if(addressType!=""){
                scrollToElement(By.cssSelector(addressStateElement(group)));
                waitElementBy(By.cssSelector(addressTypeElement(group)),createAddressDelay);
                BasePage.click(By.cssSelector(addressTypeElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(addressTypeElementList(group)), "a");
                clickOnListOfElements(addressType);
                wait(1000);
            }
            if(educationNeighborhood!=""){
                scrollToElement(By.cssSelector(addressStateElement(group)));
                waitElementBy(By.cssSelector(addressNeighborhoodElement(group)),createAddressDelay);
                BasePage.click(By.cssSelector(addressNeighborhoodElement(group)));
                waitElementBy(By.cssSelector(addressNeighborhoodElementList(group)),createAddressDelay);
                BasePage.selectElementsList(By.cssSelector(addressNeighborhoodElementList(group)), "a");
                clickOnListOfElements(educationNeighborhood);
                wait(1000);
            }
            if(addressComments!=""){
                scrollToElement(By.cssSelector(addressCommentsField(group)));
                waitElementBy(By.cssSelector(addressCommentsField(group)),createAddressDelay);
                write(By.cssSelector(addressCommentsField(group)),addressComments);
            }
            if(active!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(addressActiveCheckbox(group)),createAddressDelay);
                click(By.cssSelector(addressActiveCheckbox(group)));
            }
            if(primary!=""){
                scrollToElement(By.cssSelector(emailAddressAddButton(group)));
                waitElementBy(By.cssSelector(addressPrimaryCheckbox(group)),createAddressDelay);
                click(By.cssSelector(addressPrimaryCheckbox(group)));
            }
            ExtentReportsSetUp.testingPass(LogPage.CREATE_ADDRESS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_ADDRESS_FAIL);
        }
    }


    public static void verifyPhone(String phoneNumber, String phoneType,String phoneStatus, String timeZone, String phoneOptInMethod, String phoneOptInStatus, String optInStatusDate, String phoneComments, String active,String primary,String group){
        boolean phoneNumberValidation = false;
        boolean phoneTypeValidation = false;
        boolean timeZoneValidation = false;
        boolean phoneStatusValidation = false;
        boolean phoneOptInMethodValidation = false;
        boolean phoneOptInStatusValidation = false;
        boolean phoneCommentsValidation = false;
        boolean activeCheckboxValidation = false;
        boolean primaryCheckboxValidation = false;

        String passMessage = String.format(LogPage.VERIFY_PHONE_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_PHONE_FAIL,group);
        try {
            scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));

            if(phoneNumber!=""){
                String phoneNumberText = getAtribute(By.cssSelector(phoneNumberField(group)),"value");
                phoneNumberValidation = phoneNumber.equals(phoneNumberText);
            }else{
                phoneNumberValidation=true;
            }
            if(phoneType!=""){
                String phoneTypeText = getText(By.cssSelector(phoneTypeElement(group)));
                phoneTypeValidation = phoneType.equals(phoneTypeText);
            }else{
                phoneTypeValidation=true;
            }
            if(phoneStatus!=""){
                String phoneStatusText = getText(By.cssSelector(phoneStatusElement(group)));
                phoneStatusValidation = timeZone.equals(phoneStatusText);
            }else{
                phoneStatusValidation=true;
            }
            if(timeZone!=""){
                String timeZoneText = getText(By.cssSelector(phoneTimeZoneElement(group)));
                timeZoneValidation = timeZone.equals(timeZoneText);
            }else{
                timeZoneValidation=true;
            }
            if(phoneOptInMethod!=""){
                String phoneOptInMethodText = getText(By.cssSelector(phoneOptInMethodElement(group)));
                phoneOptInMethodValidation = phoneOptInMethod.equals(phoneOptInMethodText);
            }else{
                phoneOptInMethodValidation=true;
            }
            if(phoneOptInStatus!=""){
                String phoneOptInStatusText = getText(By.cssSelector(phoneOptInStatusElement(group)));
                phoneOptInStatusValidation = phoneOptInStatus.equals(phoneOptInStatusText);
            }else{
                phoneOptInStatusValidation=true;
            }
            if(phoneComments!=""){
                String phoneCommentsText = getAtribute(By.cssSelector(phoneCommentsField(group)),"value");
                phoneCommentsValidation = phoneOptInStatus.equals(phoneCommentsText);
            }else{
                phoneCommentsValidation=true;
            }
            if(active!=""){
                switch (active){
                    case "1":
                        activeCheckboxValidation = checkBoxIsActive(By.cssSelector(phoneActiveCheckbox(group)));
                        break;
                    case "0":
                        activeCheckboxValidation = !checkBoxIsActive(By.cssSelector(phoneActiveCheckbox(group)));
                        break;
                    default: throw new IllegalArgumentException("Active Checkbox not verified");
                }
            }else{
                activeCheckboxValidation=true;
            }
            if(primary!=""){
                switch (primary){
                    case "1":
                        primaryCheckboxValidation = checkBoxIsActive(By.cssSelector(phoneActiveCheckbox(group)));
                        break;
                    case "0":
                        primaryCheckboxValidation = !checkBoxIsActive(By.cssSelector(emailPrimaryCheckbox(group)));
                        break;
                    default: throw new IllegalArgumentException("Primary Checkbox not verified");
                }
            }else{
                primaryCheckboxValidation=true;
            }
            if(phoneNumberValidation
            && phoneTypeValidation
            && timeZoneValidation
            && phoneStatusValidation
            && phoneOptInMethodValidation
            && phoneOptInStatusValidation
            && phoneCommentsValidation
            && activeCheckboxValidation
            && primaryCheckboxValidation){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void createPhoneForPerson(String phoneNumber, String phoneType,String phoneStatus,String phoneOptInMethod,String phoneOptInStatus, String phoneComments, String active,String primary,String group){
        int createPhoneForPersonDelay = 20;

        try {
            if(phoneNumber!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneNumberField(group)),createPhoneForPersonDelay);
                write(By.cssSelector(phoneNumberField(group)), phoneNumber);
            }
            if(phoneType!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneTypeElement(group)),createPhoneForPersonDelay);
                BasePage.click(By.cssSelector(phoneTypeElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(phoneTypeElementList(group)), "a");
                clickOnListOfElements(phoneType);
                wait(1000);
            }
            if(phoneStatus!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneStatusElement(group)),createPhoneForPersonDelay);
                BasePage.click(By.cssSelector(phoneStatusElement(group)));
                waitElementBy(By.cssSelector(phoneStatusElementList(group)),createPhoneForPersonDelay);
                BasePage.selectElementsList(By.cssSelector(phoneStatusElementList(group)), "a");
                clickOnListOfElements(phoneStatus);
                wait(1000);
            }
            if(phoneOptInMethod!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneOptInMethodElement(group)),createPhoneForPersonDelay);
                BasePage.click(By.cssSelector(phoneOptInMethodElement(group)));
                waitElementBy(By.cssSelector(phoneOptInMethodElementList(group)),createPhoneForPersonDelay);
                BasePage.selectElementsList(By.cssSelector(phoneOptInMethodElementList(group)), "a");
                clickOnListOfElements(phoneOptInMethod);
                wait(1000);
            }
            if(phoneOptInStatus!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneOptInStatusElement(group)),createPhoneForPersonDelay);
                BasePage.click(By.cssSelector(phoneOptInStatusElement(group)));
                waitElementBy(By.cssSelector(phoneOptInStatusElementList(group)),createPhoneForPersonDelay);
                BasePage.selectElementsList(By.cssSelector(phoneOptInStatusElementList(group)), "a");
                clickOnListOfElements(phoneOptInStatus);
                wait(1000);
            }
            if(phoneComments!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneCommentsField(group)),createPhoneForPersonDelay);
                write(By.cssSelector(phoneCommentsField(group)), phoneComments);
            }
            if(active!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneActiveCheckbox(group)),createPhoneForPersonDelay);
                click(By.cssSelector(phoneActiveCheckbox(group)));
            }
            if(primary!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phonePrimaryCheckbox(group)),createPhoneForPersonDelay);
                click(By.cssSelector(phonePrimaryCheckbox(group)));
            }
            ExtentReportsSetUp.testingPass(LogPage.CREATE_PHONE_FOR_PERSON_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_PHONE_FOR_PERSON_FAIL);
        }
    }
    public static void verifyEmailPersonPageRecord(String index){

        boolean emailAddressValidation = false;
        boolean emailTypeValidation = false;
        boolean emailOptInMethodValidation = false;
        boolean emailOptInStatusValidation = false;
        boolean emailOptInDateValidation = false;
        boolean emailStatusValidation = false;
        boolean emailCommentsValidation = false;
        boolean emailActiveCheckboxLocator = false;
        boolean emailPrymaryCheckboxLocator = false;

        try {
            scrollToElement(By.cssSelector(emailAddressField(index)));
            int indexInt = Integer.parseInt(index);
            if (mass.get(indexInt).get("EmailAddress") != null) {
                String emailAddress = getAtribute(By.cssSelector(emailAddressField(index)),"value");
                emailAddressValidation = emailAddress.equals(mass.get(indexInt).get("EmailAddress"));
            }else{
                emailAddressValidation = true;
            }
            if (mass.get(indexInt).get("EmailType") != null) {
                String emailType = getText(By.cssSelector(emailTypeElement(index)));
                emailTypeValidation = emailType.equals(mass.get(indexInt).get("EmailType"));
            }else{
                emailTypeValidation = true;
            }
            if (mass.get(indexInt).get("EmailOptInMethod") != null) {
                String emailOptInMethod = getText(By.cssSelector(emailOptInMethodElement(index)));
                emailOptInMethodValidation = emailOptInMethod.equals(mass.get(indexInt).get("EmailOptInMethod"));
            }else{
                emailOptInMethodValidation = true;
            }
            if (mass.get(indexInt).get("EmailOptInStatus") != null) {
                String emailOptInStatus = getText(By.cssSelector(emailOptInStatusElement(index)));
                emailOptInStatusValidation = emailOptInStatus.equals(mass.get(indexInt).get("EmailOptInStatus"));
            }else{
                emailOptInStatusValidation=true;
            }
            if (mass.get(indexInt).get("EmailOptInDate") != null) {
                String emailOptInDate = getAtribute(By.cssSelector(emailOptInDateField(index)),"value");
                emailOptInDateValidation = emailOptInDate.equals(mass.get(indexInt).get("EmailOptInDate"));
            }else{
                emailOptInDateValidation = true;
            }
            if (mass.get(indexInt).get("EmailStatus") != null) {
                String emailStatus = getText(By.cssSelector(emailStatusElement(index)));
                emailStatusValidation = emailStatus.equals(mass.get(indexInt).get("EmailStatus"));
            }else{
                emailStatusValidation = true;
            }
            if (mass.get(indexInt).get("EmailComments") != null) {
                String emailComments = getText(By.cssSelector(emailCommentsField(index)));
                emailCommentsValidation = emailComments.equals(mass.get(indexInt).get("EmailComments"));
            }else{
                emailCommentsValidation = true;
            }
            switch (indexInt){
                case 0:
                    emailActiveCheckboxLocator = checkBoxIsActive(By.cssSelector(emailActiveCheckbox(index)));
                    break;
                case 1:
                    emailActiveCheckboxLocator = !checkBoxIsActive(By.cssSelector(emailActiveCheckbox(index)));
                    break;
                default: throw new IllegalArgumentException("Unhandled index. Update business logic");
            }

            switch (indexInt){
                case 0:
                    emailPrymaryCheckboxLocator = checkBoxIsActive(By.cssSelector(emailPrimaryCheckbox(index)));
                    break;
                case 1:
                    emailPrymaryCheckboxLocator = !checkBoxIsActive(By.cssSelector(emailPrimaryCheckbox(index)));
                    break;
                default: throw new IllegalArgumentException("Unhandled index. Update business logic");
            }
                if(emailAddressValidation
                    && emailTypeValidation
                    && emailOptInMethodValidation
                    && emailOptInStatusValidation
                    && emailOptInDateValidation
                    && emailStatusValidation
                    && emailCommentsValidation
                    && emailActiveCheckboxLocator
                    && emailPrymaryCheckboxLocator){
                    ExtentReportsSetUp.testingPass(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_PASS);
                }else{
                    FailureDelegatePage.handlePageException(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_FAIL);
                }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_EMAIL_PERSON_PAGE_RECORD_FAIL);
        }
    }
}
