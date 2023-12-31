package pages.records.person;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.PersonPage;
import pages.MainPage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonBasicPage extends BasePage {
    public static final String BASIC_PANEL_HEADING_ELEMENT = "#basic span";
    public static final String basicSectionHeaderElement = "#basic p";
    public static final String basicFieldLabelElement = "#basic label.control-label";

    public static final String BIRTH_XPATH = "//*[@data-field-group-label='Birth']";
    public static final String CULTURE_XPATH = "//*[@data-field-group-label='Culture']";
    public static final String CONTEXT_XPATH = "//*[@data-field-group-label='Context']";
    public static final String CITIZENSHIP_XPATH = "//*[@data-field-group-label='Citizenship']";
    public static final String RECORD_FLAGS_XPATH = "//*[@data-field-group-label='Record Flags']";
    public static final String SYSTEM_GENERATED_XPATH = "//*[@data-field-group-label='System Generated']";
    public static final String BIRTH_DATE_XPATH = "//*[@for='birth_date']";
    public static final String COUNTRY_OF_CITIZENSHIP_XPATH = "//*[@for='country_of_citizenship']";
    public static final String CITIZENSHIP_TYPE_XPATH = "//*[@for='citizenship_type']";
    public static final String ETHNICITY_XPATH = "//*[@for='ethnicity']";
    public static final String RACE_XPATH = "//*[@for='race']";
    public static final String GENDER_XPATH = "//*[@for='gender']";
    public static final String MARITAL_STATUS_XPATH = "//*[@for='marital_status']";
    public static final String PRIMARY_LANGUAGE_XPATH = "//*[@for='primary_language']";
    public static final String RELIGION_XPATH = "//*[@for='religion']";
    public static final String TIME_ZONE_XPATH = "//*[@for='time_zone']";
    public static final String CLASS_OF_XPATH = "//*[@for='class_of']";
    public static final String BIRTH_COUNTRY_XPATH = "//*[@for='birth_country']";
    public static final String BIRTH_CITY_XPATH = "//*[@for='birth_city']";
    public static final String BIRTH_STATE_XPATH = "//*[@for='birth_state']";
    public static final String SOCIAL_SECURITY_NUMBER_XPATH = "//*[@for='social_security_number']";
    public static final String HIGH_SCORE = "//*[@for='high_score']";
    public static final String ORIGINAL_GEOMARKET_XPATH = "//*[@for='original_geomarket']";
    public static final String STUDENT_FLAG_XPATH = "//*[@for='person_flag']";
    public static final String INTERNATIONAL_XPATH = "//*[@for='international_student']";
    public static final String LEGACY_XPATH = "//*[@for='legacy']";
    public static final String STATE_RESIDENT_XPATH = "//*[@for='state_resident']";
    public static final String DECEASED_XPATH = "//*[@for='deceased']";
    public static final String VETERAN_XPATH = "//*[@for='veteran']";
    public static final String CURRENT_GRADE_XPATH = "//*[@for='current_grade']";
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
    private static final String ORIGINAL_GEOMARKET_DROPDOWN = "div#s2id_original_geomarket.select2-container.form-control.select2 a.select2-choice";
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
    private static final String CITIZENSHIP_TYPE_DROPDOWN = "#s2id_citizenship_type";
    private static final String CITIZENSHIP_TYPE_DROPDOWN_LIST = "#select2-results-21";
    private static final String CITIZENSHIP_COUNTRY_DROPDOWN = "#s2id_country_of_citizenship";
    private static final String CITIZENSHIP_COUNTRY_DROPDOWN_LIST = "#select2-results-22";
    private static final String SOCIAL_SECURITY_NUMBER_FIELD = "#social_security_number";
    private static final String PERSON_BASIC_SAVE_CHANGES_BUTTON = "saveChangesBtnPersonBasic";
    private static final String FIREWORKS_ID = "#person_hashid";
    private static final String HIGH_SCORE_FIELD = "#high_score";


    public static void updatePersonRecordFlagValues(String flagDeceased,String flagVeteran){

        try {
            if(flagDeceased != ""){
                scrollToElement(By.cssSelector(DECEASED_CHECKBOX));
                scrollTo("-150");
                BasePage.click(By.cssSelector(DECEASED_CHECKBOX));
            }
            if(flagVeteran != ""){
                scrollToElement(By.cssSelector(VETERAN_CHECKBOX));
                scrollTo("-150");
                BasePage.click(By.cssSelector(VETERAN_CHECKBOX));
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_PERSON_RECORD_FLAG_VALUES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_PERSON_RECORD_FLAG_VALUES_FAIL);
        }
    }

    public static void verifySystemGeneratedValues(String fireworksID,String highScore){
        try {
            if(MainPage.verifyGetText(By.cssSelector(FIREWORKS_ID),fireworksID)
                && MainPage.verifyGetAttribute(By.cssSelector(HIGH_SCORE_FIELD),highScore)){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_SYSTEM_GENERATED_VALUES_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_SYSTEM_GENERATED_VALUES_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_SYSTEM_GENERATED_VALUES_FAIL);
        }
    }
    public static void updateCitizenshipValues(String citizenshipType,String countryOfCitizenship,String ssn){
        try {
            if (citizenshipType != "") {
                MainPage.clickOptionList(By.cssSelector(CITIZENSHIP_TYPE_DROPDOWN),
                        citizenshipType,
                        By.cssSelector(CITIZENSHIP_TYPE_DROPDOWN_LIST));
            }
            if (countryOfCitizenship != "") {
                MainPage.clickOptionList(By.cssSelector(CITIZENSHIP_COUNTRY_DROPDOWN),
                        countryOfCitizenship,
                        By.cssSelector(CITIZENSHIP_COUNTRY_DROPDOWN_LIST));
            }
            if (ssn != "") {
                MainPage.fillField(By.cssSelector(SOCIAL_SECURITY_NUMBER_FIELD), ssn);
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_CITIZENSHIP_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_CITIZENSHIP_FAIL);
        }
    }

    public static void verifyRecordFlags(String deceased,String studentFlag,String firstGeneration,String internationalStudent,String legacy,String stateResident,String veteran){

        try {
            boolean deceasedValidation = false;
            boolean studentFlagValidation = false;
            boolean firstGenerationValidation = false;
            boolean internationalStudentValidation = false;
            boolean legacyValidation = false;
            boolean stateResidentValidation = false;
            boolean veteranValidation = false;

            scrollToElement(By.cssSelector(CLASS_OF_DROPDOWN));

            if(deceased!=""){
            switch (deceased){
                case "Deceased":
                    deceasedValidation = checkBoxIsActive(By.cssSelector(DECEASED_CHECKBOX));
                    break;
                case "":
                    deceasedValidation = !checkBoxIsActive(By.cssSelector(DECEASED_CHECKBOX));
                    break;
            }
            }else{
                deceasedValidation=true;
            }
            if(studentFlag!=""){
            switch (studentFlag){
                case "Student Flag":
                    studentFlagValidation = checkBoxIsActive(By.cssSelector(STUDENT_FLAG_CHECKBOX));
                    break;
                case "":
                    studentFlagValidation = !checkBoxIsActive(By.cssSelector(STUDENT_FLAG_CHECKBOX));
                    break;
            }
            }else{
                studentFlagValidation = true;
            }
            if(firstGeneration!=""){
            switch (firstGeneration){
                case "FirstGeneration":
                    firstGenerationValidation = checkBoxIsActive(By.cssSelector(FIRST_GENERATION_CHECKBOX));
                    break;
                case "":
                    firstGenerationValidation = !checkBoxIsActive(By.cssSelector(FIRST_GENERATION_CHECKBOX));
                    break;
            }}else{
                firstGenerationValidation=true;
            }
            if(internationalStudent!=""){
            switch (internationalStudent){
                case "InternationalStudent":
                    internationalStudentValidation = checkBoxIsActive(By.cssSelector(INTERNATIONAL_STUDENT_CHECKBOX));
                    break;
                case "":
                    internationalStudentValidation = !checkBoxIsActive(By.cssSelector(INTERNATIONAL_STUDENT_CHECKBOX));
                    break;
            }}else{
                internationalStudentValidation=true;
            }
            if(legacy!=""){
            switch (legacy){
                case "Legacy":
                    legacyValidation = checkBoxIsActive(By.cssSelector(LEGACY_CHECKBOX));
                    break;
                case "":
                    legacyValidation = !checkBoxIsActive(By.cssSelector(LEGACY_CHECKBOX));
                    break;
            }}else{
                legacyValidation=true;
            }
            if(stateResident!=""){
            switch (stateResident){
                case "StateResident":
                    stateResidentValidation = checkBoxIsActive(By.cssSelector(STATE_RESIDENT_CHECKBOX));
                    break;
                case "":
                    stateResidentValidation = !checkBoxIsActive(By.cssSelector(STATE_RESIDENT_CHECKBOX));
                    break;
            }}else{
                stateResidentValidation=true;
            }
            if(veteran!=""){
            switch (veteran){
                case "Veteran":
                    veteranValidation = checkBoxIsActive(By.cssSelector(VETERAN_CHECKBOX));
                    break;
                case "":
                    veteranValidation = !checkBoxIsActive(By.cssSelector(VETERAN_CHECKBOX));
                    break;
            }}else{
                veteranValidation=true;
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

    public static void verifyContextValues(String originalGeomarket, String timeZone, String classOf,String currentGrade){
        try {
            if(MainPage.verifyGetText(By.cssSelector(ORIGINAL_GEOMARKET_DROPDOWN),originalGeomarket)
                    && MainPage.verifyGetText(By.cssSelector(TIME_ZONE_DROPDOWN),timeZone)
                    && MainPage.verifyGetText(By.cssSelector(CLASS_OF_DROPDOWN),classOf)
                    && MainPage.verifyGetText(By.cssSelector(CURRENT_GRADE_DROPDOWN),currentGrade)){
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
            if(MainPage.verifyGetText(By.cssSelector(INITIAL_CATEGORY_DROPDOWN),initialCategory)
                    && MainPage.verifyGetText(By.cssSelector(INITIAL_SOURCE_DROPDOWN),initialSource)){
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
            if(MainPage.verifyGetText(By.cssSelector(ETHNICITY_DROPDOWN),ethnicity)
                    && MainPage.verifyGetText(By.xpath(RACE_FIELD),race)
                    && MainPage.verifyGetText(By.cssSelector(GENDER_DROPDOWN),gender)
                    && MainPage.verifyGetText(By.cssSelector(MARITAL_STATUS_DROPDOWN),maritalStatus)
                    && MainPage.verifyGetText(By.cssSelector(PRIMARY_LANGUAGE_DROPDOWN),primaryLanguage)
                    && MainPage.verifyGetText(By.cssSelector(RELIGION_DROPDOWN),religion)){
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
            if(MainPage.verifyGetText(By.cssSelector(CITIZENSHIP_TYPE_DROPDOWN),citizenshipType)
                    && MainPage.verifyGetText(By.cssSelector(CITIZENSHIP_COUNTRY_DROPDOWN),countryOfCitizenship)
                    && MainPage.verifyGetAttribute(By.cssSelector(SOCIAL_SECURITY_NUMBER_FIELD),ssn)){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_CITIZENSHIP_FAIL);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_CITIZENSHIP_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_CITIZENSHIP_FAIL);
        }
    }

    public static void verifyBirthValues(String date,String country,String city,String state){
        try {
            if(MainPage.verifyGetAttribute(By.cssSelector(BIRTH_DATE),date)
                    && MainPage.verifyGetText(By.cssSelector(BIRTH_COUNTRY_DROPDOWN),country)
                    && MainPage.verifyGetAttribute(By.cssSelector(BIRTH_CITY_FIELD),city)
                    && MainPage.verifyGetText(By.cssSelector(BIRTH_STATE_DROPDOWN),state)){
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
                MainPage.clickOptionList(By.cssSelector(TIME_ZONE_DROPDOWN),
                        timeZone,
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(classOf!=""){
                MainPage.clickOptionList(By.cssSelector(CLASS_OF_DROPDOWN),
                        classOf,
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(currentGrade!=""){
                MainPage.clickOptionList(By.cssSelector(CURRENT_GRADE_DROPDOWN),
                        currentGrade,
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_CONTEXT_VALUES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_CONTEXT_VALUES_FAIL);
        }
    }

    public static void updateInitialSourceValues(String initialCategory, String sourceText){
        try {
            if(initialCategory != ""){
                MainPage.clickOptionList(By.cssSelector(INITIAL_CATEGORY_DROPDOWN),
                        initialCategory,
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(sourceText != ""){
                MainPage.clickOptionList(By.cssSelector(INITIAL_SOURCE_DROPDOWN),
                        sourceText,
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_INITIAL_SOURCE_VALUES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_INITIAL_SOURCE_VALUES_FAIL);
        }
    }
    public static void saveChangesBtnPersonBasic(){
        try {
            MainPage.clickOption(By.id(PERSON_BASIC_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.SAVE_CHANGES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SAVE_CHANGES_FAIL);
        }
    }
    public static void updateCultureValues(String ethnicity,String race,String gender,String maritalStatus,String primaryLanguage, String religion){
        try {
            if (ethnicity != ""){
                MainPage.clickOptionList(By.cssSelector(ETHNICITY_DROPDOWN),
                        ethnicity,
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (race != ""){
                MainPage.clickOptionList(By.xpath(RACE_DROPDOWN),
                        race,
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (gender != ""){
                MainPage.clickOptionList(By.cssSelector(GENDER_DROPDOWN),
                        gender,
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (maritalStatus != ""){
                MainPage.clickOptionList(By.cssSelector(MARITAL_STATUS_DROPDOWN),
                        maritalStatus,
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (primaryLanguage != ""){
                MainPage.clickOptionList(By.cssSelector(PRIMARY_LANGUAGE_DROPDOWN),
                        primaryLanguage,
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (religion != ""){
                MainPage.clickOptionList(By.cssSelector(RELIGION_DROPDOWN),
                        religion,
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_CULTURE_VALUES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_CULTURE_VALUES_FAIL);
        }
    }

    public static void updateBirthValues(String date,String country,String city,String state) {
        try {
            if (date != "") {
                MainPage.fillDateField(By.cssSelector(BIRTH_DATE), date);
            }
            if (country != "") {
                MainPage.clickOptionList(By.cssSelector(BIRTH_COUNTRY_DROPDOWN),
                        country,
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if (city != "") {
                MainPage.fillField(By.cssSelector(BIRTH_CITY_FIELD), city);
            }
            if (state != "") {
                MainPage.clickOptionList(By.cssSelector(BIRTH_STATE_DROPDOWN),
                        state,
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_BIRTH_VALUES_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_BIRTH_VALUES_FAIL);
        }
    }

        /*
         * section return list
         */
        public static String returnBasicSection (String section){
            Map<String, String> basicSection = new HashMap<String, String>();
            basicSection.put("Birth", BIRTH_XPATH);
            basicSection.put("Birth Date", BIRTH_DATE_XPATH);
            basicSection.put("Culture", CULTURE_XPATH);
            basicSection.put("Context", CONTEXT_XPATH);
            basicSection.put("Record Flags", RECORD_FLAGS_XPATH);
            basicSection.put("Citizenship", CITIZENSHIP_XPATH);
            basicSection.put("System Generated", SYSTEM_GENERATED_XPATH);
            basicSection.put("Citizenship Type", CITIZENSHIP_TYPE_XPATH);
            basicSection.put("Country of Citizenship", COUNTRY_OF_CITIZENSHIP_XPATH);
            basicSection.put("Ethnicity", ETHNICITY_XPATH);
            basicSection.put("Race", RACE_XPATH);
            basicSection.put("Gender", GENDER_XPATH);
            basicSection.put("Marital Status", MARITAL_STATUS_XPATH);
            basicSection.put("Primary Language", PRIMARY_LANGUAGE_XPATH);
            basicSection.put("Religion", RELIGION_XPATH);
            basicSection.put("Time Zone", TIME_ZONE_XPATH);
            basicSection.put("Class Of", CLASS_OF_XPATH);
            basicSection.put("Birth Country", BIRTH_COUNTRY_XPATH);
            basicSection.put("Birth City", BIRTH_CITY_XPATH);
            basicSection.put("Birth State", BIRTH_STATE_XPATH);
            basicSection.put("Social Security Number", SOCIAL_SECURITY_NUMBER_XPATH);
            basicSection.put("High Score", HIGH_SCORE);
            basicSection.put("Original Geomarket", ORIGINAL_GEOMARKET_XPATH);
            basicSection.put("Student Flag", STUDENT_FLAG_XPATH);
            basicSection.put("International", INTERNATIONAL_XPATH);
            basicSection.put("Legacy", LEGACY_XPATH);
            basicSection.put("State Resident", STATE_RESIDENT_XPATH);
            basicSection.put("Deceased", DECEASED_XPATH);
            basicSection.put("Veteran", VETERAN_XPATH);
            basicSection.put("Current Grade", CURRENT_GRADE_XPATH);
            return basicSection.get(section);
        }
        /*
         * method to validate student basic fields that is displayed
         */
        public static void validateStudentBasicFields () {
            try {
                BasePage.waitElementBy(By.cssSelector(BASIC_PANEL_HEADING_ELEMENT), 20);
                //set to variables the text from each element
                String birthReturn = returnBasicSection("Birth");
                String birthReturnText = getText(By.xpath(birthReturn));
                String birthDateReturn = returnBasicSection("Birth Date");
                String birthDateReturnText = getText(By.xpath(birthDateReturn));
                String citizenshipTypeReturn = returnBasicSection("Citizenship Type");
                String citizenshipTypeReturnText = getText(By.xpath(citizenshipTypeReturn));
                String countryOfCitizenshipReturn = returnBasicSection("Country of Citizenship");
                String countryOfCitizenshipReturnText = getText(By.xpath(countryOfCitizenshipReturn));
                String ethnicityReturn = returnBasicSection("Ethnicity");
                String ethnicityReturnText = getText(By.xpath(ethnicityReturn));
                String raceReturn = returnBasicSection("Race");
                String raceReturnText = getText(By.xpath(raceReturn));
                String genderReturn = returnBasicSection("Gender");
                String genderReturnText = getText(By.xpath(genderReturn));
                String maritalStatusReturn = returnBasicSection("Marital Status");
                String maritalStatusReturnText = getText(By.xpath(maritalStatusReturn));
                String primaryLanguageReturn = returnBasicSection("Primary Language");
                String primaryLanguageReturnText = getText(By.xpath(primaryLanguageReturn));
                String religionReturn = returnBasicSection("Religion");
                String religionReturnText = getText(By.xpath(religionReturn));
                String cultureReturn = returnBasicSection("Culture");
                String cultureReturnText = getText(By.xpath(cultureReturn));
                String contextReturn = returnBasicSection("Context");
                String contextReturnText = getText(By.xpath(contextReturn));
                String timeZoneReturn = returnBasicSection("Time Zone");
                String timeZoneReturnText = getText(By.xpath(timeZoneReturn));
                String deceasedReturn = returnBasicSection("Deceased");
                String deceasedReturnText = getText(By.xpath(deceasedReturn));
                String veteranReturn = returnBasicSection("Veteran");
                String veteranReturnText = getText(By.xpath(veteranReturn));
                String birthCountryReturn = returnBasicSection("Birth Country");
                String birthCountryReturnText = getText(By.xpath(birthCountryReturn));
                String birthCityReturn = returnBasicSection("Birth City");
                String birthCityReturnText = getText(By.xpath(birthCityReturn));
                String birthStateReturn = returnBasicSection("Birth State");
                String birthStateReturnText = getText(By.xpath(birthStateReturn));
                String citizenshipReturn = returnBasicSection("Citizenship");
                String citizenshipReturnText = getText(By.xpath(citizenshipReturn));
                String socialSecurityNumberReturn = returnBasicSection("Social Security Number");
                String socialSecurityNumberReturnText = getText(By.xpath(socialSecurityNumberReturn));
                String systemGeneratedReturn = returnBasicSection("System Generated");
                String systemGeneratedReturnText = getText(By.xpath(systemGeneratedReturn));
                String highScoreReturn = returnBasicSection("High Score");
                String highScoreReturnText = getText(By.xpath(highScoreReturn));
                String originalGeomarketReturn = returnBasicSection("Original Geomarket");
                String originalGeomarketReturnText = getText(By.xpath(originalGeomarketReturn));
                String classOfReturn = returnBasicSection("Class Of");
                String classOfReturnText = getText(By.xpath(classOfReturn));
                String currentGradeReturn = returnBasicSection("Current Grade");
                String currentGradeReturnText = getText(By.xpath(currentGradeReturn));
                String recordFlagsReturn = returnBasicSection("Record Flags");
                String recordFlagsReturnText = getText(By.xpath(recordFlagsReturn));
                String studentFlagReturn = returnBasicSection("Student Flag");
                String studentFlagReturnText = getText(By.xpath(studentFlagReturn));
                String internationalReturn = returnBasicSection("International");
                String internationalReturnText = getText(By.xpath(internationalReturn));
                String legacyReturn = returnBasicSection("Legacy");
                String legacyReturnText = getText(By.xpath(legacyReturn));
                String stateResidentReturn = returnBasicSection("State Resident");
                String StateResidentReturnText = getText(By.xpath(stateResidentReturn));

                wait(1000);
                //validate Basic Section
                boolean basicSectionValidation = false;
                if (birthReturnText.equals(mass.get(0).get("BasicSection"))
                        && birthReturnText.equals(mass.get(0).get("BasicSection"))
                        && citizenshipReturnText.equals(mass.get(1).get("BasicSection"))
                        && cultureReturnText.equals(mass.get(2).get("BasicSection"))
                        && systemGeneratedReturnText.equals(mass.get(3).get("BasicSection"))
                        && contextReturnText.equals(mass.get(4).get("BasicSection"))
                        && recordFlagsReturnText.equals(mass.get(5).get("BasicSection"))) {
                    basicSectionValidation = true;
                }
                wait(1000);
                //validate Basic Field Label
                boolean basicFieldLabeValidation = false;
                if (birthDateReturnText.equals(mass.get(0).get("BasicFieldLabel"))
                        && currentGradeReturnText.equals(mass.get(1).get("BasicFieldLabel"))
                        && classOfReturnText.equals(mass.get(2).get("BasicFieldLabel"))
                        && timeZoneReturnText.equals(mass.get(3).get("BasicFieldLabel"))
                        && originalGeomarketReturnText.equals(mass.get(4).get("BasicFieldLabel"))
                        && highScoreReturnText.equals(mass.get(5).get("BasicFieldLabel"))
                        && birthCountryReturnText.equals(mass.get(6).get("BasicFieldLabel"))
                        && birthCityReturnText.equals(mass.get(7).get("BasicFieldLabel"))
                        && birthStateReturnText.equals(mass.get(8).get("BasicFieldLabel"))
                        && citizenshipTypeReturnText.equals(mass.get(9).get("BasicFieldLabel"))
                        && countryOfCitizenshipReturnText.equals(mass.get(10).get("BasicFieldLabel"))
                        && socialSecurityNumberReturnText.equals(mass.get(11).get("BasicFieldLabel"))
                        && ethnicityReturnText.equals(mass.get(12).get("BasicFieldLabel"))
                        && genderReturnText.equals(mass.get(13).get("BasicFieldLabel"))
                        && maritalStatusReturnText.equals(mass.get(14).get("BasicFieldLabel"))
                        && primaryLanguageReturnText.equals(mass.get(15).get("BasicFieldLabel"))
                        && raceReturnText.equals(mass.get(16).get("BasicFieldLabel"))
                        && religionReturnText.equals(mass.get(17).get("BasicFieldLabel"))) {
                    basicFieldLabeValidation = true;
                }
                wait(1000);
                //validate Basic Checkbox Label
                boolean basicCheckboxLabeValidation = false;
                if (deceasedReturnText.contains(mass.get(0).get("CheckboxLabel"))
                        && studentFlagReturnText.contains(mass.get(1).get("CheckboxLabel"))
                        && legacyReturnText.contains(mass.get(2).get("CheckboxLabel"))
                        && veteranReturnText.contains(mass.get(3).get("CheckboxLabel"))
                        && internationalReturnText.contains(mass.get(4).get("CheckboxLabel"))
                        && StateResidentReturnText.contains(mass.get(5).get("CheckboxLabel"))) {
                    basicCheckboxLabeValidation = true;
                }
                wait(1000);
                //Verify if all validations are true
                if (basicSectionValidation && basicFieldLabeValidation && basicCheckboxLabeValidation) {
                    ExtentReportsSetUp.testingPass(LogPage.VERIFY_STUDENT_BASIC_FIELDS_PASS);
                } else {
                    FailureDelegatePage.handlePageException(LogPage.VERIFY_STUDENT_BASIC_FIELDS_FAIL);
                }
            } catch (Exception e) {
                FailureDelegatePage.handlePageException(LogPage.VERIFY_STUDENT_BASIC_FIELDS_FAIL);
            }
        }

        /*
         * method to validate basic fields that is displayed
         */
        public static void returnAndValidateTextBasicFieldsLabel () {
            try {
                wait(4000);
                BasePage.waitElementBy(By.cssSelector(BASIC_PANEL_HEADING_ELEMENT), 20);
                //set to variables the text from each element
                String birthReturn = returnBasicSection("Birth");
                String birthReturnText = getText(By.xpath(birthReturn));
                String birthDateReturn = returnBasicSection("Birth Date");
                String birthDateReturnText = getText(By.xpath(birthDateReturn));
                String citizenshipTypeReturn = returnBasicSection("Citizenship Type");
                String citizenshipTypeReturnText = getText(By.xpath(citizenshipTypeReturn));
                String countryOfCitizenshipReturn = returnBasicSection("Country of Citizenship");
                String countryOfCitizenshipReturnText = getText(By.xpath(countryOfCitizenshipReturn));
                String ethnicityReturn = returnBasicSection("Ethnicity");
                String ethnicityReturnText = getText(By.xpath(ethnicityReturn));
                String raceReturn = returnBasicSection("Race");
                String raceReturnText = getText(By.xpath(raceReturn));
                String genderReturn = returnBasicSection("Gender");
                String genderReturnText = getText(By.xpath(genderReturn));
                String maritalStatusReturn = returnBasicSection("Marital Status");
                String maritalStatusReturnText = getText(By.xpath(maritalStatusReturn));
                String primaryLanguageReturn = returnBasicSection("Primary Language");
                String primaryLanguageReturnText = getText(By.xpath(primaryLanguageReturn));
                String religionReturn = returnBasicSection("Religion");
                String religionReturnText = getText(By.xpath(religionReturn));
                String cultureReturn = returnBasicSection("Culture");
                String cultureReturnText = getText(By.xpath(cultureReturn));
                String contextReturn = returnBasicSection("Context");
                String contextReturnText = getText(By.xpath(contextReturn));
                String timeZoneReturn = returnBasicSection("Time Zone");
                String timeZoneReturnText = getText(By.xpath(timeZoneReturn));
                String deceasedReturn = returnBasicSection("Deceased");
                String deceasedReturnText = getText(By.xpath(deceasedReturn));
                String veteranReturn = returnBasicSection("Veteran");
                String veteranReturnText = getText(By.xpath(veteranReturn));

                wait(4000);
                //validate Basic section and Basic fields label
                if (birthReturnText.equals(mass.get(0).get("BasicSection"))
                        && birthDateReturnText.equals(mass.get(0).get("BasicFieldLabel"))
                        && citizenshipTypeReturnText.equals(mass.get(1).get("BasicFieldLabel"))
                        && countryOfCitizenshipReturnText.equals(mass.get(2).get("BasicFieldLabel"))
                        && ethnicityReturnText.equals(mass.get(3).get("BasicFieldLabel"))
                        && raceReturnText.equals(mass.get(4).get("BasicFieldLabel"))
                        && genderReturnText.equals(mass.get(5).get("BasicFieldLabel"))
                        && maritalStatusReturnText.equals(mass.get(6).get("BasicFieldLabel"))
                        && primaryLanguageReturnText.equals(mass.get(7).get("BasicFieldLabel"))
                        && religionReturnText.equals(mass.get(8).get("BasicFieldLabel"))
                        && cultureReturnText.equals(mass.get(1).get("BasicSection"))
                        && contextReturnText.equals(mass.get(2).get("BasicSection"))
                        && timeZoneReturnText.equals(mass.get(9).get("BasicFieldLabel"))
                        && deceasedReturnText.contains(mass.get(0).get("CheckboxLabel"))
                        && veteranReturnText.contains(mass.get(1).get("CheckboxLabel"))) {
                    ExtentReportsSetUp.testingPass(LogPage.VALIDATE_BASIC_FIELDS_PASS);
                } else {
                    FailureDelegatePage.handlePageException(LogPage.VALIDATE_BASIC_FIELDS_FAIL);
                }
            } catch (Exception e) {
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_BASIC_FIELDS_FAIL);
            }
        }

        /*
         * method to get an element if it exists or not
         */
        public static void returnAndValidateElementsNotDisplayed () {
            try {
                wait(3000);
                //get xpath from each one of the Datatable values that is not supposed to be displayed
                String birthCountryReturn = returnBasicSection("Birth Country");
                String birthCityReturn = returnBasicSection("Birth City");
                String socialSecurityNumberReturn = returnBasicSection("Social Security Number");
                String highScoreReturn = returnBasicSection("High Score");
                String originalGeomarketReturn = returnBasicSection("Original Geomarket");
                String studentFlagReturn = returnBasicSection("Student Flag");
                String InternationalReturn = returnBasicSection("International");
                String legacyReturn = returnBasicSection("Legacy");
                String stateResidentReturn = returnBasicSection("State Resident");
                wait(2000);
                //set to a list if an element exists
                List<WebElement> birthCountryElements = findElements(By.xpath(birthCountryReturn));
                List<WebElement> birthCityElements = findElements(By.xpath(birthCityReturn));
                List<WebElement> socialSecurityNumberElements = findElements(By.xpath(socialSecurityNumberReturn));
                List<WebElement> highScoreElements = findElements(By.xpath(highScoreReturn));
                List<WebElement> originalGeomarketElements = findElements(By.xpath(originalGeomarketReturn));
                List<WebElement> studentFlagElements = findElements(By.xpath(studentFlagReturn));
                List<WebElement> InternationalElements = findElements(By.xpath(InternationalReturn));
                List<WebElement> legacyElements = findElements(By.xpath(legacyReturn));
                List<WebElement> stateResidentElements = findElements(By.xpath(stateResidentReturn));
                wait(2000);
                if (birthCountryElements.isEmpty()
                        && birthCityElements.isEmpty()
                        && socialSecurityNumberElements.isEmpty()
                        && highScoreElements.isEmpty()
                        && originalGeomarketElements.isEmpty()
                        && studentFlagElements.isEmpty()
                        && InternationalElements.isEmpty()
                        && legacyElements.isEmpty()
                        && stateResidentElements.isEmpty()) {
                    ExtentReportsSetUp.testingPass(LogPage.VALIDATE_BASIC_NOT_DISPLAYED_FIELDS_PASS);
                } else {
                    FailureDelegatePage.handlePageException(LogPage.VALIDATE_BASIC_NOT_DISPLAYED_FIELDS_FAIL);
                }
            } catch (Exception e) {
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_BASIC_NOT_DISPLAYED_FIELDS_FAIL);
            }
        }
    }
