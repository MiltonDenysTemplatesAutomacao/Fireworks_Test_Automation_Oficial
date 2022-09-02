package pages;

import bean.ContactAddressBean;
import bean.ContactPhoneBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class StaffPage extends BasePage{
    public static final String STAFF_STATUS_RECORD = "staffHeaderRecordStatusButton";
    public static final String STAFF_PERMISSION_RECORD = ".//*[@class='btn-group autoSubmit dropDownSelect'][2]";
    private static final String CONTACT_PHONE_NUMBER_FIELD = "entity_phone_0_phone_number";
    private static final String CONTACT_PHONE_TYPE_DROPDOWN = "s2id_entity_phone_0_phone_type";
    private static final String CONTACT_PHONE_COMMENTS_FIELD = "entity_phone_0_phone_comments";
    private static final String STAFF_CONTACT_SAVE_CHANGES_BUTTON = "saveChangesBtnStaffContact";
    private static final String BASIC_PANEL_HEADING_ELEMENT = "#basic span";
    private static final String HEADER_STAFF_DELETE_BUTTON = "#deleteStaffButton";
    private static final String DELETE_STAFF_CONFIRM_SUBMIT_BUTTON = "#modalSubmitButtondeleteStaffConfirm";
    private static final String STAFF_MANAGER_TABLE_SEARCH_FIELD = "staffManagerTableControlsTableSearch";
    private static final String VALIDATE_STAFF_MANGER_DATATABLE_MESSAGE = "staffManagerTable_row_0_col_0";
    private static final String STAFF_ID_TYPES_SAVE_CHANGES_BUTTON = "saveChangesBtnStaffIdTypes";
    private static final String CONTACT_STATE_DROPDOWN_LIST = "#select2-results-10";
    private static final String CONTACT_COUNTRY_DROPDOWN_LIST = "#select2-results-11";
    private static final String CONTACT_ADDRESS_FIELD_DROPDOWN_LIST = "#select2-results-12";
    private static final String COUNTRY_SEARCH_FIELD = "#s2id_autogen11_search";
    private static final String STATE_SEARCH_FIELD = "#s2id_autogen10_search";

    private static String statusPlusSignElement(String index){
        return String.format("#user_external_ids_%s_add",index);
    }
    private static String idTypePrimaryCheckbox(String index){
        return String.format("#user_external_ids_%s_primary",index);
    }
    private static String typeDropdown(String index){
        return String.format("#s2id_user_external_ids_%s_user_id_type_id",index);
    }
    private static String idNumber(String index){
        return String.format("#user_external_ids_%s_user_id_number",index);
    }
    private static String idRecordedDate(String index){
        return String.format("#user_external_ids_%s_user_id_date",index);
    }
    private static String whoAddedID(String index){
        return String.format("#s2id_user_external_ids_%s_user_id_user_added_id",index);
    }
    private static String comments(String index){
        return String.format("#user_external_ids_%s_user_id_comments",index);
    }
    private static String contactAddress1Field(String index){
        return String.format("#entity_address_%s_address_1",index);
    }
    private static String contactAddress2Field(String index){
        return String.format("#2entity_address_%s_address_2",index);
    }
    private static String contactAddress3Field(String index){
        return String.format("#entity_address_%s_address_3",index);
    }
    private static String contactAddress4Field(String index){
        return String.format("#entity_address_%s_address_4",index);
    }
    private static String contactCityField(String index){
        return String.format("#entity_address_%s_address_city",index);
    }
    private static String contactStateDropdown(String index){
        return String.format("#s2id_entity_address_%s_address_state",index);
    }
    private static String contactRegionField(String index){
        return String.format("#entity_address_%s_address_region",index);
    }
    private static String contactCountryDropdown(String index){
        return String.format("#s2id_entity_address_%s_address_country",index);
    }
    private static String contactPostalCodeField(String index){
        return String.format("#entity_address_%s_address_postal_code",index);
    }
    private static String contactAddressTypeDropdown(String index){
        return String.format("#s2id_entity_address_%s_address_type",index);
    }
    private static String contactAddressCommentsField(String index){
        return String.format("#entity_address_%s_address_comments",index);
    }

    public static void verifyStaffPhoneNumber(ContactPhoneBean phone){
        try {
            if(MainPage.verifyGetAttribute(By.id(CONTACT_PHONE_NUMBER_FIELD),phone.getPhoneNumber())
                    && MainPage.verifyGetText(By.id(CONTACT_PHONE_TYPE_DROPDOWN),phone.getPhoneType())
                    && MainPage.verifyGetAttribute(By.id(CONTACT_PHONE_COMMENTS_FIELD),phone.getPhoneComments())){
                    ExtentReportsSetUp.testingPass(LogPage.VERIFY_STAFF_PHONE_NUMBER_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_STAFF_PHONE_NUMBER_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_STAFF_PHONE_NUMBER_FAIL);
        }
    }
    public static void createContactStaffAddress(ContactAddressBean address,String group){

        String passMessage = String.format(LogPage.CREATE_CONTACT_STAFF_ADDRESS_PASS,group);
        String failMessage = String.format(LogPage.CREATE_CONTACT_STAFF_ADDRESS_FAIL,group);
        try {
            if(address.getAddress1()!=""){
                MainPage.fillField(By.cssSelector(contactAddress1Field(group)), address.getAddress1());
            }
            if(address.getAddress2()!=""){
                MainPage.fillField(By.cssSelector(contactAddress2Field(group)), address.getAddress2());
            }
            if(address.getAddress3()!=""){
                MainPage.fillField(By.cssSelector(contactAddress3Field(group)), address.getAddress3());
            }
            if(address.getAddress4()!=""){
                MainPage.fillField(By.cssSelector(contactAddress4Field(group)), address.getAddress4());
            }
            if(address.getCity()!=""){
                MainPage.fillField(By.cssSelector(contactCityField(group)), address.getCity());
            }

            if(address.getState()!=""){
                MainPage.inputOptionField(By.cssSelector(contactStateDropdown(group)),
                        address.getState(),
                        By.cssSelector(STATE_SEARCH_FIELD));
            }
            if(address.getRegion()!=""){
                MainPage.fillField(By.cssSelector(contactRegionField(group)), address.getRegion());
            }
            if(address.getCountry()!=""){
                MainPage.inputOptionField(By.cssSelector(contactCountryDropdown(group)),
                        address.getCountry(),
                        By.cssSelector(COUNTRY_SEARCH_FIELD));
            }
            if(address.getPostalCode()!=""){
                MainPage.fillField(By.cssSelector(contactPostalCodeField(group)), address.getPostalCode());
            }
            if(address.getAddressType()!=""){
                MainPage.clickOptionList(By.cssSelector(contactAddressTypeDropdown(group)),
                        address.getAddressType(),
                        By.cssSelector(CONTACT_ADDRESS_FIELD_DROPDOWN_LIST));
            }
            if(address.getAddressComments()!=""){
                MainPage.fillField(By.cssSelector(contactAddressCommentsField(group)), address.getAddressComments());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void navigateToIdTypesStaffManager(){
        try {
            waitUntilElementToBeSelected(By.id(PersonNavPage.RECORD_NAV_TAB_ID_TYPES),20);
            BasePage.click(By.id(PersonNavPage.RECORD_NAV_TAB_ID_TYPES));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_ID_TYPES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }
    public static void validateIdTypes(String index, int person){

        String errorMessage = String.format(LogPage.VALIDATE_ID_TYPES_FAIL, index,person);
        String passMessage = String.format(LogPage.VALIDATE_ID_TYPES_PASS, index,person);

        try {
            if(MainPage.verifyGetText(By.cssSelector(typeDropdown(index)),mass.get(person).get("IDType"))
                    && MainPage.verifyGetAttribute(By.cssSelector(idNumber(index)),mass.get(person).get("IDNumber"))
                    && MainPage.verifyGetAttribute(By.cssSelector(idRecordedDate(index)),mass.get(person).get("IdRecordedDate"))
                    && MainPage.verifyGetText(By.cssSelector(comments(index)),mass.get(person).get("Comments"))
                    && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(idTypePrimaryCheckbox(index)),mass.get(person).get("Primary"))){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
                FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    public static void updateIdTypes(String index, int person){
        String errorMessage = String.format(LogPage.UPDATE_ID_TYPES_ORG_FAIL, index,person);
        String passMessage = String.format(LogPage.UPDATE_ID_TYPES_ORG_PASS, index,person);
        try {
            if (mass.get(person).get("IDType") != null) {
                MainPage.clickOptionList(By.cssSelector(typeDropdown(index)),
                        mass.get(person).get("IDType"),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (mass.get(person).get("IDNumber") != null) {
                MainPage.fillField(By.cssSelector(idNumber(index)), mass.get(person).get("IDNumber"));
            }
            if (mass.get(person).get("IdRecordedDate") != null) {
                MainPage.fillDateField(By.cssSelector(idRecordedDate(index)), mass.get(person).get("IdRecordedDate"));
            }
            if (mass.get(person).get("WhoAddedID") != null) {
                MainPage.clickOptionList(By.cssSelector(whoAddedID(index)),
                        mass.get(person).get("WhoAddedID"),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (mass.get(person).get("Comments") != null) {
                MainPage.fillField(By.cssSelector(comments(index)), mass.get(person).get("Comments"));
            }
            if (mass.get(person).get("Primary") != null) {
                MainPage.clickOption(By.cssSelector(idTypePrimaryCheckbox(index)));
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    public static void saveChangesBtnStaffIdTypes(){
        try {
            waitElementBy(By.id(STAFF_ID_TYPES_SAVE_CHANGES_BUTTON),20);
            BasePage.scrollToElement(By.id(STAFF_ID_TYPES_SAVE_CHANGES_BUTTON));
            BasePage.click(By.id(STAFF_ID_TYPES_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }

    public static void validateStaffMangerDatatableMessage(String message){
        String errorMessage = String.format(LogPage.VALIDATE_QUICK_SEARCH_EMPTY_FAIL, message);
        String passMessage = String.format(LogPage.VALIDATE_QUICK_SEARCH_EMPTY_PASS, message);
        try {
            if(MainPage.verifyGetText(By.id(VALIDATE_STAFF_MANGER_DATATABLE_MESSAGE),message)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
    public static void searchStaffManager(String search){
        String passMessage = String.format(LogPage.SEARCH_STAFF_MANAGER_PASS, search);
        String failMessage = String.format(LogPage.SEARCH_STAFF_MANAGER_FAIL, search);
        try {
            waitElementBy(By.id(STAFF_MANAGER_TABLE_SEARCH_FIELD),20);
            write(By.id(STAFF_MANAGER_TABLE_SEARCH_FIELD),mass.get(0).get(search));
            wait(2000);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void deleteStaff(){
        try {
            waitElementBy(By.cssSelector(HEADER_STAFF_DELETE_BUTTON),20);
            BasePage.click(By.cssSelector(HEADER_STAFF_DELETE_BUTTON));
            waitElementBy(By.cssSelector(DELETE_STAFF_CONFIRM_SUBMIT_BUTTON),20);
            BasePage.click(By.cssSelector(DELETE_STAFF_CONFIRM_SUBMIT_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.DELETE_STAFF_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.DELETE_STAFF_FAIL);
        }
    }

    public static void validateBasicElementIsVisible(){
        try {
            if(MainPage.verifyGetText(By.cssSelector(BASIC_PANEL_HEADING_ELEMENT),"Basic")){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_BASIC_ELEMENT_IS_VISIBLE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_BASIC_ELEMENT_IS_VISIBLE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_BASIC_ELEMENT_IS_VISIBLE_FAIL);
        }
    }


    public static void verifyHeaderRecordStatus(String status){
        String passMessage = String.format(LogPage.VERIFY_HEADER_RECORD_STATUS_PASS, status);
        String failMessage = String.format(LogPage.VERIFY_HEADER_RECORD_STATUS_FAIL, status);
        try {
            if(MainPage.verifyGetText(By.id(STAFF_STATUS_RECORD),status)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyHeaderPermissions(String permission){
        String passMessage = String.format(LogPage.VERIFY_HEADER_PERMISSIONS_PASS, permission);
        String failMessage = String.format(LogPage.VERIFY_HEADER_PERMISSIONS_FAIL, permission);
        try {
            if(MainPage.verifyGetText(By.xpath(STAFF_PERMISSION_RECORD),permission)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void updatePhoneNumber(ContactPhoneBean phone){
        try {
            waitElementBy(By.id(CONTACT_PHONE_NUMBER_FIELD),20);
            if (phone.getPhoneNumber() !="") {
                MainPage.fillField(By.id(CONTACT_PHONE_NUMBER_FIELD), phone.getPhoneNumber());
            }
            if (phone.getPhoneType() !="") {
                MainPage.clickOptionList(By.id(CONTACT_PHONE_TYPE_DROPDOWN),
                        phone.getPhoneType(),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (phone.getPhoneComments() !="") {
                MainPage.fillField(By.id(CONTACT_PHONE_COMMENTS_FIELD), phone.getPhoneComments());
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_PHONE_NUMBER_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_PHONE_NUMBER_FAIL);
        }
    }
    /*
     * to save changes in contact tab on records
     */
    public static void saveChangesBtnStaffContact(){
        try {
            waitElementBy(By.id(STAFF_CONTACT_SAVE_CHANGES_BUTTON),20);
            BasePage.scrollToElement(By.id(STAFF_CONTACT_SAVE_CHANGES_BUTTON));
            BasePage.click(By.id(STAFF_CONTACT_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }
}
