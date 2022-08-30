package pages.records.person;

import bean.ContactNameBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;

public class PersonContactNamePage extends BasePage {

    private static String firstNameField(String index){
        return String.format("#person_name_%s_name_first",index);
    }
    private static String lastNameField(String index){
        return String.format("#person_name_%s_name_last",index);
    }
    private static String middleNameField(String index){
        return String.format("#person_name_%s_name_middle",index);
    }
    private static String preferredNameField(String index){
        return String.format("#person_name_%s_preferred_name",index);
    }
    private static String suffixElement(String index){
        return String.format("#person_name_%s_name_suffix_component",index);
    }
    private static String suffixElementList(String index){
        return String.format("#person_name_%s_name_suffix_dropdown_menu",index);
    }
    private static String salutationElement(String index){
        return String.format("#person_name_%s_salutation_component",index);
    }
    private static String salutationElementList(String index){
        return String.format("#person_name_%s_salutation_dropdown_menu",index);
    }
    private static String nameActiveCheckbox(String index){
        return String.format("#person_name_%s_active",index);
    }
    private static String namePrimaryCheckbox(String index){
        return String.format("#person_name_%s_primary",index);
    }
    private static String namePlusSignElement(String index){
        return String.format("#person_name_%s_add",index);
    }

    public static void createName(ContactNameBean name, String group){
        String passMessage = String.format(LogPage.CREATE_EMAIL_PASS,group);
        String failMessage = String.format(LogPage.CREATE_EMAIL_FAIL,group);
        int createNameDelay=20;
        try {
            if(name.getFirstName()!=""){
                MainPage.fillField(By.cssSelector(firstNameField(group)), name.getFirstName());
            }
            if(name.getLastName()!=""){
                MainPage.fillField(By.cssSelector(lastNameField(group)), name.getLastName());
            }
            if(name.getMiddleName()!=""){
                MainPage.fillField(By.cssSelector(middleNameField(group)), name.getMiddleName());
            }
            if(name.getPreferredName()!=""){
                MainPage.fillField(By.cssSelector(preferredNameField(group)), name.getPreferredName());
            }
            if(name.getSuffix()!=""){
                MainPage.clickOptionList(By.cssSelector(suffixElement(group)),
                        name.getSuffix(),
                        By.cssSelector(suffixElementList(group)),
                        "a");
            }
            if(name.getSalutation()!=""){
                MainPage.clickOptionList(By.cssSelector(suffixElement(group)),
                        name.getSalutation(),
                        By.cssSelector(salutationElementList(group)),
                        "a");
            }
            if(name.getActive()!=""){
                scrollToElement(By.cssSelector(namePlusSignElement(group)));
                click(By.cssSelector(nameActiveCheckbox(group)));
            }
            if(name.getPrimary()!=""){
                scrollToElement(By.cssSelector(namePlusSignElement(group)));
                click(By.cssSelector(namePrimaryCheckbox(group)));
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void addName(String group){
        try {
            MainPage.addDeleteWithPlusButton(By.cssSelector(namePlusSignElement(group)));
            ExtentReportsSetUp.testingPass(LogPage.ADD_NAME_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ADD_NAME_FAIL);
        }
    }
    public static void verifyName(ContactNameBean name,String group){
        String passMessage = String.format(LogPage.VERIFY_NAME_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_NAME_FAIL,group);
        try {
            if(MainPage.verifyGetAttribute(By.cssSelector(firstNameField(group)),name.getFirstName())
                    && MainPage.verifyGetAttribute(By.cssSelector(lastNameField(group)),name.getLastName())
                    && MainPage.verifyGetAttribute(By.cssSelector(middleNameField(group)),name.getMiddleName())
                    && MainPage.verifyGetAttribute(By.cssSelector(preferredNameField(group)),name.getPreferredName())
                    && MainPage.verifyGetText(By.cssSelector(suffixElement(group)),name.getSuffix())
                    && MainPage.verifyGetText(By.cssSelector(salutationElement(group)),name.getSalutation())
                    && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(nameActiveCheckbox(group)),name.getActive())
                    && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(namePrimaryCheckbox(group)),name.getPrimary())){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
