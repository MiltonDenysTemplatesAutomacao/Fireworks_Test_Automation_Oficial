package pages;

import config.extent_reports.ExtentReportsSetUp;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Records.PersonContactPhonePage;
import pages.Records.StudentStatusPage;

import java.util.HashMap;
import java.util.List;

public class PersonPage extends BasePage{
    public static final String SUMMARY_LABEL = "recordNavTab_summary";
    public static final String SUMMARY_DISPLAY_EMAIL_ADDRESS = "//*[@for='summaryPanelField_64']";
    public static final String SUMMARY_DISPLAY_PERSON_CLASS_OF = "//*[@for='summaryPanelField_427']";
    public static final String SUMMARY_DISPLAY_PERSON_HIGH_SCORE = "//*[@for='summaryPanelField_406']";
    public static final String SUMMARY_DISPLAY_PERSON_INITIAL_CATEGORY = "//*[@for='summaryPanelField_592']";
    public static final String SUMMARY_DISPLAY_PERSON_INITIAL_SOURCE = "//*[@for='summaryPanelField_593']";
    public static final String SUMMARY_DISPLAY_STUDENT_STATUS_DATE = "//*[@for='summaryPanelField_240']";
    public static final String SUMMARY_EMAIL_EMAIL_ADDRESS_DELETE_BUTTON = "//*[@id='summaryPanelFieldBlock_64']/div[2]/div/div/button";
    public static final String SUMMARY_PERSON_CLASS_OF_DELETE_BUTTON = "//*[@id='summaryPanelFieldBlock_427']/div[2]/div/div/button";
    public static final String SUMMARY_PERSON_HIGH_SCORE_DELETE_BUTTON = "//*[@id='summaryPanelFieldBlock_406']/div[2]/div/div/button";
    public static final String SUMMARY_PERSON_INITIAL_CATEGORY_DELETE_BUTTON = "//*[@id='summaryPanelFieldBlock_592']/div[2]/div/div/button";
    public static final String SUMMARY_PERSON_INITIAL_SOURCE_DELETE_BUTTON = "//*[@id='summaryPanelFieldBlock_593']/div[2]/div/div/button";
    public static final String SUMMARY_STUDENT_STATUS_DATE_DELETE_BUTTON = "//*[@id='summaryPanelFieldBlock_240']/div[2]/div/div/button";
    public static final String RECORD_NAV_TAB_ID_TYPES = "recordNavTab_id_types";
    private static final String SUMMARY_FIELD_DROPDOWN = "s2id_summaryFieldPickerEntityType1";
    private static final String SUMMARY_FIELD_DROPDOWN_LIST = "#select2-results-2";
    private static final String COMPOSER_FIRST_NAME_FIELD = "person_name_0_createPersonNameFirst";
    private static final String COMPOSER_LAST_NAME_FIELD =  "person_name_0_createPersonNameLast";
    private static final String COMPOSER_EMAIL_ADDRESS_FIELD = "entity_email_0_createPersonEmailAddress";
    private static final String COMPOSER_EMAIL_TYPE_DROPDOWN = "entity_email_0_createPersonEmailType_component";
    private static final String COMPOSER_EMAIL_TYPE_DROPDOWN_LIST = "entity_email_0_createPersonEmailType_dropdown_menu";
    private static final String COMPOSER_EMAIL_OPT_IN_METHOD_DROPDOWN = "entity_email_0_createPersonOptInMethod_component";
    private static final String COMPOSER_EMAIL_OPT_IN_METHOD_DROPDOWN_LIST = "entity_email_0_createPersonOptInMethod_dropdown_menu";
    private static final String COMPOSER_PHONE_NUMBER_FIELD = "entity_phone_0_createPersonPhoneNumber";
    private static final String COMPOSER_PHONE_TYPE_DROPDOWN = "entity_phone_0_createPersonPhoneType_component";
    private static final String COMPOSER_PHONE_TYPE_DROPDOWN_LIST = "entity_phone_0_createPersonPhoneType_dropdown_menu";
    private static final String COMPOSER_ADDRESS1_FIELD = "entity_address_0_createPersonAddress1";
    private static final String COMPOSER_ADDRESS2_FIELD = "entity_address_0_createPersonAddress2";
    private static final String COMPOSER_ADDRESS3_FIELD = "entity_address_0_createPersonAddress3";
    private static final String COMPOSER_ADDRESS4_FIELD = "entity_address_0_createPersonAddress4";
    private static final String COMPOSER_ADDRESS_CITY_FIELD = "entity_address_0_createPersonAddressCity";
    private static final String COMPOSER_ADDRESS_STATE_DROPDOWN = "entity_address_0_createPersonAddressState_component";
    private static final String COMPOSER_ADDRESS_STATE_DROPDOWN_LIST = "entity_address_0_createPersonAddressState_dropdown_menu";
    private static final String COMPOSER_ADDRESS_POSTAL_CODE_FIELD = "entity_address_0_createPersonAddressPostalCode";
    private static final String COMPOSER_ADDRESS_COUNTRY_DROPDOWN = "entity_address_0_createPersonAddressCountry_component";
    private static final String COMPOSER_ADDRESS_COUNTRY_DROPDOWN_LIST = "entity_address_0_createPersonAddressCountry_dropdown_menu";
    private static final String COMPOSER_ADDRESS_REGION_FIELD = "entity_address_0_createPersonAddressRegion";
    private static final String COMPOSER_ROLE_DROPDOWN = "createPersonPersonRole_component";
    private static final String COMPOSER_ROLE_DROPDOWN_LIST = "createPersonPersonRole_dropdown_menu";
    private static final String COMPOSER_STUDENT_TYPE_DROPDOWN = "createPersonStudentType_component";
    private static final String COMPOSER_STUDENT_TYPE_DROPDOWN_LIST = "createPersonStudentType_dropdown_menu";
    private static final String COMPOSER_STUDENT_STATUS_CATEGORY_DROPDOWN = "person_student_status_0_createPersonStudentStatusCategory_component";
    private static final String COMPOSER_STUDENT_STATUS_CATEGORY_DROPDOWN_LIST = "person_student_status_0_createPersonStudentStatusCategory_dropdown_menu";
    private static final String COMPOSER_STUDENT_STATUS_DROPDOWN = "person_student_status_0_createPersonStudentStatus_component";
    private static final String COMPOSER_STUDENT_STATUS_DROPDOWN_LIST = "person_student_status_0_createPersonStudentStatus_dropdown_menu";
    private static final String COMPOSER_STUDENT_STATUS_DATE_FIELD = "person_student_status_0_createPersonStudentStatusDate";
    private static final String COMPOSER_STUDENT_STATUS_ENTRY_TERM_DROPDOWN = "person_student_status_0_createPersonStatusEntryTerm_component";
    private static final String COMPOSER_STUDENT_STATUS_ENTRY_TERM_DROPDOWN_LIST = "person_student_status_0_createPersonStatusEntryTerm_dropdown_menu";
    private static final String HEADER_DELETE_BUTTON = "personHeaderDeleteButton";
    private static final String DELETE_PERSON_CONFIRM_MODAL_LABEL = "deletePersonConfirmModalLabel";
    private static final String DELETE_PERSON_CONFIRM_SUBMIT_BUTTON = "modalSubmitButtondeletePersonConfirm";
    private static final String DATATABLE_EMPTY = "peopleManagerTable_row_0_col_0";
    private static final String QUICK_SEARCH_EMPTY = "quickSearchManagerTable_row_0_col_0";
    private static final String HEADER_STUDENT_STATUS_DISPLAY = "#descriptionObjectStudentStatusLabel";
    private static final String HEADER_ENTRY_TERM_DISPLAY = "#descriptionObjectEntryTermLabel";
    private static final String RECORD_NAV_TAB_BASIC = "recordNavTab_basic";
    private static final String CITIZENSHIP_TYPE_DROPDOWN = "#s2id_citizenship_type";
    private static final String CITIZENSHIP_TYPE_DROPDOWN_LIST = "#select2-results-21";
    private static final String CITIZENSHIP_COUNTRY_DROPDOWN = "#s2id_country_of_citizenship";
    private static final String CITIZENSHIP_COUNTRY_DROPDOWN_LIST = "#select2-results-22";
    private static final String SOCIAL_SECURITY_NUMBER_FIELD = "#social_security_number";
    private static final String PERSON_BASIC_SAVE_CHANGES_BUTTON = "saveChangesBtnPersonBasic";
    private static final String FIRST_NAME_FIELD = "person_name_0_name_first";
    private static final String LAST_NAME_FIELD = "person_name_0_name_last";
    private static final String MIDDLE_NAME_FIELD = "person_name_0_name_middle";
    private static final String PREFERRED_NAME_FIELD = "person_name_0_preferred_name";
    private static final String SUFFIX_DROPDOWN = "#person_name_0_name_suffix_toggle";
    private static final String SUFFIX_DROPDOWN_LIST = "#person_name_0_name_suffix_dropdown_menu";
    private static final String SALUTATION_DROPDOWN = "#person_name_0_salutation_toggle";
    private static final String SALUTATION_DROPDOWN_LIST = "#person_name_0_salutation_dropdown_menu";
    private static final String SAVE_CHANGES_BTN_PERSON_CONTACT = "saveChangesBtnPersonContact";
    private static final String TYPE_DROPDOWN = "#s2id_entity_external_id_0_id_type";
    private static final String TYPE_DROPDOWN_LIST = "#select2-drop";
    private static final String ID_NUMBER_FIELD = "#entity_external_id_0_id_number";
    private static final String ID_RECORDED_DATE_FIELD = "#entity_external_id_0_id_date";
    private static final String WHO_ADDED_ID_DROPDOWN = "#s2id_entity_external_id_0_id_user";
    private static final String WHO_ADDED_ID_DROPDOWN_LIST = "#select2-drop";
    private static final String COMMENTS_FIELD = "#entity_external_id_0_id_comments";
    private static final String PLUS_BUTTON_EXTERNAL_ID = "//*[@id='entity_external_id_0_add']";
    private static final String SAVE_CHANGES_BTN_PERSON_ID_TYPES = "saveChangesBtnPersonIdTypes";
    private static final String HEADER_ROLE_ELEMENT = "#personHeaderRoleButton";
    private static final String HEADER_ROLE_ELEMENT_LIST = ".//*[@class='btn-group autoSubmit dropDownSelect open']//*[@class='dropdown-menu']";
    private static final String HEADER_STUDENT_TYPE_ELEMENT = "#personHeaderStudentTypeButton";
    private static final String HEADER_ASSIGNED_STAFF_ELEMENT = "#personHeaderAssignedStaffButton";
    private static final String ACTIONS_LABEL = "recordNavTab_actions";
    private static final String BASIC_LABEL = "recordNavTab_basic";
    private static final String CONTACT_LABEL = "recordNavTab_contact";
    private static final String CUSTOM_FIELDS_LABEL = "recordNavTab_custom";
    private static final String EMPLOYMENT_LABEL = "recordNavTab_employment";
    private static final String ID_TYPES_LABEL = "recordNavTab_summary";
    private static final String RELATIONSHIP_LABEL = "recordNavTab_summary";
    private static final String INTERESTS_ACTIVITIES_LABEL = "recordNavTab_summary";
    private static final String APPLICATIONS_LABEL = "recordNavTab_summary";
    private static final String EDUCATION_LABEL = "recordNavTab_summary";
    private static final String INTERVIEWS_LABEL = "recordNavTab_summary";
    private static final String STUDENT_STATUS_LABEL = "recordNavTab_summary";
    private static final String DOCUMENTS_LABEL = "recordNavTab_summary";
    private static final String PEOPLE_MANAGER_TABLE = "#peopleManagerTable";
    private static final String PEOPLE_MANAGER_TABLE_SEARCH_FIELD = "#peopleManagerTableControlsTableSearch";
    private static final String PEOPLE_MANAGER_TABLE_ROW1_COL1_LINK = "#peopleManagerTable_row_0_col_0_link_0";
    private static final String HEADER_ROLE_DROPDOWN_OPTION3 = "div.btn-group.autoSubmit.dropDownSelect.open > ul > li:nth-child(3)";
    private static final String HEADER_ROLE_DROPDOWN_OPTION3_ACTIVE = "div.btn-group.autoSubmit.dropDownSelect.open > ul > li:nth-child(3).active";
    private static final String HEADER_ROLE_DROPDOWN_OPTION8 = "div.btn-group.autoSubmit.dropDownSelect.open > ul > li:nth-child(8)";
    private static final String HEADER_ROLE_DROPDOWN_OPTION8_ACTIVE = "div.btn-group.autoSubmit.dropDownSelect.open > ul > li:nth-child(8).active";
    private static final String HEADER_ROLE_DROPDOWN_OPTION9 = "div.btn-group.autoSubmit.dropDownSelect.open > ul > li:nth-child(9)";
    private static final String HEADER_ROLE_DROPDOWN_OPTION9_ACTIVE = "div.btn-group.autoSubmit.dropDownSelect.open > ul > li:nth-child(9).active";
    private static final String CREATE_PERSON_BUTTON = "top-controls-create-new-person";
    private static final String COMPOSER_SAVE_CHANGES_BUTTON = "saveChangesBtnPersonCreate";
    private static final String BIRTH_DATE = "#birth_date";
    private static final String BIRTH_CITY_FIELD = "#birth_city";
    private static final String BIRTH_COUNTRY_DROPDOWN = "div#s2id_birth_country.select2-container.form-control.select2 a.select2-choice";
    private static final String BIRTH_STATE_DROPDOWN = "div#s2id_birth_state.select2-container.form-control.select2 a.select2-choice";
    private static final String ETHNICITY_DROPDOWN = "div#s2id_ethnicity.select2-container.form-control.select2 a.select2-choice";
    private static final String RACE_DROPDOWN = "//div[@id='s2id_race']/ul/li/input";
    private static final String GENDER_DROPDOWN = "div#s2id_gender.select2-container.form-control.select2 a.select2-choice";
    private static final String MARITAL_STATUS_DROPDOWN = "div#s2id_marital_status.select2-container.form-control.select2 a.select2-choice";
    private static final String PRIMARY_LANGUAGE_DROPDOWN = "div#s2id_primary_language.select2-container.form-control.select2 a.select2-choice";
    private static final String RELIGION_DROPDOWN = "div#s2id_religion.select2-container.form-control.select2 a.select2-choice";
    private static final String INITIAL_CATEGORY_DROPDOWN = "div#s2id_person_initial_category.select2-container.form-control.select2 a.select2-choice";
    private static final String INITIAL_SOURCE_DROPDOWN = "div#s2id_person_initial_source.select2-container.form-control.select2 a.select2-choice";
    private static final String TIME_ZONE_DROPDOWN = "div#s2id_time_zone.select2-container.form-control.select2 a.select2-choice";
    private static final String CLASS_OF_DROPDOWN = "div#s2id_class_of.select2-container.form-control.select2 a.select2-choice";
    private static final String CURRENT_GRADE_DROPDOWN = "div#s2id_current_grade.form-control.select2 a.select2-choice";
    private static final String DECEASED_CHECKBOX = "#deceased";
    private static final String FIRST_GENERATION_CHECKBOX = "#first_generation";
    private static final String STUDENT_FLAG_CHECKBOX = "#person_flag";
    private static final String INTERNATIONAL_STUDENT_CHECKBOX = "#international_student";
    private static final String LEGACY_CHECKBOX = "#legacy";
    private static final String STATE_RESIDENT_CHECKBOX = "#state_resident";
    private static final String VETERAN_CHECKBOX = "#veteran";
    private static final String RACE_FIELD = "//*[@id='s2id_race']/ul";

