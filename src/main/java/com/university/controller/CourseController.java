package com.university.controller;

import com.university.dao.CourseDao;
import com.university.model.Course;
import com.university.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CourseController {

    // Spring automatically injects the CourseDao implementation
    @Autowired
    private CourseDao courseDao;

    // GET /courses → fetch all courses and display them
    @GetMapping("/courses")
    public String showCourses(HttpSession session, Model model) {

        // If not logged in, redirect back to login page
        Student student = (Student) session.getAttribute("loggedInStudent");
        if (student == null) {
            return "redirect:/login";
        }

        // Fetch all courses from database and pass to JSP
        List<Course> courses = courseDao.getAllCourses();
        model.addAttribute("courses", courses);
        model.addAttribute("student", student);

        return "courses"; // resolves to /WEB-INF/views/courses.jsp
    }

    // POST /register/{courseId} → enroll student in a course
    @PostMapping("/register/{courseId}")
    public String registerCourse(@PathVariable int courseId,
                                 HttpSession session,
                                 Model model) {

        // If not logged in, redirect back to login page
        Student student = (Student) session.getAttribute("loggedInStudent");
        if (student == null) {
            return "redirect:/login";
        }

        // Check if already registered
        if (courseDao.isAlreadyRegistered(student.getStudentId(), courseId)) {
            model.addAttribute("message", "You are already registered for this course.");
        } else {
            // Register the student
            courseDao.registerCourse(student.getStudentId(), courseId);
            model.addAttribute("message", "Successfully registered for the course!");
        }

        model.addAttribute("student", student);
        return "success"; // resolves to /WEB-INF/views/success.jsp
    }
}