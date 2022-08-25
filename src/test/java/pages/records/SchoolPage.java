package pages.records;

import bean.EducationSchoolBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;

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
            MainPage.addDeleteWithPlusButton(By.cssSelector(schoolRemoveButton(index)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void addSchool(String group){
        String passMessage = String.format(LogPage.ADD_SCHOOL_PASS,group);
        String failMessage = String.format(LogPage.ADD_SCHOOL_FAIL,group);
        try {
            MainPage.addDeleteWithPlusButton(By.cssSelector(schoolPlusSign(group)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void verifySchool(EducationSchoolBean educationSchoolBean, String group){
        String passMessage = String.format(LogPage.VERIFY_SCHOOL_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_SCHOOL_FAIL,group);

        try {
            if(MainPage.verifyGetAttribute(By.xpath(schoolField(group)),educationSchoolBean.getSchool())
                && MainPage.verifyGetAttribute(By.cssSelector(schoolCEEB(group)),educationSchoolBean.getSchoolCEEB())
                && MainPage.verifyGetAttribute(By.cssSelector(schoolCity(group)),educationSchoolBean.getSchoolCity())
                && MainPage.verifyGetText(By.cssSelector(schoolState(group)),educationSchoolBean.getSchoolState())
                && MainPage.verifyGetAttribute(By.cssSelector(schoolComments(group)),educationSchoolBean.getSchoolComments())
                && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(schoolActiveCheckbox(group)),educationSchoolBean.getActive())
                && MainPage.verifyCheckboxActiveOrNot(By.cssSelector(schoolPrimaryCheckbox(group)),educationSchoolBean.getPrimary())){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateSchool(EducationSchoolBean educationSchoolBean,String group){
        String passMessage = String.format(LogPage.UPDATE_SCHOOL_PASS,group);
        String failMessage = String.format(LogPage.UPDATE_SCHOOL_FAIL,group);
        try {
            if(educationSchoolBean.getSchool()!=""){
                MainPage.picker(By.cssSelector(pickerTriggerElement(group)),
                        By.cssSelector(SCHOOL_PICKER_SEARCH_FIELD),
                        By.cssSelector(SCHOOL_PICKER_MODAL_TABLE_ROW1),
                        By.xpath(SCHOOL_PICKER_MODAL_TABLE_ROW1_CHECKBOX),
                        By.cssSelector(SCHOOL_PICKER_MODAL_CHOOSE_BUTTON),
                        educationSchoolBean.getSchool());
            }
            if(educationSchoolBean.getSchoolCEEB()!=""){
                MainPage.fillField(By.cssSelector(schoolCEEB(group)), educationSchoolBean.getSchoolCEEB());
            }
            if(educationSchoolBean.getSchoolCity()!=""){
                MainPage.fillField(By.cssSelector(schoolCity(group)), educationSchoolBean.getSchoolCity());
            }
            if(educationSchoolBean.getSchoolState()!=""){
                MainPage.clickOptionList(By.cssSelector(schoolState(group)),
                        educationSchoolBean.getSchoolState(),
                        By.cssSelector(SCHOOL_STATE_LIST),
                        "a");
            }
            if(educationSchoolBean.getSchoolComments()!=""){
                MainPage.fillField(By.cssSelector(schoolComments(group)), educationSchoolBean.getSchoolComments());
            }
            if(educationSchoolBean.getActive()!=""){
                MainPage.click(By.cssSelector(schoolActiveCheckbox(group)));
            }
            if(educationSchoolBean.getPrimary()!=""){
                MainPage.click(By.cssSelector(schoolPrimaryCheckbox(group)));
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
