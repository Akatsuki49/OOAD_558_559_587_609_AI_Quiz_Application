package com.example.demo.controllers;

public class MediumQuestionGenerator implements QuestionGenerator {
    @Override
    public String generateQuestions() {
        // Implement medium question generation logic here
        return "Create 5 highly challenging , accurate multiple-choice questions in the style of Millionaire show, with 4 options with only 1 correct option that belongs to the options.Return an array of JSON objects, each containing the fields: 'question', 'options' list, and 'correct_answer' as the keys. The answers should be verifiable, factual and without misinformation.";
    }
}
