package bean;

public class ApplicationComponentBean {

    private String componentItem;
    private String receivedValue;
    private String receivedDate;
    private String requiredValue;
    private String recommender;
    private String comment;

    public ApplicationComponentBean() {
    }

    public ApplicationComponentBean(String componentItem, String receivedValue, String receivedDate, String requiredValue, String recommender, String comment) {
        this.componentItem = componentItem;
        this.receivedValue = receivedValue;
        this.receivedDate = receivedDate;
        this.requiredValue = requiredValue;
        this.recommender = recommender;
        this.comment = comment;
    }

    public String getComponentItem() {
        return componentItem;
    }

    public void setComponentItem(String componentItem) {
        this.componentItem = componentItem;
    }

    public String getReceivedValue() {
        return receivedValue;
    }

    public void setReceivedValue(String receivedValue) {
        this.receivedValue = receivedValue;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getRequiredValue() {
        return requiredValue;
    }

    public void setRequiredValue(String requiredValue) {
        this.requiredValue = requiredValue;
    }

    public String getRecommender() {
        return recommender;
    }

    public void setRecommender(String recommender) {
        this.recommender = recommender;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
