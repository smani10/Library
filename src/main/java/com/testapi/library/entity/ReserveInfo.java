package com.testapi.library.entity;

public class ReserveInfo {
    private String reserveId;
    private String userId;
    private String bookId;
    private boolean isReserved;

    public ReserveInfo(String reserveId, String userId, String bookId, boolean isReserved) {
        this.reserveId = reserveId;
        this.userId = userId;
        this.bookId = bookId;
        this.isReserved = isReserved;
    }

    public String getReserveId() {
        return reserveId;
    }

    public void setReserveId(String reserveId) {
        this.reserveId = reserveId;
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

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}
