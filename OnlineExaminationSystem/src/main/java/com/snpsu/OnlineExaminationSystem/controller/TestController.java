package com.snpsu.OnlineExaminationSystem.controller;

import com.snpsu.OnlineExaminationSystem.dao.QuestionRepository;
import com.snpsu.OnlineExaminationSystem.dao.ResultRepository;
import com.snpsu.OnlineExaminationSystem.dao.TestRepository;
import com.snpsu.OnlineExaminationSystem.model.Question;
import com.snpsu.OnlineExaminationSystem.model.Result;
import com.snpsu.OnlineExaminationSystem.model.Test;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ResultRepository resultRepository;

    @GetMapping("/start/{testId}")
    public String startTest(@PathVariable Long testId, Model model, HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/login";
        }

        Test test = testRepository.findById(testId).orElse(null);
        List<Question> questions = questionRepository.findByTestId(testId);

        model.addAttribute("test", test);
        model.addAttribute("questions", questions);
        return "test";
    }

    @PostMapping("/submit/{testId}")
    public String submitTest(@PathVariable Long testId,
                             HttpServletRequest request,
                             Model model,
                             HttpSession session) {

        String username = (String) session.getAttribute("loggedInUser");
        if (username == null) {
            return "redirect:/login";
        }

        Test test = testRepository.findById(testId).orElse(null);
        List<Question> questions = questionRepository.findByTestId(testId);

        int score = 0;

        for (Question q : questions) {
            String submittedAnswer = request.getParameter("question_" + q.getId());
            if (submittedAnswer != null && submittedAnswer.equalsIgnoreCase(q.getCorrectOption())) {
                score++;
            }
        }

        Result result = new Result();
        result.setStudentUsername(username);
        result.setTestId(testId);
        result.setTestTitle(test.getTitle());
        result.setScore(score);
        result.setTotalQuestions(questions.size());
        resultRepository.save(result);

        model.addAttribute("result", result);
        return "result";
    }
}