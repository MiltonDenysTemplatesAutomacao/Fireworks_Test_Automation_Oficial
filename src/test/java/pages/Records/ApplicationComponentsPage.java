package pages.Records;

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
        int updateApplicationComponentDelay = 10;
        String passMessage = String.format(LogPage.UPDATE_APPLICATION_COMPONENT_PASS,group,component);
        String failMessage = String.format(LogPage.UPDATE_APPLICATION_COMPONENT_FAIL,group,component);
        try {
            if(applicationComponentBean.getComponentItem()!=""){
                waitElementBy(By.cssSelector(componentAddButton(component,group)),updateApplicationComponentDelay);
                scrollToElement(By.cssSelector(componentAddButton(component,group)));
                click(By.cssSelector(componentElement(component,group)));
                waitElementBy(By.xpath(ApplicationsPage.INPUT_FIELD),updateApplicationComponentDelay);
                write(By.xpath(ApplicationsPage.INPUT_FIELD),applicationComponentBean.getComponentItem());
                KeyPage.pressKey(By.xpath(ApplicationsPage.INPUT_FIELD),"Enter");
            }
            if(applicationComponentBean.getReceivedValue()!=""){
                waitElementBy(By.cssSelector(componentAddButton(component,group)),updateApplicationComponentDelay);
                scrollToElement(By.cssSelector(componentAddButton(component,group)));
                click(By.cssSelector(receivedElement(component,group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateApplicationComponentDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(applicationComponentBean.getReceivedValue());
                wait(2000);
            }
            if(applicationComponentBean.getReceivedDate()!=""){
                String campusTimeZoneDate = currentDateTimeWithoutHour();
                waitElementBy(By.cssSelector(componentAddButton(component,group)),updateApplicationComponentDelay);
                scrollToElement(By.cssSelector(componentAddButton(component,group)));
                waitElementBy(By.cssSelector(componentReceivedDateField(component,group)),updateApplicationComponentDelay);
                KeyPage.erase(By.cssSelector(componentReceivedDateField(component,group)));
                wait(1000);
                write(By.cssSelector(componentReceivedDateField(component,group)),campusTimeZoneDate);
                wait(1000);
                KeyPage.pressKey(By.cssSelector(componentReceivedDateField(component,group)), "Enter");
            }
            if(applicationComponentBean.getRequiredValue()!=""){
                waitElementBy(By.cssSelector(componentAddButton(component,group)),updateApplicationComponentDelay);
                scrollToElement(By.cssSelector(componentAddButton(component,group)));
                click(By.cssSelector(receivedElement(component,group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateApplicationComponentDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(applicationComponentBean.getRequiredValue());
            }
            if(applicationComponentBean.getRecommender()!=""){
                wait(1000);
                pickRecommender(applicationComponentBean.getRecommender(),component,group);
            }
            if(applicationComponentBean.getComment()!=""){
                waitElementBy(By.cssSelector(componentAddButton(component,group)),updateApplicationComponentDelay);
                scrollToElement(By.cssSelector(componentAddButton(component,group)));
                BasePage.write(By.cssSelector(componentCommentField(component,group)),applicationComponentBean.getComment());
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
        boolean componentItemValidation = false;
        boolean receivedValueValidation = false;
        boolean receivedDateValidation = false;
        boolean requiredValueValidation = false;
        boolean recommenderValidation = false;
        boolean commentValidation = false;
        String passMessage = String.format(LogPage.VERIFY_APPLICATION_COMPONENT_PASS,group,component);
        String failMessage = String.format(LogPage.VERIFY_APPLICATION_COMPONENT_FAIL,group,component);
        try {
            if(applicationComponentBean.getComponentItem()!=""){
                scrollToElement(By.cssSelector(componentAddButton(component,group)));
                String componentItemText = getText(By.cssSelector(componentElement(component,group)));
                componentItemValidation = componentItemText.contains(applicationComponentBean.getComponentItem());
            }else{
                componentItemValidation=true;
            }
            if(applicationComponentBean.getReceivedValue()!=""){
                scrollToElement(By.cssSelector(componentAddButton(component,group)));
                String receivedValueText = getText(By.cssSelector(receivedElement(component,group)));
                receivedValueValidation = receivedValueText.contains(applicationComponentBean.getReceivedValue());
            }else{
                receivedValueValidation=true;
            }
            if(applicationComponentBean.getReceivedDate()!=""){
                String campusTimeZoneDate = currentDateTimeWithoutHour();
                scrollToElement(By.cssSelector(componentAddButton(component,group)));
                String receivedDateText = getAtribute(By.cssSelector(componentReceivedDateField(component,group)),"value");
                receivedDateValidation = receivedDateText.contains(campusTimeZoneDate);
            }else{
                receivedDateValidation=true;
            }
            if(applicationComponentBean.getRequiredValue()!=""){
                scrollToElement(By.cssSelector(componentAddButton(component,group)));
                String requiredValueText = getText(By.cssSelector(requiredElement(component,group)));
                requiredValueValidation = requiredValueText.contains(applicationComponentBean.getRequiredValue());
            }else{
                requiredValueValidation=true;
            }
            if(applicationComponentBean.getRecommender()!=""){
                scrollToElement(By.cssSelector(componentAddButton(component,group)));
                String recommenderText = getAtribute(By.cssSelector(recommenderElement(component,group)),"value");
                recommenderValidation = recommenderText.contains(applicationComponentBean.getRecommender());
            }else{
                recommenderValidation=true;
            }
            if(applicationComponentBean.getComment()!=""){
                scrollToElement(By.cssSelector(componentAddButton(component,group)));
                String commentsText = getText(By.cssSelector(componentCommentField(component,group)));
                commentValidation = commentsText.contains(applicationComponentBean.getComment());
            }else{
                commentValidation=true;
            }

            if(componentItemValidation
            && receivedValueValidation
            && receivedDateValidation
            && requiredValueValidation
            && recommenderValidation
            && commentValidation){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}
