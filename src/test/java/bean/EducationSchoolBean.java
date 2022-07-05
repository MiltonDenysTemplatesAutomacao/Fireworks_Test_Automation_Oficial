package bean;

public class EducationSchoolBean {

    public String school;
    public String schoolCEEB;
    public String schoolCity;
    public String schoolState;
    public String schoolComments;
    public String active;
    public String primary;

    public EducationSchoolBean() {
    }

    public EducationSchoolBean(String school, String schoolCEEB, String schoolCity, String schoolState, String schoolComments, String active, String primary) {
        this.school = school;
        this.schoolCEEB = schoolCEEB;
        this.schoolCity = schoolCity;
        this.schoolState = schoolState;
        this.schoolComments = schoolComments;
        this.active = active;
        this.primary = primary;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchoolCEEB() {
        return schoolCEEB;
    }

    public void setSchoolCEEB(String schoolCEEB) {
        this.schoolCEEB = schoolCEEB;
    }

    public String getSchoolCity() {
        return schoolCity;
    }

    public void setSchoolCity(String schoolCity) {
        this.schoolCity = schoolCity;
    }

    public String getSchoolState() {
        return schoolState;
    }

    public void setSchoolState(String schoolState) {
        this.schoolState = schoolState;
    }

    public String getSchoolComments() {
        return schoolComments;
    }

    public void setSchoolComments(String schoolComments) {
        this.schoolComments = schoolComments;
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
