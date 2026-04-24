package com.university.dao;

import com.university.model.Course;
import java.util.List;

// Defines what operations we can do with courses
public interface CourseDao {

    // Get all courses from the database
    List<Course> getAllCourses();

    // Register a student for a course
    void registerCourse(int studentId, int courseId);

    // Check if a student is already registered for a course
    boolean isAlreadyRegistered(int studentId, int courseId);
}