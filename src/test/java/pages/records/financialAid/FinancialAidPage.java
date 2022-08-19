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
        boolean aidAppTypeValidation = false;
        boolean statusValidation = false;
        boolean aidTermValidation = false;
        boolean awardCountValidation = false;
        boolean totalAwardAmountValidation = false;
        boolean dateReceivedValidation = false;
        boolean desirabilityScoreValidation = false;
        boolean needScoreValidation = false;

        String passMessage = String.format(LogPage.VERIFY_FINANCIAL_AID_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_FINANCIAL_AID_FAIL,group);

        try {
            if(financialAidBean.getAidAppType()!=""){
                scrollToElement(By.cssSelector(financialAidPlusButton(group)));
                String aidAppTypeText = getText(By.cssSelector(aidAppTypeElement(group)));
                aidAppTypeValidation = aidAppTypeText.contains(financialAidBean.getAidAppType());
            }else{
                aidAppTypeValidation=true;
            }
            if(financialAidBean.getStatus()!=""){
                scrollToElement(By.cssSelector(financialAidPlusButton(group)));
                String statusText = getText(By.cssSelector(statusElement(group)));
                statusValidation = statusText.contains(financialAidBean.getStatus());
            }else{
                statusValidation=true;
            }
            if(financialAidBean.getAidTerm()!=""){
                scrollToElement(By.cssSelector(financialAidPlusButton(group)));
                String aidTermElementText = getText(By.cssSelector(aidTermElement(group)));
                aidTermValidation = aidTermElementText.contains(financialAidBean.getAidTerm());
            }else{
                aidTermValidation=true;
            }
            if(financialAidBean.getAwardCount()!=""){
                scrollToElement(By.cssSelector(financialAidPlusButton(group)));
                String awardCountText = getAtribute(By.cssSelector(awardCountField(group)),"value");
                awardCountValidation = awardCountText.contains(financialAidBean.getAwardCount());
            }else{
                awardCountValidation=true;
            }
            if(financialAidBean.getTotalAwardAmount()!=""){
                scrollToElement(By.cssSelector(financialAidPlusButton(group)));
                String totalAwardAmountText = getAtribute(By.cssSelector(totalAwardAmountField(group)),"value");
                totalAwardAmountValidation = totalAwardAmountText.contains(financialAidBean.getTotalAwardAmount());
            }else{
                totalAwardAmountValidation=true;
            }
            if(financialAidBean.getDateReceived()!=""){
                scrollToElement(By.cssSelector(financialAidPlusButton(group)));
                String dateReceivedText = getAtribute(By.cssSelector(dateReceivedField(group)),"value");
                dateReceivedValidation = dateReceivedText.contains(financialAidBean.getDateReceived());
            }else{
                dateReceivedValidation=true;
            }
            if(financialAidBean.getDesirabilityScore()!=""){
                scrollToElement(By.cssSelector(financialAidPlusButton(group)));
                String desirabilityScoreText = getAtribute(By.cssSelector(desirabilityScoreField(group)),"value");
                desirabilityScoreValidation = desirabilityScoreText.contains(financialAidBean.getDesirabilityScore());
            }else{
                desirabilityScoreValidation=true;
            }
            if(financialAidBean.getNeedScore()!=""){
                scrollToElement(By.cssSelector(financialAidPlusButton(group)));
                String  needScoreText = getAtribute(By.cssSelector(needScoreField(group)),"value");
                needScoreValidation = needScoreText.contains(financialAidBean.getNeedScore());
            }else{
                needScoreValidation=true;
            }

            if(aidAppTypeValidation
                    && statusValidation
                    && aidTermValidation
                    && awardCountValidation
                    && totalAwardAmountValidation
                    && dateReceivedValidation
                    && desirabilityScoreValidation
                    && needScoreValidation){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
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
                MainPage.clickOption(By.cssSelector(aidAppTypeElement(group)),financialAidBean.getAidAppType(),By.cssSelector(PersonPage.SELECT_DROP),"a");
            }
            if(financialAidBean.getStatus()!=""){
                MainPage.clickOption(By.cssSelector(statusElement(group)),financialAidBean.getStatus(),By.cssSelector(PersonPage.SELECT_DROP),"a");
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
