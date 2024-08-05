package io.csecprep.repositories;

import io.csecprep.entities.Choice;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceRepository extends ListCrudRepository<Choice, Long> {
}
