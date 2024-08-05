package io.csecprep.controllers;

import io.csecprep.entities.Subject;
import io.csecprep.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestionController {
    private QuestionService questionService;

    QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public String question(Model model, @RequestParam String subject){
        List<String> years = questionService.uniqueYearsBySubject(Subject.valueOf(subject.toUpperCase()));

        model.addAttribute("years", years);
        model.addAttribute("subject", subject);

        return "questions";
    }
}
