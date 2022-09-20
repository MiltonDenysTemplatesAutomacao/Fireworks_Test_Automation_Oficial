package pages.records;

import bean.DocumentBean;
import config.extent_reports.ExtentReportsSetUp;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.FailureDelegatePage;
import pages.LogPage;
import pages.MainPage;
import pages.PersonNavPage;
import pages.ClearChangesPage;

public class DocumentsPage extends BasePage {

    public static final String CREATE_DOCUMENT_BUTTON = "#top-controls-create-new-document";
    public static final String DOCUMENT_NAME_FIELD = "#document_name";
    public static final String DOCUMENT_TYPE_DROPDOWN = "#document_type_id_component";
    public static final String DOCUMENT_TYPE_DROPDOWN_LIST = "#document_type_id_dropdown_menu";
    public static final String DOCUMENT_DESCRIPTION_FIELD = "#document_description";
    public static final String DOCUMENT_DATE_FIELD = "#document_date";
    public static final String COMMENTS_FIELD = "#document_comments";
    public static final String CHOOSE_FILE_BUTTON = "#document_file_name-mediaSourceFileButton";
    public static final String FILE_TEXT = "//*[@id='documentCreate']/div[2]/div[2]/div[1]";
    public static final String DOCUMENT_MANAGER_TABLE_ROW1 = "#documentManagerTable_row_0";
    public static final String DOCUMENT_MANAGER_SEARCH_FIELD = "#documentManagerTableControlsTableSearch";
    public static final String DOCUMENT_MANAGER_TABLE_ROW1_COL1 = "#documentManagerTable_row_0_col_0";
    public static final String REPLACE_FILE_MODAL_CONTINUE_BUTTON = "#modalSubmitButtonreplaceFileDocument";
    public static final String DELETE_DOCUMENT_BUTTON = "#deleteDocumentButton";
    public static final String DOCUMENT_DELETE_MODAL_YES_DELETE_BUTTON = "#modalSubmitButtondeleteDocument";
    public static final String DOCUMENT_SAVE_CHANGES_BUTTON = "#documentSaveButton";
    public static final String DOCUMENT_VIEW_BUTTON = "#fileView";
    public static final String DOCUMENT_DOWNLOAD_BUTTON = "#fileDownload";

