#Author: Milton Silva
#Regression testcase TL-1148: Documents Permissions: No Access

@DocumentsPermissionsNoAccess
Feature: Edits to Relationships

  @DocumentsPermissionsNoAccess @Done @Documents
  Scenario: Record - Documents - verify this permissions group can not access documents
    Given I login as "documentsNoAccessUsername", "documentsNoAccessPassword", "documentsNoAccessFullName"