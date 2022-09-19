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
