package com.example.myapplication;
public class Question {
    private String content;
    private String hint;
    private boolean correctAnswer;
    private boolean isAnswerCorrect;

    public Question(String content, String hint, boolean correctAnswer) {
        this.content = content;
        this.hint = hint;
        this.correctAnswer = correctAnswer;
        isAnswerCorrect = false;
    }

    public void setisAnswerCorrect() {
        this.isAnswerCorrect = true;
    }

    public String getcontent() {
        return content;
    }

    public String gethint() {
        return hint;
    }

    public boolean iscorrectAnswer() {
        return correctAnswer;
    }

    public boolean isisAnswerCorrect() {
        return isAnswerCorrect;
    }
}
