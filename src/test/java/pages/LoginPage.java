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

    public static final String NON_FER_ADMIN_USERNAME = "nonferadminuser@ferfun.com";
    public static final String NON_FER_ADMIN_PASSWORD = "#NrqznbZ4S^ktXRC^Mfrfq+@8Z";
    public static final String NON_FER_ADMIN_FULL_NAME = "NonFER AdminUser";

    public static final String WHOLE_RECORD_NO_DELETE_USERNAME = "fokra@delicious.org";
    public static final String WHOLE_RECORD_NO_DELETE_PASSWORD = "9af^k%54Kf#7fnu9^921k";
    public static final String WHOLE_RECORD_NO_DELETE_FULL_NAME = "Fried Okra";

    public static final String STAFF_RESTRICTED_USERNAME = "rFruit@isnotdelicious.org";
    public static final String STAFF_RESTRICTED_PASSWORD = "^kmne^fsh34Us%##sTM2iuybds23q#";
    public static final String STAFF_RESTRICTED_FULL_NAME = "Rotting Fruit";

    public static final String DUPLICATE_MANAGER_NO_ACCESS_USERNAME = "FrozenPeas@notdelicious.org";
    public static final String DUPLICATE_MANAGER_NO_ACCESS_PASSWORD = "aaz5^^9ds#0ff82ndu^sdTs%s7d";
    public static final String DUPLICATE_MANAGER_NO_ACCESS_FULL_NAME = "Frozen Peas";

    public static final String COMMUNICATIONS_NO_ACCESS_USERNAME = "oldBread@notdelicious.org";
    public static final String COMMUNICATIONS_NO_ACCESS_PASSWORD = "d89Us%sTz^f3#d^7vM2nfs#0f";
    public static final String COMMUNICATIONS_NO_ACCESS_FULL_NAME = "Old Bread";

    public static final String RUN_IMPORTS_NO_ACCESS_USERNAME = "fsalad@isdelicious.org";
    public static final String RUN_IMPORTS_NO_ACCESS_PASSWORD = "#9^3Suf8Us%sTM2Us%sTd8z^f10x";
    public static final String RUN_IMPORTS_NO_ACCESS_FULL_NAME = "Fresh Salad";

    public static final String SMART_SEARCH_NO_ACCESS_USERNAME = "ccorn@notdelicious.org";
    public static final String SMART_SEARCH_NO_ACCESS_PASSWORD = "^49%8sddTsfd9^#sdfds86^";
    public static final String SMART_SEARCH_NO_ACCESS_FULL_NAME = "Canned Corn";

    public static final String SMART_SEARCH_ACCESS_VIEW_USERNAME = "mInAJar@notdelicious.org";
    public static final String SMART_SEARCH_ACCESS_VIEW_PASSWORD = "v2#6^udids#0f2fd9^T5j1ws";
    public static final String SMART_SEARCH_ACCESS_VIEW_FULL_NAME = "Mayonnaise InAJar";

    public static final String APPLICATION_NO_CREATE_USERNAME = "mToast@isnotdelicious.org";
    public static final String APPLICATION_NO_CREATE_PASSWORD = "ii5h%#d%#ds2^3q#TZsdgmUs%#uyb";
    public static final String APPLICATION_NO_CREATE_FULL_NAME = "Moldy Toast";

    public static final String EMAIL_NO_ACCESS_USERNAME = "cToast@isdelicious.org";
    public static final String EMAIL_NO_ACCESS_PASSWORD = "0ddh!Us%#uds2^3v29csdf9iZ#d";
    public static final String EMAIL_NO_ACCESS_FULL_NAME = "Cheese Toast";

    public static final String EMAIL_COMPOSER_NO_ACCESS_USERNAME = "bSplit@isdelicious.org";
    public static final String EMAIL_COMPOSER_NO_ACCESS_PASSWORD = "dds0dcsiZs!%^f82n#0f";
    public static final String EMAIL_COMPOSER_NO_ACCESS_FULL_NAME = "Banana Split";

    public static final String EMAIL_TEMPLATES_NO_ACCESS_USERNAME = "NewMeat@canbefood.org";
    public static final String EMAIL_TEMPLATES_NO_ACCESS_PASSWORD = "d9^#s#8z^f3#d^^9ds#08Ufdf#5jsdfT";
    public static final String EMAIL_TEMPLATES_NO_ACCESS_FULL_NAME = "New Meat";

    public static final String EMAIL_SENDING_NO_ACCESS_USERNAME = "NewMeat@canbefood.org";
    public static final String EMAIL_SENDING_NO_ACCESS_PASSWORD = "d9^#s#8z^f3#d^^9ds#08Ufdf#5jsdfT";
    public static final String EMAIL_SENDING_NO_ACCESS_FULL_NAME = "New Meat";

    public static final String EMAIL_COMPOSER_AND_TEMPLATES_ACCESS_VIEW_USERNAME = "WeirdBean@isfood.org";
    public static final String EMAIL_COMPOSER_AND_TEMPLATES_ACCESS_VIEW_PASSWORD = "ds#0f3#d^en%d2iuds$hhqd%#ds2";
    public static final String EMAIL_COMPOSER_AND_TEMPLATES_ACCESS_VIEW_FULL_NAME = "Weird Bean";

    public static final String EMAIL_COMPOSER_AND_TEMPLATES_ACCESS_VIEW_CREATE_USERNAME = "lBean@isfood.org";
    public static final String EMAIL_COMPOSER_AND_TEMPLATES_ACCESS_VIEW_CREATE_PASSWORD = "ossh%!csudnaen%dds0dds$hhq";
    public static final String EMAIL_COMPOSER_AND_TEMPLATES_ACCESS_VIEW_CREATE_FULL_NAME = "Lima Bean";

    public static final String EMAIL_COMPOSER_AND_TEMPLATES_NO_CREATE_DIRECT_USERNAME = "OldBeans@canbefood.org";
    public static final String EMAIL_COMPOSER_AND_TEMPLATES_NO_CREATE_DIRECT_PASSWORD = "8df#5js#08Us%d%#ds%#uicj4#oop";
    public static final String EMAIL_COMPOSER_AND_TEMPLATES_NO_CREATE_DIRECT_FULL_NAME = "Old Beans";

    public static final String EMAIL_REPORTS_NO_ACCESS_USERNAME = "OldBeans@canbefood.org";
    public static final String EMAIL_REPORTS_NO_ACCESS_PASSWORD = "8df#5js#08Us%d%#ds%#uicj4#oop";
    public static final String EMAIL_REPORTS_NO_ACCESS_FULL_NAME = "Old Beans";

    public static final String EMAIL_SETTINGS_ACCESS_VIEW_USERNAME = "FakeMeat@mightbefood.org";
    public static final String EMAIL_SETTINGS_ACCESS_VIEW_PASSWORD = "f82n#0f#7fn5jssdf9iZdds0ddfT";
    public static final String EMAIL_SETTINGS_ACCESS_VIEW_FULL_NAME = "Fake Meat";

    public static final String EMAIL_SETTINGS_NO_ACCESS_USERNAME = "fBeans@isfood.org";
    public static final String EMAIL_SETTINGS_NO_ACCESS_PASSWORD = "!csiZs%#uUs%#uds2^ddh#dds0ddh!csdf9";
    public static final String EMAIL_SETTINGS_NO_ACCESS_FULL_NAME = "Franken Beans";

    public static final String TEXT_MESSAGES_NO_ACCESS_USERNAME = "vHotdog@mightbefood.org";
    public static final String TEXT_MESSAGES_NO_ACCESS_PASSWORD = "df#5j^n#0sTM25js#sf82sd9Us%sTzT";
    public static final String TEXT_MESSAGES_NO_ACCESS_FULL_NAME = "Vegan Hotdog";

    public static final String TEXT_MESSAGES_NO_VIEW_USERNAME = "vChickenlegs@mightbefood.org";
    public static final String TEXT_MESSAGES_NO_VIEW_PASSWORD = "2jak#ij%f^n0PPw#nu3LLgwn";
    public static final String TEXT_MESSAGES_NO_VIEW_FULL_NAME = "Vegetarian Chickenlegs";

    public static final String TEXT_MESSAGES_ACCESS_VIEW_USERNAME = "vBurger@mightbefood.org";
    public static final String TEXT_MESSAGES_ACCESS_VIEW_PASSWORD = "%4fs7Us%TM22sdUs4f%szT";
    public static final String TEXT_MESSAGES_ACCESS_VIEW_FULL_NAME = "Veggie Burger";

    public static final String TEXT_MESSAGES_ACCESS_VIEW_CREATE_USERNAME = "tFurkey@mightbefood.org";
    public static final String TEXT_MESSAGES_ACCESS_VIEW_CREATE_PASSWORD = "#sTiu%#7n4Us%#nu9^%%#s4U#sTM";
    public static final String TEXT_MESSAGES_ACCESS_VIEW_CREATE_FULL_NAME = "Tofu Turkey";

    public static final String TEXT_MESSAGES_ACCESS_VIEW_EDIT_USERNAME = "help@peptobismol.com";
    public static final String TEXT_MESSAGES_ACCESS_VIEW_EDIT_PASSWORD = "A6^f#6k%jYKfcfnu9^kJ";
    public static final String TEXT_MESSAGES_ACCESS_VIEW_EDIT_FULL_NAME = "Pepto Bismol";

    public static final String DOCUMENTS_NO_ACCESS_USERNAME = "documentsNoAccess@fire.net";
    public static final String DOCUMENTS_NO_ACCESS_PASSWORD = "D^JJnm5F89an6U=@9*^qRBVSwr";
    public static final String DOCUMENTS_NO_ACCESS_FULL_NAME = "Documents NoAccess";

    public static final String DOCUMENTS_READ_ONLY_USERNAME = "documentsReadOnly@fire.net";
    public static final String DOCUMENTS_READ_ONLY_PASSWORD = "TH7$VG=x*2KxXT2X*dvgwcv%s?";
    public static final String DOCUMENTS_READ_ONLY_FULL_NAME = "Documents ReadOnly";

    public static final String DOCUMENTS_NO_DELETE_USERNAME = "documentsNoDelete@fire.net";
    public static final String DOCUMENTS_NO_DELETE_PASSWORD = "pNghJKf@jGK3tkmcL?rbhak@$y";
    public static final String DOCUMENTS_NO_DELETE_FULL_NAME = "Documents NoDelete";

    public static final String CHATS_NO_ACCESS_USERNAME = "chatsNoAccess@fire.net";
    public static final String CHATS_NO_ACCESS_PASSWORD = "-HXRugAGc^&+_rZqT7VRq-xkQj";
    public static final String CHATS_NO_ACCESS_FULL_NAME = "Chats NoAccess";

    public static final String CHATS_READ_ONLY_USERNAME = "chatsReadOnly@fire.net";
    public static final String CHATS_READ_ONLY_PASSWORD = "ftS%Jj6C5Xe%pq32vaPBKNQ8=V";
    public static final String CHATS_READ_ONLY_FULL_NAME = "Chats ReadOnly";

    public static final String CHATS_NO_DELETE_USERNAME = "chatsNoDelete@fire.net";
    public static final String CHATS_NO_DELETE_PASSWORD = "nAw9sw!GkU#W3R=XwD!C=p$x9?";
    public static final String CHATS_NO_DELETE_FULL_NAME = "Chats NoDelete";

    public static final String BULK_UPDATE_NO_ACCESS_USERNAME = "bulkupdateNoAccess@fire.net";
    public static final String BULK_UPDATE_NO_ACCESS_PASSWORD = "wF?WuV9pMEZ49FUU*!xB69kur9";
    public static final String BULK_UPDATE_NO_ACCESS_FULL_NAME = "BulkUpdate NoAccess";

    public static final String BULK_UPDATE_READ_ONLY_USERNAME = "bulkupdateReadOnly@fire.net";
    public static final String BULK_UPDATE_READ_ONLY_PASSWORD = "HmE-R$nJPy$qee@QR9PkTkzA*^";
    public static final String BULK_UPDATE_READ_ONLY_FULL_NAME = "BulkUpdate ReadOnly";

    public static final String BULK_UPDATE_NO_RUN_USERNAME = "bulkupdateNoRun@fire.net";
    public static final String BULK_UPDATE_NO_RUN_PASSWORD = "5+tDa5Xrr_m6HsF=ZLep9Pzw?b";
    public static final String BULK_UPDATE_NO_RUN_FULL_NAME = "BulkUpdate NoRun";


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
        String errorMessage = String.format(LogPage.LOGIN_AS_FAIL, returnFullNameLoginParameter(fullName));
        String passMessage = String.format(LogPage.LOGIN_AS_PASS, returnFullNameLoginParameter(fullName));
        try {
            BasePage.write(By.cssSelector(USERNAME_FIELD),returnUsernameLoginParameter(username));
            BasePage.write(By.cssSelector(PASSWORD_FIELD),returnPasswordLoginParameter(password));
            BasePage.click(By.cssSelector(LOGIN_BUTTON));
            if(BasePage.alertMessageContains(By.id("alertMessage"),returnFullNameLoginParameter(fullName))) {
                ExtentReportsSetUp.testingPass(passMessage);

            }else {
                FailureDelegatePage.handlePageException(errorMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
}
