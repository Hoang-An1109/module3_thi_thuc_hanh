package org.example.module3_thi_thuc_hanh.model;

import java.util.Date;

public class BorrowCard {
    private int id;
    private Book id_book;
    private Student id_student;
    private boolean status;
    private Date borrowDate;
    private Date returnDate;

    public BorrowCard() {
    }

    public BorrowCard(int id) {
        this.id = id;
    }

    public BorrowCard(Book id_book, Student id_student, boolean status, Date borrowDate, Date returnDate) {
        this.id_book = id_book;
        this.id_student = id_student;
        this.status = status;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public BorrowCard(int id, Book id_book, Student id_student, boolean status, Date borrowDate, Date returnDate) {
        this.id = id;
        this.id_book = id_book;
        this.id_student = id_student;
        this.status = status;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getId_book() {
        return id_book;
    }

    public void setId_book(Book id_book) {
        this.id_book = id_book;
    }

    public Student getId_student() {
        return id_student;
    }

    public void setId_student(Student id_student) {
        this.id_student = id_student;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
