package org.example.module3_thi_thuc_hanh.model;

public class Student {
    private int id;
    private String name;
    private String classs;

    public Student() {
    }

    public Student(int id) {
        this.id = id;
    }

    public Student(String name, String classs) {
        this.name = name;
        this.classs = classs;
    }

    public Student(int id, String name, String classs) {
        this.id = id;
        this.name = name;
        this.classs = classs;
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

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }
}
