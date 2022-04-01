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
    public static final String studentFlagXpath = "//*[@for='student_flag']";
    public static final String internationalXpath = "//*[@for='international']";
    public static final String legacyXpath = "//*[@for='legacy']";
    public static final String stateResidentXpath = "//*[@for='state_resident']";
    public static final String deceasedXpath = "//*[@for='deceased']";
    public static final String veteranXpath = "//*[@for='veteran']";

    /*
     * section return list
     */
    public static String returnBasicSection(String section) {
        Map<String, String> basicSection = new HashMap<String, String>();
        basicSection.put("Birth", birthXpath);
        basicSection.put("Birth Date", birthDateXpath);
        basicSection.put("Culture", cultureXpath);
        basicSection.put("Context", contextXpath);
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
        return basicSection.get(section);
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

            if(birthReturnText.equals(mass.get(0).get("BasicSection"))
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
                && veteranReturnText.contains(mass.get(1).get("CheckboxLabel"))){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_BASIC_FIELDS_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_BASIC_FIELDS_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_BASIC_FIELDS_FAIL);
        }
    }
    /*
     * method to get an element if it exists or not
     */
    public static void returnAndValidateElementsNotDisplayed(){
        try {
            List<WebElement> basicNotDisplayedListOfElements;

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
            basicNotDisplayedListOfElements = findElements(By.xpath(birthCountryReturn));
            basicNotDisplayedListOfElements = findElements(By.xpath(birthCityReturn));
            basicNotDisplayedListOfElements = findElements(By.xpath(socialSecurityNumberReturn));
            basicNotDisplayedListOfElements = findElements(By.xpath(highScoreReturn));
            basicNotDisplayedListOfElements = findElements(By.xpath(originalGeomarketReturn));
            basicNotDisplayedListOfElements = findElements(By.xpath(studentFlagReturn));
            basicNotDisplayedListOfElements = findElements(By.xpath(InternationalReturn));
            basicNotDisplayedListOfElements = findElements(By.xpath(legacyReturn));
            basicNotDisplayedListOfElements = findElements(By.xpath(stateResidentReturn));

            if(basicNotDisplayedListOfElements.isEmpty()){
                ExtentReportsSetUp.testingPass(LogPage.VALIDATE_BASIC_NOT_DISPLAYED_FIELDS_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VALIDATE_BASIC_NOT_DISPLAYED_FIELDS_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VALIDATE_BASIC_NOT_DISPLAYED_FIELDS_FAIL);
        }
    }

}