    public static String emailComments(String index){
        return String.format("#entity_email_%s_email_comments",index);
    }
    private static String phoneNumberField(String index){
        return String.format("#entity_phone_%s_phone_number",index);
    }
    private static String phoneTypeElement(String index){
        return String.format("#entity_phone_%s_phone_type_component",index);
    }
    private static String phoneDropDown(String index){
        return String.format("#entity_phone_%s_phone_type_dropdown_menu",index);
    }



    private static String phoneStatusElement(String index){
        return String.format("#entity_phone_%s_phone_status_component",index);
    }
    private static String phoneTimeZoneElement(String index){
        return String.format("#entity_phone_%s_phone_time_zone_component",index);
    }
    private static String phoneOptInMethodElement(String index){
        return String.format("#entity_phone_%s_phone_number",index);
    }
    private static String phoneOptInStatusElement(String index){
        return String.format("#entity_phone_%s_text_messaging_opt_in_status_component",index);
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

    public static void createPhoneForPerson(String phoneNumber, String phoneType,String phoneStatus,String phoneOptInMethod, String phoneOptInStatus, String phoneComments, String active,String primary,String group){
        int createPhoneForPersonDelay = 20;
        try {
            if(phoneNumber!=""){
                scrollToElement(By.cssSelector(PersonContactPhonePage.phonePlusSignElement(group)));
                waitElementBy(By.cssSelector(phoneNumberField(group)),createPhoneForPersonDelay);
                write(By.cssSelector(phoneNumberField(group)), phoneNumber);
            }
            if(phoneType!=""){
                BasePage.click(By.cssSelector(phoneTypeElement(group)));
                BasePage.selectElementsList(By.cssSelector(phoneDropDown(group)), "a");
                clickOnListOfElements(phoneType);
            }
            if(phoneStatus!=""){

            }
            if(phoneOptInMethod!=""){

            }
            if(phoneOptInStatus!=""){

            }
            if(phoneComments!=""){

            }
            if(active!=""){

            }
            if(primary!=""){

            }
            ExtentReportsSetUp.testingPass(LogPage.CREATE_PHONE_FOR_PERSON_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_PHONE_FOR_PERSON_FAIL);
        }
    }
    public static void verifyRecordFlags(String deceased,String studentFlag,String firstGeneration,String internationalStudent,String legacy,String stateResident,String veteran){

        try {
            int verifyRecordFlagsDelay=20;

            boolean deceasedValidation = false;
            boolean studentFlagValidation = false;
            boolean firstGenerationValidation = false;
            boolean internationalStudentValidation = false;
            boolean legacyValidation = false;
            boolean stateResidentValidation = false;
            boolean veteranValidation = false;

            scrollToElement(By.cssSelector(CLASS_OF_DROPDOWN));

            switch (deceased){
                case "Deceased":
                    deceasedValidation = checkBoxIsActive(By.cssSelector(DECEASED_CHECKBOX));
                    break;
                case "":
                    deceasedValidation = !checkBoxIsActive(By.cssSelector(DECEASED_CHECKBOX));
                    break;
            }
            switch (studentFlag){
                case "Student Flag":
                    studentFlagValidation = checkBoxIsActive(By.cssSelector(STUDENT_FLAG_CHECKBOX));
                    break;
                case "":
                    studentFlagValidation = !checkBoxIsActive(By.cssSelector(STUDENT_FLAG_CHECKBOX));
                    break;
            }
            switch (firstGeneration){
                case "FirstGeneration":
                    firstGenerationValidation = checkBoxIsActive(By.cssSelector(FIRST_GENERATION_CHECKBOX));
                    break;
                case "":
                    firstGenerationValidation = !checkBoxIsActive(By.cssSelector(FIRST_GENERATION_CHECKBOX));
                    break;
            }
            switch (internationalStudent){
                case "InternationalStudent":
                    internationalStudentValidation = checkBoxIsActive(By.cssSelector(INTERNATIONAL_STUDENT_CHECKBOX));
                    break;
                case "":
                    internationalStudentValidation = !checkBoxIsActive(By.cssSelector(INTERNATIONAL_STUDENT_CHECKBOX));
                    break;
            }
            switch (legacy){
                case "Legacy":
                    legacyValidation = checkBoxIsActive(By.cssSelector(LEGACY_CHECKBOX));
                    break;
                case "":
                    legacyValidation = !checkBoxIsActive(By.cssSelector(LEGACY_CHECKBOX));
                    break;
            }
            switch (stateResident){
                case "StateResident":
                    stateResidentValidation = checkBoxIsActive(By.cssSelector(STATE_RESIDENT_CHECKBOX));
                    break;
                case "":
                    stateResidentValidation = !checkBoxIsActive(By.cssSelector(STATE_RESIDENT_CHECKBOX));
                    break;
            }
            switch (veteran){
                case "Veteran":
                    veteranValidation = checkBoxIsActive(By.cssSelector(VETERAN_CHECKBOX));
                    break;
                case "":
                    veteranValidation = !checkBoxIsActive(By.cssSelector(VETERAN_CHECKBOX));
                    break;
            }
            if(deceasedValidation
                && studentFlagValidation
                && firstGenerationValidation
                && internationalStudentValidation
                && legacyValidation
                && stateResidentValidation
                && veteranValidation){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_CONTEXT_VALUES_PASS);

            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_CONTEXT_VALUES_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_CONTEXT_VALUES_FAIL);
        }
    }


