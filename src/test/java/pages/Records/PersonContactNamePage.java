package pages.Records;

import bean.ContactNameBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

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
                scrollToElement(By.cssSelector(namePlusSignElement(group)));
                waitElementBy(By.cssSelector(firstNameField(group)),createNameDelay);
                write(By.cssSelector(firstNameField(group)), name.getFirstName());
            }
            if(name.getLastName()!=""){
                scrollToElement(By.cssSelector(namePlusSignElement(group)));
                waitElementBy(By.cssSelector(lastNameField(group)),createNameDelay);
                write(By.cssSelector(lastNameField(group)), name.getLastName());
            }
            if(name.getMiddleName()!=""){
                scrollToElement(By.cssSelector(namePlusSignElement(group)));
                waitElementBy(By.cssSelector(middleNameField(group)),createNameDelay);
                write(By.cssSelector(middleNameField(group)), name.getMiddleName());
            }
            if(name.getPreferredName()!=""){
                scrollToElement(By.cssSelector(namePlusSignElement(group)));
                waitElementBy(By.cssSelector(preferredNameField(group)),createNameDelay);
                write(By.cssSelector(preferredNameField(group)), name.getPreferredName());
            }
            if(name.getSuffix()!=""){
                scrollToElement(By.cssSelector(namePlusSignElement(group)));
                waitElementBy(By.cssSelector(suffixElement(group)),createNameDelay);
                BasePage.click(By.cssSelector(suffixElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(suffixElementList(group)), "a");
                wait(500);
                clickOnListOfElements(name.getSuffix());
            }
            if(name.getSalutation()!=""){
                scrollToElement(By.cssSelector(namePlusSignElement(group)));
                waitElementBy(By.cssSelector(salutationElement(group)),createNameDelay);
                BasePage.click(By.cssSelector(salutationElement(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(salutationElementList(group)), "a");
                wait(500);
                clickOnListOfElements(name.getSalutation());
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
            scrollToElement(By.cssSelector(namePlusSignElement(group)));
            scrollTo("-100");
            waitUntilElementToBeSelected(By.cssSelector(namePlusSignElement(group)),20);
            click(By.cssSelector(namePlusSignElement(group)));
            ExtentReportsSetUp.testingPass(LogPage.ADD_NAME_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.ADD_NAME_FAIL);
        }
    }
    public static void verifyName(ContactNameBean name,String group){
        boolean firstNameValidation = false;
        boolean lastNameValidation = false;
        boolean middleNameValidation = false;
        boolean preferredNameValidation = false;
        boolean suffixValidation = false;
        boolean salutationValidation = false;
        boolean activeCheckboxValidation = false;
        boolean primaryCheckboxValidation = false;
        String passMessage = String.format(LogPage.VERIFY_NAME_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_NAME_FAIL,group);
        try {
            scrollToElement(By.cssSelector(namePlusSignElement(group)));

            if(name.getFirstName()!=""){
                String firstNameText = getAtribute(By.cssSelector(firstNameField(group)),"value");
                firstNameValidation = name.getFirstName().equals(firstNameText);
            }else{
                firstNameValidation=true;
            }
            if(name.getLastName()!=""){
                String lastNameText = getAtribute(By.cssSelector(lastNameField(group)),"value");
                lastNameValidation = name.getLastName().equals(lastNameText);
            }else{
                lastNameValidation=true;
            }
            if(name.getMiddleName()!=""){
                String middleNameText = getAtribute(By.cssSelector(middleNameField(group)),"value");
                middleNameValidation = name.getMiddleName().equals(middleNameText);
            }else{
                middleNameValidation=true;
            }
            if(name.getPreferredName()!=""){
                String preferredNameText = getAtribute(By.cssSelector(preferredNameField(group)),"value");
                preferredNameValidation = name.getPreferredName().equals(preferredNameText);
            }else{
                preferredNameValidation=true;
            }
            if(name.getSuffix()!=""){
                String suffixText = getText(By.cssSelector(suffixElement(group)));
                suffixValidation = name.getSuffix().equals(suffixText);
            }else{
                suffixValidation=true;
            }
            if(name.getSalutation()!=""){
                String salutationText = getText(By.cssSelector(salutationElement(group)));
                salutationValidation = name.getSalutation().equals(salutationText);
            }else{
                salutationValidation=true;
            }
            if(name.getActive()!=""){
                switch (name.getActive()){
                    case "1":
                        activeCheckboxValidation = checkBoxIsActive(By.cssSelector(nameActiveCheckbox(group)));
                        break;
                    case "0":
                        activeCheckboxValidation = !checkBoxIsActive(By.cssSelector(nameActiveCheckbox(group)));
                        break;
                    default: throw new IllegalArgumentException("Active Checkbox not verified");
                }
            }else{
                activeCheckboxValidation=true;
            }
            if(name.getPrimary()!=""){
                switch (name.getPrimary()){
                    case "1":
                        primaryCheckboxValidation = checkBoxIsActive(By.cssSelector(namePrimaryCheckbox(group)));
                        break;
                    case "0":
                        primaryCheckboxValidation = !checkBoxIsActive(By.cssSelector(namePrimaryCheckbox(group)));
                        break;
                    default: throw new IllegalArgumentException("Primary Checkbox not verified");
                }
            }else{
                primaryCheckboxValidation=true;
            }
            if(firstNameValidation
            && lastNameValidation
            && middleNameValidation
            && preferredNameValidation
            && suffixValidation
            && salutationValidation
            && activeCheckboxValidation
            && primaryCheckboxValidation){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

}
