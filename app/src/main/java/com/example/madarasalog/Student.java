package com.example.madarasalog;

import androidx.annotation.NonNull;

public class Student {
    private Integer id;
    private String name;
    private String rollNo;

    public Student(Integer id, String name, String rollNo) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    @NonNull
    public String toString()
    {
        return getId()+": "+getName();
    }
}
