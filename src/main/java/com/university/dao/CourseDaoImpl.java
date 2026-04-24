// Implements CourseDao — handles course listing and registration queries

package com.university.dao;

import com.university.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Course> getAllCourses() {
        String sql = "SELECT * FROM courses";

        // maps each row to a Course object
        return jdbcTemplate.query(sql, new RowMapper<Course>() {
            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
                Course course = new Course();
                course.setCourseId(rs.getInt("course_id"));
                course.setName(rs.getString("name"));
                course.setInstructor(rs.getString("instructor"));
                course.setCredits(rs.getInt("credits"));
                return course;
            }
        });
    }

    @Override
    public void registerCourse(int studentId, int courseId) {
        String sql = "INSERT INTO registrations (student_id, course_id, date) VALUES (?, ?, CURDATE())";
        jdbcTemplate.update(sql, studentId, courseId);
    }

    @Override
    public boolean isAlreadyRegistered(int studentId, int courseId) {
        String sql = "SELECT COUNT(*) FROM registrations WHERE student_id = ? AND course_id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, studentId, courseId);
        // count > 0 means already registered
        return count > 0;
    }
}