package com.example.apibridge.service;

import com.example.apibridge.dto.AIResponse;
import com.example.apibridge.dto.ExtractionRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class AIService {

    private final String groqApiKey;
    private final String groqModel;
    private final String groqApiUrl;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public AIService(@Value("${groq.api.key}") String groqApiKey,
            @Value("${groq.model}") String groqModel,
            @Value("${groq.api.url}") String groqApiUrl) {
        this.groqApiKey = groqApiKey;
        this.groqModel = groqModel;
        this.groqApiUrl = groqApiUrl;
    }

    public AIResponse extractData(ExtractionRequest request) {
        String prompt = "Extract the company name, date, and total amount from the following text. Respond with a JSON object containing the fields 'companyName', 'date', and 'totalAmount'.\n\nText: "
                + request.getText();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(groqApiKey);

        ObjectNode requestBody = objectMapper.createObjectNode();
        requestBody.put("model", groqModel);

        ArrayNode messages = requestBody.putArray("messages");
        messages.addObject()
                .put("role", "system")
                .put("content",
                        "You are a helpful assistant that extracts information from text and returns it in JSON format.");
        messages.addObject()
                .put("role", "user")
                .put("content", prompt);

        HttpEntity<String> entity = new HttpEntity<>(requestBody.toString(), headers);

        String response = restTemplate.postForObject(groqApiUrl, entity, String.class);

        System.out.println("Raw AI Response: " + response);

        try {
            com.fasterxml.jackson.databind.JsonNode rootNode = objectMapper.readTree(response);
            String content = rootNode.path("choices").get(0).path("message").path("content").asText();

            // Strip Markdown code blocks if present
            if (content.startsWith("```json")) {
                content = content.substring(7);
            } else if (content.startsWith("```")) {
                content = content.substring(3);
            }
            if (content.endsWith("```")) {
                content = content.substring(0, content.length() - 3);
            }
            // Trim whitespace
            content = content.trim();

            return objectMapper.readValue(content, AIResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse AI response", e);
        }
    }
}
