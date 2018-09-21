package com.example.lenovo.mvp_tao.bean;

public class Question {
    private String answer;
    private String id;
    private String question;

    @Override
    public String toString() {
        return "Question{" +
                "answer='" + answer + '\'' +
                ", id='" + id + '\'' +
                ", question='" + question + '\'' +
                '}';
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
