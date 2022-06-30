package bean;

public class ContactNameBean {
    public String firstName;
    public String lastName;
    public String middleName;
    public String preferredName;
    public String suffix;
    public String salutation;
    public String active;
    public String primary;

    public ContactNameBean() {
    }

    public ContactNameBean(String firstName, String lastName, String middleName, String preferredName, String suffix, String salutation, String active, String primary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.preferredName = preferredName;
        this.suffix = suffix;
        this.salutation = salutation;
        this.active = active;
        this.primary = primary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
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
