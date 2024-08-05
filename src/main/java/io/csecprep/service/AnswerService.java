package io.csecprep.service;

import io.csecprep.entities.Answer;
import io.csecprep.entities.Question;
import io.csecprep.repositories.AnswerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    AnswerService(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }

    @Transactional
    public Answer saveAndFlush(Answer answer){
        return answerRepository.saveAndFlush(answer);
    }

    public Answer findByID(Long id){
        Optional<Answer> optionalAnswer = answerRepository.findById(id);

        return optionalAnswer.orElse(null);
    }
}
