package pages.records.application;

import bean.ApplicationBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.PersonPage;
import pages.MainPage;

public class ApplicationsPage extends BasePage {


    public static final String INPUT_FIELD = "//input[starts-with(@id, 's2id_autogen') and contains(@id, '_search') and contains(@aria-activedescendant, 'select2-result-label')]";
    private static final String APPLICATIONS_SAVE_CHANGES_BUTTON = "#saveChangesBtnPersonApplications";

    private static String applicationAddButton(String group){
        return String.format("#person_application_%s_add",group);
    }
    private static String entryTermElement(String group){
        return String.format("#s2id_person_application_%s_application_entry_term",group);
    }
    private static String major1ElementLocator(String group){
        return String.format("#s2id_person_application_%s_application_major_1",group);
    }
    private static String major2ElementLocator(String group){
        return String.format("#s2id_person_application_%s_application_major_2",group);
    }
    private static String major3ElementLocator(String group){
        return String.format("#s2id_person_application_%s_application_major_3",group);
    }
    private static String componentStatusElement(String group){
        return String.format("#s2id_person_application_%s_application_status",group);
    }
    private static String applicationTypeElement(String group){
        return String.format("#s2id_person_application_%s_application_type",group);
    }
    private static String sourceElement(String group){
        return String.format("#s2id_person_application_%S_application_source",group);
    }
    private static String receivedDateField(String group){
        return String.format("#person_application_%s_application_started_date",group);
    }
    private static String appliedGrade(String group){
        return String.format("#s2id_person_application_%s_application_for_grade",group);
    }
    private static String concentrationElement(String group){
        return String.format("#s2id_person_application_%s_application_concentration",group);
    }
    private static String housingElement(String group){
        return String.format("#s2id_person_application_%s_application_housing",group);
    }
    private static String completionDateField(String group){
        return String.format("#person_application_%s_application_comments",group);
    }
    private static String commentsField(String group){
        return String.format("#person_application_%s_application_completion_date",group);
    }
    private static String minorElement(String group){
        return String.format("#person_application_%s_application_minor",group);
    }

    public static void addApplication(String group){
        String passMessage = String.format(LogPage.ADD_APPLICATION_PASS,group);
        String failMessage = String.format(LogPage.ADD_APPLICATION_FAIL,group);
        try {
            MainPage.addDeleteWithPlusButton(By.cssSelector(applicationAddButton(group)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void clickSaveChanges(){
        try {
            wait(1000);
            scrollToTheBottom();
            waitElementBy(By.cssSelector(APPLICATIONS_SAVE_CHANGES_BUTTON),20);
            click(By.cssSelector(APPLICATIONS_SAVE_CHANGES_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_SAVE_CHANGES_APPLICATION_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_SAVE_CHANGES_APPLICATION_FAIL);
        }
    }
    public static void verifyApplication(ApplicationBean applicationBean, String group){
        String passMessage = String.format(LogPage.VERIFY_APPLICATION_PASS,group);
        String failMessage = String.format(LogPage.VERIFY_APPLICATION_FAIL,group);


        try {
            if(MainPage.verifyGetText(By.cssSelector(entryTermElement(group)),applicationBean.getEntryTerm())
                    && MainPage.verifyGetText(By.cssSelector(componentStatusElement(group)),applicationBean.getComponentStatus())
                    && MainPage.verifyGetText(By.cssSelector(applicationTypeElement(group)),applicationBean.getApplicationType())
                    && MainPage.verifyGetText(By.cssSelector(appliedGrade(group)),applicationBean.getAppliedGrade())
                    && MainPage.verifyGetText(By.cssSelector(housingElement(group)),applicationBean.getHousing())
                    && MainPage.verifyGetText(By.cssSelector(major1ElementLocator(group)),applicationBean.getMajor1())
                    && MainPage.verifyGetText(By.cssSelector(major2ElementLocator(group)),applicationBean.getMajor2())
                    && MainPage.verifyGetText(By.cssSelector(major3ElementLocator(group)),applicationBean.getMajor3())
                    && MainPage.verifyGetText(By.cssSelector(concentrationElement(group)),applicationBean.getConcentration())
                    && MainPage.verifyGetText(By.cssSelector(minorElement(group)),applicationBean.getMinor())
                    && MainPage.verifyGetAttribute(By.cssSelector(receivedDateField(group)),applicationBean.getReceivedDate())
                    && MainPage.verifyGetAttribute(By.cssSelector(completionDateField(group)),applicationBean.getCompletionDate())
                    && MainPage.verifyGetText(By.cssSelector(sourceElement(group)),applicationBean.getSource())
                    && MainPage.verifyGetAttribute(By.cssSelector(commentsField(group)),applicationBean.getComments())){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateApplication(ApplicationBean applicationBean, String group){

        String passMessage = String.format(LogPage.UPDATE_APPLICATION_PASS,group);
        String failMessage = String.format(LogPage.UPDATE_APPLICATION_FAIL,group);
        try {
            if(applicationBean.getEntryTerm()!=""){
                MainPage.clickOptionList(By.cssSelector(entryTermElement(group)),
                        applicationBean.getEntryTerm(),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(applicationBean.getMajor1()!=""){
                MainPage.clickOptionList(By.cssSelector(major1ElementLocator(group)),
                        applicationBean.getMajor1(),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(applicationBean.getComponentStatus()!=""){
                MainPage.clickOptionList(By.cssSelector(componentStatusElement(group)),
                        applicationBean.getComponentStatus(),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(applicationBean.getApplicationType()!=""){
                MainPage.clickOptionList(By.cssSelector(applicationTypeElement(group)),
                        applicationBean.getApplicationType(),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(applicationBean.getSource()!=""){
                MainPage.clickOptionList(By.cssSelector(sourceElement(group)),
                        applicationBean.getSource(),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(applicationBean.getReceivedDate()!=""){
                MainPage.fillDateField(By.cssSelector(receivedDateField(group)), applicationBean.getReceivedDate());
            }
            if(applicationBean.getMajor2()!=""){
                MainPage.clickOptionList(By.cssSelector(major2ElementLocator(group)),
                        applicationBean.getMajor2(),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(applicationBean.getMajor3()!=""){
                MainPage.clickOptionList(By.cssSelector(major3ElementLocator(group)),
                        applicationBean.getMajor3(),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(applicationBean.getAppliedGrade()!=""){
                MainPage.clickOptionList(By.cssSelector(appliedGrade(group)),
                        applicationBean.getAppliedGrade(),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(applicationBean.getConcentration()!=""){
                MainPage.clickOptionList(By.cssSelector(concentrationElement(group)),
                        applicationBean.getConcentration(),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(applicationBean.getHousing()!=""){
                MainPage.clickOptionList(By.cssSelector(housingElement(group)),
                        applicationBean.getHousing(),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(applicationBean.getMinor()!=""){
                MainPage.clickOptionList(By.cssSelector(minorElement(group)),
                        applicationBean.getMinor(),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(applicationBean.getCompletionDate()!=""){
                MainPage.clickOptionList(By.cssSelector(completionDateField(group)),
                        applicationBean.getCompletionDate(),
                        By.cssSelector(PersonPage.SELECT_DROP));
            }
            if(applicationBean.getComments()!=""){
                MainPage.fillField(By.cssSelector(major2ElementLocator(group)), applicationBean.getComments());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}

