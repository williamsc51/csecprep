package io.csecprep.service;

import io.csecprep.entities.SubPart;
import io.csecprep.repositories.SubPartRepository;
import org.springframework.stereotype.Service;

@Service
public class SubPartService {
    private final SubPartRepository subPartRepository;

    SubPartService(SubPartRepository subPartRepository){
        this.subPartRepository = subPartRepository;
    }

    public SubPart save(SubPart subPart){
        return subPartRepository.save(subPart);
    }
}
