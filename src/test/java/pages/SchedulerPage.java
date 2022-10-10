package pages;

import bean.SchedulerBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;

public class SchedulerPage extends BasePage{
    public static final String JOBS_MANAGER_TABLE = "#schedulerJobTable";
    public static final String JOB_NAME_FIELD = "#schedule_name";
    public static final String CREATE_JOB_BUTTON = "#top-controls-create-new-job";
    public static final String CREATE_JOB_BUTTON_LIST = "#top-controls-create-new-job-dropdown-menu";
    public static final String PICK_BUTTON = "#picker_input_trigger_button";
    public static final String PICKER_SEARCH_FIELD = "#emailPickerModalTableControlsTableSearch";
    public static final String PICKER_MODAL_TABLE_ROW1_COL1 = "#emailPickerModalTable_row_0_col_0";
    public static final String PICKER_MODAL_CHOOSE_BUTTON = "#modalSubmitButtonemailPicker";
    public static final String START_DATE_TIME_FIELD = "#start_date";
    public static final String TIME_ZONE_DROPDOWN = "#s2id_timezone_id.select2-container.form-control.select2.required a.select2-choice";
    public static final String DROPDOWN_INPUT_FIELD_ELEMENT = "#select2-drop.select2-drop.select2-display-none.select2-with-searchbox.select2-drop-active div.select2-search input";
    public static final String FREQUENCY1_DAY_OF_WEEK_DROPDOWN = "#s2id_frequency_0_weekday.select2-container.form-control.repeat.select2.required a.select2-choice";
    public static final String FREQUENCY1_DROPDOWN = "#s2id_frequency_0_frequency";
    public static final String FREQUENCY1_TIME_FIELD = "#frequency_0_time";
    public static final String FREQUENCY1_ENDS_DATE_TIME_FIELD = "#frequency_0_end";
    public static final String NOTIFY_RECIPIENTS_EMAIL_FIELD = "#notification_recipients";
    public static final String JOB_SAVE_BUTTON = "#scheduleFormSubmitButton";
    public static final String JOBS_MANAGER_SEARCH_FIELD = "#schedulerJobTableControlsTableSearch";
    public static final String JOBS_MANAGER_TABLE_ROW1_COL1 = "#schedulerJobTable_row_0_col_0";
    public static final String SCHEDULED_TASK_NAME_FIELD = "#activity_id_readable";
    public static final String EXCLUDE1_DATE_FIELD = "#exclude_0_date";
    public static final String JOB_ACTIVE_CHECKBOX = "#scheduler_active";
    public static final String OVERRIDE_ACTION_DATE_CHECKBOX = "#action_date_override";
    public static final String SEND_NOTIFICATION_AT_RUNTIME_CHECKBOX = "#send_notification";
    public static final String SEND_NOTIFICATION_BEFORE_RUNTIME_CHECKBOX = "#send_before";
    public static final String SEND_NOTIFICATION_IF_ERRORS_CHECKBOX = "#notify_errors_only";
    public static final String SEND_NOTIFICATION_LAST_DAY_CHECKBOX = "#notify_last_repeat";
    public static final String DELETE_JOB_BUTTON = "#schedulerJobHeaderDeleteButton";
    public static final String DELETE_JOB_CONFIRM_DELETE_BUTTON = "#modalSubmitButtondeleteSchedulerJobConfirm";
    public static final String FREQUENCY1_MONTH_DAY_DROPDOWN = "div#s2id_frequency_0_monthday.select2-container.form-control.repeat.select2.required a.select2-choice";

