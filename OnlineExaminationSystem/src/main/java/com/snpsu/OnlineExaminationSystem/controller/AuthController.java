package com.snpsu.OnlineExaminationSystem.controller;

import com.snpsu.OnlineExaminationSystem.dao.ResultRepository;
import com.snpsu.OnlineExaminationSystem.dao.UserRepository;
import com.snpsu.OnlineExaminationSystem.dao.TestRepository;
import com.snpsu.OnlineExaminationSystem.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private ResultRepository resultRepository;

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model,
                               HttpSession session) {

        User user = userRepository.findByUsernameAndPassword(username, password);

        if (user == null) {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }

        // Store logged-in user info in session
        session.setAttribute("loggedInUser", user.getUsername());
        session.setAttribute("role", user.getRole());

        if (user.getRole().equals("ADMIN")) {
            return "redirect:/admin/dashboard";
        } else {
            return "redirect:/dashboard";
        }
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model, HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/login";
        }
        model.addAttribute("tests", testRepository.findAll());
        model.addAttribute("username", session.getAttribute("loggedInUser"));
        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/my-results")
    public String myResults(Model model, HttpSession session) {
        String username = (String) session.getAttribute("loggedInUser");
        if (username == null) {
            return "redirect:/login";
        }
        model.addAttribute("results", resultRepository.findByStudentUsername(username));
        model.addAttribute("username", username);
        return "my-results";
    }
}