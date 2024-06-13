package io.cxcprep.entities;

import jakarta.persistence.*;
import org.springframework.lang.Nullable;

import java.util.List;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String prompt;

    private String subject;

    @Enumerated(EnumType.STRING)
    private QuestionTypes type;

    private List<String> subPrompts;

    @OneToMany( mappedBy = "question")
    private List<Answer> answers;

    @OneToMany(mappedBy = "question")
    private List<Response> responses;

    public Question(Integer id, String prompt, String subject, QuestionTypes type, List<String> subPrompts, List<Answer> answers, List<Response> responses) {
        this.id = id;
        this.prompt = prompt;
        this.subject = subject;
        this.type = type;
        this.subPrompts = subPrompts;
        this.answers = answers;
        this.responses = responses;
    }

    public Question(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public QuestionTypes getType() {
        return type;
    }

    public void setType(QuestionTypes type) {
        this.type = type;
    }

    public List<String> getSubPrompts() {
        return subPrompts;
    }

    public void setSubPrompts(List<String> subPrompts) {
        this.subPrompts = subPrompts;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }
}
