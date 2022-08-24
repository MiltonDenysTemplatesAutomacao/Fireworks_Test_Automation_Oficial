package pages.records.financialAid;

import bean.FinancialAidBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.*;
import pages.records.application.ApplicationsPage;

public class FinancialAidPage extends BasePage {

    public static final String FINANCIAL_AID_SAVE_CHANGES_BUTTON = "#saveChangesBtnPersonFinancial";

    private static String aidAppTypeElement(String index){
        return String.format("#s2id_person_financial_aid_%s_financial_aid_type",index);
    }
    private static String statusElement(String index){
        return String.format("#s2id_person_financial_aid_%s_financial_aid_status",index);
    }
    private static String aidTermElement(String index){
        return String.format("#s2id_person_financial_aid_%s_financial_aid_term",index);
    }
    private static String totalAwardAmountField(String index){
        return String.format("#person_financial_aid_%s_financial_aid_award_total",index);
    }
    private static String awardCountField(String index){
        return String.format("#person_financial_aid_%s_financial_aid_award_count",index);
    }
    private static String dateReceivedField(String index){
        return String.format("#person_financial_aid_%s_financial_aid_date_received",index);
    }
    private static String desirabilityScoreField(String index){
        return String.format("#person_financial_aid_%s_financial_aid_desirability_score",index);
    }
    private static String needScoreField(String index){
        return String.format("#person_financial_aid_%s_financial_aid_need_score",index);
    }
    private static String financialAidPlusButton(String index){
        return String.format("#person_financial_aid_%s_add",index);
    }
    private static String financialAidActiveCheckbox(String fin){
        return String.format("#person_financial_aid_%s_active",fin);
    }
    private static String financialAidPrimaryCheckbox(String fin){
        return String.format("#person_financial_aid_%s_primary",fin);
    }

    public static void verifyFinancialAid(FinancialAidBean financialAidBean, String group){

        String passMessage = String.format(LogPage.VERIFY_FINANCIAL_AID_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_FINANCIAL_AID_FAIL,group);

        try {
            if(MainPage.verifyGetText(By.cssSelector(aidAppTypeElement(group)),financialAidBean.getAidAppType())
                    && MainPage.verifyGetText(By.cssSelector(statusElement(group)),financialAidBean.getStatus())
                    && MainPage.verifyGetText(By.cssSelector(aidTermElement(group)),financialAidBean.getAidTerm())
                    && MainPage.verifyGetAttribute(By.cssSelector(awardCountField(group)),financialAidBean.getAwardCount())
                    && MainPage.verifyGetAttribute(By.cssSelector(totalAwardAmountField(group)),financialAidBean.getTotalAwardAmount())
                    && MainPage.verifyGetAttribute(By.cssSelector(dateReceivedField(group)),financialAidBean.getDateReceived())
                    && MainPage.verifyGetAttribute(By.cssSelector(desirabilityScoreField(group)),financialAidBean.getDesirabilityScore())
                    && MainPage.verifyGetAttribute(By.cssSelector(needScoreField(group)),financialAidBean.getNeedScore())
            ){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        }catch (Exception e){
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    /*
     * checkbox variable is used to validate if checkbox is checked or not checked, number 1 to validate if it is checked and number 0
     * to validate if it is not checked
     */
    public static void verifyFinancialAidActivePrimaryCheckbox(String checkboxName,String fin,String checkbox){
        String passMessage = String.format(LogPage.VERIFY_FINANCIAL_AID_ACTIVE_PRIMARY_CHECKBOX_PASS,checkboxName,fin);
        String failMessage = String.format(LogPage.VERIFY_FINANCIAL_AID_ACTIVE_PRIMARY_CHECKBOX_FAIL,checkboxName,fin);
        boolean activeValidation = false;
        boolean primaryValidation = false;

        try {
            if(checkbox=="Active"){
                switch (checkbox){
                    case "1":
                        activeValidation = checkBoxIsActive(By.cssSelector(financialAidActiveCheckbox(fin)));
                        break;
                    case "0":
                        activeValidation = !checkBoxIsActive(By.cssSelector(financialAidActiveCheckbox(fin)));
                        break;
                    default:
                        throw new IllegalArgumentException("Unhandled index. Update business logic");
                }
            }else{
                activeValidation=true;
            }

            if(checkbox=="Primary"){
                switch (checkbox){
                    case "1":
                        activeValidation = checkBoxIsActive(By.cssSelector(financialAidPrimaryCheckbox(fin)));
                        break;
                    case "0":
                        activeValidation = !checkBoxIsActive(By.cssSelector(financialAidPrimaryCheckbox(fin)));
                        break;
                    default:
                        throw new IllegalArgumentException("Unhandled index. Update business logic");
                }
            }else{
                primaryValidation=true;
            }
            if(activeValidation && primaryValidation){
                ExtentReportsSetUp.testingPass(passMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void clickFinancialAidActive(String fin){
        String passMessage = String.format(LogPage.CLICK_FINANCIAL_AID_ACTIVE_PASS,fin);
        String failMessage = String.format(LogPage.CLICK_FINANCIAL_AID_ACTIVE_FAIL,fin);
        try {
            scrollToElement(By.cssSelector(financialAidPlusButton(fin)));
            scrollTo("-150");
            click(By.cssSelector(financialAidActiveCheckbox(fin)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void addFinancialAid(String fin){
        String passMessage = String.format(LogPage.ADD_FINANCIAL_AID_PASS,fin);
        String failMessage = String.format(LogPage.ADD_FINANCIAL_AID_FAIL,fin);
        try {
            scrollToElement(By.cssSelector(financialAidPlusButton(fin)));
            scrollTo("-150");
            click(By.cssSelector(financialAidPlusButton(fin)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void updateFinancialAid(FinancialAidBean financialAidBean, String group){
        String passMessage = String.format(LogPage.UPDATE_FINANCIAL_AID_PASS,group);
        String failMessage = String.format(LogPage.UPDATE_FINANCIAL_AID_FAIL,group);
        try {
            if(financialAidBean.getAidAppType()!=""){
                MainPage.clickOptionList(By.cssSelector(aidAppTypeElement(group)),financialAidBean.getAidAppType(),By.cssSelector(PersonPage.SELECT_DROP),"a");
            }
            if(financialAidBean.getStatus()!=""){
                MainPage.clickOptionList(By.cssSelector(statusElement(group)),financialAidBean.getStatus(),By.cssSelector(PersonPage.SELECT_DROP),"a");
            }
            if(financialAidBean.getAidTerm()!=""){
                MainPage.inputOptionField(By.cssSelector(aidTermElement(group)),financialAidBean.getAidTerm(),By.xpath(ApplicationsPage.INPUT_FIELD));
            }
            if(financialAidBean.getDateReceived()!=""){
                MainPage.fillDateField(By.cssSelector(dateReceivedField(group)),financialAidBean.getDateReceived());
            }
            if(financialAidBean.getDesirabilityScore()!=""){
                MainPage.fillField(By.cssSelector(desirabilityScoreField(group)),financialAidBean.getDesirabilityScore());
            }
            if(financialAidBean.getNeedScore()!=""){
                MainPage.fillField(By.cssSelector(needScoreField(group)),financialAidBean.getNeedScore());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void clickSaveChanges(){
        try {
            scrollToTheBottom();
            waitElementBy(By.cssSelector((FINANCIAL_AID_SAVE_CHANGES_BUTTON)),10);
            click(By.cssSelector(FINANCIAL_AID_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_SAVE_CHANGES_FINANCIAL_AID_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_SAVE_CHANGES_FINANCIAL_AID_PASS);
        }
    }

}
