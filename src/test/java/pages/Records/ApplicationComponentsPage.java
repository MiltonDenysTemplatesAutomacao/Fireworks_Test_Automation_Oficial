package pages.Records;

import bean.ApplicationComponentBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;

public class ApplicationComponentsPage extends BasePage {

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
        return String.format("#s2id_person_application_%s_person_application_component_%s_application_component_received_date",component,group);
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
                scrollToElement(By.cssSelector(componentAddButton(component,group)));
                String receivedDateText = getText(By.cssSelector(receivedElement(component,group)));
                receivedDateValidation = receivedDateText.contains(applicationComponentBean.getReceivedDate());
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
                String recommenderText = getText(By.cssSelector(recommenderElement(component,group)));
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
