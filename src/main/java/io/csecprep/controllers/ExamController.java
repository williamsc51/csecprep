package io.csecprep.controllers;
import io.csecprep.entities.Question;
import io.csecprep.entities.Subject;
import io.csecprep.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExamController {

    private final int PAGESIZE = 1;
    private final QuestionService questionService;

    public ExamController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/exam")
    public String exam(Model model, @RequestParam String subject, @RequestParam String year,@RequestParam(required = false) Integer pageNumber){
        PageRequest pageable = PageRequest.of(pageNumber,PAGESIZE);

        Page<Question> questions = questionService.findBySubjectandYear(Subject.valueOf(subject.toUpperCase()), year, pageable);

        model.addAttribute("questions", questions);

        return "exam";
    }
}
