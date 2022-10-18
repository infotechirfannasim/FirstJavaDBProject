package com.example.firstjavadbproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "STUDENTS")
public class Student {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ROLL_NUM")
    private String rollNum;

    @Column(name = "BADGE_NAME")
    private String badgeName;

    public Student() {
    }

    public Student(long id, String name, String rollNum) {
        this.id = id;
        this.name = name;
        this.rollNum = rollNum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNum() {
        return rollNum;
    }

    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }
}
