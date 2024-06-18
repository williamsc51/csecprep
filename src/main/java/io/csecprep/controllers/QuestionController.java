package io.csecprep.controllers;
import io.csecprep.entities.Question;
import io.csecprep.entities.Subject;
import io.csecprep.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public String questions(Model model, @RequestParam String subject){

        List<Question> questions = questionService.getQuestionsBySubject(Subject.valueOf(subject.toUpperCase()));

        model.addAttribute("questions", questions);

        return "question";
    }
}
