package steps;

import io.cucumber.java.en.When;
import pages.ChatPage;

public class ChatSteps {

    @When("I update email contact in setting chat page {string}")
    public static void updateEmailContact(String emailContact) {
        ChatPage.updateEmailContact(emailContact);
    }
    @When("I verify email contact in setting chat page {string}")
    public static void verifyEmailContact(String emailContact) {
        ChatPage.verifyEmailContact(emailContact);
    }
    @When("I set chat checkbox as active")
    public static void setChatActive() {
        ChatPage.setChatActive();
    }
    @When("I open chat {string}")
    public static void openChat(String chat) {
        ChatPage.openChat(chat);
    }
    @When("I verify if chat checkbox is active or inactive {string}")
    public static void verifyChatCheckbox(String status) {
        ChatPage.verifyChatCheckbox(status);
    }
    @When("I verify image thumbnail {string} and filename {string}")
    public static void verifyImage(String thumbnail,String filename) {
        ChatPage.verifyImage(thumbnail,filename);
    }
    @When("I upload a file on chat settings page {string} on {string} thumbnail")
    public static void uploadFile(String filename,String thumbnail) {
        ChatPage.uploadFile(filename,thumbnail);
    }
    @When("I validate if {string} error message on chat settings page is correct {string}")
    public static void validateErrorMessage(String thumbnail,String errorMessage) {
        ChatPage.validateErrorMessage(thumbnail,errorMessage);
    }
}

