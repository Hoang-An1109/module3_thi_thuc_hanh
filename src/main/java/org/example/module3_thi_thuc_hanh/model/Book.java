package org.example.module3_thi_thuc_hanh.model;

public class Book {
    private int id;
    private String name;
    private String author;
    private String description;
    private int quanlity;

    public Book() {
    }

    public Book(int id) {
        this.id = id;
    }

    public Book(String name, String author, String description, int quanlity) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.quanlity = quanlity;
    }

    public Book(int id, String name, String author, String description, int quanlity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.quanlity = quanlity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }
}
