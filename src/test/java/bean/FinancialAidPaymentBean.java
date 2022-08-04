package bean;

public class FinancialAidPaymentBean {

    private String paymentDate;
    private String paymentAmount;
    private String paymentPurpose;
    private String paymentType;
    private String paymentWhoAdded;
    private String paymentComment;

    public FinancialAidPaymentBean() {
    }

    public FinancialAidPaymentBean(String paymentDate, String paymentAmount, String paymentPurpose, String paymentType, String paymentWhoAdded, String paymentComment) {
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.paymentPurpose = paymentPurpose;
        this.paymentType = paymentType;
        this.paymentWhoAdded = paymentWhoAdded;
        this.paymentComment = paymentComment;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    public void setPaymentPurpose(String paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentWhoAdded() {
        return paymentWhoAdded;
    }

    public void setPaymentWhoAdded(String paymentWhoAdded) {
        this.paymentWhoAdded = paymentWhoAdded;
    }

    public String getPaymentComment() {
        return paymentComment;
    }

    public void setPaymentComment(String paymentComment) {
        this.paymentComment = paymentComment;
    }
}
