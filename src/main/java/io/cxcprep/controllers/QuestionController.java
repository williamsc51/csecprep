package io.cxcprep.controllers;

import io.cxcprep.entities.Question;
import io.cxcprep.repositories.QuestionRepository;
import io.cxcprep.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("")
    public String index(){
        return "index";
    }

    @GetMapping("/questions")
    public String questions(Model model, @RequestParam String subject){
        List<Question> questions = questionService.getQuestionsBySubject(subject);

        model.addAttribute("questions", questions);

        return "question";
    }
}
