package pages.Records;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonBasicPage extends BasePage {
    public static final String basicPanelHeadingElement = "#basic span";
    public static final String basicSectionHeaderElement = "#basic p";
    public static final String basicFieldLabelElement = "#basic label.control-label";

    public static final String birthXpath = "//*[@data-field-group-label='Birth']";
    public static final String cultureXpath = "//*[@data-field-group-label='Culture']";
    public static final String contextXpath = "//*[@data-field-group-label='Context']";
    public static final String citizenshipXpath = "//*[@data-field-group-label='Citizenship']";
    public static final String recordFlagsXpath = "//*[@data-field-group-label='Record Flags']";
    public static final String systemGeneratedXpath = "//*[@data-field-group-label='System Generated']";
    public static final String birthDateXpath = "//*[@for='birth_date']";
    public static final String countryOfCitizenshipXpath = "//*[@for='country_of_citizenship']";
    public static final String citizenshipTypeXpath = "//*[@for='citizenship_type']";
    public static final String ethnicityXpath = "//*[@for='ethnicity']";
    public static final String raceXpath = "//*[@for='race']";
    public static final String genderXpath = "//*[@for='gender']";
    public static final String maritalStatusXpath = "//*[@for='marital_status']";
    public static final String primaryLanguageXpath = "//*[@for='primary_language']";
    public static final String religionXpath = "//*[@for='religion']";
    public static final String timeZoneXpath = "//*[@for='time_zone']";
    public static final String classOfXpath = "//*[@for='class_of']";
    public static final String birthCountryXpath = "//*[@for='birth_country']";
    public static final String birthCityXpath = "//*[@for='birth_city']";
    public static final String birthStateXpath = "//*[@for='birth_state']";
    public static final String socialSecurityNumberXpath = "//*[@for='social_security_number']";
    public static final String highScore = "//*[@for='high_score']";
    public static final String originalGeomarketXpath = "//*[@for='original_geomarket']";
    public static final String studentFlagXpath = "//*[@for='person_flag']";
    public static final String internationalXpath = "//*[@for='international_student']";
    public static final String legacyXpath = "//*[@for='legacy']";
    public static final String stateResidentXpath = "//*[@for='state_resident']";
    public static final String deceasedXpath = "//*[@for='deceased']";
    public static final String veteranXpath = "//*[@for='veteran']";
    public static final String currentGradeXpath = "//*[@for='current_grade']";

    /*
     * section return list
     */
    public static String returnBasicSection(String section) {
        Map<String, String> basicSection = new HashMap<String, String>();
        basicSection.put("Birth", birthXpath);
        basicSection.put("Birth Date", birthDateXpath);
        basicSection.put("Culture", cultureXpath);
        basicSection.put("Context", contextXpath);
        basicSection.put("Record Flags", recordFlagsXpath);
        basicSection.put("Citizenship", citizenshipXpath);
        basicSection.put("System Generated", systemGeneratedXpath);
        basicSection.put("Citizenship Type", citizenshipTypeXpath);
        basicSection.put("Country of Citizenship", countryOfCitizenshipXpath);
        basicSection.put("Ethnicity", ethnicityXpath);
        basicSection.put("Race", raceXpath);
        basicSection.put("Gender", genderXpath);
        basicSection.put("Marital Status", maritalStatusXpath);
        basicSection.put("Primary Language", primaryLanguageXpath);
        basicSection.put("Religion", religionXpath);
        basicSection.put("Time Zone", timeZoneXpath);
        basicSection.put("Class Of", classOfXpath);
        basicSection.put("Birth Country", birthCountryXpath);
        basicSection.put("Birth City", birthCityXpath);
        basicSection.put("Birth State", birthStateXpath);
        basicSection.put("Social Security Number", socialSecurityNumberXpath);
        basicSection.put("High Score", highScore);
        basicSection.put("Original Geomarket", originalGeomarketXpath);
        basicSection.put("Student Flag", studentFlagXpath);
        basicSection.put("International", internationalXpath);
        basicSection.put("Legacy", legacyXpath);
        basicSection.put("State Resident", stateResidentXpath);
        basicSection.put("Deceased", deceasedXpath);
        basicSection.put("Veteran", veteranXpath);
        basicSection.put("Current Grade", currentGradeXpath);
        return basicSection.get(section);
    }
    /*
     * method to validate student basic fields that is displayed
     */
    public static void validateStudentBasicFields() {
        try {
            BasePage.waitElementBy(By.cssSelector(basicPanelHeadingElement), 20);
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
            String birthCountryReturnText = getText(By.xpath(birthCountryXpath));
            String birthCityReturn = returnBasicSection("Birth City");
            String birthCityReturnText = getText(By.xpath(birthCityXpath));
            String birthStateReturn = returnBasicSection("Birth State");
            String birthStateReturnText = getText(By.xpath(birthStateXpath));
            String citizenshipReturn = returnBasicSection("Citizenship");
            String citizenshipReturnText = getText(By.xpath(citizenshipXpath));
            String socialSecurityNumberReturn = returnBasicSection("Social Security Number");
            String socialSecurityNumberReturnText = getText(By.xpath(socialSecurityNumberXpath));
            String systemGeneratedReturn = returnBasicSection("System Generated");
            String systemGeneratedReturnText = getText(By.xpath(systemGeneratedXpath));
            String highScoreReturn = returnBasicSection("High Score");
            String highScoreReturnText = getText(By.xpath(highScore));
            String originalGeomarketReturn = returnBasicSection("Original Geomarket");
            String originalGeomarketReturnText = getText(By.xpath(originalGeomarketXpath));
            String classOfReturn = returnBasicSection("Class Of");
            String classOfReturnText = getText(By.xpath(classOfXpath));
            String currentGradeReturn = returnBasicSection("Current Grade");
            String currentGradeReturnText = getText(By.xpath(currentGradeXpath));
            String recordFlagsReturn = returnBasicSection("Record Flags");
            String recordFlagsReturnText = getText(By.xpath(recordFlagsXpath));
            String studentFlagReturn = returnBasicSection("Student Flag");
            String studentFlagReturnText = getText(By.xpath(studentFlagXpath));
            String internationalReturn = returnBasicSection("International");
            String internationalReturnText = getText(By.xpath(internationalXpath));
            String legacyReturn = returnBasicSection("Legacy");
            String legacyReturnText = getText(By.xpath(legacyXpath));
            String stateResidentReturn = returnBasicSection("State Resident");
            String StateResidentReturnText = getText(By.xpath(stateResidentXpath));

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
            //validate Basic Checkbox Label
            boolean basicCheckboxLabeValidation = false;
            if (deceasedReturnText.contains(mass.get(0).get("CheckboxLabel"))
                    && studentFlagReturnText.contains(mass.get(1).get("CheckboxLabel"))
                    && legacyReturnText.contains(mass.get(2).get("CheckboxLabel"))
                    && veteranReturnText.contains(mass.get(3).get("CheckboxLabel"))
                    && internationalReturnText.contains(mass.get(4).get("CheckboxLabel"))
                    && StateResidentReturnText.contains(mass.get(5).get("CheckboxLabel"))){
            basicCheckboxLabeValidation = true;
            }

            //Verify if all validations are true
            if(basicSectionValidation && basicFieldLabeValidation && basicCheckboxLabeValidation){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_STUDENT_BASIC_FIELDS_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_STUDENT_BASIC_FIELDS_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_STUDENT_BASIC_FIELDS_FAIL);
    }
    }

    /*
     * method to validate basic fields that is displayed
     */
    public static void returnAndValidateTextBasicFieldsLabel() {
        try {
            BasePage.waitElementBy(By.cssSelector(basicPanelHeadingElement), 20);
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
    public static void returnAndValidateElementsNotDisplayed() {
        try {

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
