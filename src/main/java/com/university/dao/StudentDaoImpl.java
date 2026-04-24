// Implements StudentDao — handles the actual DB query for student login

package com.university.dao;

import com.university.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Student findByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM students WHERE email = ? AND `password` = ?";

        // returns a list — we only expect one match
        List<Student> students = jdbcTemplate.query(sql, new Object[]{email, password}, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setStudentId(rs.getInt("student_id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("password"));
                return student;
            }
        });

        // null means login failed
        return students.isEmpty() ? null : students.get(0);
    }
}