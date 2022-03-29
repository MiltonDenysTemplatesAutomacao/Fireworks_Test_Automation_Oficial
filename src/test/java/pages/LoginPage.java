package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

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

    public static final String tasksAdminAccessNoDeleteUsername = "tasksAdministrator@fire.net";
    public static final String tasksAdminAccessNoDeletePassword = "dCBsBwjgqZKTyOUK#0jYKWh@R0";
    public static final String tasksAdminAccessNoDeleteFullName = "Tasks AdminUser";

    public static final String tasksNoAdminNoArchiveUsername = "tasksLimited@fire.net";
    public static final String tasksNoAdminNoArchivePassword = "OMUp#MFK2gsGhG*FY$uAxQb$fQ";
    public static final String tasksNoAdminNoArchiveFullName = "LimitedAccess TasksUser";

    public static final String tasksNoAccessUsername = "tasksRestricted@fire.net";
    public static final String tasksNoAccessPassword = "&RSUubIpfkZAsTNJcK!@UAnp0*";
    public static final String tasksNoAccessFullName = "Tasks Restricted";

    /*
     * username return list
     */
    public static String returnUsernameLoginParameter(String username){
        Map<String, String> usernameParameter = new HashMap<String, String>();
        usernameParameter.put("adminUsername",tasksAdminAccessNoDeleteUsername);
        usernameParameter.put("firestarterUsername",firestarterUsername);
        usernameParameter.put("tasksNoAccessUsername",tasksNoAccessUsername);
        usernameParameter.put("tasksNoAdminNoArchiveUsername",tasksNoAdminNoArchiveUsername);
        return usernameParameter.get(username);
    }
    /*
     * password return list
     */
    public static String returnPasswordLoginParameter(String password){
        Map<String, String> passwordParameter = new HashMap<String, String>();
        passwordParameter.put("adminPassword",tasksAdminAccessNoDeletePassword);
        passwordParameter.put("firestarterPassword",firestarterPassword);
        passwordParameter.put("tasksNoAccessPassword",tasksNoAccessPassword);
        passwordParameter.put("tasksNoAdminNoArchivePassword",tasksNoAdminNoArchivePassword);
        return passwordParameter.get(password);
    }
    /*
     * fullname return list
     */
    public static String returnFullNameLoginParameter(String fullname){
        Map<String, String> fullnameParameter = new HashMap<String, String>();
        fullnameParameter.put("adminUserFullName",tasksAdminAccessNoDeleteFullName);
        fullnameParameter.put("firestarterFullName",firestarterFullName);
        fullnameParameter.put("tasksNoAccessFullName",tasksNoAccessFullName);
        fullnameParameter.put("tasksNoAdminNoArchiveFullName",tasksNoAdminNoArchiveFullName);
        return fullnameParameter.get(fullname);
    }

    /*
     * Method to login and check if the full name is correct
     */
    public static void login(String username,String password,String fullName){
        String errorMessage = String.format(LogPage.LOGIN_AS_PASS, returnFullNameLoginParameter(fullName));
        String passMessage = String.format(LogPage.LOGIN_AS_FAIL, returnFullNameLoginParameter(fullName));
        try {
            BasePage.write(By.cssSelector(usernameField),returnUsernameLoginParameter(username));
            BasePage.write(By.cssSelector(passwordField),returnPasswordLoginParameter(password));
            BasePage.click(By.cssSelector(loginButton));
            if(BasePage.alertMessageByIdContains("alertMessage",returnFullNameLoginParameter(fullName))) {
                ExtentReportsSetUp.testingPass(passMessage);

            }else {
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
}
