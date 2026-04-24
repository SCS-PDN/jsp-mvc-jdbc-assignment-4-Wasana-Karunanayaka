// Model class for the Registration table (links students to courses)

package com.university.model;

import java.util.Date;

public class Registration {

    private int regId;
    private int studentId;
    private int courseId;
    private Date date;

    // needed for Spring to create objects automatically
    public Registration() {}

    // getters and setters
    public int getRegId() { return regId; }
    public void setRegId(int regId) { this.regId = regId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}