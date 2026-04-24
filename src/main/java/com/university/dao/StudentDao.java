package com.university.dao;

import com.university.model.Student;

// Defines what operations we can do with students
public interface StudentDao {

    // Find a student by their email and password (used for login)
    Student findByEmailAndPassword(String email, String password);
}