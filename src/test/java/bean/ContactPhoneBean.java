package bean;

public class ContactPhoneBean {

    private String phoneNumber;
    private String phoneType;
    private String phoneStatus;
    private String phoneTimeZone;
    private String phoneOptInMethod;
    private String phoneOptInStatus;
    private String phoneOptInStatusDate;
    private String phoneComments;
    private String active;
    private String primary;

    public ContactPhoneBean() {
    }

    public ContactPhoneBean(String phoneNumber, String phoneType, String phoneStatus, String phoneTimeZone, String phoneOptInMethod, String phoneOptInStatus, String phoneOptInStatusDate, String phoneComments, String active, String primary) {
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
        this.phoneStatus = phoneStatus;
        this.phoneTimeZone = phoneTimeZone;
        this.phoneOptInMethod = phoneOptInMethod;
        this.phoneOptInStatus = phoneOptInStatus;
        this.phoneOptInStatusDate = phoneOptInStatusDate;
        this.phoneComments = phoneComments;
        this.active = active;
        this.primary = primary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneStatus() {
        return phoneStatus;
    }

    public void setPhoneStatus(String phoneStatus) {
        this.phoneStatus = phoneStatus;
    }

    public String getPhoneTimeZone() {
        return phoneTimeZone;
    }

    public void setPhoneTimeZone(String phoneTimeZone) {
        this.phoneTimeZone = phoneTimeZone;
    }

    public String getPhoneOptInMethod() {
        return phoneOptInMethod;
    }

    public void setPhoneOptInMethod(String phoneOptInMethod) {
        this.phoneOptInMethod = phoneOptInMethod;
    }

    public String getPhoneOptInStatus() {
        return phoneOptInStatus;
    }

    public void setPhoneOptInStatus(String phoneOptInStatus) {
        this.phoneOptInStatus = phoneOptInStatus;
    }

    public String getPhoneOptInStatusDate() {
        return phoneOptInStatusDate;
    }

    public void setPhoneOptInStatusDate(String phoneOptInStatusDate) {
        this.phoneOptInStatusDate = phoneOptInStatusDate;
    }

    public String getPhoneComments() {
        return phoneComments;
    }

    public void setPhoneComments(String phoneComments) {
        this.phoneComments = phoneComments;
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
