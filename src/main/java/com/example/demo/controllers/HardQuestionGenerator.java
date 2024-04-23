package com.example.demo.controllers;

public class HardQuestionGenerator implements QuestionGenerator {
    @Override
    public String generateQuestions() {
        // Implement hard question generation logic here
        return "Create 5 extremely challenging, obscure,niche multiple-choice questions in the style of Millionaire show, each with four options and one correct answer that belongs to the options.Return an array of JSON objects , with fields: 'question', 'options' list, and 'correct_answer' as the keys. Questions must be based on factual, verifiable information that is not widely known.";
    }
}