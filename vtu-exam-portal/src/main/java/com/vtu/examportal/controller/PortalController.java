package com.vtu.examportal.controller;

import com.vtu.examportal.dao.ApplicationDao;
import com.vtu.examportal.dao.StudentDao;
import com.vtu.examportal.dao.SubjectDao;
import com.vtu.examportal.model.ExamApplication;
import com.vtu.examportal.model.Student;
import com.vtu.examportal.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class PortalController {

    @org.springframework.beans.factory.annotation.Value("${admin.username}")
    private String adminUsername;

    @org.springframework.beans.factory.annotation.Value("${admin.password}")
    private String adminPassword;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private ApplicationDao applicationDao;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/student-portal")
    public String studentPortal(Model model) {
        model.addAttribute("usn", "");
        return "student-portal";
    }

    @PostMapping("/student-login")
    public String studentLogin(@RequestParam("usn") String usn, HttpSession session, Model model) {
        if (usn == null || usn.trim().isEmpty()) {
            model.addAttribute("error", "USN cannot be empty");
            return "student-portal";
        }
        
        Student student = studentDao.getStudentByUsn(usn.trim().toUpperCase());
        if (student == null) {
            session.setAttribute("tempUsn", usn.trim().toUpperCase());
            return "redirect:/register-student";
        }

        session.setAttribute("studentUsn", student.getUsn());
        return "redirect:/student-dashboard";
    }

    @GetMapping("/register-student")
    public String registerStudentForm(HttpSession session, Model model) {
        String tempUsn = (String) session.getAttribute("tempUsn");
        Student student = new Student();
        if (tempUsn != null) {
            student.setUsn(tempUsn);
        }
        model.addAttribute("student", student);
        return "student-register";
    }

    @PostMapping("/save-student")
    public String saveStudent(@ModelAttribute("student") Student student, HttpSession session) {
        student.setUsn(student.getUsn().trim().toUpperCase());
        studentDao.saveStudent(student);
        session.setAttribute("studentUsn", student.getUsn());
        session.removeAttribute("tempUsn");
        return "redirect:/student-dashboard";
    }

    @GetMapping("/student-dashboard")
    public String studentDashboard(HttpSession session, Model model) {
        String usn = (String) session.getAttribute("studentUsn");
        if (usn == null) {
            return "redirect:/student-portal";
        }

        Student student = studentDao.getStudentByUsn(usn);
        List<ExamApplication> applications = applicationDao.getApplicationsByUsn(usn);

        model.addAttribute("student", student);
        model.addAttribute("applications", applications);
        return "student-dashboard";
    }

    @GetMapping("/apply-exam")
    public String applyExamForm(HttpSession session, Model model) {
        String usn = (String) session.getAttribute("studentUsn");
        if (usn == null) {
            return "redirect:/student-portal";
        }

        Student student = studentDao.getStudentByUsn(usn);
        List<Subject> subjects = subjectDao.getSubjectsBySemAndDept(student.getSemester(), student.getBranch());

        ExamApplication application = new ExamApplication();
        application.setUsn(usn);

        model.addAttribute("student", student);
        model.addAttribute("subjects", subjects);
        model.addAttribute("app", application);
        return "apply-exam";
    }

    @PostMapping("/submit-application")
    public String submitApplication(@ModelAttribute("app") ExamApplication application, HttpSession session, Model model) {
        String sessionUsn = (String) session.getAttribute("studentUsn");
        if (sessionUsn == null) {
            return "redirect:/student-portal";
        }
        
        application.setUsn(sessionUsn);
        
        List<String> codes = application.getSubjectCodes();
        if (codes == null || codes.isEmpty()) {
            Student student = studentDao.getStudentByUsn(sessionUsn);
            List<Subject> subjects = subjectDao.getSubjectsBySemAndDept(student.getSemester(), student.getBranch());
            model.addAttribute("student", student);
            model.addAttribute("subjects", subjects);
            model.addAttribute("app", application);
            model.addAttribute("error", "Please select at least one subject.");
            return "apply-exam";
        }

        List<Subject> selectedSubjects = subjectDao.getSubjectsByCodes(codes);
        
        application.setTotalFee(0.00); // Pricing removed
        application.setStatus("PENDING");
        application.setAppliedDate(new Date());

        applicationDao.saveApplication(application);
        application.setAppliedSubjects(selectedSubjects);

        Student student = studentDao.getStudentByUsn(sessionUsn);
        application.setStudentName(student.getName());

        model.addAttribute("app", application);
        return "application-result";
    }

    @GetMapping("/hall-ticket")
    public String hallTicket(@RequestParam("id") int id, HttpSession session, Model model) {
        ExamApplication app = applicationDao.getApplicationById(id);
        if (app == null || !"APPROVED".equals(app.getStatus())) {
            return "redirect:/student-dashboard";
        }

        Student student = studentDao.getStudentByUsn(app.getUsn());
        model.addAttribute("app", app);
        model.addAttribute("student", student);
        return "hall-ticket";
    }

    @GetMapping("/admin-login")
    public String adminLoginForm(Model model) {
        return "admin-login";
    }

    @PostMapping("/admin-login")
    public String adminLoginSubmit(@RequestParam("username") String username, 
                                   @RequestParam("password") String password, 
                                   HttpSession session, 
                                   Model model) {
        if (adminUsername.equals(username) && adminPassword.equals(password)) {
            session.setAttribute("adminSession", true);
            return "redirect:/admin-portal";
        }
        model.addAttribute("error", "Invalid username or password");
        return "admin-login";
    }

    @GetMapping("/admin-portal")
    public String adminPortal(HttpSession session, Model model) {
        if (session.getAttribute("adminSession") == null) {
            return "redirect:/admin-login";
        }

        List<ExamApplication> allApps = applicationDao.getAllApplications();
        
        long totalCount = allApps.size();
        long pendingCount = allApps.stream().filter(a -> "PENDING".equals(a.getStatus())).count();
        long approvedCount = allApps.stream().filter(a -> "APPROVED".equals(a.getStatus())).count();
        long rejectedCount = allApps.stream().filter(a -> "REJECTED".equals(a.getStatus())).count();

        model.addAttribute("applications", allApps);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pendingCount", pendingCount);
        model.addAttribute("approvedCount", approvedCount);
        model.addAttribute("rejectedCount", rejectedCount);
        return "admin-dashboard";
    }

    @PostMapping("/admin/update-status")
    public String updateStatus(@RequestParam("id") int id, @RequestParam("status") String status, HttpSession session) {
        if (session.getAttribute("adminSession") == null) {
            return "redirect:/admin-login";
        }
        applicationDao.updateStatus(id, status);
        return "redirect:/admin-portal";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
