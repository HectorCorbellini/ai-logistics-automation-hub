package com.example.apibridge.dto;

@io.swagger.v3.oas.annotations.media.Schema(description = "Request body for AI extraction containing raw text")
public class ExtractionRequest {
    @io.swagger.v3.oas.annotations.media.Schema(description = "Raw text to be processed by the AI", example = "Invoice #1 from Acme Corp dated 2023-01-01 for $500.00")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
