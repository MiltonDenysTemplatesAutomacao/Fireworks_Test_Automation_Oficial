package pages.Records;

import bean.FinancialAidBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.PersonPage;

public class FinancialAidAwardComponentsPage extends BasePage {


    private static String awardAmountField(String fin,String awardComponent){
        return String.format("#person_financial_aid_%s_person_financial_aid_award_component_%s_award_amount",fin,awardComponent);
    }
    private static String awardCategoryElement(String fin,String awardComponent){
        return String.format("#s2id_person_financial_aid_%s_person_financial_aid_award_component_%s_award_category",fin,awardComponent);
    }
    private static String awardTypeElement(String fin,String awardComponent){
        return String.format("#s2id_person_financial_aid_%s_person_financial_aid_award_component_%s_award_type",fin,awardComponent);
    }
    private static String awardCommentsField(String fin,String awardComponent){
        return String.format("#person_financial_aid_%s_person_financial_aid_award_component_%s_award_comments",fin,awardComponent);
    }
    private static String awardComponentAddButton(String fin,String awardComponent){
        return String.format("#person_financial_aid_%s_person_financial_aid_award_component_%s_add",fin,awardComponent);
    }

    public static void addAwardComponent(String fin,String awardComponent){
        String passMessage = String.format(LogPage.ADD_AWARD_COMPONENT_PASS,fin,awardComponent);
        String failMessage = String.format(LogPage.ADD_AWARD_COMPONENT_FAIL,fin,awardComponent);
        try {
            scrollToElement(By.cssSelector(awardComponentAddButton(fin,awardComponent)));
            scrollTo("-150");
            click(By.cssSelector(awardComponentAddButton(fin,awardComponent)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void verifyAwardComponent(FinancialAidBean financialAidBean, String fin, String awardComponent){
        String passMessage = String.format(LogPage.VERIFY_AWARD_COMPONENT_PASS,fin,awardComponent);
        String failMessage = String.format(LogPage.VERIFY_AWARD_COMPONENT_FAIL,fin,awardComponent);

        boolean awardComponentAmountValidation = false;
        boolean awardComponentCategoryValidation = false;
        boolean awardComponentTypeValidation = false;
        boolean awardComponentCommentsValidation = false;

        try {
            if(financialAidBean.getAwardComponentAmount()!=""){
                scrollToElement(By.cssSelector(awardComponentAddButton(fin,awardComponent)));
                String  awardComponentAmountText = getAtribute(By.cssSelector(awardAmountField(fin,awardComponent)),"value");
                awardComponentAmountValidation = awardComponentAmountText.contains(financialAidBean.getAwardComponentAmount());
            }else{
                awardComponentAmountValidation=true;
            }
            if(financialAidBean.getAwardComponentCategory()!=""){
                scrollToElement(By.cssSelector(awardComponentAddButton(fin,awardComponent)));
                String awardComponentCategoryText = getText(By.cssSelector(awardCategoryElement(fin,awardComponent)));
                awardComponentCategoryValidation = awardComponentCategoryText.contains(financialAidBean.getAwardComponentCategory());
            }else{
                awardComponentCategoryValidation=true;
            }
            if(financialAidBean.getAwardComponentType()!=""){
                scrollToElement(By.cssSelector(awardComponentAddButton(fin,awardComponent)));
                String awardComponentTypeText = getText(By.cssSelector(awardTypeElement(fin,awardComponent)));
                awardComponentTypeValidation = awardComponentTypeText.contains(financialAidBean.getAwardComponentType());
            }else{
                awardComponentTypeValidation=true;
            }
            if(financialAidBean.getAwardComponentComments()!=""){
                scrollToElement(By.cssSelector(awardComponentAddButton(fin,awardComponent)));
                String awardComponentCommentsText = getAtribute(By.cssSelector(awardCommentsField(fin,awardComponent)),"value");
                awardComponentCommentsValidation = awardComponentCommentsText.contains(financialAidBean.getAwardComponentComments());
            }else{
                awardComponentCommentsValidation=true;
            }

            if(awardComponentAmountValidation
            && awardComponentCategoryValidation
            && awardComponentTypeValidation
            && awardComponentCommentsValidation){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateAwardComponent(FinancialAidBean financialAidBean, String fin, String awardComponent){
        int updateAwardComponentDelay = 10;
        String passMessage = String.format(LogPage.UPDATE_AWARD_COMPONENT_PASS,fin,awardComponent);
        String failMessage = String.format(LogPage.UPDATE_AWARD_COMPONENT_FAIL,fin,awardComponent);
        try {
            if(financialAidBean.getAwardComponentAmount()!=""){
                scrollToElement(By.cssSelector(awardComponentAddButton(fin,awardComponent)));
                waitElementBy(By.cssSelector(awardAmountField(fin,awardComponent)),updateAwardComponentDelay);
                write(By.cssSelector(awardAmountField(fin,awardComponent)),financialAidBean.getAwardComponentAmount());
            }
            if(financialAidBean.getAwardComponentCategory()!=""){
                scrollToElement(By.cssSelector(awardComponentAddButton(fin,awardComponent)));
                waitElementBy(By.cssSelector(awardCategoryElement(fin,awardComponent)),updateAwardComponentDelay);
                click(By.cssSelector(awardCategoryElement(fin,awardComponent)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateAwardComponentDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(financialAidBean.getAwardComponentCategory());
            }
            if(financialAidBean.getAwardComponentType()!=""){
                scrollToElement(By.cssSelector(awardComponentAddButton(fin,awardComponent)));
                waitElementBy(By.cssSelector(awardTypeElement(fin,awardComponent)),updateAwardComponentDelay);
                click(By.cssSelector(awardTypeElement(fin,awardComponent)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateAwardComponentDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(financialAidBean.getAwardComponentType());
            }
            if(financialAidBean.getAwardComponentComments()!=""){
                scrollToElement(By.cssSelector(awardComponentAddButton(fin,awardComponent)));
                waitElementBy(By.cssSelector(awardCommentsField(fin,awardComponent)),updateAwardComponentDelay);
                write(By.cssSelector(awardCommentsField(fin,awardComponent)),financialAidBean.getAwardComponentComments());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
