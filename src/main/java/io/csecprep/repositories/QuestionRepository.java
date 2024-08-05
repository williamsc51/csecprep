package io.csecprep.repositories;

import io.csecprep.entities.Question;
import io.csecprep.entities.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>, PagingAndSortingRepository<Question, Long> {

    @Query("SELECT q FROM Question q WHERE q.subject = ?1 AND q.year = ?2")
    public Page<Question> findBySubjectandYear(Subject subject, String year, Pageable pageable);

    @Query("SELECT DISTINCT q.year from Question q WHERE q.subject = ?1")
    public List<String> uniqueYearsBySubject(Subject subject);

}
