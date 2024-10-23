package com.example.quiz;

public class Question {
    private String content;
    private String hint;
    public String a1;
    public String a2;
    public String a3;
    public String a4;
    private int correctAnswer;
    private int isAnswerCorrect;

    public Question(String content, String hint, String a1, String a2, String a3, String a4, int correctAnswer) {
        this.content = content;
        this.hint = hint;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.correctAnswer = correctAnswer;
        isAnswerCorrect = 0;
    }

    public void setIsAnswerCorrect() {
        this.isAnswerCorrect = correctAnswer;
    }

    public String getContent() {
        return content;
    }
    public String getContentAndHint() {
        String newContent = content + '\n' + hint;
        return newContent;
    }

    public String getHint() {
        return hint;
    }

    public int isCorrectAnswer() {
        return correctAnswer;
    }

    public int isIsAnswerCorrect() {
        return isAnswerCorrect;
    }
}
