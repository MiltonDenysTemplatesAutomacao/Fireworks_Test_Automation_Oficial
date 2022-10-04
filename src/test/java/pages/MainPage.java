package pages;

import config.extent_reports.ExtentReportsSetUp;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.testng.reporters.jq.Main;

import static pages.GlobalNavPage.QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN;
import static pages.GlobalNavPage.QUICK_ADD_PERSON_OPT_IN_METHOD_DROPDOWN_LIST;

public class MainPage extends BasePage{
    public static final String QUICK_SEARCH_MAGNIFYING_GLASS = "#quickFindToggle";
    public static final String HEADER_QUICK_SEARCH_FIELD = "#headerSearch";
    public static final String HEADER_QUICK_SEARCH_BUTTON = "#navSearchSubmitButton";



    public static void attachFile(String sourceFile, By by)throws Exception{
        String filePath = getFile(sourceFile);
        waitElementBy(by,10);
        scrollToElement(by);
        scrollTo("-150");
        click(by);
        wait(2000);
        copyToTheClipboard(filePath);
        attachFile();
        wait(1000);
    }
    public static void navigateToFeature(By by)throws Exception{
        waitElementBy(by,10);
        scrollToElement(by);
        scrollTo("-150");
        waitElementBy(by,10);
        BasePage.click(by);
    }
    public static boolean verifyIfElementIsVisible(By by)throws Exception{
        scrollToElement(by);
        scrollTo("-150");
        return checkIfElementIsVisible(by);
    }

    public static boolean verifyCheckboxActiveOrNot(By by,String value)throws Exception{
        boolean validation = false;
        if(value!="" && value != null){
            switch(value){
                case "1":
                    validation = checkBoxIsActive(by);
                    break;
                case "0":
                    validation = !checkBoxIsActive(by);
                    break;
                default: throw new IllegalArgumentException("Unhandled index. Update business logic");
            }
        }else{
            validation=true;
        }
        return validation;
    }
    public static void addDeleteWithPlusButton(By by)throws Exception{
            waitUntilElementToBeSelected(by,10);
            scrollToElement(by);
            scrollTo("-150");
            wait(1000);
            click(by);
    }
    public static boolean validateCurrentDateTimeWithoutHour(By by,String value)throws Exception{
        boolean validation = false;
        if(value!="" && value!= null){
            wait(1000);
            scrollToElement(by);
            scrollTo("-150");
            String currentDateTimeWithoutHour = currentDateTimeWithoutHour();
            validation = currentDateTimeWithoutHour.contains(value);
        }else{
            validation=true;
        }
        return validation;
    }
    public static boolean verifyGetText(By by,String value)throws Exception{
        boolean validation = false;
        if(value!="" && value!= null){
            wait(1000);
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
        if(value!="" && value !=null){
        wait(1000);
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
        wait(1000);
        scrollToElement(pickerButton);
        scrollTo("-150");
        waitElementBy(pickerButton,10);
        click(pickerButton);
    }
    public static void searchPicker(By searchField,By recordPickerModalTableRow1,By orgPickerModalTableRow1Checkbox,String value)throws Exception{
        int delay = 10;
        waitElementBy(searchField,delay);
        write(searchField,value);
        wait(4000);
        if(verifyIfContains(recordPickerModalTableRow1,value)){
            wait(2000);
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
        waitUntilElementToBeSelected(by,10);
        scrollToElement(by);
        scrollTo("-150");
        waitUntilElementPresence(by,10);
        BasePage.click(by);
    }
    public static void selectOptionList(By by, String value,By dropDownList)throws Exception{
        int delay = 10;
        wait(1000);
        scrollToElement(by);
        scrollTo("-150");
        waitElementBy(by,delay);
        click(by);
        waitElementBy(dropDownList,delay);
        write(dropDownList,value);
        KeyPage.pressKey(dropDownList,"Enter");

    }
    public static void clickOptionList(By by, String value, By dropDownList, String tag)throws Exception{
        int delay = 10;
        wait(1000);
        scrollToElement(by);
        scrollTo("-150");
        waitElementBy(by,delay);
        click(by);
        wait(1000);
        BasePage.selectElementsList(dropDownList, tag);
        wait(2000);
        clickOnListOfElements(value);
    }
    public static void clickOptionList(By by, String value, By dropDownList)throws Exception{
        clickOptionList(by,value,dropDownList,"a");
    }
    public static void clickOptionListContains(By by, String value, By dropDownList, String tag)throws Exception{
        int delay = 10;
        wait(1000);
        scrollToElement(by);
        scrollTo("-150");
        waitElementBy(by,delay);
        click(by);
        wait(1000);
        BasePage.selectElementsList(dropDownList, tag);
        wait(2000);
        clickOnListOfElementsContains(value);
    }
    public static void clickOptionListContains(By by, String value, By dropDownList)throws Exception{
        clickOptionListContains(by,value,dropDownList,"a");
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
        waitElementBy(by,delay);
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
        try {
            waitUntilElementToBeSelected(By.xpath(getElementByText(text)),10);
            scrollToElement(By.xpath(getElementByText(text)));
            scrollTo("-150");
            wait(1000);
            BasePage.click(By.xpath(getElementByText(text)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(errorMessage);
        }
    }
}
