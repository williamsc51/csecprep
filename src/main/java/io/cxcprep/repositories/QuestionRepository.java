package io.cxcprep.repositories;

import io.cxcprep.entities.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {
    public List<Question> findBySubject(String subject);
}