    public static void verifyContextValues(String timeZone, String classOf,String currentGrade){
        try {
            int verifyContextValuesDelay=20;
            boolean timeZoneValidation = false;
            boolean classOfValidation = false;
            boolean currentGradeValidation = false;
            scrollToElement(By.cssSelector(INITIAL_CATEGORY_DROPDOWN));

            String timeZoneText = getText(By.cssSelector(TIME_ZONE_DROPDOWN));
            String classOfText = getText(By.cssSelector(CLASS_OF_DROPDOWN));
            String currentGradeText = getText(By.cssSelector(CURRENT_GRADE_DROPDOWN));

            if(timeZone !=""){
                waitElementBy(By.cssSelector(INITIAL_CATEGORY_DROPDOWN),verifyContextValuesDelay);
                timeZoneValidation = timeZoneText.equals(timeZone);
            }else{
                timeZoneValidation=true;
            }
            if(classOf !=""){
                waitElementBy(By.cssSelector(CLASS_OF_DROPDOWN),verifyContextValuesDelay);
                classOfValidation = classOfText.equals(classOf);
            }else{
                classOfValidation=true;
            }
            if(currentGrade !=""){
                waitElementBy(By.cssSelector(CURRENT_GRADE_DROPDOWN),verifyContextValuesDelay);
                currentGradeValidation = currentGradeText.equals(currentGrade);
            }else{
                currentGradeValidation=true;
            }
            if(timeZoneValidation
                    && classOfValidation
                    && currentGradeValidation
            ){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_CONTEXT_VALUES_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_CONTEXT_VALUES_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_CONTEXT_VALUES_FAIL);
        }

    }
    public static void verifyInitialSourceValues(String initialCategory, String initialSource){
        try {
            int verifyInitialSourceValuesDelay=20;
            boolean initialCategoryValidation = false;
            boolean sourceTextValidation = false;
            scrollToElement(By.cssSelector(PRIMARY_LANGUAGE_DROPDOWN));

            String initialCategoryText = getText(By.cssSelector(INITIAL_CATEGORY_DROPDOWN));
            String initialSourceText = getText(By.cssSelector(INITIAL_SOURCE_DROPDOWN));

            if(initialCategory !=""){
                waitElementBy(By.cssSelector(INITIAL_CATEGORY_DROPDOWN),verifyInitialSourceValuesDelay);
                initialCategoryValidation = initialCategoryText.equals(initialCategory);
            }else{
                initialCategoryValidation=true;
            }
            if(initialSource !=""){
                waitElementBy(By.cssSelector(INITIAL_SOURCE_DROPDOWN),verifyInitialSourceValuesDelay);
                sourceTextValidation = initialSourceText.equals(initialSource);
            }else{
                sourceTextValidation=true;
            }
            if(initialCategoryValidation
                    && sourceTextValidation
                  ){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_INITIAL_SOURCE_VALUES_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_INITIAL_SOURCE_VALUES_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_INITIAL_SOURCE_VALUES_FAIL);
        }

    }


