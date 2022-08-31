package pages.records.application;

import bean.ApplicationComponentBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.*;

public class ApplicationComponentsPage extends BasePage {

    private static final String PERSON_PICKER_MODAL_SEARCH_FIELD = "#personPickerModalTableControlsTableSearch";
    private static final String PERSON_PICKER_MODAL_TABLE_ROW1 = "#personPickerModalTable_row_0";
    private static final String PERSON_PICKER_MODAL_TABLE_ROW1_CHECKBOX = "#personPickerModalTable_row_0_col_0";
    private static final String PERSON_PICKER_MODAL_CHOOSE_BUTTON = "#modalSubmitButtonpersonPicker";

    private static String componentAddButton(String component,String group){
        return String.format("#person_application_%s_person_application_component_%s_add",component,group);
    }
    private static String componentElement(String component,String group){
        return String.format("#s2id_person_application_%s_person_application_component_%s_application_component_code",component,group);
    }
    private static String receivedElement(String component,String group){
        return String.format("#s2id_person_application_%s_person_application_component_%s_application_component_received",component,group);
    }
    private static String componentReceivedDateField(String component,String group){
        return String.format("#person_application_%s_person_application_component_%s_application_component_received_date",component,group);
    }
    private static String requiredElement(String component,String group){
        return String.format("#s2id_person_application_%s_person_application_component_%s_application_component_required",component,group);
    }
    private static String recommenderElement(String component,String group){
        return String.format("#person_application_%s_person_application_component_%s_recommender_reltn_id",component,group);
    }
    private static String componentCommentField(String component,String group){
        return String.format("#person_application_%s_person_application_component_%s_application_component_comment",component,group);
    }
    private static String recommenderPickerButton(String component,String group){
        return String.format("#person_application_%s_person_application_component_%s_recordPickerTrigger",component,group);
    }

    public static void recommenderPickerModalChooseButton()throws Exception{
        BasePage.click(By.cssSelector(PERSON_PICKER_MODAL_CHOOSE_BUTTON));
    }

    public static void searchRecommender (String searchName)throws Exception{
        try {
            waitElementBy(By.cssSelector(PERSON_PICKER_MODAL_SEARCH_FIELD),10);
            BasePage.write(By.cssSelector(PERSON_PICKER_MODAL_SEARCH_FIELD), searchName);
            wait(3000);
            if(verifyIfContains(By.cssSelector(PERSON_PICKER_MODAL_TABLE_ROW1),searchName)){
                wait(1000);
                BasePage.click(By.cssSelector(PERSON_PICKER_MODAL_TABLE_ROW1_CHECKBOX));
            }else{
                FailureDelegatePage.handlePageException(LogPage.SEARCH_RECOMMENDER_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.SEARCH_RECOMMENDER_FAIL);
        }
    }

    public static void pickRecommender(String recommender,String component,String group){
        try {
            waitElementBy(By.cssSelector(recommenderPickerButton(component,group)),20);
            BasePage.click(By.cssSelector(recommenderPickerButton(component,group)));
            searchRecommender(recommender);
            recommenderPickerModalChooseButton();
            wait(2000);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.PICK_RECOMMENDER_FAIL);
        }
    }
    /*
     * to update Received Date it is necessary to put any string on Received Date field on step, I selected "1" as a pattern
     */
    public static void updateApplicationComponent(ApplicationComponentBean applicationComponentBean, String group,String component){
        String passMessage = String.format(LogPage.UPDATE_APPLICATION_COMPONENT_PASS,group,component);
        String failMessage = String.format(LogPage.UPDATE_APPLICATION_COMPONENT_FAIL,group,component);
        try {
            if(applicationComponentBean.getComponentItem()!=""){
                MainPage.selectOptionList(By.cssSelector(componentElement(component,group)),
                        applicationComponentBean.getComponentItem(),
                        By.xpath(ApplicationsPage.INPUT_FIELD));
            }
            if(applicationComponentBean.getReceivedValue()!=""){
                MainPage.clickOptionList(By.cssSelector(receivedElement(component,group)),
                        applicationComponentBean.getReceivedValue(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(applicationComponentBean.getReceivedDate()!=""){
                String campusTimeZoneDate = currentDateTimeWithoutHour();
                MainPage.fillDateField(By.cssSelector(componentReceivedDateField(component,group)), campusTimeZoneDate);
            }
            if(applicationComponentBean.getRequiredValue()!=""){
                MainPage.clickOptionList(By.cssSelector(receivedElement(component,group)),
                        applicationComponentBean.getRequiredValue(),
                        By.cssSelector(PersonPage.SELECT_DROP),
                        "a");
            }
            if(applicationComponentBean.getRecommender()!=""){
                MainPage.picker(By.cssSelector(recommenderPickerButton(component,group)),
                        By.cssSelector(PERSON_PICKER_MODAL_SEARCH_FIELD),
                        By.cssSelector(PERSON_PICKER_MODAL_TABLE_ROW1),
                        By.cssSelector(PERSON_PICKER_MODAL_TABLE_ROW1_CHECKBOX),
                        By.cssSelector(PERSON_PICKER_MODAL_CHOOSE_BUTTON),
                        applicationComponentBean.getRecommender());
            }
            if(applicationComponentBean.getComment()!=""){
                MainPage.fillField(By.cssSelector(componentAddButton(component,group)), applicationComponentBean.getComment());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    /*
     * to verify Received Date it is necessary to put any string on Received Date field on step, I selected "1" as a pattern
     */
    public static void verifyApplicationComponent(ApplicationComponentBean applicationComponentBean, String group,String component){
        String campusTimeZoneDate = "";
        String passMessage = String.format(LogPage.VERIFY_APPLICATION_COMPONENT_PASS,group,component);
        String failMessage = String.format(LogPage.VERIFY_APPLICATION_COMPONENT_FAIL,group,component);

        try {
            if(applicationComponentBean.getReceivedDate()!=""){
                campusTimeZoneDate = currentDateTimeWithoutHour();
            }else{
                campusTimeZoneDate= "";
            }
            if(MainPage.verifyGetText(By.cssSelector(componentElement(component,group)),applicationComponentBean.getComponentItem())
                    && MainPage.verifyGetText(By.cssSelector(receivedElement(component,group)),applicationComponentBean.getReceivedValue())
                    && MainPage.verifyGetAttribute(By.cssSelector(componentReceivedDateField(component,group)),campusTimeZoneDate)
                    && MainPage.verifyGetText(By.cssSelector(requiredElement(component,group)),applicationComponentBean.getRequiredValue())
                    && MainPage.verifyGetAttribute(By.cssSelector(recommenderElement(component,group)),applicationComponentBean.getRecommender())
                    && MainPage.verifyGetText(By.cssSelector(componentCommentField(component,group)),applicationComponentBean.getComment())){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
