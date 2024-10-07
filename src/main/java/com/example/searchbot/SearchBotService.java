package com.example.searchbot;

import org.springframework.stereotype.Service;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;

@Service
public class SearchBotService {

    private final ChatClient chatClient;

    public SearchBotService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String getResponse(String question) {
        String message = """
                Answer the following user question accurately and concisely. Please avoid using markdown syntax.
                Question: %s
            """.formatted(question);
        PromptTemplate promptTemplate = new PromptTemplate(message);
        Prompt prompt = promptTemplate.create();
        return chatClient.call(prompt).getResult().getOutput().getContent();
    }
}