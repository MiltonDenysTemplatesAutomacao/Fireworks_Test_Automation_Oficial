package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class LoginPage {

    /*
     * Css
     */
    public static final String USERNAME_FIELD = "#loginForm #loginAccountEmail";
    public static final String PASSWORD_FIELD = "#loginForm #loginAccountPass";
    public static final String LOGIN_BUTTON = "#loginForm #loginAccountSubmit";



    /*
     * Users
     */
    public static final String FIRESTARTER_USERNAME = "firestarter@fire-engine-red.com";
    public static final String FIRESTARTER_PASSWORD = "CkCgb8GEwM!MW3#2T*Kd";
    public static final String FIRESTARTER_FULL_NAME = "Fire Starter";

    public static final String TASKS_ADMIN_ACCESS_NO_DELETE_USERNAME = "tasksAdministrator@fire.net";
    public static final String TASKS_ADMIN_ACCESS_NO_DELETE_PASSWORD = "dCBsBwjgqZKTyOUK#0jYKWh@R0";
    public static final String TASKS_ADMIN_ACCESS_NO_DELETE_FULL_NAME = "Tasks AdminUser";

    public static final String TASKS_NO_ADMIN_NO_ARCHIVE_USERNAME = "tasksLimited@fire.net";
    public static final String TASKS_NO_ADMIN_NO_ARCHIVE_PASSWORD = "OMUp#MFK2gsGhG*FY$uAxQb$fQ";
    public static final String TASKS_NO_ADMIN_NO_ARCHIVE_FULL_NAME = "LimitedAccess TasksUser";

    public static final String TASKS_NO_ACCESS_USERNAME = "tasksRestricted@fire.net";
    public static final String TASKS_NO_ACCESS_PASSWORD = "&RSUubIpfkZAsTNJcK!@UAnp0*";
    public static final String TASKS_NO_ACCESS_FULL_NAME = "Tasks Restricted";

    /*
     * username return list
     */
    public static String returnUsernameLoginParameter(String username){
        Map<String, String> usernameParameter = new HashMap<String, String>();
        usernameParameter.put("adminUsername", TASKS_ADMIN_ACCESS_NO_DELETE_USERNAME);
        usernameParameter.put("firestarterUsername", FIRESTARTER_USERNAME);
        usernameParameter.put("tasksNoAccessUsername", TASKS_NO_ACCESS_USERNAME);
        usernameParameter.put("tasksNoAdminNoArchiveUsername", TASKS_NO_ADMIN_NO_ARCHIVE_USERNAME);
        return usernameParameter.get(username);
    }
    /*
     * password return list
     */
    public static String returnPasswordLoginParameter(String password){
        Map<String, String> passwordParameter = new HashMap<String, String>();
        passwordParameter.put("adminPassword", TASKS_ADMIN_ACCESS_NO_DELETE_PASSWORD);
        passwordParameter.put("firestarterPassword", FIRESTARTER_PASSWORD);
        passwordParameter.put("tasksNoAccessPassword", TASKS_NO_ACCESS_PASSWORD);
        passwordParameter.put("tasksNoAdminNoArchivePassword", TASKS_NO_ADMIN_NO_ARCHIVE_PASSWORD);
        return passwordParameter.get(password);
    }
    /*
     * fullname return list
     */
    public static String returnFullNameLoginParameter(String fullname){
        Map<String, String> fullnameParameter = new HashMap<String, String>();
        fullnameParameter.put("adminUserFullName", TASKS_ADMIN_ACCESS_NO_DELETE_FULL_NAME);
        fullnameParameter.put("firestarterFullName", FIRESTARTER_FULL_NAME);
        fullnameParameter.put("tasksNoAccessFullName", TASKS_NO_ACCESS_FULL_NAME);
        fullnameParameter.put("tasksNoAdminNoArchiveFullName", TASKS_NO_ADMIN_NO_ARCHIVE_FULL_NAME);
        return fullnameParameter.get(fullname);
    }

    /*
     * Method to login and check if the full name is correct
     */
    public static void login(String username,String password,String fullName){
        String errorMessage = String.format(LogPage.LOGIN_AS_PASS, returnFullNameLoginParameter(fullName));
        String passMessage = String.format(LogPage.LOGIN_AS_FAIL, returnFullNameLoginParameter(fullName));
        try {
            BasePage.write(By.cssSelector(USERNAME_FIELD),returnUsernameLoginParameter(username));
            BasePage.write(By.cssSelector(PASSWORD_FIELD),returnPasswordLoginParameter(password));
            BasePage.click(By.cssSelector(LOGIN_BUTTON));
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
