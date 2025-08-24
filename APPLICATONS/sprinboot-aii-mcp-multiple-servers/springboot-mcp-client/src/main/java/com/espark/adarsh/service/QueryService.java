package com.espark.adarsh.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

    private final ChatClient chatClient;

    public QueryService(ChatClient.Builder chatClientBuilder, ToolCallbackProvider tools) {

        this.chatClient = chatClientBuilder
                .defaultSystem("Please prioritise context information for answering questions")
                .defaultToolCallbacks(tools)
                .build();
    }


    public String chat(String query) {
        PromptTemplate promptTemplate = new PromptTemplate(query);
        Prompt prompt = promptTemplate.create();
        ChatClient.CallResponseSpec res = chatClient.prompt(prompt).call();
        return res.content();
    }
}