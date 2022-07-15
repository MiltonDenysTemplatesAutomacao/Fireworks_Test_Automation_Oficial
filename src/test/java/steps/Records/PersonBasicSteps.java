package steps.Records;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PersonPage;
import pages.Records.PersonBasicPage;

public class PersonBasicSteps {

    @Then("I verify basic fields labels")
    public static void verifyPersonBasicFieldLabels() {
        PersonBasicPage.returnAndValidateTextBasicFieldsLabel();
    }
    @Then("I validate not displayed fields are correct")
    public static void validateNotDisplayedFields() {
        PersonBasicPage.returnAndValidateElementsNotDisplayed();
    }
    @Then("I verify the Basic fields for a student record")
    public static void verifyStudentBasicFields() {
        PersonBasicPage.validateStudentBasicFields();
    }
    @Then("I update birth values {string}, {string}, {string}, {string}")
    public static void updateBirthValues(String date,String country,String city,String state) {
        PersonBasicPage.updateBirthValues(date,country,city,state);
    }
    @Then("I update culture values {string}, {string}, {string}, {string}, {string}, {string}")
    public static void updateCultureValues(String ethnicity,String race,String gender,String maritalStatus,String primaryLanguage, String religion) {
        PersonBasicPage.updateCultureValues(ethnicity,race,gender,maritalStatus,primaryLanguage,religion);
    }
    @Then("I click on save changes on basic")
    public static void saveChangesBtnPersonBasic() {
        PersonBasicPage.saveChangesBtnPersonBasic();
    }
    @Then("I update initial Source values {string}, {string}")
    public static void updateInitialSourceValues(String initialCategory, String sourceText){
        PersonBasicPage.updateInitialSourceValues(initialCategory,sourceText);
    }
    @Then("I update context values {string}, {string}, {string}")
    public static void updateContextValues(String timeZone, String classOf,String currentGrade){
        PersonBasicPage.updateContextValues(timeZone,classOf,currentGrade);
    }
    @Then("I update record flags {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public static void updateStudentRecordFlagValues(String deceased,String studentFlag,String firstGeneration,String internationalStudent,String legacy,String stateResident,String veteran){
        PersonBasicPage.updateStudentRecordFlagValues(deceased,studentFlag,firstGeneration,internationalStudent,legacy,stateResident,veteran);
    }
    @Then("I verify birth values {string}, {string}, {string}, {string}")
    public static void verifyBirthValues(String date,String country,String city,String state){
        PersonBasicPage.verifyBirthValues(date,country,city,state);
    }
    @When("I verify citizenship values {string}, {string} and {string}")
    public static void verifyCitizenship(String citizenshipType,String countryOfCitizenship,String ssn) {
        PersonBasicPage.verifyCitizenship(citizenshipType,countryOfCitizenship,ssn);
    }
    @Then("I verify culture values {string}, {string}, {string}, {string}, {string}, {string}")
    public static void verifyCultureValues(String ethnicity,String race,String gender,String maritalStatus,String primaryLanguage, String religion) {
        PersonBasicPage.verifyCultureValues(ethnicity,race,gender,maritalStatus,primaryLanguage,religion);
    }
    @Then("I verify initial Source values {string}, {string}")
    public static void verifyInitialSourceValues(String initialCategory, String initialSource){
        PersonBasicPage.verifyInitialSourceValues(initialCategory,initialSource);
    }
    @Then("I verify context values {string}, {string}, {string}, {string}")
    public static void verifyInitialSourceValues(String originalGeomarket,String timeZone, String classOf,String currentGrade){
        PersonBasicPage.verifyContextValues(originalGeomarket,timeZone,classOf,currentGrade);
    }
    @Then("I verify record flags {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public static void verifyRecordFlags(String deceased,String studentFlag,String firstGeneration,String internationalStudent,String legacy,String stateResident,String veteran){
        PersonBasicPage.verifyRecordFlags(deceased,studentFlag,firstGeneration,internationalStudent,legacy,stateResident,veteran);
    }
    @When("I update {string}, {string} and {string} to update citizenship")
    public static void updateCitizenship(String citizenshipType,String countryOfCitizenship,String ssn) {
        PersonBasicPage.updateCitizenshipValues(citizenshipType,countryOfCitizenship,ssn);
    }
    @When("I verify system generated values {string}, {string}")
    public static void verifySystemGeneratedValues(String fireworksID,String highScore) {
        PersonBasicPage.verifySystemGeneratedValues(fireworksID,highScore);
    }
}
