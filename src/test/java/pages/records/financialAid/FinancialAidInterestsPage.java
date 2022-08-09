package pages.records.financialAid;

import bean.FinancialAidInterestBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.*;

public class FinancialAidInterestsPage extends BasePage {


    private static String financialAidInterestsPlusButton(String group){
        return String.format("#person_financial_aid_interest_%s_add",group);
    }
    private static String aidInterestCategoryDropdownLocator(String group){
        return String.format("#s2id_person_financial_aid_interest_%s_aid_interest_category",group);
    }
    private static String aidInterestTypeDropdownLocator(String group){
        return String.format("#s2id_person_financial_aid_interest_%s_aid_interest_type",group);
    }
    private static String expressedInterestDropdownLocator(String group){
        return String.format("#s2id_person_financial_aid_interest_%s_aid_expressed_interest",group);
    }
    private static String expressedInterestDateField(String group){
        return String.format("#person_financial_aid_interest_%s_aid_expressed_interest_date",group);
    }

    public static void verifyFinancialAidInterest(FinancialAidInterestBean financialAidInterestBean,String group){
        String passMessage = String.format(LogPage.VERIFY_FINANCIAL_AID_INTEREST_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_FINANCIAL_AID_INTEREST_FAIL,group);
        boolean aidInterestCategoryValidation = false;
        boolean aidInterestTypeValidation = false;
        boolean expressedInterestValidation = false;
        boolean expressedInterestDateValidation = false;
        try {
            if(financialAidInterestBean.getAidInterestCategory()!=""){
                scrollToElement(By.cssSelector(financialAidInterestsPlusButton(group)));
                String aidInterestCategoryText = getText(By.cssSelector(aidInterestCategoryDropdownLocator(group)));
                aidInterestCategoryValidation = aidInterestCategoryText.contains(financialAidInterestBean.getAidInterestCategory());
            }else{
                aidInterestCategoryValidation = true;
            }
            if(financialAidInterestBean.getAidInterestType()!=""){
                scrollToElement(By.cssSelector(financialAidInterestsPlusButton(group)));
                String aidInterestTypeText = getText(By.cssSelector(aidInterestTypeDropdownLocator(group)));
                aidInterestTypeValidation = aidInterestTypeText.contains(financialAidInterestBean.getAidInterestType());
            }else{
                aidInterestTypeValidation = true;
            }
            if(financialAidInterestBean.getExpressedInterest()!=""){
                scrollToElement(By.cssSelector(financialAidInterestsPlusButton(group)));
                String expressedInterestText = getText(By.cssSelector(expressedInterestDropdownLocator(group)));
                expressedInterestValidation = expressedInterestText.contains(financialAidInterestBean.getExpressedInterest());
            }else{
                expressedInterestValidation = true;
            }
            if(financialAidInterestBean.getExpressedInterestDate()!=""){
                scrollToElement(By.cssSelector(financialAidInterestsPlusButton(group)));
                String expressedInterestText = getAtribute(By.cssSelector(expressedInterestDateField(group)),"value");
                expressedInterestDateValidation = expressedInterestText.contains(financialAidInterestBean.getExpressedInterestDate());
            }else{
                expressedInterestDateValidation = true;
            }
            if(aidInterestCategoryValidation
            && aidInterestTypeValidation
            && expressedInterestValidation
            && expressedInterestDateValidation){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateFinancialAidInterest(FinancialAidInterestBean financialAidInterestBean,String group){

        String passMessage = String.format(LogPage.UPDATE_FINANCIAL_AID_INTEREST_PASS,group);
        String failMessage = String.format(LogPage.UPDATE_FINANCIAL_AID_INTEREST_FAIL,group);
        int updateFinancialAidInterestDelay = 10;
        try {
            if(financialAidInterestBean.getAidInterestCategory()!=""){
                scrollToElement(By.cssSelector(financialAidInterestsPlusButton(group)));
                waitElementBy(By.cssSelector(aidInterestCategoryDropdownLocator(group)), updateFinancialAidInterestDelay);
                click(By.cssSelector(aidInterestCategoryDropdownLocator(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP), updateFinancialAidInterestDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(financialAidInterestBean.getAidInterestCategory());
            }
            if(financialAidInterestBean.getAidInterestType()!=""){
                scrollToElement(By.cssSelector(financialAidInterestsPlusButton(group)));
                waitElementBy(By.cssSelector(aidInterestTypeDropdownLocator(group)), updateFinancialAidInterestDelay);
                click(By.cssSelector(aidInterestTypeDropdownLocator(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP), updateFinancialAidInterestDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(financialAidInterestBean.getAidInterestType());

            }
            if(financialAidInterestBean.getExpressedInterest()!=""){
                scrollToElement(By.cssSelector(financialAidInterestsPlusButton(group)));
                waitElementBy(By.cssSelector(expressedInterestDropdownLocator(group)), updateFinancialAidInterestDelay);
                click(By.cssSelector(expressedInterestDropdownLocator(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP), updateFinancialAidInterestDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(financialAidInterestBean.getExpressedInterest());
            }
            if(financialAidInterestBean.getExpressedInterestDate()!=""){
                scrollToElement(By.cssSelector(financialAidInterestsPlusButton(group)));
                waitElementBy(By.cssSelector(expressedInterestDateField(group)), updateFinancialAidInterestDelay);
                KeyPage.erase(By.cssSelector(expressedInterestDateField(group)));
                waitElementBy(By.cssSelector(expressedInterestDateField(group)), updateFinancialAidInterestDelay);
                write(By.cssSelector(expressedInterestDateField(group)),financialAidInterestBean.getExpressedInterestDate());
                KeyPage.pressKey(By.cssSelector(expressedInterestDateField(group)),"Enter");
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
