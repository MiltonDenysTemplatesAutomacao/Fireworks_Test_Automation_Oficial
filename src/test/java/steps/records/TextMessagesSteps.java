package steps.records;

import io.cucumber.java.en.Then;
import pages.records.TextMessagesPage;

public class TextMessagesSteps {
    @Then("I click on create text button")
    public static void createTextMessage() {
        TextMessagesPage.createTextMessage();
    }
    @Then("I update start tab {string}, {string}, {string}, {string}")
    public static void updateStartTab(String name, String description,String smartSearch,String recipient) {
        TextMessagesPage.updateStartTab(name,description,smartSearch,recipient);
    }
    @Then("I update body tab {string}")
    public static void updateBodyTab(String content) {
        TextMessagesPage.updateBodyTab(content);
    }

}
