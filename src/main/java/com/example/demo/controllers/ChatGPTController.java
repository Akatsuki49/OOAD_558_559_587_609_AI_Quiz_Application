package com.example.demo.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.ChatGPTRequest;
import com.example.demo.models.ChatGPTResponse;
import com.example.demo.models.Message;

import org.springframework.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChatGPTController {
    private final QuestionGeneratorFactory questionGeneratorFactory;

    public ChatGPTController(QuestionGeneratorFactory questionGeneratorFactory) {
        this.questionGeneratorFactory = questionGeneratorFactory;
    }

    @PostMapping("/generate_questions")
    public String getChatGPTResponse(@RequestBody String difficulty) {
        String query = generateQuery(difficulty);

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
        header.add("Authorization", "Bearer sk-proj-rj2BDsxu2LxR2A0bfcwST3BlbkFJg71k73iJ4Q43ESvbhrd3");

        HttpEntity<ChatGPTRequest> entity = new HttpEntity<>(req, header);
        ResponseEntity<ChatGPTResponse> resp = restTemplate.exchange("https://api.openai.com/v1/chat/completions",
                HttpMethod.POST, entity, ChatGPTResponse.class);
        String jsonResponse = resp.getBody().getChoices().get(0).getMessage().getContent();
        String trimmedResponse = jsonResponse.substring(8, jsonResponse.length() - 4);
        return trimmedResponse;
    }

    private String generateQuery(String difficulty) {
//        System.out.println(difficulty);
        QuestionGenerator questionGenerator = questionGeneratorFactory.createGenerator(difficulty);
//        System.out.println(questionGenerator.generateQuestions());
        return questionGenerator.generateQuestions();
    }
}