package com.espark.adarsh.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;

@Slf4j
@Service
public class QueryService {

    private ChatClient chatClient;
    private ChatClient.Builder chatClientBuilder;
    private ToolCallbackProvider toolCallbackProvider;

    public QueryService(ChatClient.Builder chatClientBuilder, ToolCallbackProvider toolCallbackProvider) {
        this.chatClientBuilder = chatClientBuilder;
        this.toolCallbackProvider = toolCallbackProvider;
    }

    @PostConstruct
    public void init() {
        Arrays.asList(toolCallbackProvider.getToolCallbacks()).forEach(toolCallback -> {
            log.info("Tool Callback Name: {}", toolCallback.getToolDefinition().name());
            log.info("Tool Callback Description: {}", toolCallback.getToolDefinition().description());
        });
        this.chatClient = chatClientBuilder
                .defaultSystem("Please prioritise context information for answering questions")
                .defaultToolCallbacks(toolCallbackProvider)
                .build();
    }


    public String chat(String query) {
        PromptTemplate promptTemplate = new PromptTemplate(query);
        Prompt prompt = promptTemplate.create();
        ChatClient.CallResponseSpec res = chatClient.prompt(prompt).call();
        return res.content();
    }
}