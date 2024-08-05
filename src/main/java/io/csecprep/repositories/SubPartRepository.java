package io.csecprep.repositories;

import io.csecprep.entities.SubPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubPartRepository extends ListCrudRepository<SubPart, Long> {
}