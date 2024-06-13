package io.cxcprep.entities;

public enum QuestionTypes {
    MULTIPLECHOICE("multiplechoice"),
    MULTIPART("multipart"),
    SINGLEVALUE("singlevalue");

    private final String type;

    QuestionTypes(String type) {
        this.type =  type;
    }

    public String getType(){
        return type;
    }
}
