package pages.Records;

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
                String schoolStateText = getAtribute(By.cssSelector(schoolState(group)), "value");
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
                openSchoolPicker(educationSchoolBean.getSchool(),group);
            }
            if(educationSchoolBean.getSchoolCEEB()!=""){
            }
            if(educationSchoolBean.getSchoolCity()!=""){
            }
            if(educationSchoolBean.getSchoolState()!=""){
            }
            if(educationSchoolBean.getSchoolComments()!=""){
            }
            if(educationSchoolBean.getActive()!=""){
            }
            if(educationSchoolBean.getPrimary()!=""){
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
