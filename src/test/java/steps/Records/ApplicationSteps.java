package steps.Records;


import bean.ApplicationBean;
import io.cucumber.java.en.And;
import pages.Records.ApplicationsPage;

public class ApplicationSteps {

    @And("I update application {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
            public static void updateApplication(String entryTerm, String major1, String componentStatus, String applicationType, String source, String receivedDate, String major2, String major3, String appliedGrade, String concentration, String housing, String minor, String completionDate, String comments,String group){
            ApplicationBean applicationBean = new ApplicationBean();
            applicationBean.setEntryTerm(entryTerm);
            applicationBean.setMajor1(major1);
            applicationBean.setComponentStatus(componentStatus);
            applicationBean.setApplicationType(applicationType);
            applicationBean.setReceivedDate(receivedDate);
            applicationBean.setSource(source);
            applicationBean.setMajor2(major2);
            applicationBean.setMajor3(major3);
            applicationBean.setAppliedGrade(appliedGrade);
            applicationBean.setConcentration(concentration);
            applicationBean.setHousing(housing);
            applicationBean.setMinor(minor);
            applicationBean.setCompletionDate(completionDate);
            applicationBean.setComments(comments);
            ApplicationsPage.updateApplication(applicationBean,group);
    }

    @And("I verify application {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
                public static void verifyApplication(String entryTerm, String major1, String componentStatus, String applicationType, String source, String receivedDate, String major2, String major3, String appliedGrade, String concentration, String housing, String minor, String completionDate, String comments,String group){
                ApplicationBean applicationBean = new ApplicationBean();
                applicationBean.setEntryTerm(entryTerm);
                applicationBean.setMajor1(major1);
                applicationBean.setComponentStatus(componentStatus);
                applicationBean.setApplicationType(applicationType);
                applicationBean.setReceivedDate(receivedDate);
                applicationBean.setSource(source);
                applicationBean.setMajor2(major2);
                applicationBean.setMajor3(major3);
                applicationBean.setAppliedGrade(appliedGrade);
                applicationBean.setConcentration(concentration);
                applicationBean.setHousing(housing);
                applicationBean.setMinor(minor);
                applicationBean.setCompletionDate(completionDate);
                applicationBean.setComments(comments);
                ApplicationsPage.verifyApplication(applicationBean,group);
        }
        @And("I click on save changes on Application")
            public static void clickSaveChanges(){
                    ApplicationsPage.clickSaveChanges();
            }
            @And("I add application {string}")
            public static void addApplication(String group){
                    ApplicationsPage.addApplication(group);
            }
}