    public static void verifyIfDeleteButtonIsNotVisible(){
        try {
            if (!checkIfElementIsVisible(By.cssSelector(DELETE_DOCUMENT_BUTTON))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_IF_DELETE_BUTTON_IS_NOT_VISIBLE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_IF_DELETE_BUTTON_IS_NOT_VISIBLE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_IF_DELETE_BUTTON_IS_NOT_VISIBLE_FAIL);
        }
    }
    public static void verifyIfDocumentDownLoadButtonIsVisible(){
        try {
            if (checkIfElementIsVisible(By.cssSelector(DOCUMENT_DOWNLOAD_BUTTON))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_IF_DOCUMENT_DOWN_LOAD_BUTTON_IS_VISIBLE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_IF_DOCUMENT_DOWN_LOAD_BUTTON_IS_VISIBLE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_IF_DOCUMENT_DOWN_LOAD_BUTTON_IS_VISIBLE_FAIL);
        }
    }
    public static void verifyIfDocumentViewButtonIsVisible(){
        try {
            if (checkIfElementIsVisible(By.cssSelector(DOCUMENT_VIEW_BUTTON))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_IF_DOCUMENT_VIEW_BUTTON_IS_VISIBLE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_IF_DOCUMENT_VIEW_BUTTON_IS_VISIBLE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_IF_DOCUMENT_VIEW_BUTTON_IS_VISIBLE_FAIL);
        }
    }
    public static void verifyIfSaveChangesButtonIsNotVisible(){
        try {
            if (!checkIfElementIsVisible(By.cssSelector(DOCUMENT_SAVE_CHANGES_BUTTON))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_IF_SAVE_CHANGES_BUTTON_IS_NOT_VISIBLE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_IF_SAVE_CHANGES_BUTTON_IS_NOT_VISIBLE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_IF_SAVE_CHANGES_BUTTON_IS_NOT_VISIBLE_FAIL);
        }
    }
    public static void verifyIfClearChangesButtonIsNotVisible(){
        try {
            if (!checkIfElementIsVisible(By.cssSelector(ClearChangesPage.CLEAR_CHANGES_BUTTON))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_IF_CLEAR_CHANGES_BUTTON_IS_NOT_VISIBLE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_IF_CLEAR_CHANGES_BUTTON_IS_NOT_VISIBLE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_IF_CLEAR_CHANGES_BUTTON_IS_NOT_VISIBLE_FAIL);
        }
    }
    public static void verifyIfCreateButtonIsNotVisible(){
        try {
            if (!checkIfElementIsVisible(By.cssSelector(CREATE_DOCUMENT_BUTTON))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_IF_CREATE_BUTTON_IS_NOT_VISIBLE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_IF_CREATE_BUTTON_IS_NOT_VISIBLE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_IF_CREATE_BUTTON_IS_NOT_VISIBLE_FAIL);
        }
    }
    public static void verifyIfDocumentsTabIsNotVisible(){
        try {
            if (!checkIfElementIsVisible(By.cssSelector(PersonNavPage.DOCUMENTS_TAB))){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_IF_DOCUMENTS_TAB_IS_VISIBLE_PASS);
            }else{
                FailureDelegatePage.handlePageException(LogPage.VERIFY_IF_DOCUMENTS_TAB_IS_VISIBLE_FAIL);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_IF_DOCUMENTS_TAB_IS_VISIBLE_FAIL);
        }
    }
    public static void deleteDocument() {
        try {
            MainPage.clickOption(By.cssSelector(DELETE_DOCUMENT_BUTTON));
            MainPage.clickOption(By.cssSelector(DOCUMENT_DELETE_MODAL_YES_DELETE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.DELETE_DOCUMENT_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.DELETE_DOCUMENT_FAIL);
        }
    }
    public static void confirmReplaceFile(){
        try {
            MainPage.clickOption(By.cssSelector(REPLACE_FILE_MODAL_CONTINUE_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CONFIRM_REPLACE_FILE_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CONFIRM_REPLACE_FILE_FAIL);
        }
    }
    public static void searchDocumentTable(String document){
        String passMessage = String.format(LogPage.SEARCH_DOCUMENT_TABLE_PASS,document);
        String failMessage = String.format(LogPage.SEARCH_DOCUMENT_TABLE_FAIL,document);
        try {
            waitElementBy(By.cssSelector(DOCUMENT_MANAGER_SEARCH_FIELD),10);
            write(By.cssSelector(DOCUMENT_MANAGER_SEARCH_FIELD),document);
            wait(2000);
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }
    public static void openDocument(String document){
        String passMessage = String.format(LogPage.OPEN_RELATIONSHIP_TABLE_PASS,document);
        String failMessage = String.format(LogPage.OPEN_RELATIONSHIP_TABLE_FAIL,document);
        try {
            searchDocumentTable(document);
            waitUntilElementToBeSelected(By.cssSelector(DOCUMENT_MANAGER_TABLE_ROW1_COL1),10);
            click(By.cssSelector(DOCUMENT_MANAGER_TABLE_ROW1_COL1));
            ExtentReportsSetUp.testingPass(passMessage);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(failMessage);
        }
    }

    public static void verifyDocumentDataTableValues(DocumentBean documentBean){
        try {
            if(MainPage.verifyGetText(By.cssSelector(DOCUMENT_MANAGER_TABLE_ROW1),documentBean.getName())
                && MainPage.verifyGetText(By.cssSelector(DOCUMENT_MANAGER_TABLE_ROW1),documentBean.getType())
                && MainPage.verifyGetText(By.cssSelector(DOCUMENT_MANAGER_TABLE_ROW1),documentBean.getDescription())
                && MainPage.verifyGetText(By.cssSelector(DOCUMENT_MANAGER_TABLE_ROW1),documentBean.getDocumentDate())
                && MainPage.verifyGetText(By.cssSelector(DOCUMENT_MANAGER_TABLE_ROW1),documentBean.getComments())
                && MainPage.verifyGetText(By.cssSelector(DOCUMENT_MANAGER_TABLE_ROW1),documentBean.getSourceFile())){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_DOCUMENT_PASS);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_DOCUMENT_FAIL);
        }
    }
    public static void verifyDocument(DocumentBean documentBean){
        try {
            if(MainPage.verifyGetAttribute(By.cssSelector(DOCUMENT_NAME_FIELD),documentBean.getName())
                && MainPage.verifyGetText(By.cssSelector(DOCUMENT_TYPE_DROPDOWN),documentBean.getType())
                && MainPage.verifyGetAttribute(By.cssSelector(DOCUMENT_DESCRIPTION_FIELD),documentBean.getDescription())
                && MainPage.verifyGetAttribute(By.cssSelector(DOCUMENT_DATE_FIELD),documentBean.getDocumentDate())
                && MainPage.verifyGetAttribute(By.cssSelector(COMMENTS_FIELD),documentBean.getComments())
                && MainPage.verifyGetText(By.xpath(FILE_TEXT),documentBean.getSourceFile())){
                ExtentReportsSetUp.testingPass(LogPage.VERIFY_DOCUMENT_PASS);
            }
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.VERIFY_DOCUMENT_FAIL);
        }
    }
    public static void updateDocument(DocumentBean documentBean){
        try {
            if(documentBean.getName()!=""){
                MainPage.fillField(By.cssSelector(DOCUMENT_NAME_FIELD), documentBean.getName());
            }
            if(documentBean.getType()!=""){
                MainPage.clickOptionList(By.cssSelector(DOCUMENT_TYPE_DROPDOWN),
                        documentBean.getType(),
                        By.cssSelector(DOCUMENT_TYPE_DROPDOWN_LIST));
            }
            if(documentBean.getDescription()!=""){
                MainPage.fillField(By.cssSelector(DOCUMENT_DESCRIPTION_FIELD), documentBean.getDescription());
            }
            if(documentBean.getDocumentDate()!=""){
                MainPage.fillDateField(By.cssSelector(DOCUMENT_DATE_FIELD), documentBean.getDocumentDate());
            }
            if(documentBean.getComments()!=""){
                MainPage.fillField(By.cssSelector(COMMENTS_FIELD), documentBean.getComments());
            }
            if(documentBean.getSourceFile()!=""){
                MainPage.attachFile(documentBean.getSourceFile(),By.cssSelector(CHOOSE_FILE_BUTTON));
            }
            ExtentReportsSetUp.testingPass(LogPage.UPDATE_DOCUMENT_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.UPDATE_DOCUMENT_FAIL);
        }
    }
    public static void createDocument(){
        try {
            waitUntilElementToBeSelected(By.cssSelector(CREATE_DOCUMENT_BUTTON),20);
            click(By.cssSelector(CREATE_DOCUMENT_BUTTON));
            ExtentReportsSetUp.testingPass(LogPage.CREATE_DOCUMENT_PASS);
        } catch (Exception e) {
            FailureDelegatePage.handlePageException(LogPage.CREATE_DOCUMENT_FAIL);
        }
    }
}
