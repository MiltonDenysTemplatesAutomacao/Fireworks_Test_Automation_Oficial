package steps.Records;

import io.cucumber.java.en.And;
import pages.Records.EducationPage;

public class EducationSteps {

    @And("I navigate to Education")
    public static void navigateToEducation() {
        EducationPage.navigateToEducation();
    }
    @And("I click on save changes in Education for person")
    public static void clickSaveChanges() {
        EducationPage.clickSaveChanges();
    }


}
