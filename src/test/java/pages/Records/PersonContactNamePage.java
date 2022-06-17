package pages.Records;

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
    private static String salutationElement(String index){
        return String.format("#person_name_%s_salutation_component",index);
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

    public static void verifyName(String firstName,String lastName,String middleName,String preferredName,String suffix,String salutation,String active,String primary,String group){
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

            if(firstName!=""){
                String firstNameText = getAtribute(By.cssSelector(firstNameField(group)),"value");
                firstNameValidation = firstName.equals(firstNameText);
            }else{
                firstNameValidation=true;
            }
            if(lastName!=""){
                String lastNameText = getAtribute(By.cssSelector(lastNameField(group)),"value");
                lastNameValidation = lastName.equals(lastNameText);
            }else{
                lastNameValidation=true;
            }
            if(middleName!=""){
                String middleNameText = getAtribute(By.cssSelector(middleNameField(group)),"value");
                middleNameValidation = middleName.equals(middleNameText);
            }else{
                middleNameValidation=true;
            }
            if(preferredName!=""){
                String preferredNameText = getAtribute(By.cssSelector(preferredNameField(group)),"value");
                preferredNameValidation = preferredName.equals(preferredNameText);
            }else{
                preferredNameValidation=true;
            }
            if(suffix!=""){
                String suffixText = getText(By.cssSelector(suffixElement(group)));
                suffixValidation = suffix.equals(suffixText);
            }else{
                suffixValidation=true;
            }
            if(salutation!=""){
                String salutationText = getText(By.cssSelector(salutationElement(group)));
                salutationValidation = salutation.equals(salutationText);
            }else{
                salutationValidation=true;
            }
            if(active!=""){
                switch (active){
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
            if(primary!=""){
                switch (primary){
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
