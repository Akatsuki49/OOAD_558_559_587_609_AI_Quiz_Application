package com.example.demo.controllers;

public class EasyQuestionGenerator implements QuestionGenerator {
    @Override
    public String generateQuestions() {
        // Implement easy question generation logic here
        return "Create 5 easy, accurate, and entertaining multiple-choice questions in the style of Millionaire show, with 4 options and 1 correct answer that belongs to the options .Return an array of JSON objects, each containing the fields: 'question', 'options' list, and 'correct_answer' as the keys. The answers should be verifiable, factual and without misinformation.";
    }
}
