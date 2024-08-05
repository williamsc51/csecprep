package io.csecprep.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @SequenceGenerator(name = "questions_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator = "questions_seq")
    private Long id;

    @ColumnDefault("true")
    private Boolean enabled;

    @Column(nullable = false)
    private String prompt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Subject subject;

    private String year;

    @Enumerated(EnumType.STRING)
    private QuestionTypes type;

    private String correctAnswer;

    private String imagePath;

    @OneToMany( mappedBy = "question")
    private List<Answer> answers;

    @OneToMany(mappedBy = "question")
    private List<Choice> choices;

    @OneToMany(mappedBy = "question")
    private List<SubPart> subParts;

    public Question(Long id, Boolean enabled, String prompt, Subject subject, String year, QuestionTypes type, String correctAnswer, String imagePath, List<SubPart> subParts, List<Answer> answers, List<Choice> choices) {
        this.id = id;
        this.enabled = enabled;
        this.prompt = prompt;
        this.subject = subject;
        this.year = year;
        this.type = type;
        this.correctAnswer = correctAnswer;
        this.imagePath = imagePath;
        this.subParts = subParts;
        this.answers = answers;
        this.choices = choices;
    }

    public Question(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Subject getSubject(){
        return subject;
    }

    public void setSubject(Subject subject){
        this.subject = subject;
    }

    public void setYear(String year){
        this.year = year;
    }

    public String getYear(){
        return year;
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

    public String getImage() {
        return imagePath;
    }

    public void setImage(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<SubPart> getSubParts() {
        return subParts;
    }

    public void setSubParts(List<SubPart> subParts) {
        this.subParts = subParts;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

}
