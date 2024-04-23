package com.example.demo.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.ChatGPTRequest;
import com.example.demo.models.ChatGPTResponse;
import com.example.demo.models.Message;
import com.example.demo.models.QuestionResult;
import com.example.demo.models.QuizResult;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FeedbackController {

    @PostMapping("/give_feedback")
    public String giveFeedback(@RequestBody QuizResult quizResult) {

        // Construct the query including information about the quiz result
        StringBuilder queryBuilder = new StringBuilder();
        // queryBuilder.append("According to the quiz results, here are some areas for
        // improvement give me a list:\n\n");
        queryBuilder.append(
                "According to the quiz results, here are some areas for improvement based on the questions answered right and wrong. Give a verbose answer in 2nd person speech and elaborate on areas of weakness in topics. Don't suggest improvements in a question if it was answered correctly. Praise the user if he does well in terms of total correct questions. Give me a list:\n\n");

        // Provide overall feedback based on total correct answers
        queryBuilder.append("Total correct answers: ").append(quizResult.getTotalCorrect()).append("\n");

        // Provide feedback for each question result
        for (QuestionResult questionResult : quizResult.getQuestionResults()) {
            queryBuilder.append("Question: ").append(questionResult.getQuestion()).append("\n");
            queryBuilder.append("Correct: ").append(questionResult.isCorrect() ? "Yes" : "No").append("\n\n");
        }

        String query = queryBuilder.toString();

        ChatGPTRequest req = new ChatGPTRequest();
        Message msg = new Message();
        msg.setContent(query);
        msg.setRole("system");

        List<Message> messages = new ArrayList<>();
        messages.add(msg);

        req.setMessages(messages);
        req.setModel("gpt-3.5-turbo");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();

        //added test comment.
        header.add("Authorization", "Bearer sk-proj-rj2BDsxu2LxR2A0bfcwST3BlbkFJg71k73iJ4Q43ESvbhrd3");

        HttpEntity<ChatGPTRequest> entity = new HttpEntity<>(req, header);
        ResponseEntity<ChatGPTResponse> resp = restTemplate.exchange("https://api.openai.com/v1/chat/completions",
                HttpMethod.POST, entity, ChatGPTResponse.class);

        return resp.getBody().getChoices().get(0).getMessage().getContent();
    }

}
