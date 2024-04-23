package com.example.demo.models;

import java.util.List;

public class QuizResult {
    private int totalCorrect;
    private List<QuestionResult> questionResults;

    public QuizResult(int totalCorrect, List<QuestionResult> questionResults) {
        this.totalCorrect = totalCorrect;
        this.questionResults = questionResults;
    }

    public int getTotalCorrect() {
        return totalCorrect;
    }

    public void setTotalCorrect(int totalCorrect) {
        this.totalCorrect = totalCorrect;
    }

    public List<QuestionResult> getQuestionResults() {
        return questionResults;
    }

    public void setQuestionResults(List<QuestionResult> questionResults) {
        this.questionResults = questionResults;
    }
}
