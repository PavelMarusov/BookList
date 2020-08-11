package com.example.booklist.models;

public class BooksModel {
    private String bookName;
    private String bookInfo;

    public BooksModel() {
    }

    public BooksModel(String bookName, String bookInfo) {
        this.bookName = bookName;
        this.bookInfo = bookInfo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }


}
