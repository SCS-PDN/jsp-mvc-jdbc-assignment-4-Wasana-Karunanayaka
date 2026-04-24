// Handles course listing and student registration

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

    @Autowired
    private CourseDao courseDao;

    @GetMapping("/courses")
    public String showCourses(HttpSession session, Model model) {

        // redirect if not logged in
        Student student = (Student) session.getAttribute("loggedInStudent");
        if (student == null) {
            return "redirect:/login";
        }

        List<Course> courses = courseDao.getAllCourses();
        model.addAttribute("courses", courses);
        model.addAttribute("student", student);

        return "courses"; // goes to courses.jsp
    }

    @PostMapping("/register/{courseId}")
    public String registerCourse(@PathVariable int courseId,
                                 HttpSession session,
                                 Model model) {

        // redirect if not logged in
        Student student = (Student) session.getAttribute("loggedInStudent");
        if (student == null) {
            return "redirect:/login";
        }

        // prevent duplicate registration
        if (courseDao.isAlreadyRegistered(student.getStudentId(), courseId)) {
            model.addAttribute("message", "You are already registered for this course.");
        } else {
            courseDao.registerCourse(student.getStudentId(), courseId);
            model.addAttribute("message", "Successfully registered for the course!");
        }

        model.addAttribute("student", student);
        return "success"; // goes to success.jsp
    }
}