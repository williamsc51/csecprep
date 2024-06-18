package io.csecprep.repositories;

import io.csecprep.entities.Question;
import io.csecprep.entities.Subject;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends ListCrudRepository<Question, Long> {
    public List<Question> findBySubject(Subject subject);
}
