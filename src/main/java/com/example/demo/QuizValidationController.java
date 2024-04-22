package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuizValidationController {
    @PostMapping("/validate_answers")
    public QuizResult validateAnswers(@RequestBody QuizAnswers quizAnswers) {
        List<QuestionAnswerOpt> questionAnswers = quizAnswers.getQuestionAnswers();
        int totalCorrect = 0;
        List<QuestionResult> questionResults = new ArrayList<>();

        for (QuestionAnswerOpt qa : questionAnswers) {
            boolean isCorrect = qa.getChosenAnswer().equalsIgnoreCase(qa.getCorrectAnswer());
            if (isCorrect) {
                totalCorrect++;
            }
            questionResults.add(new QuestionResult(qa.getQuestion(), qa.getCorrectAnswer(), isCorrect));
        }

        return new QuizResult(totalCorrect, questionResults);
    }
}
