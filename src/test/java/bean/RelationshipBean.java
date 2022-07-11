package bean;

public class RelationshipBean {
    private String relationshipTarget;
    private String targetRole;
    private String roleInRelationship;
    private String comments;
    private String active;


    public RelationshipBean() {
    }

    public RelationshipBean(String relationshipTarget, String targetRole, String roleInRelationship, String comments, String active) {
        this.relationshipTarget = relationshipTarget;
        this.targetRole = targetRole;
        this.roleInRelationship = roleInRelationship;
        this.comments = comments;
        this.active = active;
    }

    public String getRelationshipTarget() {
        return relationshipTarget;
    }

    public void setRelationshipTarget(String relationshipTarget) {
        this.relationshipTarget = relationshipTarget;
    }

    public String getTargetRole() {
        return targetRole;
    }

    public void setTargetRole(String targetRole) {
        this.targetRole = targetRole;
    }

    public String getRoleInRelationship() {
        return roleInRelationship;
    }

    public void setRoleInRelationship(String roleInRelationship) {
        this.roleInRelationship = roleInRelationship;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
