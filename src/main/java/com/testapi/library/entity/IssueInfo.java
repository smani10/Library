package com.testapi.library.entity;

public class IssueInfo {
    private String issueId;
    private String userId;
    private String bookId;
    private boolean isIssued;

    public IssueInfo(String issueId, String userId, String bookId, boolean isIssued) {
        this.issueId = issueId;
        this.userId = userId;
        this.bookId = bookId;
        this.isIssued = isIssued;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }
}
