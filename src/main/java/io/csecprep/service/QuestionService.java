package io.csecprep.service;

import io.csecprep.entities.Question;
import io.csecprep.entities.Subject;
import io.csecprep.repositories.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    public Page<Question> findBySubjectandYear(Subject subject, String year, Pageable pageable) {
        return questionRepository.findBySubjectandYear(subject, year, pageable);
    }

    public List<String> uniqueYearsBySubject(Subject subject){
        return questionRepository.uniqueYearsBySubject(subject);
    }

    public List<Question> findAll(){
        return  questionRepository.findAll();
    }

    public Question save(Question question){
        return questionRepository.save(question);
    }

    public Optional<Question> findById(Long id){
        return questionRepository.findById(id);
    }
}
