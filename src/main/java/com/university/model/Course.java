package com.university.model;

// Represents a row in the 'courses' table
public class Course {

    private int courseId;
    private String name;
    private String instructor;
    private int credits;

    // Default constructor (required by Spring/JDBC)
    public Course() {}

    // Getters and Setters
    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
}