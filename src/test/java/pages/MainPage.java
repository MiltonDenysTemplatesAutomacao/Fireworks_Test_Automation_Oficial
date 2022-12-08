package pages;

import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static pages.GlobalNavPage.QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN;
import static pages.GlobalNavPage.QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN_LIST;

public class MainPage extends BasePage{
    public static final String QUICK_SEARCH_MAGNIFYING_GLASS = "#quickFindToggle";
    public static final String HEADER_QUICK_SEARCH_FIELD = "#headerSearch";
    public static final String HEADER_QUICK_SEARCH_BUTTON = "#navSearchSubmitButton";

    public static String returnElements (String elements){
        Map<String, String> returnElement = new HashMap<String, String>();
        returnElement.put("footerToolsMenu", GlobalNavPage.FOOTER_TOOLS_MENU);
        returnElement.put("footerRecordsMenu", GlobalNavPage.FOOTER_RECORDS_MENU);
        returnElement.put("footerQuickAddMenu", GlobalNavPage.FOOTER_QUICK_ADD_MEN);
        returnElement.put("footerSettingsMenu", GlobalNavPage.FOOTER_SETTINGS_MENU);
        returnElement.put("footerCommunicationsMenu", GlobalNavPage.FOOTER_COMMUNICATIONS_MENU);
        returnElement.put("footerCommunicationsChatsMenuItem", GlobalNavPage.FOOTER_COMMUNICATIONS_CHATS_MENU_ITEM);
        return returnElement.get(elements);
    }

    public static void validateIfElementIsVisibleOrNot(String element,String status){
        String passMessage = String.format(LogPage.VALIDATE_IF_ELEMENT_IS_VISIBLE_PASS,element,status);
        String failMessage = String.format(LogPage.VALIDATE_IF_ELEMENT_IS_VISIBLE_FAIL,element,status);
        try {
            switch (status){
                case "visible":
                    if(verifyIfElementIsVisible(By.cssSelector(returnElements(element)))){
                        ExtentReportsSetUp.testingPass(passMessage);
                    }else{
                        FailureDelegatePage.handlePageException(failMessage);
                    }
                    break;
                case "not visible":
                    if(!verifyIfElementIsVisible(By.cssSelector(returnElements(element)))){
                        ExtentReportsSetUp.testingPass(passMessage);
                    }else{
                        FailureDelegatePage.handlePageException(failMessage);
                    }
                    break;
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void quickSearchFromHeader(String data){
        String passMessage = String.format(LogPage.QUICK_SEARCH_FROM_HEADER_PASS,data);
        String failMessage = String.format(LogPage.QUICK_SEARCH_FROM_HEADER_FAIL,data);
        try {
            MainPage.clickOption(By.cssSelector(QUICK_SEARCH_MAGNIFYING_GLASS));
            MainPage.fillField(By.cssSelector(HEADER_QUICK_SEARCH_FIELD),data);
            MainPage.clickOption(By.cssSelector(HEADER_QUICK_SEARCH_BUTTON));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void selectQuickAddEmailOptIn(String emailOptIn){
        String errorMessage = String.format(LogPage.SELECT_QUICK_ADD_EMAIL_OPT_IN_FAIL, emailOptIn);
        String passMessage = String.format(LogPage.SELECT_QUICK_ADD_EMAIL_OPT_IN_PASS, emailOptIn);
        try {
            waitElementBy(By.cssSelector(QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN),20);
            BasePage.click(By.cssSelector(QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN));
            BasePage.selectElementsList(By.cssSelector(QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN_LIST), "a");
            wait(1000);
            clickOnListOfElements(emailOptIn);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
    public static void clickElementByText(String text){
        String errorMessage = String.format(LogPage.CLICK_ELEMENT_BY_TEXT_FAIL, text);
        String passMessage = String.format(LogPage.CLICK_ELEMENT_BY_TEXT_PASS, text);
        wait(2000);
        try {
            waitUntilElementToBeSelected(By.xpath(getElementByText(text)),10);
            scrollToElement(By.xpath(getElementByText(text)));
            scrollTo("-150");
            wait(2000);
            BasePage.click(By.xpath(getElementByText(text)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
}
