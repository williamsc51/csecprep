package io.csecprep.controllers;

import io.csecprep.entities.Choice;
import io.csecprep.entities.Question;
import io.csecprep.entities.SubPart;
import io.csecprep.service.FileUploader;
import io.csecprep.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@Controller
@RequestMapping("admin")
public class AdminQuestionController {

    private final QuestionService questionService;
    private final FileUploader fileUploader;

    AdminQuestionController(QuestionService questionService, FileUploader fileUploader){
        this.questionService = questionService;
        this.fileUploader = fileUploader;
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

    @PostMapping(value = "questions", consumes = MULTIPART_FORM_DATA_VALUE)
    public ModelAndView createQuestion(@ModelAttribute Question question, @RequestPart("file") MultipartFile file) throws Exception{

        String filePath = fileUploader.upload(file, "question_images/");
        question.setImage(filePath);

        Question response = questionService.save(question);

        return new ModelAndView("redirect:/admin/questions/" + response.getId().toString());
    }

    @GetMapping("/questions/{id}/edit")
    public String editQuestion(Model model, @PathVariable Long id){
        Optional<Question> question = questionService.findById(id);
        question.ifPresent(value -> model.addAttribute("question", value));

        return "admin/questions/edit";
    }

    @PostMapping(value = "/questions/{id}", consumes = MULTIPART_FORM_DATA_VALUE)
    public ModelAndView updateQuestion(@PathVariable Long id, @RequestPart("file") MultipartFile file) throws Exception{

        String filePath = fileUploader.upload(file, "question_images/");

        Optional<Question> persistedQuestion = questionService.findById(id);
        persistedQuestion.ifPresent(question -> {
            question.setImage(filePath);
            questionService.save(question);
        });


        return new ModelAndView("redirect:/admin/questions/" + id);
    }

    @GetMapping("/questions/{id}")
    public String showQuestion(Model model, @PathVariable Long id){

        Optional<Question> question = questionService.findById(id);
        question.ifPresent(value -> {
            model.addAttribute("question", value);
            model.addAttribute("choice", new Choice());
            model.addAttribute("choices", value.getChoices());
            model.addAttribute("subPart", new SubPart());
            model.addAttribute("subParts", value.getSubParts());
        });

        return "/admin/questions/show";
    }

}
