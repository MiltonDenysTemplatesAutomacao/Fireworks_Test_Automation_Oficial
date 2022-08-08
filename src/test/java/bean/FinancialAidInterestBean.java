package bean;

public class FinancialAidInterestBean {
    private String aidInterestCategory;
    private String aidInterestType;
    private String expressedInterest;
    private String expressedInterestDate;

    public FinancialAidInterestBean() {
    }

    public FinancialAidInterestBean(String aidInterestCategory, String aidInterestType, String expressedInterest, String expressedInterestDate) {
        this.aidInterestCategory = aidInterestCategory;
        this.aidInterestType = aidInterestType;
        this.expressedInterest = expressedInterest;
        this.expressedInterestDate = expressedInterestDate;
    }

    public String getAidInterestCategory() {
        return aidInterestCategory;
    }

    public void setAidInterestCategory(String aidInterestCategory) {
        this.aidInterestCategory = aidInterestCategory;
    }

    public String getAidInterestType() {
        return aidInterestType;
    }

    public void setAidInterestType(String aidInterestType) {
        this.aidInterestType = aidInterestType;
    }

    public String getExpressedInterest() {
        return expressedInterest;
    }

    public void setExpressedInterest(String expressedInterest) {
        this.expressedInterest = expressedInterest;
    }

    public String getExpressedInterestDate() {
        return expressedInterestDate;
    }

    public void setExpressedInterestDate(String expressedInterestDate) {
        this.expressedInterestDate = expressedInterestDate;
    }
}
