package steps.Records;

import bean.EducationSchoolBean;
import io.cucumber.java.en.And;
import pages.Records.SchoolPage;

public class SchoolSteps {

    @And("I verify school in education for person {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void verifySchool(String school,String schoolCEEB,String schoolCity,String schoolState,String schoolComments,String active,String primary,String group) {
        EducationSchoolBean educationSchoolBean = new EducationSchoolBean();
        educationSchoolBean.setSchool(school);
        educationSchoolBean.setSchoolCEEB(schoolCEEB);
        educationSchoolBean.setSchoolCity(schoolCity);
        educationSchoolBean.setSchoolState(schoolState);
        educationSchoolBean.setSchoolComments(schoolComments);
        educationSchoolBean.setActive(active);
        educationSchoolBean.setPrimary(primary);
        SchoolPage.verifySchool(educationSchoolBean,group);
    }

    @And("I update school in education for person {string}, {string}, {string}, {string}, {string}, {string}, {string} group {string}")
    public static void updateSchool(String school,String schoolCEEB,String schoolCity,String schoolState,String schoolComments,String active,String primary,String group) {
        EducationSchoolBean educationSchoolBean = new EducationSchoolBean();
        educationSchoolBean.setSchool(school);
        educationSchoolBean.setSchoolCEEB(schoolCEEB);
        educationSchoolBean.setSchoolCity(schoolCity);
        educationSchoolBean.setSchoolState(schoolState);
        educationSchoolBean.setSchoolComments(schoolComments);
        educationSchoolBean.setActive(active);
        educationSchoolBean.setPrimary(primary);
        SchoolPage.updateSchool(educationSchoolBean,group);
    }
    @And("I add school {string}")
    public static void addSchool(String group) {
        SchoolPage.addSchool(group);
    }
    @And("I delete a school {string}")
    public static void deleteSchool(String index) {
        SchoolPage.deleteSchool(index);
    }


}
