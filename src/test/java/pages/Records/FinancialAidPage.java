package pages.Records;

import bean.FinancialAidBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.*;

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

    public static void updateFinancialAid(FinancialAidBean financialAidBean, String group){
        String passMessage = String.format(LogPage.UPDATE_FINANCIAL_AID_PASS,group);
        String failMessage = String.format(LogPage.UPDATE_FINANCIAL_AID_FAIL,group);
        int updateFinancialAidDelay=10;
        try {
            if(financialAidBean.getAidAppType()!=""){
                scrollToElement(By.cssSelector(financialAidPlusButton(group)));
                waitElementBy(By.cssSelector(aidAppTypeElement(group)),updateFinancialAidDelay);
                click(By.cssSelector(aidAppTypeElement(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateFinancialAidDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(financialAidBean.getAidAppType());
            }
            if(financialAidBean.getStatus()!=""){
                scrollToElement(By.cssSelector(financialAidPlusButton(group)));
                waitElementBy(By.cssSelector(statusElement(group)),updateFinancialAidDelay);
                click(By.cssSelector(statusElement(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateFinancialAidDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(financialAidBean.getStatus());
            }
            if(financialAidBean.getAidTerm()!=""){
                scrollToElement(By.cssSelector(financialAidPlusButton(group)));
                wait(1000);
                click(By.cssSelector(aidTermElement(group)));
                waitElementBy(By.xpath(ApplicationsPage.INPUT_FIELD),updateFinancialAidDelay);
                write(By.xpath(ApplicationsPage.INPUT_FIELD),financialAidBean.getAidTerm());
                waitElementBy(By.xpath(ApplicationsPage.INPUT_FIELD),updateFinancialAidDelay);
                KeyPage.pressKey(By.xpath(ApplicationsPage.INPUT_FIELD),"Enter");
            }
            if(financialAidBean.getDateReceived()!=""){
                scrollToElement(By.cssSelector(financialAidPlusButton(group)));
                waitElementBy(By.cssSelector(dateReceivedField(group)),updateFinancialAidDelay);
                KeyPage.erase(By.cssSelector(dateReceivedField(group)));
                waitElementBy(By.cssSelector(dateReceivedField(group)),updateFinancialAidDelay);
                write(By.cssSelector(dateReceivedField(group)),financialAidBean.getDateReceived());
                KeyPage.pressKey(By.cssSelector(dateReceivedField(group)),"Enter");
            }
            if(financialAidBean.getDesirabilityScore()!=""){
                scrollToElement(By.cssSelector(financialAidPlusButton(group)));
                waitElementBy(By.cssSelector(desirabilityScoreField(group)),updateFinancialAidDelay);
                write(By.cssSelector(desirabilityScoreField(group)),financialAidBean.getDesirabilityScore());
            }
            if(financialAidBean.getNeedScore()!=""){
                scrollToElement(By.cssSelector(financialAidPlusButton(group)));
                waitElementBy(By.cssSelector(needScoreField(group)),updateFinancialAidDelay);
                write(By.cssSelector(needScoreField(group)),financialAidBean.getNeedScore());
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
