package steps;

import io.cucumber.java.en.Given;
import pages.LoginPage;

public class LoginSteps {

    @Given("I login as {string}, {string}, {string}")
    public void loginAs(String username, String password, String fullName) {
        LoginPage.login(username, password, fullName);
    }
}
