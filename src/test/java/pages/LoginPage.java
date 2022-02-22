package pages;
import org.junit.Assert;
import org.openqa.selenium.By;

import config.extent_reports.ExtentReportsSetUp;
public class LoginPage {

    /*
     * Css
     */
    public static String usernameField = "#loginForm #loginAccountEmail";
    public static String passwordField = "#loginForm #loginAccountPass";
    public static String loginButton = "#loginForm #loginAccountSubmit";



    /*
     * Users
     */
    public static String firestarterUsername = "firestarter@fire-engine-red.com";
    public static String firestarterPassword = "CkCgb8GEwM!MW3#2T*Kd";
    public static String firestarterFullName = "Fire Starter";


    /*
     * Method to login and check if the full name is correct
     */
    public static boolean login(String username,String password,String fullName){
        boolean loginSucess = false;
        try {
            BasePage.write(By.cssSelector(usernameField),username);
            BasePage.write(By.cssSelector(passwordField),password);
            BasePage.click(By.cssSelector(loginButton));
            if(BasePage.alertMessageByIdContains("alertMessage",fullName)==true) {
                loginSucess=true;
            }else {
                System.err.println("Error - I login as firestarter");
                ExtentReportsSetUp.testingFail("FAILED to login");
            }

        } catch (Exception e) {

        }
        return loginSucess;
    }
    /*
     * Method to login as a Firestarter user
     */
    public static void loginAsFirestarter() {
        try {
            if(LoginPage.login(firestarterUsername,firestarterPassword,firestarterFullName)==true) {
                ExtentReportsSetUp.testingPass("I login as firestarter");
            }else {
                System.err.println("Error - I login as firestarter");
                ExtentReportsSetUp.testingFail("FAILED to login as firestarter");
                Assert.assertFalse(true);
            }

        } catch (Exception e) {

        }


    }
}
