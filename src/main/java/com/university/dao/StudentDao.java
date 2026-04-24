// DAO interface for student operations

package com.university.dao;

import com.university.model.Student;

public interface StudentDao {

    // used for login check
    Student findByEmailAndPassword(String email, String password);
}