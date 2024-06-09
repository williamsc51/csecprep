package io.cxcprep.service;

import io.cxcprep.entities.Question;
import io.cxcprep.repositories.QuestionRepository;
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
