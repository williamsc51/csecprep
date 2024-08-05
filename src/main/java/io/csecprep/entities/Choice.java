package io.csecprep.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "choices")
public class Choice{

    @Id
    @SequenceGenerator(name = "choices_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator = "choices_seq")
    private Long id;

    private String choiceText;

    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Choice(Long id, String choiceText, Boolean isCorrect, Question question) {
        this.id = id;
        this.choiceText = choiceText;
        this.isCorrect = isCorrect;
        this.question = question;
    }

    public Choice() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChoiceText(){
        return choiceText;
    }

    public void setChoiceText(String choiceText){
        this.choiceText = choiceText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

}
