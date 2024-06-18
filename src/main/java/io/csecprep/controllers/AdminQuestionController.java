package io.csecprep.controllers;

import io.csecprep.entities.Question;
import io.csecprep.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminQuestionController {

    private final QuestionService questionService;

    AdminQuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public String index(Model model){
        List<Question> questions = questionService.findAll();

        model.addAttribute("questions", questions);
        return "admin/questions/index";
    }

    @GetMapping("questions/new")
    public String newQuestion(Model model){

        model.addAttribute("question", new Question());

        return "admin/questions/new";
    }

    @PostMapping("questions")
    public ModelAndView createQuestion(@ModelAttribute Question question){

        questionService.save(question);

        return new ModelAndView("redirect:questions");
    }

    @GetMapping("/questions/{id}/edit")
    public String editQuestion(){
        return "admin/questions/edit";
    }
}
