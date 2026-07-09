package com.snpsu.OnlineExaminationSystem.controller;

import com.snpsu.OnlineExaminationSystem.dao.QuestionRepository;
import com.snpsu.OnlineExaminationSystem.dao.ResultRepository;
import com.snpsu.OnlineExaminationSystem.dao.TestRepository;
import com.snpsu.OnlineExaminationSystem.model.Question;
import com.snpsu.OnlineExaminationSystem.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        model.addAttribute("tests", testRepository.findAll());
        return "admin-dashboard";
    }

    @GetMapping("/test/add")
    public String showAddTestForm(Model model) {
        model.addAttribute("test", new Test());
        return "add-test";
    }

    @PostMapping("/test/add")
    public String addTest(@RequestParam String title, @RequestParam int duration) {
        Test test = new Test();
        test.setTitle(title);
        test.setDuration(duration);
        testRepository.save(test);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/question/add/{testId}")
    public String showAddQuestionForm(@PathVariable Long testId, Model model) {
        model.addAttribute("testId", testId);
        return "add-question";
    }

    @PostMapping("/question/add/{testId}")
    public String addQuestion(@PathVariable Long testId,
                              @RequestParam String questionText,
                              @RequestParam String optionA,
                              @RequestParam String optionB,
                              @RequestParam String optionC,
                              @RequestParam String optionD,
                              @RequestParam String correctOption) {

        Test test = testRepository.findById(testId).orElse(null);

        Question question = new Question();
        question.setQuestionText(questionText);
        question.setOptionA(optionA);
        question.setOptionB(optionB);
        question.setOptionC(optionC);
        question.setOptionD(optionD);
        question.setCorrectOption(correctOption);
        question.setTest(test);

        questionRepository.save(question);
        return "redirect:/admin/question/add/" + testId;
    }
    @Autowired
    private ResultRepository resultRepository;

    @GetMapping("/results")
    public String allResults(Model model) {
        model.addAttribute("results", resultRepository.findAll());
        return "admin-results";
    }
}