    public static void verifyCultureValues(String ethnicity,String race,String gender,String maritalStatus,String primaryLanguage, String religion){
        try {
            int verifyCultureValuesDelay = 20;
            boolean ethnicityValidation = false;
            boolean raceValidation = false;
            boolean genderValidation = false;
            boolean maritalStatusValidation = false;
            boolean primaryLanguageValidation = false;
            boolean religionValidation = false;

            scrollToElement(By.cssSelector(SOCIAL_SECURITY_NUMBER_FIELD));

            String ethnicityText = getText(By.cssSelector(ETHNICITY_DROPDOWN));
            String raceText = getText(By.xpath(RACE_FIELD));
            String genderText = getText(By.cssSelector(GENDER_DROPDOWN));
            String maritalStatusText = getText(By.cssSelector(MARITAL_STATUS_DROPDOWN));
            String primaryLanguageText = getText(By.cssSelector(PRIMARY_LANGUAGE_DROPDOWN));
            String religionText = getText(By.cssSelector(RELIGION_DROPDOWN));


            if(ethnicity !=""){
                waitElementBy(By.cssSelector(ETHNICITY_DROPDOWN),verifyCultureValuesDelay);
                ethnicityValidation = ethnicityText.contains(ethnicity);
            }else{
                ethnicityValidation=true;
            }
            if(race !=""){
                waitElementBy(By.xpath(RACE_FIELD),verifyCultureValuesDelay);
                raceValidation = raceText.contains(race);
            }else{
                raceValidation =true;
            }
            if(gender !=""){
                waitElementBy(By.cssSelector(GENDER_DROPDOWN),verifyCultureValuesDelay);
                genderValidation = genderText.contains(gender);
            }else{
                genderValidation=true;
            }
            if(maritalStatus !=""){
                waitElementBy(By.cssSelector(MARITAL_STATUS_DROPDOWN),verifyCultureValuesDelay);
                maritalStatusValidation = maritalStatusText.contains(maritalStatus);
            }else{
                maritalStatusValidation=true;
            }
            if(primaryLanguage !=""){
                waitElementBy(By.cssSelector(PRIMARY_LANGUAGE_DROPDOWN),verifyCultureValuesDelay);
                primaryLanguageValidation = primaryLanguageText.contains(primaryLanguage);
            }else{
                primaryLanguageValidation=true;
            }
            if(religion !=""){
                waitElementBy(By.cssSelector(RELIGION_DROPDOWN),verifyCultureValuesDelay);
                religionValidation = religionText.contains(religion);
            }else{
                religionValidation=true;
            }

            if(ethnicityValidation
                    && raceValidation
                    && genderValidation
                    && maritalStatusValidation
                    && primaryLanguageValidation
                    && religionValidation){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_CULTURE_VALUES_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_CULTURE_VALUES_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_CULTURE_VALUES_FAIL);
        }
    }
    public static void verifyCitizenship(String citizenshipType,String countryOfCitizenship,String ssn){
        try {
            int verifyCitizenshipDelay = 20;
            boolean citizenshipTypeValidation = false;
            boolean countryOfCitizenshipValidation = false;
            boolean ssnValidation = false;

            String citizenshipTypeText = getText(By.cssSelector(CITIZENSHIP_TYPE_DROPDOWN));
            String countryOfCitizenshipText = getText(By.cssSelector(CITIZENSHIP_COUNTRY_DROPDOWN));
            String ssnText = getAtribute(By.cssSelector(SOCIAL_SECURITY_NUMBER_FIELD),"value");
            scrollToElement(By.cssSelector(BIRTH_CITY_FIELD));

            if(citizenshipType !=""){
                waitElementBy(By.cssSelector(CITIZENSHIP_TYPE_DROPDOWN),verifyCitizenshipDelay);
                citizenshipTypeValidation = citizenshipTypeText.contains(citizenshipType);
            }else{
                citizenshipTypeValidation=true;
            }
            if(countryOfCitizenship!=""){
                waitElementBy(By.cssSelector(CITIZENSHIP_COUNTRY_DROPDOWN),verifyCitizenshipDelay);
                countryOfCitizenshipValidation = countryOfCitizenshipText.contains(countryOfCitizenship);
            }else{
                countryOfCitizenshipValidation=true;
            }
            if(ssn!=""){
                waitElementBy(By.cssSelector(SOCIAL_SECURITY_NUMBER_FIELD),verifyCitizenshipDelay);
                ssnValidation = ssnText.equals(ssn);
            }else{
                ssnValidation=true;
            }
            if(citizenshipTypeValidation && countryOfCitizenshipValidation && ssnValidation){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_CITIZENSHIP_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_CITIZENSHIP_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_CITIZENSHIP_FAIL);
        }
    }
    public static void verifyBirthValues(String date,String country,String city,String state){
        try {
            int verifyBirthValuesDelay = 20;
            boolean dateValidation = false;
            boolean countryValidation = false;
            boolean cityValidation = false;
            boolean stateValidation = false;

            String dateText = getAtribute(By.cssSelector(BIRTH_DATE),"value");
            String countryText = getText(By.cssSelector(BIRTH_COUNTRY_DROPDOWN));
            String cityText = getAtribute(By.cssSelector(BIRTH_CITY_FIELD),"value");
            String stateText = getText(By.cssSelector(BIRTH_STATE_DROPDOWN));
            if(date!=""){
                waitElementBy(By.cssSelector(BIRTH_DATE),verifyBirthValuesDelay);
                dateValidation = dateText.equals(date);
            }else{
                dateValidation=true;
            }
            if(country!=""){
                waitElementBy(By.cssSelector(BIRTH_COUNTRY_DROPDOWN),verifyBirthValuesDelay);
                countryValidation = countryText.equals(country);
            }else{
                countryValidation=true;
            }
            if(city!=""){
                waitElementBy(By.cssSelector(BIRTH_CITY_FIELD),verifyBirthValuesDelay);
                cityValidation = cityText.equals(city);
            }else{
                cityValidation=true;
            }
            if(state!=""){
                waitElementBy(By.cssSelector(BIRTH_STATE_DROPDOWN),verifyBirthValuesDelay);
                stateValidation = stateText.equals(state);
            }else{
                stateValidation=true;
            }
            if(dateValidation && countryValidation && cityValidation && stateValidation){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_BIRTH_VALUES_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_BIRTH_VALUES_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_BIRTH_VALUES_FAIL);
        }
    }
    public static void updateStudentRecordFlagValues(String deceased,String studentFlag,String firstGeneration,String internationalStudent,String legacy,String stateResident,String veteran){
        try {
            if(deceased!=""){
                scrollToElement(By.cssSelector(CURRENT_GRADE_DROPDOWN));
                click(By.cssSelector(DECEASED_CHECKBOX));
            }
            if(firstGeneration!=""){
                click(By.cssSelector(FIRST_GENERATION_CHECKBOX));
            }
            if(studentFlag!=""){
                click(By.cssSelector(STUDENT_FLAG_CHECKBOX));
            }
            if(internationalStudent!=""){
                click(By.cssSelector(INTERNATIONAL_STUDENT_CHECKBOX));
            }
            if(legacy!=""){
                click(By.cssSelector(LEGACY_CHECKBOX));
            }
            if(stateResident!=""){
                click(By.cssSelector(STATE_RESIDENT_CHECKBOX));
            }
            if(veteran!=""){
                click(By.cssSelector(VETERAN_CHECKBOX));
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_STUDENT_RECORD_FLAG_VALUES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_STUDENT_RECORD_FLAG_VALUES_FAIL);
        }
    }
    public static void updateContextValues(String timeZone, String classOf,String currentGrade){
        int updateContextValuesDelay = 20;
        try {
            if(timeZone!=""){
                scrollToElement(By.cssSelector(INITIAL_CATEGORY_DROPDOWN));
                waitElementBy(By.cssSelector(TIME_ZONE_DROPDOWN),updateContextValuesDelay);
                BasePage.click(By.cssSelector(TIME_ZONE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                wait(1000);
                clickOnListOfElements(timeZone);
            }
            if(classOf!=""){
                waitElementBy(By.cssSelector(CLASS_OF_DROPDOWN),updateContextValuesDelay);
                BasePage.click(By.cssSelector(CLASS_OF_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                wait(1000);
                clickOnListOfElements(classOf);
            }
            if(currentGrade!=""){
                waitElementBy(By.cssSelector(CURRENT_GRADE_DROPDOWN),updateContextValuesDelay);
                BasePage.click(By.cssSelector(CURRENT_GRADE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                wait(1000);
                clickOnListOfElements(currentGrade);
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_CONTEXT_VALUES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_CONTEXT_VALUES_FAIL);
        }

    }
    public static void updateInitialSourceValues(String initialCategory, String sourceText){
        try {
            if(initialCategory != ""){
                scrollToElement(By.cssSelector(PRIMARY_LANGUAGE_DROPDOWN));
                waitElementBy(By.cssSelector(INITIAL_CATEGORY_DROPDOWN),20);
                BasePage.click(By.cssSelector(INITIAL_CATEGORY_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                wait(1000);
                clickOnListOfElements(initialCategory);
            }
            if(sourceText != ""){
                waitElementBy(By.cssSelector(INITIAL_SOURCE_DROPDOWN),20);
                BasePage.click(By.cssSelector(INITIAL_SOURCE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                wait(1000);
                clickOnListOfElements(sourceText);
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_INITIAL_SOURCE_VALUES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_INITIAL_SOURCE_VALUES_FAIL);
        }
    }
    public static void updateCultureValues(String ethnicity,String race,String gender,String maritalStatus,String primaryLanguage, String religion){
        int updateCultureValuesDelay=20;

        try {
            if (ethnicity != ""){
                scrollToElement(By.cssSelector(BIRTH_STATE_DROPDOWN));
                waitElementBy(By.cssSelector(ETHNICITY_DROPDOWN),updateCultureValuesDelay);
                BasePage.click(By.cssSelector(ETHNICITY_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                wait(1000);
                clickOnListOfElements(ethnicity);
            }
            if (race != ""){
                waitElementBy(By.xpath(RACE_DROPDOWN),updateCultureValuesDelay);
                BasePage.click(By.xpath(RACE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                wait(1000);
                clickOnListOfElements(race);
            }
            if (gender != ""){
                waitElementBy(By.cssSelector(GENDER_DROPDOWN),updateCultureValuesDelay);
                BasePage.click(By.cssSelector(GENDER_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                wait(1000);
                clickOnListOfElements(gender);
            }
            if (maritalStatus != ""){
                waitElementBy(By.cssSelector(MARITAL_STATUS_DROPDOWN),updateCultureValuesDelay);
                BasePage.click(By.cssSelector(MARITAL_STATUS_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                wait(1000);
                clickOnListOfElements(maritalStatus);
            }
            if (primaryLanguage != ""){
                scrollToElement(By.cssSelector(ETHNICITY_DROPDOWN));
                waitElementBy(By.cssSelector(PRIMARY_LANGUAGE_DROPDOWN),updateCultureValuesDelay);
                BasePage.click(By.cssSelector(PRIMARY_LANGUAGE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                wait(1000);
                clickOnListOfElements(primaryLanguage);
            }
            if (religion != ""){
                waitElementBy(By.cssSelector(RELIGION_DROPDOWN),updateCultureValuesDelay);
                BasePage.click(By.cssSelector(RELIGION_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                wait(1000);
                clickOnListOfElements(religion);
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_CULTURE_VALUES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_CULTURE_VALUES_FAIL);

        }
    }
    public static void updateBirthValues(String date,String country,String city,String state){

        int updateBirthValuesDelay=20;
        try {
            if(date!=""){
                waitElementBy(By.cssSelector(BIRTH_DATE),updateBirthValuesDelay);
                write(By.cssSelector(BIRTH_DATE),date);
            }
            if(country!=""){
                waitElementBy(By.cssSelector(BIRTH_COUNTRY_DROPDOWN),updateBirthValuesDelay);
                BasePage.click(By.cssSelector(BIRTH_COUNTRY_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                wait(1000);
                clickOnListOfElements(country);
            }
            if(city!=""){
                waitElementBy(By.cssSelector(BIRTH_CITY_FIELD),updateBirthValuesDelay);
                write(By.cssSelector(BIRTH_CITY_FIELD),city);
            }
            if(state!=""){
                waitElementBy(By.cssSelector(BIRTH_STATE_DROPDOWN),updateBirthValuesDelay);
                BasePage.click(By.cssSelector(BIRTH_STATE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(StudentStatusPage.CHECKBOX_LIST), "a");
                wait(1000);
                clickOnListOfElements(state);
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_BIRTH_VALUES_PASS);

        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_BIRTH_VALUES_FAIL);
        }


    }
    private static String deleteSummaryList(String summary) {
        HashMap<String, String> deleteSummaryItem = new HashMap<>();
        deleteSummaryItem.put("Email Address", SUMMARY_EMAIL_EMAIL_ADDRESS_DELETE_BUTTON);
        deleteSummaryItem.put("Class Of", SUMMARY_PERSON_CLASS_OF_DELETE_BUTTON);
        deleteSummaryItem.put("High Score", SUMMARY_PERSON_HIGH_SCORE_DELETE_BUTTON);
        deleteSummaryItem.put("Initial Category", SUMMARY_PERSON_INITIAL_CATEGORY_DELETE_BUTTON);
        deleteSummaryItem.put("Initial Source", SUMMARY_PERSON_INITIAL_SOURCE_DELETE_BUTTON);
        deleteSummaryItem.put("Student Status Date", SUMMARY_STUDENT_STATUS_DATE_DELETE_BUTTON);
        return deleteSummaryItem.get(summary);

    }

    public static void deleteSummaryFields(String deleteSummaryField){
        String passMessage = String.format(LogPage.DELETE_SUMMARY_FIELDS_PASS, deleteSummaryField);
        String failMessage = String.format(LogPage.DELETE_SUMMARY_FIELDS_FAIL, deleteSummaryField);
        try {
            scrollToElement(By.id(SUMMARY_LABEL));
            waitUntilElementToBeSelected(By.xpath(deleteSummaryList(deleteSummaryField)),20);
            click(By.xpath(deleteSummaryList(deleteSummaryField)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static String summaryList(String summary){
        HashMap<String,String> summaryItem = new HashMap<>();
        summaryItem.put("Email Address",SUMMARY_DISPLAY_EMAIL_ADDRESS);
        summaryItem.put("Class Of",SUMMARY_DISPLAY_PERSON_CLASS_OF);
        summaryItem.put("High Score",SUMMARY_DISPLAY_PERSON_HIGH_SCORE);
        summaryItem.put("Initial Category",SUMMARY_DISPLAY_PERSON_INITIAL_CATEGORY);
        summaryItem.put("Initial Source",SUMMARY_DISPLAY_PERSON_INITIAL_SOURCE);
        summaryItem.put("Student Status Date",SUMMARY_DISPLAY_STUDENT_STATUS_DATE);
        return summaryItem.get(summary);

    }
    public static void verifySummaryData(String summaryData){
        String passMessage = String.format(LogPage.VERIFY_SUMMARY_DATA_PASS, summaryData);
        String failMessage = String.format(LogPage.VERIFY_SUMMARY_DATA_FAIL, summaryData);

        try {
            waitElementBy(By.xpath(summaryList(summaryData)),20);
            String summaryText = getText(By.xpath(summaryList(summaryData)));
            if(summaryText.contains(summaryData)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void addSummaryField(String summary){
        String passMessage = String.format(LogPage.ADD_SUMMARY_FIELD_PASS, summary);
        String failMessage = String.format(LogPage.ADD_SUMMARY_FIELD_FAIL, summary);
        try {
            waitUntilElementToBeSelected(By.id(SUMMARY_FIELD_DROPDOWN),20);
            click(By.id(SUMMARY_FIELD_DROPDOWN));
            waitElementBy(By.cssSelector(SUMMARY_FIELD_DROPDOWN_LIST),20);
            BasePage.selectElementsList(By.cssSelector(SUMMARY_FIELD_DROPDOWN_LIST), "a");
            clickOnListOfElements(summary);
            wait(500);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyStudentStatusLabel(String studentStatusLabel){
        String passMessage = String.format(LogPage.VERIFY_STUDENT_STATUS_LABEL_PASS, studentStatusLabel);
        String failMessage = String.format(LogPage.VERIFY_STUDENT_STATUS_LABEL_FAIL, studentStatusLabel);
        try {
            waitUntilElementPresence(By.cssSelector(HEADER_STUDENT_STATUS_DISPLAY),20);
            String studentStatusLabelText = getText(By.cssSelector(HEADER_STUDENT_STATUS_DISPLAY));
            if(studentStatusLabelText.contains(studentStatusLabel)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyEntryTermLabel(String entryTermLabel){
        String passMessage = String.format(LogPage.VERIFY_ENTRY_TERM_LABEL_PASS, entryTermLabel);
        String failMessage = String.format(LogPage.VERIFY_ENTRY_TERM_LABEL_FAIL, entryTermLabel);
        try {
            waitUntilElementPresence(By.cssSelector(HEADER_ENTRY_TERM_DISPLAY),20);
            String entryTermLabelText = getText(By.cssSelector(HEADER_ENTRY_TERM_DISPLAY));
            if(entryTermLabelText.contains(entryTermLabel)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateHeaderRole(String role){
        String errorMessage = String.format(LogPage.UPDATE_HEADER_ROLE_FAIL, role);
        String passMessage = String.format(LogPage.UPDATE_HEADER_ROLE_PASS, role);
        try {
            click(By.cssSelector(HEADER_ROLE_ELEMENT));
            BasePage.selectElementsList(By.xpath(HEADER_ROLE_ELEMENT_LIST), "a");
            clickOnListOfElements(role);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    public static void validateQuickSearchEmpty(String message){
        String errorMessage = String.format(LogPage.VALIDATE_QUICK_SEARCH_EMPTY_FAIL, message);
        String passMessage = String.format(LogPage.VALIDATE_QUICK_SEARCH_EMPTY_PASS, message);
        try {
            waitElementBy(By.id(QUICK_SEARCH_EMPTY),20);
            String messageQuickSearchEmpty = getText(By.id(QUICK_SEARCH_EMPTY));
            wait(3000);
            if(messageQuickSearchEmpty.equals(message)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    public static void validateDatatableMessage(String message){
        String errorMessage = String.format(LogPage.VALIDATE_DATATABLE_MESSAGE_FAIL, message);
        String passMessage = String.format(LogPage.VALIDATE_DATATABLE_MESSAGE_PASS, message);
        try {
            wait(2000);
            String messageDatatableEmpty = getText(By.id(DATATABLE_EMPTY));
            if(messageDatatableEmpty.equals(message)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }

    public static void deletePerson(){
        try {
            waitUntilElementToBeSelected(By.id(HEADER_DELETE_BUTTON),20);
            click(By.id(HEADER_DELETE_BUTTON));
            waitUntilElementToBeSelected(By.id(DELETE_PERSON_CONFIRM_MODAL_LABEL),20);
            click(By.id(DELETE_PERSON_CONFIRM_SUBMIT_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.DELETE_PERSON_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.DELETE_PERSON_FAIL);
        }
    }

    public static void updatePeopleComposer(DataTable data){
        int updatePeopleComposerDelay = 0;
        try {
            mass = data.asMaps(String.class, String.class);
            if (mass.get(0).get("FirstName") != null) {
                waitElementBy(By.id(COMPOSER_FIRST_NAME_FIELD),updatePeopleComposerDelay);
                BasePage.write(By.id(COMPOSER_FIRST_NAME_FIELD), mass.get(0).get("FirstName"));
            }
            if (mass.get(0).get("LastName") != null) {
                waitElementBy(By.id(COMPOSER_LAST_NAME_FIELD),updatePeopleComposerDelay);
                BasePage.write(By.id(COMPOSER_LAST_NAME_FIELD), mass.get(0).get("LastName"));
            }
            if (mass.get(0).get("EmailAddress") != null) {
                waitElementBy(By.id(COMPOSER_EMAIL_ADDRESS_FIELD),updatePeopleComposerDelay);
                BasePage.write(By.id(COMPOSER_EMAIL_ADDRESS_FIELD), mass.get(0).get("EmailAddress"));
            }
            if (mass.get(0).get("EmailType") != null) {
                waitElementBy(By.id(COMPOSER_EMAIL_TYPE_DROPDOWN),updatePeopleComposerDelay);
                BasePage.click(By.id(COMPOSER_EMAIL_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_EMAIL_TYPE_DROPDOWN_LIST), "a");
                wait(1000);
                clickOnListOfElements(mass.get(0).get("EmailType"));
            }
            scrollToElement(By.id(COMPOSER_EMAIL_ADDRESS_FIELD));
            if (mass.get(0).get("EmailOptInMethod") != null) {
                waitElementBy(By.id(COMPOSER_EMAIL_OPT_IN_METHOD_DROPDOWN),updatePeopleComposerDelay);
                BasePage.click(By.id(COMPOSER_EMAIL_OPT_IN_METHOD_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_EMAIL_OPT_IN_METHOD_DROPDOWN_LIST), "a");
                wait(2000);
                clickOnListOfElements(mass.get(0).get("EmailOptInMethod"));
            }
            if (mass.get(0).get("Phone") != null) {
                waitElementBy(By.id(COMPOSER_PHONE_NUMBER_FIELD),updatePeopleComposerDelay);
                BasePage.write(By.id(COMPOSER_PHONE_NUMBER_FIELD), mass.get(0).get("Phone"));
            }
            if (mass.get(0).get("PhoneType") != null) {
                waitElementBy(By.id(COMPOSER_PHONE_TYPE_DROPDOWN),updatePeopleComposerDelay);
                BasePage.click(By.id(COMPOSER_PHONE_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_PHONE_TYPE_DROPDOWN_LIST), "a");
                wait(2000);
                clickOnListOfElements(mass.get(0).get("PhoneType"));
            }
            scrollToElement(By.id(COMPOSER_PHONE_TYPE_DROPDOWN));
            if (mass.get(0).get("Address1") != null) {
                waitElementBy(By.id(COMPOSER_ADDRESS1_FIELD),updatePeopleComposerDelay);
                BasePage.write(By.id(COMPOSER_ADDRESS1_FIELD), mass.get(0).get("Address1"));
            }
            if (mass.get(0).get("Address2") != null) {
                waitElementBy(By.id(COMPOSER_ADDRESS2_FIELD),updatePeopleComposerDelay);
                BasePage.write(By.id(COMPOSER_ADDRESS2_FIELD), mass.get(0).get("Address2"));
            }
            if (mass.get(0).get("Address3") != null) {
                waitElementBy(By.id(COMPOSER_ADDRESS3_FIELD),updatePeopleComposerDelay);
                BasePage.write(By.id(COMPOSER_ADDRESS3_FIELD), mass.get(0).get("Address3"));
            }
            if (mass.get(0).get("Address4") != null) {
                waitElementBy(By.id(COMPOSER_ADDRESS4_FIELD),updatePeopleComposerDelay);
                BasePage.write(By.id(COMPOSER_ADDRESS4_FIELD), mass.get(0).get("Address4"));
            }
            if (mass.get(0).get("City") != null) {
                waitElementBy(By.id(COMPOSER_ADDRESS_CITY_FIELD),updatePeopleComposerDelay);
                BasePage.write(By.id(COMPOSER_ADDRESS_CITY_FIELD), mass.get(0).get("City"));
            }
            if (mass.get(0).get("State") != null) {
                waitElementBy(By.id(COMPOSER_ADDRESS_STATE_DROPDOWN),updatePeopleComposerDelay);
                BasePage.click(By.id(COMPOSER_ADDRESS_STATE_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_ADDRESS_STATE_DROPDOWN_LIST), "a");
                wait(2000);
                clickOnListOfElements(mass.get(0).get("State"));
            }
            if (mass.get(0).get("PostalCode") != null) {
                waitElementBy(By.id(COMPOSER_ADDRESS_POSTAL_CODE_FIELD),updatePeopleComposerDelay);
                BasePage.write(By.id(COMPOSER_ADDRESS_POSTAL_CODE_FIELD), mass.get(0).get("PostalCode"));
            }
            if (mass.get(0).get("Country") != null) {
                waitElementBy(By.id(COMPOSER_ADDRESS_COUNTRY_DROPDOWN),updatePeopleComposerDelay);
                BasePage.click(By.id(COMPOSER_ADDRESS_COUNTRY_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_ADDRESS_COUNTRY_DROPDOWN_LIST), "a");
                wait(2000);
                clickOnListOfElements(mass.get(0).get("Country"));
            }
            if (mass.get(0).get("Region") != null) {
                waitElementBy(By.id(COMPOSER_ADDRESS_REGION_FIELD),updatePeopleComposerDelay);
                BasePage.write(By.id(COMPOSER_ADDRESS_REGION_FIELD), mass.get(0).get("Region"));
            }
            scrollToElement(By.id(COMPOSER_ADDRESS_CITY_FIELD));
            if (mass.get(0).get("Role1") != null) {
                waitElementBy(By.id(COMPOSER_ROLE_DROPDOWN),20);
                BasePage.click(By.id(COMPOSER_ROLE_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_ROLE_DROPDOWN_LIST), "a");
                wait(2000);
                clickOnListOfElements(mass.get(0).get("Role1"));
            }
            if (mass.get(0).get("Role2") != null) {
                waitElementBy(By.id(COMPOSER_ROLE_DROPDOWN),20);
                BasePage.click(By.id(COMPOSER_ROLE_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_ROLE_DROPDOWN_LIST), "a");
                wait(2000);
                clickOnListOfElements(mass.get(0).get("Role2"));
            }
            if (mass.get(0).get("Role3") != null) {
                waitElementBy(By.id(COMPOSER_ROLE_DROPDOWN),20);
                BasePage.click(By.id(COMPOSER_ROLE_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_ROLE_DROPDOWN_LIST), "a");
                wait(2000);
                clickOnListOfElements(mass.get(0).get("Role3"));
            }
            if (mass.get(0).get("StudentType") != null) {
                waitElementBy(By.id(COMPOSER_STUDENT_TYPE_DROPDOWN),20);
                BasePage.click(By.id(COMPOSER_STUDENT_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_STUDENT_TYPE_DROPDOWN_LIST), "a");
                wait(2000);
                clickOnListOfElements(mass.get(0).get("StudentType"));
            }
            if (mass.get(0).get("StudentStatusCategory") != null) {
                waitElementBy(By.id(COMPOSER_STUDENT_STATUS_CATEGORY_DROPDOWN),20);
                BasePage.click(By.id(COMPOSER_STUDENT_STATUS_CATEGORY_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_STUDENT_STATUS_CATEGORY_DROPDOWN_LIST), "a");
                wait(2000);
                clickOnListOfElements(mass.get(0).get("StudentStatusCategory"));
            }
            if (mass.get(0).get("StudentStatus") != null) {
                waitElementBy(By.id(COMPOSER_STUDENT_STATUS_DROPDOWN),20);
                BasePage.click(By.id(COMPOSER_STUDENT_STATUS_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_STUDENT_STATUS_DROPDOWN_LIST), "a");
                wait(2000);
                clickOnListOfElements(mass.get(0).get("StudentStatus"));
            }
            if (mass.get(0).get("StudentStatusDate") != null) {
                waitElementBy(By.id(COMPOSER_STUDENT_STATUS_DATE_FIELD),20);
                BasePage.write(By.id(COMPOSER_STUDENT_STATUS_DATE_FIELD), mass.get(0).get("StudentStatusDate"));
            }
            if (mass.get(0).get("EntryTerm") != null) {
                waitElementBy(By.id(COMPOSER_STUDENT_STATUS_ENTRY_TERM_DROPDOWN),20);
                BasePage.click(By.id(COMPOSER_STUDENT_STATUS_ENTRY_TERM_DROPDOWN));
                BasePage.selectElementsList(By.id(COMPOSER_STUDENT_STATUS_ENTRY_TERM_DROPDOWN_LIST), "a");
                wait(2000);
                clickOnListOfElements(mass.get(0).get("EntryTerm"));
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_PEOPLE_COMPOSER_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_PEOPLE_COMPOSER_FAIL);
        }
    }

    public static void clickOnSaveNewRecord(){
        try {
            waitUntilElementToBeSelected(By.id(COMPOSER_SAVE_CHANGES_BUTTON),20);
            scrollToElement(By.id(COMPOSER_SAVE_CHANGES_BUTTON));
            click(By.id(COMPOSER_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_ON_SAVE_NEW_RECORD_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_ON_SAVE_NEW_RECORD_FAIL);
        }
    }

    public static void clickOnCreateRecord(){
        try {
            waitUntilElementToBeSelected(By.id(CREATE_PERSON_BUTTON),20);
            click(By.id(CREATE_PERSON_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_ON_CREATE_RECORD_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_ON_CREATE_RECORD_FAIL);
        }
    }

    public static void verifyAllthreeRolesAreSelected(){
        try {
            waitElementBy(By.cssSelector(HEADER_ROLE_ELEMENT),20);
            click(By.cssSelector(HEADER_ROLE_ELEMENT));

            String roleDropdown3 = getText(By.cssSelector(HEADER_ROLE_DROPDOWN_OPTION3));
            String roleDropdown3Active = getText(By.cssSelector(HEADER_ROLE_DROPDOWN_OPTION3_ACTIVE));
            boolean role1Person2Validation = false;
            if(roleDropdown3.equals(mass.get(1).get("Role1")) && roleDropdown3Active.equals(mass.get(1).get("Role1"))){
                role1Person2Validation=true;
            }
            String roleDropdown8 = getText(By.cssSelector(HEADER_ROLE_DROPDOWN_OPTION8));
            String roleDropdown8Active = getText(By.cssSelector(HEADER_ROLE_DROPDOWN_OPTION8_ACTIVE));
            boolean role1Person1Validation = false;
            if(roleDropdown8.equals(mass.get(0).get("Role1")) && roleDropdown8Active.equals(mass.get(0).get("Role1"))){
                role1Person1Validation=true;
            }
            String roleDropdown9 = getText(By.cssSelector(HEADER_ROLE_DROPDOWN_OPTION9));
            String roleDropdown9Active = getText(By.cssSelector(HEADER_ROLE_DROPDOWN_OPTION9_ACTIVE));
            boolean role2Person1Validation = false;
            if(roleDropdown9.equals(mass.get(0).get("Role2")) && roleDropdown9Active.equals(mass.get(0).get("Role2"))){
                role2Person1Validation=true;
            }

            if(role1Person2Validation && role1Person1Validation && role2Person1Validation){
                click(By.cssSelector(HEADER_ROLE_ELEMENT));
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_ALL_THREE_ROLES_ARE_SELECTED_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_ALL_THREE_ROLES_ARE_SELECTED_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_ALL_THREE_ROLES_ARE_SELECTED_FAIL);
        }
    }

    public static void openPeopleRecord(String search){
        searchPeopleManager(search);
        String passMessage = String.format(LogPage.OPEN_PEOPLE_RECORD_PASS, search);
        String failMessage = String.format(LogPage.OPEN_PEOPLE_RECORD_FAIL, search);
        try {
            waitElementBy(By.cssSelector(PEOPLE_MANAGER_TABLE_ROW1_COL1_LINK),20);
            click(By.cssSelector(PEOPLE_MANAGER_TABLE_ROW1_COL1_LINK));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void searchPeopleManager(String search){
        String passMessage = String.format(LogPage.SEARCH_PEOPLE_MANAGER_PASS, search);
        String failMessage = String.format(LogPage.SEARCH_PEOPLE_MANAGER_FAIL, search);
        try {
            waitElementBy(By.cssSelector(PEOPLE_MANAGER_TABLE),20);
            write(By.cssSelector(PEOPLE_MANAGER_TABLE_SEARCH_FIELD),search);
            wait(5000);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void verifyStudentRecordPanels(){
        try {
            waitUntilElementPresence(By.cssSelector(HEADER_STUDENT_TYPE_ELEMENT),20);
            String labelsText = getText(By.xpath(".//*[@class='nav nav-pills nav-stacked stickyNavPanels']"));

            if(labelsText.contains(mass.get(0).get("Labels"))
                && labelsText.contains(mass.get(1).get("Labels"))
                && labelsText.contains(mass.get(2).get("Labels"))
                && labelsText.contains(mass.get(3).get("Labels"))
                && labelsText.contains(mass.get(4).get("Labels"))
                && labelsText.contains(mass.get(5).get("Labels"))
                && labelsText.contains(mass.get(6).get("Labels"))
                && labelsText.contains(mass.get(7).get("Labels"))
                && labelsText.contains(mass.get(8).get("Labels"))
                && labelsText.contains(mass.get(9).get("Labels"))
                && labelsText.contains(mass.get(10).get("Labels"))
                && labelsText.contains(mass.get(11).get("Labels"))
                && labelsText.contains(mass.get(12).get("Labels"))
                && labelsText.contains(mass.get(13).get("Labels"))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_RECORD_PANELS_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_RECORD_PANELS_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_RECORD_PANELS_FAIL);
        }
    }
    public static void verifyHeaderAssignedStaff(String assignedStaff){
        String passMessage = String.format(LogPage.VERIFY_HEADER_ASSIGNED_STAFF_PASS, assignedStaff);
        String failMessage = String.format(LogPage.VERIFY_HEADER_ASSIGNED_STAFF_FAIL, assignedStaff);
        try {
            waitUntilElementPresence(By.cssSelector(HEADER_ASSIGNED_STAFF_ELEMENT),20);
            String assignedStaffText = getText(By.cssSelector(HEADER_ASSIGNED_STAFF_ELEMENT));
            if(assignedStaffText.contains(assignedStaff)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void verifyStudentType(String studentType){
        try {
            waitUntilElementPresence(By.cssSelector(HEADER_STUDENT_TYPE_ELEMENT),20);
            String studentTypeText = getText(By.cssSelector(HEADER_STUDENT_TYPE_ELEMENT));
            if(studentTypeText.contains(studentType)){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_STUDENT_TYPE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_STUDENT_TYPE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_STUDENT_TYPE_FAIL);
        }

    }

    public static void verifyHeaderRole(String headerRole){
        String passMessage = String.format(LogPage.VERIFY_HEADER_ROLE_PASS, headerRole);
        String failMessage = String.format(LogPage.VERIFY_HEADER_ROLE_FAIL, headerRole);

        try {
            waitUntilElementPresence(By.cssSelector(HEADER_ROLE_ELEMENT),20);
            switch (headerRole){
                case "Student":
                    String studentType = getText(By.cssSelector(HEADER_STUDENT_TYPE_ELEMENT));
                    String assignedStaff = getText(By.cssSelector(HEADER_ASSIGNED_STAFF_ELEMENT));
                    if(studentType.contains("Student Type")&& assignedStaff.contains("Assigned Staff")){
                        ExtentReportsSetUp.testingPass(passMessage);
                    }
                    break;
                case "Multiple":
                    String roleElement = getText(By.cssSelector(HEADER_ROLE_ELEMENT));
                    if(roleElement.contains(headerRole)){
                        ExtentReportsSetUp.testingPass(passMessage);
                    }
                    break;
                default:
                    List<WebElement> headerStudent = findElements(By.cssSelector(HEADER_STUDENT_TYPE_ELEMENT));
                    List<WebElement> headerStaff = findElements(By.cssSelector(HEADER_ASSIGNED_STAFF_ELEMENT));
                    if(headerStudent.isEmpty()&&headerStaff.isEmpty()){
                        ExtentReportsSetUp.testingPass(passMessage);
                    }
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void navigateToBasic(){
        try {
            BasePage.click(By.id(RECORD_NAV_TAB_BASIC));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_BASIC_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_BASIC_FAIL);
        }
    }

    public static void navigateToIdTypes(){
        wait(1000);
        try {
            scrollToElement(By.id(SUMMARY_LABEL));
            waitUntilElementToBeSelected(By.id(RECORD_NAV_TAB_ID_TYPES),20);
            BasePage.click(By.id(RECORD_NAV_TAB_ID_TYPES));
            ExtentReportsSetUp.testingPass(LogPage.NAVIGATE_TO_ID_TYPES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.NAVIGATE_TO_ID_TYPES_FAIL);
        }
    }

    public static void updateCitizenshipValues(String citizenshipType,String countryOfCitizenship,String ssn){
        try {
            waitElementBy(By.cssSelector(CITIZENSHIP_TYPE_DROPDOWN),20);
            if (citizenshipType != "") {
                scrollToElement(By.cssSelector(BIRTH_CITY_FIELD));
                BasePage.click(By.cssSelector(CITIZENSHIP_TYPE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(CITIZENSHIP_TYPE_DROPDOWN_LIST), "a");
                clickOnListOfElements(citizenshipType);
            }
            if (countryOfCitizenship != "") {
                BasePage.click(By.cssSelector(CITIZENSHIP_COUNTRY_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(CITIZENSHIP_COUNTRY_DROPDOWN_LIST), "a");
                clickOnListOfElements(countryOfCitizenship);
            }
            if (ssn != "") {
                BasePage.write(By.cssSelector(SOCIAL_SECURITY_NUMBER_FIELD), ssn);
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_CITIZENSHIP_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_CITIZENSHIP_FAIL);
        }
    }
    /*
     * to update names values values in contact tab on records
     */
    public static void updateNameValues(String firstName,String lastName,String middleName,String preferredName, String suffix, String salutation){
        try {
            waitElementBy(By.id(FIRST_NAME_FIELD),20);
            if (mass.get(0).get(firstName) != null) {
                BasePage.write(By.id(FIRST_NAME_FIELD), mass.get(0).get(firstName));
            }
            if (mass.get(0).get(lastName) != null) {
                BasePage.write(By.id(LAST_NAME_FIELD), mass.get(0).get(lastName));
            }
            if (mass.get(0).get(middleName) != null) {
                BasePage.write(By.id(MIDDLE_NAME_FIELD), mass.get(0).get(middleName));
            }
            if (mass.get(0).get(preferredName) != null) {
                BasePage.write(By.id(PREFERRED_NAME_FIELD), mass.get(0).get(preferredName));
            }
            if (mass.get(0).get(suffix) != null) {
                BasePage.click(By.cssSelector(SUFFIX_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(SUFFIX_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get(suffix));
            }
            if (mass.get(0).get(salutation) != null) {
                BasePage.click(By.cssSelector(SALUTATION_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(SALUTATION_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get(salutation));
            }
            saveChangesBtnPersonContact();
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_NAME_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_NAME_FAIL);
        }
    }
    /*
     * to update Id Types in contact tab on records
     */
    public static void updateExternalIdTypes(String type,String idNumber,String idRecordedDate,String whoAddedId, String comments){
        try {
            waitElementBy(By.cssSelector(TYPE_DROPDOWN),20);
            BasePage.scrollToElement(By.xpath(PLUS_BUTTON_EXTERNAL_ID));
            if (mass.get(0).get(type) != null) {
                BasePage.click(By.cssSelector(TYPE_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(TYPE_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get(type));
            }
            if (mass.get(0).get(idNumber) != null) {
                BasePage.write(By.cssSelector(ID_NUMBER_FIELD), mass.get(0).get(idNumber));
            }
            if (mass.get(0).get(idRecordedDate) != null) {
                BasePage.write(By.cssSelector(ID_RECORDED_DATE_FIELD), mass.get(0).get(idRecordedDate));
            }
            if (mass.get(0).get(whoAddedId) != null) {
                BasePage.click(By.cssSelector(WHO_ADDED_ID_DROPDOWN));
                BasePage.selectElementsList(By.cssSelector(WHO_ADDED_ID_DROPDOWN_LIST), "a");
                clickOnListOfElements(mass.get(0).get(whoAddedId));
            }
            if (mass.get(0).get(comments) != null) {
                BasePage.write(By.cssSelector(COMMENTS_FIELD), mass.get(0).get(comments));
            }
            saveChangesBtnPersonIdTypes();
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_EXTERNAL_ID_TYPES_PASS);

        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_EXTERNAL_ID_TYPES_FAIL);
        }
    }

    public static void saveChangesBtnPersonBasic(){
        try {
            waitElementBy(By.id(PERSON_BASIC_SAVE_CHANGES_BUTTON),20);
            BasePage.scrollToElement(By.id(PERSON_BASIC_SAVE_CHANGES_BUTTON));
            BasePage.click(By.id(PERSON_BASIC_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }

    public static void saveChangesBtnPersonContact(){
        try {
            waitElementBy(By.id(SAVE_CHANGES_BTN_PERSON_CONTACT),20);
            BasePage.scrollToElement(By.id(SAVE_CHANGES_BTN_PERSON_CONTACT));
            BasePage.click(By.id(SAVE_CHANGES_BTN_PERSON_CONTACT));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }

    public static void saveChangesBtnPersonIdTypes(){
        try {
            waitElementBy(By.id(SAVE_CHANGES_BTN_PERSON_ID_TYPES),20);
            BasePage.scrollToElement(By.id(SAVE_CHANGES_BTN_PERSON_ID_TYPES));
            BasePage.click(By.id(SAVE_CHANGES_BTN_PERSON_ID_TYPES));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }
}
