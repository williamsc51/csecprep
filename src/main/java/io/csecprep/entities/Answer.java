package io.csecprep.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @SequenceGenerator(name = "answers_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator = "answers_seq")
    private Long id;

    private String value;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn( name = "user_id" )
    private User user;

    public Answer(Long id, String value, Boolean isCorrect, Question question, User user) {
        this.id = id;
        this.value = value;
        this.question = question;
        this.user = user;
    }

    public Answer(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
