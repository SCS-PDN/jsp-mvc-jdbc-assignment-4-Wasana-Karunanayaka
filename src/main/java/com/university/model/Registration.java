package com.university.model;

import java.util.Date;

// Represents a row in the 'registrations' table
public class Registration {

    private int regId;
    private int studentId;
    private int courseId;
    private Date date;

    // Default constructor (required by Spring/JDBC)
    public Registration() {}

    // Getters and Setters
    public int getRegId() { return regId; }
    public void setRegId(int regId) { this.regId = regId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}