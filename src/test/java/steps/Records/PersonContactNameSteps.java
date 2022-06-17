package steps.Records;

import io.cucumber.java.en.Then;
import pages.Records.PersonContactNamePage;

public class PersonContactNameSteps {

    @Then("I verify name on contact for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void verifyName(String firstName,String lastName,String middleName,String preferredName,String suffix,String salutation,String active,String primary,String group) {
        PersonContactNamePage.verifyName(firstName,lastName,middleName,preferredName,suffix,salutation,active,primary,group );
    }
}
