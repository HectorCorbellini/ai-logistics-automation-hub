package com.example.apibridge.service;

import com.example.apibridge.dto.AIResponse;
import com.example.apibridge.dto.ExtractionRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AIServiceIntegrationTest {

    @Autowired
    private AIService aiService;

    @Test
    public void testExtractData() {
        ExtractionRequest request = new ExtractionRequest();
        request.setText("Invoice from ACME Corp for $123.45 on 2023-01-01");

        AIResponse response = aiService.extractData(request);

        assertNotNull(response);
        assertEquals("ACME Corp", response.getCompanyName());
        assertEquals("2023-01-01", response.getDate());
        assertEquals(123.45, response.getTotalAmount());
    }
}
