package pages.records.application;

import bean.ApplicationBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.*;

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
            waitUntilElementToBeSelected(By.cssSelector(applicationAddButton(group)),10);
            scrollToElement(By.cssSelector(applicationAddButton(group)));
            scrollTo("-150");
            click(By.cssSelector(applicationAddButton(group)));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void clickSaveChanges(){
        try {
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
        int verifyApplicationDelay = 10;

        boolean entryTermValidation = false;
        boolean componentStatusValidation = false;
        boolean applicationTypeValidation = false;
        boolean appliedGradeValidation = false;
        boolean housingValidation = false;
        boolean major1Validation = false;
        boolean major2Validation = false;
        boolean major3Validation = false;
        boolean concentrationValidation = false;
        boolean minorValidation = false;
        boolean receivedDateValidation = false;
        boolean completionDateValidation = false;
        boolean sourceValidation = false;
        boolean commentsValidation = false;

        try {
            if(applicationBean.getEntryTerm()!=""){
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                String entryTermText = getText(By.cssSelector(entryTermElement(group)));
                entryTermValidation = entryTermText.contains(applicationBean.getEntryTerm());
            }else{
                entryTermValidation = true;
            }
            if(applicationBean.getComponentStatus()!=""){
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                String componentStatusText = getText(By.cssSelector(componentStatusElement(group)));
                componentStatusValidation = componentStatusText.contains(applicationBean.getComponentStatus());
            }else{
                componentStatusValidation = true;
            }
            if(applicationBean.getApplicationType()!=""){
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                String applicationTypeText = getText(By.cssSelector(applicationTypeElement(group)));
                applicationTypeValidation = applicationTypeText.contains(applicationBean.getApplicationType());
            }else{
                applicationTypeValidation = true;
            }
            if(applicationBean.getAppliedGrade()!=""){
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                String appliedGradeText = getText(By.cssSelector(appliedGrade(group)));
                appliedGradeValidation = appliedGradeText.contains(applicationBean.getAppliedGrade());
            }else{
                appliedGradeValidation = true;
            }
            if(applicationBean.getHousing()!=""){
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                String housingText = getText(By.cssSelector(housingElement(group)));
                housingValidation = housingText.contains(applicationBean.getHousing());
            }else{
                housingValidation = true;
            }
            if(applicationBean.getMajor1()!=""){
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                String major1Text = getText(By.cssSelector(major1ElementLocator(group)));
                major1Validation = major1Text.contains(applicationBean.getMajor1());
            }else{
                major1Validation = true;
            }
            if(applicationBean.getMajor2()!=""){
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                String major2Text = getText(By.cssSelector(major2ElementLocator(group)));
                major2Validation = major2Text.contains(applicationBean.getMajor2());
            }else{
                major2Validation = true;
            }
            if(applicationBean.getMajor3()!=""){
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                String major3Text = getText(By.cssSelector(major3ElementLocator(group)));
                major3Validation = major3Text.contains(applicationBean.getMajor3());
            }else{
                major3Validation = true;
            }
            if(applicationBean.getConcentration()!=""){
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                String concentrationText = getText(By.cssSelector(concentrationElement(group)));
                concentrationValidation = concentrationText.contains(applicationBean.getConcentration());
            }else{
                concentrationValidation = true;
            }
            if(applicationBean.getMinor()!=""){
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                String minorText = getText(By.cssSelector(minorElement(group)));
                minorValidation = minorText.contains(applicationBean.getMinor());
            }else{
                minorValidation = true;
            }
            if(applicationBean.getReceivedDate()!=""){
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                String receivedDateText = getAtribute(By.cssSelector(receivedDateField(group)),"value");
                receivedDateValidation = receivedDateText.contains(applicationBean.getReceivedDate());
            }else{
                receivedDateValidation = true;
            }
            if(applicationBean.getCompletionDate()!=""){
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                String completionDateText = getAtribute(By.cssSelector(completionDateField(group)),"value");
                completionDateValidation = completionDateText.contains(applicationBean.getCompletionDate());
            }else{
                completionDateValidation = true;
            }
            if(applicationBean.getSource()!=""){
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                String sourceText = getText(By.cssSelector(sourceElement(group)));
                sourceValidation = sourceText.contains(applicationBean.getSource());
            }else{
                sourceValidation = true;
            }
            if(applicationBean.getComments()!=""){
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                String commentsText = getAtribute(By.cssSelector(commentsField(group)),"value");
                commentsValidation = commentsText.contains(applicationBean.getComments());
            }else{
                commentsValidation = true;
            }

            if(entryTermValidation
            && componentStatusValidation
            && applicationTypeValidation
            && appliedGradeValidation
            && housingValidation
            && major1Validation
            && major2Validation
            && major3Validation
            && concentrationValidation
            && minorValidation
            && receivedDateValidation
            && completionDateValidation
            && sourceValidation
            && commentsValidation){
                ExtentReportsSetUp.testingPass(passMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void updateApplication(ApplicationBean applicationBean, String group){

        String passMessage = String.format(LogPage.UPDATE_APPLICATION_PASS,group);
        String failMessage = String.format(LogPage.UPDATE_APPLICATION_FAIL,group);
        int updateApplicationDelay = 10;
        try {
            if(applicationBean.getEntryTerm()!=""){
                waitElementBy(By.cssSelector(applicationAddButton(group)),updateApplicationDelay);
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                waitElementBy(By.cssSelector(entryTermElement(group)),updateApplicationDelay);
                BasePage.click(By.cssSelector(entryTermElement(group)));
                waitElementBy(By.xpath(INPUT_FIELD),updateApplicationDelay);
                write(By.xpath(INPUT_FIELD),applicationBean.getEntryTerm());
                KeyPage.pressKey(By.xpath(INPUT_FIELD),"Enter");

            }
            if(applicationBean.getMajor1()!=""){
                waitElementBy(By.cssSelector(applicationAddButton(group)),updateApplicationDelay);
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                waitElementBy(By.cssSelector(major1ElementLocator(group)),updateApplicationDelay);
                BasePage.click(By.cssSelector(major1ElementLocator(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateApplicationDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(applicationBean.getMajor1());
            }
            if(applicationBean.getComponentStatus()!=""){
                waitElementBy(By.cssSelector(applicationAddButton(group)),updateApplicationDelay);
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                waitElementBy(By.cssSelector(componentStatusElement(group)),updateApplicationDelay);
                BasePage.click(By.cssSelector(componentStatusElement(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateApplicationDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(applicationBean.getComponentStatus());
            }
            if(applicationBean.getApplicationType()!=""){
                waitElementBy(By.cssSelector(applicationAddButton(group)),updateApplicationDelay);
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                waitElementBy(By.cssSelector(applicationTypeElement(group)),updateApplicationDelay);
                BasePage.click(By.cssSelector(applicationTypeElement(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateApplicationDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(applicationBean.getApplicationType());
                wait(1000);
            }
            if(applicationBean.getSource()!=""){
                waitElementBy(By.cssSelector(major2ElementLocator(group)),updateApplicationDelay);
                scrollToElement(By.cssSelector(major2ElementLocator(group)));
                waitElementBy(By.cssSelector(sourceElement(group)),updateApplicationDelay);
                BasePage.click(By.cssSelector(sourceElement(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateApplicationDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(applicationBean.getSource());
                wait(1000);
            }
            if(applicationBean.getReceivedDate()!=""){
                waitElementBy(By.cssSelector(receivedDateField(group)),updateApplicationDelay);
                scrollToElement(By.cssSelector(major2ElementLocator(group)));
                waitElementBy(By.cssSelector(receivedDateField(group)),updateApplicationDelay);
                KeyPage.erase(By.cssSelector(receivedDateField(group)));
                wait(1000);
                BasePage.write(By.cssSelector(receivedDateField(group)),applicationBean.getReceivedDate());
                wait(1000);
                KeyPage.pressKey(By.cssSelector(receivedDateField(group)), "Enter");

            }
            if(applicationBean.getMajor2()!=""){
                waitElementBy(By.cssSelector(applicationAddButton(group)),updateApplicationDelay);
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                waitElementBy(By.cssSelector(major2ElementLocator(group)),updateApplicationDelay);
                BasePage.click(By.cssSelector(major2ElementLocator(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateApplicationDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(applicationBean.getMajor2());
            }
            if(applicationBean.getMajor3()!=""){
                waitElementBy(By.cssSelector(applicationAddButton(group)),updateApplicationDelay);
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                waitElementBy(By.cssSelector(major3ElementLocator(group)),updateApplicationDelay);
                BasePage.click(By.cssSelector(major3ElementLocator(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateApplicationDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(applicationBean.getMajor3());
            }
            if(applicationBean.getAppliedGrade()!=""){
                waitElementBy(By.cssSelector(applicationAddButton(group)),updateApplicationDelay);
                scrollToElement(By.cssSelector(applicationAddButton(group)));
                waitElementBy(By.cssSelector(appliedGrade(group)),updateApplicationDelay);
                BasePage.click(By.cssSelector(appliedGrade(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateApplicationDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(applicationBean.getAppliedGrade());
            }
            if(applicationBean.getConcentration()!=""){
                waitElementBy(By.cssSelector(major2ElementLocator(group)),updateApplicationDelay);
                scrollToElement(By.cssSelector(major2ElementLocator(group)));
                waitElementBy(By.cssSelector(concentrationElement(group)),updateApplicationDelay);
                BasePage.click(By.cssSelector(concentrationElement(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateApplicationDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(applicationBean.getConcentration());
            }
            if(applicationBean.getHousing()!=""){
                waitElementBy(By.cssSelector(major2ElementLocator(group)),updateApplicationDelay);
                scrollToElement(By.cssSelector(major2ElementLocator(group)));
                waitElementBy(By.cssSelector(housingElement(group)),updateApplicationDelay);
                BasePage.click(By.cssSelector(housingElement(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateApplicationDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(applicationBean.getHousing());
            }
            if(applicationBean.getMinor()!=""){
                waitElementBy(By.cssSelector(major2ElementLocator(group)),updateApplicationDelay);
                scrollToElement(By.cssSelector(major2ElementLocator(group)));
                waitElementBy(By.cssSelector(minorElement(group)),updateApplicationDelay);
                BasePage.click(By.cssSelector(minorElement(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateApplicationDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(applicationBean.getMinor());
            }
            if(applicationBean.getCompletionDate()!=""){
                waitElementBy(By.cssSelector(major2ElementLocator(group)),updateApplicationDelay);
                scrollToElement(By.cssSelector(major2ElementLocator(group)));
                waitElementBy(By.cssSelector(completionDateField(group)),updateApplicationDelay);
                BasePage.click(By.cssSelector(completionDateField(group)));
                waitElementBy(By.cssSelector(PersonPage.SELECT_DROP),updateApplicationDelay);
                BasePage.selectElementsList(By.cssSelector(PersonPage.SELECT_DROP), "a");
                clickOnListOfElements(applicationBean.getCompletionDate());
            }
            if(applicationBean.getComments()!=""){
                waitElementBy(By.cssSelector(major2ElementLocator(group)),updateApplicationDelay);
                scrollToElement(By.cssSelector(major2ElementLocator(group)));
                waitElementBy(By.cssSelector(commentsField(group)),updateApplicationDelay);
                BasePage.write(By.cssSelector(commentsField(group)),applicationBean.getComments());
            }
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
}

