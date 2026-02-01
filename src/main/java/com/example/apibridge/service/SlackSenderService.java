package com.example.apibridge.service;

import com.example.apibridge.dto.AIResponse;
import com.example.apibridge.dto.ExtractionResponse;
import com.example.apibridge.util.MessageFormatter;
import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SlackSenderService {
    private final String slackWebhookUrl;

    public SlackSenderService(@Value("${slack.webhook.url}") String slackWebhookUrl) {
        this.slackWebhookUrl = slackWebhookUrl;
    }

    public void sendExtractionToSlack(ExtractionResponse extraction) throws Exception {
        Slack slack = Slack.getInstance();
        String text = MessageFormatter.formatExtraction(extraction);
        Payload payload = Payload.builder().text(text).build();
        slack.send(slackWebhookUrl, payload);
    }

    public void sendAIExtractionToSlack(AIResponse aiResponse) throws Exception {
        Slack slack = Slack.getInstance();
        String text = MessageFormatter.formatAIExtraction(aiResponse);
        Payload payload = Payload.builder().text(text).build();
        slack.send(slackWebhookUrl, payload);
    }

}
