package steps.Records;

import bean.ContactNameBean;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Records.PersonContactNamePage;

public class PersonContactNameSteps {

    @Then("I verify name on contact for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void verifyName(String firstName,String lastName,String middleName,String preferredName,String suffix,String salutation,String active,String primary,String group) {
        ContactNameBean contactName = new ContactNameBean();
        contactName.firstName = firstName;
        contactName.lastName = lastName;
        contactName.middleName = middleName;
        contactName.preferredName = preferredName;
        contactName.suffix = suffix;
        contactName.salutation = salutation;
        contactName.active = active;
        contactName.primary = primary;
        PersonContactNamePage.verifyName(contactName,group);
    }
    @And("I add a name group {string}")
    public static void addName(String group) {
        PersonContactNamePage.addName(group);
    }
    @And("I create a name on contact for person {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void createName(String firstName,String lastName,String middleName,String preferredName,String suffix,String salutation,String active,String primary,String group) {
        ContactNameBean contactName = new ContactNameBean();
        contactName.firstName = firstName;
        contactName.lastName = lastName;
        contactName.middleName = middleName;
        contactName.preferredName = preferredName;
        contactName.suffix = suffix;
        contactName.salutation = salutation;
        contactName.active = active;
        contactName.primary = primary;
        PersonContactNamePage.createName(contactName,group);
    }
}
