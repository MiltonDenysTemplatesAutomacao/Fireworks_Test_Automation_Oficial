package bean;

public class ContactEmailBean {
    private String emailAddress;
    private String emailType;
    private String emailOptInMethod;
    private String emailOptInStatus;
    private String emailOptInDate;
    private String emailStatus;
    private String emailComments;
    private String active;
    private String primary;

    public ContactEmailBean() {
    }

    public ContactEmailBean(String emailAddress, String emailType, String emailOptInMethod, String emailOptInStatus, String emailOptInDate, String emailStatus, String emailComments, String active, String primary) {
        this.emailAddress = emailAddress;
        this.emailType = emailType;
        this.emailOptInMethod = emailOptInMethod;
        this.emailOptInStatus = emailOptInStatus;
        this.emailOptInDate = emailOptInDate;
        this.emailStatus = emailStatus;
        this.emailComments = emailComments;
        this.active = active;
        this.primary = primary;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getEmailOptInMethod() {
        return emailOptInMethod;
    }

    public void setEmailOptInMethod(String emailOptInMethod) {
        this.emailOptInMethod = emailOptInMethod;
    }

    public String getEmailOptInStatus() {
        return emailOptInStatus;
    }

    public void setEmailOptInStatus(String emailOptInStatus) {
        this.emailOptInStatus = emailOptInStatus;
    }

    public String getEmailOptInDate() {
        return emailOptInDate;
    }

    public void setEmailOptInDate(String emailOptInDate) {
        this.emailOptInDate = emailOptInDate;
    }

    public String getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(String emailStatus) {
        this.emailStatus = emailStatus;
    }

    public String getEmailComments() {
        return emailComments;
    }

    public void setEmailComments(String emailComments) {
        this.emailComments = emailComments;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }
}
