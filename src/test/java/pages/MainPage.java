package pages;

import config.extent_reports.ExtentReportsSetUp;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;

import static pages.GlobalNavPage.QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN;
import static pages.GlobalNavPage.QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN_LIST;

public class MainPage extends BasePage{

    public static void addWithPlusButton(By by)throws Exception{
            waitUntilElementToBeSelected(by,10);
            scrollToElement(by);
            scrollTo("-150");
            wait(1000);
            click(by);
    }

    public static boolean verifyGetText(By by,String value)throws Exception{
        boolean validation = false;
        if(value!=""){
            scrollToElement(by);
            scrollTo("-150");
            String returnText = getText(by);
            validation = returnText.contains(value);
        }else{
            validation=true;
        }
        return validation;
    }

    public static boolean verifyGetAttribute(By by, String value)throws Exception{
        boolean validation = false;
        if(value!=""){
        scrollToElement(by);
        scrollTo("-150");
        String returnText = getAtribute(by,"value");
        validation = returnText.contains(value);
    }else{
        validation=true;
    }
        return validation;
    }
    public static void picker(By pickerButton,By searchField, By recordPickerModalTableRow1,By orgPickerModalTableRow1Checkbox,By modalChooseButton,String value)throws Exception{
        pickerButtonClick(pickerButton);
        searchPicker(searchField,recordPickerModalTableRow1,orgPickerModalTableRow1Checkbox,value);
        modalChooseButton(modalChooseButton);
    }
    public static void pickerButtonClick(By pickerButton)throws Exception{
        scrollToElement(pickerButton);
        scrollTo("-150");
        waitElementBy(pickerButton,10);
        click(pickerButton);
    }
    public static void searchPicker(By searchField,By recordPickerModalTableRow1,By orgPickerModalTableRow1Checkbox,String value)throws Exception{
        int delay = 10;
        waitElementBy(searchField,delay);
        write(searchField,value);
        wait(3000);
        if(verifyIfContains(recordPickerModalTableRow1,value)){
            wait(1000);
            click(orgPickerModalTableRow1Checkbox);
        }else{
            FailureDelegatePage.handlePageException(LogPage.SEARCH_PICKER_FAIL);
        }
    }
    public static void modalChooseButton(By modalChooseButton)throws Exception{
        click(modalChooseButton);
    }
    public static void inputOptionField(By by,String value,By inputField)throws Exception{
        int delay = 10;
        scrollToElement(by);
        scrollTo("-150");
        wait(1000);
        click(by);
        waitElementBy(inputField,delay);
        write(inputField,value);
        waitElementBy(inputField,delay);
        KeyPage.pressKey(inputField,"Enter");
    }
    public static void clickOption(By by)throws Exception{
        scrollToElement(by);
        scrollTo("-150");
        waitUntilElementPresence(by,10);
        BasePage.click(by);
    }
    public static void clickOptionList(By by, String value, By dropDownList, String tag)throws Exception{
        int delay = 10;
        wait(1000);
        scrollToElement(by);
        scrollTo("-150");
        waitElementBy(by,delay);
        click(by);
        waitElementBy(dropDownList,delay);
        BasePage.selectElementsList(dropDownList, tag);
        wait(2000);
        clickOnListOfElements(value);
    }

    public static void fillDateField(By by,String value)throws Exception{
        int delay = 10;
        scrollToElement(by);
        scrollTo("-150");
        waitElementBy(by,delay);
        KeyPage.erase(by);
        waitElementBy(by,delay);
        write(by,value);
        waitElementBy(by,delay);
        KeyPage.pressKey(by,"Enter");
    }

    public static void fillField(By by,String value)throws Exception{
        int delay = 10;
        scrollToElement(by);
        scrollTo("-150");
        waitElementBy(by,delay);
        write(by,value);
    }
    public static void toUseDatatable(DataTable data){
        createDatatable(data);
    }

    public static void createDatatable(DataTable data){
        mass = data.asMaps(String.class, String.class);
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
        try {
            waitElementBy(By.xpath(getElementByText(text)),20);
            scrollToElement(By.xpath(getElementByText(text)));
            scrollTo("-150");
            BasePage.click(By.xpath(getElementByText(text)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
}
