package bean;

public class ActionBean {
    private String category;
    private String action;
    private String type;
    private String visibility;
    private String staff;
    private String actionDateTime;
    private String actionDate;
    private String comments;
    private String communicationName;
    private String communicationType;
    private String communicationID;
    private String communicationContact;
    private String totalClicks;
    private String totalOpens;
    private String deliveredStatus;

    public ActionBean() {
    }

    public ActionBean(String category, String action, String type, String visibility, String staff, String actionDateTime, String actionDate, String comments, String communicationName, String communicationType, String communicationID, String communicationContact, String totalClicks, String totalOpens, String deliveredStatus) {
        this.category = category;
        this.action = action;
        this.type = type;
        this.visibility = visibility;
        this.staff = staff;
        this.actionDateTime = actionDateTime;
        this.actionDate = actionDate;
        this.comments = comments;
        this.communicationName = communicationName;
        this.communicationType = communicationType;
        this.communicationID = communicationID;
        this.communicationContact = communicationContact;
        this.totalClicks = totalClicks;
        this.totalOpens = totalOpens;
        this.deliveredStatus = deliveredStatus;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getActionDateTime() {
        return actionDateTime;
    }

    public void setActionDateTime(String actionDateTime) {
        this.actionDateTime = actionDateTime;
    }

    public String getActionDate() {
        return actionDate;
    }

    public void setActionDate(String actionDate) {
        this.actionDate = actionDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCommunicationName() {
        return communicationName;
    }

    public void setCommunicationName(String communicationName) {
        this.communicationName = communicationName;
    }

    public String getCommunicationType() {
        return communicationType;
    }

    public void setCommunicationType(String communicationType) {
        this.communicationType = communicationType;
    }

    public String getCommunicationID() {
        return communicationID;
    }

    public void setCommunicationID(String communicationID) {
        this.communicationID = communicationID;
    }

    public String getCommunicationContact() {
        return communicationContact;
    }

    public void setCommunicationContact(String communicationContact) {
        this.communicationContact = communicationContact;
    }

    public String getTotalClicks() {
        return totalClicks;
    }

    public void setTotalClicks(String totalClicks) {
        this.totalClicks = totalClicks;
    }

    public String getTotalOpens() {
        return totalOpens;
    }

    public void setTotalOpens(String totalOpens) {
        this.totalOpens = totalOpens;
    }

    public String getDeliveredStatus() {
        return deliveredStatus;
    }

    public void setDeliveredStatus(String deliveredStatus) {
        this.deliveredStatus = deliveredStatus;
    }
}
