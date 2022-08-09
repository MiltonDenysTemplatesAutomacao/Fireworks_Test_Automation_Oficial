package pages.records;

import bean.EducationSchoolBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class SchoolPage extends BasePage{

    private static final String SCHOOL_PICKER_SEARCH_FIELD = "#schoolPickerModalTableControlsTableSearch";
    private static final String SCHOOL_PICKER_MODAL_TABLE_ROW1 = "#schoolPickerModalTable_row_0";
    private static final String SCHOOL_PICKER_MODAL_TABLE_ROW1_CHECKBOX = "//table[@id='schoolPickerModalTable']/tbody/tr/th/div/input";
    private static final String SCHOOL_PICKER_MODAL_CHOOSE_BUTTON = "#modalSubmitButtonschoolPicker";
    private static final String SCHOOL_STATE_LIST = "#select2-chosen-91";

    private static String schoolPlusSign(String index){
        return String.format("#person_school_%s_add",index);
    }
    private static String pickerTriggerElement(String index){
        return String.format("#person_school_%s_recordPickerTrigger",index);
    }
    private static String schoolField(String index){
        return String.format("//*[@id='person_school_%s_school_reltn_id'][1]",index);
    }
    private static String schoolCEEB(String index){
        return String.format("#person_school_%s_school_ceeb_code",index);
    }
    private static String schoolCity(String index){
        return String.format("#person_school_%s_school_city",index);
    }
    private static String schoolState(String index){
        return String.format("#s2id_person_school_%s_school_state",index);
    }
    private static String schoolComments(String index){
        return String.format("#person_school_%s_school_comments",index);
    }
    private static String schoolActiveCheckbox(String index){
        return String.format("#person_school_%s_active",index);
    }
    private static String schoolPrimaryCheckbox(String index){
        return String.format("#person_school_%s_primary",index);
    }
    private static String schoolRemoveButton(String index){
        return String.format("#person_school_%s_remove",index);
    }

    public static void clickChooseButton(){
        try {
            waitUntilElementToBeSelected(By.cssSelector(SCHOOL_PICKER_MODAL_CHOOSE_BUTTON),20);
            click(By.cssSelector(SCHOOL_PICKER_MODAL_CHOOSE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_CHOOSE_BUTTON_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_CHOOSE_BUTTON_FAIL);
        }
    }
    public static void searchPickerSchool(String school, String group){
        String passMessage = String.format(LogPage.SEARCH_PICKER_SCHOOL_PASS,school,group);
        String failMessage = String.format(LogPage.SEARCH_PICKER_SCHOOL_FAIL,school,group);

        try {
            scrollToElement(By.cssSelector(schoolPlusSign(group)));
            waitUntilElementToBeSelected(By.cssSelector(pickerTriggerElement(group)),20);
            click(By.cssSelector(pickerTriggerElement(group)));
            waitElementBy(By.cssSelector(SCHOOL_PICKER_SEARCH_FIELD),20);
            write(By.cssSelector(SCHOOL_PICKER_SEARCH_FIELD),school);
            wait(2000);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void deleteSchool(String index){
        String passMessage = String.format(LogPage.DELETE_SCHOOL_PASS,index);
        String failMessage = String.format(LogPage.DELETE_SCHOOL_FAIL,index);
        try {
            waitUntilElementToBeSelected(By.cssSelector(schoolRemoveButton(index)),20);
            scrollToElement(By.cssSelector(schoolRemoveButton(index)));
            scrollTo("-150");
            click(By.cssSelector(schoolRemoveButton(index)));
            wait(2000);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void addSchool(String group){
        String passMessage = String.format(LogPage.ADD_SCHOOL_PASS,group);
        String failMessage = String.format(LogPage.ADD_SCHOOL_FAIL,group);
        try {
            scrollToElement(By.cssSelector(schoolPlusSign(group)));
            scrollTo("-100");
            waitUntilElementToBeSelected(By.cssSelector(schoolPlusSign(group)),20);
            click(By.cssSelector(schoolPlusSign(group)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void verifySchool(EducationSchoolBean educationSchoolBean, String group){
        boolean schoolValidation = false;
        boolean schoolCEEBValidation = false;
        boolean schoolCityValidation = false;
        boolean schoolStateValidation = false;
        boolean schoolCommentsValidation = false;
        boolean activeValidation = false;
        boolean primaryValidation = false;

        String passMessage = String.format(LogPage.VERIFY_SCHOOL_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_SCHOOL_FAIL,group);

        try {
            if (educationSchoolBean.getSchool() != "") {
                scrollToElement(By.cssSelector(schoolPlusSign(group)));
                String schoolText = getAtribute(By.xpath(schoolField(group)), "value");
                schoolValidation = schoolText.contains(educationSchoolBean.getSchool());
            } else {
                schoolValidation = true;
            }
            if (educationSchoolBean.getSchoolCEEB() != "") {
                scrollToElement(By.cssSelector(schoolPlusSign(group)));
                String schoolCEEBText = getAtribute(By.cssSelector(schoolCEEB(group)), "value");
                schoolCEEBValidation = schoolCEEBText.contains(educationSchoolBean.getSchoolCEEB());
            } else {
                schoolCEEBValidation = true;
            }
            if (educationSchoolBean.getSchoolCity() != "") {
                scrollToElement(By.cssSelector(schoolPlusSign(group)));
                String schoolCityText = getAtribute(By.cssSelector(schoolCity(group)), "value");
                schoolCityValidation = schoolCityText.contains(educationSchoolBean.getSchoolCity());
            } else {
                schoolCityValidation = true;
            }
            if (educationSchoolBean.getSchoolState() != "") {
                scrollToElement(By.cssSelector(schoolPlusSign(group)));
                String schoolStateText = getText(By.cssSelector(schoolState(group)));
                schoolStateValidation = schoolStateText.contains(educationSchoolBean.getSchoolState());
            } else {
                schoolStateValidation = true;
            }
            if (educationSchoolBean.getSchoolComments() != "") {
                scrollToElement(By.cssSelector(schoolPlusSign(group)));
                String schoolCommentsText = getAtribute(By.cssSelector(schoolComments(group)), "value");
                schoolCommentsValidation = schoolCommentsText.contains(educationSchoolBean.getSchoolComments());
            } else {
                schoolCommentsValidation = true;
            }
            if(educationSchoolBean.getActive()!=""){
                switch (educationSchoolBean.getActive()){
                    case "1":
                        activeValidation = checkBoxIsActive(By.cssSelector(schoolActiveCheckbox(group)));
                        break;
                    case "0":
                        activeValidation = !checkBoxIsActive(By.cssSelector(schoolActiveCheckbox(group)));
                        break;
                    default: throw new IllegalArgumentException("Active Checkbox not verified");
                }
            }else{
                activeValidation = true;
            }
            if(educationSchoolBean.getPrimary()!=""){
                switch (educationSchoolBean.getPrimary()){
                    case "1":
                        primaryValidation = checkBoxIsActive(By.cssSelector(schoolPrimaryCheckbox(group)));
                        break;
                    case "0":
                        primaryValidation = !checkBoxIsActive(By.cssSelector(schoolPrimaryCheckbox(group)));
                        break;
                    default: throw new IllegalArgumentException("Active Checkbox not verified");
                }
            }else{
                primaryValidation = true;
            }
            if(schoolValidation
                    && schoolCEEBValidation
                    && schoolCityValidation
                    && schoolStateValidation
                    && schoolCommentsValidation
                    && activeValidation
                    && primaryValidation){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }


    public static void updateSchool(EducationSchoolBean educationSchoolBean,String group){
        int updateSchoolDelay = 0;
        String passMessage = String.format(LogPage.UPDATE_SCHOOL_PASS,group);
        String failMessage = String.format(LogPage.UPDATE_SCHOOL_FAIL,group);
        try {
            if(educationSchoolBean.getSchool()!=""){
                scrollToElement(By.cssSelector(schoolPlusSign(group)));
                openSchoolPicker(educationSchoolBean.getSchool(),group);
            }
            if(educationSchoolBean.getSchoolCEEB()!=""){
                scrollToElement(By.cssSelector(schoolPlusSign(group)));
                waitElementBy(By.cssSelector(schoolCEEB(group)),updateSchoolDelay);
                write(By.cssSelector(schoolCEEB(group)),educationSchoolBean.getSchoolCEEB());

            }
            if(educationSchoolBean.getSchoolCity()!=""){
                scrollToElement(By.cssSelector(schoolPlusSign(group)));
                waitElementBy(By.cssSelector(schoolCity(group)),updateSchoolDelay);
                write(By.cssSelector(schoolCity(group)),educationSchoolBean.getSchoolCity());

            }
            if(educationSchoolBean.getSchoolState()!=""){
                scrollToElement(By.cssSelector(schoolPlusSign(group)));
                waitElementBy(By.cssSelector(schoolState(group)),updateSchoolDelay);
                BasePage.click(By.cssSelector(schoolState(group)));
                wait(1000);
                BasePage.selectElementsList(By.cssSelector(SCHOOL_STATE_LIST), "a");
                wait(500);
                clickOnListOfElements(educationSchoolBean.getSchoolState());
            }
            if(educationSchoolBean.getSchoolComments()!=""){
                scrollToElement(By.cssSelector(schoolPlusSign(group)));
                waitElementBy(By.cssSelector(schoolComments(group)),updateSchoolDelay);
                write(By.cssSelector(schoolComments(group)),educationSchoolBean.getSchoolComments());
            }
            if(educationSchoolBean.getActive()!=""){
                scrollToElement(By.cssSelector(schoolPlusSign(group)));
                waitElementBy(By.cssSelector(schoolActiveCheckbox(group)),updateSchoolDelay);
                click(By.cssSelector(schoolActiveCheckbox(group)));
            }
            if(educationSchoolBean.getPrimary()!=""){
                scrollToElement(By.cssSelector(schoolPlusSign(group)));
                waitElementBy(By.cssSelector(schoolPrimaryCheckbox(group)),updateSchoolDelay);
                click(By.cssSelector(schoolPrimaryCheckbox(group)));
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void openSchoolPicker(String educationSchool,String group){
        try {
            scrollToElement(By.cssSelector(schoolPlusSign(group)));
            waitUntilElementToBeSelected(By.cssSelector(pickerTriggerElement(group)),20);
            click(By.cssSelector(pickerTriggerElement(group)));
            searchOpenSchoolPicker(educationSchool);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.OPEN_SCHOOL_PICKER_FAIL);
        }
    }

    public static void searchOpenSchoolPicker(String schoolPicker){
        try {
            waitElementBy(By.cssSelector(SCHOOL_PICKER_SEARCH_FIELD),20);
            write(By.cssSelector(SCHOOL_PICKER_SEARCH_FIELD),schoolPicker);
            wait(2000);
            String schoolPickerText = getText(By.cssSelector(SCHOOL_PICKER_MODAL_TABLE_ROW1));
            if(!schoolPickerText.contains("No table data available.")){
                click(By.xpath(SCHOOL_PICKER_MODAL_TABLE_ROW1_CHECKBOX));
                waitUntilElementToBeSelected(By.cssSelector(SCHOOL_PICKER_MODAL_CHOOSE_BUTTON),20);
                click(By.cssSelector(SCHOOL_PICKER_MODAL_CHOOSE_BUTTON));
            }else{
                FailureDelegatePage.handlePageException(LogPage.SEARCH_OPEN_SCHOOL_PICKER_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SEARCH_OPEN_SCHOOL_PICKER_FAIL);
        }
    }
}
