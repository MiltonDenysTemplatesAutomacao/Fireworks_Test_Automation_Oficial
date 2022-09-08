package bean;

public class DocumentBean {
    private String name;
    private String type;
    private String description;
    private String documentDate;
    private String comments;
    private String sourceFile;

    public DocumentBean() {
    }

    public DocumentBean(String name, String type, String description, String documentDate, String comments, String sourceFile) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.documentDate = documentDate;
        this.comments = comments;
        this.sourceFile = sourceFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }
}
