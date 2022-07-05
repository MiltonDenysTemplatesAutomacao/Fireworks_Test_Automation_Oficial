package steps.Records;

import io.cucumber.java.en.And;
import pages.Records.EducationPage;

public class EducationSteps {

    @And("I navigate to Education")
    public static void navigateToEducation() {
        EducationPage.navigateToEducation();
    }


}
