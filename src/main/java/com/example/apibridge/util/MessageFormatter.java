package com.example.apibridge.util;

import com.example.apibridge.dto.AIResponse;
import com.example.apibridge.dto.ExtractionResponse;

public class MessageFormatter {

    public static String formatExtraction(ExtractionResponse extraction) {
        return format(extraction.getCompanyName(), extraction.getDate(), extraction.getTotalAmount());
    }

    public static String formatAIExtraction(AIResponse aiResponse) {
        return format(aiResponse.getCompanyName(), aiResponse.getDate(), aiResponse.getTotalAmount());
    }

    private static String format(String company, String date, Double total) {
        return String.format("Company: %s\nDate: %s\nTotal: %s", company, date, total);
    }
}
