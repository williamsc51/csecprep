package io.csecprep.service;

import io.csecprep.entities.Choice;
import io.csecprep.repositories.ChoiceRepository;
import org.springframework.stereotype.Service;

@Service
public class ChoiceService {

    private final ChoiceRepository choiceRepository;

    ChoiceService(ChoiceRepository choiceRepository){
        this.choiceRepository = choiceRepository;
    }

    public Choice save(Choice choice){
        return choiceRepository.save(choice);
    }
}
