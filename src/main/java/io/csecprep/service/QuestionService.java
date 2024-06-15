package io.csecprep.service;

import io.csecprep.entities.Question;
import io.csecprep.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestionsBySubject(String subject) {
        return questionRepository.findBySubject(subject);
    }
}
