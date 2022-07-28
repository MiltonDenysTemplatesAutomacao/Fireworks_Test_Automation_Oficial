package steps.Records;

import bean.ApplicationComponentBean;
import io.cucumber.java.en.And;
import pages.Records.ApplicationComponentsPage;

public class ApplicationComponentsSteps {

    @And("I verify application component {string}, {string}, {string}, {string}, {string}, {string} component {string} group {string}")
    public static void verifyApplicationComponent(String componentItem, String receivedValue,String receivedDate,String requiredValue,String recommender,String comment, String group,String component){
        ApplicationComponentBean applicationComponentBean = new ApplicationComponentBean();
        applicationComponentBean.setComponentItem(componentItem);
        applicationComponentBean.setReceivedValue(receivedValue);
        applicationComponentBean.setReceivedDate(receivedDate);
        applicationComponentBean.setRequiredValue(requiredValue);
        applicationComponentBean.setRecommender(recommender);
        applicationComponentBean.setComment(comment);
        ApplicationComponentsPage.verifyApplicationComponent(applicationComponentBean,group,component);
    }

}
