// DAO interface for course operations

package com.university.dao;

import com.university.model.Course;
import java.util.List;

public interface CourseDao {

    List<Course> getAllCourses();

    void registerCourse(int studentId, int courseId);

    // check before registering to avoid duplicates
    boolean isAlreadyRegistered(int studentId, int courseId);
}