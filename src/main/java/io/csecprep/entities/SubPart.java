package io.csecprep.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_parts")
public class SubPart {

    @Id
    @SequenceGenerator(name = "sub_parts_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator = "sub_parts_seq")
    private Long id;

    private String prompt;

    private String correctAnswer;

    private QuestionTypes type;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public SubPart(Long id, String prompt, String correctAnswer, QuestionTypes type, Question question) {
        this.id = id;
        this.prompt = prompt;
        this.correctAnswer = correctAnswer;
        this.type = type;
        this.question = question;
    }

    public SubPart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public QuestionTypes getType() {
        return type;
    }

    public void setType(QuestionTypes type) {
        this.type = type;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
