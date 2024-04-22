package com.example.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChatGPTController {
    @PostMapping("/generate_questions")
    public String getChatGPTResponse(@RequestBody String difficulty)
    {
        String query="";
        if(difficulty.equals("e"))
            query="Create 5 easy, accurate, and entertaining multiple-choice questions in the style of Millionaire show, with 4 options (A, B, C, and D) and 1 correct answer.Return an array of JSON objects, each containing the fields: 'question', 'A', 'B', 'C', 'D', and 'correct answer(A,B,C,D)'. The answers should be verifiable, factual and without misinformation.";
        else if(difficulty.equals("m"))
            query="Create 5 highly challenging , accurate multiple-choice questions in the style of Millionaire show, with 4 options (A, B, C, and D) with only 1 correct option.Return an array of JSON objects, each containing the fields: 'question', 'A', 'B', 'C', 'D', and 'correct answer(A,B,C,D)'. The answers should be verifiable, factual and without misinformation.";
        else
            query="Create 5 extremely challenging, obscure,niche multiple-choice questions in the style of Millionaire show, each with four options (A, B, C, and D) and one correct answer.Return an array of JSON objects , with fields: 'question', 'A', 'B', 'C', 'D', and 'correct answer(A,B,C,D)'.Questions must be based on factual, verifiable information that is not widely known.";

        ChatGPTRequest req = new ChatGPTRequest();
        Message msg = new Message();
        msg.setContent(query);
        msg.setRole("system");

        List<Message> messages = new ArrayList<Message>();
        messages.add(msg);

        req.setMessages(messages);
        req.setModel("gpt-3.5-turbo");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();

        header.add("Authorization", "Bearer sk-proj-rj2BDsxu2LxR2A0bfcwST3BlbkFJg71k73iJ4Q43ESvbhrd3");

        HttpEntity<ChatGPTRequest> entity = new HttpEntity<ChatGPTRequest>(req, header);
        ResponseEntity<ChatGPTResponse> resp = restTemplate.exchange("https://api.openai.com/v1/chat/completions", HttpMethod.POST, entity, ChatGPTResponse.class);

        return resp.getBody().getChoices().get(0).getMessage().getContent();
    }
}
