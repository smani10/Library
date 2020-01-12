package com.testapi.library.entity;

public class BookEntity {
    public BookEntity(String bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    private String bookId;
    private String bookName;
    private boolean isAvailable;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