    public static void validateIfJobIsNotDisplayed(String job){
        String passMessage = String.format(LogPage.VALIDATE_IF_JOB_IS_NOT_DISPLAYED_PASS,job);
        String failMessage = String.format(LogPage.VALIDATE_IF_JOB_IS_NOT_DISPLAYED_FAIL,job);
        try {
            if(!verifyGetText(By.cssSelector(JOBS_MANAGER_TABLE_ROW1_COL1),job)){
                ExtentReportsSetUp.testingPass(passMessage);
            }else{
                FailureDelegatePage.handlePageException(failMessage);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void deleteJob(){
        try {
            clickOption(By.cssSelector(DELETE_JOB_BUTTON));
            clickOption(By.cssSelector(DELETE_JOB_CONFIRM_DELETE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.DELETE_JOB_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.DELETE_JOB_FAIL);
        }
    }
    public static void verifyCheckboxDefaults(){
        try {
            if(verifyCheckboxActiveOrNot(By.cssSelector(JOB_ACTIVE_CHECKBOX),"1")
                    && verifyCheckboxActiveOrNot(By.cssSelector(OVERRIDE_ACTION_DATE_CHECKBOX),"1")
                    && verifyCheckboxActiveOrNot(By.cssSelector(SEND_NOTIFICATION_AT_RUNTIME_CHECKBOX),"1")
                    && verifyCheckboxActiveOrNot(By.cssSelector(SEND_NOTIFICATION_BEFORE_RUNTIME_CHECKBOX),"0")
                    && verifyCheckboxActiveOrNot(By.cssSelector(SEND_NOTIFICATION_IF_ERRORS_CHECKBOX),"0")
                    && verifyCheckboxActiveOrNot(By.cssSelector(SEND_NOTIFICATION_LAST_DAY_CHECKBOX),"0")){
                    ExtentReportsSetUp.testingPass(LogPage.VERIFY_CHECKBOX_DEFAULTS_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_CHECKBOX_DEFAULTS_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_CHECKBOX_DEFAULTS_FAIL);
        }
    }
    public static void verifyExclude1Date(String date){
        try {
            if(verifyGetAttribute(By.cssSelector(EXCLUDE1_DATE_FIELD),date)){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_EXCLUDE1_DATE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_EXCLUDE1_DATE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_EXCLUDE1_DATE_FAIL);
        }
    }
    public static void verifyFrequency1Monthly(String frequency,String dayOfWeek,String time,String endDateTime){
        try {
            if(verifyGetText(By.cssSelector(FREQUENCY1_DROPDOWN),frequency)
                && verifyGetText(By.cssSelector(FREQUENCY1_MONTH_DAY_DROPDOWN),dayOfWeek)
                    && verifyGetAttribute(By.cssSelector(FREQUENCY1_TIME_FIELD),time)
                    && verifyGetAttribute(By.cssSelector(FREQUENCY1_ENDS_DATE_TIME_FIELD),endDateTime)){
                    ExtentReportsSetUp.testingPass(LogPage.VERIFY_FREQUENCY1_MONTHLY_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_FREQUENCY1_MONTHLY_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_FREQUENCY1_MONTHLY_FAIL);
        }
    }
    public static void verifyFrequency1Weekly(String frequency,String dayOfWeek,String time,String endDateTime){
        try {
            if(verifyGetText(By.cssSelector(FREQUENCY1_DROPDOWN),frequency)
                && verifyGetText(By.cssSelector(FREQUENCY1_DAY_OF_WEEK_DROPDOWN),dayOfWeek)
                    && verifyGetAttribute(By.cssSelector(FREQUENCY1_TIME_FIELD),time)
                    && verifyGetAttribute(By.cssSelector(FREQUENCY1_ENDS_DATE_TIME_FIELD),endDateTime)){
                    ExtentReportsSetUp.testingPass(LogPage.VERIFY_FREQUENCY1_WEEKLY_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_FREQUENCY1_WEEKLY_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_FREQUENCY1_WEEKLY_PASS);
        }
    }
    public static void verifyJobDetails(SchedulerBean scheduler){
        try {
            if(verifyGetAttribute(By.cssSelector(JOB_NAME_FIELD),scheduler.getJobName())
                && verifyGetText(By.cssSelector(SCHEDULED_TASK_NAME_FIELD),scheduler.getTaskName())
                    && verifyGetAttribute(By.cssSelector(START_DATE_TIME_FIELD),scheduler.getStartDateTime())
                    && verifyGetText(By.cssSelector(TIME_ZONE_DROPDOWN),scheduler.getTimeZone())){
                    ExtentReportsSetUp.testingPass(LogPage.VERIFY_JOB_DETAILS_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_JOB_DETAILS_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_JOB_DETAILS_FAIL);
        }
    }
    public static void openScheduledJob(String job){
        String passMessage = String.format(LogPage.OPEN_SCHEDULED_JOB_PASS,job);
        String failMessage = String.format(LogPage.OPEN_SCHEDULED_JOB_FAIL,job);
        try {
            searchJobsManager(job);
            clickOption(By.cssSelector(JOBS_MANAGER_TABLE_ROW1_COL1));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void searchJobsManager(String job){
        String passMessage = String.format(LogPage.SEARCH_JOBS_MANAGER_PASS,job);
        String failMessage = String.format(LogPage.SEARCH_JOBS_MANAGER_FAIL,job);
        try {
            fillField(By.cssSelector(JOBS_MANAGER_SEARCH_FIELD),job);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void clickJobSaveButton(){
        try {
            clickOption(By.cssSelector(JOB_SAVE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CLICK_JOB_SAVE_BUTTON_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CLICK_JOB_SAVE_BUTTON_FAIL);
        }
    }
    public static void updateNotifyRecipients(String emailAddress){
        try {
            fillDateField(By.cssSelector(NOTIFY_RECIPIENTS_EMAIL_FIELD),emailAddress);
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_NOTIFY_RECIPIENTS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_NOTIFY_RECIPIENTS_FAIL);
        }
    }
    public static void updateExclude1Date(String date){
        try {
            fillDateField(By.cssSelector(EXCLUDE1_DATE_FIELD),date);
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_EXCLUDE1_DATE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_EXCLUDE1_DATE_FAIL);
        }
    }
    public static void updateFrequency1Weekly(String frequency,String dayOfWeek,String time,String endDateTime){
        try {
            inputOptionField(By.cssSelector(FREQUENCY1_DROPDOWN), frequency,By.cssSelector(DROPDOWN_INPUT_FIELD_ELEMENT));
            inputOptionField(By.cssSelector(FREQUENCY1_DAY_OF_WEEK_DROPDOWN), dayOfWeek,By.cssSelector(DROPDOWN_INPUT_FIELD_ELEMENT));
            fillDateField(By.cssSelector(FREQUENCY1_TIME_FIELD),time);
            fillDateField(By.cssSelector(FREQUENCY1_ENDS_DATE_TIME_FIELD),endDateTime);
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_FREQUENCY1_WEEKLY_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_FREQUENCY1_WEEKLY_FAIL);
        }
    }
    public static void updateFrequency1Monthly(String frequency,String frequencyDayOfMonth,String frequencyTime,String frequencyEndDateTime){
        try {
            inputOptionField(By.cssSelector(FREQUENCY1_DROPDOWN), frequency,By.cssSelector(DROPDOWN_INPUT_FIELD_ELEMENT));
            inputOptionField(By.cssSelector(FREQUENCY1_MONTH_DAY_DROPDOWN), frequencyDayOfMonth,By.cssSelector(DROPDOWN_INPUT_FIELD_ELEMENT));
            fillDateField(By.cssSelector(FREQUENCY1_TIME_FIELD),frequencyTime);
            fillDateField(By.cssSelector(FREQUENCY1_ENDS_DATE_TIME_FIELD),frequencyEndDateTime);
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_FREQUENCY1_MONTHLY_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_FREQUENCY1_MONTHLY_FAIL);
        }
    }

    public static void updateJobDetails(SchedulerBean scheduler){
        wait(3000);
        try {
            fillField(By.cssSelector(JOB_NAME_FIELD),scheduler.getJobName());
            picker(By.cssSelector((PICK_BUTTON)),
                    By.cssSelector(PICKER_SEARCH_FIELD),
                    By.cssSelector(PICKER_MODAL_TABLE_ROW1_COL1),
                    By.cssSelector(PICKER_MODAL_TABLE_ROW1_COL1),
                    By.cssSelector(PICKER_MODAL_CHOOSE_BUTTON),scheduler.getTaskName());
            fillDateField(By.cssSelector(START_DATE_TIME_FIELD), scheduler.getStartDateTime());
            inputOptionField(By.cssSelector(TIME_ZONE_DROPDOWN), scheduler.getTimeZone(),By.cssSelector(DROPDOWN_INPUT_FIELD_ELEMENT));
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_JOB_DETAILS_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_JOB_DETAILS_FAIL);
        }
    }
    public static void createNewJob(String jobType){
        try {
            MainPage.clickOptionList(By.cssSelector(CREATE_JOB_BUTTON),jobType,By.cssSelector(CREATE_JOB_BUTTON_LIST));
            waitElementBy(By.cssSelector(JOB_NAME_FIELD),10);
            ExtentReportsSetUp.testingPass(LogPage.CREATE_NEW_JOB_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_NEW_JOB_FAIL);
        }
    }


}
