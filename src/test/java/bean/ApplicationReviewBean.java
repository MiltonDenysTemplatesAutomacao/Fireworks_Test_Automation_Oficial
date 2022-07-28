package bean;

public class ApplicationReviewBean {

    private String reviewFactor;
    private String rating;
    private String reader;
    private String reviewDate;
    private String comments;

    public ApplicationReviewBean() {
    }

    public ApplicationReviewBean(String reviewFactor, String rating, String reader, String reviewDate, String comments) {
        this.reviewFactor = reviewFactor;
        this.rating = rating;
        this.reader = reader;
        this.reviewDate = reviewDate;
        this.comments = comments;
    }

    public String getReviewFactor() {
        return reviewFactor;
    }

    public void setReviewFactor(String reviewFactor) {
        this.reviewFactor = reviewFactor;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
