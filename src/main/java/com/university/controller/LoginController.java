// Handles login and logout requests

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

    @Autowired
    private StudentDao studentDao;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // goes to login.jsp
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email,
                               @RequestParam String password,
                               HttpSession session,
                               Model model) {

        Student student = studentDao.findByEmailAndPassword(email, password);

        if (student != null) {
            // save student in session for other pages to use
            session.setAttribute("loggedInStudent", student);
            System.out.println("[LOG] Login successful for: " + email);
            return "redirect:/courses";
        } else {
            System.out.println("[LOG] Login failed for: " + email);
            model.addAttribute("error", "Invalid email or password. Please try again.");
            return "login";
        }
    }

    // clears the session and goes back to login
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}