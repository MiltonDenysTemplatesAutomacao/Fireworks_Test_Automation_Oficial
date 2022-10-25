package steps;

import io.cucumber.java.en.When;
import pages.ChatPage;

public class ChatSteps {

    @When("I update email contact in setting chat page {string}")
    public static void updateEmailContact(String emailContact) {
        ChatPage.updateEmailContact(emailContact);
    }
    @When("I verify image thumbnail {string} and filename {string}")
    public static void verifyImage(String thumbnail,String filename) {
        ChatPage.verifyImage(thumbnail,filename);
    }
    @When("I upload a file on chat settings page {string}")
    public static void uploadFile(String filename) {
        ChatPage.uploadFile(filename);
    }
    @When("I validate if error message on chat settings page is correct {string}")
    public static void validateErrorMessage(String errorMessage) {
        ChatPage.validateErrorMessage(errorMessage);
    }
}

