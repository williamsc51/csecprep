package io.csecprep.controllers;

import io.csecprep.entities.Answer;
import io.csecprep.entities.Question;
import io.csecprep.service.AnswerService;
import io.csecprep.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;


@RestController
public class AnswerController {

    private final AnswerService answerService;
    private final QuestionService questionService;

    AnswerController(AnswerService answerService, QuestionService questionService){
        this.answerService = answerService;
        this.questionService = questionService;
    }

    @PostMapping("/answers")
    public HashMap<String, Object> createAnswer(@RequestBody Answer answer){
        HashMap<String, Object> result = new HashMap<>();
        Long questionId = answer.getQuestion().getId();
        Optional<Question> question = questionService.findById(questionId);

        question.ifPresent(answer::setQuestion);

        Answer ans = answerService.saveAndFlush(answer);

        boolean isCorrect = checkAnswer(ans);

        result.put("isCorrect", isCorrect);
        result.put("correctAnswer", answer.getQuestion().getCorrectAnswer());

        return result;
    }

    private boolean checkAnswer(Answer answer){
        return Objects.equals(answer.getValue(), answer.getQuestion().getCorrectAnswer());
    }
}
