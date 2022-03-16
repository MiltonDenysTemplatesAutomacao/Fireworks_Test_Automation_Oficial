package pages;
import org.junit.Assert;
import org.openqa.selenium.By;

import config.extent_reports.ExtentReportsSetUp;
public class LoginPage {

    /*
     * Css
     */
    public static final String usernameField = "#loginForm #loginAccountEmail";
    public static final String passwordField = "#loginForm #loginAccountPass";
    public static final String loginButton = "#loginForm #loginAccountSubmit";



    /*
     * Users
     */
    public static final String firestarterUsername = "firestarter@fire-engine-red.com";
    public static final String firestarterPassword = "CkCgb8GEwM!MW3#2T*Kd";
    public static final String firestarterFullName = "Fire Starter";


    /*
     * Method to login and check if the full name is correct
     */
    public static boolean login(String username,String password,String fullName){
        boolean loginSucess = false;
        try {
            BasePage.write(By.cssSelector(usernameField),username);
            BasePage.write(By.cssSelector(passwordField),password);
            BasePage.click(By.cssSelector(loginButton));
            if(BasePage.alertMessageByIdContains("alertMessage",fullName)) {
                loginSucess=true;
            }else {
                System.err.println(LogPage.LOGIN_FAIL);
            }
        } catch (Exception e) {
            System.err.println(LogPage.LOGIN_FAIL);
        }
        return loginSucess;
    }
    /*
     * Method to login as a Firestarter user
     */
    public static void loginAsFirestarter() {
        try {
            if(LoginPage.login(firestarterUsername,firestarterPassword,firestarterFullName)) {
                ExtentReportsSetUp.testingPass(LogPage.LOGIN_AS_FIRESTARTER_PASS);
            }else {
                System.err.println(LogPage.LOGIN_AS_FIRESTARTER_FAIL);
                ExtentReportsSetUp.testingFail(LogPage.LOGIN_AS_FIRESTARTER_FAIL);
                Assert.assertFalse(true);
            }
        } catch (Exception e) {
            System.err.println(LogPage.LOGIN_AS_FIRESTARTER_FAIL);
        }
    }
}
