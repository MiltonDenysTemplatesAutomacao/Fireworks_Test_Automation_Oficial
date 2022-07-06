package steps.Records;

import bean.EducationSchoolBean;
import io.cucumber.java.en.And;
import pages.Records.SchoolPage;

public class SchoolSteps {

    @And("I verify school in education for person {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void verifySchool(String school,String schoolCEEB,String schoolCity,String schoolState,String schoolComments,String active,String primary,String group) {
        EducationSchoolBean educationSchoolBean = new EducationSchoolBean();
        educationSchoolBean.school = school;
        educationSchoolBean.schoolCEEB = schoolCEEB;
        educationSchoolBean.schoolCity = schoolCity;
        educationSchoolBean.schoolState = schoolState;
        educationSchoolBean.schoolComments = schoolComments;
        educationSchoolBean.active = active;
        educationSchoolBean.primary = primary;
        SchoolPage.verifySchool(educationSchoolBean,group);
    }

    @And("I update school in education for person {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void updateSchool(String school,String schoolCEEB,String schoolCity,String schoolState,String schoolComments,String active,String primary,String group) {
        EducationSchoolBean educationSchoolBean = new EducationSchoolBean();
        educationSchoolBean.school = school;
        educationSchoolBean.schoolCEEB = schoolCEEB;
        educationSchoolBean.schoolCity = schoolCity;
        educationSchoolBean.schoolState = schoolState;
        educationSchoolBean.schoolComments = schoolComments;
        educationSchoolBean.active = active;
        educationSchoolBean.primary = primary;
        SchoolPage.updateSchool(educationSchoolBean,group);
    }
}
