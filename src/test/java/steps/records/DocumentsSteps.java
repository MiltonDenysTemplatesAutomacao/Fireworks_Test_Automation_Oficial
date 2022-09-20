package steps.records;

import bean.DocumentBean;
import io.cucumber.java.en.Then;
import pages.records.DocumentsPage;

public class DocumentsSteps {

    @Then("I confirm replace file")
    public static void confirmReplaceFile() {
        DocumentsPage.confirmReplaceFile();
    }
    @Then("I open a document {string}")
    public static void openDocument(String document) {
        DocumentsPage.openDocument(document);
    }
    @Then("I validate if documents tab is not visible")
    public static void verifyIfDocumentsTabIsNotVisible() {
        DocumentsPage.verifyIfDocumentsTabIsNotVisible();
    }
    @Then("I validate if create button is not displayed")
    public static void verifyIfCreateButtonIsNotVisible() {
        DocumentsPage.verifyIfCreateButtonIsNotVisible();
    }
    @Then("I validate if clear changes button is not displayed")
    public static void verifyIfClearChangesButtonIsNotVisible() {
        DocumentsPage.verifyIfClearChangesButtonIsNotVisible();
    }
    @Then("I validate if document view button is displayed")
    public static void verifyIfDocumentViewButtonIsVisible() {
        DocumentsPage.verifyIfDocumentViewButtonIsVisible();
    }
    @Then("I validate if delete button on documents is not displayed")
    public static void verifyIfDeleteButtonIsNotVisible() {
        DocumentsPage.verifyIfDeleteButtonIsNotVisible();
    }
    @Then("I validate if document download button is displayed")
    public static void verifyIfDocumentDownLoadButtonIsVisible() {
        DocumentsPage.verifyIfDocumentDownLoadButtonIsVisible();
    }
    @Then("I validate if save changes button is not displayed")
    public static void verifyIfSaveChangesButtonIsNotVisible() {
        DocumentsPage.verifyIfSaveChangesButtonIsNotVisible();
    }

    @Then("I delete a document")
    public static void deleteDocument() {
        DocumentsPage.deleteDocument();
    }
    @Then("I create a document")
    public static void createDocument() {
        DocumentsPage.createDocument();
    }
    @Then("I verify document data table values {string}, {string}, {string}, {string}, {string}, {string}")
    public static void verifyDocumentDataTableValues(String name,String type,String description,String documentDate,String comments,String sourceFile) {
        DocumentBean documentBean = new DocumentBean();
        documentBean.setName(name);
        documentBean.setType(type);
        documentBean.setDescription(description);
        documentBean.setDocumentDate(documentDate);
        documentBean.setComments(comments);
        documentBean.setSourceFile(sourceFile);
        DocumentsPage.verifyDocumentDataTableValues(documentBean);
    }
    @Then("I verify document {string}, {string}, {string}, {string}, {string}, {string}")
    public static void verifyDocument(String name,String type,String description,String documentDate,String comments,String sourceFile) {
        DocumentBean documentBean = new DocumentBean();
        documentBean.setName(name);
        documentBean.setType(type);
        documentBean.setDescription(description);
        documentBean.setDocumentDate(documentDate);
        documentBean.setComments(comments);
        documentBean.setSourceFile(sourceFile);
        DocumentsPage.verifyDocument(documentBean);
    }
    @Then("I update document {string}, {string}, {string}, {string}, {string}, {string}")
    public static void updateDocument(String name,String type,String description,String documentDate,String comments,String sourceFile) {
        DocumentBean documentBean = new DocumentBean();
        documentBean.setName(name);
        documentBean.setType(type);
        documentBean.setDescription(description);
        documentBean.setDocumentDate(documentDate);
        documentBean.setComments(comments);
        documentBean.setSourceFile(sourceFile);
        DocumentsPage.updateDocument(documentBean);
    }

}
