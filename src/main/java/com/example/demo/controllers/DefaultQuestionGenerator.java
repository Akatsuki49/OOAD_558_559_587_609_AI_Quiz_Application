package com.example.demo.controllers;

public class DefaultQuestionGenerator implements QuestionGenerator {
    @Override
    public String generateQuestions() {
        // Implement default question generation logic here
        return "Default questions on random topics each of random difficulty must be generated";
    }
}
