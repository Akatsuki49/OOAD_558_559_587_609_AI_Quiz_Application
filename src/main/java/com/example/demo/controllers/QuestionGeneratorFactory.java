package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

@Component
public class QuestionGeneratorFactory {
    private final Map<String, QuestionGenerator> generators;

    public QuestionGeneratorFactory() {
        generators = new HashMap<>();
        generators.put("e", new EasyQuestionGenerator());
        generators.put("m", new MediumQuestionGenerator());
        generators.put("h", new HardQuestionGenerator());
    }
    public QuestionGenerator createGenerator(String json) {
        String difficulty = extractDifficultyFromJson(json);
        return generators.getOrDefault(difficulty, new DefaultQuestionGenerator());
    }

    private String extractDifficultyFromJson(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(json);
            return node.get("difficulty").asText();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle JSON parsing exception
            return ""; // or throw an exception
        }
    }

//    public QuestionGenerator createGenerator(String difficulty) {
//        System.out.println(difficulty);
//        return generators.getOrDefault(difficulty, new DefaultQuestionGenerator());
//    }
}

