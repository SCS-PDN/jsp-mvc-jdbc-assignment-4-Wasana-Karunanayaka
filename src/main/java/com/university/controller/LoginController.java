package com.university.controller;

import com.university.dao.StudentDao;
import com.university.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    // Spring automatically injects the StudentDao implementation
    @Autowired
    private StudentDao studentDao;

    // GET /login → show the login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // resolves to /WEB-INF/views/login.jsp
    }

    // POST /login → validate credentials
    @PostMapping("/login")
    public String processLogin(@RequestParam String email,
                               @RequestParam String password,
                               HttpSession session,
                               Model model) {

        // Check database for matching student
        Student student = studentDao.findByEmailAndPassword(email, password);

        if (student != null) {
            // Store student in session so other pages can access it
            session.setAttribute("loggedInStudent", student);
            System.out.println("[LOG] Login successful for: " + email);
            return "redirect:/courses"; // go to courses page
        } else {
            // Login failed — send error message back to login page
            System.out.println("[LOG] Login failed for: " + email);
            model.addAttribute("error", "Invalid email or password. Please try again.");
            return "login";
        }
    }

    // GET /logout → clear session and return to login
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}